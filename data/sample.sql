use uicsserver;
GO

/**************************** ADMIN TABLE ****************************/
INSERT INTO Admin VALUES('admin','admin','admin@gmail.com');

/**************************** ZONE TABLE ****************************/
INSERT INTO Zone VALUES('01','New York');
INSERT INTO Zone VALUES('02','Pennsylvania');
INSERT INTO Zone VALUES('03','Virginia');
INSERT INTO Zone VALUES('04','Iowa');
INSERT INTO Zone VALUES('05','Ohio');
INSERT INTO Zone VALUES('06','Indiana');
INSERT INTO Zone VALUES('07','Illinois');
INSERT INTO Zone VALUES('08','Minnesota');
INSERT INTO Zone VALUES('09','Colorado');

/**************************** CENTRE TABLE ************************/
INSERT INTO Centre VALUES('0101','01','Albany','Albany','127.0.0.1');
INSERT INTO Centre VALUES('0102','01','Hartford','Hartford','192.168.1.1');
INSERT INTO Centre VALUES('0201','02','Harrisburg','Harrisburg','192.168.1.2');
INSERT INTO Centre VALUES('0202','02','Trenton','Trenton','192.168.1.3');
INSERT INTO Centre VALUES('0301','03','Rickmond','Richmond','192.168.1.4');
INSERT INTO Centre VALUES('0302','03','Charleston','Charleston','192.168.1.5');
INSERT INTO Centre VALUES('0401','04','Des Moines','Des Moines','192.168.1.6');
INSERT INTO Centre VALUES('0402','04','Lincoln','Lincoln','192.168.1.7');
INSERT INTO Centre VALUES('0501','05','Columbus','Columbus','192.168.1.8');
INSERT INTO Centre VALUES('0502','05','Lansing','Lansing','192.168.1.9');
INSERT INTO Centre VALUES('0601','06','Indianapolis','Indianapolis','192.168.1.10');
INSERT INTO Centre VALUES('0602','06','Frankfort','Frankfort','192.168.1.11');
INSERT INTO Centre VALUES('0701','07','Springfield','Springfield','192.168.1.12');
INSERT INTO Centre VALUES('0702','07','Nashville','Nashville','192.168.1.13');
INSERT INTO Centre VALUES('0801','08','St.Paul','St.Paul','192.168.1.14');
INSERT INTO Centre VALUES('0802','08','Madison','Madison','192.168.1.15');
INSERT INTO Centre VALUES('0901','09','Denver','Denver','192.168.1.16');
INSERT INTO Centre VALUES('0902','09','Santa Fe','Santa Fe','192.168.1.17');

/**************************** EMPLOYEE TABLE ************************/
INSERT INTO Employee VALUES('emp1','123','emp1@gmail.com',0,'0101');
INSERT INTO Employee VALUES('emp2','123','emp2@gmail.com',0,'0101');
INSERT INTO Employee VALUES('emp3','123','emp3@gmail.com',0,'0102');
INSERT INTO Employee VALUES('emp4','123','emp4@gmail.com',0,'0102');
INSERT INTO Employee VALUES('emp5','123','emp5@gmail.com',0,'0201');
INSERT INTO Employee VALUES('emp6','123','emp6@gmail.com',0,'0201');
INSERT INTO Employee VALUES('emp7','123','emp7@gmail.com',0,'0202');
INSERT INTO Employee VALUES('emp8','123','emp8@gmail.com',0,'0202');
INSERT INTO Employee VALUES('emp9','123','emp1@gmail.com',0,'0301');
INSERT INTO Employee VALUES('emp10','123','emp10@gmail.com',0,'0301');
INSERT INTO Employee VALUES('emp11','123','emp11@gmail.com',0,'0302');
INSERT INTO Employee VALUES('emp12','123','emp12@gmail.com',0,'0302');
INSERT INTO Employee VALUES('emp13','123','emp13@gmail.com',0,'0401');
INSERT INTO Employee VALUES('emp14','123','emp14@gmail.com',0,'0401');
INSERT INTO Employee VALUES('emp15','123','emp15@gmail.com',0,'0402');
INSERT INTO Employee VALUES('emp16','123','emp16@gmail.com',0,'0402');
INSERT INTO Employee VALUES('emp17','123','emp17@gmail.com',0,'0501');
INSERT INTO Employee VALUES('emp18','123','emp18@gmail.com',0,'0501');
INSERT INTO Employee VALUES('emp19','123','emp19@gmail.com',0,'0502');
INSERT INTO Employee VALUES('emp20','123','emp20@gmail.com',0,'0502');
INSERT INTO Employee VALUES('emp21','123','emp21@gmail.com',0,'0601');
INSERT INTO Employee VALUES('emp22','123','emp22@gmail.com',0,'0601');
INSERT INTO Employee VALUES('emp23','123','emp23@gmail.com',0,'0602');
INSERT INTO Employee VALUES('emp24','123','emp24@gmail.com',0,'0602');
INSERT INTO Employee VALUES('emp25','123','emp25@gmail.com',0,'0701');
INSERT INTO Employee VALUES('emp26','123','emp26@gmail.com',0,'0701');
INSERT INTO Employee VALUES('emp27','123','emp27@gmail.com',0,'0702');
INSERT INTO Employee VALUES('emp28','123','emp28@gmail.com',0,'0702');
INSERT INTO Employee VALUES('emp29','123','emp29@gmail.com',0,'0801');
INSERT INTO Employee VALUES('emp30','123','emp30@gmail.com',0,'0801');
INSERT INTO Employee VALUES('emp31','123','emp31@gmail.com',0,'0802');
INSERT INTO Employee VALUES('emp32','123','emp32@gmail.com',0,'0802');
INSERT INTO Employee VALUES('emp33','123','emp33@gmail.com',0,'0901');
INSERT INTO Employee VALUES('emp34','123','emp34@gmail.com',0,'0901');
INSERT INTO Employee VALUES('emp35','123','emp35@gmail.com',0,'0902');
INSERT INTO Employee VALUES('emp36','123','emp36@gmail.com',0,'0902');

