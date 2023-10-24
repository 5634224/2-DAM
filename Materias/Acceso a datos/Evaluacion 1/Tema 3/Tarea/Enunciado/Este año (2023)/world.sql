CREATE TABLE country (
  Code varchar(3) NOT NULL,
  Name varchar(52) NOT NULL,
  Continent varchar(20) DEFAULT 'Europe' NOT NULL,
  Region varchar(26),
  SurfaceArea decimal(10,2),
  IndepYear smallint,
  Population int,
  LifeExpectancy decimal(3,1),
  GNP decimal(10,2),
  GNPOld decimal(10,2),
  LocalName varchar(45),
  GovernmentForm varchar(45),
  HeadOfState varchar(60),
  Capital int,
  Code2 varchar(2),
  CONSTRAINT COUNTRY_PK PRIMARY KEY (Code)
);

INSERT INTO country VALUES ('ALB','Albania','Europe','Southern Europe',28748.00,1912,3401200,71.6,3205.00,2500.00,'Shqipëria','Republic','Rexhep Mejdani',34,'AL');
INSERT INTO country VALUES  ('AND','Andorra','Europe','Southern Europe',468.00,1278,78000,83.5,1630.00,NULL,'Andorra','Parliamentary Coprincipality','',55,'AD');
INSERT INTO country VALUES  ('AUT','Austria','Europe','Western Europe',83859.00,1918,8091800,77.7,211860.00,206025.00,'Österreich','Federal Republic','Thomas Klestil',1523,'AT');
INSERT INTO country VALUES  ('BEL','Belgium','Europe','Western Europe',30518.00,1830,10239000,77.8,249704.00,243948.00,'België/Belgique','Constitutional Monarchy, Federation','Albert II',179,'BE');
INSERT INTO country VALUES  ('BGR','Bulgaria','Europe','Eastern Europe',110994.00,1908,8190900,70.9,12178.00,10169.00,'Balgarija','Republic','Petar Stojanov',539,'BG');
INSERT INTO country VALUES  ('BIH','Bosnia and Herzegovina','Europe','Southern Europe',51197.00,1992,3972000,71.5,2841.00,NULL,'Bosna i Hercegovina','Federal Republic','Ante Jelavic',201,'BA');
INSERT INTO country VALUES  ('BLR','Belarus','Europe','Eastern Europe',207600.00,1991,10236000,68.0,13714.00,NULL,'Belarus','Republic','Aljaksandr Lukašenka',3520,'BY');
INSERT INTO country VALUES ('CHE','Switzerland','Europe','Western Europe',41284.00,1499,7160400,79.6,264478.00,256092.00,'Schweiz/Suisse/Svizzera/Svizra','Federation','Adolf Ogi',3248,'CH');
INSERT INTO country VALUES  ('CZE','Czech Republic','Europe','Eastern Europe',78866.00,1993,10278100,74.5,55017.00,52037.00,'¸esko','Republic','Václav Havel',3339,'CZ');
INSERT INTO country VALUES  ('DEU','Germany','Europe','Western Europe',357022.00,1955,82164700,77.4,2133367.00,2102826.00,'Deutschland','Federal Republic','Johannes Rau',3068,'DE');
INSERT INTO country VALUES  ('DNK','Denmark','Europe','Nordic Countries',43094.00,800,5330000,76.5,174099.00,169264.00,'Danmark','Constitutional Monarchy','Margrethe II',3315,'DK');
INSERT INTO country VALUES  ('ESP','Spain','Europe','Southern Europe',505992.00,1492,39441700,78.8,553233.00,532031.00,'España','Constitutional Monarchy','Juan Carlos I',653,'ES');
INSERT INTO country VALUES  ('EST','Estonia','Europe','Baltic Countries',45227.00,1991,1439200,69.5,5328.00,3371.00,'Eesti','Republic','Lennart Meri',3791,'EE');
INSERT INTO country VALUES  ('FIN','Finland','Europe','Nordic Countries',338145.00,1917,5171300,77.4,121914.00,119833.00,'Suomi','Republic','Tarja Halonen',3236,'FI');
INSERT INTO country VALUES ('FRA','France','Europe','Western Europe',551500.00,843,59225700,78.8,1424285.00,1392448.00,'France','Republic','Jacques Chirac',2974,'FR');
INSERT INTO country VALUES  ('FRO','Faroe Islands','Europe','Nordic Countries',1399.00,NULL,43000,78.4,0.00,NULL,'Føroyar','Part of Denmark','Margrethe II',901,'FO');
INSERT INTO country VALUES  ('GBR','United Kingdom','Europe','British Islands',242900.00,1066,59623400,77.7,1378330.00,1296830.00,'United Kingdom','Constitutional Monarchy','Elisabeth II',456,'GB');
INSERT INTO country VALUES  ('GIB','Gibraltar','Europe','Southern Europe',6.00,NULL,25000,79.0,258.00,NULL,'Gibraltar','Dependent Territory of the UK','Elisabeth II',915,'GI');
INSERT INTO country VALUES  ('GRC','Greece','Europe','Southern Europe',131626.00,1830,10545700,78.4,120724.00,119946.00,'Elláda','Republic','Kostis Stefanopoulos',2401,'GR');
INSERT INTO country VALUES  ('HRV','Croatia','Europe','Southern Europe',56538.00,1991,4473000,73.7,20208.00,19300.00,'Hrvatska','Republic','Štipe Mesic',2409,'HR');
INSERT INTO country VALUES  ('HUN','Hungary','Europe','Eastern Europe',93030.00,1918,10043200,71.4,48267.00,45914.00,'Magyarország','Republic','Ferenc Mádl',3483,'HU');
INSERT INTO country VALUES ('IRL','Ireland','Europe','British Islands',70273.00,1921,3775100,76.8,75921.00,73132.00,'Ireland/Éire','Republic','Mary McAleese',1447,'IE');
INSERT INTO country VALUES  ('ISL','Iceland','Europe','Nordic Countries',103000.00,1944,279000,79.4,8255.00,7474.00,'Ísland','Republic','Ólafur Ragnar Grímsson',1449,'IS');
INSERT INTO country VALUES  ('ITA','Italy','Europe','Southern Europe',301316.00,1861,57680000,79.0,1161755.00,1145372.00,'Italia','Republic','Carlo Azeglio Ciampi',1464,'IT');
INSERT INTO country VALUES  ('LIE','Liechtenstein','Europe','Western Europe',160.00,1806,32300,78.8,1119.00,1084.00,'Liechtenstein','Constitutional Monarchy','Hans-Adam II',2446,'LI');
INSERT INTO country VALUES  ('LTU','Lithuania','Europe','Baltic Countries',65301.00,1991,3698500,69.1,10692.00,9585.00,'Lietuva','Republic','Valdas Adamkus',2447,'LT');
INSERT INTO country VALUES  ('LUX','Luxembourg','Europe','Western Europe',2586.00,1867,435700,77.1,16321.00,15519.00,'Luxembourg/Lëtzebuerg','Constitutional Monarchy','Henri',2452,'LU');
INSERT INTO country VALUES  ('LVA','Latvia','Europe','Baltic Countries',64589.00,1991,2424200,68.4,6398.00,5639.00,'Latvija','Republic','Vaira Vike-Freiberga',2434,'LV');
INSERT INTO country VALUES ('MCO','Monaco','Europe','Western Europe',1.50,1861,34000,78.8,776.00,NULL,'Monaco','Constitutional Monarchy','Rainier III',2695,'MC');
INSERT INTO country VALUES  ('MDA','Moldova','Europe','Eastern Europe',33851.00,1991,4380000,64.5,1579.00,1872.00,'Moldova','Republic','Vladimir Voronin',2690,'MD');
INSERT INTO country VALUES  ('MKD','Macedonia','Europe','Southern Europe',25713.00,1991,2024000,73.8,1694.00,1915.00,'Makedonija','Republic','Boris Trajkovski',2460,'MK');
INSERT INTO country VALUES  ('MLT','Malta','Europe','Southern Europe',316.00,1964,380200,77.9,3512.00,3338.00,'Malta','Republic','Guido de Marco',2484,'MT');
INSERT INTO country VALUES  ('NLD','Netherlands','Europe','Western Europe',41526.00,1581,15864000,78.3,371362.00,360478.00,'Nederland','Constitutional Monarchy','Beatrix',5,'NL');
INSERT INTO country VALUES  ('NOR','Norway','Europe','Nordic Countries',323877.00,1905,4478500,78.7,145895.00,153370.00,'Norge','Constitutional Monarchy','Harald V',2807,'NO');
INSERT INTO country VALUES  ('POL','Poland','Europe','Eastern Europe',323250.00,1918,38653600,73.2,151697.00,135636.00,'Polska','Republic','Aleksander Kwasniewski',2928,'PL');
INSERT INTO country VALUES ('PRT','Portugal','Europe','Southern Europe',91982.00,1143,9997600,75.8,105954.00,102133.00,'Portugal','Republic','Jorge Sampãio',2914,'PT');
INSERT INTO country VALUES  ('ROM','Romania','Europe','Eastern Europe',238391.00,1878,22455500,69.9,38158.00,34843.00,'România','Republic','Ion Iliescu',3018,'RO');
INSERT INTO country VALUES  ('RUS','Russian Federation','Europe','Eastern Europe',17075400.00,1991,146934000,67.2,276608.00,442989.00,'Rossija','Federal Republic','Vladimir Putin',3580,'RU');
INSERT INTO country VALUES  ('SJM','Svalbard and Jan Mayen','Europe','Nordic Countries',62422.00,NULL,3200,NULL,0.00,NULL,'Svalbard og Jan Mayen','Dependent Territory of Norway','Harald V',938,'SJ');
INSERT INTO country VALUES  ('SMR','San Marino','Europe','Southern Europe',61.00,885,27000,81.1,510.00,NULL,'San Marino','Republic',NULL,3171,'SM');
INSERT INTO country VALUES  ('SVK','Slovakia','Europe','Eastern Europe',49012.00,1993,5398700,73.7,20594.00,19452.00,'Slovensko','Republic','Rudolf Schuster',3209,'SK');
INSERT INTO country VALUES  ('SVN','Slovenia','Europe','Southern Europe',20256.00,1991,1987800,74.9,19756.00,18202.00,'Slovenija','Republic','Milan Kucan',3212,'SI');
INSERT INTO country VALUES ('SWE','Sweden','Europe','Nordic Countries',449964.00,836,8861400,79.6,226492.00,227757.00,'Sverige','Constitutional Monarchy','Carl XVI Gustaf',3048,'SE');
INSERT INTO country VALUES  ('UKR','Ukraine','Europe','Eastern Europe',603700.00,1991,50456000,66.0,42168.00,49677.00,'Ukrajina','Republic','Leonid Kutšma',3426,'UA');
INSERT INTO country VALUES  ('VAT','Holy See (Vatican City State)','Europe','Southern Europe',0.40,1929,1000,NULL,9.00,NULL,'Santa Sede/Città del Vaticano','Independent Church State','Johannes Paavali II',3538,'VA');
INSERT INTO country VALUES  ('YUG','Yugoslavia','Europe','Southern Europe',102173.00,1918,10640000,72.4,17000.00,NULL,'Jugoslavija','Federal Republic','Vojislav Koštunica',1792,'YU');

