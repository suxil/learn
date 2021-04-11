
DROP TABLE IF EXISTS `cdm_time_segment`;
CREATE TABLE `cdm_time_segment`  (
  `id` varchar(32) not null,
  `hour` varchar(255) COMMENT '时辰',
  `zodiac` varchar(255) COMMENT '生肖',
  `segment` varchar(255) COMMENT '小时片段',
  `description` varchar(255) COMMENT '描述',
  `tenant_id` varchar(32) comment '租户id',
  `office_code` varchar(100) comment '组织代码',
  `created_by` varchar(100) comment '创建人',
  `created_at` timestamp comment '创建日期',
  `updated_by` varchar(100) comment '更新人',
  `updated_at` timestamp comment '更新日期',
  `deleted` tinyint(1) default 0 comment '是否删除 1：是 0：否',
  `version` int default 0 comment '版本号',
  PRIMARY KEY (`id`)
);

ALTER TABLE `cdm_time_segment` COMMENT '时间片段';
