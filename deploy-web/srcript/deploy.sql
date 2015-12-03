/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/11/30 11:30:57                          */
/*==============================================================*/

drop table if exists TB_APP_SYSTEM;

drop table if exists TB_APP;

drop table if exists TB_APP_COMMON;

drop table if exists TB_APP_MEMBER;

drop table if exists TB_APP_RESOURCES;

drop table if exists TB_APP_SOURCE_CODE;

drop table if exists TB_APP_TEST_COMMON;

drop table if exists TB_APP_TEST_RESOURCES;

drop table if exists TB_COMPILE;

drop table if exists TB_COMPILE_CONFIG;

drop table if exists TB_COMPILE_PACKAGE;

drop table if exists TB_DEPARTMENT;

drop table if exists TB_DEPLOY_RESOURCES;

drop table if exists TB_DEPLOY_TASK;

drop table if exists TB_DICTIONARY;

drop table if exists TB_ONLINE_TASK;

drop table if exists TB_ONLINE_TASK_PACKAGE;

drop table if exists TB_ONLINE_TASK_RESUME;

drop table if exists TB_PACKAGE_VERSION;

drop table if exists TB_TEST_COMPILE_PACKAGE;

drop table if exists TB_TEST_DEPLOY_RESOURCES;

drop table if exists TB_TEST_PACKAGE_VERSION;

/*==============================================================*/
/* Table: TB_APP                                                */
/*==============================================================*/
create table TB_APP_SYSTEM
(
   ID                   int(11) not null auto_increment comment '自增ID',
   SYSTEM_ID            int(11) not null comment '系统ID',
   SYSTEM_NAME          varchar(100) comment '系统名称',
   SYSTEM_CHINESE_NAME  varchar(200) comment '系统中文名',
   SYSTEM_LEVEL         int(4) comment '系统级别',
   SYSTEM_CHIEF         varchar(30) comment '系统负责人',
   DEPARTMENT           varchar(100) comment '所属部门',
   CREATE_USER          varchar(30) comment '创建人',
   CREATE_TIME          datetime comment '创建时间',
   UPDATE_USER          varchar(30) comment '更新人',
   UPDATE_TIME          datetime comment '更新时间',
   REMARK               varchar(200) comment '备注',
   IS_DEL               int(4) comment '删除标示 0：否  1：是',
   primary key (ID)
);
alter table TB_APP_SYSTEM comment '应用系统表';

/*==============================================================*/
/* Table: TB_APP                                                */
/*==============================================================*/
create table TB_APP
(
   ID                   int not null auto_increment comment '自增ID',
   APP_ID            	int(11) not null comment '应用ID',
   SYSTEM_ID            int(11) not null comment '系统ID',
   APP_NAME             varchar(100) comment '应用名称',
   APP_CHINESE_NAME     varchar(200) comment '应用中文名',
   APP_TYPE             int(4) comment '应用类型',
   APP_LEVEL            int(4) comment '应用级别',
   APP_CHIEF            varchar(30) comment '应用负责人',
   DOMAIN_TYPE          int(4) comment '域名类型',
   APP_DOMAIN           varchar(80) comment '应用域名',
   DEPLOY_TYPE          int(4) comment '应用部署类型',
   DEPLOY_PATH          varchar(200) comment '应用部署路径',
   COMPILE_TYPE         int(4) comment '编译类型',
   STATUS               int(4) comment '状态',
   CREATE_USER          varchar(30) comment '创建人',
   CREATE_TIME          datetime comment '创建时间',
   UPDATE_USER          varchar(30) comment '更新人',
   UPDATE_TIME          datetime comment '更新时间',
   REMARK               varchar(200) comment '备注',
   IS_DEL               int(4) comment '删除标示 0：否  1：是',
   primary key (ID)
);

alter table TB_APP comment '应用表';

/*==============================================================*/
/* Table: TB_APP_COMMON                                         */
/*==============================================================*/
create table TB_APP_COMMON
(
   ID                   int not null auto_increment comment '自增ID',
   APP_ID               int comment '应用ID',
   `FILE_NAME`          varchar(100) comment '文件名',
   FILE_PATH            varchar(200) comment '文件地址',
   CREATE_TIME          datetime comment '创建时间',
   CREATE_USER          datetime comment '创建人',
   primary key (ID)
);

alter table TB_APP_COMMON comment '应用公用配置';

