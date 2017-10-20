-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 20, 2017 at 09:37 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `quanlitv`
--

-- --------------------------------------------------------

--
-- Table structure for table `bangmuontra`
--

CREATE TABLE IF NOT EXISTS `bangmuontra` (
`maphieumuon` int(11) NOT NULL,
  `madocgia` int(11) NOT NULL,
  `soluongmuon` int(11) NOT NULL,
  `soluongTra` int(11) NOT NULL,
  `ngaymuon` date NOT NULL,
  `ngayhentra` date NOT NULL,
  `tiencoc` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `bangmuontra`
--

INSERT INTO `bangmuontra` (`maphieumuon`, `madocgia`, `soluongmuon`, `soluongTra`, `ngaymuon`, `ngayhentra`, `tiencoc`) VALUES
(1, 1, 2, 2, '2017-08-22', '2017-09-05', 100000),
(2, 2, 2, 1, '2017-09-07', '2017-09-21', 50000),
(3, 3, 3, 3, '2017-09-07', '2017-09-21', 100000),
(4, 4, 3, 3, '2017-08-22', '2017-09-05', 100000),
(5, 5, 3, 2, '2017-09-07', '2017-09-21', 100000),
(6, 7, 5, 0, '2017-09-08', '2017-09-22', 150000),
(7, 1, 5, 6, '2017-09-08', '2017-09-22', 200000),
(8, 3, 5, 0, '2017-09-08', '2017-09-22', 150000),
(9, 11, 2, 2, '2017-09-11', '2017-09-25', 100000),
(10, 8, 3, 0, '2017-09-18', '2017-10-02', 150000),
(11, 12, 2, 0, '2017-10-11', '2017-10-25', 100000);

-- --------------------------------------------------------

--
-- Table structure for table `bangmuontra_chitiet`
--

CREATE TABLE IF NOT EXISTS `bangmuontra_chitiet` (
  `maphieumuon` int(11) NOT NULL,
  `masach` int(11) NOT NULL,
  `ngaytra` date NOT NULL,
  `tinhtrang` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `bangmuontra_chitiet`
--

INSERT INTO `bangmuontra_chitiet` (`maphieumuon`, `masach`, `ngaytra`, `tinhtrang`) VALUES
(1, 1, '2017-09-07', 'Đã trả'),
(1, 2, '2017-09-07', 'Đã trả'),
(2, 3, '2017-09-07', 'Đã trả'),
(2, 4, '2017-09-21', 'Mất sách'),
(3, 3, '2017-09-07', 'Đã trả'),
(3, 4, '2017-09-07', 'Đã trả'),
(3, 5, '2017-09-21', 'Mất sách'),
(3, 6, '2017-09-21', 'Mất sách'),
(3, 7, '2017-09-07', 'Đã trả'),
(4, 8, '2017-09-18', 'Đã trả'),
(4, 9, '2017-09-18', 'Đã trả'),
(4, 10, '2017-09-18', 'Đã trả'),
(5, 11, '2017-09-08', 'Đã trả'),
(5, 12, '2017-09-21', 'Mất sách'),
(5, 13, '2017-09-08', 'Đã trả'),
(6, 1, '2017-09-22', 'Đang mượn'),
(6, 2, '2017-09-22', 'Đang mượn'),
(6, 3, '2017-09-22', 'Đang mượn'),
(6, 5, '2017-09-22', 'Đang mượn'),
(6, 6, '2017-09-22', 'Đang mượn'),
(7, 1, '2017-09-18', 'Đã trả'),
(7, 2, '2017-09-18', 'Đã trả'),
(7, 3, '2017-09-18', 'Đã trả'),
(7, 4, '2017-09-18', 'Đã trả'),
(7, 5, '2017-09-18', 'Đã trả'),
(7, 6, '2017-09-18', 'Đã trả'),
(8, 5, '2017-09-22', 'Đang mượn'),
(8, 7, '2017-09-22', 'Đang mượn'),
(8, 8, '2017-09-22', 'Đang mượn'),
(8, 9, '2017-09-22', 'Đang mượn'),
(8, 10, '2017-09-22', 'Đang mượn'),
(9, 1, '2017-09-11', 'Đã trả'),
(9, 2, '2017-09-11', 'Đã trả'),
(10, 1, '2017-10-02', 'Đang mượn'),
(10, 2, '2017-10-02', 'Đang mượn'),
(10, 3, '2017-10-02', 'Đang mượn'),
(11, 1, '2017-10-25', 'Đang mượn'),
(11, 11, '2017-10-25', 'Đang mượn');

-- --------------------------------------------------------

--
-- Table structure for table `bangphat`
--

CREATE TABLE IF NOT EXISTS `bangphat` (
  `maphieumuon` int(11) NOT NULL,
  `masach` int(11) NOT NULL,
  `songaytre` int(11) NOT NULL,
  `lydophat` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sotienphat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `bangphat`
--

INSERT INTO `bangphat` (`maphieumuon`, `masach`, `songaytre`, `lydophat`, `sotienphat`) VALUES
(1, 1, 2, 'Trả muộn', 10000),
(1, 2, 2, 'Trả muộn', 10000),
(2, 4, 0, 'Mất sách+', 60000),
(3, 5, 0, 'Mất sách+', 200000),
(3, 6, 0, 'Mất sách+', 70000),
(5, 12, 0, 'Mất sách+', 50000),
(4, 8, 13, 'Trả muộn', 65000),
(4, 9, 13, 'Trả muộn', 65000),
(4, 10, 13, 'Trả muộn', 65000);

-- --------------------------------------------------------

--
-- Table structure for table `docgia`
--

CREATE TABLE IF NOT EXISTS `docgia` (
`madocgia` int(11) NOT NULL,
  `tendocgia` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `namsinh` date NOT NULL,
  `diachi` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sodienthoai` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cmt` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hanthe` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `docgia`
--

INSERT INTO `docgia` (`madocgia`, `tendocgia`, `namsinh`, `diachi`, `sodienthoai`, `cmt`, `hanthe`) VALUES
(1, 'Nguyễn Viết Hoàng', '1997-08-21', 'Đan Phượng-Hà Nội', '8473625463', '968574635', '2018-08-24'),
(2, 'Nguyễn Hà An', '1999-08-08', 'Tây Mỗ-Hà Nội', '5647364537', '756453625', '2018-08-24'),
(3, 'Đỗ Ngọc Lan', '1994-10-07', 'Tây Mỗ-Hà Nội', '7685647364', '564753625', '2018-08-24'),
(4, 'Vũ Mai Hương', '1996-10-26', 'Đan Phượng-Hà Nội', '4635274635', '746453627', '2018-08-24'),
(5, 'Vũ Mai Lan', '1995-10-15', 'Đan Phượng-Hà Nội', '65746354657', '746453756', '2018-08-24'),
(6, 'Đoàn Ngọc Linh', '1997-10-16', 'Đan Phượng-Hà Nội', '4657463546', '54653645', '2018-08-15'),
(7, 'Phạm Thành Chung', '1994-06-12', 'Đan Phượng - Hà Nội', '0981991478', '986754673', '2019-08-31'),
(8, 'Đỗ Văn Cường', '1993-07-19', 'Đan Phượng - Hà Nội', '0911261636', '937453728', '2019-08-31'),
(9, 'Hà Văn Đạt', '1991-08-24', 'Đan Phượng - Hà Nội', '0919369159', '937434728', '2019-08-31'),
(10, 'Chu Thị Nguyệt Hương', '1987-09-14', 'Đan Phượng - Hà Nội', '0985876146', '847364537', '2019-08-31'),
(11, 'Đỗ Thị Diễm', '1994-09-09', 'Đan Phượng - Hà Nội', '01629854226', '847397463', '2019-08-31'),
(12, 'Nguyễn Thị Lan', '1992-09-14', 'Đan Phượng - Hà Nội', '01669499967', '102039484', '2019-08-31'),
(13, 'Trần Thị Phương', '1993-11-06', 'Đan Phượng - Hà Nội', '01649729075', '193874893', '2019-08-31'),
(14, 'Hoàng Phương Thảo', '1992-06-30', 'Đan Phượng - Hà Nội', '01642316538', '938782920', '2019-08-31'),
(15, 'Phạm Văn Biển', '1994-06-12', 'Đan Phượng - Hà Nội', '1689993791', '967591165', '2019-09-06'),
(16, 'Đặng Đình Cảnh', '1993-07-19', 'Đan Phượng - Hà Nội', '904878187', '989532180', '2019-09-06'),
(17, 'Lưu Minh Châu', '1991-08-24', 'Đan Phượng - Hà Nội', '1649655689', '981370993', '2019-09-06'),
(18, 'Nguyễn Xuân Đạo', '1994-09-09', 'Đan Phượng - Hà Nội', '1255609255', '1675050891', '2019-09-06'),
(19, 'Trần Mạnh Đạt', '1992-09-14', 'Đan Phượng - Hà Nội', '1244889689', '1696878850', '2019-09-06'),
(20, 'Nguyễn Tiến Đạt', '1993-11-06', 'Đan Phượng - Hà Nội', '934669386', '979148265', '2019-09-06'),
(21, 'Nguyễn Như Điệp', '1992-06-30', 'Đan Phượng - Hà Nội', '964042051', '968096123', '2019-09-06'),
(22, 'Nguyễn Văn Hanh', '1994-06-12', 'Đan Phượng - Hà Nội', '988074493', '1672881976', '2019-09-06'),
(23, 'Nguyễn Trung Hiếu', '1993-07-19', 'Đan Phượng - Hà Nội', '1687295016', '1655994323', '2019-09-06'),
(24, 'Đỗ Văn Hoàng', '1991-08-24', 'Đan Phượng - Hà Nội', '982465148', '982205856', '2019-09-06'),
(25, 'Nguyễn Hữu Hưng', '1994-09-09', 'Đan Phượng - Hà Nội', '967211692', '941408663', '2019-09-06'),
(26, 'Phạm Gia Khánh', '1992-09-14', 'Đan Phượng - Hà Nội', '966397361', '1699364345', '2019-09-06'),
(27, 'Bùi Đăng Khoa', '1993-11-06', 'Đan Phượng - Hà Nội', '1644128220', '2457320027', '2019-09-06'),
(28, 'Trần Trung Kiên', '1994-06-12', 'Đan Phượng - Hà Nội', '968343426', '3215275709', '2019-09-06'),
(29, 'Nguyễn Hồng Lân', '1993-07-19', 'Đan Phượng - Hà Nội', '1689917805', '3973231391', '2019-09-06'),
(30, 'Lê Thanh Loan', '1991-08-24', 'Đan Phượng - Hà Nội', '982539382', '4731187073', '2019-09-06'),
(31, 'Nguyễn Văn Lợi', '1987-09-14', 'Đan Phượng - Hà Nội', '912217468', '5489142755', '2019-09-06'),
(32, 'Phạm Thế Long', '1994-09-09', 'Đan Phượng - Hà Nội', '585948573', '6247098437', '2019-09-06');

-- --------------------------------------------------------

--
-- Table structure for table `ngonngu`
--

CREATE TABLE IF NOT EXISTS `ngonngu` (
  `ngonngu` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `ngonngu`
--

INSERT INTO `ngonngu` (`ngonngu`) VALUES
('Tiếng Anh'),
('Tiếng Nhật'),
('Tiếng Pháp'),
('Tiếng Trung'),
('Tiếng Việt');

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE IF NOT EXISTS `sach` (
`masach` int(11) NOT NULL,
  `tensach` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tacgia` varchar(100) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `nhaxuatban` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ngonngu` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `theloaisach` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaynhap` date NOT NULL,
  `sotrang` int(11) NOT NULL,
  `giatien` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `soluongCON` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`masach`, `tensach`, `tacgia`, `nhaxuatban`, `ngonngu`, `theloaisach`, `ngaynhap`, `sotrang`, `giatien`, `soluong`, `soluongCON`) VALUES
(1, 'Chuyên đề Hóa học THPT - Đại cương về kim loại', 'Nguyễn Thị Ngà', 'NXB Hà Nội', 'Tiếng Việt', 'Hóa Học', '2017-08-23', 150, 60000, 10, 7),
(2, 'Giải toán 12: Hàm số mũ Logarit và số phức', 'TRẦN ĐỨC HUYÊN', 'NXB Hà Nội', 'Tiếng Việt', 'Toán Học', '2017-08-23', 100, 50000, 10, 8),
(3, 'Giải Toán 12: Khảo sát hàm số (chuyên)     ', 'TRẦN ĐỨC HUYÊN', 'NXB Hà Nội', 'Tiếng Việt', 'Toán Học', '2017-08-23', 100, 50000, 10, 8),
(4, 'Tài liệu chuyên tiếng Anh 10', 'Hoàng Thị Xuân Hoa', 'NXB Sư Phạm', 'Tiếng Anh', 'Ngoại Ngữ', '2017-08-23', 120, 30000, 9, 8),
(5, 'Tự luyện Olympic Tiếng Anh 10 - T1', 'Đặng Hiệp Giang', 'NXB Ngoại Ngữ', 'Tiếng Anh', 'Ngoại Ngữ', '2017-08-23', 200, 100000, 9, 6),
(6, 'Bài tập Sinh lí học động vật', 'Nguyễn Quang Vinh', 'NXB Hà Nội', 'Tiếng Việt', 'Sinh Học', '2017-08-24', 80, 35000, 9, 7),
(7, 'Các dạng bài tập Hóa học THPT', 'Trần Ngọc Huy', 'NXB Hà Nội', 'Tiếng Việt', 'Hóa Học', '2017-08-23', 120, 60000, 10, 9),
(8, 'Sinh học THPT - Di truyền và tiến hóa', 'Phạm Văn Ty', 'NXB Hà Nội', 'Tiếng Việt', 'Sinh Học', '2017-08-24', 160, 45000, 10, 9),
(9, 'Giải toán 12: Hàm số mũ Logarit và số phức (chuyên)', 'TRẦN ĐỨC HUYÊN', 'NXB Hà Nội', 'Tiếng Việt', 'Toán học', '2017-09-04', 150, 26500, 10, 9),
(10, 'Giải Toán 12: Khảo sát hàm số (chuyên)                                                              ', 'TRẦN ĐỨC HUYÊN', 'NXB Hà Nội', 'Tiếng Việt', 'Toán học', '2017-09-04', 150, 37000, 10, 9),
(11, 'Giải Toán 12: Khối đa diện và khối tròn xoay (chuyên)', 'TRẦN ĐỨC HUYÊN', 'NXB Hà Nội', 'Tiếng Việt', 'Toán học', '2017-09-04', 150, 21500, 10, 9),
(12, 'Giải Toán 12: Phương pháp tọa độ trong không gian (chuyên)', 'TRẦN ĐỨC HUYÊN', 'NXB Hà Nội', 'Tiếng Việt', 'Toán học', '2017-09-04', 150, 25000, 9, 8),
(13, 'Giải Toán 12: Tích phân, nguyên hàm (chuyên)', 'TRẦN ĐỨC HUYÊN', 'NXB Hà Nội', 'Tiếng Việt', 'Toán học', '2017-09-04', 150, 25000, 10, 10),
(14, 'Giải toán Đại số 10 (chuyên)', 'Đào Tam', 'NXB Hà Nội', 'Tiếng Việt', 'Toán học', '2017-09-04', 150, 37000, 10, 10),
(15, 'Giải toán Đại số và Lượng giác 11 (chuyên)', 'VÕ ANH DŨNG', 'NXB Hà Nội', 'Tiếng Việt', 'Toán học', '2017-09-04', 150, 33000, 10, 10),
(16, 'Giải toán Giải tích 11 (chuyên)', 'Võ Anh Dũng', 'NXB Hà Nội', 'Tiếng Việt', 'Toán học', '2017-09-04', 150, 43000, 10, 10),
(17, 'Giải toán Hình học 10 (Chuyên)', 'Vũ Anh Dũng', 'NXB Hà Nội', 'Tiếng Việt', 'Toán học', '2017-09-04', 150, 32000, 10, 10),
(18, 'Giải toán Hình học 11 (chuyên)', 'Võ Anh Dũng', 'NXB Hà Nội', 'Tiếng Việt', 'Toán học', '2017-09-04', 150, 35000, 10, 10),
(19, 'Giải toán Hoá học 10 (lớp chuyên và HS giỏi)', 'Ngô Ngọc An', 'NXB Hà Nội', 'Tiếng Việt', 'Toán học', '2017-09-04', 150, 33000, 10, 10),
(20, 'Giải toán Lượng giác 10 (chuyên)', 'Vũ Anh Dũng', 'NXB Sư Phạm', 'Tiếng Việt', 'Toán học', '2017-09-04', 150, 25000, 10, 10),
(21, 'Giải toán và trắc nghiệm Vật lí 10 (Ban KHTN) - T1: Cơ học', 'Bùi Quang Hân - Duy Hiền', 'NXB Sư Phạm', 'Tiếng Việt', 'Vật lý', '2017-09-04', 150, 41000, 10, 10),
(22, 'Giải toán và trắc nghiệm Vật lí 10 (Ban KHTN) - T2: Nhiệt học', 'Bùi Quang Hân - Duy Hiền', 'NXB Sư Phạm', 'Tiếng Việt', 'Vật lý', '2017-09-04', 130, 32000, 10, 10),
(23, 'Tài liệu chuyên Hóa học 11-12 - T2: Hóa học vô cơ', 'Nguyễn Duy Aí', 'NXB Sư Phạm', 'Tiếng Việt', 'Hóa học', '2016-09-20', 130, 44000, 10, 10),
(24, 'Tài liệu chuyên Sinh học THPT - Bài tập Sinh học tế bào', 'Nguyễn Như Hiền', 'NXB Sư Phạm', 'Tiếng Việt', 'Hóa học', '2016-09-20', 130, 27000, 10, 10),
(25, 'Bài tập Hóa học 10', 'Phạm Sỹ Lựu', 'NXB Sư Phạm', 'Tiếng Việt', 'Hóa học', '2016-09-20', 130, 22000, 10, 10),
(26, 'Bài tập Hóa học 10 nâng cao', 'Phạm Sỹ Lựu', 'NXB Sư Phạm', 'Tiếng Việt', 'Hóa học', '2016-09-20', 130, 29000, 10, 10),
(27, 'Bài tập nâng cao và một số chuyên đề Đại số 10', 'Nguyễn Huy Đoan', 'NXB Sư Phạm', 'Tiếng Việt', 'Hóa học', '2016-09-20', 130, 45000, 10, 10),
(28, 'Bài tập trắc nghiệm Hóa 10', 'Đặng Thị Oanh', 'NXB Sư Phạm', 'Tiếng Việt', 'Hóa học', '2016-09-20', 130, 22500, 10, 10),
(29, 'Bài tập trắc nghiệm và các đề kiểm tra Hình học 10', 'Văn Như Cương', 'NXB Sư Phạm', 'Tiếng Việt', 'Toán học', '2016-09-20', 130, 23500, 10, 10),
(30, 'Bài tập Vật lí 10', 'Nguyễn Bảo Hoàng Thanh', 'NXB Sư Phạm', 'Tiếng Việt', 'Toán học', '2016-09-20', 130, 31000, 10, 10),
(31, 'Bài tập Vật lí 10 nâng cao', 'Nguyễn Bảo Hoàng Thanh', 'NXB Sư Phạm', 'Tiếng Việt', 'Toán học', '2016-09-20', 100, 34000, 10, 10),
(32, 'Các dạng toán và phương pháp giải Hóa học 10', 'Lê Thanh Xuân', 'NXB Sư Phạm', 'Tiếng Việt', 'Toán học', '2016-09-20', 100, 36000, 10, 10),
(33, 'Các dạng Toán và phương pháp Hình học 10', 'Nguyễn Văn Vui', 'NXB Sư Phạm', 'Tiếng Việt', 'Toán học', '2016-09-20', 100, 31000, 10, 10),
(34, 'Các dạng toán và PP giải Đại số 10', 'Nguyễn Văn Hà', 'NXB Sư Phạm', 'Tiếng Việt', 'Toán học', '2016-09-20', 100, 34000, 10, 10),
(35, 'Các dạng toán và PP giải Đại số 10', 'Nguyễn Hữu Ngọc', 'NXB Giáo Dục', 'Tiếng Việt', 'Toán học', '2016-09-20', 100, 34000, 10, 10),
(36, 'Các phương pháp cơ bản giải bài tập Hóa học THPT', 'Phạm Đình Hiển', 'NXB Giáo Dục', 'Tiếng Việt', 'Hóa học', '2016-09-20', 100, 32000, 10, 10),
(37, 'Cẩm nang Hóa học 10', 'Nguyễn Văn Lễ', 'NXB Giáo Dục', 'Tiếng Việt', 'Hóa học', '2016-09-20', 100, 16000, 10, 10),
(38, 'Bài tập Địa lí 10', 'Nguyễn Đức Vũ', 'NXB Giáo Dục', 'Tiếng Việt', 'Địa lý', '2016-09-20', 100, 25000, 10, 10),
(39, 'Bài tập Địa lí 10', 'Nguyễn Đức Vũ', 'NXB Giáo Dục', 'Tiếng Việt', 'Địa lý', '2016-09-20', 100, 20000, 10, 10),
(40, 'Bài tập Địa lí 10 nâng cao', 'Nguyễn Đức Vũ', 'NXB Giáo Dục', 'Tiếng Việt', 'Địa lý', '2016-09-20', 100, 32000, 10, 10),
(41, 'Bài tập Lịch sử 10', 'Đinh Ngọc Bảo', 'NXB Giáo Dục', 'Tiếng Việt', 'Lịch sử', '2016-09-20', 100, 24000, 10, 10),
(42, 'Bài tập Lịch sử 10', 'Đinh Ngọc Bảo', 'NXB Giáo Dục', 'Tiếng Việt', 'Lịch sử', '2016-09-20', 100, 17500, 10, 10),
(43, 'Bài tập Lịch sử 10 nâng cao', 'Lê Văn Anh', 'NXB Giáo Dục', 'Tiếng Việt', 'Lịch sử', '2016-09-20', 100, 25000, 10, 10),
(44, 'Bài tập Ngữ văn 10 - T1', 'Nguyễn Minh Hùng', 'NXB Giáo Dục', 'Tiếng Việt', 'Ngữ văn', '2016-09-20', 100, 22000, 10, 10),
(45, 'Bài tập Ngữ văn 10 - T2', 'Nguyễn Minh Hùng', 'NXB Giáo Dục', 'Tiếng Việt', 'Ngữ văn', '2016-09-20', 100, 24000, 10, 10),
(46, 'Bài tập Ngữ văn 10 nâng cao - T1', 'Huỳnh Văn Hoa', 'NXB Giáo Dục', 'Tiếng Việt', 'Ngữ văn', '2016-09-20', 100, 28000, 10, 10),
(47, 'Bài tập Ngữ văn 10 nâng cao - T2', 'Nguyễn Minh Hùng', 'NXB Giáo Dục', 'Tiếng Việt', 'Ngữ văn', '2016-09-20', 100, 25000, 10, 10);

-- --------------------------------------------------------

--
-- Table structure for table `theloaisach`
--

CREATE TABLE IF NOT EXISTS `theloaisach` (
  `theloaisach` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `theloaisach`
--

INSERT INTO `theloaisach` (`theloaisach`) VALUES
('Âm nhạc'),
('Địa Lý'),
('Hóa Học'),
('Lịch Sử'),
('Ngoại Ngữ'),
('Pháp Luật'),
('Sinh Học'),
('Toán Học'),
('Văn Học'),
('Vật Lý');

-- --------------------------------------------------------

--
-- Table structure for table `thongtintaikhoan`
--

CREATE TABLE IF NOT EXISTS `thongtintaikhoan` (
  `TaiKhoan` varchar(30) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MatKhau` varchar(30) COLLATE utf8mb4_vietnamese_ci NOT NULL,
`manhanvien` int(11) NOT NULL,
  `tendaydu` varchar(30) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `chucvu` varchar(15) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `thongtintaikhoan`
--

INSERT INTO `thongtintaikhoan` (`TaiKhoan`, `MatKhau`, `manhanvien`, `tendaydu`, `chucvu`) VALUES
('admin', 'admin123', 1, 'Nguyễn Thị Huyền Trang', 'Quản lý'),
('hung2202', 'viethung', 2, 'Nguyễn Viết Hưng', 'Nhân viên'),
('toan0903', 'vantoan', 3, 'Nguyễn Văn Toàn', 'Nhân viên'),
('hanh2209', 'honghanh', 4, 'Nguyễn Hồng Hạnh', 'Nhân viên');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bangmuontra`
--
ALTER TABLE `bangmuontra`
 ADD PRIMARY KEY (`maphieumuon`), ADD KEY `madocgia_fk` (`madocgia`);

--
-- Indexes for table `bangmuontra_chitiet`
--
ALTER TABLE `bangmuontra_chitiet`
 ADD KEY `masach_fk` (`masach`), ADD KEY `maphieumuon_fk` (`maphieumuon`);

--
-- Indexes for table `bangphat`
--
ALTER TABLE `bangphat`
 ADD KEY `masach_fk_phat` (`masach`), ADD KEY `maphieumuon_fk_phat` (`maphieumuon`);

--
-- Indexes for table `docgia`
--
ALTER TABLE `docgia`
 ADD PRIMARY KEY (`madocgia`);

--
-- Indexes for table `ngonngu`
--
ALTER TABLE `ngonngu`
 ADD PRIMARY KEY (`ngonngu`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
 ADD PRIMARY KEY (`masach`), ADD KEY `theloaisach_fk` (`theloaisach`), ADD KEY `ngonngu` (`ngonngu`);

--
-- Indexes for table `theloaisach`
--
ALTER TABLE `theloaisach`
 ADD PRIMARY KEY (`theloaisach`);

--
-- Indexes for table `thongtintaikhoan`
--
ALTER TABLE `thongtintaikhoan`
 ADD PRIMARY KEY (`manhanvien`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bangmuontra`
--
ALTER TABLE `bangmuontra`
MODIFY `maphieumuon` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `docgia`
--
ALTER TABLE `docgia`
MODIFY `madocgia` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `sach`
--
ALTER TABLE `sach`
MODIFY `masach` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=48;
--
-- AUTO_INCREMENT for table `thongtintaikhoan`
--
ALTER TABLE `thongtintaikhoan`
MODIFY `manhanvien` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `bangmuontra`
--
ALTER TABLE `bangmuontra`
ADD CONSTRAINT `madocgia_fk` FOREIGN KEY (`madocgia`) REFERENCES `docgia` (`madocgia`);

--
-- Constraints for table `bangmuontra_chitiet`
--
ALTER TABLE `bangmuontra_chitiet`
ADD CONSTRAINT `maphieumuon_fk` FOREIGN KEY (`maphieumuon`) REFERENCES `bangmuontra` (`maphieumuon`),
ADD CONSTRAINT `masach_fk` FOREIGN KEY (`masach`) REFERENCES `sach` (`masach`);

--
-- Constraints for table `bangphat`
--
ALTER TABLE `bangphat`
ADD CONSTRAINT `maphieumuon_fk_phat` FOREIGN KEY (`maphieumuon`) REFERENCES `bangmuontra` (`maphieumuon`),
ADD CONSTRAINT `masach_fk_phat` FOREIGN KEY (`masach`) REFERENCES `sach` (`masach`);

--
-- Constraints for table `sach`
--
ALTER TABLE `sach`
ADD CONSTRAINT `sach_ibfk_1` FOREIGN KEY (`ngonngu`) REFERENCES `ngonngu` (`NgonNgu`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
