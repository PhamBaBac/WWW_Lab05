-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.35 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for works
DROP DATABASE IF EXISTS `works`;
CREATE DATABASE IF NOT EXISTS `works` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `works`;

-- Dumping structure for table works.address
DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `add_id` bigint NOT NULL AUTO_INCREMENT,
  `city` varchar(50) DEFAULT NULL,
  `country` smallint DEFAULT NULL,
  `number` varchar(20) DEFAULT NULL,
  `street` varchar(150) DEFAULT NULL,
  `zipcode` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`add_id`),
  CONSTRAINT `address_chk_1` CHECK ((`country` between 0 and 271))
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table works.address: ~1 rows (approximately)
INSERT INTO `address` (`add_id`, `city`, `country`, `number`, `street`, `zipcode`) VALUES
	(2, ' Hà Nội', 258, '456', 'Đường Đổi Mới', '100000'),
	(3, 'Thành phố Hồ Chí Minh', 258, ' 789', 'Đường Sáng Tạo', '700000');

-- Dumping structure for table works.candidate
DROP TABLE IF EXISTS `candidate`;
CREATE TABLE IF NOT EXISTS `candidate` (
  `can_id` bigint NOT NULL AUTO_INCREMENT,
  `dob` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `address` bigint NOT NULL,
  PRIMARY KEY (`can_id`),
  UNIQUE KEY `UK_qfut8ruekode092nlkipgl09g` (`email`),
  UNIQUE KEY `UK_9i5yt1gvm0chg5e10qkns7tll` (`phone`),
  UNIQUE KEY `UK_m8qhlm4wu215gr34dhxp0dour` (`address`),
  CONSTRAINT `FKa8gnyyhbb2qnhp94grci1n0o9` FOREIGN KEY (`address`) REFERENCES `address` (`add_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table works.candidate: ~0 rows (approximately)

-- Dumping structure for table works.candidate_skill
DROP TABLE IF EXISTS `candidate_skill`;
CREATE TABLE IF NOT EXISTS `candidate_skill` (
  `more_infos` varchar(1000) DEFAULT NULL,
  `skill_level` tinyint NOT NULL,
  `skill_id` bigint NOT NULL,
  `can_id` bigint NOT NULL,
  PRIMARY KEY (`can_id`,`skill_id`),
  KEY `FKb7cxhiqhcah7c20a2cdlvr1f8` (`skill_id`),
  CONSTRAINT `FKb0m5tm3fi0upa3b3kjx3vrlxs` FOREIGN KEY (`can_id`) REFERENCES `candidate` (`can_id`),
  CONSTRAINT `FKb7cxhiqhcah7c20a2cdlvr1f8` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`),
  CONSTRAINT `candidate_skill_chk_1` CHECK ((`skill_level` between 0 and 4))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table works.candidate_skill: ~0 rows (approximately)

-- Dumping structure for table works.company
DROP TABLE IF EXISTS `company`;
CREATE TABLE IF NOT EXISTS `company` (
  `com_id` bigint NOT NULL AUTO_INCREMENT,
  `about` varchar(2000) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `comp_name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `web_url` varchar(255) DEFAULT NULL,
  `address` bigint NOT NULL,
  PRIMARY KEY (`com_id`),
  UNIQUE KEY `UK_rvp2hunsq4sgmpxe3a7i1ym3m` (`address`),
  CONSTRAINT `FKd5occp4cjwihejbxdbpvkp5tv` FOREIGN KEY (`address`) REFERENCES `address` (`add_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table works.company: ~1 rows (approximately)
INSERT INTO `company` (`com_id`, `about`, `email`, `comp_name`, `phone`, `web_url`, `address`) VALUES
	(2, ' Điện Tử Việt Nam Công Nghệ Mới là một công ty hàng đầu tại Việt Nam chuyên cung cấp các giải pháp công nghệ tiên tiến và độc đáo. Chúng tôi tập trung vào phát triển phần mềm, trí tuệ nhân tạo và các dịch vụ chuyển đổi số, đem lại giải pháp tối ưu cho nhu cầu đặc biệt của khách hàng.', ' info@dientuvietnam.com', 'Điện Tử Việt Nam Công Nghệ Mới', '+84-123-456-7890', 'www.dientuvietnam.vn', 2),
	(3, 'Phát Triển Sáng Tạo Công Nghệ HCM là một doanh nghiệp hàng đầu tại Thành phố Hồ Chí Minh, chuyên cung cấp các giải pháp công nghệ đột phá và hiệu quả. Chúng tôi tập trung vào phát triển phần mềm, Internet of Things (IoT), và các dịch vụ công nghệ thông tin để đáp ứng nhu cầu đa dạng của khách hàng.', 'info@ptsctechhcm.com', ' Phát Triển Sáng Tạo Công Nghệ HCM', '+84-987-654-3210', ' www.ptsctechhcm.vn', 3);

-- Dumping structure for table works.experience
DROP TABLE IF EXISTS `experience`;
CREATE TABLE IF NOT EXISTS `experience` (
  `exp_id` bigint NOT NULL AUTO_INCREMENT,
  `company` varchar(120) NOT NULL,
  `from_date` date NOT NULL,
  `role` varchar(100) NOT NULL,
  `to_date` date NOT NULL,
  `work_desc` varchar(400) NOT NULL,
  `can_id` bigint DEFAULT NULL,
  PRIMARY KEY (`exp_id`),
  KEY `FK8d5oqe0wxh52v352i04qnuady` (`can_id`),
  CONSTRAINT `FK8d5oqe0wxh52v352i04qnuady` FOREIGN KEY (`can_id`) REFERENCES `candidate` (`can_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table works.experience: ~0 rows (approximately)

-- Dumping structure for table works.job
DROP TABLE IF EXISTS `job`;
CREATE TABLE IF NOT EXISTS `job` (
  `job_id` bigint NOT NULL AUTO_INCREMENT,
  `job_desc` varchar(2000) NOT NULL,
  `job_name` varchar(255) NOT NULL,
  `company` bigint DEFAULT NULL,
  PRIMARY KEY (`job_id`),
  KEY `FKbaqlvluu78phmo9ld89um7wnm` (`company`),
  CONSTRAINT `FKbaqlvluu78phmo9ld89um7wnm` FOREIGN KEY (`company`) REFERENCES `company` (`com_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table works.job: ~1 rows (approximately)
INSERT INTO `job` (`job_id`, `job_desc`, `job_name`, `company`) VALUES
	(1, 'We are looking for a talented Full-Stack Web Developer to join our dynamic team. As a Full-Stack Developer, you will be responsible for designing, developing, and maintaining web applications from both the frontend and backend perspectives. The ideal candidate should have a strong passion for web development, a creative mindset, and the ability to work collaboratively within a team.', 'Full-Stack Web Developer', 2),
	(2, 'We are seeking a skilled and creative Frontend Developer to join our passionate team. As a Frontend Developer, you will be responsible for translating design concepts into interactive and engaging user interfaces. The ideal candidate should have a strong eye for design, proficiency in frontend technologies, and a dedication to creating seamless and visually appealing web experiences.', 'Frontend Developer', 3);

-- Dumping structure for table works.job_skill
DROP TABLE IF EXISTS `job_skill`;
CREATE TABLE IF NOT EXISTS `job_skill` (
  `more_infos` varchar(1000) DEFAULT NULL,
  `skill_level` tinyint NOT NULL,
  `job_id` bigint NOT NULL,
  `skill_id` bigint NOT NULL,
  PRIMARY KEY (`job_id`,`skill_id`),
  KEY `FKj33qbbf3vk1lvhqpcosnh54u1` (`skill_id`),
  CONSTRAINT `FK9ix4wg520ii2gu2felxdhdup6` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`),
  CONSTRAINT `FKj33qbbf3vk1lvhqpcosnh54u1` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`),
  CONSTRAINT `job_skill_chk_1` CHECK ((`skill_level` between 0 and 4))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table works.job_skill: ~0 rows (approximately)
INSERT INTO `job_skill` (`more_infos`, `skill_level`, `job_id`, `skill_id`) VALUES
	(NULL, 1, 1, 1),
	(NULL, 2, 2, 2);

-- Dumping structure for table works.skill
DROP TABLE IF EXISTS `skill`;
CREATE TABLE IF NOT EXISTS `skill` (
  `skill_id` bigint NOT NULL AUTO_INCREMENT,
  `skill_desc` varchar(300) NOT NULL,
  `skill_name` varchar(150) NOT NULL,
  `skill_type` tinyint NOT NULL,
  PRIMARY KEY (`skill_id`),
  CONSTRAINT `skill_chk_1` CHECK ((`skill_type` between 0 and 2))
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table works.skill: ~0 rows (approximately)
INSERT INTO `skill` (`skill_id`, `skill_desc`, `skill_name`, `skill_type`) VALUES
	(1, '', 'HTML, CSS, and JavaScrip/Backend Development/Database Management/Version Control-Git/Web Security/Agile Development/Problem-Solving/Communication', 1),
	(2, 'a', 'HTML, CSS, and JavaScript/Frontend Framework/Web Performance Optimization/Version Control-Git/Responsive Design', 2);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