/*==============================================================*/
/* Table: TB_APP_MEMBER                                         */
/*==============================================================*/
create table TB_APP_MEMBER
(
   ID                   int(11) not null auto_increment comment '自增ID',
   APP_ID               int(11) comment '应用ID',
   USER_ID              varchar(30) comment '用户ID',
   primary key (ID)
);

alter table TB_APP_MEMBER comment '应用成员表';

/*==============================================================*/
/* Table: TB_APP_RESOURCES                                      */
/*==============================================================*/
create table TB_APP_RESOURCES
(
   ID                   int(11) not null auto_increment comment '自增ID',
   APP_ID               int(11) comment '应用ID',
   IP                   varchar(20) comment '机器IP',
   STAUTS               int(4) comment '状态',
   CREATE_TIME          datetime comment '创建时间',
   CREATE_USER          varchar(30) comment '创建人',
   UPDATE_TIME          timestamp comment '更新时间',
   UPDATE_USER          varchar(32) comment '更新人',
   IS_DEL               int(4) comment '是否删除',
   primary key (ID)
);

alter table TB_APP_RESOURCES comment '应用资源表';

/*==============================================================*/
/* Table: TB_APP_SOURCE_CODE                                            */
/*==============================================================*/
create table TB_APP_SOURCE_CODE
(
   ID                   int(11) not null auto_increment comment '自增ID',
   APP_ID               int(11) comment '应用ID',
   TRUNK                varchar(100) comment '主干地址',
   TRUNK_USER           varchar(30) comment '主干用户名',
   TRUNK_PASSWORD       varchar(128) comment '主干密码',
   BRANCH               varchar(100) comment '分支地址',
   BRANCH_USER          varchar(30) comment '分支用户名',
   BRANCH_PASSWORD      varchar(64) comment '分支密码',
   TRUNK_LAST_VERSION   varchar(100) comment '最后一次主干更新版本',
   BRANCH_LAST_VERSION  varchar(100) comment '分支最后一次更新版本',
   TARGET_PATH          varchar(100) comment '编译后的地址',
   SOURCE_TYPE          int(4) comment '1=SVN, 2=GIT',
   CREATE_TIME          datetime comment '创建时间',
   CREATE_USER          varchar(30) comment '创建人',
   UPDATE_TIME          datetime comment '更新时间',
   UPDATE_USER          varchar(30) comment '更新人',
   IS_DEL               int(4) comment '删除标示',
   primary key (ID)
);

alter table TB_APP_SOURCE_CODE comment '应用源码表';

/*==============================================================*/
/* Table: TB_APP_TEST_COMMON                                    */
/*==============================================================*/
create table TB_APP_TEST_COMMON
(
   ID                   int(11) not null auto_increment comment '自增ID',
   APP_ID               int(11) comment '应用ID',
   `FILE_NAME`          varchar(100) comment '文件名',
   FILE_PATH            varchar(200) comment '文件地址',
   CREATE_TIME          datetime comment '创建时间',
   CREATE_USER          datetime comment '创建人',
   primary key (ID)
);

alter table TB_APP_TEST_COMMON comment '测试应用公用配置';

/*==============================================================*/
/* Table: TB_APP_TEST_RESOURCES                                 */
/*==============================================================*/
create table TB_APP_TEST_RESOURCES
(
   ID                   int(11) not null auto_increment comment '自增ID',
   APP_ID               int(11) comment '应用ID',
   IP                   varchar(20) comment '机器IP',
   STAUTS               int(11) comment '状态 0=停止, 1=运行',
   CREATE_TIME          datetime comment '创建时间',
   CREATE_USER          varchar(30) comment '创建人',
   UPDATE_TIME          timestamp comment '更新时间',
   UPDATE_USER          varchar(32) comment '更新人',
   IS_DEL               int(4) comment '是否删除',
   primary key (ID)
);

alter table TB_APP_TEST_RESOURCES comment '测试应用资源表';

/*==============================================================*/
/* Table: TB_COMPILE                                            */
/*==============================================================*/
create table TB_COMPILE
(
   ID                   int(11) not null auto_increment comment '自增ID',
   APP_ID               int(11) comment '应用ID',
   TRUNK                varchar(200) comment '抽包地址',
   TEST_TYPE            int(4) comment '测试类型 1=测试 ,2=自测',
   ONLINE_TYPE          int(4) comment '上线类型 1=正常上线 ,2=紧急上线',
   STATUS               int(4) comment '状态',
   TEST_USER            varchar(30) comment '测试人',
   TEST_EMAIL           varchar(50) comment '测试人EMAIL',
   REMARK               varchar(200) comment '备注',
   CREATE_TIME          datetime comment '创建时间',
   CREATE_USER          datetime comment '创建人',
   primary key (ID)
);

