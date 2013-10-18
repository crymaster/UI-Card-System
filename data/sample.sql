use uicard;
GO

/**************************** ADMIN TABLE ****************************/
INSERT INTO Admin VALUES('hoangson','hoangson','hoangson@gmail.com');
INSERT INTO Admin VALUES('quanghuy','quanghuy','quanghuy@gmail.com');


/**************************** ZONE TABLE ****************************/
INSERT INTO Zone VALUES('HAN','Ha Noi');
INSERT INTO Zone VALUES('HCM','TP HCM');

/**************************** CENTRE TABLE ************************/
INSERT INTO Centre VALUES('HAN001','HAN','Hoan Kiem','15 Ly Thai To','127.0.0.1');

/**************************** EMPLOYEE TABLE ************************/
INSERT INTO Employee VALUES('emp1','123','emp1@gmail.com','HAN001');
INSERT INTO Employee VALUES('emp2','123','emp2@gmail.com','HAN001');