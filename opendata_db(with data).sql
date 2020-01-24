-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Värd: 127.0.0.1
-- Tid vid skapande: 24 jan 2020 kl 10:12
-- Serverversion: 10.4.6-MariaDB
-- PHP-version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databas: `opendata_db`
--
CREATE DATABASE IF NOT EXISTS `opendata_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `opendata_db`;

-- --------------------------------------------------------

--
-- Tabellstruktur `car`
--

CREATE TABLE `car` (
  `id` int(11) NOT NULL COMMENT 'Item id (PRIMARY)',
  `link` varchar(256) NOT NULL COMMENT 'Link to bytbil.com article. ex: bytbil.com/[LINK]',
  `brand` varchar(64) NOT NULL COMMENT 'Bilens märke',
  `regnum` varchar(16) NOT NULL COMMENT 'Regnummret till bilen',
  `address` varchar(256) NOT NULL COMMENT 'Address till vart bilen finns',
  `model` varchar(64) NOT NULL COMMENT 'Bilens modell',
  `drivewheel` varchar(64) NOT NULL COMMENT '2wd / 4wd',
  `milage` int(11) NOT NULL COMMENT 'Hur många mil bilen gått',
  `price` int(11) NOT NULL COMMENT 'Vad bilen säljs för',
  `gearbox` varchar(16) NOT NULL COMMENT 'manuel / automat',
  `year` int(11) NOT NULL COMMENT 'Årsmodell',
  `fuel` varchar(32) NOT NULL COMMENT 'Type of fuel (Disel/Bensin)'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumpning av Data i tabell `car`
--

INSERT INTO `car` (`id`, `link`, `brand`, `regnum`, `address`, `model`, `drivewheel`, `milage`, `price`, `gearbox`, `year`, `fuel`) VALUES
(37, 'https://bytbil.com/skane-lan/personbil-prius-1-5-vvt-i-plus-3cm-cvt-112hk-8202-14181994', 'Toyota', '-', 'Gevärsgatan 17 25466 HELSINGBORG', 'Prius', '2WD', 12200, 59900, 'Automatisk', 2008, 'Hybrid el/bensin'),
(38, 'https://bytbil.com/orebro-lan/personbil-passat-r-line-2-0tdi-177-dsg-4motion-5687-14181928', 'Volkswagen', 'MOB520', 'tomta 189 69491 HALLSBERG', 'Passat', '4WD', 15700, 139900, 'Automatisk', 2015, 'Diesel'),
(39, 'https://bytbil.com/stockholms-lan/personbil-cx-5-2-2-awd-automat-euro6-150hk-7423-14181841', 'Mazda', 'MEM085', 'Finspångsgatan 37 16353 SPÅNGA', 'CX-5', '4WD', 15178, 129900, 'Automatisk', 2012, 'Diesel'),
(40, 'https://bytbil.com/kronobergs-lan/personbil-one-5d-pepper-15e-sportratt-2109-14181961', 'Mini', 'PCL224', 'Vaktvägen 3 35236 VÄXJÖ', 'One', '2WD', 1254, 119800, 'Manuell', 2017, 'Bensin'),
(41, 'https://bytbil.com/kronobergs-lan/personbil-i3-120ah-charged-navi-fast-charge-2109-14181960', 'BMW', 'SPH512', 'Vaktvägen 3 35236 VÄXJÖ', 'i3', '2WD', 170, 329800, 'Automatisk', 2019, 'El'),
(42, 'https://bytbil.com/uppsala-lan/personbil-v60-t3-aut-kinetic-150-hk-drag-plus-p-varmare-plus-mv-1761-14181606', 'Volvo', 'PSH424', 'Fyrislundsgatan 74 75450 UPPSALA', 'V60', '2WD', 8819, 169000, 'Automatisk', 2015, 'Bensin'),
(43, 'https://bytbil.com/stockholms-lan/personbil-karoq-life-edition-tsi115-dragpaket-9175-14181943', 'Skoda', 'KJD40S', 'Kanalvägen 1 E 19461 UPPLANDS VÄSBY', 'Karoq', '2WD', 0, 2990, 'Manuell', 2020, 'Bensin'),
(44, 'https://bytbil.com/skane-lan/personbil-sharan-2-0-tdi-eu6-184hk-4motion-dsg-premium-6579-14181812', 'Volkswagen', 'YJL647', 'Holmbyvägen 71 24747 FLYINGE', 'Sharan', '4WD', 8119, 279500, 'Automatisk', 2017, 'Diesel'),
(45, 'https://bytbil.com/vastra-gotalands-lan/personbil-corolla-corolla-1-6-4-d-pluspaket-2217-14181911', 'Toyota', 'CPE084', 'Jordbron 66822 ED', 'Corolla', '2WD', 11534, 69000, 'Manuell', 2009, 'Bensin'),
(46, 'https://bytbil.com/uppsala-lan/personbil-panamera-4-sv-sald-sport-chrono-plus-sv-hjul-1756-14181582', 'Porsche', 'MUN177', 'Åkaregatan 7 75454 UPPSALA', 'Panamera', '4WD', 5500, 399000, 'Automatisk', 2012, 'Bensin'),
(47, 'https://bytbil.com/varmlands-lan/personbil-i30-5-dorrar-1-6-crdi-dct-110hk-1882-14181852', 'Hyundai', 'PYH325', 'Stationsgatan 6 68122 KRISTINEHAMN', 'i30', '2WD', 8000, 129000, 'Automatisk', 2016, 'Diesel'),
(48, 'https://bytbil.com/uppsala-lan/personbil-camry-hybrid-2-5-executive-euro-6-203hk-5297-14181822', 'Toyota', 'CLB25W', 'Martinvägen 6 74832 ÖSTERBYBRUK', 'Camry', '2WD', 158, 374000, 'Automatisk', 2019, 'Hybrid el/bensin'),
(49, 'https://bytbil.com/stockholms-lan/personbil-karoq-life-edition-tsi115-dragpaket-9175-14181858', 'Skoda', 'BFK84A', 'Kanalvägen 1 E 19461 UPPLANDS VÄSBY', 'Karoq', '2WD', 0, 235900, 'Manuell', 2020, 'Bensin'),
(50, 'https://bytbil.com/vastra-gotalands-lan/personbil-golf-1-6-tdi-halvkombi-gps-11000mil-7901-14181740', 'Volkswagen', 'JKF793', 'Utlandagatan 24 C 41280 GÖTEBORG', 'Golf', '2WD', 11050, 67000, 'Manuell', 2011, 'Diesel'),
(51, 'https://bytbil.com/stockholms-lan/personbil-vitara-1-6-exclusive-120hk-automat-awd-5231-14181873', 'Suzuki', 'YMY888', 'Murmästarvägen 29 12735 SÄTRA / STHLM', 'Vitara', '4WD', 800, 179900, 'Automatisk', 2017, 'Bensin'),
(52, 'https://bytbil.com/skane-lan/personbil-ff-6-3-v12-dct-euro-6-660hk-6604-14181274', 'Ferrari', '-', 'Västkustvägen 19 21124 MALMÖ', 'FF', 'Okänt', 2650, 1590000, 'Automatisk', 2015, 'Bensin'),
(53, 'https://bytbil.com/skane-lan/personbil-v60-d4-momentum-163hk-1491-14181923', 'Volvo', 'GDK985', 'Företagsgatan 7 23321 SVEDALA', 'V60', '2WD', 11965, 149900, 'Manuell', 2014, 'Diesel'),
(54, 'https://bytbil.com/sodermanlands-lan/personbil-x-trail-2-5-4x4-automat-165hk-8277-14180942', 'Nissan', 'OMU125', 'Björksgatan 14 63221 ESKILSTUNA', 'X-Trail', '4WD', 17500, 44900, 'Automatisk', 2006, 'Bensin'),
(55, 'https://bytbil.com/kronobergs-lan/personbil-passat-2-0-tdi-4motion-executive-euro-6-190hk-6329-14181832', 'Volkswagen', 'SBW797', 'Gängesvägen 12 34131 LJUNGBY', 'Passat', '4WD', 15780, 159900, 'Automatisk', 2016, 'Diesel'),
(56, 'https://bytbil.com/skane-lan/personbil-passat-gte-variant-1-4-tsi-dsg-nav-euro-6-218hk-1491-14181904', 'Volkswagen', 'YBP591', 'Företagsgatan 7 23321 SVEDALA', 'Passat', '2WD', 5407, 259900, 'Automatisk', 2016, 'Hybrid el/bensin'),
(57, 'https://bytbil.com/stockholms-lan/personbil-passat-gte-sportscombi-dsg6-executive-7573-14181918', 'Volkswagen', 'HFG378', 'Smista Allé 13 14170 SEGELTORP', 'Passat', '2WD', 1650, 339900, 'Automatisk', 2019, 'Hybrid el/bensin'),
(58, 'https://bytbil.com/stockholms-lan/personbil-polo-tsi-90-dsg-1-2-master-7573-14181919', 'Volkswagen', 'YGP347', 'Smista Allé 13 14170 SEGELTORP', 'Polo', '2WD', 2486, 129900, 'Automatisk', 2017, 'Bensin'),
(59, 'https://bytbil.com/sodermanlands-lan/personbil-x1-sdrive18d-panorama-taklucka-sov-143hk-7946-14186138', 'BMW', 'DYU603', 'Fagottvägen 1 63347 ESKILSTUNA', 'X1', '2WD', 5828, 114900, 'Manuell', 2012, 'Diesel'),
(60, 'https://bytbil.com/gavleborgs-lan/personbil-clio-halvkombi-tce-ny-besiktad-8675-14186161', 'Renault', 'MCL040', 'Femte Tvärgatan 4 80284 GÄVLE', 'Clio', '2WD', 8259, 48000, 'Manuell', 2012, 'Bensin'),
(61, 'https://bytbil.com/stockholms-lan/personbil-a3-2-0-tdi-150-aut-sb-s-line-sport-navi-svensksald-7364-14186158', 'Audi', 'SWU516', 'Stålgatan 15A 19572 ROSERSBERG', 'A3', '2WD', 1800, 242900, 'Automatisk', 2017, 'Diesel'),
(62, 'https://bytbil.com/stockholms-lan/personbil-octavia-kombi-1-6-101hk-fynd-7777-14186268', 'Skoda', 'PJT679', 'Spjutvägen 5C 17561 JÄRFÄLLA', 'Octavia', '2WD', 22800, 3900, 'Manuell', 2000, 'Bensin'),
(63, 'https://bytbil.com/uppsala-lan/personbil-xceed-1-4-t-gdi-dct-advance-plus-mv-plus-led-ramp-1761-14186237', 'Kia', 'WYF78E', 'Fyrislundsgatan 74 75450 UPPSALA', 'Xceed', '2WD', 244, 269000, 'Automatisk', 2020, 'Bensin'),
(64, 'https://bytbil.com/stockholms-lan/personbil-e-220-t-d-4matic-9g-tronic-euro-6-194hk-2562-14185460', 'Mercedes-Benz', 'YUS583', 'Björnövägen 15 76141 NORRTÄLJE', 'E', '4WD', 2342, 439000, 'Automatisk', 2018, 'Diesel'),
(65, 'https://bytbil.com/jonkopings-lan/personbil-avensis-kombi-1-8-drag-vhjul-4-ar-garanti-7086-14186201', 'Toyota', 'GLP055', 'Granitvägen 2 55303 JÖNKÖPING', 'Avensis', '2WD', 8655, 134900, 'Manuell', 2014, 'Bensin'),
(66, 'https://bytbil.com/ostergotlands-lan/personbil-vito-110-cdi-95hk-9673-mil-6454-14186156', 'Mercedes-Benz', 'NBF516', 'Linghemsvägen 20 58272 LINKÖPING', 'Vito', '2WD', 9673, 94900, 'Manuell', 2013, 'Diesel'),
(67, 'https://bytbil.com/skane-lan/personbil-space-star-1-2-80hk-8436-14186166', 'Mitsubishi', 'HWY708', 'Kalkstensvägen 20 22478 LUND', 'Space Star', '2WD', 5000, 69000, 'Manuell', 2015, 'Bensin'),
(68, 'https://bytbil.com/stockholms-lan/personbil-transporter-t5-2-5-tdi-130hk-drag-5238-14186260', 'VW', 'HKF023', 'Energivägen 3 19637 KUNGSÄNGEN', 'Transporter', '2WD', 6528, 59000, 'Automatisk', 2008, 'Diesel'),
(69, 'https://bytbil.com/vastra-gotalands-lan/personbil-e-200-automat-136hk-10000-mil-8612-14186216', 'Mercedes-Benz', 'EXE723', 'Ryssnäsgatan 14 50464 BORÅS', 'E', '2WD', 10500, 29900, 'Automatisk', 1999, 'Bensin'),
(70, 'https://bytbil.com/skane-lan/personbil-9-3-sportcombi-1-9-tid-automat-linear-150hk-8998-14186164', 'Saab', 'KGP134', 'Tians väg 26 29532 BROMÖLLA', '9-3', '2WD', 31000, 23900, 'Automatisk', 2007, 'Diesel'),
(71, 'https://bytbil.com/stockholms-lan/personbil-rsq3-400-hk-s-tronic-6391-14186188', 'Audi', '-', 'Raseborgsgatan 2 16474 KISTA', 'RSQ3', 'Okänt', 1, 658900, 'Automatisk', 2020, 'Bensin'),
(72, 'https://bytbil.com/stockholms-lan/personbil-ix20-1-6-125hk-comfort-1820-14186097', 'Hyundai', 'OFW252', 'Markörgatan 5 13644 HANINGE', 'ix20', '2WD', 2250, 128900, 'Manuell', 2017, 'Bensin'),
(73, 'https://bytbil.com/orebro-lan/personbil-tiguan-1-4-tsi-4motion-r-line-comfort-160hk-2666-14186170', 'Volkswagen', 'HFL397', 'Kopparbergsvägen 53 71176 STORÅ', 'Tiguan', '4WD', 9300, 159500, 'Manuell', 2015, 'Bensin'),
(74, 'https://bytbil.com/varmlands-lan/personbil-cx-3-2-0-120hk-aut-2610mil-1agare-7471-14186172', 'Mazda', 'GBZ726', 'Våxnäsgatan 120 65341 KARLSTAD', 'CX-3', '2WD', 2610, 159900, 'Automatisk', 2015, 'Bensin'),
(75, 'https://bytbil.com/orebro-lan/personbil-a6-avant-2-0-tdi-dpf-multitronic-170hk-5732-14186179', 'Audi', 'JXG668', 'Tingslagsgatan 5 70217 ÖREBRO', 'A6', '2WD', 22500, 69900, 'Automatisk', 2010, 'Diesel'),
(76, 'https://bytbil.com/skane-lan/personbil-307-sw-2-0-140hk-dragkrok-8587-14186185', 'Peugeot', 'XMT960', 'Lundavägen 10 24138 ESLÖV', '307', '2WD', 21500, 13900, 'Manuell', 2006, 'Bensin'),
(77, 'https://bytbil.com/sodermanlands-lan/personbil-320-i-150hk-advantage-lagamil-8195-14186180', 'BMW', 'XJP702', '64430 ESKILSTUNA', '320', '2WD', 16600, 54900, 'Manuell', 2006, 'Bensin'),
(78, 'https://bytbil.com/gavleborgs-lan/personbil-aygo-5-dorrar-1-0-vvt-i-68hk-3214-14186220', 'Toyota', 'CXG109', 'Larsvägen 6 82434 HUDIKSVALL', 'Aygo', '2WD', 15040, 22000, 'Manuell', 2008, 'Bensin'),
(79, 'https://bytbil.com/uppsala-lan/personbil-qashqai-plus-2-2-0-7-sits-141hk-tekna-navi-plus-backkamera-plus-panorama-1761-14186168', 'Nissan', 'LZP174', 'Fyrislundsgatan 74 75450 UPPSALA', 'Qashqai+2', '2WD', 9199, 109000, 'Manuell', 2012, 'Bensin'),
(80, 'https://bytbil.com/vastmanlands-lan/personbil-golf-5-dorrar-1-6-fsi-115hk-7934-14186190', 'Volkswagen', 'UST493', 'Brinellvägen 7 73740 FAGERSTA', 'Golf', '2WD', 168939, 29000, 'Manuell', 2004, 'Bensin'),
(81, 'https://bytbil.com/skane-lan/personbil-3008-active-puretech-130hk-dragkrok-1635-14186067', 'Peugeot', 'JYU011', 'Djurhagegatan 14 21376 MALMÖ', '3008', '2WD', 5647, 199900, 'Manuell', 2017, 'Bensin'),
(82, 'https://bytbil.com/vastra-gotalands-lan/personbil-astra-1-6-twinport-105hk-7964-14186052', 'Opel', 'XZX916', 'Svetsargatan 1 46256 VÄNERSBORG', 'Astra', '2WD', 19700, 17900, 'Manuell', 2007, 'Bensin'),
(83, 'https://bytbil.com/vastra-gotalands-lan/personbil-v90-d3-aut-6569-14186130', 'Volvo', 'PEV668', 'Råda Johanslund 53196 LIDKÖPING', 'V90', 'Okänt', 28310, 199500, 'Automatisk', 2017, 'Diesel'),
(84, 'https://bytbil.com/skane-lan/personbil-jumpy-van-2-0-hdi-128hk-6142-14185563', 'Citroën', 'NWY821', 'Tryde 1918 27397 TOMELILLA', 'Jumpy', '2WD', 8624, 79900, 'Manuell', 2013, 'Diesel'),
(85, 'https://bytbil.com/stockholms-lan/personbil-e-240-177hk-aut-inf-drag-m-varm-8383-14186182', 'Mercedes-Benz', 'WAK364', 'Sturegatan 6 17231 SUNDBYBERG', 'E', '2WD', 17971, 64900, 'Automatisk', 2004, 'Bensin'),
(86, 'https://bytbil.com/varmlands-lan/personbil-clio-tce-100-intens-5-d-1200-14186358', 'Renault', 'DGG64A', 'Västgötagatan 45 68142 KRISTINEHAMN', 'Clio', '2WD', 0, 189700, 'Manuell', 2020, 'Bensin'),
(87, 'https://bytbil.com/varmlands-lan/personbil-captur-phii-tce-90-zen-ii-1200-14186359', 'Renault', 'FNH06R', 'Västgötagatan 45 68142 KRISTINEHAMN', 'Captur', '2WD', 0, 176300, 'Manuell', 2019, 'Bensin'),
(88, 'https://bytbil.com/varmlands-lan/personbil-captur-tce-130-intens-edc-1200-14186357', 'Renault', 'EPX75B', 'Västgötagatan 45 68142 KRISTINEHAMN', 'Captur', '2WD', 0, 268400, 'Manuell', 2020, 'Bensin'),
(89, 'https://bytbil.com/varmlands-lan/personbil-520d-touring-f11-1200-14186356', 'BMW', 'KTN796', 'Västgötagatan 45 68142 KRISTINEHAMN', '520', '2WD', 14968, 146000, 'Manuell', 2013, 'Diesel'),
(90, 'https://bytbil.com/uppsala-lan/personbil-outlander-phev-2-4-komfort-omg-lev-1709-14186328', 'Mitsubishi', 'RNU15W', 'Stångjärnsgatan 3 75323 UPPSALA', 'Outlander', '4WD', 0, 459800, 'Automatisk', 2020, 'Hybrid el/bensin'),
(91, 'https://bytbil.com/stockholms-lan/personbil-xc60-d4-awd-classic-momentum-1930-14186349', 'Volvo', 'JNU684', 'Kilowattvägen 11 13644 HANDEN', 'XC60', '4WD', 4985, 269900, 'Automatisk', 2017, 'Diesel'),
(92, 'https://bytbil.com/skane-lan/personbil-golf-1-6-comfort-105hk-gott-skick-svensksald-9117-14186289', 'Volkswagen', 'SXN434', 'Sadelgatan 14 21377 MALMÖ', 'Golf', '2WD', 27000, 8900, 'Manuell', 2002, 'Bensin'),
(93, 'https://bytbil.com/stockholms-lan/personbil-xc90-t5-awd-r-design-7-saten-5152-14186339', 'Volvo', 'FYT45T', 'Kronåsvägen 2-4 19124 SOLLENTUNA', 'XC90', '4WD', 544, 729900, 'Automatisk', 2020, 'Bensin'),
(94, 'https://bytbil.com/stockholms-lan/personbil-v60-d4-classic-momentum-5152-14186340', 'Volvo', 'YSN459', 'Kronåsvägen 2-4 19124 SOLLENTUNA', 'V60', '2WD', 2454, 239900, 'Automatisk', 2018, 'Diesel'),
(95, 'https://bytbil.com/vastra-gotalands-lan/personbil-passat-alltrack-2-0tdi-4motion-dsg-euro-6-190hk-16-8380-14186288', 'Volkswagen', 'KCL903', 'Stampgatan 2 46273 VÄNERSBORG', 'Passat', '4WD', 10800, 219900, 'Automatisk', 2016, 'Diesel'),
(96, 'https://bytbil.com/stockholms-lan/personbil-superb-2-0-tsi-4x4-2305-14186334', 'Skoda', 'YEY676', 'Enhagsvägen 6 18740 TÄBY', 'Superb', '4WD', 4800, 269000, 'Automatisk', 2017, 'Bensin'),
(97, 'https://bytbil.com/uppsala-lan/personbil-outlander-phev-2-4-komfort-omg-lev-1709-14186281', 'Mitsubishi', 'FHR86B', 'Stångjärnsgatan 3 75323 UPPSALA', 'Outlander', '4WD', 0, 459800, 'Automatisk', 2020, 'Hybrid el/bensin'),
(98, 'https://bytbil.com/hallands-lan/personbil-tiguan-2-0-4m-190-tdi-d7a-1123-14186318', 'Volkswagen', 'ZCD154', 'Faktorvägen 8 43437 KUNGSBACKA', 'Tiguan', '4WD', 3200, 314900, 'Automatisk', 2018, 'Diesel'),
(99, 'https://bytbil.com/hallands-lan/personbil-golf-sportscombi-1-4-tsi-150hk-dsg-1123-14186317', 'Volkswagen', 'YGD154', 'Faktorvägen 8 43437 KUNGSBACKA', 'Golf', '2WD', 4140, 199800, 'Automatisk', 2017, 'Bensin'),
(100, 'https://bytbil.com/stockholms-lan/personbil-fabia-kombi-combi-style-tsi-110hk-dsg-2550-14186310', 'Skoda', 'ZDG563', 'Ulvsundavägen 120-132 16836 BROMMA', 'Fabia', '2WD', 1422, 144900, 'Automatisk', 2018, 'Bensin'),
(101, 'https://bytbil.com/skane-lan/personbil-captur-1-2-tce-aut-euro-6-120hk-1635-14186277', 'Renault', 'PZJ965', 'Djurhagegatan 14 21376 MALMÖ', 'Captur', '2WD', 2225, 154900, 'Automatisk', 2017, 'Bensin'),
(102, 'https://bytbil.com/stockholms-lan/personbil-320-d-aut-sedan-m-sport-navi-pro-7666-14186234', 'BMW', '-', 'Ellipsvägen 12 14175 STOCKHOLM', '320', '2WD', 7810, 239900, 'Automatisk', 2016, 'Diesel'),
(103, 'https://bytbil.com/hallands-lan/personbil-colt-1-3-mpi-95hk-11-100mil-6263-14186257', 'Mitsubishi', 'FPA932', 'Sättarevägen 5 43437 KUNGSBACKA', 'Colt', '2WD', 11100, 23500, 'Manuell', 2007, 'Bensin'),
(104, 'https://bytbil.com/stockholms-lan/personbil-rsq3-sportback-400-hk-s-tronic-6391-14186282', 'Audi', '-', 'Raseborgsgatan 2 16474 KISTA', 'RSQ3', 'Okänt', 1, 685400, 'Automatisk', 2020, 'Bensin'),
(105, 'https://bytbil.com/sodermanlands-lan/personbil-v60-d5-awd-aut-summum-voc-drag-215hk-6806-14186051', 'Volvo', 'MJO709', 'Mått Johanssons väg 34 63346 ESKILSTUNA', 'V60', '4WD', 10771, 199000, 'Automatisk', 2014, 'Diesel');

-- --------------------------------------------------------

--
-- Tabellstruktur `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL COMMENT 'User ID (PRIMARY)',
  `username` varchar(32) NOT NULL COMMENT 'username (UNIQUE)',
  `hash` varchar(256) DEFAULT NULL COMMENT 'hashed version of users password',
  `oauth_id` varchar(32) DEFAULT NULL COMMENT 'Oauth ID from Github',
  `token` varchar(128) DEFAULT NULL COMMENT 'OAuth/Auth Token'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumpning av Data i tabell `user`
