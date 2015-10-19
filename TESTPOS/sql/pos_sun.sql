/*
Navicat MySQL Data Transfer

Source Server         : daxiongit
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : pos_sun

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2015-10-13 21:25:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pos_category`
-- 商品分类表
-- ----------------------------
DROP TABLE IF EXISTS `pos_category`;
CREATE TABLE `pos_category` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `gcname` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pos_category
-- ----------------------------

-- ----------------------------
-- Table structure for `pos_client`
-- 客户表
-- ----------------------------
DROP TABLE IF EXISTS `pos_client`;
CREATE TABLE `pos_client` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `cname` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `clinkman` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `cadress` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `ctel` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `cemail` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `cremark` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pos_client
-- ----------------------------

-- ----------------------------
-- Table structure for `pos_clientgoods_detail`
-- 客户退货详情表
-- ----------------------------
DROP TABLE IF EXISTS `pos_clientgoods_detail`;
CREATE TABLE `pos_clientgoods_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `cbid` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `gid` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `cbdamount` int(10) DEFAULT NULL,
  `cbdprice` double(10,2) DEFAULT NULL,
  `cbdtotalprice` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pos_clientgoods_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `pos_clientgoods_return`
-- 客户退货表
-- ----------------------------
DROP TABLE IF EXISTS `pos_clientgoods_return`;
CREATE TABLE `pos_clientgoods_return` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `cid` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `eid` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `cbdate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pos_clientgoods_return
-- ----------------------------

-- ----------------------------
-- Table structure for `pos_goods`
-- 商品表
-- ----------------------------
DROP TABLE IF EXISTS `pos_goods`;
CREATE TABLE `pos_goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `gname` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `gcid` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `gunit` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `gpin` double(10,2) DEFAULT NULL,
  `gpout` double(10,2) DEFAULT NULL,
  `gamount` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pos_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `pos_provider`
-- 供应商表
-- ----------------------------
DROP TABLE IF EXISTS `pos_provider`;
CREATE TABLE `pos_provider` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) DEFAULT NULL,
  `plinkman` varchar(50) DEFAULT NULL,
  `paddress` varchar(50) DEFAULT NULL,
  `ptel` varchar(20) DEFAULT NULL,
  `pemail` varchar(50) DEFAULT NULL,
  `premark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pos_provider
-- ----------------------------

-- ----------------------------
-- Table structure for `pos_purchasing`
-- 采购表
-- ----------------------------
DROP TABLE IF EXISTS `pos_purchasing`;
CREATE TABLE `pos_purchasing` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pid` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `sdate` date DEFAULT NULL,
  `stotalprice` double(10,2) DEFAULT NULL,
  `sbuyer` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pos_purchasing
-- ----------------------------

-- ----------------------------
-- Table structure for `pos_purchasing_detail`
-- 采购退货表
-- ----------------------------
DROP TABLE IF EXISTS `pos_purchasing_detail`;
CREATE TABLE `pos_purchasing_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pbid` varchar(50) DEFAULT NULL,
  `gid` varchar(50) DEFAULT NULL,
  `pbdamount` int(10) DEFAULT NULL,
  `pbdprice` double(10,2) DEFAULT NULL,
  `pbdtotalprice` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pos_purchasing_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `pos_purchasing_return`
-- ----------------------------
DROP TABLE IF EXISTS `pos_purchasing_return`;
CREATE TABLE `pos_purchasing_return` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pid` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `sid` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `pbdate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pos_purchasing_return
-- ----------------------------

-- ----------------------------
-- Table structure for `pos_sale`
-- 销售表
-- ----------------------------
DROP TABLE IF EXISTS `pos_sale`;
CREATE TABLE `pos_sale` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `cid` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `edate` date DEFAULT NULL,
  `etotalprice` double(10,2) DEFAULT NULL,
  `ebuyer` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pos_sale
-- ----------------------------

-- ----------------------------
-- Table structure for `pos_sale_detail`
-- 销售详情表
-- ----------------------------
DROP TABLE IF EXISTS `pos_sale_detail`;
CREATE TABLE `pos_sale_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `eid` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `gid` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `edamount` int(10) DEFAULT NULL,
  `edprice` double(10,2) DEFAULT NULL,
  `edtotalprice` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pos_sale_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `pos_users`
-- 管理员表
-- ----------------------------
DROP TABLE IF EXISTS `pos_users`;
CREATE TABLE `pos_users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `aname` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `apwd` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `alevel` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of pos_users
-- ----------------------------
