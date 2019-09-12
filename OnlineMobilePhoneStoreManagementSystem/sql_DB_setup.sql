DROP TABLE mobilephones;

CREATE TABLE mobilephones(
   id INT,
   model VARCHAR(50),
   brand VARCHAR(50),
   price FLOAT,
   qty INT,
   description VARCHAR(500),
   PRIMARY KEY(id)
   );
 
INSERT INTO mobilephones VALUES (1001, 'iPhone XS Max 256 GB (Gold)', 'Apple', 2049, 100, 'iPhone XS Max features a 6.5-inch
					Super Retina display with custom-engineered OLED panels for an HDR
					display that provides the industrys best colour accuracy, as well
					as true blacks and remarkable brightness');
INSERT INTO mobilephones VALUES (1002, 'PORSCHE DESIGN Mate20 RS', 'Huawei', 2599, 100, 'The iconic glass band on the back is
					inspired by the Motor Racing seeking the balance of ultimate
					aesthetics and engineering sophistication. A true masterpiece of
					craftsmanship forged to perfection');
INSERT INTO mobilephones VALUES (1003, 'Nokia 4.2 (Black)', 'Nokia', 299, 100, 'Free of unnecessary UI changes and hidden processes for longer lasting battery. 
					Better still, your Nokia 4.2 is future-proof with guaranteed software and security updates ? so it just keeps getting better over time');			
INSERT INTO mobilephones VALUES (1004, 'Galaxy S10+ (Ceramic White)', 'Samsung', 2399, 100, 'No notch. No interruptions. 
					The powerful new Galaxy S10+ features a cinematic bezel-less screen to give you immersive viewing. Shoot 
					like a professional with our Pro-grade camera');					
INSERT INTO mobilephones VALUES (1005, 'Reno 5G (Jet Black)', 'OPPO', 1499, 100, 'Reno 5G is about seeing the world from completely new perspectives. 
					The technology behind Reno 5G elevates photography and mobile entertainment to all-new heights. Let Reno 5G further your vision');
INSERT INTO mobilephones VALUES (1006, 'Mi MIX 3 5G 128GB (Onyx Black)', 'Xiaomi', 1399, 100, 'As Xiaomi premium flagship, Mi MIX 3 5G has the most advanced 
					5G technology. Xiaomi is one of the first companies to put a 5G smartphone into the hands of consumers to truly experience');
