-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.9.1-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table zeninventory.customer: 3 rows
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT IGNORE INTO `customer` (`customer_id`, `customer_address`, `customer_name`, `customer_phone_no`) VALUES
	(13, '123Hope', 'leon zheng', '1111112'),
	(69, '123rd st', 'Tom', '123456'),
	(76, '123rd st', 'Ms Lewis', '123456');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping data for table zeninventory.customer_order: 26 rows
/*!40000 ALTER TABLE `customer_order` DISABLE KEYS */;
INSERT IGNORE INTO `customer_order` (`order_id`, `order_date`, `status`, `purchase_price`, `purchase_quantity`, `customer_id`, `product_id`) VALUES
	(1, '2022-10-16 20:00:00', 'Pending', 1199.89, 1, 13, 22),
	(29, '2022-10-11 20:00:00', 'Pending', 99, 1, 13, 1),
	(32, '2022-10-19 20:00:00', 'Pending', 0.01, 3, 14, 24),
	(39, '2022-10-19 20:00:00', 'Pending', 299, 1, 13, 5),
	(40, '2022-10-19 20:00:00', 'Pending', 12, 1, 13, 22),
	(45, '2022-10-04 20:00:00', 'Pending', 0, 0, NULL, NULL),
	(46, '2022-10-11 20:00:00', 'Pending', 0, 0, NULL, NULL),
	(49, '2022-10-02 20:00:00', 'Pending', 0, 0, 13, 5),
	(51, '2022-10-11 20:00:00', 'Pending', 111, 11, 13, 5),
	(52, '2022-10-11 20:00:00', 'Pending', 111, 11, 13, 5),
	(53, '2022-10-11 20:00:00', 'Pending', 111, 11, 13, 5),
	(55, '2022-09-26 20:00:00', 'Pending', 0, 0, NULL, NULL),
	(57, '2022-10-16 20:00:00', 'Pending', 1199.89, 3, 13, 1),
	(58, '2022-10-11 20:00:00', 'Shipped', 119, 1, 13, 1),
	(59, '2022-10-11 20:00:00', 'Shipped', 119, 1, 13, 1),
	(60, '2022-10-11 20:00:00', 'Pending', 119, 2, 13, 1),
	(61, '2022-10-11 20:00:00', 'Pending', 119, 2, 13, 1),
	(62, '2022-10-11 20:00:00', 'Pending', 119, 2, 13, 1),
	(63, '2022-10-16 20:00:00', 'Pending', 1199.89, 3, 13, 1),
	(64, '2022-10-16 20:00:00', 'Pending', 1199.89, 3, 13, 1),
	(66, '2022-10-18 20:00:00', 'Pending', 499, 1, 13, 1),
	(67, '2022-10-18 20:00:00', 'Pending', 799, 2, 13, 1),
	(68, '2022-10-03 20:00:00', 'Pending', 1, 2, 13, 1),
	(70, '2022-10-12 20:00:00', 'Pending', 111, 1, 69, 5),
	(71, '2022-10-19 20:00:00', 'Pending', 778, 4, 69, 1),
	(78, '2022-10-10 20:00:00', 'Pending', 199, 1, 69, 23);
/*!40000 ALTER TABLE `customer_order` ENABLE KEYS */;

-- Dumping data for table zeninventory.hibernate_sequence: 1 rows
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT IGNORE INTO `hibernate_sequence` (`next_val`) VALUES
	(79);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping data for table zeninventory.product: 7 rows
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT IGNORE INTO `product` (`product_id`, `minimum_stock`, `product_desc`, `product_name`, `product_quantity`) VALUES
	(1, 11, 'none', 'pc', 21),
	(5, 4, 'a console', 'switch', 2),
	(22, 10, 'a smart phone ', 'iphone 14', 29),
	(23, 5, 'a smart printer', 'printer XL5000', 4),
	(77, 20, 'imac', 'iMac', 30),
	(28, 0, '404 ', 'laptop404', 22),
	(74, 15, 'a watch', 'apple watch', 20);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Dumping data for table zeninventory.supplier: 8 rows
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT IGNORE INTO `supplier` (`supplier_id`, `supplier_address`, `supplier_name`, `supplier_phone_no`) VALUES
	(16, 'ree', 'Apple', '123'),
	(17, 'yessss', 'testgood', '1234444'),
	(27, '22', 'test2', '123456'),
	(33, '123Hope', 'newSupplier', '123456'),
	(36, 'hope123', 'supplier101', '123456'),
	(37, 'asd', 'asd', 'asdasd'),
	(43, 'qwe', 'qwe', 'qwe'),
	(73, 'Dummy123', 'Dummy', '123456');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;

