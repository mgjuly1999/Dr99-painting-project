SET SESSION FOREIGN_KEY_CHECKS=0;

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
DROP TABLE IF EXISTS Admin;
DROP TABLE IF EXISTS admin_status;
DROP TABLE IF EXISTS color;
DROP TABLE IF EXISTS color_group;
DROP TABLE IF EXISTS member_order_form;
DROP TABLE IF EXISTS order_form;
DROP TABLE IF EXISTS Delivery_Address;
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
DROP TABLE IF EXISTS product_quality;
DROP TABLE IF EXISTS product_status;
DROP TABLE IF EXISTS qty_unit;
DROP TABLE IF EXISTS shop_status;




/* Create Tables */

CREATE TABLE about_product_language
(
	product_id int NOT NULL,
	language_id int NOT NULL,
	about_desc varchar(1500) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (product_id, language_id)
) ENGINE = InnoDB;


CREATE TABLE Admin
(
	admin_id int NOT NULL AUTO_INCREMENT,
	name varchar(200) CHARACTER SET utf8 NOT NULL,
	email varchar(100) NOT NULL,
	password varchar(1000) NOT NULL,
	phone varchar(30) NOT NULL,
	nrc varchar(200) CHARACTER SET utf8 NOT NULL,
	gender varchar(20) NOT NULL,
	description varchar(1500),
	create_date date NOT NULL,
	admin_status_id int NOT NULL,
	PRIMARY KEY (admin_id)
) ENGINE = InnoDB;


CREATE TABLE admin_status
(
	admin_status_id int NOT NULL AUTO_INCREMENT,
	status_name varchar(300) NOT NULL,
	status_desc varchar(1500),
	PRIMARY KEY (admin_status_id)
);


CREATE TABLE color
(
	color_id int NOT NULL AUTO_INCREMENT,
	html_color_code varchar(100) NOT NULL,
	color_name varchar(200) CHARACTER SET utf8 NOT NULL,
	color_number varchar(100) CHARACTER SET utf8 NOT NULL,
	description varchar(1500),
	color_group_id int NOT NULL,
	PRIMARY KEY (color_id)
);


CREATE TABLE color_group
(
	color_group_id int NOT NULL AUTO_INCREMENT,
	name varchar(1000) CHARACTER SET utf8 NOT NULL,
	html_color_code varchar(100) NOT NULL,
	color_number varchar(100) NOT NULL,
	color_name varchar(100) NOT NULL,
	description varchar(1500),
	PRIMARY KEY (color_group_id)
) ENGINE = InnoDB;


CREATE TABLE Delivery_Address
(
	delivery_address_id int NOT NULL AUTO_INCREMENT,
	address varchar(1500) CHARACTER SET utf8 NOT NULL,
	delivery_price double NOT NULL,
	description varchar(1500),
	PRIMARY KEY (delivery_address_id)
) ENGINE = InnoDB;


CREATE TABLE delivery_type
(
	delivery_type_id int NOT NULL AUTO_INCREMENT,
	name varchar(1500) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (delivery_type_id)
) ENGINE = InnoDB;


CREATE TABLE discount
(
	discount_id int NOT NULL AUTO_INCREMENT,
	product_id int NOT NULL,
	discount_rate int NOT NULL,
	qty int NOT NULL,
	end_date date NOT NULL,
	start_date date NOT NULL,
	description varchar(100) CHARACTER SET utf8,
	PRIMARY KEY (discount_id)
) ENGINE = InnoDB;


CREATE TABLE feature
(
	feature_id int NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (feature_id)
);


CREATE TABLE feature_language
(
	feature_id int NOT NULL,
	language_id int NOT NULL,
	feature_name varchar(1500) NOT NULL,
	PRIMARY KEY (feature_id, language_id)
) ENGINE = InnoDB;


CREATE TABLE folder
(
	folder_id int NOT NULL AUTO_INCREMENT,
	name varchar(500) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (folder_id)
) ENGINE = InnoDB;


CREATE TABLE free_tool
(
	tool_id int NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (tool_id)
);


CREATE TABLE group_language
(
	product_group_id int NOT NULL,
	language_id int NOT NULL,
	name varchar(1500) CHARACTER SET utf8 NOT NULL,
	description varchar(1500) CHARACTER SET utf8,
	PRIMARY KEY (product_group_id, language_id)
) ENGINE = InnoDB;


