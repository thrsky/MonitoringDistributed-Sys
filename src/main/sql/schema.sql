create database sys;

use sys;
-- 用户表
CREATE TABLE user(
  `user_id` bigint not null auto_increment comment '用户ID',
  `user_name` VARCHAR(25) NOT NULL COMMENT '用户姓名',
  `user_password` VARCHAR(64) NOT NULL COMMENT '用户密码',
  PRIMARY KEY (user_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 服务器表

-- 用户-服务器对应表

-- 还有其他的表