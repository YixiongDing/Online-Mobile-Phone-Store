DROP TABLE MobilePhone;
DROP TABLE Customer;


CREATE TABLE MobilePhone(
   mobilePhoneId INT,
   modelName VARCHAR(100),
   storageSize VARCHAR(50),
   color VARCHAR(50),
   brand VARCHAR(50),
   price FLOAT,
   qty INT,
   PRIMARY KEY(mobilePhoneId)
   );
 
INSERT INTO MobilePhone VALUES (1001, 'iPhone XS Max','256 GB','Gold','Apple', 2049, 100);
INSERT INTO MobilePhone VALUES (1002, 'PORSCHE DESIGN Mate20 RS','128 GB','Black', 'Huawei', 2599, 100);
INSERT INTO MobilePhone VALUES (1003, 'Galaxy S10', '1TB','Ceramic White', 'Samsung', 2399, 100);
INSERT INTO MobilePhone VALUES (1004, 'Reno 5G','128 GB', 'Jet Black', 'OPPO', 1499, 100);
INSERT INTO MobilePhone VALUES (1005, 'Mi MIX 3 5G', '128GB', 'Onyx Black', 'Xiaomi', 1399, 100);


CREATE TABLE User(
   id INT,
   name VARCHAR(50),
   email VARCHAR(100),
   address VARCHAR(100),
   PRIMARY KEY(id)
   );
 
INSERT INTO Customer VALUES (2001, 'Albert Einstein', 'albert.einstein@ias.edu', 'Office 9, IAS, Princeton, USA');
INSERT INTO Customer VALUES (2002, 'James Bond', 'jbond@ghcq.uk', 'Queen Street 9,Chelsea 338, London');



CREATE TABLE Order(
   id INT,
   name VARCHAR(50),
   email VARCHAR(100),
   address VARCHAR(100),
   PRIMARY KEY(id)
   );
 
INSERT INTO Customer VALUES (2001, 'Albert Einstein', 'albert.einstein@ias.edu', 'Office 9, IAS, Princeton, USA');
INSERT INTO Customer VALUES (2002, 'James Bond', 'jbond@ghcq.uk', 'Queen Street 9,Chelsea 338, London');