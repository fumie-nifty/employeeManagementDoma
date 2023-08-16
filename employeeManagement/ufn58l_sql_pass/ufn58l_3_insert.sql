--/*================================================================*/
--/* レコード削除                                                   */
--/*================================================================*/
USE ufn58l;

DELETE FROM employee; 
DELETE FROM stock;
DELETE FROM product;
DELETE FROM category;
DELETE FROM member;

--/*================================================================*/
--/* employee（従業員）                                             */
--/*================================================================*/
INSERT INTO employee(employeeId, employeeName, section, phone) VALUES (922101, '鈴木　一郎', '研修部', '7700-2257');
INSERT INTO employee(employeeId, employeeName, section, phone) VALUES (922102, '田村　正人', '研修部', '7700-2258');
INSERT INTO employee(employeeId, employeeName, section, phone) VALUES (922103, '松田　明美', '開発部', '7712-4418');
INSERT INTO employee(employeeId, employeeName, section, phone) VALUES (922104, '浅井　順二', '開発部', '7712-4416');
INSERT INTO employee(employeeId, employeeName, section, phone) VALUES (922105, '高橋　道夫', '営業部', '7712-3316');
INSERT INTO employee(employeeId, employeeName, section, phone) VALUES (922106, '夏木　裕子', '営業部', '7712-3317');

--/*================================================================*/
--/* category（商品カテゴリ）情報                                   */
--/*================================================================*/
INSERT INTO category(categoryId, categoryName, picture) VALUES ('a', 'スポーツシューズ', 'a.gif');
INSERT INTO category(categoryId, categoryName, picture) VALUES ('b', 'スニーカー', 'b.gif');
INSERT INTO category(categoryId, categoryName, picture) VALUES ('c', 'サンダル', 'c.gif');
INSERT INTO category(categoryId, categoryName, picture) VALUES ('d', 'ウォーキングシューズ', 'd.gif');
INSERT INTO category(categoryId, categoryName, picture) VALUES ('e', 'シャツ', 'e.png');
INSERT INTO category(categoryId, categoryName, picture) VALUES ('f', 'グッズ', 'f.png');

--/*================================================================*/
--/* product（商品）情報                                            */
--/*================================================================*/
-- スポーツシューズ
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('a01', 'a', 'ALL STAR one', 15000, 'a01.gif', 150);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('a02', 'a', 'Star Speeder HI', 13800, 'a02.gif', 138);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('a03', 'a', 'Scuderia-α', 15000, 'a03.gif', 150);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('a04', 'a', 'エアロセプシー', 12000, 'a04.gif', 120);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('a05', 'a', 'Squadra Nova', 12000, 'a05.gif', 120);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('a06', 'a', 'Squadra Stellar', 9800, 'a06.gif', 98);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('a07', 'a', 'Squadra Estoile', 8500, 'a07.gif', 85);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('a08', 'a', 'Squadra Hobit', 6800, 'a08.gif', 68);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('a09', 'a', 'ヒュプノクラウン2000', 16000, 'a09.gif', 160);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('a10', 'a', 'SLIP STREAM', 12500, 'a10.gif', 125);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('a11', 'a', 'ストラーダ ラップリーダー', 25000, 'a11.gif', 250);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('a12', 'a', 'Star Speeder Kids', 6700, 'a12.gif', 67);

-- スニーカー
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('b01', 'b', 'ドライブステッパー', 9500, 'b01.gif', 95);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('b02', 'b', 'Effect Machine III', 17800, 'b02.gif', 178);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('b03', 'b', 'クロスオーバードライブ', 12800, 'b03.gif', 128);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('b04', 'b', 'Scuderia 11', 12800, 'b04.gif', 128);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('b05', 'b', 'インターセプター', 9800, 'b05.gif', 98);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('b06', 'b', 'Winglet RX', 18000, 'b06.gif', 180);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('b07', 'b', 'ストラーダ フラット', 12300, 'b07.gif', 123);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('b08', 'b', 'ストラーダ ZERO', 19800, 'b08.gif', 198);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('b09', 'b', 'capsule LDK', 8800, 'b09.gif', 88);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('b10', 'b', 'Urban Complex', 7800, 'b10.gif', 78);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('b11', 'b', 'Scuderia KAAR', 5600, 'b11.gif', 56);

