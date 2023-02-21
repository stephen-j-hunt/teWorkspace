DROP TABLE IF EXISTS member_group;
DROP TABLE IF EXISTS event_attendees;
DROP TABLE IF EXISTS events;
DROP TABLE IF EXISTS members;
DROP TABLE IF EXISTS groups;



CREATE TABLE members (
member_id SERIAL NOT NULL PRIMARY KEY
	, last_name VARCHAR(50) NOT NULL
	, first_name VARCHAR(50) NOT NULL
	, email VARCHAR(75) NOT NULL
	, phone_number VARCHAR(20) NULL
	, date_of_birth DATE NOT NULL
	, reminder_emails BOOLEAN NOT NULL
);

CREATE TABLE groups (
	group_id SERIAL PRIMARY KEY
	, group_name VARCHAR(50) UNIQUE
);

CREATE TABLE member_group (
member_id INT NOT NULL 
	, group_id INT NOT NULL 
	
	, CONSTRAINT PK_member_group PRIMARY KEY (member_id)
	, CONSTRAINT PK_member_group PRIMARY KEY (group_id)
	, CONSTRAINT FK_member_group_members FOREIGN KEY (member_id) REFERENCES members(member_id)
	, CONSTRAINT FK_member_group_id FOREIGN KEY (group_id) REFERENCES groups(group_id)
);

CREATE TABLE events (
event_id SERIAL NOT NULL PRIMARY KEY
	, destination VARCHAR(50) NOT NULL
	, date_time TIMESTAMP NOT NULL
	, duration DECIMAL NOT NULL
	, group_id INT NOT NULL
	
	, CONSTRAINT FK_events_groups FOREIGN KEY (group_id) REFERENCES groups(group_id)
);

CREATE TABLE event_attendees (
member_id INT NOT NULL 
	, event_id INT NOT NULL 
	
	, CONSTRAINT PK_event_attendees PRIMARY KEY (member_id)
	--, CONSTRAINT PK_event_attendees PRIMARY KEY (event_id)
	, CONSTRAINT FK_event_attendees_events FOREIGN KEY (event_id) REFERENCES events(event_id)
	, CONSTRAINT FK_event_attendees_members FOREIGN KEY (member_id) REFERENCES members(member_id)

);

INSERT INTO members (last_name, first_name, email, phone_number, date_of_birth, reminder_emails)
VALUES ('Smith', 'Tom', 'tomsmith@gmail.com', '123-456-7890','1960-01-01', true),
		('Jenkins', 'Mary', 'maryjenkins@gmail.com', '345-456-1234','1960-02-02', true),
		('Hunt', 'Stephen', 'stephenhunt@gmail.com', null,'1990-01-01', false),
		('Little', 'Nicole', 'nicolelittle@gmail.com', null,'1992-01-01', true),
		('Ramirez', 'Manny', 'mannyramirez.com', '508-345-7856','1965-01-01', false),
		('Hawkins', 'Bobby', 'bobbyhawkins@gmail.com', '123-456-5463','1989-01-01', false),
		('Short', 'Guy', 'guyshort@gmail.com', '123-546-7890','1987-01-01', true),
		('Dewald', 'Jay', 'jaydewald@gmail.com', '678-456-7890','1998-01-01', false);
	  --SELECT * FROM members;

INSERT INTO events (destination, date_time, duration)
	VALUES ('Disney', '2020-01-01 10:30:00', '100.0' );
	SELECT * FROM events;
	
	
	
	
	