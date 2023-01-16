CREATE DATABASE image;

USE image;

CREATE TABLE `image` (
  `id` int NOT NULL,
  `file_name` varchar(200) DEFAULT NULL,
  `image_type` varchar(80) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
