SET MODE MYSQL;

CREATE ALIAS IF NOT EXISTS NOW FOR "com.dj.bms.common.dao.jdbc.h2.H2DatabaseFunctionExt.NOW";

CREATE ALIAS IF NOT EXISTS TO_DAYS FOR "com.dj.bms.common.dao.jdbc.h2.H2DatabaseFunctionExt.TO_DAYS";

CREATE TABLE IF NOT EXISTS admin_user (
  admin_user_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(255) NOT NULL DEFAULT '',
  password varchar(255) NOT NULL DEFAULT '',
  avatar varchar(255) DEFAULT NULL ,
  create_date datetime NOT NULL,
  update_date datetime DEFAULT NULL,
  PRIMARY KEY (admin_user_id),
  UNIQUE KEY uk_admin_user_username0 (username) USING BTREE
);

CREATE TABLE IF NOT EXISTS role (
  role_id int(11) NOT NULL AUTO_INCREMENT,
  role_name varchar(255) NOT NULL DEFAULT '',
  create_date datetime DEFAULT NULL,
  update_date datetime DEFAULT NULL,
  PRIMARY KEY (role_id),
  UNIQUE KEY uk_role_role_name1 (role_name) USING BTREE
);

CREATE TABLE IF NOT EXISTS permission (
  permission_id int(11) NOT NULL AUTO_INCREMENT,
  permission_name varchar(255) NOT NULL DEFAULT '',
  permission_value varchar(255) NOT NULL DEFAULT '',
  pid int(11) NOT NULL DEFAULT '0',
  create_date datetime DEFAULT NULL,
  update_date datetime DEFAULT NULL,
  PRIMARY KEY (permission_id),
  UNIQUE KEY permission_name_uk2 (permission_name),
  UNIQUE KEY permission_value_uk3 (permission_value)
);

CREATE TABLE IF NOT EXISTS admin_user_role_rel (
  admin_user_role_rel_id int(11) NOT NULL AUTO_INCREMENT,
  admin_user_id int(11) NOT NULL,
  role_id int(11) NOT NULL,
  create_date datetime DEFAULT NULL,
  update_date datetime DEFAULT NULL,
  PRIMARY KEY (admin_user_role_rel_id),
  KEY key_admin_user_role_rel_role_id4 (role_id) USING BTREE,
  KEY key_admin_user_role_rel_admin_user_id5 (admin_user_id) USING BTREE,
  CONSTRAINT fk_admin_user_role_rel_admin_user_id FOREIGN KEY (admin_user_id) REFERENCES admin_user (admin_user_id),
  CONSTRAINT fk_admin_user_role_rel_role_id FOREIGN KEY (role_id) REFERENCES role (role_id)
);

CREATE TABLE IF NOT EXISTS role_permission_rel (
  role_permission_rel_id int(11) NOT NULL AUTO_INCREMENT,
  role_id int(11) NOT NULL,
  permission_id int(11) NOT NULL,
  create_date datetime DEFAULT NULL,
  update_date datetime DEFAULT NULL,
  PRIMARY KEY (role_permission_rel_id),
  KEY key_role_permission_rel_role_id8 (role_id) USING BTREE,
  KEY key_role_permission_rel_permission_id9 (permission_id) USING BTREE,
  CONSTRAINT fk_role_permission_rel_permission_id FOREIGN KEY (permission_id) REFERENCES permission (permission_id),
  CONSTRAINT fk_role_permission_rel_role_id FOREIGN KEY (role_id) REFERENCES role (role_id)
);

