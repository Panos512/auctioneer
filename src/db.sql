# CREATE DATABASE auctioneer;
USE auctioneer;
-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Generation Time: Jul 25, 2016 at 07:26 PM
-- Server version: 5.5.42
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `auctioneer`
--

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `UserID` int(11) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `FirstName` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `BuyerRating` double not null,
  `SellerRating` double not null,
  `Address` varchar(200) NOT NULL,
  `Latitude` double(10,6) NOT NULL,
  `Longitude` double(10,6) NOT NULL,
  `Afm` varchar(255) NOT NULL,
  `Phone` varchar(255) NOT NULL,
  `Role` varchar(10) NOT NULL,
  `Gender` varchar(10),
  `Verified` BOOLEAN NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`UserID`, `LastName`, `FirstName`, `Password`, `Username`, `Email`, `Address`, `Latitude`, `Longitude`, `Afm`, `Phone`, `Role`, `Gender`, `Verified`, `BuyerRating`, `SellerRating`) VALUES
  (25, 'Paparigopoulos', 'Lemonemboras', '123456', 'cocoblocos', 'jimseinta@gmail.com', 'praxitelous', 37.434003, 25.274956, '23242343423', '6987122499', 'admin', 'male', TRUE, 0.0, 0.0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`UserID`),
  ADD UNIQUE KEY `UserID` (`UserID`),
  ADD UNIQUE KEY `Username` (`Username`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `Afm` (`Afm`),
  ADD UNIQUE KEY `Phone` (`Phone`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=27;




  -- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Generation Time: Jul 31, 2016 at 06:24 PM
-- Server version: 5.5.42
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `auctioneer`
--

-- --------------------------------------------------------

--
-- Table structure for table `Bids`
--

CREATE TABLE `Bids` (
  `BidId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `ItemId` int(11) NOT NULL,
  `Bid_Date` date NOT NULL,
  `OfferPrice` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Category`
--

CREATE TABLE `Category` (
  `CategoryId` int(11) NOT NULL,
  `CategoryName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Item`
--

CREATE TABLE `Item` (
  `ItemId` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Currently` decimal(10,2) NOT NULL,
  `Buy_Price` decimal(10,2) DEFAULT NULL,
  `First_Bid` decimal(10,2) NOT NULL,
  `Number_Of_Bids` int(11) DEFAULT '0',
  `Latitude` double(10,6) NOT NULL,
  `Longitude` double(10,6) NOT NULL,
  `Country` varchar(255) DEFAULT NULL,
  `CreatedDate` date NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `Description` text,
  `SellerId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ItemCategory`
--

CREATE TABLE `ItemCategory` (
  `ItemCategoryId` int(11) NOT NULL,
  `ItemId` int(11) NOT NULL,
  `CategoryId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `UserID` int(11) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `FirstName` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `Latitude` double(10,6) NOT NULL,
  `Longitude` double(10,6) NOT NULL,
  `Afm` varchar(255) NOT NULL,
  `Phone` varchar(255) NOT NULL,
  `Role` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`UserID`, `LastName`, `FirstName`, `Password`, `Username`, `Email`, `Address`, `Latitude`, `Longitude`, `Afm`, `Phone`, `Role`) VALUES
(25, 'Paparigopoulos', 'Lemonemboras', '123456', 'cocoblocos', 'jimseinta@gmail.com', 'praxitelous', 37.434003, 25.274956, '23242343423', '6987122499', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Bids`
--
ALTER TABLE `Bids`
  ADD PRIMARY KEY (`BidId`),
  ADD KEY `UserId` (`UserId`),
  ADD KEY `ItemId` (`ItemId`);

--
-- Indexes for table `Category`
--
ALTER TABLE `Category`
  ADD PRIMARY KEY (`CategoryId`);

--
-- Indexes for table `Item`
--
ALTER TABLE `Item`
  ADD PRIMARY KEY (`ItemId`),
  ADD KEY `SellerId` (`SellerId`);

--
-- Indexes for table `ItemCategory`
--
ALTER TABLE `ItemCategory`
  ADD PRIMARY KEY (`ItemCategoryId`),
  ADD KEY `ItemId` (`ItemId`),
  ADD KEY `CategoryId` (`CategoryId`);



--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Bids`
--
ALTER TABLE `Bids`
  MODIFY `BidId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Category`
--
ALTER TABLE `Category`
  MODIFY `CategoryId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ItemCategory`
--
ALTER TABLE `ItemCategory`
  MODIFY `ItemCategoryId` int(11) NOT NULL AUTO_INCREMENT;
--


--
-- Constraints for dumped tables
--

--
-- Constraints for table `Bids`
--
ALTER TABLE `Bids`
  ADD CONSTRAINT `bids_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `Users` (`UserID`),
  ADD CONSTRAINT `bids_ibfk_2` FOREIGN KEY (`ItemId`) REFERENCES `Item` (`ItemId`);

--
-- Constraints for table `Item`
--
ALTER TABLE `Item`
  ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`SellerId`) REFERENCES `Users` (`UserID`);

--
-- Constraints for table `ItemCategory`
--
ALTER TABLE `ItemCategory`
  ADD CONSTRAINT `itemcategory_ibfk_1` FOREIGN KEY (`ItemId`) REFERENCES `Item` (`ItemId`),
  ADD CONSTRAINT `itemcategory_ibfk_2` FOREIGN KEY (`CategoryId`) REFERENCES `Category` (`CategoryId`);
