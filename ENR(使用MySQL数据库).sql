/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.5.61 : Database - enr
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`enr` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `enr`;

/*Table structure for table `auditopinion` */

DROP TABLE IF EXISTS `auditopinion`;

CREATE TABLE `auditopinion` (
  `ID` varchar(255) NOT NULL,
  `isPass` varchar(255) DEFAULT NULL,
  `opinion` longtext,
  `createTime` datetime DEFAULT NULL,
  `auditor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_AuditOpinion_Personal` (`auditor`),
  CONSTRAINT `FK_AuditOpinion_Personal` FOREIGN KEY (`auditor`) REFERENCES `personal` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `auditopinion` */

insert  into `auditopinion`(`ID`,`isPass`,`opinion`,`createTime`,`auditor`) values ('1c43e4218ddafda3','通过','通过','2020-02-15 21:13:28','00001'),('25e192c036ab8dd4','未审核','未审核','2020-03-12 12:44:34',NULL),('2b051b10015c03b2','通过','通过','2020-02-15 21:11:40','00001'),('32dce73223da479a','未审核','未审核','2020-02-15 22:03:47',NULL),('37e4b8ab791e87d5','通过','通过','2020-02-15 21:29:24','00001'),('3cebddff47b1cea7','通过','通过','2020-02-15 21:21:04','00001'),('3d81f4a9ca839687','通过','通过','2020-02-15 20:56:31','00001'),('4536b7a443c6e07f','通过','通过','2020-02-15 21:14:03','00001'),('4a7e10c52c393b8','未审核','未审核','2020-04-13 15:38:29',NULL),('4ec7b02d20616db5','通过','通过','2020-02-15 21:12:41','00001'),('506a74a5b2ecd456','通过','通过','2020-02-15 22:08:18','00001'),('5201d794c65be0df','未审核','未审核','2020-04-13 18:03:02',NULL),('53ed6918fbe63753','未审核','未审核','2020-02-15 21:33:55',NULL),('6e8e60d0ba03b90b','通过','通过','2020-02-15 21:25:09','00001'),('6f65e00f0f0af473','未审核','未审核','2020-02-15 21:27:17',NULL),('708cab4eb95fd6ae','通过','通过','2020-02-15 21:24:08','00001'),('75e9e214d687c635','通过','通过','2020-02-15 21:21:35','00001'),('941bedc1a51d8193','通过','通过','2020-02-15 21:30:49','00001'),('9aed803142ffe252','未审核','未审核','2020-02-15 21:52:56',NULL),('9c16fd4d2ff4b1b4','通过','通过\r\n','2020-02-15 21:30:26','00001'),('9f24571ca7d15ce3','通过','通过','2020-02-15 21:26:00','00001'),('a1100ea2d98a26d7','未审核','未审核','2020-02-15 22:05:56',NULL),('a3628fb8aa91bb6c','通过','通过','2020-02-15 20:54:21','00001'),('a615661682a503df','未审核','未审核','2020-02-15 21:59:45',NULL),('ac42a87a80ebebdb','通过','通过','2020-04-13 15:44:25','00001'),('b035650fd29a490b','通过','通过','2020-02-15 21:27:48','00001'),('b78d29da3b76299','未审核','未审核','2020-02-15 21:33:20',NULL),('bdbc27472f9d0712','通过','通过','2020-02-15 21:28:54','00001'),('d04a81fa2f34df91','通过','通过','2020-02-15 21:26:47','00001'),('e287023d7ad3665f','通过','通过','2020-02-15 21:15:11','00001'),('edb50975c7ff331b','通过','通过','2020-02-15 21:17:47','00001'),('f788ea4f7401e773','通过','通过','2020-02-16 12:30:03','ab00f811ff00064d');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `ID` varchar(255) NOT NULL,
  `imageName` varchar(255) DEFAULT NULL,
  `imageUrl` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `text` longtext,
  `serialState` varchar(255) DEFAULT NULL,
  `bookType` varchar(255) DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  `fileUrl` varchar(255) DEFAULT NULL,
  `fileSize` varchar(255) DEFAULT NULL,
  `uploadUser` varchar(255) DEFAULT NULL,
  `uploadTime` datetime DEFAULT NULL,
  `clickCount` int(11) DEFAULT NULL,
  `isTrue` int(11) DEFAULT NULL,
  `auditOpinion` varchar(255) DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Book_User` (`uploadUser`),
  KEY `FK_Book_Department` (`bookType`),
  KEY `FK_Book_AuditOpinion` (`auditOpinion`),
  CONSTRAINT `FK_Book_AuditOpinion` FOREIGN KEY (`auditOpinion`) REFERENCES `auditopinion` (`ID`),
  CONSTRAINT `FK_Book_Department` FOREIGN KEY (`bookType`) REFERENCES `department` (`ID`),
  CONSTRAINT `FK_Book_User` FOREIGN KEY (`uploadUser`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`ID`,`imageName`,`imageUrl`,`name`,`author`,`text`,`serialState`,`bookType`,`fileName`,`fileUrl`,`fileSize`,`uploadUser`,`uploadTime`,`clickCount`,`isTrue`,`auditOpinion`,`isDelete`) values ('14fa685e38c95ce3','img-5da4d5e05d839fe3f32277d2cd6f2030.jpg','../ashx/Covers/img-5da4d5e05d839fe3f32277d2cd6f2030.jpg','大王饶命','会说话的肘子','高中生吕树在一场车祸中改变人生，当灵气复苏时代来袭，他要做这时代的领跑者。\r\n物竞天择，胜者为王。\r\n……','已完结','fb150d2e514695bq','19.jpg','../../ashx/Files/19.jpg','784818','693040c30e4205d0','2020-02-15 21:26:00',3,1,'9f24571ca7d15ce3',0),('19d680a4579c09b4','21.jpg','../ashx/Covers/21.jpg','回到过去变成猫','陈词懒调','楚华大学东家属区大院门口，门卫大叔接了个电话之后，拉开窗子朝不远处的小树林中气十足一声吼：“黑炭，你妈叫你回家吃饭！”嗖——一只黑猫从小树林那边茂密的草丛里冲射而出，朝某栋楼跑去，眨眼间便消失在楼道口。在它之后，一个个猫头接连从草丛那边冒出来。饭点了，各回各家，各找各妈。……有人说，猫是这个世界上唯一一个整个种族都是神经病的动物，元芳你怎么看？－－－－－－－－－－－－－－－－－－无修真，想看修真的可以点“X”了。——————新书《未来天王》已发。','已完结','fb150d2e514695bq','17.jpg','../../ashx/Files/17.jpg','484758','693040c30e4205d0','2020-02-15 21:30:26',11,1,'9c16fd4d2ff4b1b4',0),('1d26e73a5d81b2ae','诸葛大力.jpg','../ashx/Covers/诸葛大力.jpg','重生之财源滚滚','老鹰吃小鸡','当重生成为一种潮流，李东也幸运地赶上了重生的马车。\r\n　　上辈子遗憾太多，这辈子且让他一一弥补！\r\n　　看小人物重回2004，亲情爱情双丰收，发家致富两不误！','已完结','fb150d2e514695bq','img-73d3cc7e9042ce40c97a4764e7a4970f.jpg','../../ashx/Files/img-73d3cc7e9042ce40c97a4764e7a4970f.jpg','2186884','693040c30e4205d0','2020-02-15 21:24:08',2,1,'708cab4eb95fd6ae',0),('245ed8e73af056d7','7.jpg','../ashx/Covers/7.jpg','学霸的黑科技系统','晨星LL','“系统，积分能兑钱吗？”\r\n　　“不能。”\r\n　　“那我要你何用！”\r\n　　“本系统能让你当上学霸，你还要钱干啥？”\r\n　　——\r\n　　本书又名《我要当学霸》','连载中','fb250d2e514695bq','7.jpg','../../ashx/Files/7.jpg','285376','1522780723982b66','2020-02-15 22:05:56',0,0,'a1100ea2d98a26d7',1),('25d06bba90704a5f','诸葛大力.jpg','../ashx/Covers/诸葛大力.jpg','打造诸天神话','请叫我小佳佳','【创世流】青帝出世，威压天地！女娲补天，天外有天！老子证道，谁与争锋？七王五帝，六道轮回，诸天万界……终不敌荒主俯瞰而下一道眸光。\r\n放养众生，以世界为田地，以神话和文明为果实，追寻宇宙大崩塌的隐秘，追寻返家之路。\r\n　　从山海经怪物到远古氏族建立，从【轮回殿】到【天地人三界】，打造远古神庭和六道轮回。\r\n青帝、七王、三清、金乌、外挂傍身的杂草…\r\n　　这是一个灭霸式老农民打造荒古世界的故事……\r\n　　ps：智商在线、慎重苟发育、完全原创魔改剧情，喷子请直接绕道。曾用书名《打造荒古世界》！','已完结','fb150d2e514695bq','暂无封面.jpg','../../ashx/Files/暂无封面.jpg','6318','fb850d2e514695be','2020-02-15 21:15:11',6,1,'e287023d7ad3665f',0),('281c628df5251f12','27.jpg','../ashx/Covers/27.jpg','我怎么就火了呢 ','奈何笑忘川','来到平行世界的方别只想过普通的生活。\r\n直到他相亲第五十次失败的那一天，他捡到了一个女高中生。\r\n身为逃家富二代的她梦想成为大明星。\r\n于是方别陪着她来到了横店。\r\n原本他只想随意整两部烂片打破她的明星梦，好让她回去继承亿万家产，自己也能跟着混口饭吃。\r\n直到他发现......\r\n门口美甲店的老板说他叫吉良吉影。\r\n横店巡逻的那个有着演员梦想的小片警，他的名字是陈永仁，他还有个哥们，名字叫刘建明。\r\n那个被大小姐她爹派来暗中保护她的保镖，名字叫燕双鹰......\r\n然后......方别火了。\r\n后现代主义电影教父？那是什么鬼......','已完结','fb150d2e514695bq','27.jpg','../../ashx/Files/27.jpg','977853','693040c30e4205d0','2020-02-15 21:28:54',8,1,'bdbc27472f9d0712',0),('2f9ccc1ddefe6cd4','img-5da4d5e05d839fe3f32277d2cd6f2030.jpg','../ashx/Covers/img-5da4d5e05d839fe3f32277d2cd6f2030.jpg','明星的悠闲人生','五矿贤者','　在影视城做牛做马当了10年龙套演员的李轩，穿越到地球平行世界。\r\n　　李轩：哎，罪过啊！我为什么要这么的优秀！本来男女比例就已经失衡，奈何。。。。。真的不怪我啊！\r\n　　无数男性同胞：打死李轩！不然我找不到女朋友！','已完结','fb150d2e514695bq','全员脱单.mp3','../../ashx/Files/暂无封面.jpg','89631','693040c30e4205d0','2020-03-12 12:44:34',0,0,'25e192c036ab8dd4',0),('3095c9e1b01236e7','诸葛大力.jpg','../ashx/Covers/诸葛大力.jpg','读档修仙','真名封印','【读档流】修仙不易，更别说一个普通的凡人，想要在这个命如草芥，生死由天的世界修行。\r\n在这个人吃人的疯狂世界，卓不凡唯一能做的，就只有不断地将自己的修仙生涯存档，因为他不知道自己什么时候会莫名其妙的死亡。\r\n及时存档，然后死亡读档。\r\n究竟是将残酷的命运再经历一次，还是将悲惨的结局重新改写。\r\n——————\r\n新书《超神封魔师》已经发布，还请新老书友，多多支持！谢谢！！','已完结','fb850d2e514695bq','暂无封面.jpg','../../ashx/Files/暂无封面.jpg','6318','fb850d2e514695be','2020-02-15 21:21:04',6,1,'3cebddff47b1cea7',0),('337e172d6947331b','诸葛大力.jpg','../ashx/Covers/诸葛大力.jpg','史上第一祖师爷','八月飞鹰','穿越了，也有了一个系统，但林锋压力山大。\r\n　　系统主线任务：林锋开山立派，建立史上第一大宗门，林锋本人成为第一祖师。\r\n　　于是为了成为史上第一祖师爷，林锋开始奋斗。\r\n　　“你叫石天昊？天生至尊，却被族兄谋夺，现在被生父寄养在一个小山村里？来来来，跟为师走，咱们让那些人知道一下，欠下的公道，必须还！”\r\n　　“你叫萧焱？昔日天才，现在废柴，你的未婚妻还上门打脸退婚？来来来，跟为师走，咱们让那丫头知道一下，什么叫莫欺少年穷！”\r\n　　“你叫朱易？侯府庶子，被父亲压制，母亲是昔日圣女却被人害死了？来来来，跟为师走，咱们让你爹知道一下，什么叫天大地大，拳头最……不对，是道理最大！”\r\n　　新书《史上最强师兄》已发布，欢迎移步阅读！','已完结','fb850d2e514695bq','诸葛大力.jpg','../../ashx/Files/诸葛大力.jpg','3234696','fb850d2e514695be','2020-02-15 21:17:47',4,1,'edb50975c7ff331b',0),('38953703ab7a0635','img-5da4d5e05d839fe3f32277d2cd6f2030.jpg','../ashx/Covers/img-5da4d5e05d839fe3f32277d2cd6f2030.jpg','对着剑说','兰帝魅晨','传说开天辟地之力化作无数部分，散落在天地间，被称为混沌碎片，得其力量多者既为武王！\r\n　　武王可令逝者死而复生，让活者永生不灭。\r\n　　只要世上还有一个人记得，就能死而复生！\r\n　　这就是武王拥有的力量。\r\n　　天下众生，皆为大小武王而战，只求得赐那永生不灭的殊荣。\r\n　　李天照本来也以为他追求的是这份殊荣，某天他突然发现，他要的是拥有这种力量……','已完结','fb850d2e514695bq','暂无封面.jpg','../../ashx/Files/暂无封面.jpg','6318','fb850d2e514695be','2020-02-15 21:21:35',3,1,'75e9e214d687c635',1),('39a205420b639687','19.jpg','../ashx/Covers/19.jpg','我有一张沾沾卡','宝石猫','灵气复苏，你有血脉无双，来来来，让我粘一下!\r\n什么，你有悟性盖世，来来来，让我粘一下!\r\n哎呀，大哥你福运冲天，实在是让人羡慕，来来来，让俺粘一下……\r\nps：已完本《无上崛起》《随身英雄杀》皆是精品，大家有兴趣可以去看一看。老猫出品，必属精品！','已完结','fb850d2e514695bq','19.jpg','../../ashx/Files/19.jpg','784818','fb850d2e514695be','2020-02-15 20:54:21',4,1,'a3628fb8aa91bb6c',0),('49a205420b639687','img-73d3cc7e9042ce40c97a4764e7a4970f.jpg','../ashx/Covers/img-73d3cc7e9042ce40c97a4764e7a4970f.jpg','完美世界','辰东','一粒尘可填海，一根草斩尽日月星辰，弹指间天翻地覆。\r\n　　群雄并起，万族林立，诸圣争霸，乱天动地。问苍茫大地，谁主沉浮？！\r\n　　一个少年从大荒中走出，一切从这里开始……','已完结','fb850d2e514695bq','暂无封面.jpg','../../ashx/Files/暂无封面.jpg','6318','fb850d2e514695be','2020-02-15 20:56:31',1,1,'3d81f4a9ca839687',0),('4a7e10c52c393b8','19.jpg','E:\\学习\\编程\\毕业设计\\电子书资源网\\EBookNetworkResource\\ENR_UI\\ashx\\Covers\\19.jpg','对着剑说','兰帝魅晨','传说开天辟地之力化作无数部分，散落在天地间，被称为混沌碎片，得其力量多者既为武王！\r\n　　武王可令逝者死而复生，让活者永生不灭。\r\n　　只要世上还有一个人记得，就能死而复生！\r\n　　这就是武王拥有的力量。\r\n　　天下众生，皆为大小武王而战，只求得赐那永生不灭的殊荣。\r\n　　李天照本来也以为他追求的是这份殊荣，某天他突然发现，他要的是拥有这种力量……','已完结','fb850d2e514695bq','21.jpg','E:\\学习\\编程\\毕业设计\\电子书资源网\\EBookNetworkResource\\ENR_UI\\ashx\\Files\\21.jpg','839132','fb850d2e514695be','2020-04-13 15:38:30',0,0,'4a7e10c52c393b8',1),('5201d794c65be0df','18.jpg','E:\\学习\\编程\\毕业设计\\电子书资源网\\EBookNetworkResource\\ENR_UI\\ashx\\Covers\\18.jpg','对着剑说','兰帝魅晨','传说开天辟地之力化作无数部分，散落在天地间，被称为混沌碎片，得其力量多者既为武王！\r\n　　武王可令逝者死而复生，让活者永生不灭。\r\n　　只要世上还有一个人记得，就能死而复生！\r\n　　这就是武王拥有的力量。\r\n　　天下众生，皆为大小武王而战，只求得赐那永生不灭的殊荣。\r\n　　李天照本来也以为他追求的是这份殊荣，某天他突然发现，他要的是拥有这种力量……','已完结','fb850d2e514695bq','19.jpg','E:\\学习\\编程\\毕业设计\\电子书资源网\\EBookNetworkResource\\ENR_UI\\ashx\\Files\\19.jpg','784818','fb850d2e514695be','2020-04-13 18:03:02',0,0,'5201d794c65be0df',0),('5a27e8c05368af73','3.jpg','../ashx/Covers/3.jpg','学霸的黑科技系统','晨星LL','“系统，积分能兑钱吗？”\r\n　　“不能。”\r\n　　“那我要你何用！”\r\n　　“本系统能让你当上学霸，你还要钱干啥？”\r\n　　——\r\n　　本书又名《我要当学霸》','连载中','fb250d2e514695bq','21.jpg','../../ashx/Files/21.jpg','839132','1522780723982b66','2020-02-16 12:30:03',22,1,'f788ea4f7401e773',0),('608984365513b90b','img-73d3cc7e9042ce40c97a4764e7a4970f.jpg','../ashx/Covers/img-73d3cc7e9042ce40c97a4764e7a4970f.jpg','黄金瞳','打眼','典当行工作的小职员庄睿，在一次意外中眼睛发生异变。\r\n　　美轮美奂的陶瓷，古拙大方的青铜器，惊心动魄的赌石接踵而来，他的生活也随之产生了天翻地覆的变化。\r\n　　眼生双瞳，财富人生\r\n　　*********************','已完结','fb150d2e514695bq','19.jpg','../../ashx/Files/19.jpg','784818','693040c30e4205d0','2020-02-15 21:25:09',5,1,'6e8e60d0ba03b90b',0),('619c348461e4d456','2.jpg','../ashx/Covers/2.jpg','学霸的黑科技系统','晨星LL','“系统，积分能兑钱吗？”\r\n　　“不能。”\r\n　　“那我要你何用！”\r\n　　“本系统能让你当上学霸，你还要钱干啥？”\r\n　　——\r\n　　本书又名《我要当学霸》','连载中','fb250d2e514695bq','5.jpg','../../ashx/Files/5.jpg','717563','1522780723982b66','2020-02-15 22:08:18',3,0,'506a74a5b2ecd456',1),('671485c052a50153','11.jpg','../ashx/Covers/11.jpg','学霸的黑科技系统','晨星LL','“系统，积分能兑钱吗？”\r\n　　“不能。”\r\n　　“那我要你何用！”\r\n　　“本系统能让你当上学霸，你还要钱干啥？”\r\n　　——\r\n　　本书又名《我要当学霸》','连载中','fb150d2e514695bq','19.jpg','../../ashx/Files/19.jpg','784818','1522780723982b66','2020-02-15 21:33:55',0,0,'53ed6918fbe63753',1),('6b4ba013ddbbf77f','img-73d3cc7e9042ce40c97a4764e7a4970f.jpg','../ashx/Covers/img-73d3cc7e9042ce40c97a4764e7a4970f.jpg','史上最强师兄','八月飞鹰','燕赵歌第一次穿越，穿到了武道文明繁盛至极的异世界，一头撞进包罗万象，遍收天下经典的神宫藏书楼里，但随后便是一场天地大劫，连神宫也破灭了。\r\n　　接下来居然第二次穿越，灵魂来到了同一个世界，不知多少年后的时代。\r\n　　人们发掘承载破灭之后残存的遗留，这里的武道文明重新起步，还处于新一代的发展期。\r\n　　装了一脑子神宫秘籍宝典的燕赵歌，二次穿越到当前的时代，简直就如同一个人玩惯了地狱模式之后，突然被丢去玩简单模式。\r\n　　简直不要太爽！\r\n　　不过在此之前，他先要解决一个问题。\r\n　　“我不是主角？而是跟主角争妹子的反派高富帅师兄？”\r\n　　“这剧本不对啊！”\r\n　　PS：已有460万字完本精品老书《史上第一祖师爷》，欢迎大家收藏养肥本书的同时移步阅读。','已完结','fb850d2e514695bq','暂无封面.jpg','../../ashx/Files/暂无封面.jpg','6318','fb850d2e514695be','2020-02-15 21:14:03',4,1,'4536b7a443c6e07f',0),('6b721a8ace65df91','21.jpg','../ashx/Covers/21.jpg','神藏','打眼','一念之间，沧海桑田\r\n　　打眼带你进入古玩的世界！！！','已完结','fb150d2e514695bq','21.jpg','../../ashx/Files/21.jpg','839132','693040c30e4205d0','2020-02-15 21:26:47',0,1,'d04a81fa2f34df91',0),('6e82b664bab2090b','23.jpg','../ashx/Covers/23.jpg','宝鉴','打眼','一局安百变，叵测是人心！\r\n　　三教九流，五行三家，尽在宝鉴之中！','已完结','fb150d2e514695bq','23.jpg','../../ashx/Files/23.jpg','766345','693040c30e4205d0','2020-02-15 21:27:48',5,1,'b035650fd29a490b',0),('727552f2467733b3','4.jpg','../ashx/Covers/4.jpg','明星的悠闲人生','五矿贤者','　在影视城做牛做马当了10年龙套演员的李轩，穿越到地球平行世界。\r\n　　李轩：哎，罪过啊！我为什么要这么的优秀！本来男女比例就已经失衡，奈何。。。。。真的不怪我啊！\r\n　　无数男性同胞：打死李轩！不然我找不到女朋友！','已完结','fb150d2e514695bq','4.jpg','../../ashx/Files/4.jpg','301109','693040c30e4205d0','2020-02-15 21:30:49',18,1,'941bedc1a51d8193',1),('837ef8cc3f814da3','19.jpg','../ashx/Covers/19.jpg','我家可能有位大佬','雨下的好大','江左有个貌美的老婆，可是她却经常出差。\r\n　　去干嘛？\r\n　　不是忙着给他带帽子，而是瞒着他降妖除魔去了。\r\n　　得知真相的江左连连叹息，看来自己也坐不住了。\r\n　　为了他美好的夫妻生活，江左只能暗中出手。\r\n　　降妖除魔嘛，维护天地秩序嘛，没问题，老婆高兴就行。\r\n　　…………','已完结','fb850d2e514695bq','暂无封面.jpg','../../ashx/Files/暂无封面.jpg','6318','fb850d2e514695be','2020-02-15 21:13:28',1,1,'1c43e4218ddafda3',0),('8e747269a61c6a99','23.jpg','../ashx/Covers/23.jpg','学霸的黑科技系统','晨星LL','“系统，积分能兑钱吗？”\r\n　　“不能。”\r\n　　“那我要你何用！”\r\n　　“本系统能让你当上学霸，你还要钱干啥？”\r\n　　——\r\n　　本书又名《我要当学霸》','连载中','fb250d2e514695bq','18.jpg','../../ashx/Files/18.jpg','762653','1522780723982b66','2020-02-15 21:33:20',0,0,'b78d29da3b76299',1),('91f5a66d8edec947','img-73d3cc7e9042ce40c97a4764e7a4970f.jpg','../ashx/Covers/img-73d3cc7e9042ce40c97a4764e7a4970f.jpg','天道罚恶令','东城令','人心生一念，天地尽皆知。\r\n善恶若无报，乾坤必有私。','已完结','fb850d2e514695bq','暂无封面.jpg','../../ashx/Files/暂无封面.jpg','6318','fb850d2e514695be','2020-02-15 21:12:41',0,1,'4ec7b02d20616db5',0),('a21ab2e47b53c7d5','45.jpg','../ashx/Covers/45.jpg','我只想享受人生','外汇似海','他是金融之神，先定一个2300亿的小目标。\r\n　　打造自己超级商业帝国，享受美好人生。','已完结','fb150d2e514695bq','19.jpg','../../ashx/Files/19.jpg','784818','693040c30e4205d0','2020-02-15 21:29:24',7,1,'37e4b8ab791e87d5',0),('ac42a87a80ebebdb','12.jpg','E:\\学习\\编程\\毕业设计\\电子书资源网\\EBookNetworkResource\\ENR_UI\\ashx\\Covers\\12.jpg','对着剑说','兰帝魅晨','传说开天辟地之力化作无数部分，散落在天地间，被称为混沌碎片，得其力量多者既为武王！\r\n　　武王可令逝者死而复生，让活者永生不灭。\r\n　　只要世上还有一个人记得，就能死而复生！\r\n　　这就是武王拥有的力量。\r\n　　天下众生，皆为大小武王而战，只求得赐那永生不灭的殊荣。\r\n　　李天照本来也以为他追求的是这份殊荣，某天他突然发现，他要的是拥有这种力量……','已完结','fb850d2e514695bq','20.jpg','E:\\学习\\编程\\毕业设计\\电子书资源网\\EBookNetworkResource\\ENR_UI\\ashx\\Files\\20.jpg','454337','fb850d2e514695be','2020-04-13 15:44:25',0,1,'ac42a87a80ebebdb',1),('b275e5a6a2c3d272','19.jpg','../ashx/Covers/19.jpg','斗罗大陆','唐家三少','唐门外门弟子唐三，因偷学内门绝学为唐门所不容，跳崖明志时却发现没有死，反而以另外一个身份来到了另一个世界，一个属于武魂的世界，名叫斗罗大陆。这里没有魔法，没有斗气，没有武术，却有神奇的武魂。这里的每个人，在自己六岁的时候，都会在武魂殿中令武魂觉醒。武魂有动物，有植物，有器物，武魂可以辅助人们的日常生活。而其中一些特别出色的武魂却可以用来修炼并进行战斗，这个职业，是斗罗大陆上最为强大也是最荣耀的职业——魂师!\r\n　　当唐门暗器来到斗罗大陆，当唐三武魂觉醒，他能否在这片武魂的世界再铸唐门的辉煌？他能否成为这个世界的主宰：神?','已完结','fb850d2e514695bq','暂无封面.jpg','../../ashx/Files/暂无封面.jpg','6318','fb850d2e514695be','2020-02-15 21:11:40',2,1,'2b051b10015c03b2',0),('ca554dfc3dccb79a','4.jpg','../ashx/Covers/4.jpg','学霸的黑科技系统','晨星LL','“系统，积分能兑钱吗？”\r\n　　“不能。”\r\n　　“那我要你何用！”\r\n　　“本系统能让你当上学霸，你还要钱干啥？”\r\n　　——\r\n　　本书又名《我要当学霸》','连载中','fb250d2e514695bq','4.jpg','../../ashx/Files/4.jpg','301109','1522780723982b66','2020-02-15 22:03:47',0,0,'32dce73223da479a',1),('eb60d781910db473','18.jpg','../ashx/Covers/18.jpg','天才相师','打眼','少年叶天偶得相师传承，究天人之际，通古今之变，为往圣继绝学','已完结','fb150d2e514695bq','18.jpg','../../ashx/Files/18.jpg','762653','693040c30e4205d0','2020-02-15 21:27:17',2,0,'6f65e00f0f0af473',0),('f0608b919d0431d2','5.jpg','../ashx/Covers/5.jpg','学霸的黑科技系统','晨星LL','“系统，积分能兑钱吗？”\r\n　　“不能。”\r\n　　“那我要你何用！”\r\n　　“本系统能让你当上学霸，你还要钱干啥？”\r\n　　——\r\n　　本书又名《我要当学霸》','连载中','fb250d2e514695bq','5.jpg','../../ashx/Files/5.jpg','717563','1522780723982b66','2020-02-15 21:52:56',0,0,'9aed803142ffe252',1),('f58bbf33c71b11df','6.jpg','../ashx/Covers/6.jpg','学霸的黑科技系统','晨星LL','“系统，积分能兑钱吗？”\r\n　　“不能。”\r\n　　“那我要你何用！”\r\n　　“本系统能让你当上学霸，你还要钱干啥？”\r\n　　——\r\n　　本书又名《我要当学霸》','连载中','fb250d2e514695bq','6.jpg','../../ashx/Files/6.jpg','467820','1522780723982b66','2020-02-15 21:59:45',0,0,'a615661682a503df',1);

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `ID` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `leader` varchar(255) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `isTrue` int(11) DEFAULT NULL,
  `isAdministrative` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`ID`,`name`,`leader`,`createTime`,`isTrue`,`isAdministrative`) values ('00001','董事长办公室','00001','2020-02-01',1,1),('fb150d2e514695bq','现代都市','00001','2020-02-08',1,0),('fb250d2e514695bq','科幻灵异','00001','2020-02-02',1,0),('fb81232e514695bq','游戏竞技','00001','2020-02-02',1,0),('fb850d11514695bq','美文同人','00001','2020-02-02',1,0),('fb850d21314695bq','历史军事','00001','2020-02-01',1,0),('fb850d2e114695bq','名著杂志','00001','2020-02-02',1,0),('fb850d2e514625bq','技术其他','00001','2020-02-02',1,0),('fb850d2e514695be','武侠仙侠','00001','2020-02-08',1,0),('fb850d2e514695bq','玄幻奇幻','00001','2020-02-08',1,0);

/*Table structure for table `limit` */

DROP TABLE IF EXISTS `limit`;

CREATE TABLE `limit` (
  `ID` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `operation` longtext,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `limit` */

insert  into `limit`(`ID`,`name`,`operation`) values ('001','一级','仅能修改本部门内图书审核结果，查看本用户已审核的审核列表'),('002','二级','拥有一级权限内容且能修改本部门用户信息，查看本部门用户已审核的审核列表'),('010','十级','拥有全系统权限');

/*Table structure for table `personal` */

DROP TABLE IF EXISTS `personal`;

CREATE TABLE `personal` (
  `ID` varchar(255) NOT NULL,
  `PID` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `limit` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `isDimission` int(11) DEFAULT NULL,
  `dimissionTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Personal_Department` (`department`),
  KEY `FK_Personal_limit` (`limit`),
  CONSTRAINT `FK_Personal_Department` FOREIGN KEY (`department`) REFERENCES `department` (`ID`),
  CONSTRAINT `FK_Personal_limit` FOREIGN KEY (`limit`) REFERENCES `limit` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `personal` */

insert  into `personal`(`ID`,`PID`,`name`,`pwd`,`department`,`limit`,`telephone`,`createTime`,`isDimission`,`dimissionTime`) values ('00001','1','路明非','123','00001','010','13828912138','2020-02-14 00:00:00',0,NULL),('9cc3e80c21e0a565','10','测试账号','123456','00001','010','13822812222','2020-03-12 12:38:29',1,NULL),('ab00f811ff00064d','02','叶浪','123456','fb250d2e514695bq','001','110','2020-02-15 12:18:49',0,NULL),('abb5b67814996ee3','03','张喜喜','123456','fb250d2e514695bq','002','13822812138','2020-02-15 22:45:22',0,NULL),('f8c6c4f3516da813','05','王令','123456','fb850d2e514695be','002','13822912138','2020-02-16 22:05:08',0,NULL),('fa4c31e227ba1309','06','漩涡鸣人','123456','fb250d2e514695bq','001','13813812138','2020-04-13 16:46:53',0,NULL),('fe27d22e01104c5b','04','陆亦可','123456','fb850d2e514695be','001','13822812138','2020-02-16 13:19:25',0,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `ID` varchar(255) NOT NULL,
  `UName` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`ID`,`UName`,`Email`,`pwd`) values (',IRequiresSessionState',',IRequiresSessionState',',IRequiresSessionState',',IRequiresSessionState'),('1522780723982b66','123','456','321'),('25c8c62dc428691b','5','321','321'),('44b2f0235876a04f','11','po123456789@qq.com','123456'),('525700b801134bef','7','321','321'),('693040c30e4205d0','2','321','321'),('78b71cd5cff2be07','10','321','321'),('8c07cb6ede33a8eb','8','321','321'),('9aebccd9014abf59','6','321','321'),('b73ce3e34e94ee87','9','321','321'),('ed324b3caf6f590a','4','321','321'),('fb850d2e514695be','1','po123456789@qq.com','123');

/*Table structure for table `bookinformation` */

DROP TABLE IF EXISTS `bookinformation`;

/*!50001 DROP VIEW IF EXISTS `bookinformation` */;
/*!50001 DROP TABLE IF EXISTS `bookinformation` */;

/*!50001 CREATE TABLE  `bookinformation`(
 `auditOpinion` varchar(255) ,
 `isPass` varchar(255) ,
 `opinion` longtext ,
 `createTime` datetime ,
 `auditor` varchar(255) ,
 `BookID` varchar(255) ,
 `imgName` varchar(255) ,
 `imgUrl` varchar(255) ,
 `BookName` varchar(255) ,
 `author` varchar(255) ,
 `BookText` longtext ,
 `BookSerialState` varchar(255) ,
 `BookType` varchar(255) ,
 `FileName` varchar(255) ,
 `FileUrl` varchar(255) ,
 `FileSize` varchar(255) ,
 `UploadUser` varchar(255) ,
 `UploadTime` datetime ,
 `ClickCount` int(11) ,
 `IsTrue` int(11) ,
 `IsDelete` int(11) ,
 `DeparName` varchar(255) ,
 `UName` varchar(255) ,
 `UEmail` varchar(255) 
)*/;

/*View structure for view bookinformation */

/*!50001 DROP TABLE IF EXISTS `bookinformation` */;
/*!50001 DROP VIEW IF EXISTS `bookinformation` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `bookinformation` AS select `book`.`auditOpinion` AS `auditOpinion`,`auditopinion`.`isPass` AS `isPass`,`auditopinion`.`opinion` AS `opinion`,`auditopinion`.`createTime` AS `createTime`,`auditopinion`.`auditor` AS `auditor`,`book`.`ID` AS `BookID`,`book`.`imageName` AS `imgName`,`book`.`imageUrl` AS `imgUrl`,`book`.`name` AS `BookName`,`book`.`author` AS `author`,`book`.`text` AS `BookText`,`book`.`serialState` AS `BookSerialState`,`book`.`bookType` AS `BookType`,`book`.`fileName` AS `FileName`,`book`.`fileUrl` AS `FileUrl`,`book`.`fileSize` AS `FileSize`,`book`.`uploadUser` AS `UploadUser`,`book`.`uploadTime` AS `UploadTime`,`book`.`clickCount` AS `ClickCount`,`book`.`isTrue` AS `IsTrue`,`book`.`isDelete` AS `IsDelete`,`depart`.`name` AS `DeparName`,`user`.`UName` AS `UName`,`user`.`Email` AS `UEmail` from (((`auditopinion` join `book` on((`book`.`auditOpinion` = `auditopinion`.`ID`))) join `department` `depart` on((`book`.`bookType` = `depart`.`ID`))) join `user` on((`book`.`uploadUser` = `user`.`ID`))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
