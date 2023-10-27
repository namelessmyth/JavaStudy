package com.gem.db.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.ClientSession;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;


public class MongoClientTest {
    //数据库
    private MongoDatabase db;
    //文档集合
    private MongoCollection<Document> doc;
    //连接客户端（内置连接池）
    private MongoClient client;

    @BeforeEach
    public void init() {
        client = new MongoClient("docker-study", 27017);
        db = client.getDatabase("test");
        doc = db.getCollection("collection1");
    }

    @Test
    public void insertOne() {
        Document doc1 = new Document();
        doc1.append("username", "gem");
        doc1.append("country", "China");
        doc1.append("age", 36);
        doc1.append("lenght", 178.75f);
        doc1.append("salary", new BigDecimal("16565.22"));//存金额，使用bigdecimal这个数据类型
        Map<String, String> address1 = new HashMap<String, String>();       //添加“address”子文档
        address1.put("aCode", "0000");
        address1.put("add", "xxx000");
        doc1.append("address", address1);
        Map<String, Object> favorites1 = new HashMap<String, Object>();        //添加“favorites”子文档，其中两个属性是数组
        favorites1.put("movies", Arrays.asList("爱死机", "光环"));
        favorites1.put("cites", Arrays.asList("北京", "南京"));
        doc1.append("favorites", favorites1);

        //使用insertMany插入多条数据
        doc.insertOne(doc1);
    }

    //三条数据
    @Test
    public void insertDemo() {
        Document doc1 = new Document();
        doc1.append("username", "lijin");
        doc1.append("country", "China");
        doc1.append("age", 36);
        doc1.append("lenght", 178.75f);
        doc1.append("salary", new BigDecimal("16565.22"));//存金额，使用bigdecimal这个数据类型
        Map<String, String> address1 = new HashMap<String, String>();       //添加“address”子文档
        address1.put("aCode", "0000");
        address1.put("add", "xxx000");
        doc1.append("address", address1);
        Map<String, Object> favorites1 = new HashMap<String, Object>();        //添加“favorites”子文档，其中两个属性是数组
        favorites1.put("movies", Arrays.asList("爱死机", "光环"));
        favorites1.put("cites", Arrays.asList("北京", "南京"));
        doc1.append("favorites", favorites1);

        Document doc2 = new Document();
        doc2.append("username", "yan");
        doc2.append("country", "China");
        doc2.append("age", 30);
        doc2.append("lenght", 185.75f);
        doc2.append("salary", new BigDecimal("38888.22"));
        Map<String, String> address2 = new HashMap<>();
        address2.put("aCode", "411000");
        address2.put("add", "我的地址2");
        doc2.append("address", address2);
        Map<String, Object> favorites2 = new HashMap<>();
        favorites2.put("movies", Arrays.asList("西游记", "东游记"));
        favorites2.put("cites", Arrays.asList("西藏", "三亚"));
        doc2.append("favorites", favorites2);

        Document doc3 = new Document();
        doc3.append("username", "mic");
        doc3.append("country", "USA");
        doc3.append("age", 60);
        doc3.append("lenght", 180.75f);
        doc3.append("salary", new BigDecimal("3008888.22"));
        Map<String, String> address3 = new HashMap<>();
        address3.put("aCode", "411000");
        address3.put("add", "我的地址2");
        doc3.append("address", address3);
        Map<String, Object> favorites3 = new HashMap<>();
        favorites3.put("movies", Arrays.asList("卓别林", "牛顿的棺材板"));
        favorites3.put("cites", Arrays.asList("纽约", "洛杉矶"));
        doc3.append("favorites", favorites3);

        //使用insertMany插入多条数据
        doc.insertMany(Arrays.asList(doc1, doc2, doc3));
    }

    //查询出文档集合中所有记录  select * from  table
    @Test
    public void testFindAll() {
        Consumer<Document> printDocument = new Consumer<Document>() {
            @Override
            public void accept(Document document) {
                System.out.println(document);
            }
        };
        FindIterable<Document> find = doc.find();
        find.forEach(printDocument);
    }

    //查询出文档集合中的记录（过滤2）
    @Test
    public void testFindFilter2() {
        //block接口专门用于处理查询出来的数据
        Consumer<Document> printDocument = new Consumer<Document>() {
            @Override
            public void accept(Document document) {
                System.out.println(document);
            }
        };
        //定义数据过滤器，country like '%ina%'  and ( contry= 北京 or contry = USA)
        String regexStr = ".*ina.*";
        Bson regex = regex("country", regexStr);
        Bson or = or(eq("favorites.cites", "北京"), eq("favorites.cites", "纽约"));
        Bson and = and(regex, or);
        FindIterable<Document> find = doc.find(and);
        find.forEach(printDocument);
    }

    @Test
    public void testUpdate1() {
        Bson eq = eq("username", "lijin");//定义数据过滤器，username = 'cang'
        Bson set = set("age", 18);//更新的字段.来自于Updates包的静态导入
        UpdateResult updateMany = doc.updateMany(eq, set);
        //打印受影响的行数
        System.out.println("------------------>" + String.valueOf(updateMany.getModifiedCount()));

        Bson eq2 = eq("username", "yan");//定义数据过滤器，favorites.cites  has "东莞"

        Bson addEachToSet = addEachToSet("favorites.movies", Arrays.asList("小电影1 ", "小电影2"));
        UpdateResult updateMany2 = doc.updateMany(eq2, addEachToSet);
        System.out.println("------------------>" + String.valueOf(updateMany2.getModifiedCount()));
    }

    @Test
    public void testDelete() {

        Bson eq = eq("username", "yan");//定义数据过滤器，username='yan'
        DeleteResult deleteMany = doc.deleteMany(eq);
        System.out.println("------------------>" + String.valueOf(deleteMany.getDeletedCount()));//打印受影响的行数

        //定义数据过滤器，age > 50，所有过滤器的定义来自于Filter这个包的静态方法，需要频繁使用所以静态导入
        Bson gt = gt("age", 50);
        //定义数据过滤器，age < 100
        Bson lt = lt("age", 100);
        Bson and = and(gt, lt);//定义数据过滤器，将条件用and拼接
        DeleteResult deleteMany2 = doc.deleteMany(and);
        System.out.println("------------------>" + String.valueOf(deleteMany2.getDeletedCount()));//打印受影响的行数
    }


    @Test
    public void testTransaction() {
//		begin
//		update  users  set lenght= lenght-1  where username = ‘james’
//		update  users  set lenght= lenght+1  where username = ‘lison’
//		commit
        ClientSession clientSession = client.startSession();
        clientSession.startTransaction();
        Bson eq = eq("username", "james");
        Bson inc = inc("lenght", -1);
        doc.updateOne(clientSession, eq, inc);

        Bson eq2 = eq("username", "lison");
        Bson inc2 = inc("lenght", 1);

        doc.updateOne(clientSession, eq2, inc2);

        clientSession.commitTransaction();
        // clientSession.abortTransaction();

    }
}