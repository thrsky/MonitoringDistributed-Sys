CREATE TABLE warn_message(
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(200) NOT NULL COMMENT '标题',
  warn_line DOUBLE NOT NULL COMMENT '警戒线',
  `type` int NOT NULL COMMENT '大于：1 等于：0 小于：-1',
  item VARCHAR(20) COMMENT 'cpu,mem,disk,net...'
)