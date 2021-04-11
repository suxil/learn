
DROP TABLE IF EXISTS `cdm_dict_category`;
CREATE TABLE `cdm_dict_category`  (
  `id` varchar(32) not null,
  `parent_id` varchar(32) COMMENT '父节点id',
  `seq` int(11,0) COMMENT '序号',
  `category_code` varchar(10) COMMENT '类型代码',
  `category_name` varchar(60) COMMENT '类型名称',
  `remark` varchar(100) COMMENT '备注',
  `tenant_id` varchar(32) comment '租户id',
  `office_code` varchar(100) comment '组织代码',
  `created_by` varchar(100) comment '创建人',
  `created_at` timestamp default current_timestamp comment '创建日期',
  `updated_by` varchar(100) comment '更新人',
  `updated_at` timestamp default current_timestamp comment '更新日期',
  `deleted` tinyint(1) default 0 comment '是否删除 1：是 0：否',
  `version` int default 0 comment '版本号',
  PRIMARY KEY (`id`)
);

ALTER TABLE `cdm_dict_category` COMMENT '数据字典类型';
