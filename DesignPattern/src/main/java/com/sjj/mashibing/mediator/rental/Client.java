package com.sjj.mashibing.mediator.rental;

public class Client {
    public static void main(String[] args) {
        //一个房主 一个租房者 一个中介机构
        MediatorStructure mediator = new MediatorStructure();
        //房主和租房者只需要知道中介机构即可
        HouseOwner houseOwner = new HouseOwner("路飞", mediator);
        Tenant tenant = new Tenant("娜美", mediator);
        //中介收集房租和租房者信息
        mediator.setHouseOwner(houseOwner);
        mediator.setTenant(tenant);

        tenant.contact("需要一个两室一厅的房子,一家人住");
        houseOwner.contact("出租一套两室一厅带电梯,月租5000");
    }
}