-- Dumping data for table zeninventory.supplier_product: 17 rows
/*!40000 ALTER TABLE `supplier_product` DISABLE KEYS */;
INSERT IGNORE INTO `supplier_product` (`supplier_id`, `product_id`) VALUES
	(16, 28),
	(17, 5),
	(17, 1),
	(16, 77),
	(16, 1),
	(17, 26),
	(27, 23),
	(33, 1),
	(33, 5),
	(33, 22),
	(33, 23),
	(37, 23),
	(37, 22),
	(37, 5),
	(37, 1),
	(43, 22),
	(16, 74);
/*!40000 ALTER TABLE `supplier_product` ENABLE KEYS */;

-- Dumping data for table zeninventory.users: 12 rows
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT IGNORE INTO `users` (`id`, `email`, `name`, `password`) VALUES
	(1, 'test123@321.com', 'test', '$2a$10$nFl2bPKuycorxA.8g5TS4uf46JUvSf8171RrPhdmKw/neLLeg6H2y'),
	(3, 'admin@zeninventory.com', 'admin', '$2a$10$WmcvHzDHw9/md6ksfi1ZcOU237M4MHWUT1wpVpFfE8H7oFgfQpiMy'),
	(4, 'qweqwe@dsa', '123', '$2a$10$0cyAdD03BeCUEgkNrQxUUezGDRq9Xbst4/MrHGo81cswkDFF0oiSO'),
	(5, 'admin2@zeninventory.com', 'admin2', '$2a$10$OMurdcAWxmObIybPd4ENyuEMyQeHzk4KRS/w/yz29D2MpfKJm5fIO'),
	(6, 'test@123123.com', 'test', '$2a$10$K7LS1Qs6DuwYs8QsCYIrAuaXeNOcSk2Z3fDDF/HnflTkNYK4OViQm'),
	(7, 'test22@gmail.com', 'test22', '$2a$10$L9R8MSR8SWTokiOn5DQ7i.LuIzRq5r.K5QGWA/ktmU62F0qdSIBUO'),
	(8, 'test33@gmail.com', 'test33', '$2a$10$RtAzigdSL8YQRg/boDz5wOu9FtxqvlFYxRCAgNukugfYDTdoIwNhO'),
	(9, 'user@123.com', 'newUser', '$2a$10$jpoFXpfasQK/AGxg1zTFfujazAV8kvsghlEFNAnql5vQ5zhv1n8M2'),
	(10, 'test@123.com', 'testtest', '$2a$10$s2jylsfjdhpWdOLbpjqeiOE.VL3pAikfWx0Cd0C.Flnwt4CAy1la.'),
	(11, '', '', '$2a$10$JLLRw2Ma7phVuHKfokG3EuSkoFL55KdsUqckOjZLT6EEEER401COS'),
	(12, 'tom@123.com', 'Tom', '$2a$10$DV6p9QUrDmxKLik1.Xwx4.U7u5kP6bON76k7c5Qr2gHbGpL0t8rvu'),
	(13, 'test@test.com', 'test', '$2a$10$.NLTVN1INUXmEcWYnybJIeFaxZryjDM.y4YmEqQ.6lhPTGv4AMN7S');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping data for table zeninventory.vendor_order: 0 rows
/*!40000 ALTER TABLE `vendor_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor_order` ENABLE KEYS */;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
