DROP TABLE mobilephones;

CREATE TABLE mobilephones(
   id INT,
   model VARCHAR(50),
   brand VARCHAR(50),
   price FLOAT,
   qty INT,
   PRIMARY KEY(id)
   );
 
INSERT INTO mobilephones VALUES (1001, 'iPhone XS Max 256 GB (Gold)', 'Apple', 2049, 100);
INSERT INTO mobilephones VALUES (1002, 'PORSCHE DESIGN Mate20 RS', 'Huawei', 2599, 100);
INSERT INTO mobilephones VALUES (1003, 'Galaxy S10+ 1TB (Ceramic White)', 'Samsung', 2399, 100);
INSERT INTO mobilephones VALUES (1004, 'Reno 5G (Jet Black)', 'OPPO', 1499, 100);
INSERT INTO mobilephones VALUES (1005, 'Mi MIX 3 5G 128GB (Onyx Black)', 'Xiaomi', 1399, 100);

