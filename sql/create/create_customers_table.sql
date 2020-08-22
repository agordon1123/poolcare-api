USE poolcaredb;

DROP TABLE IF EXISTS customers;
CREATE TABLE customers 
(
  customer_id INT NOT NULL AUTO_INCREMENT,
  company_id INT(11) DEFAULT NULL,
  first_name VARCHAR(150) NOT NULL,
  last_name VARCHAR(150) NOT NULL,
  PRIMARY KEY (customer_id),
  KEY ixfk_customers_company_id (company_id),
  FOREIGN KEY (company_id) REFERENCES companies (company_id)
);