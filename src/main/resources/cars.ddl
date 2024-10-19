drop table cars;

create table cars (
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  model_name VARCHAR(200) NOT NULL,
  manufacturer VARCHAR(200),
  vin VARCHAR(200) NOT NULL);