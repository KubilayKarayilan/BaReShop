
CREATE TABLE IF NOT EXISTS person(
  id BIGINT NOT NULL ,
  username VARCHAR(100),
  password VARCHAR(100),
  fullname VARCHAR(100),
  email VARCHAR(100),
  tlf VARCHAR(100),
  tlfUID VARCHAR(100),
  create_time TIMESTAMP) ;