-- サンダル
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('c01', 'c', 'ビルケンサンダル（WH）', 9800, 'c01.gif', 98);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('c02', 'c', 'ビルケンサンダル（BK）', 9800, 'c02.gif', 98);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('c03', 'c', 'シティサンダル（PK）', 5200, 'c03.gif', 52);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('c04', 'c', 'シティサンダル（BL）', 5200, 'c04.gif', 52);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('c05', 'c', 'シティサンダル（YE）', 5200, 'c05.gif', 52);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('c06', 'c', 'シティサンダルK（BL）', 3800, 'c06.gif', 38);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('c07', 'c', 'シティサンダルK（PK）', 3800, 'c07.gif', 38);

-- ウォーキングシューズ
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('d01', 'd', 'Star Speeder MID', 12800, 'd01.gif', 128);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('d02', 'd', 'SKY POINTER', 9800, 'd02.gif', 98);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('d03', 'd', 'Scuderia 914', 16000, 'd03.gif', 160);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('d04', 'd', '5iVE STAR', 9800, 'd04.gif', 98);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('d05', 'd', 'SS LightTone', 9800, 'd05.gif', 98);

-- シャツ
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('e01', 'e', 'アニマルTシャツ（カエル）', 2380, 'e01.png', 23);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('e02', 'e', 'アニマルTシャツ（ウサギ）', 2380, 'e02.png', 23);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('e03', 'e', 'アニマルTシャツ（シカ）', 2380, 'e03.png', 23);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('e04', 'e', 'アニマルTシャツ（コブタ）', 2380, 'e04.png', 23);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('e05', 'e', 'アニマルTシャツ（アヒル）', 2380, 'e05.png', 23);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('e06', 'e', 'チェックポロシャツ（BK）', 3800, 'e06.png', 38);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('e07', 'e', 'チェックポロシャツ（GR）', 3800, 'e07.png', 38);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('e08', 'e', 'チェックポロシャツ（RD）', 3800, 'e08.png', 38);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('e09', 'e', 'キッズTシャツ（Apple）', 1700, 'e09.png', 17);

-- グッズ
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('f01', 'f', 'フラワースイムバッグ', 2200, 'f01.png', 22);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('f02', 'f', 'フルーツスイムバッグ', 2200, 'f02.png', 22);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('f03', 'f', 'FlowerBag（TypeA）', 1800, 'f03.png', 18);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('f04', 'f', 'FlowerBag（TypeB）', 1800, 'f04.png', 18);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('f05', 'f', 'FlowerBag（TypeC）', 1800, 'f05.png', 18);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('f06', 'f', 'FlowerBag（TypeD）', 1800, 'f06.png', 18);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('f07', 'f', 'FlowerBag（TypeE）', 1800, 'f07.png', 18);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('f08', 'f', 'カラフルシュシュ（TypeA）', 780, 'f08.png', 7);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('f09', 'f', 'カラフルシュシュ（TypeB）', 780, 'f09.png', 7);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('f10', 'f', 'カラフルシュシュ（TypeC）', 780, 'f10.png', 7);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('f11', 'f', 'カラフルシュシュ（TypeD）', 780, 'f11.png', 7);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('f12', 'f', 'カラフルシュシュ（TypeE）', 780, 'f12.png', 7);
INSERT INTO product(productid, categoryid, productname, price, picture, point) VALUES ('f13', 'f', 'カラフルシュシュ（TypeF）', 780, 'f13.png', 7);

--/*================================================================*/
--/* stock（在庫）情報                                              */
--/*================================================================*/
INSERT INTO stock(productid, quantity) VALUES ('a01', 100);
INSERT INTO stock(productid, quantity) VALUES ('a02', 100);
INSERT INTO stock(productid, quantity) VALUES ('a03', 100);
INSERT INTO stock(productid, quantity) VALUES ('a04', 100);
INSERT INTO stock(productid, quantity) VALUES ('a05', 100);
INSERT INTO stock(productid, quantity) VALUES ('a06', 100);
INSERT INTO stock(productid, quantity) VALUES ('a07', 100);
INSERT INTO stock(productid, quantity) VALUES ('a08', 100);
INSERT INTO stock(productid, quantity) VALUES ('a09', 100);
INSERT INTO stock(productid, quantity) VALUES ('a10', 100);
INSERT INTO stock(productid, quantity) VALUES ('a11', 100);
INSERT INTO stock(productid, quantity) VALUES ('a12', 100);

