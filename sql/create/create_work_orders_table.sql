USE poolcaredb;

DROP TABLE IF EXISTS work_orders;
CREATE TABLE work_orders 
(
  work_order_id INT NOT NULL AUTO_INCREMENT,
  company_id INT(11) DEFAULT NULL,
  customer_id INT(11) DEFAULT NULL,
  created DATETIME DEFAULT CURRENT_TIMESTAMP,
  scheduled DATETIME NOT NULL,
  PRIMARY KEY (work_order_id),
  KEY ixfk_work_orders_company_id (company_id),
  KEY ixfk_work_orders_customer_id (customer_id),
  FOREIGN KEY (company_id) REFERENCES companies (company_id),
  FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);