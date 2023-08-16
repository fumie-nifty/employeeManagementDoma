--/*================================================================*/
--/* テーブル削除                                                   */
--/*================================================================*/
USE ufn58l;

DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS stock;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS member;


--/*================================================================*/
--/* employee（従業員）テーブル                                     */
--/*================================================================*/
CREATE TABLE employee (
 employeeid     INTEGER      PRIMARY KEY,
 employeeName   VARCHAR(30)  NOT NULL ,
 section        VARCHAR(30)  NOT NULL ,
 phone          VARCHAR(30)  NOT NULL
);


--/*================================================================*/
--/* category（商品カテゴリ）テーブル                               */
--/*================================================================*/
CREATE TABLE category (
 categoryId     VARCHAR(2)   PRIMARY KEY ,
 categoryName   VARCHAR(40)  NOT NULL ,
 picture        VARCHAR(30)  NOT NULL
);


--/*================================================================*/
--/* product（商品）テーブル                                        */
--/*================================================================*/
CREATE TABLE product (
 productid      VARCHAR(12)  PRIMARY KEY ,
 categoryId     VARCHAR(2)   NOT NULL ,
 productName    VARCHAR(40)  NOT NULL ,
 price          DECIMAL(7)   NOT NULL ,
 picture        VARCHAR(30)  NOT NULL ,
 point          INTEGER      NOT NULL ,
 FOREIGN KEY(categoryId) REFERENCES category(categoryId)
);


--/*================================================================*/
--/* stock（在庫）テーブル                                          */
--/*================================================================*/
CREATE TABLE stock (
 productid      VARCHAR(12)  PRIMARY KEY ,
 quantity       INTEGER      NOT NULL ,
 FOREIGN KEY(productId) REFERENCES product(productId)
);


--/*================================================================*/
--/* MEMBER（会員）テーブル                                         */
--/*================================================================*/
CREATE TABLE member (
 memberId       VARCHAR(255) PRIMARY KEY ,
 password       CHAR(100)      NOT NULL ,
 memberName     VARCHAR(40)  NOT NULL ,
 gender         CHAR(1)      NOT NULL ,
 address        VARCHAR(80)  NOT NULL ,
 phone          VARCHAR(15)  NOT NULL ,
 memberPoint    INTEGER      NOT NULL
);