INSERT INTO stock(productid, quantity) VALUES ('b01', 100);
INSERT INTO stock(productid, quantity) VALUES ('b02', 100);
INSERT INTO stock(productid, quantity) VALUES ('b03', 100);
INSERT INTO stock(productid, quantity) VALUES ('b04', 100);
INSERT INTO stock(productid, quantity) VALUES ('b05', 100);
INSERT INTO stock(productid, quantity) VALUES ('b06', 100);
INSERT INTO stock(productid, quantity) VALUES ('b07', 100);
INSERT INTO stock(productid, quantity) VALUES ('b08', 100);
INSERT INTO stock(productid, quantity) VALUES ('b09', 100);
INSERT INTO stock(productid, quantity) VALUES ('b10', 100);
INSERT INTO stock(productid, quantity) VALUES ('b11', 100);

INSERT INTO stock(productid, quantity) VALUES ('c01', 100);
INSERT INTO stock(productid, quantity) VALUES ('c02', 100);
INSERT INTO stock(productid, quantity) VALUES ('c03', 100);
INSERT INTO stock(productid, quantity) VALUES ('c04', 100);
INSERT INTO stock(productid, quantity) VALUES ('c05', 100);
INSERT INTO stock(productid, quantity) VALUES ('c06', 100);
INSERT INTO stock(productid, quantity) VALUES ('c07', 100);

INSERT INTO stock(productid, quantity) VALUES ('d01', 100);
INSERT INTO stock(productid, quantity) VALUES ('d02', 100);
INSERT INTO stock(productid, quantity) VALUES ('d03', 100);
INSERT INTO stock(productid, quantity) VALUES ('d04', 100);
INSERT INTO stock(productid, quantity) VALUES ('d05', 100);

INSERT INTO stock(productid, quantity) VALUES ('e01', 100);
INSERT INTO stock(productid, quantity) VALUES ('e02', 100);
INSERT INTO stock(productid, quantity) VALUES ('e03', 100);
INSERT INTO stock(productid, quantity) VALUES ('e04', 100);
INSERT INTO stock(productid, quantity) VALUES ('e05', 100);
INSERT INTO stock(productid, quantity) VALUES ('e06', 100);
INSERT INTO stock(productid, quantity) VALUES ('e07', 100);
INSERT INTO stock(productid, quantity) VALUES ('e08', 100);
INSERT INTO stock(productid, quantity) VALUES ('e09', 100);

INSERT INTO stock(productid, quantity) VALUES ('f01', 100);
INSERT INTO stock(productid, quantity) VALUES ('f02', 100);
INSERT INTO stock(productid, quantity) VALUES ('f03', 100);
INSERT INTO stock(productid, quantity) VALUES ('f04', 100);
INSERT INTO stock(productid, quantity) VALUES ('f05', 100);
INSERT INTO stock(productid, quantity) VALUES ('f06', 100);
INSERT INTO stock(productid, quantity) VALUES ('f07', 100);
INSERT INTO stock(productid, quantity) VALUES ('f08', 100);
INSERT INTO stock(productid, quantity) VALUES ('f09', 100);
INSERT INTO stock(productid, quantity) VALUES ('f10', 100);
INSERT INTO stock(productid, quantity) VALUES ('f11', 100);
INSERT INTO stock(productid, quantity) VALUES ('f12', 100);
INSERT INTO stock(productid, quantity) VALUES ('f13', 100);

--/*================================================================*/
--/*  member（会員）情報                                            */
--/*================================================================*/
INSERT INTO member(memberId, password, memberName, gender, address, phone, memberPoint) VALUES ('test1', '$argon2id$v=19$m=16,t=2,p=1$UXptdXJxdk9QMTRic1psbw$8RlOZ4Yi/I9e1FYM9kD2jg', '飯田 哲夫', 'M', '東京都 大田区 池上0-0-0', '03-1111-2222', 652);
INSERT INTO member(memberId, password, memberName, gender, address, phone, memberPoint) VALUES ('test2', '$argon2id$v=19$m=16,t=2,p=1$UXptdXJxdk9QMTRic1psbw$8RlOZ4Yi/I9e1FYM9kD2jg', '渡邉 準', 'M', '東京都 大田区 蒲田0-0-0', '03-2222-3333', 0);


COMMIT;
