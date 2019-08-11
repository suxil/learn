/* ============================================================== CDM ============================================================== */

/*==============================================================*/
/* Table: cdm_dict                                              */
/*==============================================================*/
create table cdm_dict
(
   id                   varchar(32) not null,
   seq                  numeric(11,0) comment '序号',
   category             varchar(20) comment '类别',
   dict_code            varchar(10) comment '代码',
   dict_name            varchar(60) comment '名称',
   remark               varchar(100) comment '备注',

   office_code         varchar(100) comment '组织机构',
   create_by            varchar(100) comment '创建人',
   create_date         timestamp comment '创建日期',
   update_by            varchar(100) comment '更新人',
   update_date         timestamp comment '更新日期',
   is_deleted          int comment '是否删除',
   version             int comment '版本号',
   primary key (id)
);

alter table cdm_dict comment '数据字典';

/*==============================================================*/
/* Table: cdm_time_segment                                      */
/*==============================================================*/
create table cdm_time_segment
(
   id                   varchar(32) not null,
   hour                 varchar(255) comment '时辰',
   zodiac               varchar(255) comment '生肖',
   segment              varchar(255) comment '小时片段',
   description          varchar(255) comment '描述',

   office_code         varchar(100) comment '组织机构',
   create_by            varchar(100) comment '创建人',
   create_date         timestamp comment '创建日期',
   update_by            varchar(100) comment '更新人',
   update_date         timestamp comment '更新日期',
   is_deleted          int comment '是否删除',
   version             int comment '版本号',
   primary key (id)
);

alter table cdm_time_segment comment '时间片段';

/* ============================================================== TEM ============================================================== */

/*==============================================================*/
/* Table: tem_self_record                                       */
/*==============================================================*/
create table tem_self_record
(
   id                   varchar(32) not null,
   content              varchar(255) comment '内容',

   office_code         varchar(100) comment '组织机构',
   create_by            varchar(100) comment '创建人',
   create_date         timestamp comment '创建日期',
   update_by            varchar(100) comment '更新人',
   update_date         timestamp comment '更新日期',
   is_deleted          int comment '是否删除',
   version             int comment '版本号',
   primary key (id)
);

alter table tem_self_record comment '自己的生活记录';

/*==============================================================*/
/* Table: tem_work_log                                          */
/*==============================================================*/
create table tem_work_log
(
   id                   varchar(32) not null,
   category             varchar(20) comment '类别',
   work_date            datetime comment '工作日期',
   work_hours           numeric(11,0) comment '工作小时数',
   start_date           datetime comment '开始日期',
   end_date             datetime comment '结束日期',
   note_taker           varchar(255) comment '工作人',
   content              varchar(255) comment '工作内容',

   office_code         varchar(100) comment '组织机构',
   create_by            varchar(100) comment '创建人',
   create_date         timestamp comment '创建日期',
   update_by            varchar(100) comment '更新人',
   update_date         timestamp comment '更新日期',
   is_deleted          int comment '是否删除',
   version             int comment '版本号',
   primary key (id)
);

alter table tem_work_log comment '工作日志';

/* ============================================================== UAA ============================================================== */

/* ============================================================== ZYJ ============================================================== */

/*==============================================================*/
/* Table: zyj_sixty_four_gua                                    */
/*==============================================================*/
create table zyj_sixty_four_gua
(
   id                   varchar(32) not null,
   seq                  numeric(11,0) comment '卦序',
   up_seq               numeric(11,0) comment '上卦卦序',
   up_name              varchar(10) comment '上卦卦名',
   down_seq             numeric(11,0) comment '下卦卦序',
   down_name            varchar(10) comment '下卦卦名',
   gua_name             varchar(10) comment '卦名',
   gua_yi               varchar(10) comment '卦的含义',
   gua_note             varchar(500) comment '解释',
   gua_qian             varchar(10) comment '卦签',
   gua_chi              varchar(100) comment '卦辞',
   gua_chi_note         varchar(500) comment '卦辞解释',
   xiang_yue            varchar(100) comment '象辞',
   xiang_yue_note       varchar(500) comment '象辞解释',
   tuan_yue             varchar(100) comment '彖传',
   tuan_yue_note        varchar(500) comment '彖传解释',
   qi_shi               varchar(500) comment '启示',

   office_code         varchar(100) comment '组织机构',
   create_by            varchar(100) comment '创建人',
   create_date         timestamp comment '创建日期',
   update_by            varchar(100) comment '更新人',
   update_date         timestamp comment '更新日期',
   is_deleted          int comment '是否删除',
   version             int comment '版本号',
   primary key (id)
);

alter table zyj_sixty_four_gua comment '六十四卦';

/*==============================================================*/
/* Table: zyj_sixty_four_gua_item                               */
/*==============================================================*/
create table zyj_sixty_four_gua_item
(
   id                   varchar(32) not null,
   sixty_four_gua_id    varchar(32),
   seq                  numeric(11,0) comment '爻序',
   yao_name             varchar(10) comment '爻名',
   yao_chi              varchar(100) comment '爻辞',
   yao_chi_note         varchar(500) comment '爻辞解释',
   xiang_yue            varchar(100) comment '象辞',
   xiang_yue_note       varchar(500) comment '象辞解释',

   office_code         varchar(100) comment '组织机构',
   create_by            varchar(100) comment '创建人',
   create_date         timestamp comment '创建日期',
   update_by            varchar(100) comment '更新人',
   update_date         timestamp comment '更新日期',
   is_deleted          int comment '是否删除',
   version             int comment '版本号',
   primary key (id)
);

alter table zyj_sixty_four_gua_item comment '六十四卦爻信息';