 select * from order_form;
 select * from delivery_type;
 select * from order_status;
 select * from delivery_address;
 
EGAR product_media
EGAR literage qty unit
EGAR Product type id Egar Type language
INSERT INTO `feature` (`feature_id`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12);

INSERT INTO `feature_language` (`feature_id`, `language_id`, `feature_name`) VALUES
(1, 1, 'Waterbased & low VOC'),
(2, 1, 'Effective against Feline Calicivirus (approved by EPA to replace human norovirus)'),
(3, 1, 'Mould & mildew resistance'),
(4, 1, 'Good hiding power'),
(5, 1, 'Effective against human Coronavirus when test against human coronavirus 229E'),
(6, 1, 'Anti-bacterial property'),
(7, 1, 'Good flow and levelling'),
(8, 1, 'Good stain resistance and washability'),
(9, 1, 'Excellent stain resistance to common household stains'),
(10, 1, 'Water-resistant'),
(11, 1, 'Long lasting colours'),
(12, 1, 'Excellent flow and leveling');


INSERT INTO `guide` (`guide_id`) VALUES
(1),
(2),
(3),
(4);

INSERT INTO `guide_language` (`language_id`, `guide_id`, `guide_type`, `guide_value`) VALUES
(1, 1, 'Finishes ', 'Matt finish'),
(1, 2, 'Coverage ', '10 – 12 m²/L'),
(1, 3, 'Drying Time ', '2 hour(s)'),
(1, 4, ' Coats ', '2 coats');

INSERT INTO `free_tool` (`tool_id`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9);


select * from feature_language;


select * from feature_language;


select * from product_title_language;


	desc payment_method;
	
ALTER TABLE payment_method ADD COLUMN resp_code varchar(100) NOT NULL AFTER phone;
ALTER TABLE payment_method ADD COLUMN resp_desc varchar(300) NOT NULL AFTER phone;
ALTER TABLE payment_method ADD COLUMN amount double NOT NULL AFTER phone;
ALTER TABLE payment_method ADD COLUMN invoice_no varchar(300) NOT NULL AFTER phone;
ALTER TABLE payment_method ADD COLUMN merchant_user_id varchar(1000) NOT NULL AFTER phone;
ALTER TABLE payment_method ADD COLUMN channel varchar(300) NOT NULL;


ALTER TABLE payment_method DROP COLUMN resp_description;
ALTER TABLE payment_method DROP COLUMN service_name;


ALTER TABLE payment_method CHANGE resp_description resp_desc varchar(300) NOT NULL;
ALTER TABLE payment_method CHANGE service_name channel varchar(300) CHARACTER SET utf8 NOT NULL;

insert into admin_status values(null,'Active','Active');
insert into admin_status values(null,'Block','Block');
insert into admin_status values(null,'Pending','Pending');

insert into folder values(null,'profile');
insert into folder values(null,'freetool');
insert into folder values(null,'other');

de
insert into admin value();


drop view product_feature_language;

CREATE VIEW product_feature_language AS
SELECT 
	product_feature.product_id,
	product_feature.feature_id,
	feature_language.language_id,
	feature_language.feature_name
FROM  product_feature,feature_language
where product_feature.feature_id=feature_language.feature_id
ORDER BY product_feature.product_id ASC;


drop view product_tool_language;

CREATE VIEW product_tool_language AS
SELECT 
	product_free_tool.product_id,
	product_free_tool.tool_id,
	tool_language.language_id,
	tool_language.tool_name
FROM  product_free_tool,tool_language
where product_free_tool.tool_id=tool_language.tool_id
ORDER BY product_free_tool.product_id ASC;


drop view product_guide_language;

CREATE VIEW product_guide_language AS
SELECT 
	product_guide.product_id,
	product_guide.guide_id,
	guide_language.language_id,
	guide_language.guide_type,
	guide_language.guide_value
FROM  product_guide,guide_language
where product_guide.guide_id=product_guide.guide_id
ORDER BY product_guide.product_id ASC;


drop view product_guide_language;

CREATE VIEW product_guide_language AS
SELECT 
	product_guide.product_id,
	product_guide.guide_id,
	guide_language.language_id,
	guide_language.guide_type,
	guide_language.guide_value
FROM  product_guide,guide_language
where product_guide.guide_id=product_guide.guide_id
ORDER BY product_guide.product_id ASC;

drop view product_literage_qtyUnit;

CREATE VIEW product_literage_qtyUnit AS
SELECT 
	product.product_id,
	litreage.unit_price as litreage_unit_price,
	litreage.qty as litreage_qty,
	qty_unit.unit as qty_unit
FROM product,litreage,qty_unit
where 
		product.product_id=litreage.product_id
AND 	litreage.qty_unit_id=qty_unit.qty_unit_id
ORDER BY product.product_id ASC;

drop view product_literage_qtyUnit;



