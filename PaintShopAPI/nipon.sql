SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Indexes */

DROP INDEX language_id ON about_product_language;
DROP INDEX admin_status_id ON admin;
DROP INDEX color_group_id ON color;
DROP INDEX product_id ON discount;
DROP INDEX language_id ON feature_language;
DROP INDEX language_id ON group_language;
DROP INDEX guide_id ON guide_language;
DROP INDEX product_id ON litreage;
DROP INDEX qty_unit_id ON litreage;
DROP INDEX member_status_id ON member;
DROP INDEX member_id ON member_order_form;
DROP INDEX delivery_address_id ON order_form;
DROP INDEX delivery_type_id ON order_form;
DROP INDEX status_id ON order_form;
DROP INDEX payment_method_id ON order_form;
DROP INDEX member_id ON payment_method_owner;
DROP INDEX admin_id ON product;
DROP INDEX status_id ON product;
DROP INDEX product_type_id ON product;
DROP INDEX qty_unit_id ON product;
DROP INDEX color_group_id ON product_color_group;
DROP INDEX feature_id ON product_feature;
DROP INDEX tool_id ON product_free_tool;
DROP INDEX guide_id ON product_guide;
DROP INDEX folder_id ON product_media;
DROP INDEX product_id ON product_media;
DROP INDEX color_id ON product_order;
DROP INDEX litreage_id ON product_order;
DROP INDEX order_form_id ON product_order;
DROP INDEX product_id ON product_order;
DROP INDEX qty_unit_id ON product_order;
DROP INDEX language_id ON product_title_language;
DROP INDEX product_group_id ON product_type;
DROP INDEX admin_id ON shop;
DROP INDEX status_id ON shop;
DROP INDEX tool_id ON tool_language;
DROP INDEX language_id ON type_language;



/* Drop Views */

DROP VIEW IF EXISTS product_feature_language;
DROP VIEW IF EXISTS product_guide_language;
DROP VIEW IF EXISTS product_literage_qtyunit;
DROP VIEW IF EXISTS product_tool_language;



/* Drop Tables */

DROP TABLE IF EXISTS about_product_language;
DROP TABLE IF EXISTS discount;
DROP TABLE IF EXISTS product_order;
DROP TABLE IF EXISTS litreage;
DROP TABLE IF EXISTS product_color_group;
DROP TABLE IF EXISTS product_feature;
DROP TABLE IF EXISTS product_free_tool;
DROP TABLE IF EXISTS product_guide;
DROP TABLE IF EXISTS product_media;
DROP TABLE IF EXISTS product_title_language;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS shop;
DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS admin_status;
DROP TABLE IF EXISTS color;
DROP TABLE IF EXISTS color_group;
DROP TABLE IF EXISTS member_order_form;
DROP TABLE IF EXISTS order_form;
DROP TABLE IF EXISTS delivery_address;
DROP TABLE IF EXISTS delivery_type;
DROP TABLE IF EXISTS feature_language;
DROP TABLE IF EXISTS feature;
DROP TABLE IF EXISTS folder;
DROP TABLE IF EXISTS tool_language;
DROP TABLE IF EXISTS free_tool;
DROP TABLE IF EXISTS group_language;
DROP TABLE IF EXISTS guide_language;
DROP TABLE IF EXISTS guide;
DROP TABLE IF EXISTS type_language;
DROP TABLE IF EXISTS language;
DROP TABLE IF EXISTS payment_method_owner;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS member_status;
DROP TABLE IF EXISTS order_status;
DROP TABLE IF EXISTS payment_method;
DROP TABLE IF EXISTS product_type;
DROP TABLE IF EXISTS product_group;
DROP TABLE IF EXISTS product_status;
DROP TABLE IF EXISTS qty_unit;
DROP TABLE IF EXISTS shop_status;




/* Create Tables */

