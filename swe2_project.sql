create database swe2_project;


CREATE TABLE brand (
  id int NOT NULL primary key,
  category varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL
);

-- --------------------------------------------------------

--


-- --------------------------------------------------------

--
-- Table structure for table `explored_product`
--

CREATE TABLE explored_product (
  id int NOT NULL primary key,
  username varchar(255) NOT NULL,
  productid int NOT NULL,
  constraint foreign key (username) references user(username),
  constraint foreign key (productid) references product(id)
);
-- --------------------------------------------------------

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE product (
  id int NOT NULL primary key,
  brand_id int NOT NULL,
  category varchar(255) DEFAULT NULL,
  in_stock bool NOT NULL,
  name varchar(255) DEFAULT NULL,
  price double NOT NULL,
  price_range varchar(255) DEFAULT NULL,
  constraint brand_id FOREIGN KEY (brand_id) REFERENCES brand(id)
);

-- --------------------------------------------------------


CREATE TABLE storeproducts (
  id INT NOT NULL primary key,
  storeID INT NOT NULL,
  username VARCHAR(255) NOT NULL,
  constraint foreign  KEY(storeID) references store(id),
  constraint FOREIGN KEY(username) references user(username)
);
  


--
-- Table structure for table `store`
--
  
CREATE TABLE store (
  id int NOT NULL primary key,
  accepted bool NOT NULL,
  location varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  owner_username varchar(255) DEFAULT NULL,
  type varchar(255) DEFAULT NULL,
  CONSTRAINT FOREIGN KEY (owner_username) REFERENCES user(username)
) ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE user (
  username varchar(255) NOT NULL primary key,
  email varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  type varchar(255) DEFAULT NULL
)