CREATE TABLE city (
  ID int NOT NULL,
  Name varchar(35) NOT NULL,
  CountryCode varchar(3) NOT NULL,
  District varchar(50),
  Population int,
  CONSTRAINT CITY_PK PRIMARY KEY (ID),
  CONSTRAINT city_ibfk_1 FOREIGN KEY (CountryCode) REFERENCES country (Code)
) ;

INSERT INTO city VALUES (5,'Amsterdam','NLD','Noord-Holland',731200);
INSERT INTO city VALUES (34,'Tirana','ALB','Tirana',270000);
INSERT INTO city VALUES (55,'Andorra la Vella','AND','Andorra la Vella',21189);
INSERT INTO city VALUES (179,'Bruxelles [Brussel]','BEL','Bryssel',133859);
INSERT INTO city VALUES (201,'Sarajevo','BIH','Federaatio',360000);
INSERT INTO city VALUES (456,'London','GBR','England',7285000);
INSERT INTO city VALUES (539,'Sofija','BGR','Grad Sofija',1122302);
INSERT INTO city VALUES (653,'Madrid','ESP','Madrid',2879052);
INSERT INTO city VALUES (901,'Tórshavn','FRO','Streymoyar',14542);
INSERT INTO city VALUES (915,'Gibraltar','GIB','–',27025);
INSERT INTO city VALUES (938,'Longyearbyen','SJM','Länsimaa',1438);
INSERT INTO city VALUES (1447,'Dublin','IRL','Leinster',481854);
INSERT INTO city VALUES (1449,'Reykjavík','ISL','Höfuðborgarsvæði',109184);
INSERT INTO city VALUES (1464,'Roma','ITA','Latium',2643581);
INSERT INTO city VALUES (1523,'Wien','AUT','Wien',1608144);
INSERT INTO city VALUES (1792,'Beograd','YUG','Central Serbia',1204000);
INSERT INTO city VALUES (2401,'Athenai','GRC','Attika',772072);
INSERT INTO city VALUES (2409,'Zagreb','HRV','Grad Zagreb',706770);
INSERT INTO city VALUES (2434,'Riga','LVA','Riika',764328);
INSERT INTO city VALUES (2446,'Vaduz','LIE','Vaduz',5043);
INSERT INTO city VALUES (2447,'Vilnius','LTU','Vilna',577969);
INSERT INTO city VALUES (2452,'Luxembourg [Luxemburg/Lëtzebuerg]','LUX','Luxembourg',80700);
INSERT INTO city VALUES (2460,'Skopje','MKD','Skopje',444299);
INSERT INTO city VALUES (2484,'Valletta','MLT','Inner Harbour',7073);
INSERT INTO city VALUES (2690,'Chisinau','MDA','Chisinau',719900);
INSERT INTO city VALUES (2695,'Monaco-Ville','MCO','–',1234);
INSERT INTO city VALUES (2807,'Oslo','NOR','Oslo',508726);
INSERT INTO city VALUES (2914,'Lisboa','PRT','Lisboa',563210);
INSERT INTO city VALUES (2928,'Warszawa','POL','Mazowieckie',1615369);
INSERT INTO city VALUES (2974,'Paris','FRA','Île-de-France',2125246);
INSERT INTO city VALUES (3018,'Bucuresti','ROM','Bukarest',2016131);
INSERT INTO city VALUES (3048,'Stockholm','SWE','Lisboa',750348);
INSERT INTO city VALUES (3068,'Berlin','DEU','Berliini',3386667);
INSERT INTO city VALUES (3171,'San Marino','SMR','San Marino',2294);
INSERT INTO city VALUES (3209,'Bratislava','SVK','Bratislava',448292);
INSERT INTO city VALUES (3212,'Ljubljana','SVN','Osrednjeslovenska',270986);
INSERT INTO city VALUES (3236,'Helsinki [Helsingfors]','FIN','Newmaa',555474);
INSERT INTO city VALUES (3248,'Bern','CHE','Bern',122700);
INSERT INTO city VALUES (3315,'København','DNK','København',495699);
INSERT INTO city VALUES (3339,'Praha','CZE','Hlavní mesto Praha',1181126);
INSERT INTO city VALUES (3426,'Kyiv','UKR','Kiova',2624000);
INSERT INTO city VALUES (3483,'Budapest','HUN','Budapest',1811552);
INSERT INTO city VALUES (3520,'Minsk','BLR','Horad Minsk',1674000);
INSERT INTO city VALUES (3538,'Città del Vaticano','VAT','–',455);
INSERT INTO city VALUES (3580,'Moscow','RUS','Moscow (City)',8389200);
INSERT INTO city VALUES (3791,'Tallinn','EST','Harjumaa',403981);


