# CREATE DATABASE auctioneer;
# USE auctioneer;

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

CREATE TABLE `Users` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
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
  `Verified` BOOLEAN NOT NULL,
  PRIMARY KEY (UserID)
);

CREATE TABLE `Item` (
  `ItemId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Currently` decimal(10,2) NOT NULL,
  `Buy_Price` decimal(10,2) DEFAULT NULL,
  `First_Bid` decimal(10,2) NOT NULL,
  `Number_Of_Bids` int(11) DEFAULT '0',
  `Latitude` double(10,6) NOT NULL,
  `Longitude` double(10,6) NOT NULL,
  `Country` varchar(255) DEFAULT NULL,
  `CreatedDate` date NOT NULL,
  `StartDate` date,
  `EndDate` date NOT NULL,
  `Description` text,
  `SellerId` int(11) NOT NULL,
  PRIMARY KEY (ItemId),
  FOREIGN KEY (`SellerId`) REFERENCES `Users` (`UserID`)
);



CREATE TABLE `Bids` (
  `BidId` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) NOT NULL,
  `ItemId` int(11) NOT NULL,
  `Bid_Date` date NOT NULL,
  `OfferPrice` decimal(10,2) NOT NULL,
  PRIMARY KEY (BidId),
  FOREIGN KEY (`UserId`) REFERENCES `Users` (`UserID`),
  FOREIGN KEY (`ItemId`) REFERENCES `Item` (`ItemId`)

);


CREATE TABLE `Category` (
  `CategoryId` int(11) NOT NULL AUTO_INCREMENT,
  `CategoryName` varchar(255) NOT NULL,
  PRIMARY KEY (CategoryId)
);


CREATE TABLE `ItemCategory` (
  `ItemCategoryId` int(11) NOT NULL,
  `ItemId` int(11) NOT NULL,
  `CategoryId` int(11) NOT NULL,
  PRIMARY KEY (ItemCategoryId),
  FOREIGN KEY (`ItemId`) REFERENCES `Item` (`ItemId`),
  FOREIGN KEY (`CategoryId`) REFERENCES `Category` (`CategoryId`)
);



CREATE TABLE `Photos` (
  `PhotoId` int(11) NOT NULL AUTO_INCREMENT,
  `Itemid` int(11) NOT NULL,
  `PhotoPath` varchar(255) NOT NULL,
  PRIMARY KEY (PhotoId),
  FOREIGN KEY (`ItemId`) REFERENCES `Item` (`ItemId`)
);



INSERT INTO `Users` (`UserID`, `LastName`, `FirstName`, `Password`, `Username`, `Email`, `Address`, `Latitude`, `Longitude`, `Afm`, `Phone`, `Role`, `Gender`, `Verified`, `BuyerRating`, `SellerRating`) VALUES
  (1, 'Paparigopoulos', 'Lemonemboras', '123456', 'cocoblocos', 'jimseinta@gmail.com', 'praxitelous', 37.434003, 25.274956, '23242343423', '6987122499', 'admin', 'male', TRUE, 0.0, 0.0);

INSERT INTO `Item` (`ItemId`,  `Name`,  `Currently`,  `Buy_Price`,  `First_Bid`,  `Number_Of_Bids`,  `Latitude`,  `Longitude`,  `Country`,  `CreatedDate`,  `StartDate`,  `EndDate`,  `Description`,  `SellerId`) VALUES
                    (1, "Playstation 4", 150, 200, 100, 3, 42.1, 6.1, "Greece", STR_TO_DATE('1-08-2016', '%d-%m-%Y'), STR_TO_DATE('1-08-2016', '%d-%m-%Y'), STR_TO_DATE('15-08-2016', '%d-%m-%Y'), "Playstation 4 in great condition, bought on 2016. Comes with 4 games and 2 controllers. Also available 3rd remote." , 1);
INSERT INTO `Item` (`ItemId`,  `Name`,  `Currently`,  `Buy_Price`,  `First_Bid`,  `Number_Of_Bids`,  `Latitude`,  `Longitude`,  `Country`,  `CreatedDate`,  `StartDate`,  `EndDate`,  `Description`,  `SellerId`)  VALUES
                    (2, "MacBook Pro 13inch late 2015", 850, 950, 800, 1, 42.1, 6.2, "Greece",  STR_TO_DATE('1-08-2016', '%d-%m-%Y'), null, STR_TO_DATE('16-09-2016', '%d-%m-%Y'), "MacBook Pro in exceland condition. 4gb of ram 128gb ssd and i5 processor. Comes with charger and 2 thunderbolt to dvi adaptors." , 1);

INSERT INTO `Category` VALUES (1, "Video Games");
INSERT INTO `Category` VALUES (2, "Laptops");

INSERT INTO  `ItemCategory` VALUES (1, 1, 1);
INSERT INTO  `ItemCategory` VALUES (2, 2, 2);

INSERT INTO `Photos` VALUES (1, 1, 'images/1_1.png');
INSERT INTO `Photos` VALUES (2, 2, 'images/2_1.png');