USE poolcaredb;

DROP TABLE IF EXISTS pools;
CREATE TABLE pools 
(
  pool_id INT NOT NULL AUTO_INCREMENT,
  customer_id INT(11) DEFAULT NULL,
  company_id INT(11) DEFAULT NULL,
  gallonage INT(11) DEFAULT NULL,
  PRIMARY KEY (pool_id),
  KEY ixfk_pools_company_id (company_id),
  KEY ixfk_pools_customer_id (customer_id),
  FOREIGN KEY (company_id) REFERENCES companies (company_id),
  FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);