alter table TB_COMPILE comment '编译';

/*==============================================================*/
/* Table: TB_COMPILE_CONFIG                                     */
/*==============================================================*/
create table TB_COMPILE_CONFIG
(
   ID                   int(11) not null auto_increment comment '自增ID',
   APP_ID               int(11) comment '应用ID',
   PROFILE_ID_TEST      varchar(50) comment '测试PROFILEID',
   PROFILE_ID_PRODUCT   varchar(50) comment '生产PROFILEID',
   PROFILE_PATH         varchar(200) comment '文件地址',
   CREATE_TIME          datetime comment '创建时间',
   CREATE_USER          datetime comment '创建人',
   primary key (ID)
);

alter table TB_COMPILE_CONFIG comment '编译配置表';

/*==============================================================*/
/* Table: TB_COMPILE_PACKAGE                                    */
/*==============================================================*/
create table TB_COMPILE_PACKAGE
(
   ID                   int(11) not null auto_increment comment '自增ID',
   APP_ID               int(11) comment '应用ID',
   COMPILE_ID           int(11) comment '测试PROFILEID',
   PACKAGE_NAME         varchar(50) comment '包名称',
   ADDRESS              varchar(200) comment '包存放地址',
   CREATE_TIME          datetime comment '创建时间',
   CREATE_USER          datetime comment '创建人',
   primary key (ID)
);

alter table TB_COMPILE_PACKAGE comment '编译包';

/*==============================================================*/
/* Table: TB_DEPLOY_RESOURCES                                   */
/*==============================================================*/
create table TB_DEPLOY_RESOURCES
(
   ID                   int(11) not null auto_increment comment '自增ID',
   APP_ID               int(11) comment '应用ID',
   TASK_ID              int(11) comment '部署任务ID',
   DEPLOY_IP            varchar(20) comment '部署任务IP',
   IS_DEL               int(4) comment '是否删除',
   primary key (ID)
);

alter table TB_DEPLOY_RESOURCES comment '部署资源表';

/*==============================================================*/
/* Table: TB_DEPLOY_TASK                                        */
/*==============================================================*/
create table TB_DEPLOY_TASK
(
   ID                   int(11) not null auto_increment comment '自增ID',
   `TYPE`               int(4) comment '上线类型 1=正常上线 ,2=紧急上线, 3=重启任务, 4=停止任务, 5=回滚任务',
   APPROVAL_USER        varchar(60) comment '审批人',
   APPROVAL_TIME        datetime comment '审批时间',
   TITLE                varchar(200) comment '标题',
   APP_ID               int(11) comment '应用ID',
   PLAN_DEPLOY_TIME     varchar(20) comment '计划部署时间',
   REMARK               varchar(200) comment '备注',
   VERSION_SRC          int comment '版本来源',
   VERSION_NO           varchar(50) comment '版本号',
   CREATE_USER          varchar(60) comment '创建人',
   CREATE_TIME          datetime comment '创建时间',
   STATUS               int(4) comment '状态 0=待部署, 1=部署成功',
   FINISH_TIME          datetime comment '完成时间',
   TASK_ID              int(11) comment '任务包ID',
   primary key (ID)
);

alter table TB_DEPLOY_TASK comment '部署任务表';

/*==============================================================*/
/* Table: TB_DICTIONARY                                         */
/*==============================================================*/
create table TB_DICTIONARY
(
   ID                   int not null auto_increment comment '自增ID',
   `TYPE`               int(4) comment '字典类型',
   `NAME`               varchar(80) comment '名称',
   `KEY`                varchar(50) comment '字典KEY',
   `VALUE`              varchar(200) comment '字典VALUE',
   CREATE_USER          varchar(30) comment '创建人',
   CREATE_TIME          datetime comment '创建时间',
   UPDATE_USER          varchar(30) comment '更新人',
   UPDATE_TIME          datetime comment '更新时间',
   IS_DEL               int(4) comment '是否删除',
   DESCRIPTION          varchar(50) comment '描述',
   primary key (ID)
);

alter table TB_DICTIONARY comment '字典表';

