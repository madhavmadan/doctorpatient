-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 16, 2019 at 07:47 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `doctorpatient`
--

-- --------------------------------------------------------

--
-- Table structure for table `prescription_details`
--

CREATE TABLE `prescription_details` (
  `id` int(11) NOT NULL,
  `prescription_date` date NOT NULL,
  `patient_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prescription_details`
--

INSERT INTO `prescription_details` (`id`, `prescription_date`, `patient_id`) VALUES
(6, '2019-02-14', 6),
(7, '2019-02-14', 7),
(8, '2019-02-14', 8),
(9, '2019-02-14', 9),
(10, '2019-02-14', 10),
(11, '2019-02-14', 11),
(12, '2019-02-14', 12),
(13, '2019-02-14', 13),
(14, '2019-02-14', 14),
(15, '2019-02-14', 15),
(16, '2019-02-14', 16),
(17, '2019-02-14', 17),
(18, '2019-02-14', 18),
(19, '2019-02-14', 19),
(20, '2019-02-14', 20);

-- --------------------------------------------------------

--
-- Table structure for table `prescription_master`
--

CREATE TABLE `prescription_master` (
  `patient_id` int(11) NOT NULL,
  `patient_name` varchar(85) NOT NULL,
  `patient_contact` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prescription_master`
--

INSERT INTO `prescription_master` (`patient_id`, `patient_name`, `patient_contact`) VALUES
(6, 'Amit', 9856237411),
(7, 'Bobby', 9856237412),
(8, 'Danish', 9856237413),
(9, 'Fameer', 9856237414),
(10, 'Gagan', 9856237415),
(11, 'Harsh', 9856237416),
(12, 'Ishita', 9856237417),
(13, 'Jaggu', 9856237418),
(14, 'Karen', 9856237419),
(15, 'Laksh', 9856237410),
(16, 'Montu', 9764318521),
(17, 'Naman', 9764318522),
(18, 'Paresh', 9764318523),
(19, 'Rohit', 9764318524),
(20, 'Sarita', 9764318525);

-- --------------------------------------------------------

--
-- Table structure for table `response_details`
--

CREATE TABLE `response_details` (
  `id` int(11) NOT NULL,
  `response_id` int(11) NOT NULL,
  `response_text` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `response_details`
--

INSERT INTO `response_details` (`id`, `response_id`, `response_text`) VALUES
(3, 3, 'Ok3'),
(4, 4, 'Ok4'),
(5, 5, 'Ok5'),
(6, 6, 'Ok6'),
(7, 7, 'Ok7'),
(8, 8, 'Ok8'),
(9, 9, 'Ok9'),
(10, 10, 'Ok10'),
(11, 11, 'Ok11'),
(12, 12, 'Ok12'),
(13, 13, 'Ok13'),
(14, 14, 'Ok14'),
(15, 15, 'Ok15'),
(16, 16, 'Ok16');

-- --------------------------------------------------------

--
-- Table structure for table `response_master`
--

CREATE TABLE `response_master` (
  `response_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `created_on` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `response_master`
--

INSERT INTO `response_master` (`response_id`, `patient_id`, `created_on`) VALUES
(3, 6, '2019-02-14'),
(4, 7, '2019-02-14'),
(5, 8, '2019-02-14'),
(6, 9, '2019-02-14'),
(7, 10, '2019-02-14'),
(8, 11, '2019-02-14'),
(9, 12, '2019-02-14'),
(10, 13, '2019-02-14'),
(11, 14, '2019-02-14'),
(12, 15, '2019-02-14'),
(13, 16, '2019-02-14'),
(14, 17, '2019-02-14'),
(15, 18, '2019-02-14'),
(16, 19, '2019-02-14'),
(17, 20, '2019-02-14');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `prescription_details`
--
ALTER TABLE `prescription_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk` (`patient_id`);

--
-- Indexes for table `prescription_master`
--
ALTER TABLE `prescription_master`
  ADD PRIMARY KEY (`patient_id`);

--
-- Indexes for table `response_details`
--
ALTER TABLE `response_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk5` (`response_id`);

--
-- Indexes for table `response_master`
--
ALTER TABLE `response_master`
  ADD PRIMARY KEY (`response_id`),
  ADD KEY `fk3` (`patient_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `prescription_details`
--
ALTER TABLE `prescription_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `prescription_master`
--
ALTER TABLE `prescription_master`
  MODIFY `patient_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `response_details`
--
ALTER TABLE `response_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `response_master`
--
ALTER TABLE `response_master`
  MODIFY `response_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `prescription_details`
--
ALTER TABLE `prescription_details`
  ADD CONSTRAINT `fk` FOREIGN KEY (`patient_id`) REFERENCES `prescription_master` (`patient_id`);

--
-- Constraints for table `response_details`
--
ALTER TABLE `response_details`
  ADD CONSTRAINT `fk5` FOREIGN KEY (`response_id`) REFERENCES `response_master` (`response_id`);

--
-- Constraints for table `response_master`
--
ALTER TABLE `response_master`
  ADD CONSTRAINT `fk3` FOREIGN KEY (`patient_id`) REFERENCES `prescription_master` (`patient_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
