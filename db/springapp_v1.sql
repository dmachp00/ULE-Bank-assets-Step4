CREATE DATABASE springapp;

GRANT ALL ON springapp_v1.* TO springappuser@'%' IDENTIFIED BY 'pspringappuser';
GRANT ALL ON springapp_v1.* TO springappuser@localhost IDENTIFIED BY 'pspringappuser';

USE springapp;

CREATE TABLE loan (
  idLoan varchar(255) PRIMARY KEY,
  idCliente varchar(255),
  paymentPeriod DOUBLE,
  initialCapital DOUBLE,
  amortizationTime DOUBLE,
  Iterest DOUBLE,
  tableOfAmortization varchar(500)
);
CREATE INDEX loan_tableOfAmortization ON loan(tableOfAmortization);