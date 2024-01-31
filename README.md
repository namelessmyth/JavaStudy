# 项目说明
- 本项目是知识库项目的配套代码。主要收录和知识库相关的以及Java学习和实践中的所有代码。
- 每一个目录模块的说明如下



## 公共依赖

这里列出的是公共父项目下的依赖，子项目不再重复引入。

- lombok
- 日志打印，slf4j，log4j2
- Hutool-all
- 单元测试，Junit5



## 目录结构说明

```bat
目录结构
├─JavaStudy                # 顶层父项目，公共依赖
│  ├─DesignPattern         # 设计模式
│  ├─algorithm             # 算法，包含leetcode题解
│  ├─TankBattle            # 坦克大战设计模式版，Netty版
│  ├─MQ                    # 消息中间件-父项目
│  │  ├─karfka_mq          # karfka独立
│  │  ├─karfka_spring      # karfka集成Spring
│  │  ├─RocketMQ           # RocketMQ独立
│  │  ├─RocketMQ_spring    # RocketMQ集成Spring
│  ├─SpringCloudAlibaba    # 微服务父项目
│  │  ├─nacos-consumer     # nacos客户端
│  │  ├─nacos-provider     # nacos服务端
│  │  ├─gateway-LoadBalance# gateway负载均衡
│  │  ├─sentinel-persist   # sentinel降级熔断
│  │  ├─feign-consumer     # feign服务调用
│  ├─SpringBoot            # SpringBoot-父项目
│  │  ├─springboot-source  # SpringBoot源码分析
│  │  ├─springboot-cache   # SpringBoot集成缓存
│  │  ├─springboot-thread  # SpringBoot集成多线程
│  │  ├─springboot-actuator# SpringBoot监控
│  ├─j2se                  # J2SE项目
│  │  ├─JVM                # JVM底层研究
│  │  ├─thread             # 多线程并发编程
│  │  ├─sentinel-persist   # sentinel降级熔断
│  ├─db                    # Java连接数据库
│  │  ├─MongoDb            # Java操作MongoDB
```
