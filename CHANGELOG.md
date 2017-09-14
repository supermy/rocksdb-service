###2017-09-14

    9000 与 9008 不可共存；
    

###2017-08-23

    没时间啊，没时间
    准备实现时序数据库；
    准备实现 Redis 数据类型支撑；
    
        
###2017-06-02

    学习 java8 de lambda语法；
    mvn dependency:tree
    
    ratpack->io.netty->akka
    
    [INFO] ------------------------------------------------------------------------
    [INFO] Building rocksdb-service 0.1.0
    [INFO] ------------------------------------------------------------------------
    [INFO] 
    [INFO] --- maven-dependency-plugin:2.10:tree (default-cli) @ rocksdb-service ---
    [INFO] org.supermy:rocksdb-service:jar:0.1.0
    [INFO] +- org.apache.commons:commons-lang3:jar:3.0:compile
    
    [INFO] +- io.ratpack:ratpack-spring-boot:jar:1.4.6:compile
    [INFO] |  +- io.ratpack:ratpack-core:jar:1.4.6:compile
    [INFO] |  |  +- io.netty:netty-codec-http:jar:4.1.6.Final:compile
    [INFO] |  |  |  \- io.netty:netty-codec:jar:4.1.6.Final:compile
    [INFO] |  |  +- io.netty:netty-handler:jar:4.1.6.Final:compile
    [INFO] |  |  |  +- io.netty:netty-buffer:jar:4.1.6.Final:compile
    [INFO] |  |  |  \- io.netty:netty-transport:jar:4.1.6.Final:compile
    [INFO] |  |  |     \- io.netty:netty-resolver:jar:4.1.6.Final:compile
    [INFO] |  |  +- io.netty:netty-transport-native-epoll:jar:linux-x86_64:4.1.6.Final:compile
    [INFO] |  |  |  \- io.netty:netty-common:jar:4.1.6.Final:compile
    [INFO] |  |  +- com.google.guava:guava:jar:19.0:compile
    [INFO] |  |  +- org.slf4j:slf4j-api:jar:1.7.25:compile
    [INFO] |  |  +- org.reactivestreams:reactive-streams:jar:1.0.0.final:compile
    [INFO] |  |  +- com.github.ben-manes.caffeine:caffeine:jar:2.3.5:compile
    [INFO] |  |  +- org.javassist:javassist:jar:3.21.0-GA:compile
    [INFO] |  |  +- com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:jar:2.8.8:compile
    [INFO] |  |  +- com.fasterxml.jackson.datatype:jackson-datatype-guava:jar:2.8.8:compile
    [INFO] |  |  +- org.yaml:snakeyaml:jar:1.17:compile
    [INFO] |  |  +- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:jar:2.8.8:compile
    [INFO] |  |  \- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.8.8:compile
    [INFO] |  +- io.ratpack:ratpack-guice:jar:1.4.6:compile
    [INFO] |  |  +- com.google.inject:guice:jar:4.1.0:compile
    [INFO] |  |  |  +- javax.inject:javax.inject:jar:1:compile
    [INFO] |  |  |  \- aopalliance:aopalliance:jar:1.0:compile
    [INFO] |  |  \- com.google.inject.extensions:guice-multibindings:jar:4.1.0:compile
    [INFO] |  \- org.springframework.boot:spring-boot-autoconfigure:jar:1.5.3.RELEASE:compile
    [INFO] |     \- org.springframework.boot:spring-boot:jar:1.5.3.RELEASE:compile
    
    
    [INFO] +- org.rocksdb:rocksdbjni:jar:5.2.1:compile
    [INFO] +- com.google.code.gson:gson:jar:2.8.0:compile
    [INFO] +- org.springframework.boot:spring-boot-starter-web:jar:1.5.3.RELEASE:compile
    [INFO] |  +- org.springframework.boot:spring-boot-starter:jar:1.5.3.RELEASE:compile
    [INFO] |  |  \- org.springframework.boot:spring-boot-starter-logging:jar:1.5.3.RELEASE:compile
    [INFO] |  |     +- ch.qos.logback:logback-classic:jar:1.1.11:compile
    [INFO] |  |     |  \- ch.qos.logback:logback-core:jar:1.1.11:compile
    [INFO] |  |     +- org.slf4j:jcl-over-slf4j:jar:1.7.25:compile
    [INFO] |  |     +- org.slf4j:jul-to-slf4j:jar:1.7.25:compile
    [INFO] |  |     \- org.slf4j:log4j-over-slf4j:jar:1.7.25:compile
    [INFO] |  +- org.springframework.boot:spring-boot-starter-tomcat:jar:1.5.3.RELEASE:compile
    [INFO] |  |  +- org.apache.tomcat.embed:tomcat-embed-core:jar:8.5.14:compile
    [INFO] |  |  +- org.apache.tomcat.embed:tomcat-embed-el:jar:8.5.14:compile
    [INFO] |  |  \- org.apache.tomcat.embed:tomcat-embed-websocket:jar:8.5.14:compile
    [INFO] |  +- org.hibernate:hibernate-validator:jar:5.3.5.Final:compile
    [INFO] |  |  +- javax.validation:validation-api:jar:1.1.0.Final:compile
    [INFO] |  |  +- org.jboss.logging:jboss-logging:jar:3.3.1.Final:compile
    [INFO] |  |  \- com.fasterxml:classmate:jar:1.3.3:compile
    [INFO] |  +- com.fasterxml.jackson.core:jackson-databind:jar:2.8.8:compile
    [INFO] |  |  +- com.fasterxml.jackson.core:jackson-annotations:jar:2.8.0:compile
    [INFO] |  |  \- com.fasterxml.jackson.core:jackson-core:jar:2.8.8:compile
    [INFO] |  +- org.springframework:spring-web:jar:4.3.8.RELEASE:compile
    [INFO] |  |  +- org.springframework:spring-aop:jar:4.3.8.RELEASE:compile
    [INFO] |  |  +- org.springframework:spring-beans:jar:4.3.8.RELEASE:compile
    [INFO] |  |  \- org.springframework:spring-context:jar:4.3.8.RELEASE:compile
    [INFO] |  \- org.springframework:spring-webmvc:jar:4.3.8.RELEASE:compile
    [INFO] |     \- org.springframework:spring-expression:jar:4.3.8.RELEASE:compile
    
    
    [INFO] +- org.springframework.boot:spring-boot-starter-actuator:jar:1.5.3.RELEASE:compile
    [INFO] |  \- org.springframework.boot:spring-boot-actuator:jar:1.5.3.RELEASE:compile
    
    [INFO] \- org.springframework.boot:spring-boot-starter-test:jar:1.5.3.RELEASE:test
    [INFO]    +- org.springframework.boot:spring-boot-test:jar:1.5.3.RELEASE:test
    [INFO]    +- org.springframework.boot:spring-boot-test-autoconfigure:jar:1.5.3.RELEASE:test
    [INFO]    +- com.jayway.jsonpath:json-path:jar:2.2.0:test
    [INFO]    |  \- net.minidev:json-smart:jar:2.2.1:test
    [INFO]    |     \- net.minidev:accessors-smart:jar:1.1:test
    [INFO]    |        \- org.ow2.asm:asm:jar:5.0.3:test
    [INFO]    +- junit:junit:jar:4.12:test
    [INFO]    +- org.assertj:assertj-core:jar:2.6.0:test
    [INFO]    +- org.mockito:mockito-core:jar:1.10.19:test
    [INFO]    |  \- org.objenesis:objenesis:jar:2.1:test
    [INFO]    +- org.hamcrest:hamcrest-core:jar:1.3:test
    [INFO]    +- org.hamcrest:hamcrest-library:jar:1.3:test
    [INFO]    +- org.skyscreamer:jsonassert:jar:1.4.0:test
    [INFO]    |  \- com.vaadin.external.google:android-json:jar:0.0.20131108.vaadin1:test
    [INFO]    +- org.springframework:spring-core:jar:4.3.8.RELEASE:compile
    [INFO]    \- org.springframework:spring-test:jar:4.3.8.RELEASE:test
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    
    
