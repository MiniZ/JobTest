INSERT INTO User(user_name, hashed_password, first_name, last_name)
	VALUES ("user1", "b3daa77b4c04a9551b8781d03191fe098f325e67", "Anano", "Bodokia");
INSERT INTO User(user_name, hashed_password, first_name, last_name)
	VALUES ("user2", "a1881c06eec96db9901c7bbfe41c42a3f08e9cb4", "Thom", "Yorke");
INSERT INTO User(user_name, hashed_password, first_name, last_name)
	VALUES ("user3", "0b7f849446d3383546d15a480966084442cd2193", "Sean", "Penn");

INSERT INTO Admins (user_name)
	VALUES ("user3");

INSERT INTO Entry(user_name, submission_date,  movie_name, entry_type)
	VALUES ("user1", NOW(),  "Hunger Games", "ჯავშანი");
INSERT INTO Entry(user_name, submission_date,  movie_name, entry_type)
	VALUES ("user2", NOW(),  "ცელქი ბავშვები 2", "სეანსები");
INSERT INTO Entry(user_name, submission_date,  movie_name, entry_type)
	VALUES ("user2", NOW(),  "ცელქი ბავშვები", "სხვა");
INSERT INTO Entry(user_name, submission_date,  movie_name, entry_type)
	VALUES ("user1", NOW(),  "ცელქი ბავშვები", "ჯავშანი");
INSERT INTO Entry(user_name, submission_date,  movie_name, entry_type)
	VALUES ("user1", NOW(),  "ცელქი ბავშვები", "ჯავშანი");
INSERT INTO Entry(user_name, submission_date,  movie_name, entry_type)
	VALUES ("user1", NOW(),  "Hobbit", "ჯავშანი");
INSERT INTO Entry(user_name, submission_date,  movie_name, entry_type)
	VALUES ("user1", NOW(),  "Hobbit", "სეანსები");
INSERT INTO Entry(user_name, submission_date,  movie_name, entry_type)
	VALUES ("user2", NOW(),  "ყინულის დედოფალი", "სხვა");
INSERT INTO Entry(user_name, submission_date,  movie_name, entry_type)
	VALUES ("user1", NOW(),  "ყინულის დედოფალი", "ჯავშანი");
INSERT INTO Entry(user_name, submission_date,  movie_name, entry_type)
	VALUES ("user2", NOW(),  "ყინულის დედოფალი", "სეანსები");











