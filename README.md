# dubbo-spring-boot-mybatis-redis

项目介绍：重构齐材电商·商品管理项目

1、首先安装zookeeper+redis；

2、product-data-provider服务提供者项目的资源文件dubbo-spring-mybatis.xml下配置zookeeper地址；

3、product-openapi服务消费者的资源文件dubbo-services.xml下配置zookeeper地址，然后在application.properties下配置redis地址；

4、product-security服务消费者的资源文件dubbo-services.xml下配置zookeeper地址；

5、启动product-data-provider项目下的mainloader注册服务提供者；

6、启动product-openapi项目下的App注册服务消费者；

7、整个项目即可完整运行。
