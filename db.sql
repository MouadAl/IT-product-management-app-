
--Table creation
CREATE TABLE PRODUITS (
	ID serial PRIMARY KEY ,
	DESIGNATION VARCHAR (50)  ,
	PRIX real  ,
	QUANTITE int 
	);
--Insertion of some products
INSERT INTO PRODUITS (DESIGNATION,PRIX,QUANTITE) values ('Clavier',40.00,5);
INSERT INTO PRODUITS (DESIGNATION,PRIX,QUANTITE) values ('souris',25.00,8);
INSERT INTO PRODUITS (DESIGNATION,PRIX,QUANTITE) values ('pc-hp',5000.00,4);
INSERT INTO PRODUITS (DESIGNATION,PRIX,QUANTITE) values ('pc-dell',7500.00,3);

--Test inserted products
select* from Produits



