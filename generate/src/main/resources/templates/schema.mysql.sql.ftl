
DROP TABLE IF EXISTS `${table.name}`;
CREATE TABLE `${table.name}`  (
  `id` varchar(32) not null,
<#list table.fields as field>
  `${field.name}` ${field.type} COMMENT '${field.comment}',
</#list>
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

ALTER TABLE `${table.name}` COMMENT '${table.comment}';
