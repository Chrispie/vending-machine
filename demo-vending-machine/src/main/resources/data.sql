--PRODUCT
DROP TABLE IF EXISTS product;

CREATE TABLE product (
  Product_Id   INT AUTO_INCREMENT PRIMARY KEY,
  Description VARCHAR(250) NOT NULL
);

INSERT INTO product (Product_Id, Description) VALUES
  (1, 'Cola'),
  (2, 'Fanta'),
  (3, 'Sprite');

--STOCK
DROP TABLE IF EXISTS stock;

CREATE TABLE stock (
  Product_Id   INT AUTO_INCREMENT PRIMARY KEY,
  Qty INT NOT NULL
);

INSERT INTO stock (Product_Id, Qty) VALUES
  (1,  10),
  (2,  10),
  (3,  10);

--PRICE INFORMATION
DROP TABLE IF EXISTS price_info;

CREATE TABLE price_info (
  Price_Info_Id INT AUTO_INCREMENT PRIMARY KEY,
  Product_Id   INT           NOT NULL,
  Eff_From     DATE          NOT NULL,
  Eff_To       DATE          NOT NULL,
  Price       DECIMAL(9, 2) NOT NULL
);


INSERT INTO price_info (Price_Info_Id, Product_Id, Eff_From, Eff_To, Price) VALUES
  (1, 1, PARSEDATETIME('20190101', 'yyyyMMdd'), PARSEDATETIME('99991231', 'yyyyMMdd'), 0.50),
  (2, 2, PARSEDATETIME('20190101', 'yyyyMMdd'), PARSEDATETIME('99991231', 'yyyyMMdd'), 1.50),
  (3, 3, PARSEDATETIME('20190101', 'yyyyMMdd'), PARSEDATETIME('99991231', 'yyyyMMdd'), 1.00);

--SALE
DROP TABLE IF EXISTS sale;

CREATE TABLE sale (
  Sale_Id    INT AUTO_INCREMENT PRIMARY KEY,
  Product_Id INT           NOT NULL,
  Eff_Date   DATE          NOT NULL,
  Qty       INT           NOT NULL,
  Price     DECIMAL(9, 2) NOT NULL,
  Total     DECIMAL(9, 2) NOT NULL
);