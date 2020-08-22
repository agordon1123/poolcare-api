USE poolcaredb;

DROP TABLE IF EXISTS companies;
CREATE TABLE companies
(
    company_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    PRIMARY KEY (company_id)
);