CREATE TABLE guide
(
	guide_id int NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (guide_id)
);


CREATE TABLE guide_language
(
	language_id int NOT NULL,
	guide_id int NOT NULL,
	guide_type varchar(1500) NOT NULL,
	guide_value varchar(1500) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (language_id, guide_id)
) ENGINE = InnoDB;


CREATE TABLE language
(
	language_id int NOT NULL AUTO_INCREMENT,
	name varchar(100) CHARACTER SET utf8 NOT NULL,
	code varchar(100) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (language_id)
) ENGINE = InnoDB;


CREATE TABLE litreage
(
	litreage_id int NOT NULL AUTO_INCREMENT,
	qty_unit_id int NOT NULL,
	product_id int NOT NULL,
	qty int NOT NULL,
	unit_price double NOT NULL,
	description varchar(1500) CHARACTER SET utf8,
	PRIMARY KEY (litreage_id)
) ENGINE = InnoDB;


CREATE TABLE member
(
	member_id int NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
	phone varchar(200) NOT NULL,
	password varchar(1000) CHARACTER SET utf8 NOT NULL,
	mail varchar(200) NOT NULL,
	address varchar(1500) CHARACTER SET utf8,
	note varchar(1000) CHARACTER SET utf8,
	create_date date NOT NULL,
	member_status_id int NOT NULL,
	PRIMARY KEY (member_id)
) ENGINE = InnoDB;


CREATE TABLE member_order_form
(
	order_form_id int NOT NULL,
	member_id int NOT NULL,
	PRIMARY KEY (order_form_id, member_id)
);


CREATE TABLE member_status
(
	member_status_id int NOT NULL AUTO_INCREMENT,
	status_name varchar(1500) NOT NULL,
	status_desc varchar(1500),
	PRIMARY KEY (member_status_id)
);


CREATE TABLE order_form
(
	order_form_id int NOT NULL AUTO_INCREMENT,
	delivery_type_id int NOT NULL,
	payment_method_id int NOT NULL,
	delivery_address_id int NOT NULL,
	phone varchar(100) NOT NULL,
	address_details varchar(1500) CHARACTER SET utf8 NOT NULL,
	create_date date NOT NULL,
	total_dicount_rate double NOT NULL,
	total_price double NOT NULL,
	note varchar(2000) CHARACTER SET utf8,
	status_id int NOT NULL,
	PRIMARY KEY (order_form_id)
) ENGINE = InnoDB;


CREATE TABLE order_status
(
	status_id int NOT NULL AUTO_INCREMENT,
	status_name varchar(100) NOT NULL,
	PRIMARY KEY (status_id)
);


CREATE TABLE payment_method
(
	payment_method_id int NOT NULL AUTO_INCREMENT,
	merchant_user_id varchar(1000) NOT NULL,
	serial_id varchar(1500) NOT NULL,
	channel varchar(300) CHARACTER SET utf8 NOT NULL,
	invoice_no varchar(300) NOT NULL,
	amount double NOT NULL,
	phone varchar(100) NOT NULL,
	resp_code varchar(100) NOT NULL,
	resp_desc varchar(300) NOT NULL,
	description varchar(1500),
	create_date date NOT NULL,
	PRIMARY KEY (payment_method_id)
) ENGINE = InnoDB;


CREATE TABLE payment_method_owner
(
	payment_method_id int NOT NULL,
	member_id int NOT NULL,
	PRIMARY KEY (payment_method_id, member_id)
);


CREATE TABLE product
(
	product_id int NOT NULL AUTO_INCREMENT,
	product_type_id int NOT NULL,
	create_date date NOT NULL,
	total_qty int NOT NULL,
	admin_id int NOT NULL,
	qty_unit_id int NOT NULL,
	status_id int NOT NULL,
	product_quality_id int NOT NULL,
	PRIMARY KEY (product_id)
);



CREATE TABLE product_color_group
(
	product_id int NOT NULL,
	color_group_id int NOT NULL,
	PRIMARY KEY (product_id, color_group_id)
);


CREATE TABLE product_feature
(
	product_id int NOT NULL,
	feature_id int NOT NULL,
	PRIMARY KEY (product_id, feature_id)
);


