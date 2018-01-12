/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17-log : Database - ccmmss
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ccmmss` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `ccmmss`;

/*Table structure for table `cms_article` */

DROP TABLE IF EXISTS `cms_article`;

CREATE TABLE `cms_article` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `category_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '栏目编号',
  `title` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '标题',
  `link` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '文章链接',
  `color` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '标题颜色',
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '文章图片',
  `keywords` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '关键字',
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '描述、摘要',
  `weight` int(11) DEFAULT '0' COMMENT '权重，越大越靠前',
  `weight_date` datetime DEFAULT NULL COMMENT '权重期限',
  `hits` int(11) DEFAULT '0' COMMENT '点击数',
  `posid` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '推荐位，多选',
  `custom_content_view` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '自定义内容视图',
  `view_config` text COLLATE utf8_bin COMMENT '视图配置',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `cms_article_create_by` (`create_by`),
  KEY `cms_article_title` (`title`),
  KEY `cms_article_keywords` (`keywords`),
  KEY `cms_article_del_flag` (`del_flag`),
  KEY `cms_article_weight` (`weight`),
  KEY `cms_article_update_date` (`update_date`),
  KEY `cms_article_category_id` (`category_id`),
  KEY `cms_article_id` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='文章表';

/*Data for the table `cms_article` */

