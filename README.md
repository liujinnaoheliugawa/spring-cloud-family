# Spring Cloud 生态搭建

## 目的



一键生成 CMS 项目中的 Service 层，Controller 层，CMS CURD 页面以及 JS 文件。

插件使用样例项目请参考 simple-cms-generator-project-example 项目



## 项目组件用途

### Eureka Server

服务发现中心，Config Server/Feign/Sleuth/Zuul 都将注册在其上



### Config Server

动态配置中心，动态配置更新基于 Git 实现动态变动，zuul 的配置文件放在其上



### Feign

业务逻辑 Service + Provider + Controller （类似于单机 Springboot 的某个服务），配合 Hystrix 做服务熔断，配合 JPA 做数据持久化



### Zuul

网关，负责转发，配合 Feign 使用可以转发到 Controller 或者直接到 Service



### Zipkin

配合 Zookeeper + Kafka 监听收集服务之间的调用信息



### Sleuth

客户端应用调用方，配合 @LoadBalance 做服务端负载均衡



## 项目结构图

![项目结构图](https://github.com/liujinnaoheliugawa/spring-cloud-family/blob/master/resources/Zuul%20整合.jpg)
