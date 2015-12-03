
/*--系统级别*/
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1000, '0级系统', 'level_0', '0', 'system', now(), 'system', now(), '系统级别', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1000, '1级系统', 'level_1', '1', 'system', now(), 'system', now(), '系统级别', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1000, '2级系统', 'level_2', '2', 'system', now(), 'system', now(), '系统级别', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1000, '3级系统', 'level_3', '3', 'system', now(), 'system', now(), '系统级别', 0);

/*--应用类型*/
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1001, '核心应用', 'core', '1', 'system', now(), 'system', now(), '应用类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1001, '非核心应用', 'no_core', '2', 'system', now(), 'system', now(), '应用类型', 0);

/*--域名类型*/
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1002, '对内域名', 'local', '1', 'system', now(), 'system', now(), '域名类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1002, '对外域名', 'internet', '2', 'system', now(), 'system', now(), '域名类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1002, '无需域名解析', 'no', '3', 'system', now(), 'system', now(), '域名类型', 0);

/*--部署类型*/
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1003, 'web_tomcat', 'tomcat', '1', 'system', now(), 'system', now(), '部署类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1003, 'application_worker', 'worker', '2', 'system', now(), 'system', now(), '部署类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1003, 'static_resource', 'resource', '3', 'system', now(), 'system', now(), '部署类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1003, 'rpm_package', 'rpm', '4', 'system', now(), 'system', now(), '部署类型', 0);

/*--编译类型*/
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1004, 'JAVA/maven3(jdk1.7)', 'maven3', '1', 'system', now(), 'system', now(), '编译类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1004, 'JAVA/maven2(jdk1.6)', 'maven2', '1', 'system', now(), 'system', now(), '编译类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1004, 'static_resource', 'html', '2', 'system', now(), 'system', now(), '编译类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1004, 'C++/Make/rpm', 'rpm', '4', 'system', now(), 'system', now(), '编译类型', 0);

/*--源码类型*/
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1005, 'SVN', 'SVN', '1', 'system', now(), 'system', now(), '源码类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1005, 'Git', 'Git', '2', 'system', now(), 'system', now(), '源码类型', 0);

/*--测试类型*/
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1006, '测试', 'test', '1', 'system', now(), 'system', now(), '测试类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1006, '自测', 'no_test', '2', 'system', now(), 'system', now(), '测试类型', 0);

/*--上线类型*/
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1007, '正常上线', 'normal', '1', 'system', now(), 'system', now(), '上线类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1007, '紧急上线', 'urgent', '2', 'system', now(), 'system', now(), '上线类型', 0);

/*--操作部署类型*/
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1008, '正常上线', 'normal', '1', 'system', now(), 'system', now(), '部署任务类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1008, '紧急上线', 'urgent', '2', 'system', now(), 'system', now(), '部署任务类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1008, '回滚任务', 'normal', '3', 'system', now(), 'system', now(), '部署任务类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1008, '重启任务', 'urgent', '4', 'system', now(), 'system', now(), '部署任务类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1008, '停止任务', 'normal', '5', 'system', now(), 'system', now(), '部署任务类型', 0);

/*--编译包类型*/
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1009, '全量包', 'totalamount', '1', 'system', now(), 'system', now(), '编译包类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1009, '增量包', 'incremental', '2', 'system', now(), 'system', now(), '编译包类型', 0);

/*--是否新应用类型*/
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1010, '是', 'yes', '1', 'system', now(), 'system', now(), '是否新应用类型', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1010, '否', 'no', '0', 'system', now(), 'system', now(), '是否新应用类型', 0);

/*--是否SQL变动*/
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1011, '是', 'yes', '1', 'system', now(), 'system', now(), '是否SQL变动', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1011, '否', 'no', '0', 'system', now(), 'system', now(), '是否SQL变动', 0);

/*--上线时间 */
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1012, '10:00 - 17:00', '1017', '1', 'system', now(), 'system', now(), '上线时间', 0);
insert into tb_dictionary (`TYPE`, NAME, `KEY`, VALUE, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, DESCRIPTION, IS_DEL) values (1012, '17:00 - 09:00', '1709', '2', 'system', now(), 'system', now(), '上线时间', 0);

