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