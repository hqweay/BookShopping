-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: db_bookshopping
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `new_table`
--

DROP TABLE IF EXISTS `new_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `new_table` (
  `idnew_table` int(11) NOT NULL,
  PRIMARY KEY (`idnew_table`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `new_table`
--

LOCK TABLES `new_table` WRITE;
/*!40000 ALTER TABLE `new_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `new_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_book`
--

DROP TABLE IF EXISTS `tb_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_book` (
  `Book_id` int(11) NOT NULL AUTO_INCREMENT,
  `Book_name` varchar(45) NOT NULL,
  `Book_price` float NOT NULL,
  `Book_discount` float DEFAULT '1',
  `Book_typeid` int(11) DEFAULT '1',
  `Book_describe` varchar(100) DEFAULT NULL,
  `Book_quantity` int(11) NOT NULL,
  `Book_url` varchar(100) NOT NULL,
  `Book_author` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_book`
--

LOCK TABLES `tb_book` WRITE;
/*!40000 ALTER TABLE `tb_book` DISABLE KEYS */;
INSERT INTO `tb_book` VALUES (1,'自在独行',39,0.9,1,'陈坤开心推荐，贾平凹的独行世界，研磨孤独，收获自在，致每个孤独的行路人。你独自行走，不顾一切，哭着，笑着，留恋人间，只为不虚此行。独行是一场心灵的隐居，即便你认为自己是孤独的，也是可以自在的。',100,'image/wenxue_01.jpg','贾平凹'),(2,'皮囊',21.8,9,1,'（白岩松、刘同、蒋方舟、阿来、阎连科、张晓龙倾情推荐，献给内心漂泊无依的你，关于亲人、关于故乡，真挚暖心——请勿在公众场合阅读，比如地铁，以免流泪遭围观） ',200,'image/wenxue_02.jpg','蔡崇达'),(3,'孤独六讲',38,0.9,1,'靳东推荐阅读，蒋勋经典代表作，全新精装版，亲作长序，全书修订，初版十周年重磅回归！以一颗柔软心，书写我们内心安定的力量。黑白灰极简装帧，清雅质感。龙应台、席慕蓉、林青霞鼎力推荐，三毛特别推崇的美学大师',100,'image/wenxue_03.jpg','蒋勋'),(4,'行走的人生',49.8,0.9,1,'（三联出品，新东方创始人俞敏洪走心之作，亲笔书写55年的沉淀人生，商界领袖、梦想导师、励志传奇背后的真实生活，发现俞敏洪之所以成为俞敏洪的真正原因。）',100,'image/wenxue_04.jpg','俞敏洪'),(5,'醒来觉得甚是爱你',45,0.9,1,'董卿《朗读者》推荐阅读，鲜花谷夫妇倾情朗诵，四色精美手绘插图典藏版。译莎巨匠朱生豪写给爱人宋清如的经典情话。',100,'image/wenxue_05.jpg','朱生豪'),(6,'巨流河',25,0.9,2,'暂无描述',100,'image/xiaoshuo_01.jpg','齐邦媛'),(7,'平民之宴',33.8,1,2,'与渡边淳一齐名的女作家，直木奖评委、直木奖获得者林真理子代表作，作品在日本狂销3000万册。 看懂这本书，就看懂了中国中产阶级的焦虑。 ',100,'image/xiaoshuo_02.jpg','林真理子'),(8,'大秦帝国',498.3,1,2,'附赠进阶手册。具有广泛影响力的历史小说，南怀瑾、二月河等推荐。典藏礼盒装，社会精英启示录。',100,'image/xiaoshuo_03.jpg','孙皓晖'),(9,'地下铁道',97.3,1,2,'（2017年普利策奖得主！《追风筝的人》之后，再燃无数中国人的阅读热情！奥巴马、奥普拉齐声赞叹，新晋奥斯卡奖得主导演巴里·詹金斯新片改编！人生终需一次妄想，带领我们去那从未到过的地方。）',100,'image/xiaoshuo_04.jpg','[美]科尔森·怀特黑'),(10,'围城',23.3,1,2,'《围城》是钱钟书的长篇小说，于1946年完成，《围城》是中国现代文学史上一部风格独特的讽刺小说，语言犀利，讽刺尖露，诙谐幽默，妙语连篇，被誉为“新儒林外史” ',100,'image/xiaoshuo_05.jpg','钱钟书');
/*!40000 ALTER TABLE `tb_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_booktype`
--

DROP TABLE IF EXISTS `tb_booktype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_booktype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  `param` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type_UNIQUE` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_booktype`
--

LOCK TABLES `tb_booktype` WRITE;
/*!40000 ALTER TABLE `tb_booktype` DISABLE KEYS */;
INSERT INTO `tb_booktype` VALUES (1,'青春文学','wenxue'),(2,'热门小说','xiaoshuo'),(3,'幼儿启蒙','youer'),(4,'小学一年级','xiaoxue'),(5,'高中英语','gaozhong'),(6,'大学英语','daxue');
/*!40000 ALTER TABLE `tb_booktype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cart`
--

DROP TABLE IF EXISTS `tb_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_cart` (
  `Cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `Cart_book_id` int(11) NOT NULL,
  `Cart_quantity` int(11) NOT NULL,
  `Cart_customer_id` int(11) NOT NULL,
  PRIMARY KEY (`Cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cart`
--

LOCK TABLES `tb_cart` WRITE;
/*!40000 ALTER TABLE `tb_cart` DISABLE KEYS */;
INSERT INTO `tb_cart` VALUES (1,1,1,1002),(2,2,1,1002);
/*!40000 ALTER TABLE `tb_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_customer`
--

DROP TABLE IF EXISTS `tb_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_customer` (
  `Customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `Customer_name` varchar(15) NOT NULL,
  `Customer_password` varchar(15) NOT NULL,
  `Customer_phone` int(11) NOT NULL,
  `Customer_order_id` int(11) DEFAULT NULL,
  `Customer_address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Customer_id`),
  UNIQUE KEY `Customer_name_UNIQUE` (`Customer_name`),
  KEY `idx_tb_customer_Customer_Password` (`Customer_password`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_customer`
--

LOCK TABLES `tb_customer` WRITE;
/*!40000 ALTER TABLE `tb_customer` DISABLE KEYS */;
INSERT INTO `tb_customer` VALUES (1000,'hqweay','123456',10086,NULL,NULL),(1001,'965','65',65,NULL,NULL),(1002,'zb','1234',10086,NULL,NULL);
/*!40000 ALTER TABLE `tb_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_manager`
--

DROP TABLE IF EXISTS `tb_manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_manager` (
  `Manager_name` varchar(40) NOT NULL,
  `Manager_pass` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Manager_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_manager`
--

LOCK TABLES `tb_manager` WRITE;
/*!40000 ALTER TABLE `tb_manager` DISABLE KEYS */;
INSERT INTO `tb_manager` VALUES ('zb','1234');
/*!40000 ALTER TABLE `tb_manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_order`
--

DROP TABLE IF EXISTS `tb_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_order` (
  `Order_id` int(11) NOT NULL,
  `Order_data` varchar(45) NOT NULL,
  `Order_price` int(11) NOT NULL,
  `Order_customer_id` int(11) NOT NULL,
  PRIMARY KEY (`Order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_order`
--

LOCK TABLES `tb_order` WRITE;
/*!40000 ALTER TABLE `tb_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-09 13:33:08