###2017-05-26
     
     db数据清除指令；提供批量删除的指令；
     db数据备份指令；完成系列 api
         
###2017-05-25

    静态资源处理
    管理首页  http://127.0.0.1:9000/
        
###2017-05-24

    采用简单策略；json 数据类型支持，默认为 json 数据格式；
    通过 json 数据类型支持 Hash 类型；
    一个实例一个数据表；
    
    restful 支持 json
    http://127.0.0.1:9008/api/mydb/abc
    
    get http://127.0.0.1:9008/api/mydb/a
    put http://127.0.0.1:9008/api/mydb/abc {"a"=12,"b"=c}
    del http://127.0.0.1:9008/api/mydb/abc
    
    get http://127.0.0.1:9008/api/mydb?pre=ab  根据前缀查询 key
    post    http://127.0.0.1:9008/api/mydb/  {a:{"a":1},b:{b:1}}
    
    

###2017-05-23
        
    数据路径通过配置文件加载；
    使用外部配置文件
        java -jar rocksdb-service-0.1.0.jar --spring.config.location=location_of_your_config_file.properties
    使用Profile区分环境
        @Service
        @Profile("dev")
        class DevEmailService implements EmailService {
        
            public void send(String email) {
                //Do Nothing
            }
        }
        
        @Service
        @Profile("prod")
        class ProdEmailService implements EmailService {
        
            public void send(String email) {
                //Real Email Service Logic
            }
        }
        
        @Profile("dev")表明只有Spring定义的Profile为dev时才会实例化DevEmailService这个类。那么如何设置Profile呢？
        在application.properties中加入：
            spring.profiles.active=dev
        通过命令行参数
            java -jar app.jar --spring.profiles.active=dev
        
    
###2017-05-22
    nginx+lua 实现集群与鉴权
    数据库状况监控
    http://127.0.0.1:9000/rocksdb/status
    
    restful 获取一个 key 的 value
    http://127.0.0.1:9008/api/mydb/ab
    
    get http://127.0.0.1:9008/api/mydb/ab
    put  body=  http://127.0.0.1:9008/api/mydb/ab
    delete http://127.0.0.1:9008/api/mydb/ab

###2017-05-20
    RatPack 可用于高性能的 API 封装（如果没有合适的 lua 库的情况下）
    引入 RatPack 进行性能优化，比原生的 SpringBoot 快三倍；
    基于 SpringBoot 嵌入式启动 RatPack;
    编写基于 Ratpack 的 api;
    
    
###2017-05-18
    主要的性能方面的优化配置；
    
###2017-05-18
    RocksjavaTest 测试 OK

    API
    http://127.0.0.1:9000/hello-world?name=abc
    
    健康监测
    http://localhost:9001/health
    
    存储一个数据
    http://127.0.0.1:9000/rocksdb/set?key=ab&value=%E4%B8%AD%E6%96%87
    获取一个数据
    http://127.0.0.1:9000/rocksdb/get?key=ab