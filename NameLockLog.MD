```
2023-12-14T21:15:39.727+09:00 DEBUG 69302 --- [    Test worker] org.hibernate.SQL                        : 
    insert 
    into
        some_data_table
        (data) 
    values
        (?)
2023-12-14T21:15:39.732+09:00 TRACE 69302 --- [    Test worker] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Test Data]
2023-12-14T21:15:39.819+09:00 DEBUG 69302 --- [pool-2-thread-2] org.hibernate.SQL                        : 
    select
        get_lock(?, 6000)
2023-12-14T21:15:39.819+09:00 DEBUG 69302 --- [pool-2-thread-1] org.hibernate.SQL                        : 
    select
        get_lock(?, 6000)
2023-12-14T21:15:39.819+09:00 DEBUG 69302 --- [pool-2-thread-5] org.hibernate.SQL                        : 
    select
        get_lock(?, 6000)
2023-12-14T21:15:39.819+09:00 DEBUG 69302 --- [pool-2-thread-3] org.hibernate.SQL                        : 
    select
        get_lock(?, 6000)
2023-12-14T21:15:39.819+09:00 DEBUG 69302 --- [pool-2-thread-4] org.hibernate.SQL                        : 
    select
        get_lock(?, 6000)
2023-12-14T21:15:39.820+09:00 TRACE 69302 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
2023-12-14T21:15:39.820+09:00 TRACE 69302 --- [pool-2-thread-4] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
2023-12-14T21:15:39.820+09:00 TRACE 69302 --- [pool-2-thread-3] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
2023-12-14T21:15:39.820+09:00 TRACE 69302 --- [pool-2-thread-2] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
2023-12-14T21:15:39.820+09:00 TRACE 69302 --- [pool-2-thread-5] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
Update Data 3 lock 획득 성공
2023-12-14T21:15:39.845+09:00 DEBUG 69302 --- [pool-2-thread-4] org.hibernate.SQL                        : 
    select
        sdt1_0.id,
        sdt1_0.data 
    from
        some_data_table sdt1_0 
    where
        sdt1_0.id=?
2023-12-14T21:15:39.845+09:00 TRACE 69302 --- [pool-2-thread-4] org.hibernate.orm.jdbc.bind              : binding parameter (1:BIGINT) <- [1]
SomeDataTable(id=1, data='Test Data')
2023-12-14T21:15:42.869+09:00 DEBUG 69302 --- [pool-2-thread-4] org.hibernate.SQL                        : 
    update
        some_data_table 
    set
        data=? 
    where
        id=?
2023-12-14T21:15:42.870+09:00 TRACE 69302 --- [pool-2-thread-4] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Update Data 3]
2023-12-14T21:15:42.870+09:00 TRACE 69302 --- [pool-2-thread-4] org.hibernate.orm.jdbc.bind              : binding parameter (2:BIGINT) <- [1]
2023-12-14T21:15:42.892+09:00 DEBUG 69302 --- [pool-2-thread-4] org.hibernate.SQL                        : 
    select
        release_lock(?)
2023-12-14T21:15:42.893+09:00 TRACE 69302 --- [pool-2-thread-4] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
Update Data 0 lock 획득 성공
2023-12-14T21:15:42.896+09:00 DEBUG 69302 --- [pool-2-thread-1] org.hibernate.SQL                        : 
    select
        sdt1_0.id,
        sdt1_0.data 
    from
        some_data_table sdt1_0 
    where
        sdt1_0.id=?
2023-12-14T21:15:42.897+09:00 TRACE 69302 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (1:BIGINT) <- [1]
SomeDataTable(id=1, data='Test Data')
2023-12-14T21:15:42.907+09:00 DEBUG 69302 --- [pool-2-thread-4] org.hibernate.SQL                        : 
    select
        get_lock(?, 6000)
2023-12-14T21:15:42.907+09:00 TRACE 69302 --- [pool-2-thread-4] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
2023-12-14T21:15:45.907+09:00 DEBUG 69302 --- [pool-2-thread-1] org.hibernate.SQL                        : 
    update
        some_data_table 
    set
        data=? 
    where
        id=?
2023-12-14T21:15:45.907+09:00 TRACE 69302 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Update Data 0]
2023-12-14T21:15:45.908+09:00 TRACE 69302 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (2:BIGINT) <- [1]
2023-12-14T21:15:45.924+09:00 DEBUG 69302 --- [pool-2-thread-1] org.hibernate.SQL                        : 
    select
        release_lock(?)
2023-12-14T21:15:45.925+09:00 TRACE 69302 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
Update Data 1 lock 획득 성공
2023-12-14T21:15:45.930+09:00 DEBUG 69302 --- [pool-2-thread-2] org.hibernate.SQL                        : 
    select
        sdt1_0.id,
        sdt1_0.data 
    from
        some_data_table sdt1_0 
    where
        sdt1_0.id=?
2023-12-14T21:15:45.930+09:00 TRACE 69302 --- [pool-2-thread-2] org.hibernate.orm.jdbc.bind              : binding parameter (1:BIGINT) <- [1]
SomeDataTable(id=1, data='Update Data 3')
2023-12-14T21:15:45.944+09:00 DEBUG 69302 --- [pool-2-thread-1] org.hibernate.SQL                        : 
    select
        get_lock(?, 6000)
2023-12-14T21:15:45.944+09:00 TRACE 69302 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
2023-12-14T21:15:48.946+09:00 DEBUG 69302 --- [pool-2-thread-2] org.hibernate.SQL                        : 
    update
        some_data_table 
    set
        data=? 
    where
        id=?
2023-12-14T21:15:48.947+09:00 TRACE 69302 --- [pool-2-thread-2] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Update Data 1]
2023-12-14T21:15:48.947+09:00 TRACE 69302 --- [pool-2-thread-2] org.hibernate.orm.jdbc.bind              : binding parameter (2:BIGINT) <- [1]
2023-12-14T21:15:48.960+09:00 DEBUG 69302 --- [pool-2-thread-2] org.hibernate.SQL                        : 
    select
        release_lock(?)
2023-12-14T21:15:48.961+09:00 TRACE 69302 --- [pool-2-thread-2] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
Update Data 4 lock 획득 성공
2023-12-14T21:15:48.967+09:00 DEBUG 69302 --- [pool-2-thread-5] org.hibernate.SQL                        : 
    select
        sdt1_0.id,
        sdt1_0.data 
    from
        some_data_table sdt1_0 
    where
        sdt1_0.id=?
2023-12-14T21:15:48.968+09:00 TRACE 69302 --- [pool-2-thread-5] org.hibernate.orm.jdbc.bind              : binding parameter (1:BIGINT) <- [1]
SomeDataTable(id=1, data='Update Data 0')
2023-12-14T21:15:48.990+09:00 DEBUG 69302 --- [pool-2-thread-2] org.hibernate.SQL                        : 
    select
        get_lock(?, 6000)
2023-12-14T21:15:48.990+09:00 TRACE 69302 --- [pool-2-thread-2] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
2023-12-14T21:15:51.985+09:00 DEBUG 69302 --- [pool-2-thread-5] org.hibernate.SQL                        : 
    update
        some_data_table 
    set
        data=? 
    where
        id=?
2023-12-14T21:15:51.986+09:00 TRACE 69302 --- [pool-2-thread-5] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Update Data 4]
2023-12-14T21:15:51.986+09:00 TRACE 69302 --- [pool-2-thread-5] org.hibernate.orm.jdbc.bind              : binding parameter (2:BIGINT) <- [1]
2023-12-14T21:15:51.995+09:00 DEBUG 69302 --- [pool-2-thread-5] org.hibernate.SQL                        : 
    select
        release_lock(?)
2023-12-14T21:15:51.996+09:00 TRACE 69302 --- [pool-2-thread-5] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
Update Data 2 lock 획득 성공
2023-12-14T21:15:52.003+09:00 DEBUG 69302 --- [pool-2-thread-3] org.hibernate.SQL                        : 
    select
        sdt1_0.id,
        sdt1_0.data 
    from
        some_data_table sdt1_0 
    where
        sdt1_0.id=?
2023-12-14T21:15:52.003+09:00 TRACE 69302 --- [pool-2-thread-3] org.hibernate.orm.jdbc.bind              : binding parameter (1:BIGINT) <- [1]
SomeDataTable(id=1, data='Update Data 1')
2023-12-14T21:15:52.014+09:00 DEBUG 69302 --- [pool-2-thread-5] org.hibernate.SQL                        : 
    select
        get_lock(?, 6000)
2023-12-14T21:15:52.015+09:00 TRACE 69302 --- [pool-2-thread-5] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
2023-12-14T21:15:55.012+09:00 DEBUG 69302 --- [pool-2-thread-3] org.hibernate.SQL                        : 
    update
        some_data_table 
    set
        data=? 
    where
        id=?
2023-12-14T21:15:55.013+09:00 TRACE 69302 --- [pool-2-thread-3] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Update Data 2]
2023-12-14T21:15:55.013+09:00 TRACE 69302 --- [pool-2-thread-3] org.hibernate.orm.jdbc.bind              : binding parameter (2:BIGINT) <- [1]
2023-12-14T21:15:55.017+09:00 DEBUG 69302 --- [pool-2-thread-3] org.hibernate.SQL                        : 
    select
        release_lock(?)
2023-12-14T21:15:55.018+09:00 TRACE 69302 --- [pool-2-thread-3] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
Update Data 5 lock 획득 성공
2023-12-14T21:15:55.026+09:00 DEBUG 69302 --- [pool-2-thread-4] org.hibernate.SQL                        : 
    select
        sdt1_0.id,
        sdt1_0.data 
    from
        some_data_table sdt1_0 
    where
        sdt1_0.id=?
2023-12-14T21:15:55.027+09:00 TRACE 69302 --- [pool-2-thread-4] org.hibernate.orm.jdbc.bind              : binding parameter (1:BIGINT) <- [1]
SomeDataTable(id=1, data='Update Data 4')
2023-12-14T21:15:55.040+09:00 DEBUG 69302 --- [pool-2-thread-3] org.hibernate.SQL                        : 
    select
        get_lock(?, 6000)
2023-12-14T21:15:55.041+09:00 TRACE 69302 --- [pool-2-thread-3] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
2023-12-14T21:15:58.044+09:00 DEBUG 69302 --- [pool-2-thread-4] org.hibernate.SQL                        : 
    update
        some_data_table 
    set
        data=? 
    where
        id=?
2023-12-14T21:15:58.045+09:00 TRACE 69302 --- [pool-2-thread-4] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Update Data 5]
2023-12-14T21:15:58.045+09:00 TRACE 69302 --- [pool-2-thread-4] org.hibernate.orm.jdbc.bind              : binding parameter (2:BIGINT) <- [1]
2023-12-14T21:15:58.056+09:00 DEBUG 69302 --- [pool-2-thread-4] org.hibernate.SQL                        : 
    select
        release_lock(?)
2023-12-14T21:15:58.056+09:00 TRACE 69302 --- [pool-2-thread-4] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
Update Data 6 lock 획득 성공
2023-12-14T21:15:58.063+09:00 DEBUG 69302 --- [pool-2-thread-1] org.hibernate.SQL                        : 
    select
        sdt1_0.id,
        sdt1_0.data 
    from
        some_data_table sdt1_0 
    where
        sdt1_0.id=?
2023-12-14T21:15:58.063+09:00 TRACE 69302 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (1:BIGINT) <- [1]
SomeDataTable(id=1, data='Update Data 2')
2023-12-14T21:16:01.076+09:00 DEBUG 69302 --- [pool-2-thread-1] org.hibernate.SQL                        : 
    update
        some_data_table 
    set
        data=? 
    where
        id=?
2023-12-14T21:16:01.077+09:00 TRACE 69302 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Update Data 6]
2023-12-14T21:16:01.077+09:00 TRACE 69302 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (2:BIGINT) <- [1]
2023-12-14T21:16:01.086+09:00 DEBUG 69302 --- [pool-2-thread-1] org.hibernate.SQL                        : 
    select
        release_lock(?)
2023-12-14T21:16:01.087+09:00 TRACE 69302 --- [pool-2-thread-1] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
Update Data 7 lock 획득 성공
2023-12-14T21:16:01.091+09:00 DEBUG 69302 --- [pool-2-thread-2] org.hibernate.SQL                        : 
    select
        sdt1_0.id,
        sdt1_0.data 
    from
        some_data_table sdt1_0 
    where
        sdt1_0.id=?
2023-12-14T21:16:01.091+09:00 TRACE 69302 --- [pool-2-thread-2] org.hibernate.orm.jdbc.bind              : binding parameter (1:BIGINT) <- [1]
SomeDataTable(id=1, data='Update Data 5')
2023-12-14T21:16:04.111+09:00 DEBUG 69302 --- [pool-2-thread-2] org.hibernate.SQL                        : 
    update
        some_data_table 
    set
        data=? 
    where
        id=?
2023-12-14T21:16:04.111+09:00 TRACE 69302 --- [pool-2-thread-2] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Update Data 7]
2023-12-14T21:16:04.112+09:00 TRACE 69302 --- [pool-2-thread-2] org.hibernate.orm.jdbc.bind              : binding parameter (2:BIGINT) <- [1]
2023-12-14T21:16:04.120+09:00 DEBUG 69302 --- [pool-2-thread-2] org.hibernate.SQL                        : 
    select
        release_lock(?)
2023-12-14T21:16:04.120+09:00 TRACE 69302 --- [pool-2-thread-2] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
Update Data 8 lock 획득 성공
2023-12-14T21:16:04.126+09:00 DEBUG 69302 --- [pool-2-thread-5] org.hibernate.SQL                        : 
    select
        sdt1_0.id,
        sdt1_0.data 
    from
        some_data_table sdt1_0 
    where
        sdt1_0.id=?
2023-12-14T21:16:04.126+09:00 TRACE 69302 --- [pool-2-thread-5] org.hibernate.orm.jdbc.bind              : binding parameter (1:BIGINT) <- [1]
SomeDataTable(id=1, data='Update Data 6')
2023-12-14T21:16:07.140+09:00 DEBUG 69302 --- [pool-2-thread-5] org.hibernate.SQL                        : 
    update
        some_data_table 
    set
        data=? 
    where
        id=?
2023-12-14T21:16:07.140+09:00 TRACE 69302 --- [pool-2-thread-5] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Update Data 8]
2023-12-14T21:16:07.141+09:00 TRACE 69302 --- [pool-2-thread-5] org.hibernate.orm.jdbc.bind              : binding parameter (2:BIGINT) <- [1]
2023-12-14T21:16:07.165+09:00 DEBUG 69302 --- [pool-2-thread-5] org.hibernate.SQL                        : 
    select
        release_lock(?)
2023-12-14T21:16:07.166+09:00 TRACE 69302 --- [pool-2-thread-5] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]
Update Data 9 lock 획득 성공
2023-12-14T21:16:07.173+09:00 DEBUG 69302 --- [pool-2-thread-3] org.hibernate.SQL                        : 
    select
        sdt1_0.id,
        sdt1_0.data 
    from
        some_data_table sdt1_0 
    where
        sdt1_0.id=?
2023-12-14T21:16:07.173+09:00 TRACE 69302 --- [pool-2-thread-3] org.hibernate.orm.jdbc.bind              : binding parameter (1:BIGINT) <- [1]
SomeDataTable(id=1, data='Update Data 7')
2023-12-14T21:16:10.188+09:00 DEBUG 69302 --- [pool-2-thread-3] org.hibernate.SQL                        : 
    update
        some_data_table 
    set
        data=? 
    where
        id=?
2023-12-14T21:16:10.189+09:00 TRACE 69302 --- [pool-2-thread-3] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [Update Data 9]
2023-12-14T21:16:10.189+09:00 TRACE 69302 --- [pool-2-thread-3] org.hibernate.orm.jdbc.bind              : binding parameter (2:BIGINT) <- [1]
2023-12-14T21:16:10.202+09:00 DEBUG 69302 --- [pool-2-thread-3] org.hibernate.SQL                        : 
    select
        release_lock(?)
2023-12-14T21:16:10.202+09:00 TRACE 69302 --- [pool-2-thread-3] org.hibernate.orm.jdbc.bind              : binding parameter (1:VARCHAR) <- [1]

```