/*==============================================================*/
/* Table: TB_ONLINE_TASK                                        */
/*==============================================================*/
create table TB_ONLINE_TASK
(
   ID                   int(11) not null auto_increment comment '自增ID',
   APP_ID               int(11) comment '应用ID',
   TITLE                varchar(200) comment '标题',
   STATUS               int(4) comment '状态',
   `TYPE`               int(4) comment '上线类型',
   IS_NEW               int(4) comment '是否新应用',
   DEPLOY_DATE          varchar(20) comment '部署日期',
   DEPLOY_TIME          varchar(20) comment '部署时间',
   IS_CHAGE_SQL         int(4) comment '是否SQL变动',
   CREATE_TIME          datetime comment '创建时间',
   CREATE_USER          varchar(30) comment '创建人',
   primary key (ID)
);

alter table TB_ONLINE_TASK comment '上线任务表';

/*==============================================================*/
/* Table: TB_ONLINE_TASK_PACKAGE                                */
/*==============================================================*/
create table TB_ONLINE_TASK_PACKAGE
(
   ID                   int(11) not null auto_increment comment '自增ID',
   TASK_ID              int(11) comment '任务ID',
   COMPILE_ID           int(11) comment '编译ID',
   PACKAGE_NAME         varchar(200) comment '包名称',
   `TYPE`               int(4) comment '包类型(1：增量 2：全量)',
   PACKAGE_PATH         varchar(200) comment '包路径',
   CREATE_USER          varchar(30) comment '创建人',
   CREATE_TIME          datetime comment '创建时间',
   primary key (ID)
);

alter table TB_ONLINE_TASK_PACKAGE comment '上线任务挂包表';

/*==============================================================*/
/* Table: TB_ONLINE_TASK_RESUME                                 */
/*==============================================================*/
create table TB_ONLINE_TASK_RESUME
(
   ID                   int(11) not null auto_increment comment '自增ID',
   TASK_ID              int(11) comment '任务ID',
   STATUS               int(4) comment '状态',
   CREATE_USER          varchar(30) comment '创建人',
   CREATE_TIME          datetime comment '创建时间',
   primary key (ID)
);

alter table TB_ONLINE_TASK_RESUME comment '上线申请履历表';

/*==============================================================*/
/* Table: TB_PACKAGE_VERSION                                    */
/*==============================================================*/
create table TB_PACKAGE_VERSION
(
   ID                   int(11) not null auto_increment comment '自增ID',
   APP_ID               int(11) comment '应用ID',
   PACKAGE_VERSION_NO   varchar(200) comment '包版本',
   CREATE_TIME          datetime comment '创建时间',
   CREATE_USER          varchar(30) comment '创建人',
   primary key (ID)
);

alter table TB_PACKAGE_VERSION comment '版本包';

/*==============================================================*/
/* Table: TB_TEST_COMPILE_PACKAGE                               */
/*==============================================================*/
create table TB_TEST_COMPILE_PACKAGE
(
   ID                   int(11) not null auto_increment comment '自增ID',
   APP_ID               int(11) comment '应用ID',
   COMPILE_ID           int(11) comment '测试PROFILEID',
   PACKAGE_NAME         varchar(50) comment '包名称',
   ADDRESS              varchar(200) comment '包存放地址',
   CREATE_TIME          datetime comment '创建时间',
   CREATE_USER          datetime comment '创建人',
   primary key (ID)
);

alter table TB_TEST_COMPILE_PACKAGE comment '测试编译包';

/*==============================================================*/
/* Table: TB_TEST_DEPLOY_RESOURCES                              */
/*==============================================================*/
create table TB_TEST_DEPLOY_RESOURCES
(
   ID                   int(11) not null auto_increment comment '自增ID',
   APP_ID               int(11) comment '应用ID',
   TASK_ID              int(11) comment '部署任务ID',
   DEPLOY_IP            varchar(20) comment '部署任务IP',
   IS_DEL               int(4) comment '是否删除',
   primary key (ID)
);

/*==============================================================*/
/* Table: TB_TEST_PACKAGE_VERSION                               */
/*==============================================================*/
create table TB_TEST_PACKAGE_VERSION
(
   ID                   int not null auto_increment comment '自增ID',
   APP_ID               int(11) comment '应用ID',
   PACKAGE_VERSION_NO   varchar(200) comment '包版本',
   CREATE_TIME          datetime comment '创建时间',
   CREATE_USER          varchar(30) comment '创建人',
   primary key (ID)
);

alter table TB_TEST_PACKAGE_VERSION comment '测试版本包';

