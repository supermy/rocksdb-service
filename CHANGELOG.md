2017-05-23
    todo  Hash 类型支持
    
2017-05-22
    nginx+lua 实现集群与鉴权
    数据库状况监控
    http://127.0.0.1:9000/rocksdb/status
    
    restful 获取一个 key 的 value
    http://127.0.0.1:9008/api/mydb/ab
    
    get http://127.0.0.1:9008/api/mydb/ab
    put  body=  http://127.0.0.1:9008/api/mydb/ab
    delete http://127.0.0.1:9008/api/mydb/ab
2017-05-20
    RatPack 可用于高性能的 API 封装（如果没有合适的 lua 库的情况下）
    引入 RatPack 进行性能优化，比原生的 SpringBoot 快三倍；
    基于 SpringBoot 嵌入式启动 RatPack;
    编写基于 Ratpack 的 api;
    
    
2017-05-18
    主要的性能方面的优化配置；
    
2017-05-18
    RocksjavaTest 测试 OK

    API
    http://127.0.0.1:9000/hello-world?name=abc
    
    健康监测
    http://localhost:9001/health
    
    存储一个数据
    http://127.0.0.1:9000/rocksdb/set?key=ab&value=%E4%B8%AD%E6%96%87
    获取一个数据
    http://127.0.0.1:9000/rocksdb/get?key=ab