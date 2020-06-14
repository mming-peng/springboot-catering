
CREATE TABLE  dish  (
   dish_number  int NOT NULL auto_increment,
   dish_name  varchar(10) NOT NULL,
   discount  int,
   price double(10,2), 
   PRIMARY KEY ( dish_number ) 
); 

CREATE TABLE orders (
   order_number int NOT NULL auto_increment,
   table_number int NOT NULL,
   status  int,
   time  int,
   price double(10,2), 
   PRIMARY KEY ( order_number ) 
); 

CREATE TABLE  order_dish  (
   order_number  int ,
   dish_number  int ,
   amount  int
); 