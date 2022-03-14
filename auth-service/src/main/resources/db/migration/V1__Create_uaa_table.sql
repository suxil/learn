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
    user_code            varchar(60) comment '用户代码',
    user_name            varchar(60) comment '姓名',
    jp                   varchar(60) comment '简拼',
    login_name           varchar(60) comment '登录名',
    country              varchar(60) comment '国家',
    city                 varchar(60) comment '城市',
    operator             varchar(60) comment '运营商',
    login_ip             int(10) comment '登录ip',
    computer_name        varchar(30) comment '计算机名称',
    language             varchar(10) comment '语言',
    platform             varchar(10) comment '平台',
    user_agent           varchar(100) comment '浏览器',
    cookies              varchar(200) comment '登录cookie',

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '用户登录日志';

/*==============================================================*/
/* Table: uaa_user                                              */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_user (
    id                   varchar(32) not null,
    user_code            varchar(60) comment '用户代码',
    user_name            varchar(60) comment '姓名',
    jp                   varchar(60) comment '简拼',
    login_name           varchar(60) comment '登录名',
    password             varchar(200) comment '密码',
    mobile               varchar(30) comment '手机号',
    email                varchar(30) comment '邮箱',
    admin                tinyint(1) comment '是否超级管理员 1：是 0：否',
    last_login_date      timestamp default current_timestamp comment '上次登录日期',
    login_count          int comment '登录次数',
    description          varchar(200) comment '描述',

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '用户信息';

/*==============================================================*/
/* Table: uaa_role                                              */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_role (
    id                   varchar(32) not null,
    parent_id            varchar(32) comment '父角色id',
    seq                  int comment '序号',
    level                int comment '角色层级',
    full_path            varchar(300) comment '角色全路径',
    role_code            varchar(60) comment '角色代码',
    role_name            varchar(60) comment '角色名称',
    description          varchar(200) comment '描述',

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '角色信息';

/*==============================================================*/
/* Table: uaa_user_role                                         */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_user_role (
    id                   varchar(32) not null,
    user_id              varchar(32) not null,
    role_id              varchar(32) not null,

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '角色信息';

/*==============================================================*/
/* Table: uaa_permission                                        */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_permission (
    id                   varchar(32) not null,
    parent_id            varchar(32) comment '父权限id',
    seq                  int comment '序号',
    permission_code      varchar(200) comment '权限代码',
    permission_name      varchar(60) comment '权限名称',
    permission_type      varchar(30) comment '权限类型',
    description          varchar(200) comment '描述',

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '权限信息';

/*==============================================================*/
/* Table: uaa_user_permission                                   */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_user_permission (
    id                   varchar(32) not null,
    user_id              varchar(32) not null,
    permission_id        varchar(32) not null,

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '用户-权限信息';

/*==============================================================*/
/* Table: uaa_role_permission                                   */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_role_permission (
    id                   varchar(32) not null,
    role_id              varchar(32) not null,
    permission_id        varchar(32) not null,

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '角色-权限信息';

/*==============================================================*/
/* Table: uaa_group                                             */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_group (
    id                   varchar(32) not null,
    parent_id            varchar(32) comment '父组id',
    seq                  int comment '序号',
    level                int comment '组层级',
    full_path            varchar(300) comment '组全路径',
    group_code           varchar(60) comment '组代码',
    group_name           varchar(60) comment '组名称',
    description          varchar(200) comment '描述',

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '组信息';

/*==============================================================*/
/* Table: uaa_group_user                                        */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_group_user (
    id                   varchar(32) not null,
    group_id             varchar(32) not null,
    user_id              varchar(32) not null,

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '组-用户信息';

/*==============================================================*/
/* Table: uaa_group_role                                        */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_group_role (
    id                   varchar(32) not null,
    group_id             varchar(32) not null,
    role_id              varchar(32) not null,

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '组-角色信息';

/*==============================================================*/
/* Table: uaa_group_permission                                  */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_group_permission (
    id                   varchar(32) not null,
    group_id             varchar(32) not null,
    permission_id        varchar(32) not null,

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '组-权限信息';

/*==============================================================*/
/* Table: uaa_office                                            */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_office (
    id                   varchar(32) not null,
    parent_id            varchar(32) comment '父组织id',
    seq                  int comment '序号',
    level                int comment '组织层级',
    full_path            varchar(300) comment '组织全路径',
    office_name          varchar(60) comment '组织名称',
    description          varchar(200) comment '描述',

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '组织信息';

/*==============================================================*/
/* Table: uaa_department                                        */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_department (
    id                   varchar(32) not null,
    parent_id            varchar(32) comment '父部门id',
    seq                  int comment '序号',
    level                int comment '部门层级',
    full_path            varchar(300) comment '部门全路径',
    department_code      varchar(30) comment '部门代码',
    department_name      varchar(60) comment '部门名称',
    description          varchar(200) comment '描述',

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '部门信息';

/*==============================================================*/
/* Table: uaa_department_position                               */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_department_position (
    id                   varchar(32) not null,
    department_id        varchar(32) not null,
    position_id          varchar(32) not null,

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '部门-岗位信息';

/*==============================================================*/
/* Table: uaa_position                                          */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_position (
    id                   varchar(32) not null,
    parent_id            varchar(32) comment '父岗位id',
    seq                  int comment '序号',
    level                int comment '岗位层级',
    full_path            varchar(300) comment '岗位全路径',
    position_code        varchar(30) comment '岗位代码',
    position_name        varchar(60) comment '岗位名称',
    description          varchar(200) comment '描述',

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '岗位信息';

/*==============================================================*/
/* Table: uaa_user_position                                     */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_user_position (
    id                   varchar(32) not null,
    user_id             varchar(32) not null,
    position_id        varchar(32) not null,
    main_position      tinyint(1) comment '是否主岗 1：是 0：否',

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '用户-岗位信息';

/*==============================================================*/
/* Table: uaa_menu                                              */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_menu (
    id                   varchar(32) not null,
    parent_id            varchar(32) comment '父菜单id',
    seq                  int comment '序号',
    level                int comment '菜单层级',
    full_path            varchar(300) comment '菜单全路径',
    icon                 varchar(30) comment '菜单图标',
    menu_code            varchar(30) comment '菜单代码',
    menu_name            varchar(60) comment '菜单名称',
    description          varchar(200) comment '描述',

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '菜单信息';

/*==============================================================*/
/* Table: uaa_menu_role                                         */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_menu_role (
    id                   varchar(32) not null,
    menu_id              varchar(32) not null,
    role_id              varchar(32) not null,

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '菜单-角色信息';

/*==============================================================*/
/* Table: uaa_menu_element                                      */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_menu_element (
    id                   varchar(32) not null,
    menu_id              varchar(32) comment '菜单id',
    seq                  int comment '序号',
    menu_element_code    varchar(30) comment '菜单元素代码',
    menu_element_name    varchar(60) comment '菜单元素名称',
    description          varchar(200) comment '描述',

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '菜单页面元素信息';

/*==============================================================*/
/* Table: uaa_menu_element_role                                 */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_menu_element_role (
    id                   varchar(32) not null,
    menu_element_id      varchar(32) not null,
    role_id              varchar(32) not null,

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '菜单菜单页面元素-角色息';

/*==============================================================*/
/* Table: uaa_operate                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_operate (
    id                   varchar(32) not null,
    seq                  int comment '序号',
    service_name         varchar(60) comment '服务名称',
    operate_type         varchar(30) comment '操作类型',
    operate_url          varchar(60) comment '操作url',
    operate_code         varchar(200) comment '操作代码',
    operate_name         varchar(60) comment '操作名称',
    operate_param        varchar(500) comment '参数',
    description          varchar(200) comment '描述',

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '操作信息';

/*==============================================================*/
/* Table: uaa_operate_permission                                */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS uaa_operate_permission (
    id                   varchar(32) not null,
    operate_id           varchar(32) not null,
    permission_id        varchar(32) not null,

    tenant_id            varchar(32) comment '租户id',
    office_code          varchar(100) comment '组织代码',
    created_by            varchar(100) comment '创建人',
    created_at          timestamp comment '创建日期',
    updated_by            varchar(100) comment '更新人',
    updated_at          timestamp comment '更新日期',
    deleted           tinyint(1) comment '是否删除 1：是 0：否',
    version              int comment '版本号'
) ENGINE = InnoDB DEFAULT CHARSET=utf8 comment '操作-权限息';

/* primary key index */
ALTER TABLE uaa_user_login_log ADD PRIMARY KEY (id);
ALTER TABLE uaa_user ADD PRIMARY KEY (id);
ALTER TABLE uaa_role ADD PRIMARY KEY (id);
ALTER TABLE uaa_user_role ADD PRIMARY KEY (id);
ALTER TABLE uaa_permission ADD PRIMARY KEY (id);
ALTER TABLE uaa_user_permission ADD PRIMARY KEY (id);
ALTER TABLE uaa_role_permission ADD PRIMARY KEY (id);
ALTER TABLE uaa_group ADD PRIMARY KEY (id);
ALTER TABLE uaa_group_user ADD PRIMARY KEY (id);
ALTER TABLE uaa_group_role ADD PRIMARY KEY (id);
ALTER TABLE uaa_group_permission ADD PRIMARY KEY (id);
ALTER TABLE uaa_office ADD PRIMARY KEY (id);
ALTER TABLE uaa_department ADD PRIMARY KEY (id);
ALTER TABLE uaa_department_position ADD PRIMARY KEY (id);
ALTER TABLE uaa_position ADD PRIMARY KEY (id);
ALTER TABLE uaa_user_position ADD PRIMARY KEY (id);
ALTER TABLE uaa_menu ADD PRIMARY KEY (id);
ALTER TABLE uaa_menu_role ADD PRIMARY KEY (id);
ALTER TABLE uaa_menu_element ADD PRIMARY KEY (id);
ALTER TABLE uaa_menu_element_role ADD PRIMARY KEY (id);
ALTER TABLE uaa_operate ADD PRIMARY KEY (id);
ALTER TABLE uaa_operate_permission ADD PRIMARY KEY (id);

/* tenant_id index */
CREATE INDEX idx_uaa_user_login_log_tenant_id ON uaa_user_login_log(tenant_id);
CREATE INDEX idx_uaa_user_tenant_id ON uaa_user(tenant_id);
CREATE INDEX idx_uaa_role_tenant_id ON uaa_role(tenant_id);
CREATE INDEX idx_uaa_user_role_tenant_id ON uaa_user_role(tenant_id);
CREATE INDEX idx_uaa_permission_tenant_id ON uaa_permission(tenant_id);
CREATE INDEX idx_uaa_user_permission_tenant_id ON uaa_user_permission(tenant_id);
CREATE INDEX idx_uaa_role_permission_tenant_id ON uaa_role_permission(tenant_id);
CREATE INDEX idx_uaa_group_tenant_id ON uaa_group(tenant_id);
CREATE INDEX idx_uaa_group_user_tenant_id ON uaa_group_user(tenant_id);
CREATE INDEX idx_uaa_group_role_tenant_id ON uaa_group_role(tenant_id);
CREATE INDEX idx_uaa_group_permission_tenant_id ON uaa_group_permission(tenant_id);
CREATE INDEX idx_uaa_office_tenant_id ON uaa_office(tenant_id);
CREATE INDEX idx_uaa_department_tenant_id ON uaa_department(tenant_id);
CREATE INDEX idx_uaa_department_position_tenant_id ON uaa_department_position(tenant_id);
CREATE INDEX idx_uaa_position_tenant_id ON uaa_position(tenant_id);
CREATE INDEX idx_uaa_user_position_tenant_id ON uaa_user_position(tenant_id);
CREATE INDEX idx_uaa_menu_tenant_id ON uaa_menu(tenant_id);
CREATE INDEX idx_uaa_menu_role_tenant_id ON uaa_menu_role(tenant_id);
CREATE INDEX idx_uaa_menu_element_tenant_id ON uaa_menu_element(tenant_id);
CREATE INDEX idx_uaa_menu_element_role_tenant_id ON uaa_menu_element_role(tenant_id);
CREATE INDEX idx_uaa_operate_tenant_id ON uaa_operate(tenant_id);
CREATE INDEX idx_uaa_operate_permission_tenant_id ON uaa_operate_permission(tenant_id);

/* office_code index */
CREATE INDEX idx_uaa_user_login_log_office_code ON uaa_user_login_log(office_code);
CREATE INDEX idx_uaa_user_office_code ON uaa_user(office_code);
CREATE INDEX idx_uaa_role_office_code ON uaa_role(office_code);
CREATE INDEX idx_uaa_user_role_office_code ON uaa_user_role(office_code);
CREATE INDEX idx_uaa_permission_office_code ON uaa_permission(office_code);
CREATE INDEX idx_uaa_user_permission_office_code ON uaa_user_permission(office_code);
CREATE INDEX idx_uaa_role_permission_office_code ON uaa_role_permission(office_code);
CREATE INDEX idx_uaa_group_office_code ON uaa_group(office_code);
CREATE INDEX idx_uaa_group_user_office_code ON uaa_group_user(office_code);
CREATE INDEX idx_uaa_group_role_office_code ON uaa_group_role(office_code);
CREATE INDEX idx_uaa_group_permission_office_code ON uaa_group_permission(office_code);
CREATE INDEX idx_uaa_office_office_code ON uaa_office(office_code);
CREATE INDEX idx_uaa_department_office_code ON uaa_department(office_code);
CREATE INDEX idx_uaa_department_position_office_code ON uaa_department_position(office_code);
CREATE INDEX idx_uaa_position_office_code ON uaa_position(office_code);
CREATE INDEX idx_uaa_user_position_office_code ON uaa_user_position(office_code);
CREATE INDEX idx_uaa_menu_office_code ON uaa_menu(office_code);
CREATE INDEX idx_uaa_menu_role_office_code ON uaa_menu_role(office_code);
CREATE INDEX idx_uaa_menu_element_office_code ON uaa_menu_element(office_code);
CREATE INDEX idx_uaa_menu_element_role_office_code ON uaa_menu_element_role(office_code);
CREATE INDEX idx_uaa_operate_office_code ON uaa_operate(office_code);
CREATE INDEX idx_uaa_operate_permission_office_code ON uaa_operate_permission(office_code);

/* deleted index */
CREATE INDEX idx_uaa_user_login_log_deleted ON uaa_user_login_log(deleted);
CREATE INDEX idx_uaa_user_deleted ON uaa_user(deleted);
CREATE INDEX idx_uaa_role_deleted ON uaa_role(deleted);
CREATE INDEX idx_uaa_user_role_deleted ON uaa_user_role(deleted);
CREATE INDEX idx_uaa_permission_deleted ON uaa_permission(deleted);
CREATE INDEX idx_uaa_user_permission_deleted ON uaa_user_permission(deleted);
CREATE INDEX idx_uaa_role_permission_deleted ON uaa_role_permission(deleted);
CREATE INDEX idx_uaa_group_deleted ON uaa_group(deleted);
CREATE INDEX idx_uaa_group_user_deleted ON uaa_group_user(deleted);
CREATE INDEX idx_uaa_group_role_deleted ON uaa_group_role(deleted);
CREATE INDEX idx_uaa_group_permission_deleted ON uaa_group_permission(deleted);
CREATE INDEX idx_uaa_office_deleted ON uaa_office(deleted);
CREATE INDEX idx_uaa_department_deleted ON uaa_department(deleted);
CREATE INDEX idx_uaa_department_position_deleted ON uaa_department_position(deleted);
CREATE INDEX idx_uaa_position_deleted ON uaa_position(deleted);
CREATE INDEX idx_uaa_user_position_deleted ON uaa_user_position(deleted);
CREATE INDEX idx_uaa_menu_deleted ON uaa_menu(deleted);
CREATE INDEX idx_uaa_menu_role_deleted ON uaa_menu_role(deleted);
CREATE INDEX idx_uaa_menu_element_deleted ON uaa_menu_element(deleted);
CREATE INDEX idx_uaa_menu_element_role_deleted ON uaa_menu_element_role(deleted);
CREATE INDEX idx_uaa_operate_deleted ON uaa_operate(deleted);
CREATE INDEX idx_uaa_operate_permission_deleted ON uaa_operate_permission(deleted);

/* other index */
CREATE INDEX idx_uaa_user_login_log_user_code ON uaa_user_login_log(user_code);

CREATE INDEX idx_uaa_user_user_code ON uaa_user(user_code);
CREATE INDEX idx_uaa_user_login_name ON uaa_user(login_name);
CREATE INDEX idx_uaa_user_mobile ON uaa_user(mobile);
CREATE INDEX idx_uaa_user_email ON uaa_user(email);

CREATE INDEX idx_uaa_role_role_code ON uaa_role(role_code);
CREATE INDEX idx_uaa_role_parent_id ON uaa_role(parent_id);
CREATE INDEX idx_uaa_role_full_path ON uaa_role(full_path);

CREATE INDEX idx_uaa_user_role_user_id ON uaa_user_role(user_id);
CREATE INDEX idx_uaa_user_role_role_id ON uaa_user_role(role_id);

CREATE INDEX idx_uaa_permission_permission_code ON uaa_permission(permission_code);
CREATE INDEX idx_uaa_permission_parent_id ON uaa_permission(parent_id);

CREATE INDEX idx_uaa_user_permission_user_id ON uaa_user_permission(user_id);
CREATE INDEX idx_uaa_user_permission_permission_id ON uaa_user_permission(permission_id);

CREATE INDEX idx_uaa_role_permission_role_id ON uaa_role_permission(role_id);
CREATE INDEX idx_uaa_role_permission_permission_id ON uaa_role_permission(permission_id);

CREATE INDEX idx_uaa_group_group_code ON uaa_group(group_code);
CREATE INDEX idx_uaa_group_parent_id ON uaa_group(parent_id);
CREATE INDEX idx_uaa_group_full_path ON uaa_group(full_path);

CREATE INDEX idx_uaa_group_user_group_id ON uaa_group_user(group_id);
CREATE INDEX idx_uaa_group_user_user_id ON uaa_group_user(user_id);

CREATE INDEX idx_uaa_group_role_group_id ON uaa_group_role(group_id);
CREATE INDEX idx_uaa_group_role_role_id ON uaa_group_role(role_id);

CREATE INDEX idx_uaa_group_permission_group_id ON uaa_group_permission(group_id);
CREATE INDEX idx_uaa_group_permission_permission_id ON uaa_group_permission(permission_id);

CREATE INDEX idx_uaa_office_parent_id ON uaa_office(parent_id);
CREATE INDEX idx_uaa_office_full_path ON uaa_office(full_path);

CREATE INDEX idx_uaa_department_department_code ON uaa_department(department_code);
CREATE INDEX idx_uaa_department_parent_id ON uaa_department(parent_id);
CREATE INDEX idx_uaa_department_full_path ON uaa_department(full_path);

CREATE INDEX idx_uaa_department_position_department_id ON uaa_department_position(department_id);
CREATE INDEX idx_uaa_department_position_position_id ON uaa_department_position(position_id);

CREATE INDEX idx_uaa_position_position_code ON uaa_position(position_code);
CREATE INDEX idx_uaa_position_parent_id ON uaa_position(parent_id);
CREATE INDEX idx_uaa_position_full_path ON uaa_position(full_path);

CREATE INDEX idx_uaa_user_position_user_id ON uaa_user_position(user_id);
CREATE INDEX idx_uaa_user_position_position_id ON uaa_user_position(position_id);

CREATE INDEX idx_uaa_menu_menu_code ON uaa_menu(menu_code);
CREATE INDEX idx_uaa_menu_parent_id ON uaa_menu(parent_id);
CREATE INDEX idx_uaa_menu_full_path ON uaa_menu(full_path);

CREATE INDEX idx_uaa_menu_role_menu_id ON uaa_menu_role(menu_id);
CREATE INDEX idx_uaa_menu_role_role_id ON uaa_menu_role(role_id);

CREATE INDEX idx_uaa_menu_element_menu_id ON uaa_menu_element(menu_id);

CREATE INDEX idx_uaa_menu_element_role_menu_element_id ON uaa_menu_element_role(menu_element_id);
CREATE INDEX idx_uaa_menu_element_role_role_id ON uaa_menu_element_role(role_id);

CREATE INDEX idx_uaa_operate_operate_code ON uaa_operate(operate_code);
CREATE INDEX idx_uaa_operate_permission_operate_id ON uaa_operate_permission(operate_id);
CREATE INDEX idx_uaa_operate_permission_permission_id ON uaa_operate_permission(permission_id);

/* unique index */
ALTER TABLE uaa_user ADD CONSTRAINT uk_uaa_user_user_code UNIQUE (user_code);
ALTER TABLE uaa_user ADD CONSTRAINT uk_uaa_user_login_name UNIQUE (login_name);
ALTER TABLE uaa_user ADD CONSTRAINT uk_uaa_user_mobile UNIQUE (mobile);
ALTER TABLE uaa_user ADD CONSTRAINT uk_uaa_user_email UNIQUE (email);
