-- phpMyAdmin SQL Dump
-- version 4.9.4
-- https://www.phpmyadmin.net/
--
-- Host: mysql3000.mochahost.com:3306
-- Generation Time: Feb 20, 2021 at 12:14 AM
-- Server version: 5.6.23
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `drnineni_paint_shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `about_product_language`
--

CREATE TABLE `about_product_language` (
  `product_id` int(11) NOT NULL,
  `language_id` int(11) NOT NULL,
  `about_desc` varchar(1500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `about_product_language`
--

INSERT INTO `about_product_language` (`product_id`, `language_id`, `about_desc`) VALUES
(2, 1, 'Decorate and protect your interior wall surfaces with Nippon Paint Vinilex 5000 Low Odour emulsion paint. A premium grade low odour emulsion paint, it delivers a beautiful smooth matt finish, in a choice of over 1000 colours, Designed to last and give good coverage, there\'s no better basic paint for your walls.'),
(3, 1, 'Nippon Paint 3-in-1 Medifresh anti-bacterial paint has a special anti-bacterial formula, which offers protection from harmful bacteria such as MRSA, E-Coli and Staphylococcus Aureus. 3-in-1 Medifresh anti-bacterial paint is a long-lasting coat that promotes better hygiene and health, while keeping the surroundings clean and fresh.'),
(4, 1, 'Nippon Paint RoofGuard is a high quality and highly durable acrylic-based emulsion that imparts a smooth finish to roof tiles. It contains excellent light-fast and alkali-resistant pigments, and an effective mould-control additive to protect roof tiles. Suitable for application on old and new unglazed roof tiles and other masonry surfaces. Nippon Paint RoofGuard can be used on old and new unglazed roof tiles, cement-fibre sheets, concrete- or cement-fibre pipes. Not recommended for glazed tiles, unless the glazed film has worn off.'),
(5, 1, 'Nippon Paint Gold Paint is a low odour, water-based acrylic paint which can be applied to concrete, gypsum, wood and also metal to provide a gold effect finish. It is formulated for application by roller, brush and spray, providing a uniform distribution of metallic gold pigment across the substrate, giving a smooth finish.'),
(6, 1, 'Easy Wash\r\n- Interior Paints\r\n\r\nFREE Painting Tools included:\r\n\r\n6 inch Euro Frame Blue Handle\r\nRoller King 885 Roller\r\nPainters Tape(for 5L purchases only)'),
(7, 1, 'WoodGuard is an air-drying type of polyurethane which does not require any addition of hardener. It dries quickly to a glossy, durable finish while enhancing the character of the natural grains of wood. With its enhanced UV protection property and flexibility, the varnish protects timber surfaces from the damaging effects of UV rays, making it ideal for exterior deck and outdoor furniture');

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(1000) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `nrc` varchar(200) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `description` varchar(1500) DEFAULT NULL,
  `create_date` date NOT NULL,
  `admin_status_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `name`, `email`, `password`, `phone`, `nrc`, `gender`, `description`, `create_date`, `admin_status_id`) VALUES
(1, 'Min Maung Hein', 'minmaunghein1999@gmail.com', 'admin123', '09790834201', '၆/ထဝန(နိုင်)၁၃၆၄၀၈', 'male', 'Min Maung Hein Description', '2021-01-24', 1),
(2, 'Min Pyae Hein', 'minpyaehein@ucsdawei.edu.mm', 'minpyae', '09455836692', '6/htawanaing136407', 'male', 'admin', '2021-01-25', 1);

-- --------------------------------------------------------

--
-- Table structure for table `admin_status`
--