CREATE TABLE countrylanguage (
  CountryCode varchar(3) NOT NULL,
  Language varchar(30) NOT NULL,
  IsOfficial varchar(1) DEFAULT 'F' NOT NULL,
  Percentage decimal(4,1),
  CONSTRAINT CL_PK PRIMARY KEY (CountryCode,Language),
  CONSTRAINT countryLanguage_ibfk_1 FOREIGN KEY (CountryCode) REFERENCES country (Code)
);

INSERT INTO countrylanguage VALUES ('ALB','Albaniana','T',97.9);
INSERT INTO countrylanguage VALUES ('ALB','Greek','F',1.8);
INSERT INTO countrylanguage VALUES ('ALB','Macedonian','F',0.1);
INSERT INTO countrylanguage VALUES ('AND','Catalan','T',32.3);
INSERT INTO countrylanguage VALUES ('AND','French','F',6.2);
INSERT INTO countrylanguage VALUES ('AND','Portuguese','F',10.8);
INSERT INTO countrylanguage VALUES ('AND','Spanish','F',44.6);
INSERT INTO countrylanguage VALUES ('AUT','Czech','F',0.2);
INSERT INTO countrylanguage VALUES ('AUT','German','T',92.0);
INSERT INTO countrylanguage VALUES ('AUT','Hungarian','F',0.4);
INSERT INTO countrylanguage VALUES ('AUT','Polish','F',0.2);
INSERT INTO countrylanguage VALUES ('AUT','Romanian','F',0.2);
INSERT INTO countrylanguage VALUES ('AUT','Serbo-Croatian','F',2.2);
INSERT INTO countrylanguage VALUES ('AUT','Slovene','F',0.4);
INSERT INTO countrylanguage VALUES ('AUT','Turkish','F',1.5);
INSERT INTO countrylanguage VALUES ('BEL','Arabic','F',1.6);
INSERT INTO countrylanguage VALUES ('BEL','Dutch','T',59.2);
INSERT INTO countrylanguage VALUES ('BEL','French','T',32.6);
INSERT INTO countrylanguage VALUES ('BEL','German','T',1.0);
INSERT INTO countrylanguage VALUES ('BEL','Italian','F',2.4);
INSERT INTO countrylanguage VALUES ('BEL','Turkish','F',0.9);
INSERT INTO countrylanguage VALUES ('BGR','Bulgariana','T',83.2);
INSERT INTO countrylanguage VALUES ('BGR','Macedonian','F',2.6);
INSERT INTO countrylanguage VALUES ('BGR','Romani','F',3.7);
INSERT INTO countrylanguage VALUES ('BGR','Turkish','F',9.4);
INSERT INTO countrylanguage VALUES ('BIH','Serbo-Croatian','T',99.2);
INSERT INTO countrylanguage VALUES ('BLR','Belorussian','T',65.6);
INSERT INTO countrylanguage VALUES ('BLR','Polish','F',0.6);
INSERT INTO countrylanguage VALUES ('BLR','Russian','T',32.0);
INSERT INTO countrylanguage VALUES ('BLR','Ukrainian','F',1.3);
INSERT INTO countrylanguage VALUES ('CHE','French','T',19.2);
INSERT INTO countrylanguage VALUES ('CHE','German','T',63.6);
INSERT INTO countrylanguage VALUES ('CHE','Italian','T',7.7);
INSERT INTO countrylanguage VALUES ('CHE','Romansh','T',0.6);
INSERT INTO countrylanguage VALUES ('CZE','Czech','T',81.2);
INSERT INTO countrylanguage VALUES ('CZE','German','F',0.5);
INSERT INTO countrylanguage VALUES ('CZE','Hungarian','F',0.2);
INSERT INTO countrylanguage VALUES ('CZE','Moravian','F',12.9);
INSERT INTO countrylanguage VALUES ('CZE','Polish','F',0.6);
INSERT INTO countrylanguage VALUES ('CZE','Romani','F',0.3);
INSERT INTO countrylanguage VALUES ('CZE','Silesiana','F',0.4);
INSERT INTO countrylanguage VALUES ('CZE','Slovak','F',3.1);
INSERT INTO countrylanguage VALUES ('DEU','German','T',91.3);
INSERT INTO countrylanguage VALUES ('DEU','Greek','F',0.4);
INSERT INTO countrylanguage VALUES ('DEU','Italian','F',0.7);
INSERT INTO countrylanguage VALUES ('DEU','Polish','F',0.3);
INSERT INTO countrylanguage VALUES ('DEU','Southern Slavic Languages','F',1.4);
INSERT INTO countrylanguage VALUES ('DEU','Turkish','F',2.6);
INSERT INTO countrylanguage VALUES ('DNK','Arabic','F',0.7);
INSERT INTO countrylanguage VALUES ('DNK','Danish','T',93.5);
INSERT INTO countrylanguage VALUES ('DNK','English','F',0.3);
INSERT INTO countrylanguage VALUES ('DNK','German','F',0.5);
INSERT INTO countrylanguage VALUES ('DNK','Norwegian','F',0.3);
INSERT INTO countrylanguage VALUES ('DNK','Swedish','F',0.3);
INSERT INTO countrylanguage VALUES ('DNK','Turkish','F',0.8);
INSERT INTO countrylanguage VALUES ('ESP','Basque','F',1.6);
INSERT INTO countrylanguage VALUES ('ESP','Catalan','F',16.9);
INSERT INTO countrylanguage VALUES ('ESP','Galecian','F',6.4);
INSERT INTO countrylanguage VALUES ('ESP','Spanish','T',74.4);
INSERT INTO countrylanguage VALUES ('EST','Belorussian','F',1.4);
INSERT INTO countrylanguage VALUES ('EST','Estonian','T',65.3);
INSERT INTO countrylanguage VALUES ('EST','Finnish','F',0.7);
INSERT INTO countrylanguage VALUES ('EST','Russian','F',27.8);
INSERT INTO countrylanguage VALUES ('EST','Ukrainian','F',2.8);
INSERT INTO countrylanguage VALUES ('FIN','Estonian','F',0.2);
INSERT INTO countrylanguage VALUES ('FIN','Finnish','T',92.7);
INSERT INTO countrylanguage VALUES ('FIN','Russian','F',0.4);
INSERT INTO countrylanguage VALUES ('FIN','Saame','F',0.0);
INSERT INTO countrylanguage VALUES ('FIN','Swedish','T',5.7);
INSERT INTO countrylanguage VALUES ('FRA','Arabic','F',2.5);
INSERT INTO countrylanguage VALUES ('FRA','French','T',93.6);
INSERT INTO countrylanguage VALUES ('FRA','Italian','F',0.4);
INSERT INTO countrylanguage VALUES ('FRA','Portuguese','F',1.2);
INSERT INTO countrylanguage VALUES ('FRA','Spanish','F',0.4);
INSERT INTO countrylanguage VALUES ('FRA','Turkish','F',0.4);
INSERT INTO countrylanguage VALUES ('FRO','Danish','T',0.0);
INSERT INTO countrylanguage VALUES ('FRO','Faroese','T',100.0);
INSERT INTO countrylanguage VALUES ('GBR','English','T',97.3);
INSERT INTO countrylanguage VALUES ('GBR','Gaeli','F',0.1);
INSERT INTO countrylanguage VALUES ('GBR','Kymri','F',0.9);
INSERT INTO countrylanguage VALUES ('GIB','Arabic','F',7.4);
INSERT INTO countrylanguage VALUES ('GIB','English','T',88.9);
INSERT INTO countrylanguage VALUES ('GRC','Greek','T',98.5);
INSERT INTO countrylanguage VALUES ('GRC','Turkish','F',0.9);
INSERT INTO countrylanguage VALUES ('HRV','Serbo-Croatian','T',95.9);
INSERT INTO countrylanguage VALUES ('HRV','Slovene','F',0.0);
INSERT INTO countrylanguage VALUES ('HUN','German','F',0.4);
INSERT INTO countrylanguage VALUES ('HUN','Hungarian','T',98.5);
INSERT INTO countrylanguage VALUES ('HUN','Romani','F',0.5);
INSERT INTO countrylanguage VALUES ('HUN','Romanian','F',0.1);
INSERT INTO countrylanguage VALUES ('HUN','Serbo-Croatian','F',0.2);
INSERT INTO countrylanguage VALUES ('HUN','Slovak','F',0.1);
INSERT INTO countrylanguage VALUES ('IRL','English','T',98.4);
INSERT INTO countrylanguage VALUES ('IRL','Irish','T',1.6);
INSERT INTO countrylanguage VALUES ('ISL','English','F',0.0);
INSERT INTO countrylanguage VALUES ('ISL','Icelandic','T',95.7);
INSERT INTO countrylanguage VALUES ('ITA','Albaniana','F',0.2);
INSERT INTO countrylanguage VALUES ('ITA','French','F',0.5);
INSERT INTO countrylanguage VALUES ('ITA','Friuli','F',1.2);
INSERT INTO countrylanguage VALUES ('ITA','German','F',0.5);
INSERT INTO countrylanguage VALUES ('ITA','Italian','T',94.1);
INSERT INTO countrylanguage VALUES ('ITA','Romani','F',0.2);
INSERT INTO countrylanguage VALUES ('ITA','Sardinian','F',2.7);
INSERT INTO countrylanguage VALUES ('ITA','Slovene','F',0.2);
INSERT INTO countrylanguage VALUES ('LIE','German','T',89.0);
INSERT INTO countrylanguage VALUES ('LIE','Italian','F',2.5);
INSERT INTO countrylanguage VALUES ('LIE','Turkish','F',2.5);
INSERT INTO countrylanguage VALUES ('LTU','Belorussian','F',1.4);
INSERT INTO countrylanguage VALUES ('LTU','Lithuanian','T',81.6);
INSERT INTO countrylanguage VALUES ('LTU','Polish','F',7.0);
INSERT INTO countrylanguage VALUES ('LTU','Russian','F',8.1);
INSERT INTO countrylanguage VALUES ('LTU','Ukrainian','F',1.1);
INSERT INTO countrylanguage VALUES ('LUX','French','T',4.2);
INSERT INTO countrylanguage VALUES ('LUX','German','T',2.3);
INSERT INTO countrylanguage VALUES ('LUX','Italian','F',4.6);
INSERT INTO countrylanguage VALUES ('LUX','Luxembourgish','T',64.4);
INSERT INTO countrylanguage VALUES ('LUX','Portuguese','F',13.0);
INSERT INTO countrylanguage VALUES ('LVA','Belorussian','F',4.1);
INSERT INTO countrylanguage VALUES ('LVA','Latvian','T',55.1);
INSERT INTO countrylanguage VALUES ('LVA','Lithuanian','F',1.2);
INSERT INTO countrylanguage VALUES ('LVA','Polish','F',2.1);
INSERT INTO countrylanguage VALUES ('LVA','Russian','F',32.5);
INSERT INTO countrylanguage VALUES ('LVA','Ukrainian','F',2.9);
INSERT INTO countrylanguage VALUES ('MCO','English','F',6.5);
INSERT INTO countrylanguage VALUES ('MCO','French','T',41.9);
INSERT INTO countrylanguage VALUES ('MCO','Italian','F',16.1);
INSERT INTO countrylanguage VALUES ('MCO','Monegasque','F',16.1);
INSERT INTO countrylanguage VALUES ('MDA','Bulgariana','F',1.6);
INSERT INTO countrylanguage VALUES ('MDA','Gagauzi','F',3.2);
INSERT INTO countrylanguage VALUES ('MDA','Romanian','T',61.9);
INSERT INTO countrylanguage VALUES ('MDA','Russian','F',23.2);
INSERT INTO countrylanguage VALUES ('MDA','Ukrainian','F',8.6);
INSERT INTO countrylanguage VALUES ('MKD','Albaniana','F',22.9);
INSERT INTO countrylanguage VALUES ('MKD','Macedonian','T',66.5);
INSERT INTO countrylanguage VALUES ('MKD','Romani','F',2.3);
INSERT INTO countrylanguage VALUES ('MKD','Serbo-Croatian','F',2.0);
INSERT INTO countrylanguage VALUES ('MKD','Turkish','F',4.0);
INSERT INTO countrylanguage VALUES ('MLT','English','T',2.1);
INSERT INTO countrylanguage VALUES ('MLT','Maltese','T',95.8);
INSERT INTO countrylanguage VALUES ('NLD','Arabic','F',0.9);
INSERT INTO countrylanguage VALUES ('NLD','Dutch','T',95.6);
INSERT INTO countrylanguage VALUES ('NLD','Fries','F',3.7);
INSERT INTO countrylanguage VALUES ('NLD','Turkish','F',0.8);
INSERT INTO countrylanguage VALUES ('NOR','Danish','F',0.4);
INSERT INTO countrylanguage VALUES ('NOR','English','F',0.5);
INSERT INTO countrylanguage VALUES ('NOR','Norwegian','T',96.6);
INSERT INTO countrylanguage VALUES ('NOR','Saame','F',0.0);
INSERT INTO countrylanguage VALUES ('NOR','Swedish','F',0.3);
INSERT INTO countrylanguage VALUES ('POL','Belorussian','F',0.5);
INSERT INTO countrylanguage VALUES ('POL','German','F',1.3);
INSERT INTO countrylanguage VALUES ('POL','Polish','T',97.6);
INSERT INTO countrylanguage VALUES ('POL','Ukrainian','F',0.6);
INSERT INTO countrylanguage VALUES ('PRT','Portuguese','T',99.0);
INSERT INTO countrylanguage VALUES ('ROM','German','F',0.4);
INSERT INTO countrylanguage VALUES ('ROM','Hungarian','F',7.2);
INSERT INTO countrylanguage VALUES ('ROM','Romani','T',0.7);
INSERT INTO countrylanguage VALUES ('ROM','Romanian','T',90.7);
INSERT INTO countrylanguage VALUES ('ROM','Serbo-Croatian','F',0.1);
INSERT INTO countrylanguage VALUES ('ROM','Ukrainian','F',0.3);
INSERT INTO countrylanguage VALUES ('RUS','Avarian','F',0.4);
INSERT INTO countrylanguage VALUES ('RUS','Bashkir','F',0.7);
INSERT INTO countrylanguage VALUES ('RUS','Belorussian','F',0.3);
INSERT INTO countrylanguage VALUES ('RUS','Chechen','F',0.6);
INSERT INTO countrylanguage VALUES ('RUS','Chuvash','F',0.9);
INSERT INTO countrylanguage VALUES ('RUS','Kazakh','F',0.4);
INSERT INTO countrylanguage VALUES ('RUS','Mari','F',0.4);
INSERT INTO countrylanguage VALUES ('RUS','Mordva','F',0.5);
INSERT INTO countrylanguage VALUES ('RUS','Russian','T',86.6);
INSERT INTO countrylanguage VALUES ('RUS','Tatar','F',3.2);
INSERT INTO countrylanguage VALUES ('RUS','Udmur','F',0.3);
INSERT INTO countrylanguage VALUES ('RUS','Ukrainian','F',1.3);
INSERT INTO countrylanguage VALUES ('SJM','Norwegian','T',0.0);
INSERT INTO countrylanguage VALUES ('SJM','Russian','F',0.0);
INSERT INTO countrylanguage VALUES ('SMR','Italian','T',100.0);
INSERT INTO countrylanguage VALUES ('SVK','Czech and Moravian','F',1.1);
INSERT INTO countrylanguage VALUES ('SVK','Hungarian','F',10.5);
INSERT INTO countrylanguage VALUES ('SVK','Romani','F',1.7);
INSERT INTO countrylanguage VALUES ('SVK','Slovak','T',85.6);
INSERT INTO countrylanguage VALUES ('SVK','Ukrainian and Russian','F',0.6);
INSERT INTO countrylanguage VALUES ('SVN','Hungarian','F',0.5);
INSERT INTO countrylanguage VALUES ('SVN','Serbo-Croatian','F',7.9);
INSERT INTO countrylanguage VALUES ('SVN','Slovene','T',87.9);
INSERT INTO countrylanguage VALUES ('SWE','Arabic','F',0.8);
INSERT INTO countrylanguage VALUES ('SWE','Finnish','F',2.4);
INSERT INTO countrylanguage VALUES ('SWE','Norwegian','F',0.5);
INSERT INTO countrylanguage VALUES ('SWE','Southern Slavic Languages','F',1.3);
INSERT INTO countrylanguage VALUES ('SWE','Spanish','F',0.6);
INSERT INTO countrylanguage VALUES ('SWE','Swedish','T',89.5);
INSERT INTO countrylanguage VALUES ('UKR','Belorussian','F',0.3);
INSERT INTO countrylanguage VALUES ('UKR','Bulgariana','F',0.3);
INSERT INTO countrylanguage VALUES ('UKR','Hungarian','F',0.3);
INSERT INTO countrylanguage VALUES ('UKR','Polish','F',0.1);
INSERT INTO countrylanguage VALUES ('UKR','Romanian','F',0.7);
INSERT INTO countrylanguage VALUES ('UKR','Russian','F',32.9);
INSERT INTO countrylanguage VALUES ('UKR','Ukrainian','T',64.7);
INSERT INTO countrylanguage VALUES ('VAT','Italian','T',0.0);
INSERT INTO countrylanguage VALUES ('YUG','Albaniana','F',16.5);
INSERT INTO countrylanguage VALUES ('YUG','Hungarian','F',3.4);
INSERT INTO countrylanguage VALUES ('YUG','Macedonian','F',0.5);
INSERT INTO countrylanguage VALUES ('YUG','Romani','F',1.4);
INSERT INTO countrylanguage VALUES ('YUG','Serbo-Croatian','T',75.2);
INSERT INTO countrylanguage VALUES ('YUG','Slovak','F',0.7);