insert  into `cms_article`(`id`,`category_id`,`title`,`link`,`color`,`image`,`keywords`,`description`,`weight`,`weight_date`,`hits`,`posid`,`custom_content_view`,`view_config`,`create_by`,`create_date`,`update_by`,`update_date`,`remarks`,`del_flag`) values ('1','3','文章标题标题标题标题',NULL,'green',NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('2','3','文章标题标题标题标题',NULL,'red',NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('3','3','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('4','3','文章标题标题标题标题',NULL,'green',NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('5','3','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('6','3','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('7','4','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('8','4','文章标题标题标题标题',NULL,'blue',NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('9','4','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('10','4','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('11','5','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('12','5','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('13','5','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('14','7','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('15','7','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('16','7','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('17','7','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('18','8','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('19','8','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('20','8','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('21','8','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('22','9','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('23','9','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('24','9','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('25','9','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('26','9','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('27','11','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('28','11','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('29','11','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('30','11','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('31','11','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('32','12','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('33','12','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('34','12','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('35','12','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('36','12','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('37','13','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('38','13','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('39','13','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('40','13','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('41','14','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('42','14','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('43','14','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('44','14','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('45','14','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('46','15','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('47','15','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('48','15','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('49','16','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('50','17','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('51','17','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('52','26','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('53','26','文章标题标题标题标题',NULL,NULL,NULL,'关键字1,关键字2',NULL,0,NULL,0,NULL,NULL,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0');

/*Table structure for table `cms_link` */

DROP TABLE IF EXISTS `cms_link`;

CREATE TABLE `cms_link` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `category_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '栏目编号',
  `title` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '链接名称',
  `color` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '标题颜色',
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '链接图片',
  `href` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '链接地址',
  `weight` int(11) DEFAULT '0' COMMENT '权重，越大越靠前',
  `weight_date` datetime DEFAULT NULL COMMENT '权重期限',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `cms_link_category_id` (`category_id`),
  KEY `cms_link_title` (`title`),
  KEY `cms_link_del_flag` (`del_flag`),
  KEY `cms_link_weight` (`weight`),
  KEY `cms_link_create_by` (`create_by`),
  KEY `cms_link_update_date` (`update_date`),
  KEY `cms_link_id` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='友情链接';

/*Data for the table `cms_link` */

insert  into `cms_link`(`id`,`category_id`,`title`,`color`,`image`,`href`,`weight`,`weight_date`,`create_by`,`create_date`,`update_by`,`update_date`,`remarks`,`del_flag`) values ('1','19','JeeSite',NULL,NULL,'http://thinkgem.github.com/jeesite',0,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('2','19','ThinkGem',NULL,NULL,'http://thinkgem.iteye.com/',0,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('3','19','百度一下',NULL,NULL,'http://www.baidu.com',0,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('4','19','谷歌搜索',NULL,NULL,'http://www.google.com',0,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('5','20','新浪网',NULL,NULL,'http://www.sina.com.cn',0,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('6','20','腾讯网',NULL,NULL,'http://www.qq.com/',0,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('7','21','淘宝网',NULL,NULL,'http://www.taobao.com/',0,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('8','21','新华网',NULL,NULL,'http://www.xinhuanet.com/',0,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('9','22','赶集网',NULL,NULL,'http://www.ganji.com/',0,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('10','22','58同城',NULL,NULL,'http://www.58.com/',0,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('11','23','视频大全',NULL,NULL,'http://v.360.cn/',0,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('12','23','凤凰网',NULL,NULL,'http://www.ifeng.com/',0,NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0');

/*Table structure for table `sys_dict` */

DROP TABLE IF EXISTS `sys_dict`;

CREATE TABLE `sys_dict` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `label` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '标签名',
  `value` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '数据值',
  `type` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '类型',
  `description` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '描述',
  `sort` int(11) NOT NULL COMMENT '排序（升序）',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`value`),
  KEY `sys_dict_label` (`label`),
  KEY `sys_dict_del_flag` (`del_flag`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='字典表';

/*Data for the table `sys_dict` */

insert  into `sys_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_by`,`create_date`,`update_by`,`update_date`,`remarks`,`del_flag`) values ('1','正常','0','del_flag','删除标记',10,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('2','删除','1','del_flag','删除标记',20,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('3','显示','1','show_hide','显示/隐藏',10,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('4','隐藏','0','show_hide','显示/隐藏',20,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('5','是','1','yes_no','是/否',10,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('6','否','0','yes_no','是/否',20,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('7','红色','red','color','颜色值',10,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('8','绿色','green','color','颜色值',20,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('9','蓝色','blue','color','颜色值',30,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('10','黄色','yellow','color','颜色值',40,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('11','橙色','orange','color','颜色值',50,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('12','默认主题','default','theme','主题方案',10,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('13','天蓝主题','cerulean','theme','主题方案',20,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('14','橙色主题','readable','theme','主题方案',30,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('15','红色主题','united','theme','主题方案',40,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('16','Flat主题','flat','theme','主题方案',60,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('17','国家','1','sys_area_type','区域类型',10,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('18','省份、直辖市','2','sys_area_type','区域类型',20,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('19','地市','3','sys_area_type','区域类型',30,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('20','区县','4','sys_area_type','区域类型',40,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('21','公司','1','sys_office_type','机构类型',60,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('22','部门','2','sys_office_type','机构类型',70,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('23','一级','1','sys_office_grade','机构等级',10,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('24','二级','2','sys_office_grade','机构等级',20,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('25','三级','3','sys_office_grade','机构等级',30,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('26','四级','4','sys_office_grade','机构等级',40,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('27','所有数据','1','sys_data_scope','数据范围',10,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('28','所在公司及以下数据','2','sys_data_scope','数据范围',20,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('29','所在公司数据','3','sys_data_scope','数据范围',30,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('30','所在部门及以下数据','4','sys_data_scope','数据范围',40,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('31','所在部门数据','5','sys_data_scope','数据范围',50,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('32','仅本人数据','8','sys_data_scope','数据范围',90,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('33','按明细设置','9','sys_data_scope','数据范围',100,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('34','系统管理','1','sys_user_type','用户类型',10,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('35','部门经理','2','sys_user_type','用户类型',20,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('36','普通用户','3','sys_user_type','用户类型',30,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('37','基础主题','basic','cms_theme','站点主题',10,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('38','蓝色主题','blue','cms_theme','站点主题',20,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'1'),('39','红色主题','red','cms_theme','站点主题',30,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'1'),('40','文章模型','article','cms_module','栏目模型',10,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('41','图片模型','picture','cms_module','栏目模型',20,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'1'),('42','下载模型','download','cms_module','栏目模型',30,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'1'),('43','链接模型','link','cms_module','栏目模型',40,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('44','专题模型','special','cms_module','栏目模型',50,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'1'),('45','默认展现方式','0','cms_show_modes','展现方式',10,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('46','首栏目内容列表','1','cms_show_modes','展现方式',20,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('47','栏目第一条内容','2','cms_show_modes','展现方式',30,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('48','发布','0','cms_del_flag','内容状态',10,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('49','删除','1','cms_del_flag','内容状态',20,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('50','审核','2','cms_del_flag','内容状态',15,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('51','首页焦点图','1','cms_posid','推荐位',10,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('52','栏目页文章推荐','2','cms_posid','推荐位',20,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('53','咨询','1','cms_guestbook','留言板分类',10,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('54','建议','2','cms_guestbook','留言板分类',20,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('55','投诉','3','cms_guestbook','留言板分类',30,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('56','其它','4','cms_guestbook','留言板分类',40,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('57','公休','1','oa_leave_type','请假类型',10,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('58','病假','2','oa_leave_type','请假类型',20,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('59','事假','3','oa_leave_type','请假类型',30,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('60','调休','4','oa_leave_type','请假类型',40,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('61','婚假','5','oa_leave_type','请假类型',60,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0'),('62','接入日志','1','sys_log_type','日志类型',30,'1','2013-06-03 08:00:00','1','2013-06-03 08:00:00',NULL,'0'),('63','异常日志','2','sys_log_type','日志类型',40,'1','2013-06-03 08:00:00','1','2013-06-03 08:00:00',NULL,'0'),('64','单表增删改查','single','prj_template_type','代码模板',10,'1','2013-06-03 08:00:00','1','2013-06-03 08:00:00',NULL,'0'),('65','所有entity和dao','entityAndDao','prj_template_type','代码模板',20,'1','2013-06-03 08:00:00','1','2013-06-03 08:00:00',NULL,'0');

/*Table structure for table `sys_log` */

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `type` char(1) COLLATE utf8_bin DEFAULT '1' COMMENT '日志类型',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `remote_addr` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '请求URI',
  `method` varchar(5) COLLATE utf8_bin DEFAULT NULL COMMENT '操作方式',
  `params` text COLLATE utf8_bin COMMENT '操作提交的数据',
  `exception` text COLLATE utf8_bin COMMENT '异常信息',
  PRIMARY KEY (`id`),
  KEY `sys_log_create_by` (`create_by`),
  KEY `sys_log_request_uri` (`request_uri`),
  KEY `sys_log_type` (`type`),
  KEY `sys_log_create_date` (`create_date`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='日志表';

/*Data for the table `sys_log` */

/*Table structure for table `sys_permissions` */

DROP TABLE IF EXISTS `sys_permissions`;

CREATE TABLE `sys_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(24) COLLATE utf8_bin NOT NULL COMMENT '权限名称',
  `permission_code` varchar(24) COLLATE utf8_bin DEFAULT NULL COMMENT '标识符',
  `permission_mark` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `last_user` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '修改者',
  `is_enable` varchar(1) COLLATE utf8_bin DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sys_permissions` */

insert  into `sys_permissions`(`id`,`permission_name`,`permission_code`,`permission_mark`,`create_time`,`update_time`,`last_user`,`is_enable`) values (1,'all','0x0000','所有权限',NULL,NULL,NULL,'1'),(2,'add','0x0001','增',NULL,NULL,NULL,'1'),(3,'delete','0x0002','删',NULL,NULL,NULL,'1'),(4,'update','0x0003','改',NULL,NULL,NULL,'1'),(5,'query','0x0004','查',NULL,NULL,NULL,'1'),(6,'11','1','22',NULL,NULL,NULL,'1'),(14,'9','9','9',NULL,NULL,NULL,'1'),(15,'12','12','12',NULL,NULL,NULL,'1'),(17,'1342','1234','1234',NULL,NULL,NULL,'1'),(18,'432','346','365',NULL,NULL,NULL,'1'),(19,'0','0','0',NULL,NULL,NULL,'1'),(20,'asads','asdf','afds',NULL,NULL,NULL,'1'),(21,'46','45','45',NULL,NULL,NULL,'1'),(22,'z','z','z',NULL,NULL,NULL,'1'),(23,'a','a','a',NULL,NULL,NULL,'1'),(24,'b','b','b',NULL,NULL,NULL,'1'),(25,'111','222','333','2011-11-11 00:00:00','2022-11-22 00:00:00','444','5'),(26,'119',NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(11) COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `role_mark` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `permission_id` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '权限',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `last_user` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '修改者',
  `is_enable` varchar(1) COLLATE utf8_bin DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`role_name`,`role_mark`,`permission_id`,`create_time`,`update_time`,`last_user`,`is_enable`) values (1,'user','普通用户','2,5,25',NULL,NULL,NULL,'1'),(2,'admin','管理员','2,3,4,5',NULL,NULL,NULL,'1'),(3,'supperadmin','超管理员','1,2,3,4,5',NULL,NULL,NULL,'1'),(5,'formart','SB','1,2',NULL,NULL,NULL,'1'),(6,'7','12345','4,5',NULL,NULL,NULL,'1'),(7,'1324','1324',NULL,NULL,NULL,NULL,'1'),(8,'1324','1324',NULL,NULL,NULL,NULL,'1'),(9,'1324','1234',NULL,NULL,NULL,NULL,'1'),(10,'113','1324',NULL,NULL,NULL,NULL,'1'),(13,'1234',NULL,NULL,NULL,NULL,NULL,'1'),(25,'2','1','8,10,22',NULL,NULL,NULL,'1'),(26,'6','6','1',NULL,NULL,NULL,'1'),(27,'admin1','管理员1','',NULL,NULL,NULL,'1'),(28,'12343','2134','1,2',NULL,NULL,NULL,'1'),(29,'曲儿','wretch','1',NULL,NULL,NULL,'1'),(30,'120',NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `sys_tree_menu` */

DROP TABLE IF EXISTS `sys_tree_menu`;

CREATE TABLE `sys_tree_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) DEFAULT '0' COMMENT '父级',
  `url` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '链接',
  `sort_num` int(20) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `role_id` varchar(2048) COLLATE utf8_bin DEFAULT NULL COMMENT '角色',
  `index_select` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '默认首页',
  `create_by` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '修改者',
  `is_enable` varchar(1) COLLATE utf8_bin NOT NULL DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sys_tree_menu` */

insert  into `sys_tree_menu`(`id`,`name`,`parent_id`,`url`,`sort_num`,`create_time`,`update_time`,`role_id`,`index_select`,`create_by`,`is_enable`) values (1,'统计报表',0,'',1235,NULL,NULL,'2,3,5,13,16','',NULL,'1'),(2,'店铺管理',0,'',1,NULL,NULL,'1,2,3','',NULL,'1'),(3,'商品管理',0,'',NULL,NULL,NULL,'2,3','',NULL,'1'),(4,'订单管理',0,'',1,NULL,NULL,'2,3','',NULL,'1'),(5,'用户管理',0,'',NULL,NULL,NULL,'2,3','',NULL,'1'),(6,'前端管理',0,'',NULL,NULL,NULL,'2,3','',NULL,'1'),(7,'系统管理',0,'',1200,NULL,NULL,'3','',NULL,'1'),(8,'安全管理',0,'',0,NULL,NULL,'2,3','',NULL,'1'),(9,'数据统计',0,'',1,NULL,NULL,'2,3','',NULL,'1'),(11,'商品查询',3,'',NULL,NULL,NULL,'3','',NULL,'1'),(12,'订单查询',4,'',NULL,NULL,NULL,'3','',NULL,'1'),(15,'用户列表',8,'',NULL,NULL,NULL,'3','',NULL,'1'),(16,'角色列表',8,'',NULL,NULL,NULL,'3','',NULL,'1'),(17,'权限列表',8,'',1,NULL,NULL,'3','',NULL,'1'),(18,'操作轨迹',9,'',2,NULL,NULL,'3','',NULL,'1'),(19,'用户查询',5,'/user/index',1,NULL,NULL,'3','',NULL,'1'),(20,'首页',1,'/a/testPage',1234,NULL,NULL,'1,2,3,5','1',NULL,'1'),(24,'店铺资料',2,'www/taobao/com',120,NULL,NULL,'1,3','',NULL,'1'),(47,'奇热网若群二无',10,'2134',1234,NULL,NULL,'2','',NULL,'1'),(48,'奇热网若群二无',10,'2134',1234,NULL,NULL,'2,5','',NULL,'1'),(51,'顶级菜单',0,'',0,NULL,NULL,'3','',NULL,'1'),(52,'1',51,'2',3,NULL,NULL,'3','',NULL,'1'),(53,'1',52,'2',0,NULL,NULL,'3','',NULL,'1'),(77,'管理员',7,'/user/index?user=admin',1,'2017-06-22 09:51:18',NULL,'3','select',NULL,'1'),(78,'爱的色放',52,NULL,1,NULL,NULL,'3',NULL,NULL,'1'),(79,'阿斯蒂芬',78,'sysmenu/load',22,'2017-08-17 11:48:05',NULL,'2',NULL,NULL,'1'),(80,'as多发点是',12,'https://www.taobao.com',12,NULL,NULL,'2',NULL,NULL,'1'),(81,'1324',78,'adsf',2134,NULL,NULL,'3',NULL,NULL,'1'),(82,'1234',78,'https://www.taobao.com',NULL,NULL,NULL,'3',NULL,NULL,'1'),(83,'114321234',78,'1',NULL,NULL,NULL,'3',NULL,NULL,'1'),(84,'系统管理',77,'1',1,NULL,NULL,'3',NULL,NULL,'1'),(85,'节点管理',84,'/sysmenu/grid',1,NULL,NULL,'3',NULL,NULL,'1'),(86,'权限管理',84,'/permission/grid',1,NULL,NULL,'3',NULL,NULL,'1'),(88,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) DEFAULT NULL,
  `role_id` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `nickname` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `account` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(6) COLLATE utf8_bin DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `phone` varchar(33) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(90) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `security_level` int(5) DEFAULT NULL,
  `account_level` int(5) DEFAULT NULL,
  `sort` int(10) DEFAULT NULL,
  `registration_time` datetime DEFAULT NULL,
  `mark` varchar(765) COLLATE utf8_bin DEFAULT NULL,
  `user_type` varchar(72) COLLATE utf8_bin DEFAULT NULL,
  `is_enable` varchar(3) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`role_id`,`nickname`,`name`,`account`,`password`,`sex`,`age`,`birthday`,`phone`,`email`,`address`,`security_level`,`account_level`,`sort`,`registration_time`,`mark`,`user_type`,`is_enable`) values (1,'2','小甜甜','路正宁','15209426503','02e2a70eeb03d5d5d5c8918d26771074','男',21,'1996-05-26 16:53:49','15002653994','1738515000@qq.com','甘肃省兰州市',5,5,1,'2017-05-16 16:54:36','','admin',NULL),(2,'2,3,5,7','小暴龙','马云','15002653994','b55e899b71d4bb08fa77190a11ac26b8','男',30,'2012-02-28 09:48:46','18215199576','15002653994@163qq.com','浙江杭州',6,7,1,'2017-05-19 09:50:13','1235','admin',NULL),(NULL,NULL,NULL,'adfadf','asdf',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(NULL,NULL,NULL,'adf110','adfas',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `u_permission` */

DROP TABLE IF EXISTS `u_permission`;

CREATE TABLE `u_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(256) DEFAULT NULL COMMENT 'url地址',
  `name` varchar(64) DEFAULT NULL COMMENT 'url描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `u_permission` */

insert  into `u_permission`(`id`,`url`,`name`) values (4,'/permission/index.shtml','权限列表'),(6,'/permission/addPermission.shtml','权限添加'),(7,'/permission/deletePermissionById.shtml','权限删除'),(8,'/member/list.shtml','用户列表'),(9,'/member/online.shtml','在线用户'),(10,'/member/changeSessionStatus.shtml','用户Session踢出'),(11,'/member/forbidUserById.shtml','用户激活&禁止'),(12,'/member/deleteUserById.shtml','用户删除'),(13,'/permission/addPermission2Role.shtml','权限分配'),(14,'/role/clearRoleByUserIds.shtml','用户角色分配清空'),(15,'/role/addRole2User.shtml','角色分配保存'),(16,'/role/deleteRoleById.shtml','角色列表删除'),(17,'/role/addRole.shtml','角色列表添加'),(18,'/role/index.shtml','角色列表'),(19,'/permission/allocation.shtml','权限分配'),(20,'/role/allocation.shtml','角色分配');

/*Table structure for table `u_role` */

DROP TABLE IF EXISTS `u_role`;

CREATE TABLE `u_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `type` varchar(10) DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `u_role` */

insert  into `u_role`(`id`,`name`,`type`) values (1,'系统管理员','888888'),(3,'权限角色','100003'),(4,'用户中心','100002');

/*Table structure for table `u_role_permission` */

DROP TABLE IF EXISTS `u_role_permission`;

CREATE TABLE `u_role_permission` (
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `pid` bigint(20) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `u_role_permission` */

insert  into `u_role_permission`(`rid`,`pid`) values (4,8),(4,9),(4,10),(4,11),(4,12),(3,4),(3,6),(3,7),(3,13),(3,14),(3,15),(3,16),(3,17),(3,18),(3,19),(3,20),(1,4),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20);

/*Table structure for table `u_user` */

DROP TABLE IF EXISTS `u_user`;

CREATE TABLE `u_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱|登录帐号',
  `pswd` varchar(32) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` bigint(1) DEFAULT '1' COMMENT '1:有效，0:禁止登录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `u_user` */

insert  into `u_user`(`id`,`nickname`,`email`,`pswd`,`create_time`,`last_login_time`,`status`) values (1,'管理员','admin','9c3250081c7b1f5c6cbb8096e3e1cd04','2016-06-16 11:15:33','2016-06-16 11:24:10',1),(11,'soso','8446666@qq.com','d57ffbe486910dd5b26d0167d034f9ad','2016-05-26 20:50:54','2016-06-16 11:24:35',1),(12,'8446666','8446666','4afdc875a67a55528c224ce088be2ab8','2016-05-27 22:34:19','2016-06-15 17:03:16',1);

/*Table structure for table `u_user_role` */

DROP TABLE IF EXISTS `u_user_role`;

CREATE TABLE `u_user_role` (
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `u_user_role` */

insert  into `u_user_role`(`uid`,`rid`) values (12,4),(11,3),(11,4),(1,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
