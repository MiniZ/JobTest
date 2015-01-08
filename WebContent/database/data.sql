DROP DATABASE IF EXISTS operator_db;
CREATE DATABASE operator_db;
USE operator_db;

CREATE TABLE IF NOT EXISTS User (
	user_name CHAR(64) NOT NULL PRIMARY KEY UNIQUE,
	hashed_password CHAR(64) NOT NULL,
	first_name NCHAR(32),
	last_name NCHAR(32)
);

CREATE TABLE IF NOT EXISTS Entry (
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
	user_name CHAR(64),
	submission_date DATETIME,
	movie_name CHAR(32),
	entry_type CHAR(32),
	FOREIGN KEY (user_name) REFERENCES User(user_name) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Admins (
	user_name CHAR(64) UNIQUE,
	FOREIGN KEY (user_name) REFERENCES User(user_name) ON DELETE CASCADE
)