CREATE TABLE IF NOT EXISTS collect (
  id int(11) NOT NULL AUTO_INCREMENT ,
  uid int(11) DEFAULT NULL ,
  tid int(11) DEFAULT NULL ,
  create_date datetime DEFAULT NULL ,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS follow (
  id int(11) NOT NULL AUTO_INCREMENT ,
  uid int(11) DEFAULT NULL ,
  fid int(11) DEFAULT NULL ,
  create_date datetime DEFAULT NULL ,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS node (
  node_id int(11) NOT NULL AUTO_INCREMENT ,
  node_code varchar(50)  NOT NULL ,
  node_title varchar(50)  NOT NULL ,
  avatar_normal varchar(250)  DEFAULT NULL ,
  avatar_mini varchar(250)  DEFAULT NULL ,
  avatar_large varchar(250)  DEFAULT NULL ,
  node_desc varchar(2000)  DEFAULT NULL ,
  tab_id int(11) DEFAULT NULL ,
  url varchar(50)  DEFAULT NULL ,
  parent_node_id varchar(50) DEFAULT NULL ,
  create_date datetime DEFAULT NULL ,
  update_date datetime DEFAULT NULL ,
  is_delete tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (node_id),
  UNIQUE KEY uk_node_title12 (node_title),
  KEY key_node_code13 (node_code)
);

CREATE TABLE IF NOT EXISTS node_tab (
  node_tab_id int(11) NOT NULL AUTO_INCREMENT ,
  node_tab_code varchar(45) DEFAULT NULL ,
  node_tab_title varchar(45) DEFAULT NULL ,
  node_tab_desc varchar(300) DEFAULT NULL ,
  is_delete tinyint(1) DEFAULT NULL ,
  node_tab_order int(11) DEFAULT NULL ,
  create_date datetime DEFAULT NULL ,
  update_date datetime DEFAULT NULL ,
  PRIMARY KEY (node_tab_id)
);

CREATE TABLE IF NOT EXISTS notice (
  notice_id int(11) NOT NULL AUTO_INCREMENT ,
  notice_title varchar(200) DEFAULT '' ,
  is_read tinyint(1) DEFAULT NULL ,
  notice_author_id int(11) DEFAULT NULL ,
  notice_author_name varchar(50) NOT NULL DEFAULT '' ,
  target_author_id int(11) DEFAULT NULL ,
  target_author_name varchar(50) NOT NULL DEFAULT '' ,
  create_date datetime DEFAULT NULL ,
  update_date datetime DEFAULT NULL ,
  notice_action varchar(255) NOT NULL DEFAULT '' ,
  topic_id int(11) DEFAULT NULL ,
  topic_author_id int(11) DEFAULT NULL ,
  topic_section_id int(11) DEFAULT NULL ,
  notice_content longtext ,
  status_cd varchar(4) DEFAULT NULL ,
  PRIMARY KEY (notice_id)
);

CREATE TABLE IF NOT EXISTS reply (
  reply_id int(11) NOT NULL AUTO_INCREMENT ,
  topic_id int(11) DEFAULT NULL ,
  topic_author_id int(11) DEFAULT NULL ,
  reply_content longtext ,
  create_date datetime DEFAULT NULL ,
  update_date datetime DEFAULT NULL ,
  reply_author_id int(11) DEFAULT NULL ,
  reply_author_name varchar(50) DEFAULT NULL ,
  is_delete tinyint(1) DEFAULT '0' ,
  is_read tinyint(1) DEFAULT '0' ,
  is_show tinyint(1) DEFAULT '0' ,
  reply_good_count int(10) DEFAULT '0' ,
  reply_bad_count int(10) DEFAULT '0' ,
  reply_type varchar(16) DEFAULT NULL ,
  reply_read_count int(11) DEFAULT NULL ,
  status_cd varchar(4) DEFAULT '1000' ,
  PRIMARY KEY (reply_id),
  KEY key_topic_id14 (topic_id),
  KEY key_reply_author_name15 (reply_author_name)
);

CREATE TABLE IF NOT EXISTS system_config (
  system_config_id int(11) unsigned NOT NULL AUTO_INCREMENT,
  key varchar(255) DEFAULT NULL,
  value varchar(255) DEFAULT NULL,
  description varchar(1000) NOT NULL,
  pid int(11) NOT NULL DEFAULT '0',
  type varchar(255) DEFAULT NULL,
  option varchar(255) DEFAULT NULL,
  reboot int(11) NOT NULL DEFAULT '0',
  is_delete tinyint(1) DEFAULT '0' ,
  PRIMARY KEY (system_config_id)
);

CREATE TABLE IF NOT EXISTS tab (
  id int(11) NOT NULL AUTO_INCREMENT ,
  tab_name varchar(50)  DEFAULT NULL ,
  tab_desc varchar(250)  DEFAULT NULL ,
  is_delete tinyint(1) DEFAULT NULL ,
  create_date datetime DEFAULT NULL ,
  tab_order int(2) DEFAULT NULL ,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS topic (
  topic_id int(11) NOT NULL AUTO_INCREMENT ,
  ptab varchar(50) DEFAULT NULL ,
  tab varchar(50) DEFAULT NULL ,
  title varchar(250) NOT NULL ,
  tag varchar(250) DEFAULT NULL ,
  content longtext ,
  excerpt varchar(500) DEFAULT NULL ,
  create_date datetime DEFAULT NULL ,
  update_date datetime DEFAULT NULL ,
  last_reply_time datetime DEFAULT NULL ,
  last_reply_author varchar(50) DEFAULT NULL ,
  view_count int(11) DEFAULT '0' ,
  author varchar(50) DEFAULT NULL ,
  top tinyint(1) DEFAULT '0' ,
  good tinyint(1) DEFAULT '0' ,
  show_status tinyint(1) DEFAULT NULL ,
  reply_count int(11) NOT NULL DEFAULT '0' ,
  is_delete tinyint(1) DEFAULT '0' ,
  tag_is_count int(1) DEFAULT '0' ,
  post_good_count int(10) DEFAULT '0' ,
  post_bad_count int(10) DEFAULT '0' ,
  status_cd varchar(4) DEFAULT NULL ,
  node_slug varchar(50) DEFAULT NULL ,
  node_title varchar(50) DEFAULT NULL ,
  remark varchar(2000) DEFAULT NULL ,
  avatar varchar(250) DEFAULT NULL ,
  url varchar(250) DEFAULT NULL ,
  PRIMARY KEY (topic_id),
  KEY key_tab16 (tab),
  KEY key_author17 (author),
  KEY key_node_title18 (node_title)
);

CREATE TABLE IF NOT EXISTS up_down (
  id int(11) NOT NULL AUTO_INCREMENT ,
  uid int(11) DEFAULT NULL ,
  tid int(11) DEFAULT NULL ,
  up_down tinyint(1) DEFAULT NULL ,
  create_date datetime DEFAULT NULL ,
  is_delete tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user (
  user_id int(11) NOT NULL AUTO_INCREMENT ,
  user_name varchar(50) NOT NULL ,
  password varchar(250) NOT NULL ,
  user_sex varchar(10) DEFAULT NULL ,
  user_addr varchar(250) DEFAULT NULL ,
  score int(11) DEFAULT NULL ,
  avatar varchar(255) DEFAULT NULL ,
  email varchar(255) DEFAULT NULL ,
  url varchar(255) DEFAULT NULL ,
  signature varchar(1000) DEFAULT NULL ,
  third_id varchar(50) DEFAULT NULL ,
  receive_msg tinyint(1) DEFAULT NULL ,
  create_date datetime DEFAULT NULL ,
  update_date datetime DEFAULT NULL ,
  is_locked tinyint(1) DEFAULT NULL ,
  third_access_token varchar(50) DEFAULT NULL ,
  status_cd varchar(4) DEFAULT NULL ,
  login_ip varchar(20) DEFAULT NULL ,
  last_login_ip varchar(20) DEFAULT NULL ,
  user_type int(2) DEFAULT NULL ,
  remark varchar(2000) DEFAULT NULL ,
  PRIMARY KEY (user_id),
  UNIQUE KEY UNIQUE_NAME19 (user_name) USING BTREE
);

CREATE TABLE IF NOT EXISTS visit (
  id int(11) NOT NULL AUTO_INCREMENT ,
  uid int(11) DEFAULT NULL ,
  vid int(11) DEFAULT NULL ,
  create_date datetime DEFAULT NULL ,
  is_delete tinyint(1) DEFAULT NULL ,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS app (
  app_id varchar(36) NOT NULL COMMENT '应用ID',
  app_category_id varchar(36) DEFAULT NULL COMMENT '应用类别ID',
  user_id varchar(36) DEFAULT NULL COMMENT '创建人ID',
  app_name varchar(250) NOT NULL COMMENT '应用名称',
  app_desc varchar(500) DEFAULT NULL COMMENT '应用描述',
  app_icon varchar(250) DEFAULT NULL COMMENT '应用图标',
  app_index varchar(500) NOT NULL COMMENT '应用首页',
  app_status int(11) DEFAULT NULL COMMENT '应用状态(1000: "草稿", 1100: "发布", 1200: "停用")',
  create_date datetime DEFAULT NULL COMMENT '创建时间',
  update_date datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (app_id),
  KEY key_app_app_category_id (app_category_id),
  KEY key_app_user_id (user_id),
  KEY key_app_app_name (app_name)
);

CREATE TABLE IF NOT EXISTS app_category (
  app_category_id VARCHAR(36) NOT NULL COMMENT '应用类别ID',
  user_id VARCHAR(36) DEFAULT NULL COMMENT '创建人ID',
  app_category_name VARCHAR(250) NOT NULL COMMENT '应用类别名称',
  app_category_desc VARCHAR(500) DEFAULT NULL COMMENT '应用类别描述',
  create_date DATETIME DEFAULT NULL COMMENT '创建时间',
  update_date DATETIME DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (app_category_id),
  KEY key_app_category_user_id (user_id),
  KEY key_app_category_app_category_name (app_category_name)
);

CREATE TABLE IF NOT EXISTS sidebar (
  sidebar_id VARCHAR(36) NOT NULL COMMENT '侧边栏ID',
  parent_sidebar_id VARCHAR(36) DEFAULT NULL COMMENT '父级侧边栏ID',
  permission_id VARCHAR(36) DEFAULT NULL COMMENT '权限ID',
  user_id VARCHAR(36) DEFAULT NULL COMMENT '创建人ID',
  sidebar_name VARCHAR(50) NOT NULL COMMENT '侧边栏的名字',
  sidebar_url VARCHAR(500) DEFAULT NULL COMMENT '点击侧边栏时发送的请求URL',
  sidebar_sort INT(11) DEFAULT NULL COMMENT '排序',
  create_date DATETIME DEFAULT NULL COMMENT '创建时间',
  update_date DATETIME DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (sidebar_id),
  KEY key_sidebar_parent_sidebar_id (parent_sidebar_id),
  KEY key_sidebar_permission_id (permission_id),
  KEY key_sidebar_user_id (user_id)
);

CREATE TABLE resource_type (
  resource_type_id varchar(36) NOT NULL COMMENT '资源类型ID',
  resource_type_code int(11) DEFAULT NULL COMMENT '资源类型编码',
  resource_type_name varchar(50) NOT NULL COMMENT '资源类型名称',
  PRIMARY KEY (resource_type_id)
);

CREATE TABLE resource_category (
  resource_category_id varchar(36) NOT NULL COMMENT '资源类别ID',
  user_id varchar(36) DEFAULT NULL COMMENT '创建人ID',
  resource_category_name varchar(50) NOT NULL COMMENT '资源类别名称',
  create_date datetime DEFAULT NULL COMMENT '创建时间',
  update_date datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (resource_category_id),
  KEY key_resource_category_user_id (user_id)
);

CREATE TABLE resource (
  resource_id varchar(36) NOT NULL COMMENT '资源ID',
  resource_type_id varchar(36) DEFAULT NULL COMMENT '资源类型ID',
  resource_category_id varchar(36) DEFAULT NULL COMMENT '资源类别ID',
  user_id varchar(36) DEFAULT NULL COMMENT '创建人ID',
  resource_name varchar(50) NOT NULL COMMENT '资源名称',
  resource_value varchar(500) NOT NULL COMMENT '资源值',
  resource_desc varchar(500) DEFAULT NULL COMMENT '资源描述',
  create_date datetime DEFAULT NULL COMMENT '创建时间',
  update_date datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (resource_id),
  KEY key_r_resource_type_id (resource_type_id),
  KEY key_r_resource_category_id (resource_category_id),
  KEY key_r_user_id (user_id)
);