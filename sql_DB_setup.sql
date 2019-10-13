DROP TABLE MobilePhone;
DROP TABLE Users;
DROP TABLE Orders;
DROP TABLE MobilePhone_Order;

CREATE TABLE MobilePhone(
   mobilePhoneId INT,
   modelName VARCHAR(100),
   storageSize VARCHAR(50),
   color VARCHAR(50),
   brand VARCHAR(50),
   price FLOAT,
   qty INT,
   description VARCHAR(500),
   PRIMARY KEY(mobilePhoneId)
   );
 
INSERT INTO MobilePhone VALUES (1001, 'iPhone XS Max', '256 GB', 'Gold', 'Apple', 2049, 100, 'iPhone XS Max features a 6.5-inch Super Retina display with custom-engineered OLED panels for an HDR display that provides the industrys best colour accuracy, as well as true blacks and remarkable brightness');
INSERT INTO MobilePhone VALUES (1002, 'PORSCHE DESIGN Mate20 RS','128 GB', 'Black', 'Huawei', 2599, 100, 'The iconic glass band on the back is inspired by the Motor Racing seeking the balance of ultimate aesthetics and engineering sophistication. A true masterpiece of craftsmanship forged to perfection');
INSERT INTO MobilePhone VALUES (1003, 'Nokia 4.2', '32 GB', 'Black', 'Nokia', 299, 100, 'Free of unnecessary UI changes and hidden processes for longer lasting battery. Better still, your Nokia 4.2 is future-proof with guaranteed software and security updates ? so it just keeps getting better over time');			
INSERT INTO MobilePhone VALUES (1004, 'Galaxy S10+', '1 TB', 'Ceramic White', 'Samsung', 2399, 100, 'No notch. No interruptions. The powerful new Galaxy S10+ features a cinematic bezel-less screen to give you immersive viewing. Shoot like a professional with our Pro-grade camera');					
INSERT INTO MobilePhone VALUES (1005, 'Reno 5G', '256 GB', 'Jet Black', 'OPPO', 1499, 100, 'Reno 5G is about seeing the world from completely new perspectives. The technology behind Reno 5G elevates photography and mobile entertainment to all-new heights. Let Reno 5G further your vision');
INSERT INTO MobilePhone VALUES (1006, 'Mi MIX 3 5G', '128 GB', 'Onyx Black','Xiaomi', 1399, 100, 'As Xiaomi premium flagship, Mi MIX 3 5G has the most advanced 5G technology. Xiaomi is one of the first companies to put a 5G smartphone into the hands of consumers to truly experience');

CREATE TABLE Users(
   userId INT,
   username VARCHAR(50),
   email VARCHAR(100),
   address VARCHAR(100),
   userType VARCHAR(50),
   password VARCHAR(100),
   PRIMARY KEY(UserId)
   );
 
INSERT INTO Users VALUES (2001, 'Albert Einstein', 'albert.einstein@ias.edu', 'Office 9, IAS, Princeton, USA','CUSTOMER',111);
INSERT INTO Users VALUES (2002, 'James Bond', 'jbond@ghcq.uk', 'Queen Street 9,Chelsea 338, London','CUSTOMER',222);
INSERT INTO Users VALUES (2003, 'admin', 'nimda@admin', 'nimda','ADMIN',123);


CREATE TABLE Orders(
   orderId INT,
   createTime DATE,
   status VARCHAR(100), 
   mobilePhoneId INT,
   userId INT,
   PRIMARY KEY(orderId),
   FOREIGN KEY (mobilePhoneId) REFERENCES MobilePhone (mobilePhoneId),
   FOREIGN KEY (userId) REFERENCES Users (UserId)
   );
 
INSERT INTO Orders VALUES (3001, '2019-01-01', 'ACTIVE', 1001,2001);

CREATE TABLE MobilePhone_Order(
   mobilePhoneId INT,
   orderId INT,
   FOREIGN KEY (mobilePhoneId) REFERENCES MobilePhone (mobilePhoneId),
   FOREIGN KEY (orderId) REFERENCES Orders (orderId)
   );
 
   
CREATE TABLE Locks(
   Id INT,
   SessionId INT,
   tablename VARCHAR(10),
   PRIMARY KEY(Id)
   );
   
 INSERT INTO Locks VALUES (4001, 2001, 'Orders');