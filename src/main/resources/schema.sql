DROP TABLE user IF EXISTS;
CREATE TABLE user(
  id BIGINT,
  name VARCHAR(100),
  password VARCHAR(100),
  create_time TIMESTAMP) ;