CREATE TABLE `admin_status` (
  `admin_status_id` int(11) NOT NULL,
  `status_name` varchar(300) NOT NULL,
  `status_desc` varchar(1500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin_status`
--

INSERT INTO `admin_status` (`admin_status_id`, `status_name`, `status_desc`) VALUES
(1, 'Active', 'Active'),
(2, 'Block', 'Block'),
(3, 'Pending', 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `color`
--

CREATE TABLE `color` (
  `color_id` int(11) NOT NULL,
  `html_color_code` varchar(100) NOT NULL,
  `color_name` varchar(200) NOT NULL,
  `color_number` varchar(100) NOT NULL,
  `description` varchar(1500) DEFAULT NULL,
  `color_group_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `color`
--

INSERT INTO `color` (`color_id`, `html_color_code`, `color_name`, `color_number`, `description`, `color_group_id`) VALUES
(1, '#f4d03f', 'Yellow', 'f4d03f', NULL, 1),
(2, '#FF7700', 'Fire Orange', 'S.M.X-X09266', NULL, 1),
(3, '#ff94e0', 'Black Pink', 'MX-O 9705', NULL, 1),
(4, '#C11B17', 'Chilli', 'SS.MX-09700', NULL, 3),
(5, '#4c408e', 'Evening Purple', 'S.MX-09755', NULL, 3),
(6, '#fdb927', 'Lakers', 'SS.MX-09744', NULL, 3),
(7, '#7c6d80', 'Thunder', 'MX-09905', NULL, 3),
(8, '#bed0da', 'SleeplyBlue', 'MX-09602', NULL, 3),
(9, '#1FD537', 'Holiday Green', 'MX-09401', NULL, 3),
(10, '#c0bbab', 'Putty', 'MX-09402', NULL, 3),
(11, '#5fa777', 'Forest Green', 'S.M.X-09444', NULL, 3),
(12, '#b5b35c', 'Oliver Green', 'S.MX-09455', NULL, 3),
(13, '#007071', 'Sea Green', 'SS.MX-09400', NULL, 3),
(14, '#f4d03f', 'Yellow', 'f4d03f', NULL, 3),
(15, '#C58F00', 'Honey Yellow', 'S.MX-09200', NULL, 3),
(16, '#F7BD62', 'Dragon', 'S.MX-09205', NULL, 3),
(17, '#C11B17', 'Chilli', 'SS.MX-09700', NULL, 3),
(18, '#4c408e', 'Evening Purple', 'S.MX-09755', NULL, 3),
(19, '#fdb927', 'Lakers', 'SS.MX-09744', NULL, 3),
(20, '#7c6d80', 'Thunder', 'MX-09905', NULL, 3),
(21, '#bed0da', 'SleeplyBlue', 'MX-09602', NULL, 3),
(22, '#1FD537', 'Holiday Green', 'MX-09401', NULL, 3),
(23, '#c0bbab', 'Putty', 'MX-09402', NULL, 3),
(24, '#5fa777', 'Forest Green', 'S.M.X-09444', NULL, 3),
(25, '#b5b35c', 'Oliver Green', 'S.MX-09455', NULL, 3),
(26, '#007071', 'Sea Green', 'SS.MX-09400', NULL, 3),
(27, '#f4d03f', 'Yellow', 'f4d03f', NULL, 3),
(28, '#C58F00', 'Honey Yellow', 'S.MX-09200', NULL, 3),
(29, '#F7BD62', 'Dragon', 'S.MX-09205', NULL, 3),
(30, '#C11B17', 'Chilli', 'SS.MX-09700', NULL, 3),
(31, '#4c408e', 'Evening Purple', 'S.MX-09755', NULL, 3),
(32, '#fdb927', 'Lakers', 'SS.MX-09744', NULL, 3),
(33, '#7c6d80', 'Thunder', 'MX-09905', NULL, 3),
(34, '#bed0da', 'SleeplyBlue', 'MX-09602', NULL, 3),
(35, '#1FD537', 'Holiday Green', 'MX-09401', NULL, 3),
(36, '#c0bbab', 'Putty', 'MX-09402', NULL, 3),
(37, '#5fa777', 'Forest Green', 'S.M.X-09444', NULL, 3),
(38, '#b5b35c', 'Oliver Green', 'S.MX-09455', NULL, 3),
(39, '#007071', 'Sea Green', 'SS.MX-09400', NULL, 3);

-- --------------------------------------------------------

--
-- Table structure for table `color_group`
--

CREATE TABLE `color_group` (
  `color_group_id` int(11) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `html_color_code` varchar(100) NOT NULL,
  `color_number` varchar(100) NOT NULL,
  `color_name` varchar(100) NOT NULL,
  `description` varchar(1500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `color_group`
--

INSERT INTO `color_group` (`color_group_id`, `name`, `html_color_code`, `color_number`, `color_name`, `description`) VALUES
(1, 'Yellow', '#33d6ff', 'NP BGG 2698 P', 'Yellow', 'NP BGG 2698 P'),
(2, 'Blue-green', '#ff6699', 'NP BGG 1605 T', 'Blue-green', 'NP BGG 1605 T'),
(3, 'Red', '#33d6ff', 'NP R 1280 T', 'Red', 'NP R 1280 T');

-- --------------------------------------------------------

--
-- Table structure for table `delivery_address`
--

CREATE TABLE `delivery_address` (
  `delivery_address_id` int(11) NOT NULL,
  `address` varchar(1500) NOT NULL,
  `delivery_price` double NOT NULL,
  `description` varchar(1500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `delivery_address`
--

INSERT INTO `delivery_address` (`delivery_address_id`, `address`, `delivery_price`, `description`) VALUES
(1, 'ထားဝယ်မြို့တွင်း', 5000, 'ထားဝယ်မြို့အတွင်း အခမဲ့ပို့ဆောင်ပေးပါသည်ရှင်။'),
(2, 'မန္တလေးကားကြီးဝင်း', 5000, 'မန္တလေးကားကြီးဝင်းအရောက်ဝန်ဆောင်ခမှာ ၅၀၀၀ ဖြစ်ပါသည်။'),
(3, 'ရန်ကုန်ကားကြီးဝင်း', 5000, 'ရန်ကုန်ကားကြီးဝင်းအရောက်ဝန်ဆောင်ခမှာ ၅၀၀၀ ဖြစ်ပါသည်။');

-- --------------------------------------------------------

--
-- Table structure for table `delivery_type`
--

CREATE TABLE `delivery_type` (
  `delivery_type_id` int(11) NOT NULL,
  `name` varchar(1500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `delivery_type`
--

INSERT INTO `delivery_type` (`delivery_type_id`, `name`) VALUES
(1, 'ပို့ဆောင်ပေးရန်'),
(2, 'ပို့ဆောင်ရန်မလို');

-- --------------------------------------------------------

--
-- Table structure for table `discount`
--

CREATE TABLE `discount` (
  `discount_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `discount_rate` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `end_date` date NOT NULL,
  `start_date` date NOT NULL,
  `description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `feature`
--

CREATE TABLE `feature` (
  `feature_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `feature`
--

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

-- --------------------------------------------------------

--
-- Table structure for table `feature_language`
--

CREATE TABLE `feature_language` (
  `feature_id` int(11) NOT NULL,
  `language_id` int(11) NOT NULL,
  `feature_name` varchar(1500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `feature_language`
--

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

-- --------------------------------------------------------

--
-- Table structure for table `folder`
--

CREATE TABLE `folder` (
  `folder_id` int(11) NOT NULL,
  `name` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `folder`
--

INSERT INTO `folder` (`folder_id`, `name`) VALUES
(1, 'profile'),
(2, 'freetool'),
(3, 'other'),
(4, 'profile'),
(5, 'CoverPhoto'),
(6, 'Other');

-- --------------------------------------------------------

--
-- Table structure for table `free_tool`
--

CREATE TABLE `free_tool` (
  `tool_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `free_tool`
--

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

-- --------------------------------------------------------

--
-- Table structure for table `group_language`
--

CREATE TABLE `group_language` (
  `product_group_id` int(11) NOT NULL,
  `language_id` int(11) NOT NULL,
  `name` varchar(1500) NOT NULL,
  `description` varchar(1500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `group_language`
--

INSERT INTO `group_language` (`product_group_id`, `language_id`, `name`, `description`) VALUES
(5, 1, 'Nippon Paints', 'Anti-Viral Room Protection Bundle BRAND NEW BUNDLE  Protect your loved ones today by reducing surface contamination with viruses and bacteria.  Get everything you need with our Anti-Viral Room Protection Bundle!'),
(6, 1, 'UPG Paints', ' Welcome to UPG Since its establishment in 1995, UPG PAINT & COATING CO., LTD. has developed a wide range of products.  It has been producing architecture paints, decorative paints, industrial paints, marine paints ... '),
(7, 1, 'HHHHH', 'HHHH');

-- --------------------------------------------------------

--
-- Table structure for table `guide`
--

CREATE TABLE `guide` (
  `guide_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `guide`
--

INSERT INTO `guide` (`guide_id`) VALUES
(1),
(2),
(3),
(4);

-- --------------------------------------------------------

--
-- Table structure for table `guide_language`
--

CREATE TABLE `guide_language` (
  `language_id` int(11) NOT NULL,
  `guide_id` int(11) NOT NULL,
  `guide_type` varchar(1500) NOT NULL,
  `guide_value` varchar(1500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `guide_language`
--

INSERT INTO `guide_language` (`language_id`, `guide_id`, `guide_type`, `guide_value`) VALUES
(1, 1, 'Finishes ', 'Matt finish'),
(1, 2, 'Coverage ', '10 – 12 m²/L'),
(1, 3, 'Drying Time ', '2 hour(s)'),
(1, 4, ' Coats ', '2 coats');

-- --------------------------------------------------------

--
-- Table structure for table `language`
--

CREATE TABLE `language` (
  `language_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `code` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `language`
--

INSERT INTO `language` (`language_id`, `name`, `code`) VALUES
(1, 'english', '001'),
(2, 'Myanmar', '002'),
(3, 'Japan', '003');

-- --------------------------------------------------------

--
-- Table structure for table `litreage`
--

CREATE TABLE `litreage` (
  `litreage_id` int(11) NOT NULL,
  `qty_unit_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `unit_price` double NOT NULL,
  `description` varchar(1500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `litreage`
--

INSERT INTO `litreage` (`litreage_id`, `qty_unit_id`, `product_id`, `qty`, `unit_price`, `description`) VALUES
(3, 1, 2, 2, 1700, 'yaung say'),
(4, 1, 3, 6, 1700, 'ddg'),
(5, 1, 3, 12, 12000, 'yes'),
(6, 2, 3, 4, 1300, 'yes'),
(7, 1, 4, 56, 1270, 'yes'),
(8, 1, 4, 7, 2099, 'no'),
(9, 1, 5, 12, 5800, 'yes'),
(10, 1, 5, 22, 34000, 'yes'),
(11, 1, 6, 4, 1700, '78000'),
(12, 2, 6, 34, 1700, 'yes'),
(13, 1, 7, 2, 1500, '1500');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `member_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(200) NOT NULL,
  `password` varchar(1000) NOT NULL,
  `mail` varchar(200) NOT NULL,
  `address` varchar(1500) DEFAULT NULL,
  `note` varchar(1000) DEFAULT NULL,
  `create_date` date NOT NULL,
  `member_status_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`member_id`, `name`, `phone`, `password`, `mail`, `address`, `note`, `create_date`, `member_status_id`) VALUES
(1, 'Daw Ni Ni Yu', '098741515', 'member1999', 'niniwin1999@gmail.com', 'dawei', 'Daw Ni Ni Yu', '2021-02-12', 1),
(2, 'Pyae Sone Htet', '09773608700', '123456', 'pyaesonehtet432@gmail.com', 'dawei', 'Pyae Sone Htet', '2021-02-13', 1),
(3, 'Pyae Sone Htet', '09773608700', '123456', 'kokopyae2345@gmail.com', 'Yangon', 'Pyae Sone Htet', '2021-02-13', 1),
(4, 'May Thu Zin', '09967025640', '12345678', 'maythuzin2412@gmail.com', 'Taungoo', 'May Thu Zin', '2021-02-13', 1),
(5, 'May Thu Zin', '09967025640', '12345678', 'maythuzin2412@gmail.com', 'Taungoo', 'May Thu Zin', '2021-02-13', 1),
(6, 'Htetlinko', '09978024133', 'hlk1234', 'htetlinko.hlk1998@gmail.com', 'Nyaunglaypin', 'Htetlinko', '2021-02-13', 1),
(7, 'Daw Ni Ni Yu', '098741515', 'member1999', 'niniwin1999@gmail.com', 'dawei', 'Daw Ni Ni Yu', '2021-02-15', 1),
(8, '', '', '', '', '', '', '2021-02-17', 1),
(9, 'Min Mg', '09790834201', 'admin123', 'minmaunghein1999@gmail.com', 'Dawei', 'Min Mg', '2021-02-18', 1),
(10, 'Min Pyae Hein', '09455836692', 'minpyae', 'minpyaehein.ucsdawei@gmail.com', 'Dawei', 'Min Pyae Hein', '2021-02-18', 1),
(11, 'Linn Htet Ko', '09790834201', 'admin', 'minmaunghein1999@gmail.com', 'Dawei', 'Linn Htet Ko', '2021-02-18', 1),
(12, 'Min Mg', '09790834201', 'admin123', 'minmaunghein1999@gmail.com', 'Dawei', 'Min Mg', '2021-02-18', 1);

-- --------------------------------------------------------

--
-- Table structure for table `member_order_form`
--

CREATE TABLE `member_order_form` (
  `order_form_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `member_status`
--

CREATE TABLE `member_status` (
  `member_status_id` int(11) NOT NULL,
  `status_name` varchar(1500) NOT NULL,
  `status_desc` varchar(1500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `member_status`
--

INSERT INTO `member_status` (`member_status_id`, `status_name`, `status_desc`) VALUES
(1, 'Normal User', 'Normal User');

-- --------------------------------------------------------

--
-- Table structure for table `one_pay_payment_method`
--

CREATE TABLE `one_pay_payment_method` (
  `payment_method_id` int(11) NOT NULL,
  `merchant_user_Id` varchar(1000) NOT NULL,
  `serial_id` varchar(1000) NOT NULL,
  `channel` varchar(300) NOT NULL,
  `invoice_no` varchar(300) NOT NULL,
  `amount` double NOT NULL,
  `phone` varchar(100) NOT NULL,
  `resp_code` varchar(100) NOT NULL,
  `resp_desc` varchar(300) NOT NULL,
  `description` varchar(1500) DEFAULT NULL,
  `items` varchar(1500) DEFAULT NULL,
  `create_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `one_pay_payment_method`
--

INSERT INTO `one_pay_payment_method` (`payment_method_id`, `merchant_user_Id`, `serial_id`, `channel`, `invoice_no`, `amount`, `phone`, `resp_code`, `resp_desc`, `description`, `items`, `create_date`) VALUES
(9, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE9839', 'EVOLVE MYANMAR', 'INV035', 1000, '09790834201', '012', 'Cancel Transaction', 'Success Direct Payment', NULL, '2021-01-31'),
(10, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98310', 'EVOLVE MYANMAR', 'INV035', 1000, '09790834201', '012', 'Cancel Transaction', 'Cancel Transaction', NULL, '2021-01-31'),
(11, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98311', 'EVOLVE MYANMAR', 'INV039', 1000, '09790834201', '000', 'Success', 'Success Direct Payment', NULL, '2021-01-31'),
(12, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98312', 'EVOLVE MYANMAR', 'INV0013', 1000, '09790834201', '000', 'Success', 'Success Direct Payment', NULL, '2021-01-31'),
(13, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98313', 'EVOLVE MYANMAR', 'INV0013', 1000, '09962715428', '012', 'Cancel Transaction', 'Cancel Transaction', NULL, '2021-01-31'),
(14, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98314', 'EVOLVE MYANMAR', 'INV0013', 1000, '09962715428', '012', 'Cancel Transaction', 'Cancel Transaction', NULL, '2021-01-31'),
(15, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98315', 'EVOLVE MYANMAR', '1012', 1000, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-01-31'),
(16, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98316', 'EVOLVE MYANMAR', '1023', 500, '09790834201', '000', 'Success', 'Success Direct Payment', NULL, '2021-01-31'),
(17, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98317', 'EVOLVE MYANMAR', '46467', 1500, '09978024133', '012', 'Cancel Transaction', 'Cancel Transaction', NULL, '2021-01-31'),
(18, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98318', 'EVOLVE MYANMAR', 'INV0013', 1000, '09790834201', '000', 'Success', 'Success Direct Payment', NULL, '2021-01-31'),
(19, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98319', 'EVOLVE MYANMAR', 'INV0013', 1000, '09790834201', '000', 'Success', 'Success Direct Payment', NULL, '2021-01-31'),
(20, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98320', 'EVOLVE MYANMAR', 'INV0013', 1000, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-01-31'),
(21, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98321', 'EVOLVE MYANMAR', '001', 1000, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-01-31'),
(22, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98322', 'EVOLVE MYANMAR', '001', 1700, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-01-31'),
(23, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98323', 'EVOLVE MYANMAR', '001', 650, '09962715428', '014', 'System Security Error', 'Payment Success', NULL, '2021-01-31'),
(24, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98324', 'EVOLVE MYANMAR', 'INV003', 650, '09962715428', '014', 'System Security Error', 'Payment Success', NULL, '2021-01-31'),
(25, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98325', 'EVOLVE MYANMAR', 'INV003', 650, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-01-31'),
(26, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98326', 'EVOLVE MYANMAR', 'INV003', 650, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-01-31'),
(27, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98327', 'EVOLVE MYANMAR', 'INV003', 39000, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-01-31'),
(28, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98328', 'EVOLVE MYANMAR', 'INV003', 650, '09962715428', '014', 'System Security Error', 'Payment Success', NULL, '2021-01-31'),
(29, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98329', 'EVOLVE MYANMAR', 'INV003', 1300, '09962715428', '014', 'System Security Error', 'Payment Success', NULL, '2021-01-31'),
(30, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98330', 'EVOLVE MYANMAR', 'INV003', 6900, '09978024133', '014', 'System Security Error', 'Payment Success', NULL, '2021-02-01'),
(31, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98331', 'EVOLVE MYANMAR', 'INV003', 95000, '09978024133', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-01'),
(32, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98332', 'EVOLVE MYANMAR', 'INV060', 1000, '09790834201', '000', 'Success', 'Payment Success', NULL, '2021-02-13'),
(33, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98333', 'EVOLVE MYANMAR', 'INV038', 2300, '09790834201', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-13'),
(34, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98334', 'EVOLVE MYANMAR', 'INV003', 2300, '09978024133', '000', 'Success', 'Payment Success', NULL, '2021-02-13'),
(35, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98335', 'EVOLVE MYANMAR', 'INV003', 4600, '09978024133', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-13'),
(36, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98336', 'EVOLVE MYANMAR', 'INV003', 5100, '09978024133', '000', 'Success', 'Payment Success', NULL, '2021-02-13'),
(37, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98337', 'EVOLVE MYANMAR', 'INV003', 2300, '09978024133', '000', 'Success', 'Payment Success', NULL, '2021-02-13'),
(38, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98338', 'EVOLVE MYANMAR', 'INV003', 2300, '09978024133', '012', 'Cancel Transaction', 'Cancel Transaction', NULL, '2021-02-13'),
(39, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98339', 'EVOLVE MYANMAR', 'INV003', 2300, '09978024133', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-13'),
(40, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98340', 'EVOLVE MYANMAR', 'INV003', 2300, '09978024133', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-13'),
(41, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98341', 'EVOLVE MYANMAR', 'INV003', 650, '09978024133', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-13'),
(42, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98342', 'EVOLVE MYANMAR', 'INV003', 650, '09978024133', '000', 'Success', 'Payment Success', NULL, '2021-02-13'),
(43, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98343', 'EVOLVE MYANMAR', 'INV003', 2300, '09962715428', '000', 'Success', 'Payment Success', NULL, '2021-02-13'),
(44, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98344', 'EVOLVE MYANMAR', 'INV003', 2300, '09962715428', '012', 'Cancel Transaction', 'Cancel Transaction', NULL, '2021-02-13'),
(45, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98345', 'EVOLVE MYANMAR', 'INV003', 2300, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-13'),
(46, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98346', 'EVOLVE MYANMAR', 'INV003', 2300, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-13'),
(47, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98347', 'EVOLVE MYANMAR', 'INV003', 2300, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-13'),
(48, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98348', 'EVOLVE MYANMAR', 'INV003', 2300, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-13'),
(49, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98349', 'EVOLVE MYANMAR', 'INV003', 2300, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-13'),
(50, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98350', 'EVOLVE MYANMAR', 'INV003', 2300, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-13'),
(51, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98351', 'EVOLVE MYANMAR', 'INV003', 2300, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-13'),
(52, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98352', 'EVOLVE MYANMAR', 'INV003', 2300, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-13'),
(53, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98353', 'EVOLVE MYANMAR', 'INV003', 2300, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-13'),
(54, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98354', 'EVOLVE MYANMAR', 'INV003', 2300, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-13'),
(55, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98355', 'EVOLVE MYANMAR', 'INV003', 2300, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-13'),
(56, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98356', 'EVOLVE MYANMAR', 'INV003', 3000, '09962715428', '000', 'Success', 'Payment Success', NULL, '2021-02-13'),
(57, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98357', 'EVOLVE MYANMAR', 'INV003', 3000, '09962715428', '000', 'Success', 'Payment Success', NULL, '2021-02-13'),
(58, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98358', 'EVOLVE MYANMAR', 'INV003', 2300, '09962715428', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-13'),
(59, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98359', 'EVOLVE MYANMAR', 'INV0013', 1500, '09790834201', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-16'),
(60, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98360', 'EVOLVE MYANMAR', 'Order_001', 119000, '09790834201', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-17'),
(61, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98361', 'EVOLVE MYANMAR', 'Order_001', 119000, '09790834201', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-17'),
(62, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98362', 'EVOLVE MYANMAR', 'INV0013', 1500, '09790834201', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-17'),
(63, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98363', 'EVOLVE MYANMAR', 'INV0013', 1500, '09790834201', '012', 'Cancel Transaction', 'Cancel Transaction', NULL, '2021-02-17'),
(64, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98364', 'EVOLVE MYANMAR', 'INV0013', 1500, '09790834201', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-17'),
(65, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98365', 'EVOLVE MYANMAR', 'INV003', 2300, '09978024133', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-18'),
(66, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98366', 'EVOLVE MYANMAR', 'INV003', 2300, '09978024133', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-18'),
(67, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98367', 'EVOLVE MYANMAR', 'INV003', 2300, '09978024133', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-18'),
(68, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98368', 'EVOLVE MYANMAR', 'INV003', 2300, '09978024133', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-18'),
(69, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98369', 'EVOLVE MYANMAR', 'INV003', 2300, '09978024133', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-18'),
(70, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98370', 'EVOLVE MYANMAR', 'INV003', 2300, '09978024133', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-18'),
(71, 'MM202144071244435371349', 'CEF11DB8546456B9F10055510143AE98371', 'EVOLVE MYANMAR', 'INV003', 2300, '09978024133', '000', 'Success', 'Success Direct Payment', NULL, '2021-02-18');

-- --------------------------------------------------------

--
-- Table structure for table `order_form`
--

CREATE TABLE `order_form` (
  `order_form_id` int(11) NOT NULL,
  `delivery_type_id` int(11) NOT NULL,
  `payment_method_id` int(11) NOT NULL,
  `delivery_address_id` int(11) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `address_details` varchar(1500) NOT NULL,
  `create_date` date NOT NULL,
  `total_dicount_rate` double NOT NULL,
  `total_price` double NOT NULL,
  `note` varchar(2000) DEFAULT NULL,
  `status_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_form`
--

INSERT INTO `order_form` (`order_form_id`, `delivery_type_id`, `payment_method_id`, `delivery_address_id`, `phone`, `address_details`, `create_date`, `total_dicount_rate`, `total_price`, `note`, `status_id`) VALUES
(1, 1, 46, 1, '09790834201', 'No(720)Ka Myaw Kin Road, OakTha Yan Quater,Dawei', '2021-02-18', 0, 1000, 'OnePay Appကိုအသုံးပြု၍ငွေပေးခြေမှူပြီးပါပြီ', 2),
(2, 1, 47, 1, '09790834201', 'အမှတ်(720)ကမြောကင်းလမ်း ဉသာရံရပ် ထားဝယ် မြို့', '2021-02-18', 0, 1700, 'OnePay Appကိုအသုံးပြု၍ငွေပေးခြေမှူပြီးပါပြီ', 2),
(3, 1, 48, 1, '09790834201', 'အမှတ်(720)ကမြောကင်းလမ်း ဥဿရံရပ် ထားဝယ် မြို့', '2021-02-18', 0, 3400, 'OnePay Appကိုအသုံးပြု၍ငွေပေးခြေမှူပြီးပါပြီ', 2),
(4, 1, 49, 1, '09790834201', 'No(720)Ka Myaw Kin Road, OakTha Yan Quater,Dawei', '2021-02-19', 0, 119000, 'Success', 1),
(5, 1, 50, 1, '09790834201', 'No(720)Ka Myaw Kin Road, OakTha Yan Quater,Dawei', '2021-02-19', 0, 119000, 'Success', 1),
(6, 1, 51, 1, '09790834201', 'No(720)Ka Myaw Kin Road, OakTha Yan Quater,Dawei', '2021-02-19', 0, 119000, 'Success', 1),
(7, 1, 52, 1, '09790834201', 'No(720)Ka Myaw Kin Road, OakTha Yan Quater,Dawei', '2021-02-19', 0, 119000, 'Success', 1);

-- --------------------------------------------------------

--
-- Table structure for table `order_status`
--

CREATE TABLE `order_status` (
  `status_id` int(11) NOT NULL,
  `status_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_status`
--

INSERT INTO `order_status` (`status_id`, `status_name`) VALUES
(1, 'ငွေမရှင်းသေးပါ'),
(2, 'ငွေရှင်းပြီးပါပြီ');

-- --------------------------------------------------------

--
-- Table structure for table `payment_method`
--

CREATE TABLE `payment_method` (
  `payment_method_id` int(11) NOT NULL,
  `serial_id` varchar(1500) NOT NULL,
  `create_date` date NOT NULL,
  `phone` varchar(100) NOT NULL,
  `invoice_no` varchar(300) NOT NULL,
  `resp_desc` varchar(300) NOT NULL,
  `description` varchar(1500) DEFAULT NULL,
  `resp_code` varchar(100) NOT NULL,
  `merchant_user_id` varchar(300) NOT NULL,
  `amount` double NOT NULL,
  `channel` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payment_method`
--

INSERT INTO `payment_method` (`payment_method_id`, `serial_id`, `create_date`, `phone`, `invoice_no`, `resp_desc`, `description`, `resp_code`, `merchant_user_id`, `amount`, `channel`) VALUES
(20, 'CEF11DB8546456B9F10055510143AE98320', '2021-02-17', '09790834201', 'Order_001', 'Duplicate Sequence No.', 'Success Direct Payment', '906', 'MM202144071244435371349', 1000, 'EVOLVE MYANMAR'),
(21, 'CEF11DB8546456B9F10055510143AE98321', '2021-02-17', '09790834201', 'Order_001', 'Duplicate Sequence No.', 'Success Direct Payment', '906', 'MM202144071244435371349', 1000, 'EVOLVE MYANMAR'),
(35, 'jkcvhchvujfhguifghf', '2021-02-01', '0979084', 'fdfdfdfdf', 'fddsf', 'dffdfdf', 'fgfgfgf', 'cxfdfd', 1300, 'fdfdfdfdfd'),
(40, 'jkcvhchvujfhguifghf', '2021-02-01', '0979084', 'fdfdfdfdf', 'fddsf', 'dffdfdf', 'fgfgfgf', 'cxfdfd', 1300, 'fdfdfdfdfd'),
(41, 'CEF11DB8546456B9F10055510143AE98341', '2021-02-17', '09790834201', 'Order_001', 'Duplicate Sequence No.', 'Success Direct Payment', '906', 'MM202144071244435371349', 1000, 'EVOLVE MYANMAR'),
(42, 'CEF11PAINTDR8903333AE98110011342', '2021-02-17', '09790834201', 'Order_001', 'Success', 'Success Direct Payment', '000', 'MM202144071244435371349', 1000, 'EVOLVE MYANMAR'),
(43, 'CEF11PAINTDR8903333AE98110011343', '2021-02-17', '09790834201', 'Order_001', 'Success', 'Success Direct Payment', '000', 'MM202144071244435371349', 1000, 'EVOLVE MYANMAR'),
(44, 'CEF11PAINTDR8903333AE98110011344', '2021-02-17', '09790834201', 'Order_001', 'Success', 'Success Direct Payment', '000', 'MM202144071244435371349', 1000, 'EVOLVE MYANMAR'),
(45, 'CEF11PAINTDR8903333AE98110011345', '2021-02-18', '09790834201', 'Order_001', 'Success', 'Payment Success', '000', 'MM202144071244435371349', 11600, 'EVOLVE MYANMAR'),
(46, 'CEF11PAINTDR8903333AE98110011346', '2021-02-18', '09790834201', '1', 'Success', 'Payment Success', '000', 'MM202144071244435371349', 1000, 'EVOLVE MYANMAR'),
(47, 'CEF11PAINTDR8903333AE98110011347', '2021-02-18', '09790834201', '2', 'Success', 'Payment Success', '000', 'MM202144071244435371349', 1700, 'EVOLVE MYANMAR'),
(48, 'CEF11PAINTDR8903333AE98110011348', '2021-02-18', '09790834201', '3', 'Success', 'Payment Success', '000', 'MM202144071244435371349', 3400, 'EVOLVE MYANMAR'),
(49, 'CEF11PAINTDR8903333AE98110011349', '2021-02-19', '09790834201', '4', 'Success', 'Success Direct Payment', '000', 'MM202144071244435371349', 119000, 'EVOLVE MYANMAR'),
(50, 'CEF11PAINTDR8903333AE98110011350', '2021-02-19', '09790834201', '5', 'Success', 'Success Direct Payment', '000', 'MM202144071244435371349', 119000, 'EVOLVE MYANMAR'),
(51, 'CEF11PAINTDR8903333AE98110011351', '2021-02-19', '09790834201', '6', 'Success', 'Success Direct Payment', '000', 'MM202144071244435371349', 119000, 'EVOLVE MYANMAR'),
(52, 'CEF11PAINTDR8903333AE98110011352', '2021-02-19', '09790834201', '7', 'Success', 'Success Direct Payment', '000', 'MM202144071244435371349', 119000, 'EVOLVE MYANMAR');

-- --------------------------------------------------------

--
-- Table structure for table `payment_method_owner`
--

CREATE TABLE `payment_method_owner` (
  `payment_method_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_type_id` int(11) NOT NULL,
  `create_date` date NOT NULL,
  `total_qty` int(11) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `qty_unit_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_type_id`, `create_date`, `total_qty`, `admin_id`, `qty_unit_id`, `status_id`) VALUES
(2, 7, '2021-01-25', 3000, 1, 1, 1),
(3, 7, '2021-01-25', 3400, 1, 1, 1),
(4, 8, '2021-01-25', 2000, 1, 1, 1),
(5, 9, '2021-01-25', 23, 1, 1, 1),
(6, 7, '2021-01-25', 34, 1, 1, 1),
(7, 10, '2021-02-18', 200, 2, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `product_color_group`
--

CREATE TABLE `product_color_group` (
  `product_id` int(11) NOT NULL,
  `color_group_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_color_group`
--

INSERT INTO `product_color_group` (`product_id`, `color_group_id`) VALUES
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 2),
(3, 3),
(4, 3),
(5, 3),
(6, 3),
(7, 3);

-- --------------------------------------------------------

--
-- Table structure for table `product_feature`
--

CREATE TABLE `product_feature` (
  `product_id` int(11) NOT NULL,
  `feature_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_feature`
--

INSERT INTO `product_feature` (`product_id`, `feature_id`) VALUES
(2, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(2, 2),
(6, 2),
(2, 3),
(5, 3),
(6, 3),
(7, 4),
(3, 5),
(4, 5),
(7, 5),
(3, 6),
(4, 6),
(5, 6),
(3, 7),
(3, 8),
(4, 8);

-- --------------------------------------------------------

--
-- Table structure for table `product_free_tool`
--

CREATE TABLE `product_free_tool` (
  `product_id` int(11) NOT NULL,
  `tool_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_free_tool`
--

INSERT INTO `product_free_tool` (`product_id`, `tool_id`) VALUES
(2, 1),
(5, 1),
(6, 1),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(2, 3),
(3, 3),
(4, 3),
(5, 3),
(6, 3),
(3, 4),
(7, 4),
(7, 8);

-- --------------------------------------------------------

--
-- Table structure for table `product_group`
--

CREATE TABLE `product_group` (
  `product_group_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_group`
--

INSERT INTO `product_group` (`product_group_id`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7);

-- --------------------------------------------------------

--
-- Table structure for table `product_guide`
--

CREATE TABLE `product_guide` (
  `product_id` int(11) NOT NULL,
  `guide_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_guide`
--

INSERT INTO `product_guide` (`product_id`, `guide_id`) VALUES
(2, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 2),
(3, 3),
(4, 3),
(5, 3),
(6, 3),
(7, 3),
(3, 4),
(4, 4),
(7, 4);

-- --------------------------------------------------------

--
-- Stand-in structure for view `product_guide_language`
-- (See below for the actual view)
--
CREATE TABLE `product_guide_language` (
`product_id` int(1)
,`guide_id` int(1)
,`language_id` int(1)
,`guide_type` int(1)
,`guide_value` int(1)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `product_literage_qtyunit`
-- (See below for the actual view)
--
CREATE TABLE `product_literage_qtyunit` (
`product_id` int(1)
,`litreage_unit_price` int(1)
,`litreage_qty` int(1)
,`qty_unit` int(1)
);

-- --------------------------------------------------------

--
-- Table structure for table `product_media`
--

CREATE TABLE `product_media` (
  `product_media_id` int(11) NOT NULL,
  `folder_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `create_date` date NOT NULL,
  `media_type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_media`
--

INSERT INTO `product_media` (`product_media_id`, `folder_id`, `product_id`, `create_date`, `media_type`) VALUES
(3, 1, 2, '2021-01-25', 'jpg'),
(4, 5, 2, '2021-01-25', ''),
(5, 6, 2, '2021-01-25', ''),
(6, 1, 3, '2021-01-25', 'jpg'),
(7, 3, 3, '2021-01-25', ''),
(8, 5, 3, '2021-01-25', ''),
(9, 1, 4, '2021-01-25', 'jpg'),
(10, 5, 4, '2021-01-25', ''),
(11, 1, 5, '2021-01-25', 'jpg'),
(12, 5, 5, '2021-01-25', ''),
(13, 6, 5, '2021-01-25', ''),
(14, 1, 6, '2021-01-25', 'jpg'),
(15, 3, 6, '2021-01-25', ''),
(17, 1, 7, '2021-02-18', 'jpg');

-- --------------------------------------------------------

--
-- Table structure for table `product_order`
--

CREATE TABLE `product_order` (
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `order_form_id` int(11) NOT NULL,
  `qty_unit_id` int(11) NOT NULL,
  `color_id` int(11) NOT NULL,
  `litreage_id` int(11) NOT NULL,
  `order_qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_order`
--

INSERT INTO `product_order` (`order_id`, `product_id`, `order_form_id`, `qty_unit_id`, `color_id`, `litreage_id`, `order_qty`) VALUES
(1, 3, 7, 1, 23, 3, 3),
(2, 4, 7, 1, 23, 3, 1),
(3, 5, 7, 1, 23, 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `product_status`
--

CREATE TABLE `product_status` (
  `status_id` int(11) NOT NULL,
  `status_name` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_status`
--

INSERT INTO `product_status` (`status_id`, `status_name`, `description`) VALUES
(1, 'Available', 'Available'),
(2, 'Delete', 'Delete'),
(3, 'Sold Out', 'Sold Out');

-- --------------------------------------------------------

--
-- Table structure for table `product_title_language`
--

CREATE TABLE `product_title_language` (
  `product_id` int(11) NOT NULL,
  `language_id` int(11) NOT NULL,
  `name` varchar(1500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_title_language`
--

INSERT INTO `product_title_language` (`product_id`, `language_id`, `name`) VALUES
(2, 1, 'vinilex-5000'),
(3, 1, '3-in-1 Medifresh '),
(4, 1, 'RoofGuard'),
(5, 1, 'Gold Paint SHARE'),
(6, 1, 'Easy Wash'),
(7, 1, 'WoodGuard');

-- --------------------------------------------------------

--
-- Stand-in structure for view `product_tool_language`
-- (See below for the actual view)
--
CREATE TABLE `product_tool_language` (
`product_id` int(1)
,`tool_id` int(1)
,`language_id` int(1)
,`tool_name` int(1)
);

-- --------------------------------------------------------

--
-- Table structure for table `product_type`
--

CREATE TABLE `product_type` (
  `product_type_id` int(11) NOT NULL,
  `product_group_id` int(11) NOT NULL,
  `html_color_code` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_type`
--

INSERT INTO `product_type` (`product_type_id`, `product_group_id`, `html_color_code`) VALUES
(7, 5, '#99ffcc'),
(8, 5, '#ff6600'),
(9, 5, '#cc3300'),
(10, 5, '#ff9980');

-- --------------------------------------------------------

--
-- Table structure for table `qty_unit`
--

CREATE TABLE `qty_unit` (
  `qty_unit_id` int(11) NOT NULL,
  `unit` varchar(400) NOT NULL,
  `description` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `qty_unit`
--

INSERT INTO `qty_unit` (`qty_unit_id`, `unit`, `description`) VALUES
(1, 'Liter', 'Liter'),
(2, 'Grams', 'Grams');

-- --------------------------------------------------------

--
-- Table structure for table `shop`
--

CREATE TABLE `shop` (
  `shop_id` int(11) NOT NULL,
  `name` varchar(500) NOT NULL,
  `email` varchar(200) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `address` varchar(1500) NOT NULL,
  `description` varchar(1500) DEFAULT NULL,
  `create_date` date NOT NULL,
  `admin_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shop_status`
--

CREATE TABLE `shop_status` (
  `status_id` int(11) NOT NULL,
  `status_name` varchar(200) NOT NULL,
  `description` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tool_language`
--

CREATE TABLE `tool_language` (
  `language_id` int(11) NOT NULL,
  `tool_id` int(11) NOT NULL,
  `tool_name` varchar(1500) DEFAULT NULL,
  `tool_description` varchar(1500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tool_language`
--

INSERT INTO `tool_language` (`language_id`, `tool_id`, `tool_name`, `tool_description`) VALUES
(1, 1, '6 inch Euro Frame Blue Handle ', '\r\nQty: 1\r\n*Only for 5 Litre purchases\r\nApplication Instructions:\r\n\r\n    Dampen the rollers (with water or appropriate thinner) to condition them for better efficiency.\r\n    Remove excess moisture before painting.\r\n    Apply the paint from top right hand corner of the first wall.\r\n    Paint in overlapping up-and-down strokes.\r\n'),
(1, 2, 'Roller King 885 Roller ', '\r\nColour: Green\r\nSize: 6 inch\r\nQty: 1\r\n*Only for 5 Litre purchases\r\nMaterial/Purposes:\r\n\r\n    Industrial paint-roller for all surfaces.\r\n    Supreme blend of high performance delivers top results.\r\n    German Technology.\r\n    High quality and area coverage.\r\n    Saves paint, no pile dropping.\r\n    Absorbs more paint through superior fibre quality.\r\n    Easy to apply and clean.\r\n'),
(1, 3, 'Painters Tape ', '\r\nSize: 1.5 inch\r\nQty: 1\r\n*Only for 5 Litre purchases\r\nMaterial/Purposes:\r\n\r\n    General purpose, strong adhesive.\r\n    Ideal for trim marking.\r\n    Easy hand tearing, yet resists slivering.\r\n    Easy removal without residue.\r\n\r\nApplication Instructions:\r\n\r\n    Before painting, use masking tape to protect light switches, electrical sockets, window frames and wood work.\r\n    Strip 8 to 10 inches of tape from the roll and use the roll itself,held tightly against the wall, to pull the tape straight.\r\n    Remove tape at about a 45-degree angle to the painted surface to minimize the tendency for paint to peel.\r\n    Do not use outdoor as UV may cause tape to become very difficult to remove.\r\n'),
(1, 4, '6 inch Euro Frame Blue Handle ', '*Only for 5 Litre purchases\r\nApplication Instructions:\r\n\r\n    Dampen the rollers (with water or appropriate thinner) to condition them for better efficiency.\r\n    Remove excess moisture before painting.\r\n    Apply the paint from top right hand corner of the first wall.\r\n    Paint in overlapping up-and-down strokes.\r\n'),
(1, 5, 'Synthetic Paint Brush', 'Made with a combination of synthetic materials, the brushes are best suited for water-based paints. Relatively cost effective and suitable for Muslim customers'),
(1, 6, 'Premium Dropsheet with Anti Skid', 'Material/Purposes:\r\nNon slip, waterproof, mildewproof.\r\nEasy spread out, one-piece construction.\r\nProtects against paint spills and splashes.\r\nCover vehicles & furnishings to protect against dust and dirt.'),
(1, 7, 'Roller King 885 Roller', 'Material/Purposes:\r\nIndustrial paint-roller for all surfaces.\r\nSupreme blend of high performance delivers top results.\r\nGerman Technology.'),
(1, 8, 'Plastic Paint Tray', 'Application Instructions:\r\nDip paint roller into the well to coat it with paint.\r\nRoll the paint roller back and forth on the ridged part of the tray to squeeze out excess paint and evenly spread out the paint around the roller.'),
(1, 9, 'Painters Tape', 'Application Instructions:\r\nBefore painting, use masking tape to protect light switches, electrical sockets, window frames and wood work.');

-- --------------------------------------------------------

--
-- Table structure for table `type_language`
--

CREATE TABLE `type_language` (
  `product_type_id` int(11) NOT NULL,
  `language_id` int(11) NOT NULL,
  `name` varchar(3000) NOT NULL,
  `description` varchar(1500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `type_language`
--

INSERT INTO `type_language` (`product_type_id`, `language_id`, `name`, `description`) VALUES
(7, 1, 'Internor Paint', 'Our Interior Paints come in a vast spectrum of classic and contemporary colour wall paints, with finishes ranging from matt to glossy. And if you thought paint merely added colour, think again. Specialised paints include easy-to-wash coatings and anti-bacterial paints that protect your family as well as your walls from harm. These are the best interior paints colour that you can find!'),
(8, 1, 'Exterior Paint', 'Our tropical climate is extremely hard and demanding on Exterior Paints. That is why Nippon Paint exterior paint products combine high performance & durability with beauty, keeping your exterior wall painting looking beautiful for years after application.  Nippon Paint Exterior Paints come in a wide range of sought-after colours, and incorporate a plethora of benefits and features, such as in-built anti-fungal and weather-resistant properties.'),
(9, 1, 'Wood & Metal Paints SHARE', 'Nippon Paint makes a range of hard-working Wood and Metal Paints for doors and door-frames, furniture, exposed piping and every imaginable surface in your home. High performance, durable and easy to apply, Nippon\'s paint for wood and paint for metal are the perfect complement to Nippon Paint wall and ceiling paints, and promise the perfect pairing of durability and beauty.'),
(10, 1, ' Wood Paints', 'Wood furniture gives your home a cosy and polished feel. However, their colours tend to fade over time with exposure to air and sunlight. That’s why wood surfaces have to be protected with a coat of paint that has been specially formulated for it.  At Nippon Paint Singapore, we have 5 different types of wood paints that can help you to shield your furniture and/or enhance the look of the material.');

-- --------------------------------------------------------

--
-- Structure for view `product_guide_language`
--
DROP TABLE IF EXISTS `product_guide_language`;

CREATE ALGORITHM=UNDEFINED DEFINER=`drnineni`@`mocha6008.mochahost.com` SQL SECURITY DEFINER VIEW `product_guide_language`  AS  select 1 AS `product_id`,1 AS `guide_id`,1 AS `language_id`,1 AS `guide_type`,1 AS `guide_value` ;

-- --------------------------------------------------------

--
-- Structure for view `product_literage_qtyunit`
--
DROP TABLE IF EXISTS `product_literage_qtyunit`;

CREATE ALGORITHM=UNDEFINED DEFINER=`drnineni`@`mocha6008.mochahost.com` SQL SECURITY DEFINER VIEW `product_literage_qtyunit`  AS  select 1 AS `product_id`,1 AS `litreage_unit_price`,1 AS `litreage_qty`,1 AS `qty_unit` ;

-- --------------------------------------------------------

--
-- Structure for view `product_tool_language`
--
DROP TABLE IF EXISTS `product_tool_language`;

CREATE ALGORITHM=UNDEFINED DEFINER=`drnineni`@`mocha6008.mochahost.com` SQL SECURITY DEFINER VIEW `product_tool_language`  AS  select 1 AS `product_id`,1 AS `tool_id`,1 AS `language_id`,1 AS `tool_name` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `about_product_language`
--
ALTER TABLE `about_product_language`
  ADD PRIMARY KEY (`product_id`,`language_id`),
  ADD KEY `language_id` (`language_id`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`),
  ADD KEY `admin_status_id` (`admin_status_id`);

--
-- Indexes for table `admin_status`
--
ALTER TABLE `admin_status`
  ADD PRIMARY KEY (`admin_status_id`);

--
-- Indexes for table `color`
--
ALTER TABLE `color`
  ADD PRIMARY KEY (`color_id`),
  ADD KEY `color_group_id` (`color_group_id`);

--
-- Indexes for table `color_group`
--
ALTER TABLE `color_group`
  ADD PRIMARY KEY (`color_group_id`);

--
-- Indexes for table `delivery_address`
--
ALTER TABLE `delivery_address`
  ADD PRIMARY KEY (`delivery_address_id`);

--
-- Indexes for table `delivery_type`
--
ALTER TABLE `delivery_type`
  ADD PRIMARY KEY (`delivery_type_id`);

--
-- Indexes for table `discount`
--
ALTER TABLE `discount`
  ADD PRIMARY KEY (`discount_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `feature`
--
ALTER TABLE `feature`
  ADD PRIMARY KEY (`feature_id`);

--
-- Indexes for table `feature_language`
--
ALTER TABLE `feature_language`
  ADD PRIMARY KEY (`feature_id`,`language_id`),
  ADD KEY `language_id` (`language_id`);

--
-- Indexes for table `folder`
--
ALTER TABLE `folder`
  ADD PRIMARY KEY (`folder_id`);

--
-- Indexes for table `free_tool`
--
ALTER TABLE `free_tool`
  ADD PRIMARY KEY (`tool_id`);

--
-- Indexes for table `group_language`
--
ALTER TABLE `group_language`
  ADD PRIMARY KEY (`product_group_id`,`language_id`),
  ADD KEY `language_id` (`language_id`);

--
-- Indexes for table `guide`
--
ALTER TABLE `guide`
  ADD PRIMARY KEY (`guide_id`);

--
-- Indexes for table `guide_language`
--
ALTER TABLE `guide_language`
  ADD PRIMARY KEY (`language_id`,`guide_id`),
  ADD KEY `guide_id` (`guide_id`);

--
-- Indexes for table `language`
--
ALTER TABLE `language`
  ADD PRIMARY KEY (`language_id`);

--
-- Indexes for table `litreage`
--
ALTER TABLE `litreage`
  ADD PRIMARY KEY (`litreage_id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `qty_unit_id` (`qty_unit_id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`member_id`),
  ADD KEY `member_status_id` (`member_status_id`);

--
-- Indexes for table `member_order_form`
--
ALTER TABLE `member_order_form`
  ADD PRIMARY KEY (`order_form_id`,`member_id`),
  ADD KEY `member_id` (`member_id`);

--
-- Indexes for table `member_status`
--
ALTER TABLE `member_status`
  ADD PRIMARY KEY (`member_status_id`);

--
-- Indexes for table `one_pay_payment_method`
--
ALTER TABLE `one_pay_payment_method`
  ADD PRIMARY KEY (`payment_method_id`);

--
-- Indexes for table `order_form`
--
ALTER TABLE `order_form`
  ADD PRIMARY KEY (`order_form_id`),
  ADD KEY `delivery_address_id` (`delivery_address_id`),
  ADD KEY `delivery_type_id` (`delivery_type_id`),
  ADD KEY `status_id` (`status_id`),
  ADD KEY `payment_method_id` (`payment_method_id`);

--
-- Indexes for table `order_status`
--
ALTER TABLE `order_status`
  ADD PRIMARY KEY (`status_id`);

--
-- Indexes for table `payment_method`
--
ALTER TABLE `payment_method`
  ADD PRIMARY KEY (`payment_method_id`);

--
-- Indexes for table `payment_method_owner`
--
ALTER TABLE `payment_method_owner`
  ADD PRIMARY KEY (`payment_method_id`,`member_id`),
  ADD KEY `member_id` (`member_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `admin_id` (`admin_id`),
  ADD KEY `status_id` (`status_id`),
  ADD KEY `product_type_id` (`product_type_id`),
  ADD KEY `qty_unit_id` (`qty_unit_id`);

--
-- Indexes for table `product_color_group`
--
ALTER TABLE `product_color_group`
  ADD PRIMARY KEY (`product_id`,`color_group_id`),
  ADD KEY `color_group_id` (`color_group_id`);

--
-- Indexes for table `product_feature`
--
ALTER TABLE `product_feature`
  ADD PRIMARY KEY (`product_id`,`feature_id`),
  ADD KEY `feature_id` (`feature_id`);

--
-- Indexes for table `product_free_tool`
--
ALTER TABLE `product_free_tool`
  ADD PRIMARY KEY (`product_id`,`tool_id`),
  ADD KEY `tool_id` (`tool_id`);

--
-- Indexes for table `product_group`
--
ALTER TABLE `product_group`
  ADD PRIMARY KEY (`product_group_id`);

--
-- Indexes for table `product_guide`
--
ALTER TABLE `product_guide`
  ADD PRIMARY KEY (`product_id`,`guide_id`),
  ADD KEY `guide_id` (`guide_id`);

--
-- Indexes for table `product_media`
--
ALTER TABLE `product_media`
  ADD PRIMARY KEY (`product_media_id`),
  ADD KEY `folder_id` (`folder_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `product_order`
--
ALTER TABLE `product_order`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `color_id` (`color_id`),
  ADD KEY `litreage_id` (`litreage_id`),
  ADD KEY `order_form_id` (`order_form_id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `qty_unit_id` (`qty_unit_id`);

--
-- Indexes for table `product_status`
--
ALTER TABLE `product_status`
  ADD PRIMARY KEY (`status_id`);

--
-- Indexes for table `product_title_language`
--
ALTER TABLE `product_title_language`
  ADD PRIMARY KEY (`product_id`,`language_id`),
  ADD KEY `language_id` (`language_id`);

--
-- Indexes for table `product_type`
--
ALTER TABLE `product_type`
  ADD PRIMARY KEY (`product_type_id`),
  ADD KEY `product_group_id` (`product_group_id`);

--
-- Indexes for table `qty_unit`
--
ALTER TABLE `qty_unit`
  ADD PRIMARY KEY (`qty_unit_id`);

--
-- Indexes for table `shop`
--
ALTER TABLE `shop`
  ADD PRIMARY KEY (`shop_id`),
  ADD KEY `admin_id` (`admin_id`),
  ADD KEY `status_id` (`status_id`);

--
-- Indexes for table `shop_status`
--
ALTER TABLE `shop_status`
  ADD PRIMARY KEY (`status_id`);

--
-- Indexes for table `tool_language`
--
ALTER TABLE `tool_language`
  ADD PRIMARY KEY (`language_id`,`tool_id`),
  ADD KEY `tool_id` (`tool_id`);

--
-- Indexes for table `type_language`
--
ALTER TABLE `type_language`
  ADD PRIMARY KEY (`product_type_id`,`language_id`),
  ADD KEY `language_id` (`language_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `admin_status`
--
ALTER TABLE `admin_status`
  MODIFY `admin_status_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `color`
--
ALTER TABLE `color`
  MODIFY `color_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `color_group`
--
ALTER TABLE `color_group`
  MODIFY `color_group_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `delivery_address`
--
ALTER TABLE `delivery_address`
  MODIFY `delivery_address_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `delivery_type`
--
ALTER TABLE `delivery_type`
  MODIFY `delivery_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `discount`
--
ALTER TABLE `discount`
  MODIFY `discount_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `feature`
--
ALTER TABLE `feature`
  MODIFY `feature_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `folder`
--
ALTER TABLE `folder`
  MODIFY `folder_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `free_tool`
--
ALTER TABLE `free_tool`
  MODIFY `tool_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `guide`
--
ALTER TABLE `guide`
  MODIFY `guide_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `language`
--
ALTER TABLE `language`
  MODIFY `language_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `litreage`
--
ALTER TABLE `litreage`
  MODIFY `litreage_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `member_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `member_status`
--
ALTER TABLE `member_status`
  MODIFY `member_status_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `one_pay_payment_method`
--
ALTER TABLE `one_pay_payment_method`
  MODIFY `payment_method_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;

--
-- AUTO_INCREMENT for table `order_form`
--
ALTER TABLE `order_form`
  MODIFY `order_form_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `order_status`
--
ALTER TABLE `order_status`
  MODIFY `status_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `payment_method`
--
ALTER TABLE `payment_method`
  MODIFY `payment_method_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `product_group`
--
ALTER TABLE `product_group`
  MODIFY `product_group_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `product_media`
--
ALTER TABLE `product_media`
  MODIFY `product_media_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `product_order`
--
ALTER TABLE `product_order`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `product_status`
--
ALTER TABLE `product_status`
  MODIFY `status_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `product_type`
--
ALTER TABLE `product_type`
  MODIFY `product_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `qty_unit`
--
ALTER TABLE `qty_unit`
  MODIFY `qty_unit_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `shop`
--
ALTER TABLE `shop`
  MODIFY `shop_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `shop_status`
--
ALTER TABLE `shop_status`
  MODIFY `status_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `about_product_language`
--
ALTER TABLE `about_product_language`
  ADD CONSTRAINT `about_product_language_ibfk_1` FOREIGN KEY (`language_id`) REFERENCES `language` (`language_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `about_product_language_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`admin_status_id`) REFERENCES `admin_status` (`admin_status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `color`
--
ALTER TABLE `color`
  ADD CONSTRAINT `color_ibfk_1` FOREIGN KEY (`color_group_id`) REFERENCES `color_group` (`color_group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `discount`
--
ALTER TABLE `discount`
  ADD CONSTRAINT `discount_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `feature_language`
--
ALTER TABLE `feature_language`
  ADD CONSTRAINT `feature_language_ibfk_1` FOREIGN KEY (`feature_id`) REFERENCES `feature` (`feature_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `feature_language_ibfk_2` FOREIGN KEY (`language_id`) REFERENCES `language` (`language_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `group_language`
--
ALTER TABLE `group_language`
  ADD CONSTRAINT `group_language_ibfk_1` FOREIGN KEY (`language_id`) REFERENCES `language` (`language_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `group_language_ibfk_2` FOREIGN KEY (`product_group_id`) REFERENCES `product_group` (`product_group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `guide_language`
--
ALTER TABLE `guide_language`
  ADD CONSTRAINT `guide_language_ibfk_1` FOREIGN KEY (`guide_id`) REFERENCES `guide` (`guide_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `guide_language_ibfk_2` FOREIGN KEY (`language_id`) REFERENCES `language` (`language_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `litreage`
--
ALTER TABLE `litreage`
  ADD CONSTRAINT `litreage_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `litreage_ibfk_2` FOREIGN KEY (`qty_unit_id`) REFERENCES `qty_unit` (`qty_unit_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `member_ibfk_1` FOREIGN KEY (`member_status_id`) REFERENCES `member_status` (`member_status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `member_order_form`
--
ALTER TABLE `member_order_form`
  ADD CONSTRAINT `member_order_form_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `member_order_form_ibfk_2` FOREIGN KEY (`order_form_id`) REFERENCES `order_form` (`order_form_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `order_form`
--
ALTER TABLE `order_form`
  ADD CONSTRAINT `order_form_ibfk_1` FOREIGN KEY (`delivery_address_id`) REFERENCES `delivery_address` (`delivery_address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `order_form_ibfk_2` FOREIGN KEY (`delivery_type_id`) REFERENCES `delivery_type` (`delivery_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `order_form_ibfk_3` FOREIGN KEY (`status_id`) REFERENCES `order_status` (`status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `order_form_ibfk_4` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`payment_method_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `payment_method_owner`
--
ALTER TABLE `payment_method_owner`
  ADD CONSTRAINT `payment_method_owner_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `payment_method_owner_ibfk_2` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`payment_method_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `product_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `product_status` (`status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `product_ibfk_3` FOREIGN KEY (`product_type_id`) REFERENCES `product_type` (`product_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `product_ibfk_4` FOREIGN KEY (`qty_unit_id`) REFERENCES `qty_unit` (`qty_unit_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `product_color_group`
--
ALTER TABLE `product_color_group`
  ADD CONSTRAINT `product_color_group_ibfk_1` FOREIGN KEY (`color_group_id`) REFERENCES `color_group` (`color_group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `product_color_group_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `product_feature`
--
ALTER TABLE `product_feature`
  ADD CONSTRAINT `product_feature_ibfk_1` FOREIGN KEY (`feature_id`) REFERENCES `feature` (`feature_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `product_feature_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `product_free_tool`
--
ALTER TABLE `product_free_tool`
  ADD CONSTRAINT `product_free_tool_ibfk_1` FOREIGN KEY (`tool_id`) REFERENCES `free_tool` (`tool_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `product_free_tool_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `product_guide`
--
ALTER TABLE `product_guide`
  ADD CONSTRAINT `product_guide_ibfk_1` FOREIGN KEY (`guide_id`) REFERENCES `guide` (`guide_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `product_guide_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `product_media`
--
ALTER TABLE `product_media`
  ADD CONSTRAINT `product_media_ibfk_1` FOREIGN KEY (`folder_id`) REFERENCES `folder` (`folder_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `product_media_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `product_order`
--
ALTER TABLE `product_order`
  ADD CONSTRAINT `product_order_ibfk_1` FOREIGN KEY (`color_id`) REFERENCES `color` (`color_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `product_order_ibfk_2` FOREIGN KEY (`litreage_id`) REFERENCES `litreage` (`litreage_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `product_order_ibfk_3` FOREIGN KEY (`order_form_id`) REFERENCES `order_form` (`order_form_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `product_order_ibfk_4` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `product_order_ibfk_5` FOREIGN KEY (`qty_unit_id`) REFERENCES `qty_unit` (`qty_unit_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `product_title_language`
--
ALTER TABLE `product_title_language`
  ADD CONSTRAINT `product_title_language_ibfk_1` FOREIGN KEY (`language_id`) REFERENCES `language` (`language_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `product_title_language_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `product_type`
--
ALTER TABLE `product_type`
  ADD CONSTRAINT `product_type_ibfk_1` FOREIGN KEY (`product_group_id`) REFERENCES `product_group` (`product_group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `shop`
--
ALTER TABLE `shop`
  ADD CONSTRAINT `shop_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `shop_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `shop_status` (`status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tool_language`
--
ALTER TABLE `tool_language`
  ADD CONSTRAINT `tool_language_ibfk_1` FOREIGN KEY (`tool_id`) REFERENCES `free_tool` (`tool_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tool_language_ibfk_2` FOREIGN KEY (`language_id`) REFERENCES `language` (`language_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `type_language`
--
ALTER TABLE `type_language`
  ADD CONSTRAINT `type_language_ibfk_1` FOREIGN KEY (`language_id`) REFERENCES `language` (`language_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `type_language_ibfk_2` FOREIGN KEY (`product_type_id`) REFERENCES `product_type` (`product_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