CREATE TABLE product_free_tool
(
	product_id int NOT NULL,
	tool_id int NOT NULL,
	PRIMARY KEY (product_id, tool_id)
);


CREATE TABLE product_group
(
	product_group_id int NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (product_group_id)
);


CREATE TABLE product_guide
(
	product_id int NOT NULL,
	guide_id int NOT NULL,
	PRIMARY KEY (product_id, guide_id)
);


CREATE TABLE product_media
(
	product_media_id int NOT NULL AUTO_INCREMENT,
	folder_id int NOT NULL,
	product_id int NOT NULL,
	create_date date NOT NULL,
	media_type varchar(20) NOT NULL,
	PRIMARY KEY (product_media_id)
);


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
);


CREATE TABLE product_quality
(
	product_quality_id int NOT NULL AUTO_INCREMENT,
	name varchar(300) NOT NULL,
	description varchar(1000),
	PRIMARY KEY (product_quality_id)
);

ALTER TABLE product
ADD CONSTRAINT FOREIGN KEY(product_quality_id) REFERENCES product_quality(product_quality_id)
ON UPDATE CASCADE ON DELETE CASCADE; 

desc product;

select * from product;


ALTER TABLE product
    ADD product_quality_id INTEGER,
    ADD CONSTRAINT FOREIGN KEY(product_quality_id) REFERENCES product_quality(product_quality_id);

ALTER TABLE product ADD COLUMN product_quality_id int NOT NULL;
ALTER TABLE product ADD FOREIGN KEY (product_quality_id) REFERENCES product_quality;

CREATE TABLE product_status
(
	status_id int NOT NULL AUTO_INCREMENT,
	status_name varchar(100) NOT NULL,
	description varchar(500),
	PRIMARY KEY (status_id)
) ENGINE = InnoDB;


CREATE TABLE product_title_language
(
	product_id int NOT NULL,
	language_id int NOT NULL,
	name varchar(1500) NOT NULL,
	PRIMARY KEY (product_id, language_id)
) ENGINE = InnoDB;


CREATE TABLE product_type
(
	product_type_id int NOT NULL AUTO_INCREMENT,
	product_group_id int NOT NULL,
	html_color_code varchar(100) NOT NULL,
	PRIMARY KEY (product_type_id)
);


CREATE TABLE qty_unit
(
	qty_unit_id int NOT NULL AUTO_INCREMENT,
	unit varchar(400) NOT NULL,
	description varchar(200) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (qty_unit_id)
) ENGINE = InnoDB;


CREATE TABLE shop
(
	shop_id int NOT NULL AUTO_INCREMENT,
	name varchar(500) CHARACTER SET utf8 NOT NULL,
	email varchar(200) NOT NULL,
	phone varchar(100) NOT NULL,
	address varchar(1500) CHARACTER SET utf8 NOT NULL,
	description varchar(1500) CHARACTER SET utf8,
	create_date date NOT NULL,
	admin_id int NOT NULL,
	status_id int NOT NULL,
	PRIMARY KEY (shop_id)
) ENGINE = InnoDB;


CREATE TABLE shop_status
(
	status_id int NOT NULL AUTO_INCREMENT,
	status_name varchar(200) CHARACTER SET utf8 NOT NULL,
	description varchar(300) NOT NULL,
	PRIMARY KEY (status_id)
) ENGINE = InnoDB;


CREATE TABLE tool_language
(
	language_id int NOT NULL,
	tool_id int NOT NULL,
	tool_name varchar(1500) CHARACTER SET utf8,
	tool_description varchar(1500),
	PRIMARY KEY (language_id, tool_id)
) ENGINE = InnoDB;


CREATE TABLE type_language
(
	product_type_id int NOT NULL,
	language_id int NOT NULL,
	name varchar(3000) CHARACTER SET utf8 NOT NULL,
	description varchar(1500) CHARACTER SET utf8,
	PRIMARY KEY (product_type_id, language_id)
) ENGINE = InnoDB;



/* Create Foreign Keys */

