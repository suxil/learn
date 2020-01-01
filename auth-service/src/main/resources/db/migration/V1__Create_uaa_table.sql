/* ============================================================== UAA ============================================================== */

/*
 * uaa_user_login_log 用户登录日志
 *
 * uaa_user 用户表
 * uaa_role 角色表
 * uaa_user_role 用户-角色表
 * uaa_permission 权限表
 * uaa_user_permission 用户-权限表
 * uaa_role_permission 角色-权限表
 * uaa_group 组表
 * uaa_group_user 组-用户表
 * uaa_group_role 组-角色表
 * uaa_group_permission 组-权限表
 * uaa_office 组织表
 * uaa_department 部门表
 * uaa_department_position 部门-岗位表
 * uaa_position 岗位表
 * uaa_user_position 用户-岗位表
 * uaa_menu 菜单表
 * uaa_menu_role 菜单-角色表
 * uaa_menu_element 菜单页面元素表
 * uaa_menu_element_role 菜单页面元素-角色表
 * uaa_operate 操作表(系统启动自动记录所有后台接口，不需要手工操作)
 * uaa_operate_permission 操作-权限表
 */

/*==============================================================*/
/* Table: uaa_user_login_log                                    */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_user_login_log (
    id                   varchar(32) not null,
    user_code            varchar(60) not null comment '用户代码',
    user_name            varchar(60) not null comment '姓名',
    jp                   varchar(60) not null comment '简拼',
    login_name           varchar(60) not null comment '登录名',
    country              varchar(60) not null comment '国家',
    city                 varchar(60) not null comment '城市',
    operator             varchar(30) not null comment '运营商',
    login_ip             int(10) not null comment '登录ip',
    computer_name        varchar(30) not null comment '计算机名称',
    language             varchar(10) not null comment '语言',
    platform             varchar(10) not null comment '平台',
    user_agent           varchar(100) not null comment '浏览器',
    cookies              varchar(200) not null comment '登录cookie',

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '用户登录日志';

/*==============================================================*/
/* Table: uaa_user                                              */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_user (
    id                   varchar(32) not null,
    user_code            varchar(60) not null comment '用户代码',
    user_name            varchar(60) not null comment '姓名',
    jp                   varchar(60) not null comment '简拼',
    login_name           varchar(60) not null comment '登录名',
    password             varchar(200) not null comment '密码',
    mobile               varchar(30) not null comment '手机号',
    email                varchar(30) not null comment '邮箱',
    is_admin             tinyint(1) not null comment '是否超级管理员 1：是 0：否',
    last_login_date      timestamp default current_timestamp comment '上次登录日期',
    login_count          int comment '登录次数',
    description          varchar(200) not null comment '描述',

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '用户信息';

/*==============================================================*/
/* Table: uaa_role                                              */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_role (
    id                   varchar(32) not null,
    parent_id            varchar(32) not null comment '父角色id',
    seq                  int not null comment '序号',
    level                int not null comment '角色层级',
    full_path            varchar(300) not null comment '角色全路径',
    role_code            varchar(60) not null comment '角色代码',
    role_name            varchar(60) not null comment '角色名称',
    description          varchar(200) not null comment '描述',

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '角色信息';

/*==============================================================*/
/* Table: uaa_user_role                                         */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_user_role (
    id                   varchar(32) not null,
    user_id              varchar(32) not null,
    role_id              varchar(32) not null,

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '角色信息';

/*==============================================================*/
/* Table: uaa_permission                                        */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_permission (
    id                   varchar(32) not null,
    parent_id            varchar(32) not null comment '父权限id',
    seq                  int not null comment '序号',
    permission_code      varchar(200) not null comment '权限代码',
    permission_name      varchar(60) not null comment '权限名称',
    permission_type      varchar(30) not null comment '权限类型',
    description          varchar(200) not null comment '描述',

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '权限信息';

/*==============================================================*/
/* Table: uaa_user_permission                                   */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_user_permission (
    id                   varchar(32) not null,
    user_id              varchar(32) not null,
    permission_id        varchar(32) not null,

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '用户-权限信息';

/*==============================================================*/
/* Table: uaa_role_permission                                   */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_role_permission (
    id                   varchar(32) not null,
    role_id              varchar(32) not null,
    permission_id        varchar(32) not null,

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '角色-权限信息';

/*==============================================================*/
/* Table: uaa_group                                             */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_group (
    id                   varchar(32) not null,
    parent_id            varchar(32) not null comment '父组id',
    seq                  int not null comment '序号',
    level                int not null comment '组层级',
    full_path            varchar(300) not null comment '组全路径',
    group_code           varchar(60) not null comment '组代码',
    group_name           varchar(60) not null comment '组名称',
    description          varchar(200) not null comment '描述',

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '组信息';

/*==============================================================*/
/* Table: uaa_group_user                                        */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_group_user (
    id                   varchar(32) not null,
    group_id             varchar(32) not null,
    user_id              varchar(32) not null,

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '组-用户信息';

/*==============================================================*/
/* Table: uaa_group_role                                        */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_group_role (
    id                   varchar(32) not null,
    group_id             varchar(32) not null,
    role_id              varchar(32) not null,

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '组-角色信息';

/*==============================================================*/
/* Table: uaa_group_permission                                  */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_group_permission (
    id                   varchar(32) not null,
    group_id             varchar(32) not null,
    permission_id        varchar(32) not null,

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '组-权限信息';

/*==============================================================*/
/* Table: uaa_office                                            */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_office (
    id                   varchar(32) not null,
    parent_id            varchar(32) not null comment '父组织id',
    seq                  int not null comment '序号',
    level                int not null comment '组织层级',
    full_path            varchar(300) not null comment '组织全路径',
    office_name          varchar(60) not null comment '组织名称',
    description          varchar(200) not null comment '描述',

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '组织信息';

/*==============================================================*/
/* Table: uaa_department                                        */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_department (
    id                   varchar(32) not null,
    parent_id            varchar(32) not null comment '父部门id',
    seq                  int not null comment '序号',
    level                int not null comment '部门层级',
    full_path            varchar(300) not null comment '部门全路径',
    department_code      varchar(30) not null comment '部门代码',
    department_name      varchar(60) not null comment '部门名称',
    description          varchar(200) not null comment '描述',

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '部门信息';

/*==============================================================*/
/* Table: uaa_department_position                               */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_department_position (
    id                   varchar(32) not null,
    department_id        varchar(32) not null,
    position_id          varchar(32) not null,

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '部门-岗位信息';

/*==============================================================*/
/* Table: uaa_position                                          */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_position (
    id                   varchar(32) not null,
    parent_id            varchar(32) not null comment '父岗位id',
    seq                  int not null comment '序号',
    level                int not null comment '岗位层级',
    full_path            varchar(300) not null comment '岗位全路径',
    position_code        varchar(30) not null comment '岗位代码',
    position_name        varchar(60) not null comment '岗位名称',
    description          varchar(200) not null comment '描述',

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '部门信息';

/*==============================================================*/
/* Table: uaa_user_position                                     */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_user_position (
    id                   varchar(32) not null,
    user_id             varchar(32) not null,
    position_id        varchar(32) not null,
    main_position      tinyint(1) comment '是否主岗 1：是 0：否',

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '用户-岗位信息';

/*==============================================================*/
/* Table: uaa_menu                                              */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_menu (
    id                   varchar(32) not null,
    parent_id            varchar(32) not null comment '父菜单id',
    seq                  int not null comment '序号',
    level                int not null comment '菜单层级',
    full_path            varchar(300) not null comment '菜单全路径',
    icon                 varchar(30) not null comment '菜单图标',
    menu_code            varchar(30) not null comment '菜单代码',
    menu_name            varchar(60) not null comment '菜单名称',
    description          varchar(200) not null comment '描述',

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '菜单信息';

/*==============================================================*/
/* Table: uaa_menu_role                                         */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_menu_role (
    id                   varchar(32) not null,
    menu_id              varchar(32) not null,
    role_id              varchar(32) not null,

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '菜单-角色信息';

/*==============================================================*/
/* Table: uaa_menu_element                                      */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_menu_element (
    id                   varchar(32) not null,
    parent_id            varchar(32) not null comment '父菜单id',
    seq                  int not null comment '序号',
    level                int not null comment '菜单层级',
    icon                 varchar(30) not null comment '菜单图标',
    menu_element_code    varchar(30) not null comment '菜单元素代码',
    menu_element_name    varchar(60) not null comment '菜单元素名称',
    description          varchar(200) not null comment '描述',

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '页面元素信息';

/*==============================================================*/
/* Table: uaa_menu_element_role                                 */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_menu_element_role (
    id                   varchar(32) not null,
    menu_element_id      varchar(32) not null,
    role_id              varchar(32) not null,

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '页面元素-角色息';

/*==============================================================*/
/* Table: uaa_operate                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_operate (
    id                   varchar(32) not null,
    seq                  int not null comment '序号',
    service_name         varchar(60) not null comment '服务名称',
    operate_type         varchar(30) not null comment '操作类型',
    operate_url          varchar(60) not null comment '操作url',
    operate_code         varchar(200) not null comment '操作代码',
    operate_name         varchar(60) not null comment '操作名称',
    operate_param        varchar(500) not null comment '参数',
    description          varchar(200) not null comment '描述',

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '操作信息';

/*==============================================================*/
/* Table: uaa_operate_permission                                */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_operate_permission (
    id                   varchar(32) not null,
    operate_id           varchar(32) not null,
    permission_id        varchar(32) not null,

    tenant_id            varchar(32) not null comment '租户id',
    office_code          varchar(100) not null comment '组织代码',
    created_by            varchar(100) not null comment '创建人',
    created_at          timestamp not null default current_timestamp comment '创建日期',
    updated_by            varchar(100) not null comment '更新人',
    updated_at          timestamp not null default current_timestamp comment '更新日期',
    is_deleted           tinyint(1) not null comment '是否删除 1：有效 0：无效',
    version              int not null comment '版本号',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '操作-权限息';
