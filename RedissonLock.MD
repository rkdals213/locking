```
2023-12-14T22:53:42.852+09:00 DEBUG 76419 --- [    Test worker] org.hibernate.SQL                        : 
    insert 
    into
        some_data_table
        (data) 
    values
        (?)
2023-12-14T22:53:42.858+09:00 TRACE 76419 --- [    Test worker] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Test Data]
Update Data 0 lock 획득 성공
2023-12-14T22:53:42.950+09:00 DEBUG 76419 --- [pool-2-thread-1] org.hibernate.SQL                        : 
    select
        sdt1_0.id,
        sdt1_0.data 
    from
        some_data_table sdt1_0 
    where
        sdt1_0.id=?
2023-12-14T22:53:42.950+09:00 TRACE 76419 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (1:BIGINT) <- [1]
SomeDataTable(id=1, data='Test Data')
2023-12-14T22:53:45.973+09:00 DEBUG 76419 --- [pool-2-thread-1] org.hibernate.SQL                        : 
    update
        some_data_table 
    set
        data=? 
    where
        id=?
2023-12-14T22:53:45.974+09:00 TRACE 76419 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Update Data 0]
2023-12-14T22:53:45.974+09:00 TRACE 76419 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (2:BIGINT) <- [1]
Update Data 0 lock 해제
Update Data 1 lock 획득 성공
2023-12-14T22:53:46.006+09:00 DEBUG 76419 --- [pool-2-thread-2] org.hibernate.SQL                        : 
    select
        sdt1_0.id,
        sdt1_0.data 
    from
        some_data_table sdt1_0 
    where
        sdt1_0.id=?
2023-12-14T22:53:46.007+09:00 TRACE 76419 --- [pool-2-thread-2] org.hibernate.orm.jdbc.bind              : binding parameter (1:BIGINT) <- [1]
SomeDataTable(id=1, data='Update Data 0')
2023-12-14T22:53:49.016+09:00 DEBUG 76419 --- [pool-2-thread-2] org.hibernate.SQL                        : 
    update
        some_data_table 
    set
        data=? 
    where
        id=?
2023-12-14T22:53:49.018+09:00 TRACE 76419 --- [pool-2-thread-2] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Update Data 1]
2023-12-14T22:53:49.019+09:00 TRACE 76419 --- [pool-2-thread-2] org.hibernate.orm.jdbc.bind              : binding parameter (2:BIGINT) <- [1]
Update Data 1 lock 해제
Update Data 5 lock 획득 성공
2023-12-14T22:53:49.047+09:00 DEBUG 76419 --- [pool-2-thread-1] org.hibernate.SQL                        : 
    select
        sdt1_0.id,
        sdt1_0.data 
    from
        some_data_table sdt1_0 
    where
        sdt1_0.id=?
2023-12-14T22:53:49.047+09:00 TRACE 76419 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (1:BIGINT) <- [1]
SomeDataTable(id=1, data='Update Data 1')
2023-12-14T22:53:52.056+09:00 DEBUG 76419 --- [pool-2-thread-1] org.hibernate.SQL                        : 
    update
        some_data_table 
    set
        data=? 
    where
        id=?
2023-12-14T22:53:52.058+09:00 TRACE 76419 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Update Data 5]
2023-12-14T22:53:52.058+09:00 TRACE 76419 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (2:BIGINT) <- [1]
Update Data 5 lock 해제
Update Data 6 lock 획득 성공
2023-12-14T22:53:52.094+09:00 DEBUG 76419 --- [pool-2-thread-2] org.hibernate.SQL                        : 
    select
        sdt1_0.id,
        sdt1_0.data 
    from
        some_data_table sdt1_0 
    where
        sdt1_0.id=?
2023-12-14T22:53:52.094+09:00 TRACE 76419 --- [pool-2-thread-2] org.hibernate.orm.jdbc.bind              : binding parameter (1:BIGINT) <- [1]
SomeDataTable(id=1, data='Update Data 5')
Update Data 3 lock 획득 실패
Update Data 2 lock 획득 실패
Update Data 4 lock 획득 실패
2023-12-14T22:53:55.102+09:00 DEBUG 76419 --- [pool-2-thread-2] org.hibernate.SQL                        : 
    update
        some_data_table 
    set
        data=? 
    where
        id=?
2023-12-14T22:53:55.102+09:00 TRACE 76419 --- [pool-2-thread-2] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Update Data 6]
2023-12-14T22:53:55.103+09:00 TRACE 76419 --- [pool-2-thread-2] org.hibernate.orm.jdbc.bind              : binding parameter (2:BIGINT) <- [1]
Update Data 6 lock 해제
Update Data 7 lock 획득 성공
2023-12-14T22:53:55.149+09:00 DEBUG 76419 --- [pool-2-thread-1] org.hibernate.SQL                        : 
    select
        sdt1_0.id,
        sdt1_0.data 
    from
        some_data_table sdt1_0 
    where
        sdt1_0.id=?
2023-12-14T22:53:55.150+09:00 TRACE 76419 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (1:BIGINT) <- [1]
SomeDataTable(id=1, data='Update Data 6')
2023-12-14T22:53:58.163+09:00 DEBUG 76419 --- [pool-2-thread-1] org.hibernate.SQL                        : 
    update
        some_data_table 
    set
        data=? 
    where
        id=?
2023-12-14T22:53:58.163+09:00 TRACE 76419 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Update Data 7]
2023-12-14T22:53:58.164+09:00 TRACE 76419 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (2:BIGINT) <- [1]
Update Data 7 lock 해제
Update Data 8 lock 획득 성공
2023-12-14T22:53:58.198+09:00 DEBUG 76419 --- [pool-2-thread-5] org.hibernate.SQL                        : 
    select
        sdt1_0.id,
        sdt1_0.data 
    from
        some_data_table sdt1_0 
    where
        sdt1_0.id=?
2023-12-14T22:53:58.198+09:00 TRACE 76419 --- [pool-2-thread-5] org.hibernate.orm.jdbc.bind              : binding parameter (1:BIGINT) <- [1]
SomeDataTable(id=1, data='Update Data 7')
2023-12-14T22:54:01.207+09:00 DEBUG 76419 --- [pool-2-thread-5] org.hibernate.SQL                        : 
    update
        some_data_table 
    set
        data=? 
    where
        id=?
2023-12-14T22:54:01.207+09:00 TRACE 76419 --- [pool-2-thread-5] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Update Data 8]
2023-12-14T22:54:01.207+09:00 TRACE 76419 --- [pool-2-thread-5] org.hibernate.orm.jdbc.bind              : binding parameter (2:BIGINT) <- [1]
Update Data 8 lock 해제
Update Data 9 lock 획득 성공
2023-12-14T22:54:01.235+09:00 DEBUG 76419 --- [pool-2-thread-3] org.hibernate.SQL                        : 
    select
        sdt1_0.id,
        sdt1_0.data 
    from
        some_data_table sdt1_0 
    where
        sdt1_0.id=?
2023-12-14T22:54:01.236+09:00 TRACE 76419 --- [pool-2-thread-3] org.hibernate.orm.jdbc.bind              : binding parameter (1:BIGINT) <- [1]
SomeDataTable(id=1, data='Update Data 8')
2023-12-14T22:54:04.245+09:00 DEBUG 76419 --- [pool-2-thread-3] org.hibernate.SQL                        : 
    update
        some_data_table 
    set
        data=? 
    where
        id=?
2023-12-14T22:54:04.245+09:00 TRACE 76419 --- [pool-2-thread-3] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Update Data 9]
2023-12-14T22:54:04.246+09:00 TRACE 76419 --- [pool-2-thread-3] org.hibernate.orm.jdbc.bind              : binding parameter (2:BIGINT) <- [1]
Update Data 9 lock 해제

```