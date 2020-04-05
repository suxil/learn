/*==============================================================*/
/* Table: uaa_office                                            */
/*==============================================================*/
insert into uaa_office (id,parent_id,seq,level,full_path,office_name,description,tenant_id,office_code,created_by,created_at,updated_by,updated_at,deleted,version) values ("3b268e1424be11eab36902420aff0015", "", 1, 1, "9000", "集团总公司", "集团总公司", "1", "9000", "system", now(), "system", now(), 0, 0);

insert into uaa_office (id,parent_id,seq,level,full_path,office_name,description,tenant_id,office_code,created_by,created_at,updated_by,updated_at,deleted,version) values (REPLACE(UUID(), "-", ""), "3b268e1424be11eab36902420aff0015", 1, 2, "9000|1001", "武汉分公司", "武汉分公司", "1", "9000", "system", now(), "system", now(), 0, 0);
insert into uaa_office (id,parent_id,seq,level,full_path,office_name,description,tenant_id,office_code,created_by,created_at,updated_by,updated_at,deleted,version) values (REPLACE(UUID(), "-", ""), "3b268e1424be11eab36902420aff0015", 1, 2, "9000|2001", "成都分公司", "成都分公司", "1", "9000", "system", now(), "system", now(), 0, 0);
insert into uaa_office (id,parent_id,seq,level,full_path,office_name,description,tenant_id,office_code,created_by,created_at,updated_by,updated_at,deleted,version) values (REPLACE(UUID(), "-", ""), "3b268e1424be11eab36902420aff0015", 1, 2, "9000|3001", "西安分公司", "西安分公司", "1", "9000", "system", now(), "system", now(), 0, 0);
insert into uaa_office (id,parent_id,seq,level,full_path,office_name,description,tenant_id,office_code,created_by,created_at,updated_by,updated_at,deleted,version) values (REPLACE(UUID(), "-", ""), "3b268e1424be11eab36902420aff0015", 1, 2, "9000|4001", "北京分公司", "北京分公司", "1", "9000", "system", now(), "system", now(), 0, 0);
insert into uaa_office (id,parent_id,seq,level,full_path,office_name,description,tenant_id,office_code,created_by,created_at,updated_by,updated_at,deleted,version) values (REPLACE(UUID(), "-", ""), "3b268e1424be11eab36902420aff0015", 1, 2, "9000|5001", "重庆分公司", "重庆分公司", "1", "9000", "system", now(), "system", now(), 0, 0);
insert into uaa_office (id,parent_id,seq,level,full_path,office_name,description,tenant_id,office_code,created_by,created_at,updated_by,updated_at,deleted,version) values (REPLACE(UUID(), "-", ""), "3b268e1424be11eab36902420aff0015", 1, 2, "9000|6001", "合肥分公司", "合肥分公司", "1", "9000", "system", now(), "system", now(), 0, 0);

/*==============================================================*/
/* Table: uaa_department                                        */
/*==============================================================*/
insert into uaa_department(id,parent_id,parent_office_code,seq,level,full_path,department_code,department_name,description,tenant_id,office_code,created_by,created_at,updated_by,updated_at,deleted,version) values ("f48d26c324c511eab36902420aff0015", "", "9000", 1, 1, "900", "900", "总经理", "总经理", "1", "9000", "system", now(), "system", now(), 0, 0);

insert into uaa_department(id,parent_id,parent_office_code,seq,level,full_path,department_code,department_name,description,tenant_id,office_code,created_by,created_at,updated_by,updated_at,deleted,version) values ("3bfe40d824c611eab36902420aff0015", "f48d26c324c511eab36902420aff0015", "9000", 1, 2, "900|101", "101", "副总经理（行政）", "副总经理（行政）", "1", "9000", "system", now(), "system", now(), 0, 0);
insert into uaa_department(id,parent_id,parent_office_code,seq,level,full_path,department_code,department_name,description,tenant_id,office_code,created_by,created_at,updated_by,updated_at,deleted,version) values ("3c15f82024c611eab36902420aff0015", "f48d26c324c511eab36902420aff0015", "9000", 1, 2, "900|201", "201", "副总经理（营销）", "副总经理（营销）", "1", "9000", "system", now(), "system", now(), 0, 0);

insert into uaa_department(id,parent_id,parent_office_code,seq,level,full_path,department_code,department_name,description,tenant_id,office_code,created_by,created_at,updated_by,updated_at,deleted,version) values (REPLACE(UUID(), "-", ""), "3bfe40d824c611eab36902420aff0015", "9000", 1, 3, "900|101", "111", "财务部", "财务部", "1", "9000", "system", now(), "system", now(), 0, 0);
insert into uaa_department(id,parent_id,parent_office_code,seq,level,full_path,department_code,department_name,description,tenant_id,office_code,created_by,created_at,updated_by,updated_at,deleted,version) values (REPLACE(UUID(), "-", ""), "3bfe40d824c611eab36902420aff0015", "9000", 1, 3, "900|101", "112", "进出口部", "进出口部", "1", "9000", "system", now(), "system", now(), 0, 0);
insert into uaa_department(id,parent_id,parent_office_code,seq,level,full_path,department_code,department_name,description,tenant_id,office_code,created_by,created_at,updated_by,updated_at,deleted,version) values (REPLACE(UUID(), "-", ""), "3c15f82024c611eab36902420aff0015", "9000", 1, 3, "900|201", "211", "销售部", "销售部", "1", "9000", "system", now(), "system", now(), 0, 0);
insert into uaa_department(id,parent_id,parent_office_code,seq,level,full_path,department_code,department_name,description,tenant_id,office_code,created_by,created_at,updated_by,updated_at,deleted,version) values (REPLACE(UUID(), "-", ""), "3c15f82024c611eab36902420aff0015", "9000", 1, 3, "900|201", "212", "市场部", "市场部", "1", "9000", "system", now(), "system", now(), 0, 0);

/*==============================================================*/
/* Table: uaa_position                                          */
/*==============================================================*/

/*==============================================================*/
/* Table: uaa_user                                            */
/*==============================================================*/
insert into uaa_user(id, user_code, user_name, jp, login_name, password, mobile, email, is_admin, last_login_date, login_count, description, tenant_id, office_code, created_by, created_at, updated_by, updated_at, deleted, version) values (REPLACE(UUID(), "-", ""), "10001", "管理员", 'gly', 'admin', "$2a$10$kdx4NpGKUnMrVQVU37f08OHbMPfRuHfa.Csbf1iiF2oBzX9DBMUpa", "1321111111111", "admin@163.dom", 1, now(), 0, "管理员", "1", "9000", "system", now(), "system", now(), 0, 0);


