/*
 Navicat Premium Data Transfer

 Source Server         : Data-Viettravel
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 34.87.28.37:3306
 Source Schema         : viettraveldata

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 15/01/2021 20:38:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fullname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin', 'Phạm Tiệp');

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `descriptions` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `images` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES (2, 'Banner1', 'Banner1', 'banner1', 'banner1.jpg');
INSERT INTO `banner` VALUES (3, 'Banner2', 'Banner2', 'Banner2', 'banner2.jpg');
INSERT INTO `banner` VALUES (4, 'Banner3', 'Banner3', 'Banner3', 'banner3.jpg');
INSERT INTO `banner` VALUES (5, 'Banner4', 'Banner4', 'Banner4', 'banner4.jpg');
INSERT INTO `banner` VALUES (6, 'Banner5', 'Banner5', 'Banner5', 'banner5.jpg');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `descriptions` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `images` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, 'Đà Nẵng', 'Du lịch Đà Nẵng', 'danangbanner.jpg');
INSERT INTO `category` VALUES (2, 'Hà Nội', 'Du lịch Hà Nội', 'hanoibanner.jpg');
INSERT INTO `category` VALUES (3, 'Quảng Ninh', 'Du lịch Quảng Ninh', 'quangninhbanner.jpg');

-- ----------------------------
-- Table structure for gioithieu
-- ----------------------------
DROP TABLE IF EXISTS `gioithieu`;
CREATE TABLE `gioithieu`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `descriptions` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `contact` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rule` text CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ordertour
-- ----------------------------
DROP TABLE IF EXISTS `ordertour`;
CREATE TABLE `ordertour`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `hoten` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `diachi` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tourid` int(10) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `tourid`(`tourid`) USING BTREE,
  CONSTRAINT `ordertour_ibfk_1` FOREIGN KEY (`tourid`) REFERENCES `tour` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ordertour
-- ----------------------------
INSERT INTO `ordertour` VALUES (1, 'Tabn', 'test1', '123', 'test1', 3, 1);
INSERT INTO `ordertour` VALUES (2, 'Tabn', 'test1', '123', 'test1', 3, 1);
INSERT INTO `ordertour` VALUES (3, 'Phạm Tiệp', '08', 'Hải Dương', 'testemail@gmail.com', 3, 0);
INSERT INTO `ordertour` VALUES (4, 'Tuan Pham', '0928230347', 'Thái Bình', 'ngoctuan1102000@gmail.com', 3, 0);
INSERT INTO `ordertour` VALUES (5, 'Leo', '098752526', 'Hà Nội', 'ngoctuan1102000@gmail.com', 3, 0);
INSERT INTO `ordertour` VALUES (6, 'Tuân Phạm', '0976415525', 'Thái Bình', 'tuanpn.tb@gmail.com', 3, 0);
INSERT INTO `ordertour` VALUES (7, 'Tuân Phạm', '0928230347', 'Thái Bình', 'buivinh1325@gmail.com', 3, 0);

-- ----------------------------
-- Table structure for promotion
-- ----------------------------
DROP TABLE IF EXISTS `promotion`;
CREATE TABLE `promotion`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryid` int(11) NOT NULL,
  `promotioncode` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `diemdi` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `diemden` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `timedi` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `timeve` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `descriptions` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `images` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `categoryid`(`categoryid`) USING BTREE,
  CONSTRAINT `promotion_ibfk_1` FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of promotion
-- ----------------------------
INSERT INTO `promotion` VALUES (2, 2, '0', '0', '0', '0', '0', '0', '0', 'nosale.jpg', 0);

-- ----------------------------
-- Table structure for tip
-- ----------------------------
DROP TABLE IF EXISTS `tip`;
CREATE TABLE `tip`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tip
-- ----------------------------
INSERT INTO `tip` VALUES (2, 'Thận trọng khi du lịch ngắm tuyết tại miền núi', 'Thời tiết giá lạnh khiến nhiều khu vực ở miền núi phía Bắc xuất hiện hiện tượng băng tuyết như tại Sa Pa (tỉnh Lào Cai), Mẫu Sơn (tỉnh Lạng Sơn)... Nhiều du khách không bỏ lỡ cơ hội hiếm hoi này, đã thực hiện các chuyến du lịch để được trải nghiệm băng tuyết tại Việt Nam. Tuy nhiên, các chuyên gia cũng đưa ra nhiều cảnh báo cho du khách khi du lịch tại miền núi trong điều kiện thời tiết không thuận lợi.\r\nTừ ngày 8/1, nhiệt độ các tỉnh miền núi phía Bắc xuống thấp, nhiều nơi xuất hiện băng tuyết, như tại Sa Pa, Mẫu Sơn... tạo nên sức hút mới cho những du khách thích khám phá, mạo hiểm. Ngay trong ngày 8/1, rất nhiều du khách không ngại thời tiết giá lạnh, nhiệt độ xuống dưới 0 độ C đã thực hiện chuyến đi dã ngoại đến các vùng có băng tuyết để chụp ảnh check-in.\r\n\r\nAnh Nguyễn Hồng Sơn (du khách Hà Nội) đã có kế hoạch lên đỉnh Mẫu Sơn từ sớm để có thể ghi lại cảnh băng tuyết xuất hiện hiếm hoi tại Việt Nam. Anh Sơn cho biết, vốn thích du lịch khám phá, mạo hiểm, nên anh rất hào hứng thực hiện chuyến đi để thử thách bản thân trước sự khắc nghiệt của thời tiết.\r\nKhông chỉ dịp này lượng khách đến các tỉnh miền núi tăng cao, mà trước đó, vào cuối tháng 12/2020, tuyến cáp treo lên đỉnh Fanxipan (Sa Pa, Lào Cai) cũng quá tải do lượng du khách đổ về để ngắm tuyết quá đông.');
INSERT INTO `tip` VALUES (3, 'Loạt địa điểm check-in như trời Tây ở Việt Nam', 'Trước tình hình dịch Covid-19, ngại việc xuất ngoại, bạn có thể chọn các địa điểm du lịch đẹp trong nước để khám phá. Với loạt góc check-in hấp dẫn, những điểm đến này là nơi du khách thỏa sức sống ảo, lên hình sang chảnh.\r\n\r\nSa Pa (Lào Cai)\r\n\r\nCách Hà Nội khoảng 350 km, Sa Pa (Lào Cai) là một trong những điểm du lịch thu hút lượng lớn khách vào mùa đông. Nơi đây hấp dẫn bởi khung cảnh thiên nhiên đẹp, các dịch vụ từ bình dân tới cao cấp và nhiều trải nghiệm thú vị.\r\n\r\nMùa đông là thời điểm thị trấn chìm trong sương mù. Khí hậu lạnh giá, có lúc xuất hiện băng tuyết, tạo nên khung cảnh trắng xóa tựa trời Tây. Ngoài ra, bạn có thể lang thang quanh trung tâm thị trấn để tìm kiếm các điểm sống ảo lạ ở các quán cà phê, nhà hàng, trạm ga tàu leo Fansipan như Mường Hoa, Hoàng Liên...');
INSERT INTO `tip` VALUES (4, 'Tư vấn du lịch: Chuẩn bị cho chuyến đạp xe dã ngoại', 'Đạp xe dã ngoại là một trong những môn thể thao kết hợp với du lịch mang lại cho bạn những trải nghiệm thú vị kết hợp với rèn luyện sức khỏe. Để có chuyến đạp xe dã ngoại hoàn hảo, hãy lưu ý một số kinh nghiệm sau.');
INSERT INTO `tip` VALUES (5, '10 tour du lịch đáng trải nghiệm nhất năm 2021', 'Lặn ngắm xác tàu Titanic, đón nhật thực toàn phần tại Nam Cực hay du thuyền vòng quanh thế giới là những trải nghiệm đáng chờ đợi nhất trong năm 2021, theo trang Lonely Planet bình chọn.');
INSERT INTO `tip` VALUES (6, '10 lời khuyên hữu ích để giữ sức khỏe khi du lịch', 'Du lịch mang lại niềm vui và trải nghiệm tuyệt vời nhưng việc thường xuyên di chuyển trong suốt hành trình gây ra không ít căng thẳng và mệt mỏi. Dưới đây là những lời khuyên hữu ích giúp bạn giữ gìn sức khỏe trong chuyến đi.');
INSERT INTO `tip` VALUES (7, 'Thời điểm nào tuyệt vời nhất để khám phá Sơn Đoòng?', 'Sơn Đoòng là hang động lớn nhất thế giới, nằm trong vùng lõi của Vườn Quốc gia Phong Nha – Kẻ Bàng (Quảng Bình). Mỗi thời điểm, mỗi mùa Sơn Đoòng đều có vẻ đẹp riêng.');
INSERT INTO `tip` VALUES (8, 'Những địa điểm check-in trước thềm Giáng sinh ở Hà Nội', 'Mỗi dịp Giáng sinh đến là các bạn trẻ lại nô nức tìm kiếm những địa điểm check in Giáng sinh độc lạ, khó tìm để sống ảo. Những địa điểm dưới đây sẽ là gợi ý để bạn có những bức ảnh check-in đáng nể dịp Giáng sinh 2020.');
INSERT INTO `tip` VALUES (9, 'Nhà thờ Lớn - khoảng lặng trong lòng đô thị', 'Nhà thờ Lớn Hà Nội (số 40 phố Nhà Chung, phường Hàng Trống, quận Hoàn Kiếm) là Nhà thờ chính tòa của Tổng giáo phận Hà Nội. Đây là một trong những công trình Thiên chúa giáo được xây dựng sớm nhất và là nhà thờ đẹp nhất ở Hà Nội.');
INSERT INTO `tip` VALUES (10, 'Những địa điểm du lịch tiết kiệm phù hợp theo từng tháng', 'Bạn đang lên kế hoạch du lịch đến một địa điểm ngoài khả năng tài chính của bạn? Đừng băn khoăn quá nhiều bởi nếu bạn lựa chọn thời điểm phù hợp trong năm, số tiền bạn phải chi ra cho địa điểm đó có thể rẻ hơn sức tưởng tượng.');
INSERT INTO `tip` VALUES (11, 'Bí quyết để có chuyến du lịch \"siêu tiết kiệm\"', 'Chi phí cho một chuyến đi du lịch luôn là vấn đề khiến người ta phải suy nghĩ đau đầu. Những bí quyết sau đây sẽ giúp bạn phần nào tiết kiệm và chi tiêu hợp lý hơn cho chuyến đi chơi của mình.');
INSERT INTO `tip` VALUES (12, 'Những lưu ý khi đón Tết Dương lịch xa nhà', '(VOVTV) - Chỉ còn ít ngày nữa là một năm mới sẽ lại đến. Dù không được mong đợi như Tết Nguyên đán nhưng Tết Dương lịch vẫn là dịp để mọi người tận hưởng một kỳ nghỉ lễ thú vị bên gia đình, người thân. Làm thế nào để có một chuyến đi suôn sẻ và đúng như mong đợi? Dưới đây là một vài lưu ý giúp trải nghiệm của bạn trở nên thú vị và đáng nhớ.');
INSERT INTO `tip` VALUES (13, 'Bí quyết để \"auto xinh\" khi đi du lịch', '(VOVTV) - Khi đi du lịch, ai cũng muốn mình được nghỉ ngơi thoải mái và có những tấm ảnh kỷ niệm \"chất như nước cất\". Vậy có bí quyết nào để \"auto xinh\" dù phải đối mặt với sự thay đổi của khí hậu, thời tiết, thức ăn... nơi xa lạ?');
INSERT INTO `tip` VALUES (14, 'Những điểm du lịch đừng bỏ lỡ dịp cuối năm', 'Nếu có ý định du lịch vào dịp cuối năm, bạn đừng bỏ qua những điểm đến có cảnh sắc thiên nhiên thơ mộng, hữu tình của mùa hoa miền Đông Tây Bắc, Đà Lạt thành phố ngàn hoa hay miền Tây sông nước thanh bình.');

-- ----------------------------
-- Table structure for tour
-- ----------------------------
DROP TABLE IF EXISTS `tour`;
CREATE TABLE `tour`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryid` int(11) NOT NULL,
  `promotionid` int(11) NOT NULL,
  `name` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `diemdi` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `diemden` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `timedi` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `timeve` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `descriptions` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `images` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_macategory`(`categoryid`) USING BTREE,
  INDEX `fk_mauudai`(`promotionid`) USING BTREE,
  CONSTRAINT `fk_macategory` FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_mauudai` FOREIGN KEY (`promotionid`) REFERENCES `promotion` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tour
-- ----------------------------
INSERT INTO `tour` VALUES (3, 2, 2, 'Du lịch Tết Nguyên Đán Hà Nội - Hà Giang - Đồng Văn - Lũng Cú - Mèo Vạc - Cao Bằng từ Sài Gòn 2021', 'Hồ Chí Minh', 'Hà Nội - Hà Giang - Đồng Văn - Lũng Cú - Mèo Vạc - Cao Bằng - Thác Bản Giốc - Hang Pắc Bó - Hồ Ba Bể ', '14,15,17/02/2021 (Mùng 3,4,6 Tết)', '18/02/2021', 'NGÀY 1 | TP.HCM – HÀ NỘI – PHÚ THỌ – HÀ GIANG (Ăn trưa, chiều)\r\nSáng:  Quý khách có mặt tại ga quốc nội, sân bay Tân Sơn Nhất trước giờ bay ít nhất ba tiếng. \r\nĐại diện công ty Du Lịch Việt đón và hỗ trợ Quý khách làm thủ tục đón chuyến bay đi Hà Nội.\r\nĐến sân bay Nội Bài, Hướng dẫn viên đón Quý khách khởi hành đến Hà Giang.\r\nTrưa: Dừng chân, dùng cơm trưa.\r\n\r\nĐoàn tiếp tục khởi hành đến Hà Giang – nơi có những con đường đèo, cứ nối nhau quanh co uốn lượn, nơi có những con người dân tộc chân chất, mặc dù cuộc sống nghèo khổ nhưng trên môi luôn nở nụ cười.\r\nTham quan Làng văn hóa du lịch sinh thái Hạ Thành, được bao quanh bởi những thửa ruộng bậc thang xếp nối nhau. Đến với Hạ Thành là đến với những ngôi nhà sàn truyền thống nguyên sơ, đến với những câu hát lượn, hát cọi, hát then ngọt ngào, những điệu múa dân gian, múa tín ngưỡng, những lễ hội truyền thống huyền bí, tạo cho bạn một cảm giác như trở về nơi cội nguồn của dân tộc.\r\nTối:    Dùng cơm tối. Nghỉ đêm Hà Giang.', 'kinh-nghiem-du-lich-tet-nguyen-dan-gia-tot-tham-quan-thac-ban-gioc-du-lich-viet.jpg', 10999000);
INSERT INTO `tour` VALUES (4, 2, 2, 'Du lịch Hà Nội - Yên Tử - Hạ Long - Tràng An - Sapa - Fansipan từ Sài Gòn', 'Sài Gòn', 'Hà Nội - Yên Tử - Hạ Long - Tràng An - Sapa - Fansipan', '05,06,12,16,23,30/01', '1/02/2021', 'Miền Bắc là nơi khởi nguồn văn hóa ngàn năm văn hiến của dân tộc Việt Nam. Du lịch miền Bắc du khách sẽ được khám phá những thắng cảnh thiên nhiên đẹp mê hồn cùng nhiều công trình kiến trúc ấn tượng được tạo nên bởi bàn tay khéo léo của con người. Điểm du lịch Tràng An là nơi du khách sẽ được khám phá một trong những địa điểm du lịch đẹp nhất Ninh Bình. Tạo hóa đã vô cùng ưu ái ban tặng cho nơi đây một cảnh quan thiên nhiên tuyệt đẹp với các dãy núi uốn lượn bao quanh các dòng Suối nước tự nhiên, tạo nên vô vàn các hang động kỳ ảo, huyền bí.... Cùng Du Lịch Việt khám phá những địa điểm du lịch miền bắc hấp dẫn nhất như Hà Nội - Yên Tử - Hạ Long - Chùa Bái Đính - Tràng An - Sapa - Bản Cát Cát - Đỉnh Fansipan,... để bắt đầu lên kế hoạch cho chuyến du lịch ngay nhé!', 'du-lich-sapa-gia-re-du-lich-viet.jpg', 8099000);
INSERT INTO `tour` VALUES (5, 2, 2, 'Du lịch Miền Bắc - Đông Bắc - Hà Giang 5 ngày 4 đêm khởi hành từ Sài Gòn', 'Hồ Chí Minh', 'Du lịch Miền Bắc - Đông Bắc - Hà Giang', '08,15,22,29/01', '30/01', 'Tour du lịch Đông Bắc - Du Lịch Việt đưa du khách đến không gian xanh mát của núi rừng. Hành trình du lịch Đông Bắc, đưa du khách tham quan những thắng cảnh đồi núi trùng điệp hùng vĩ, hay những thác nước chảy cuồn cuộn, những cảnh thiên nhiên thơ mộng, hay sự nhộn nhịp của những con phố cổ. ', 'du-lich-he-dong-bac-ha-giang-375x259.jpg', 7099000);
INSERT INTO `tour` VALUES (6, 2, 2, 'Du lịch Hà Nội - Hạ Long - Lào Cai - Sapa 5 ngày 4 đêm khởi hành từ Sài Gòn', 'Hồ Chí Minh', 'Hà Nội - Hạ Long - Lào Cai - Sapa', '08,12,16,23,29/01/2021', '30/01/2021', 'Miền Bắc là nơi khởi nguồn văn hóa ngàn năm văn hiến của dân tộc Việt Nam. Du lịch miền Bắc du khách sẽ được khám phá những thắng cảnh thiên nhiên đẹp mê hồn cùng nhiều công trình kiến trúc ấn tượng được tạo nên bởi bàn tay khéo léo của con người. Cùng Du Lịch Việt tìm hiểu những địa điểm du lịch tâm linh ở miền bắc hấp dẫn nhất như Hà Nội - Hạ Long - Lào Cai - Sapa - Fansipan,... để bắt đầu lên kế hoạch cho chuyến du lịch ngay nhé!', 'tour-sapa-gia-tot-du-lich-viet.jpg', 6899000);
INSERT INTO `tour` VALUES (7, 2, 2, 'Du lịch Hà Nội - Mộc Châu - Sơn La - Điện Biên - Sapa - Fansipan - Phú Thọ - Đền Hùng', 'Hồ Chí Minh', 'Hà Nội - Mộc Châu - Sơn La - Điện Biên - Sapa - Fansipan - Phú Thọ - Đền Hùng', '05,08,09,12,15,16,30/01/2021', '31/01/2021', 'Du Lịch Hà Nội - Mai Châu - Mộc Châu - Sơn La - Sapa - Yên Bái - Phú Thọ từ Sài Gòn 2020 - Mai Châu là huyện cực tây của tỉnh, phía bắc giáp tỉnh Sơn La, phía nam giáp tỉnh Thanh Hóa, phía bắc giáp huyện Đà Bắc, phía đông giáp huyện Tân Lạc. Mai Châu điểm đến thích hợp vào tất cả các mùa trong năm. Cùng Du Lịch Việt tìm hiểu những địa điểm du lịch miền bắc hấp dẫn nhất như Hà Nội - Mai Châu - Mộc Châu - Sơn La - Sapa - Yên Bái - Phú Thọ,... để bắt đầu lên kế hoạch cho chuyến du lịch ngay nhé!', 'du-lich-mai-chau-gia-tot-du-lich-viet.jpg', 8099000);
INSERT INTO `tour` VALUES (8, 3, 2, 'Du Thuyền Hạ Long Golden Star Cruise 3 Sao 2 Ngày 1 Đêm', 'Hà Nội - Việt Nam', 'Quảng Ninh - Việt Nam', '2 ngày 1 đêm', '2 ngày 1 đêm', 'Giá tour bao gồm: \r\n\r\n-    Xe ôtô đời mới đi theo chương trình.\r\n\r\n-    Tàu tiêu chuẩn 2 người/ phòng.\r\n\r\n-    Ăn 3 bữa chính theo chương trình .\r\n\r\n-    Hướng dẫn viên kinh nghiệm, nhanh nhẹn, nhiệt tình phục vụ đoàn suốt tuyến. \r\n\r\n-    Vé vào cửa lần 1 các điểm thăm quan trong chương trình.\r\n\r\n-    01 chai nước/01 khách/01 ngày.\r\n\r\n-    Bảo hiểm du lịch\r\n\r\nGiá chưa bao gồm:\r\n\r\n-    Đồ uống và các chi phí cá nhân khác không được nêu ở trên\r\n\r\n-    Bồi dưỡng cho lái xe và hướng dẫn viên', 'opf1418889811_du-thuyen-5-sao-paradise-2-ngay-1-dem.jpg', 2490000);
INSERT INTO `tour` VALUES (9, 3, 2, 'Tour du lịch Hà Nội - Hạ Long Teambuilding 2 ngày 1 đêm', 'Hà Nội - Việt Nam', 'Hạ Long', 'T2, 3, 4, 5, & chủ nhật', '2 ngày 1 đêm', 'Hạ Long là một địa điểm du lịch nổi bật miền bắc. Là một điểm đến lí tưởng không thể bỏ qua với mỗi du khách trong và ngoài nước. Đến với Hạ Long du khách không những chỉ được thưởng thức cảnh đẹp nơi đây, mà còn hòa mình vào với khung cảnh thiên nhiên tuyệt đẹp vào mỗi buổi sớm mai khi bình minh thức dậy, và lúc chiều tà khi hoàng hôn khuất dần nơi góc biển.', 'Vinh-Bai-Tu-Long.jpg', 1480000);
INSERT INTO `tour` VALUES (10, 3, 2, 'Tour du lịch Hà Nội - Hạ Long - Teambuilding 3 ngày 2 đêm', 'Hà Nội', ' Hạ Long', 'Theo yêu cầu', '3 ngày 2 đêm', 'Hạ Long là một địa điểm du lịch nổi bật miền bắc. Là một điểm đến lí tưởng không thể bỏ qua với mỗi du khách trong và ngoài nước. Đến với Hạ Long du khách không những chỉ được thưởng thức cảnh đẹp nơi đây, mà còn hòa mình vào với khung cảnh thiên nhiên tuyệt đẹp vào mỗi buổi sớm mai khi bình minh thức dậy, và lúc chiều tà khi hoàng hôn khuất dần nơi góc biển.', 'e363506297f92df044b265b8e8dd30f1.jpg', 2580000);
INSERT INTO `tour` VALUES (11, 3, 2, 'Tour du lịch đảo Cô Tô 3 ngày 2 đêm về miền biển đảo yên bình', 'Hà Nội', 'Cô Tô', 'Thứ 6 hàng tuần', '3 ngày 2 đêm', 'Đảo Cô Tô – Hòn đảo xinh đẹp nằm ở phía Đông Bắc Tổ quốc, một vài năm trở lại đây có sức đặc biệt với du khách khắp nơi. Với nhiều bãi biển trong xanh cùng với sự phát triển nhiều loại hình vui chơi giải trí nơi đây phù hợp cả nghỉ dưỡng hay khám phá. \r\n\r\nKhông phải ngẫu nhiên mà Cô Tô được nhiều người ưu ái với tên gọi ‘thiên đường du lịch biển miền Bắc’. Đây là điểm đến dành cho bất cứ ai mong muốn trở về với thiên nhiên hoang sơ, bình yên, để tâm trí được vỗ về, quên hết mọi âu lo thường nhật.', '1f94b33a67774dcc8e2439f6bdc87eab.jpg', 3080000);
INSERT INTO `tour` VALUES (12, 3, 2, 'Hà Nội - Legacy Yên Tử 2 ngày 1 đêm: Nghỉ dưỡng chốn \"cung đình\" độc đáo', ' Hà Nội', 'Quảng Ninh', '12/10', '2 ngày 1 đêm', 'Yên Tử từ lâu đã được xem như điểm đến hành hương tâm linh Phật pháp của nhiều người. Chẳng vì thế mà hằng năm nếu có dịp, người ta đều tìm về với Yên Tử, một phần để thỏa mãn ước mong về nơi hồn thiêng đất nước, một phần để tìm đến cảm giác yên bình, thanh tịnh. \r\n\r\nSẽ thật thiếu sót nếu về với mảnh đất này lại không đặt chân đến Legacy Yên Tử - một khu nghỉ dưỡng nằm kề bên rừng cây xanh mát, lấy cảm hứng từ đời sống, kiến cung đình vua chúa thời Trần. Nơi đây hứa hẹn sẽ mang đến cho bất cứ tâm hồn du khách nào sự an yên, nhẹ nhõm ngay từ lần đầu tiên đặt chân vào cửa. \r\n\r\nĐiểm nổi bật trong hành trình \r\n\r\n- Chiêm ngưỡng thắng cảnh kiến trúc độc đáo của công trình nghỉ dưỡng cao cấp được thiết kế bởi nhà kiến trúc sư tài ba thế giới Bill Bensley\r\n\r\n- Tham gia các hoạt động đêm hội làng – Chợ Quê, các trò chơi dân gian như múa sạp, nhảy dây, đi cà kheo, thả đèn hoa đăng, biểu diễn nghệ thuật và các món ăn truyền thống cổ truyền....\r\n\r\n- Tham gia chương trình Yoga 50 phút tìm đến cảm giác thiền định trong tâm hồn dưới sự hướng dẫn của chuyên gia.\r\n\r\nVà các hoạt động ý nghĩa khác như \"hành trình theo dấu chân Phật Hoàng\", tìm hiểu về văn hóa, lịch sử thời kỳ nhà Trần – Vua Phật Hoàng Trần Nhân Tông thế kỷ thứ 13', 'b86849fe1e8c67d08330e5eda49e0cf7.jpg', 1280000);
INSERT INTO `tour` VALUES (13, 1, 2, 'Tour Du lịch Đà Nẵng - Hội An 4 ngày 3 đêm giá tốt khởi hành từ Hà Nội', 'Hà Nội ', 'Sơn Trà – Ngũ Hành Sơn – Bà Nà Hills  – Hội An', '18,25/4; 9,16,23,30/5', '4 ngày 3 đêm', 'Thành phố Đà Nẵng nằm ở vùng Trung Bộ của đất nước, cách Thủ đô Hà Nội 764km về phía Bắc. Nói đến Đà Nẵng là chúng ta có thể hình dung ngay rằng đó là một thành phố tuyệt đẹp bên sông Hàn, bên bờ biển Đông với những nét quyến rũ chưa từng có ở các đô thị biển khác…', '400x275(1).jpg', 3990000);
INSERT INTO `tour` VALUES (14, 1, 2, 'Du lịch Tết dương - Đà Nẵng - Sơn Trà - Bà Nà - Hội An 4 ngày từ Hà Nội', 'Hà Nội', 'Đà Nẵng', '28/12', '03/01', 'Đến Đà Nẵng, du khách sẽ được hoà mình vào làn nước mát lạnh của biển trong những ngày hè oi bức, được tham gia vào các trò chơi thể thao trên biển,… Đến Đà Nẵng để từ đó xuất phát đến những điểm tham quan du lịch nổi tiếng: Phố cổ đèn lồng Hội An, Bà Nà 4 mùa Xuân Hạ Thu Đông, viếng chùa Linh Ứng, viếng Ngũ Hành Sơn, vọng về Thành phố từ Bán đảo Sơn Trà... Ngoài ra du khách còn được thưởng thức những món ăn ngon, đặc sản mang đậm hương vị miền Trung để nhớ mãi không quên.', '400x275_hoi_an_faifo_tet2020_du_lich_viet.jpg', 2750000);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `email` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_vietnamese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'test1', '202cb962ac59075b964b07152d234b70', NULL, NULL, 'test1');
INSERT INTO `user` VALUES (2, 't2', '202cb962ac59075b964b07152d234b70', NULL, NULL, 't2');
INSERT INTO `user` VALUES (3, 'tiep2', '202cb962ac59075b964b07152d234b70', NULL, NULL, 'testemail@gmail.com');
INSERT INTO `user` VALUES (4, 'S2kael', 'f0172e1462b0e7fdf99793168e5c0a65', NULL, NULL, 'laiducminh1002@gmail.com');
INSERT INTO `user` VALUES (5, 'tuanpn', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, 'ngoctuan1102000@gmail.com');
INSERT INTO `user` VALUES (6, 'tuanpn.tb@gmail.com', 'fcea920f7412b5da7be0cf42b8c93759', NULL, NULL, 'tuanpn.tb@gmail.com');
INSERT INTO `user` VALUES (7, 'TuanPham', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, 'buivinh1325@gmail.com');

SET FOREIGN_KEY_CHECKS = 1;