ALTER TABLE product
	ADD FOREIGN KEY (admin_id)
	REFERENCES Admin (admin_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE shop
	ADD FOREIGN KEY (admin_id)
	REFERENCES Admin (admin_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Admin
	ADD FOREIGN KEY (admin_status_id)
	REFERENCES admin_status (admin_status_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_order
	ADD FOREIGN KEY (color_id)
	REFERENCES color (color_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE color
	ADD FOREIGN KEY (color_group_id)
	REFERENCES color_group (color_group_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_color_group
	ADD FOREIGN KEY (color_group_id)
	REFERENCES color_group (color_group_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE order_form
	ADD FOREIGN KEY (delivery_address_id)
	REFERENCES Delivery_Address (delivery_address_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE order_form
	ADD FOREIGN KEY (delivery_type_id)
	REFERENCES delivery_type (delivery_type_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE feature_language
	ADD FOREIGN KEY (feature_id)
	REFERENCES feature (feature_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_feature
	ADD FOREIGN KEY (feature_id)
	REFERENCES feature (feature_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_media
	ADD FOREIGN KEY (folder_id)
	REFERENCES folder (folder_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_free_tool
	ADD FOREIGN KEY (tool_id)
	REFERENCES free_tool (tool_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE tool_language
	ADD FOREIGN KEY (tool_id)
	REFERENCES free_tool (tool_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE guide_language
	ADD FOREIGN KEY (guide_id)
	REFERENCES guide (guide_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_guide
	ADD FOREIGN KEY (guide_id)
	REFERENCES guide (guide_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE about_product_language
	ADD FOREIGN KEY (language_id)
	REFERENCES language (language_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE feature_language
	ADD FOREIGN KEY (language_id)
	REFERENCES language (language_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE group_language
	ADD FOREIGN KEY (language_id)
	REFERENCES language (language_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE guide_language
	ADD FOREIGN KEY (language_id)
	REFERENCES language (language_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_title_language
	ADD FOREIGN KEY (language_id)
	REFERENCES language (language_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE tool_language
	ADD FOREIGN KEY (language_id)
	REFERENCES language (language_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE type_language
	ADD FOREIGN KEY (language_id)
	REFERENCES language (language_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_order
	ADD FOREIGN KEY (litreage_id)
	REFERENCES litreage (litreage_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE member_order_form
	ADD FOREIGN KEY (member_id)
	REFERENCES member (member_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE payment_method_owner
	ADD FOREIGN KEY (member_id)
	REFERENCES member (member_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE member
	ADD FOREIGN KEY (member_status_id)
	REFERENCES member_status (member_status_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE member_order_form
	ADD FOREIGN KEY (order_form_id)
	REFERENCES order_form (order_form_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_order
	ADD FOREIGN KEY (order_form_id)
	REFERENCES order_form (order_form_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE order_form
	ADD FOREIGN KEY (status_id)
	REFERENCES order_status (status_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE order_form
	ADD FOREIGN KEY (payment_method_id)
	REFERENCES payment_method (payment_method_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE payment_method_owner
	ADD FOREIGN KEY (payment_method_id)
	REFERENCES payment_method (payment_method_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE about_product_language
	ADD FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE discount
	ADD FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE litreage
	ADD FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_color_group
	ADD FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_feature
	ADD FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_free_tool
	ADD FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_guide
	ADD FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_media
	ADD FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_order
	ADD FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_title_language
	ADD FOREIGN KEY (product_id)
	REFERENCES product (product_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE group_language
	ADD FOREIGN KEY (product_group_id)
	REFERENCES product_group (product_group_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_type
	ADD FOREIGN KEY (product_group_id)
	REFERENCES product_group (product_group_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product
	ADD FOREIGN KEY (product_quality_id)
	REFERENCES product_quality (product_quality_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product
	ADD FOREIGN KEY (status_id)
	REFERENCES product_status (status_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product
	ADD FOREIGN KEY (product_type_id)
	REFERENCES product_type (product_type_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE type_language
	ADD FOREIGN KEY (product_type_id)
	REFERENCES product_type (product_type_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE litreage
	ADD FOREIGN KEY (qty_unit_id)
	REFERENCES qty_unit (qty_unit_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product
	ADD FOREIGN KEY (qty_unit_id)
	REFERENCES qty_unit (qty_unit_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product_order
	ADD FOREIGN KEY (qty_unit_id)
	REFERENCES qty_unit (qty_unit_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE shop
	ADD FOREIGN KEY (status_id)
	REFERENCES shop_status (status_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



