/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : ways

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-11-08 10:37:03
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `dept_id` varchar(32) NOT NULL DEFAULT '',
  `dept_name` varchar(50) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('dept1', '开发部', '2018-10-16');

-- ----------------------------
-- Table structure for `login_user`
-- ----------------------------
DROP TABLE IF EXISTS `login_user`;
CREATE TABLE `login_user` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `user_id` varchar(32) DEFAULT NULL,
  `login_name` varchar(20) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login_user
-- ----------------------------
INSERT INTO `login_user` VALUES ('login1', 'user1', 'admin', 'c4ca4238a0b923820dcc509a6f75849b');
INSERT INTO `login_user` VALUES ('login2', 'user1', 'admin1', 'c4ca4238a0b923820dcc509a6f75849b');

-- ----------------------------
-- Table structure for `memosort`
-- ----------------------------
DROP TABLE IF EXISTS `memosort`;
CREATE TABLE `memosort` (
  `id` int(6) NOT NULL DEFAULT '0',
  `name` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of memosort
-- ----------------------------
INSERT INTO `memosort` VALUES ('1', 'ZY哈尔滨泰林投资有限公司');
INSERT INTO `memosort` VALUES ('2', 'ZY哈尔滨徐虎上海物业经营有限责任公司');
INSERT INTO `memosort` VALUES ('3', 'ZY哈尔滨展通市政工程有限公司');
INSERT INTO `memosort` VALUES ('4', 'ZY哈尔滨菱建物业管理有限公司');
INSERT INTO `memosort` VALUES ('5', 'ZY哈尔滨市城市内河建设发展有限公司');
INSERT INTO `memosort` VALUES ('6', 'ZY哈尔滨宜家家居');
INSERT INTO `memosort` VALUES ('7', 'ZY哈尔滨排水集团');
INSERT INTO `memosort` VALUES ('8', 'ZY黑龙江广顺房地产开放有限公司');
INSERT INTO `memosort` VALUES ('9', 'ZY江畔路停车场');
INSERT INTO `memosort` VALUES ('10', 'ZY哈尔滨安泊阳光停车场管理有限公司');
INSERT INTO `memosort` VALUES ('11', 'ZY哈尔滨记忆餐饮管理有限公司');
INSERT INTO `memosort` VALUES ('12', 'ZY哈尔滨金冠建筑装饰工程有限公司');
INSERT INTO `memosort` VALUES ('13', 'ZY哈尔滨丰园物业管理有限公司');
INSERT INTO `memosort` VALUES ('14', 'ZY省电力医院');
INSERT INTO `memosort` VALUES ('15', 'ZY哈尔滨云鹏物业管理有限公司');
INSERT INTO `memosort` VALUES ('16', 'ZY哈尔滨少年宫');
INSERT INTO `memosort` VALUES ('17', 'ZY哈尔滨市道外区东方停车场服务中心');
INSERT INTO `memosort` VALUES ('18', 'ZY哈尔滨德润物业管理有限公司');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` varchar(32) NOT NULL DEFAULT '',
  `menu_name` varchar(50) DEFAULT NULL,
  `level` int(2) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  `style` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('menu1', '首页', '1', 'home', 'menu0', null);
INSERT INTO `menu` VALUES ('menu2', '项目', '1', 'project', 'menu0', null);
INSERT INTO `menu` VALUES ('menu21', '项目清单', '2', 'project/list', 'menu2', null);
INSERT INTO `menu` VALUES ('menu211', '项目详细信息', '3', 'project/list/detail', 'menu21', null);
INSERT INTO `menu` VALUES ('menu212', '项目组成员', '3', 'project/list/projectMember', 'menu21', null);
INSERT INTO `menu` VALUES ('menu22', '项目知识库', '2', 'project/knowledge', 'menu2', null);
INSERT INTO `menu` VALUES ('menu23', '项目节点', '2', 'project/milepost', 'menu2', null);
INSERT INTO `menu` VALUES ('menu3', '组织架构', '1', 'organization', 'menu0', null);
INSERT INTO `menu` VALUES ('menu31', '人员管理', '2', 'organization/person', 'menu3', null);
INSERT INTO `menu` VALUES ('menu32', '角色管理', '2', 'organization/person', 'menu3', null);
INSERT INTO `menu` VALUES ('menu33', '部门管理', '2', 'organization/dept', 'menu3', null);
INSERT INTO `menu` VALUES ('menu4', '系统管理', '1', 'system', 'menu0', null);
INSERT INTO `menu` VALUES ('menu41', '权限设置', '2', 'system/authority', 'menu4', null);
INSERT INTO `menu` VALUES ('menu42', '后台专用', '2', 'system/coder', 'menu4', null);

-- ----------------------------
-- Table structure for `menutemp`
-- ----------------------------
DROP TABLE IF EXISTS `menutemp`;
CREATE TABLE `menutemp` (
  `menu_id` varchar(32) NOT NULL DEFAULT '',
  `module` varchar(200) DEFAULT NULL,
  `premissionId` varchar(200) DEFAULT NULL,
  `label` varchar(200) DEFAULT NULL,
  `params` varchar(2048) DEFAULT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  `sort_id` int(3) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menutemp
-- ----------------------------
INSERT INTO `menutemp` VALUES ('001', null, null, '黑龙江省', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163ae9427950000', null, null, '共享', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163ae94a3d50001', null, null, '城投集团', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163ae94fb470002', null, null, 'GX成高子镇卫生服务中心', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163af91f5d40006', null, null, 'GX哈尔滨市城市管理局', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163af99caa8000a', null, null, 'GX哈尔滨市道里区教育局', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163afc06e03000e', null, null, 'GX哈尔滨南岗区先锋路街道办事处', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163afc0fd5a0012', null, null, 'GX哈尔滨市南岗区保健路街道办事处', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163afc3998e0016', null, null, '城市普查', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163afc4350d0017', null, null, '中央大街区域', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163afc4e63e0018', null, null, 'JY哈尔滨优先科技股份有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163afca4612001d', null, null, 'GX新春办事处', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163affb18f40029', null, null, 'GX哈尔滨市城市建设投资集团有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163affe873c002e', null, null, '第三方资源企业', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163afff05a5002f', null, null, 'ZY凯利集团', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b002db8e0033', null, null, 'GX哈尔滨市道里区文化体育局', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b006486b0038', null, null, 'GX中共哈尔滨市委员会', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b008c614003d', null, null, 'ZY哈尔滨市中医医院', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b0094d090042', null, null, 'GX哈尔滨市林业局', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b0094dec1155', null, null, 'ZY哈尔滨市林业局', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b0187e31004b', null, null, 'GX香坊区城市管理行政执法局', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b01938d3004f', null, null, 'GX哈尔滨市规划展览馆', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b02b42170054', null, null, 'GX哈尔滨市平房区国家税务局', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b02cb0580059', null, null, 'GX哈尔滨市平房区人民政府', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b02dcd7f005e', null, null, 'GX哈尔滨市城乡路街道办事处', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b07c6b410064', null, null, 'GX哈尔滨市香坊区人民政府', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b07e008b0068', null, null, 'GX中国云谷', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b07fb5b5006e', null, null, 'GX哈尔滨市呼兰区市场监督管理局', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b08171360073', null, null, 'GX哈尔滨市道里区太平镇政府', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b08448a10078', null, null, 'GX哈尔滨经济技术开发区管委会', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b08611d0007c', null, null, 'ZY哈尔滨好民居资产运营管理有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b08b93c20082', null, null, 'GX哈尔滨城投资产经营管理有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b08cc1550086', null, null, 'GX哈尔滨市人力资源和社会保障局', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b08df50d008c', null, null, '城安停车场经营管理有限公司1', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b08e18f00091', null, null, '城安停车场经营管理有限公司2', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b08e70240095', null, null, '城投资产经营管理有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b0b9750300b9', null, null, 'ZY省电力医院', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b0bf5a3800be', null, null, 'ZY哈尔滨少年宫', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b0c2bb1000c3', null, null, 'GX哈尔滨市科学技术局', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b0c6b2ef00c9', null, null, 'GX哈尔滨市道里区城市管理行政执法局', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b0c732a300cd', null, null, 'GX哈尔滨市财政局', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b0c8c60400d2', null, null, 'GX哈尔滨市民大厦', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b0ca336600d7', null, null, 'GX哈尔滨市香坊振兴投资有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b0cc458400dc', null, null, 'ZY哈尔滨排水集团', null, null, null);
INSERT INTO `menutemp` VALUES ('40283a4763ab022a0163b0ccca0000e0', null, null, 'ZY哈尔滨德润物业管理有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e316489788201649254d7dc0386', null, null, 'ZY黑龙江省宇翔装饰材料经销有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3165147030016569adeff03a34', null, null, 'ZY黑龙江省昆仑都荟商业管理有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3165147030016569af51223a3c', null, null, 'ZY哈尔滨顺城机动车停车管理有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3165147030016569afd6cd3a44', null, null, 'ZY哈尔滨中信物流管理有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3165ccf7830165ea22858717a7', null, null, 'ZY哈尔滨市儿童公园', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e31660168b301665122410f2412', null, null, 'ZY哈尔滨第一专科医院', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e31660168b301665123acc6241c', null, null, 'ZY哈尔滨迈奇威科技开发有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e35642e762901643f47185f27d5', null, null, 'ZY哈尔滨金冠建筑装饰工程有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e356472e92c01647e48f16b08ea', null, null, 'GX哈尔滨综合保税区', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e356472e92c016487605ed80ea0', null, null, 'ZY哈尔滨洲际地下智能停车场有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e356489745a01649254a2fc0464', null, null, 'ZY哈尔滨徐虎上海物业经营有限责任公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e36642e762301643f45d8e52d1b', null, null, 'ZY哈尔滨广兴汽车租赁服务有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e36642e762301643f46ab7e2d23', null, null, 'ZY哈尔滨市南岗区信恒停车场', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e36642e762301643fb7730a2d7c', null, null, 'ZY江畔路停车场', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e366472e90301647e49580d08cf', null, null, 'GX哈尔滨市松花江街道办事处', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e36648974200164927408200480', null, null, 'ZY哈尔滨记忆餐饮管理有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3664a323460164a68cb7e2011e', null, null, 'ZY哈尔滨丰园物业管理有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3664b72f0f0164d5b2977e0c40', null, null, 'ZY哈尔滨菱建物业管理有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3d648973d50164925605a0050a', null, null, 'ZY哈尔滨红旗家俱城有限责任公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3d648973d50164927871ac0513', null, null, 'ZY哈尔滨云鹏物业管理有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3d64b72aee0164cb9bd18d0822', null, null, 'ZY哈尔滨安泊阳光停车场管理有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3d65146f980165459a5f4b15cf', null, null, 'ZY哈尔滨恒资科技开发有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3d65146f9801655ae9e99d27fc', null, null, 'GX哈投集团公房管理中心', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3d65146f9801655aea589a2804', null, null, 'ZY哈尔滨泰林投资有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3d65146f9801656584da84319a', null, null, 'ZY哈尔滨科华装饰有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3d65c619780165ef7e36942128', null, null, 'ZY哈尔滨人和国际健身俱乐部有限公司盛和店', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f63b4ecc10163b524bcd2001b', null, null, '测试', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f63b4ecc10163b529a33f001c', null, null, '测试企业', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f63f796a70164021645301701', null, null, 'ZY哈尔滨展通市政工程有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f63f796a7016402175a0b1707', null, null, 'ZY哈尔滨嘉捷投资客理有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f64216b9601642bcd91bd0469', null, null, 'ZY金源花园', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f64216b9601642bd39f58046d', null, null, 'ZY哈尔滨市城市内河建设发展有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f64216b9601642c7de39904a0', null, null, 'ZY市民大厦', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f642e761d01643f2d9bef32f6', null, null, 'GX哈尔滨市南岗区教育局', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f642e761d01643f2de41e32fe', null, null, 'GX哈尔滨市地铁集团', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f6472e8e501647e491d9108bd', null, null, 'GX哈尔滨市国土局', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f6472e8e501647e4984fd08c5', null, null, 'GX哈尔滨市芦家街道办事处', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f6472e8e501647e49d30a08cd', null, null, 'GX哈尔滨市教育局装备处', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f6472e8e501648761d6b81081', null, null, 'ZY哈尔滨瀚源花园大酒店有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f6472e8e501648766f8441089', null, null, 'ZY哈尔滨市道外区东方停车场服务中心', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f64896d61016492552a080515', null, null, 'ZY哈尔滨南郡停车场管理有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f64896d610164926a4cc60520', null, null, 'ZY哈尔滨市光祖体育发展有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f64a323010164b03bacd90773', null, null, 'ZY黑龙江广顺房地产开放有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f64b71fe80164d40fd3530a47', null, null, 'ZY哈尔滨佰运停车场经营管理有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f651c7ec701655f52cdc52f8f', null, null, 'ZY哈尔滨市道里区拿督斯停车场', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f651c7ec701658d8aaae55817', null, null, 'ZY哈尔滨蓝贝壳汽车服务有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f651c7ec701659d29d6a266c6', null, null, 'ZY哈尔滨铁路局物资中心', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e3f65c615020165feb0db2f2b92', null, null, 'ZY哈尔滨新千年实业有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e4064216bd401642bcf5f6b03f9', null, null, 'ZY哈尔滨宜家家居', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e4064216bd401642bd1713103fe', null, null, 'ZY哈尔滨市海宁皮革城', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e40642e761701643f1c60e423ba', null, null, 'GX哈尔滨市委党校', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e406472e9a301647e48ca030ba9', null, null, 'GX哈尔滨市第四医院', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e406472e9a3016487623c56136b', null, null, 'ZY哈尔滨中顺二手车交易市场有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e406489739e0164925500b70444', null, null, 'ZY哈尔滨正偲商贸有限公司', null, null, null);
INSERT INTO `menutemp` VALUES ('40288e4065c610b10165f98a034926c4', null, null, 'ZY哈尔滨市天昊房地产开发建设有限公司', null, null, null);

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` varchar(32) NOT NULL DEFAULT '',
  `role_name` varchar(50) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('role1', 'A角', '2018-10-16');

-- ----------------------------
-- Table structure for `role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `role_id` varchar(32) DEFAULT NULL,
  `menu_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('b4e5dedcd2a211e8a87100e04c68532f', 'role1', 'menu1');
INSERT INTO `role_menu` VALUES ('b4e5e0fcd2a211e8a87100e04c68532f', 'role1', 'menu2');
INSERT INTO `role_menu` VALUES ('b4e5e80dd2a211e8a87100e04c68532f', 'role1', 'menu21');
INSERT INTO `role_menu` VALUES ('b4e5e938d2a211e8a87100e04c68532f', 'role1', 'menu23');
INSERT INTO `role_menu` VALUES ('b4e5e985d2a211e8a87100e04c68532f', 'role1', 'menu3');
INSERT INTO `role_menu` VALUES ('b4e5e9c5d2a211e8a87100e04c68532f', 'role1', 'menu31');
INSERT INTO `role_menu` VALUES ('b4e5ea9bd2a211e8a87100e04c68532f', 'role1', 'menu4');
INSERT INTO `role_menu` VALUES ('b4e5ead7d2a211e8a87100e04c68532f', 'role1', 'menu41');
INSERT INTO `role_menu` VALUES ('b4e5eb1bd2a211e8a87100e04c68532f', 'role1', 'menu42');

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `name` varchar(100) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('asdfasdf12312sedfas', 'aaa', '12');
INSERT INTO `test` VALUES ('asdfdsdfhgfdghfgjhgfh', 'bbb', '14');
INSERT INTO `test` VALUES ('asdfhgjgigkj', 'ccc', '17');
INSERT INTO `test` VALUES ('sdfghjhljklfsd', 'ddd', '16');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(32) NOT NULL COMMENT '主键，用户id',
  `user_code` varchar(50) DEFAULT NULL,
  `user_type` varchar(5) DEFAULT NULL COMMENT '用户类型',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别',
  `dept_name` varchar(32) DEFAULT NULL COMMENT '部门名称',
  `dept_id` varchar(32) DEFAULT NULL COMMENT '部门id',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色id',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `user_status` varchar(1) DEFAULT NULL COMMENT '1:在职，2:离职，3:停职，4：其他',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建人id',
  `create_name` varchar(50) DEFAULT NULL COMMENT '创建人姓名',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新人id',
  `update_name` varchar(32) DEFAULT NULL COMMENT '更新人姓名',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` varchar(5) DEFAULT NULL,
  `udf_1` varchar(100) DEFAULT NULL,
  `udf_2` varchar(100) DEFAULT NULL,
  `udf_3` varchar(100) DEFAULT NULL,
  `udf_4` varchar(100) DEFAULT NULL,
  `udf_5` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1111', '234', null, '12322222', '2018-07-23 11:08:24', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('40289bff63b3b0f40163b3c2d9020000', null, null, 'admin', null, null, null, null, '1', null, null, null, null, null, '2018-05-31 09:14:41', '0', 'admin', null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('40289bff63b3b0f40163b3c451290001', null, null, 'admin', null, null, null, null, '1', null, null, null, null, null, '2018-05-31 09:16:17', '0', 'admin', null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('user1', '000125', null, 'admin', null, null, null, null, null, '研发部', 'dept1', 'role1', 'A角', null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `user_menu`
-- ----------------------------
DROP TABLE IF EXISTS `user_menu`;
CREATE TABLE `user_menu` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `user_id` varchar(32) DEFAULT NULL,
  `menu_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_menu
-- ----------------------------
INSERT INTO `user_menu` VALUES ('c164a6c2d2a111e8a87100e04c68532f', 'user1', 'menu32');
INSERT INTO `user_menu` VALUES ('c164a747d2a111e8a87100e04c68532c', 'user1', 'menu212');
INSERT INTO `user_menu` VALUES ('c164a747d2a111e8a87100e04c68532d', 'user1', 'menu211');
INSERT INTO `user_menu` VALUES ('c164a747d2a111e8a87100e04c68532f', 'user1', 'menu33');

-- ----------------------------
-- Procedure structure for `product`
-- ----------------------------
DROP PROCEDURE IF EXISTS `product`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `product`()
BEGIN
SELECT * from `user`;
end
;;
DELIMITER ;