--

INSERT INTO `user` (`id`, `username`, `hash`, `oauth_id`, `token`) VALUES
(12, 'qwe', '$2a$13$nj2K22AmdDC9ZYVls6atK.PgTrb0Ae626QBrdVCXR6xlR4Z90NgSG', NULL, '1aEjZlumt0agTC7ITqe_Gyu5eV2fqWf7'),
(17, 'zyxago', NULL, '32297312', '1b5e60a6ae5345a1d5b347ffd13973610f74786b');

-- --------------------------------------------------------

--
-- Tabellstruktur `user_car`
--

CREATE TABLE `user_car` (
  `user_id` int(11) NOT NULL COMMENT 'Users ID',
  `car_id` int(11) NOT NULL COMMENT 'Items ID'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumpning av Data i tabell `user_car`
--

INSERT INTO `user_car` (`user_id`, `car_id`) VALUES
(12, 100);

-- --------------------------------------------------------

--
-- Ersättningsstruktur för vy `user_car_full_info`
-- (See below for the actual view)
--
CREATE TABLE `user_car_full_info` (
`user_id` int(11)
,`username` varchar(32)
,`item_id` int(11)
,`link` varchar(256)
,`brand` varchar(64)
,`regnum` varchar(16)
,`address` varchar(256)
,`model` varchar(64)
,`drivewheel` varchar(64)
,`milage` int(11)
,`price` int(11)
,`fuel` varchar(32)
,`year` int(11)
,`gearbox` varchar(16)
);

-- --------------------------------------------------------

--
-- Struktur för vy `user_car_full_info`
--
DROP TABLE IF EXISTS `user_car_full_info`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `user_car_full_info`  AS  select `user`.`id` AS `user_id`,`user`.`username` AS `username`,`car`.`id` AS `item_id`,`car`.`link` AS `link`,`car`.`brand` AS `brand`,`car`.`regnum` AS `regnum`,`car`.`address` AS `address`,`car`.`model` AS `model`,`car`.`drivewheel` AS `drivewheel`,`car`.`milage` AS `milage`,`car`.`price` AS `price`,`car`.`fuel` AS `fuel`,`car`.`year` AS `year`,`car`.`gearbox` AS `gearbox` from ((`user` join `car`) join `user_car`) where `user`.`id` = `user_car`.`user_id` and `car`.`id` = `user_car`.`car_id` ;

--
-- Index för dumpade tabeller
--

--
-- Index för tabell `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `link_idx` (`link`);

--
-- Index för tabell `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username_idx` (`username`),
  ADD UNIQUE KEY `token_idx` (`token`),
  ADD UNIQUE KEY `oauth_idx` (`oauth_id`);

--
-- Index för tabell `user_car`
--
ALTER TABLE `user_car`
  ADD PRIMARY KEY (`user_id`,`car_id`),
  ADD KEY `item_id` (`car_id`);

--
-- AUTO_INCREMENT för dumpade tabeller
--

--
-- AUTO_INCREMENT för tabell `car`
--
ALTER TABLE `car`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Item id (PRIMARY)', AUTO_INCREMENT=106;

--
-- AUTO_INCREMENT för tabell `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'User ID (PRIMARY)', AUTO_INCREMENT=21;

--
-- Restriktioner för dumpade tabeller
--

--
-- Restriktioner för tabell `user_car`
--
ALTER TABLE `user_car`
  ADD CONSTRAINT `item_id` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`),
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