CREATE TABLE about_product_language
(
	product_id int NOT NULL,
	language_id int NOT NULL,
	about_desc varchar(1500) NOT NULL,
	PRIMARY KEY (product_id, language_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE admin
(
	admin_id int NOT NULL AUTO_INCREMENT,
	name varchar(200) NOT NULL,
	email varchar(100) NOT NULL,
	password varchar(1000) NOT NULL,
	phone varchar(30) NOT NULL,
	nrc varchar(200) NOT NULL,
	gender varchar(20) NOT NULL,
	description varchar(1500),
	create_date date NOT NULL,
	admin_status_id int NOT NULL,
	PRIMARY KEY (admin_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE admin_status
(
	admin_status_id int NOT NULL AUTO_INCREMENT,
	status_name varchar(300) NOT NULL,
	status_desc varchar(1500),
	PRIMARY KEY (admin_status_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE color
(
	color_id int NOT NULL AUTO_INCREMENT,
	html_color_code varchar(100) NOT NULL,
	color_name varchar(200) NOT NULL,
	color_number varchar(100) NOT NULL,
	description varchar(1500),
	color_group_id int NOT NULL,
	PRIMARY KEY (color_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE color_group
(
	color_group_id int NOT NULL AUTO_INCREMENT,
	name varchar(1000) NOT NULL,
	html_color_code varchar(100) NOT NULL,
	color_number varchar(100) NOT NULL,
	color_name varchar(100) NOT NULL,
	description varchar(1500),
	PRIMARY KEY (color_group_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE delivery_address
(
	delivery_address_id int NOT NULL AUTO_INCREMENT,
	address varchar(1500) NOT NULL,
	delivery_price double NOT NULL,
	description varchar(1500),
	PRIMARY KEY (delivery_address_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE delivery_type
(
	delivery_type_id int NOT NULL AUTO_INCREMENT,
	name varchar(1500) NOT NULL,
	PRIMARY KEY (delivery_type_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE discount
(
	discount_id int NOT NULL AUTO_INCREMENT,
	product_id int NOT NULL,
	discount_rate int NOT NULL,
	qty int NOT NULL,
	end_date date NOT NULL,
	start_date date NOT NULL,
	description varchar(100),
	PRIMARY KEY (discount_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE feature
(
	feature_id int NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (feature_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE feature_language
(
	feature_id int NOT NULL,
	language_id int NOT NULL,
	feature_name varchar(1500) NOT NULL,
	PRIMARY KEY (feature_id, language_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE folder
(
	folder_id int NOT NULL AUTO_INCREMENT,
	name varchar(500) NOT NULL,
	PRIMARY KEY (folder_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE free_tool
(
	tool_id int NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (tool_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE group_language
(
	product_group_id int NOT NULL,
	language_id int NOT NULL,
	name varchar(1500) NOT NULL,
	description varchar(1500),
	PRIMARY KEY (product_group_id, language_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE guide
(
	guide_id int NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (guide_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE guide_language
(
	language_id int NOT NULL,
	guide_id int NOT NULL,
	guide_type varchar(1500) NOT NULL,
	guide_value varchar(1500) NOT NULL,
	PRIMARY KEY (language_id, guide_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE language
(
	language_id int NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
	code varchar(100) NOT NULL,
	PRIMARY KEY (language_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE litreage
(
	litreage_id int NOT NULL AUTO_INCREMENT,
	qty_unit_id int NOT NULL,
	product_id int NOT NULL,
	qty int NOT NULL,
	unit_price double NOT NULL,
	description varchar(1500),
	PRIMARY KEY (litreage_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE member
(
	member_id int NOT NULL AUTO_INCREMENT,
	name varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
	phone varchar(200) NOT NULL,
	password varchar(1000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
	mail varchar(200) NOT NULL,
	address varchar(1500),
	note varchar(1000),
	create_date date NOT NULL,
	member_status_id int NOT NULL,
	PRIMARY KEY (member_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE member_order_form
(
	order_form_id int NOT NULL,
	member_id int NOT NULL,
	PRIMARY KEY (order_form_id, member_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE member_status
(
	member_status_id int NOT NULL AUTO_INCREMENT,
	status_name varchar(1500) NOT NULL,
	status_desc varchar(1500),
	PRIMARY KEY (member_status_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE order_form
(
	order_form_id int NOT NULL AUTO_INCREMENT,
	delivery_type_id int NOT NULL,
	payment_method_id int NOT NULL,
	delivery_address_id int NOT NULL,
	phone varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
	address_details varchar(1500) NOT NULL,
	create_date date NOT NULL,
	total_dicount_rate double NOT NULL,
	total_price double NOT NULL,
	note varchar(2000),
	status_id int NOT NULL,
	PRIMARY KEY (order_form_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE order_status
(
	status_id int NOT NULL AUTO_INCREMENT,
	status_name varchar(100) NOT NULL,
	PRIMARY KEY (status_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE payment_method
(
	payment_method_id int NOT NULL AUTO_INCREMENT,
	serial_id varchar(1500) NOT NULL,
	service_name varchar(100) NOT NULL,
	create_date date NOT NULL,
	phone varchar(100) NOT NULL,
	description varchar(1500),
	PRIMARY KEY (payment_method_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE payment_method_owner
(
	payment_method_id int NOT NULL,
	member_id int NOT NULL,
	PRIMARY KEY (payment_method_id, member_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE product
(
	product_id int NOT NULL AUTO_INCREMENT,
	product_type_id int NOT NULL,
	create_date date NOT NULL,
	total_qty int NOT NULL,
	admin_id int CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
	qty_unit_id int NOT NULL,
	status_id int NOT NULL,
	PRIMARY KEY (product_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE product_color_group
(
	product_id int NOT NULL,
	color_group_id int NOT NULL,
	PRIMARY KEY (product_id, color_group_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE product_feature
(
	product_id int NOT NULL,
	feature_id int NOT NULL,
	PRIMARY KEY (product_id, feature_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE product_free_tool
(
	product_id int NOT NULL,
	tool_id int NOT NULL,
	PRIMARY KEY (product_id, tool_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE product_group
(
	product_group_id int NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (product_group_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE product_guide
(
	product_id int NOT NULL,
	guide_id int NOT NULL,
	PRIMARY KEY (product_id, guide_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE product_media
(
	product_media_id int NOT NULL AUTO_INCREMENT,
	folder_id int NOT NULL,
	product_id int NOT NULL,
	create_date date NOT NULL,
	media_type varchar(20) NOT NULL,
	PRIMARY KEY (product_media_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE product_order
(
	order_id int NOT NULL AUTO_INCREMENT,
	product_id int NOT NULL,
	order_form_id int NOT NULL,
	qty_unit_id int NOT NULL,
	color_id int NOT NULL,
	litreage_id int NOT NULL,
	order_qty int NOT NULL,
	PRIMARY KEY (order_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE product_status
(
	status_id int NOT NULL AUTO_INCREMENT,
	status_name varchar(100) NOT NULL,
	description varchar(500),
	PRIMARY KEY (status_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE product_title_language
(
	product_id int NOT NULL,
	language_id int NOT NULL,
	name varchar(1500) NOT NULL,
	PRIMARY KEY (product_id, language_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE product_type
(
	product_type_id int NOT NULL AUTO_INCREMENT,
	product_group_id int NOT NULL,
	html_color_code varchar(100) NOT NULL,
	PRIMARY KEY (product_type_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE qty_unit
(
	qty_unit_id int NOT NULL AUTO_INCREMENT,
	unit varchar(400) NOT NULL,
	description varchar(200) NOT NULL,
	PRIMARY KEY (qty_unit_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE shop
(
	shop_id int NOT NULL AUTO_INCREMENT,
	name varchar(500) NOT NULL,
	email varchar(200) NOT NULL,
	phone varchar(100) NOT NULL,
	address varchar(1500) NOT NULL,
	description varchar(1500),
	create_date date NOT NULL,
	admin_id int NOT NULL,
	status_id int NOT NULL,
	PRIMARY KEY (shop_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE shop_status
(
	status_id int NOT NULL AUTO_INCREMENT,
	status_name varchar(200) NOT NULL,
	description varchar(300) NOT NULL,
	PRIMARY KEY (status_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE tool_language
(
	language_id int NOT NULL,
	tool_id int NOT NULL,
	tool_name varchar(1500),
	tool_description varchar(1500),
	PRIMARY KEY (language_id, tool_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE type_language
(
	product_type_id int NOT NULL,
	language_id int NOT NULL,
	name varchar(3000) NOT NULL,
	description varchar(1500),
	PRIMARY KEY (product_type_id, language_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;



/* Create Foreign Keys */

ALTER TABLE product
	ADD CONSTRAINT product_ibfk_1 FOREIGN KEY (admin_id)
	REFERENCES admin (admin_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE shop
	ADD CONSTRAINT shop_ibfk_1 FOREIGN KEY (admin_id)
	REFERENCES admin (admin_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE admin
	ADD CONSTRAINT admin_ibfk_1 FOREIGN KEY (admin_status_id)
	REFERENCES admin_status (admin_status_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_order
	ADD CONSTRAINT product_order_ibfk_1 FOREIGN KEY (color_id)
	REFERENCES color (color_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE color
	ADD CONSTRAINT color_ibfk_1 FOREIGN KEY (color_group_id)
	REFERENCES color_group (color_group_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_color_group
	ADD CONSTRAINT product_color_group_ibfk_1 FOREIGN KEY (color_group_id)
	REFERENCES color_group (color_group_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE order_form
	ADD CONSTRAINT order_form_ibfk_1 FOREIGN KEY (delivery_address_id)
	REFERENCES delivery_address (delivery_address_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE order_form
	ADD CONSTRAINT order_form_ibfk_2 FOREIGN KEY (delivery_type_id)
	REFERENCES delivery_type (delivery_type_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE feature_language
	ADD CONSTRAINT feature_language_ibfk_1 FOREIGN KEY (feature_id)
	REFERENCES feature (feature_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_feature
	ADD CONSTRAINT product_feature_ibfk_1 FOREIGN KEY (feature_id)
	REFERENCES feature (feature_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_media
	ADD CONSTRAINT product_media_ibfk_1 FOREIGN KEY (folder_id)
	REFERENCES folder (folder_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_free_tool
	ADD CONSTRAINT product_free_tool_ibfk_1 FOREIGN KEY (tool_id)
	REFERENCES free_tool (tool_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE tool_language
	ADD CONSTRAINT tool_language_ibfk_1 FOREIGN KEY (tool_id)
	REFERENCES free_tool (tool_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE guide_language
	ADD CONSTRAINT guide_language_ibfk_1 FOREIGN KEY (guide_id)
	REFERENCES guide (guide_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_guide
	ADD CONSTRAINT product_guide_ibfk_1 FOREIGN KEY (guide_id)
	REFERENCES guide (guide_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE about_product_language
	ADD CONSTRAINT about_product_language_ibfk_1 FOREIGN KEY (language_id)
	REFERENCES language (language_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE feature_language
	ADD CONSTRAINT feature_language_ibfk_2 FOREIGN KEY (language_id)
	REFERENCES language (language_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE group_language
	ADD CONSTRAINT group_language_ibfk_1 FOREIGN KEY (language_id)
	REFERENCES language (language_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE guide_language
	ADD CONSTRAINT guide_language_ibfk_2 FOREIGN KEY (language_id)
	REFERENCES language (language_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_title_language
	ADD CONSTRAINT product_title_language_ibfk_1 FOREIGN KEY (language_id)
	REFERENCES language (language_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE tool_language
	ADD CONSTRAINT tool_language_ibfk_2 FOREIGN KEY (language_id)
	REFERENCES language (language_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE type_language
	ADD CONSTRAINT type_language_ibfk_1 FOREIGN KEY (language_id)
	REFERENCES language (language_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_order
	ADD CONSTRAINT product_order_ibfk_2 FOREIGN KEY (litreage_id)
	REFERENCES litreage (litreage_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE member_order_form
	ADD CONSTRAINT member_order_form_ibfk_1 FOREIGN KEY (member_id)
	REFERENCES member (member_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE payment_method_owner
	ADD CONSTRAINT payment_method_owner_ibfk_1 FOREIGN KEY (member_id)
	REFERENCES member (member_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE member
	ADD CONSTRAINT member_ibfk_1 FOREIGN KEY (member_status_id)
	REFERENCES member_status (member_status_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE member_order_form
	ADD CONSTRAINT member_order_form_ibfk_2 FOREIGN KEY (order_form_id)
	REFERENCES order_form (order_form_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_order
	ADD CONSTRAINT product_order_ibfk_3 FOREIGN KEY (order_form_id)
	REFERENCES order_form (order_form_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE order_form
	ADD CONSTRAINT order_form_ibfk_3 FOREIGN KEY (status_id)
	REFERENCES order_status (status_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE order_form
	ADD CONSTRAINT order_form_ibfk_4 FOREIGN KEY (payment_method_id)
	REFERENCES payment_method (payment_method_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE payment_method_owner
	ADD CONSTRAINT payment_method_owner_ibfk_2 FOREIGN KEY (payment_method_id)
	REFERENCES payment_method (payment_method_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE about_product_language
	ADD CONSTRAINT about_product_language_ibfk_2 FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE discount
	ADD CONSTRAINT discount_ibfk_1 FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE litreage
	ADD CONSTRAINT litreage_ibfk_1 FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_color_group
	ADD CONSTRAINT product_color_group_ibfk_2 FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_feature
	ADD CONSTRAINT product_feature_ibfk_2 FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_free_tool
	ADD CONSTRAINT product_free_tool_ibfk_2 FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_guide
	ADD CONSTRAINT product_guide_ibfk_2 FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_media
	ADD CONSTRAINT product_media_ibfk_2 FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_order
	ADD CONSTRAINT product_order_ibfk_4 FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_title_language
	ADD CONSTRAINT product_title_language_ibfk_2 FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE group_language
	ADD CONSTRAINT group_language_ibfk_2 FOREIGN KEY (product_group_id)
	REFERENCES product_group (product_group_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_type
	ADD CONSTRAINT product_type_ibfk_1 FOREIGN KEY (product_group_id)
	REFERENCES product_group (product_group_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product
	ADD CONSTRAINT product_ibfk_2 FOREIGN KEY (status_id)
	REFERENCES product_status (status_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product
	ADD CONSTRAINT product_ibfk_3 FOREIGN KEY (product_type_id)
	REFERENCES product_type (product_type_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE type_language
	ADD CONSTRAINT type_language_ibfk_2 FOREIGN KEY (product_type_id)
	REFERENCES product_type (product_type_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE litreage
	ADD CONSTRAINT litreage_ibfk_2 FOREIGN KEY (qty_unit_id)
	REFERENCES qty_unit (qty_unit_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product
	ADD CONSTRAINT product_ibfk_4 FOREIGN KEY (qty_unit_id)
	REFERENCES qty_unit (qty_unit_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE product_order
	ADD CONSTRAINT product_order_ibfk_5 FOREIGN KEY (qty_unit_id)
	REFERENCES qty_unit (qty_unit_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE shop
	ADD CONSTRAINT shop_ibfk_2 FOREIGN KEY (status_id)
	REFERENCES shop_status (status_id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;



/* Create Views */

CREATE VIEW product_feature_language AS select `drnineni_paint_shop`.`product_feature`.`product_id` AS `product_id`,`drnineni_paint_shop`.`product_feature`.`feature_id` AS `feature_id`,`drnineni_paint_shop`.`feature_language`.`language_id` AS `language_id`,`drnineni_paint_shop`.`feature_language`.`feature_name` AS `feature_name` from `drnineni_paint_shop`.`product_feature` join `drnineni_paint_shop`.`feature_language` where (`drnineni_paint_shop`.`product_feature`.`feature_id` = `drnineni_paint_shop`.`feature_language`.`feature_id`) order by `drnineni_paint_shop`.`product_feature`.`product_id`;
CREATE VIEW product_guide_language AS select `drnineni_paint_shop`.`product_guide`.`product_id` AS `product_id`,`drnineni_paint_shop`.`product_guide`.`guide_id` AS `guide_id`,`drnineni_paint_shop`.`guide_language`.`language_id` AS `language_id`,`drnineni_paint_shop`.`guide_language`.`guide_type` AS `guide_type`,`drnineni_paint_shop`.`guide_language`.`guide_value` AS `guide_value` from `drnineni_paint_shop`.`product_guide` join `drnineni_paint_shop`.`guide_language` where (`drnineni_paint_shop`.`product_guide`.`guide_id` = `drnineni_paint_shop`.`product_guide`.`guide_id`) order by `drnineni_paint_shop`.`product_guide`.`product_id`;
CREATE VIEW product_literage_qtyunit AS select `drnineni_paint_shop`.`product`.`product_id` AS `product_id`,`drnineni_paint_shop`.`litreage`.`unit_price` AS `litreage_unit_price`,`drnineni_paint_shop`.`litreage`.`qty` AS `litreage_qty`,`drnineni_paint_shop`.`qty_unit`.`unit` AS `qty_unit` from `drnineni_paint_shop`.`product` join `drnineni_paint_shop`.`litreage` join `drnineni_paint_shop`.`qty_unit` where ((`drnineni_paint_shop`.`product`.`product_id` = `drnineni_paint_shop`.`litreage`.`product_id`) and (`drnineni_paint_shop`.`litreage`.`qty_unit_id` = `drnineni_paint_shop`.`qty_unit`.`qty_unit_id`)) order by `drnineni_paint_shop`.`product`.`product_id`;
CREATE VIEW product_tool_language AS select `drnineni_paint_shop`.`product_free_tool`.`product_id` AS `product_id`,`drnineni_paint_shop`.`product_free_tool`.`tool_id` AS `tool_id`,`drnineni_paint_shop`.`tool_language`.`language_id` AS `language_id`,`drnineni_paint_shop`.`tool_language`.`tool_name` AS `tool_name` from `drnineni_paint_shop`.`product_free_tool` join `drnineni_paint_shop`.`tool_language` where (`drnineni_paint_shop`.`product_free_tool`.`tool_id` = `drnineni_paint_shop`.`tool_language`.`tool_id`) order by `drnineni_paint_shop`.`product_free_tool`.`product_id`;



/* Create Indexes */

CREATE INDEX language_id USING BTREE ON about_product_language (language_id ASC);
CREATE INDEX admin_status_id USING BTREE ON admin (admin_status_id ASC);
CREATE INDEX color_group_id USING BTREE ON color (color_group_id ASC);
CREATE INDEX product_id USING BTREE ON discount (product_id ASC);
CREATE INDEX language_id USING BTREE ON feature_language (language_id ASC);
CREATE INDEX language_id USING BTREE ON group_language (language_id ASC);
CREATE INDEX guide_id USING BTREE ON guide_language (guide_id ASC);
CREATE INDEX product_id USING BTREE ON litreage (product_id ASC);
CREATE INDEX qty_unit_id USING BTREE ON litreage (qty_unit_id ASC);
CREATE INDEX member_status_id USING BTREE ON member (member_status_id ASC);
CREATE INDEX member_id USING BTREE ON member_order_form (member_id ASC);
CREATE INDEX delivery_address_id USING BTREE ON order_form (delivery_address_id ASC);
CREATE INDEX delivery_type_id USING BTREE ON order_form (delivery_type_id ASC);
CREATE INDEX status_id USING BTREE ON order_form (status_id ASC);
CREATE INDEX payment_method_id USING BTREE ON order_form (payment_method_id ASC);
CREATE INDEX member_id USING BTREE ON payment_method_owner (member_id ASC);
CREATE INDEX admin_id USING BTREE ON product (admin_id ASC);
CREATE INDEX status_id USING BTREE ON product (status_id ASC);
CREATE INDEX product_type_id USING BTREE ON product (product_type_id ASC);
CREATE INDEX qty_unit_id USING BTREE ON product (qty_unit_id ASC);
CREATE INDEX color_group_id USING BTREE ON product_color_group (color_group_id ASC);
CREATE INDEX feature_id USING BTREE ON product_feature (feature_id ASC);
CREATE INDEX tool_id USING BTREE ON product_free_tool (tool_id ASC);
CREATE INDEX guide_id USING BTREE ON product_guide (guide_id ASC);
CREATE INDEX folder_id USING BTREE ON product_media (folder_id ASC);
CREATE INDEX product_id USING BTREE ON product_media (product_id ASC);
CREATE INDEX color_id USING BTREE ON product_order (color_id ASC);
CREATE INDEX litreage_id USING BTREE ON product_order (litreage_id ASC);
CREATE INDEX order_form_id USING BTREE ON product_order (order_form_id ASC);
CREATE INDEX product_id USING BTREE ON product_order (product_id ASC);
CREATE INDEX qty_unit_id USING BTREE ON product_order (qty_unit_id ASC);
CREATE INDEX language_id USING BTREE ON product_title_language (language_id ASC);
CREATE INDEX product_group_id USING BTREE ON product_type (product_group_id ASC);
CREATE INDEX admin_id USING BTREE ON shop (admin_id ASC);
CREATE INDEX status_id USING BTREE ON shop (status_id ASC);
CREATE INDEX tool_id USING BTREE ON tool_language (tool_id ASC);
CREATE INDEX language_id USING BTREE ON type_language (language_id ASC);

insert into admin_status values(null,'Active','Active');
insert into admin_status values(null,'Block','Block');
insert into admin_status values(null,'Pending','Pending');

insert into folder values(null,'profile');
insert into folder values(null,'freetool');
insert into folder values(null,'other');

insert into product_status values(null,'available','available');

desc product_status;



