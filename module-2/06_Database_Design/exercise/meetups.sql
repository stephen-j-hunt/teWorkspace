BEGIN TRANSACTION;

DROP TABLE IF EXISTS event_attendees;
DROP TABLE IF EXISTS member_group;
DROP TABLE IF EXISTS events;
DROP TABLE IF EXISTS groups;
DROP TABLE IF EXISTS members;


CREATE TABLE members (
member_id SERIAL NOT NULL PRIMARY KEY
	, member_name VARCHAR(75) NOT NULL
	, email VARCHAR(75) NOT NULL
	, phone_number VARCHAR(20) NULL
	, date_of_birth DATE NOT NULL
	, reminder_emails BOOLEAN NOT NULL
);

CREATE TABLE groups (
	group_id SERIAL NOT NULL PRIMARY KEY
	, group_name VARCHAR(50) UNIQUE

);

CREATE TABLE member_group (
member_id INT NOT NULL 
	, group_id INT NOT NULL 
	
	, CONSTRAINT PK_member_group PRIMARY KEY (member_id, group_id)
	, CONSTRAINT FK_member_group_member_id FOREIGN KEY (member_id) REFERENCES members(member_id)
	, CONSTRAINT FK_member_group_group_id FOREIGN KEY (group_id) REFERENCES groups(group_id)
);

CREATE TABLE events (
event_id SERIAL NOT NULL PRIMARY KEY
	, destination VARCHAR(50) NOT NULL
	, date_time TIMESTAMP NOT NULL
	, duration_minutes INTEGER NOT NULL
	, group_id INT NOT NULL
	
	, CONSTRAINT FK_events_group_id FOREIGN KEY (group_id) REFERENCES groups(group_id)
);

CREATE TABLE event_attendees (
member_id INT NOT NULL 
	, event_id INT NOT NULL 
	
	, CONSTRAINT PK_event_attendees PRIMARY KEY (member_id, event_id)
	
	, CONSTRAINT FK_event_attendees_events FOREIGN KEY (event_id) REFERENCES events(event_id)
	, CONSTRAINT FK_event_attendees_members FOREIGN KEY (member_id) REFERENCES members(member_id)

);

ALTER TABLE events
	ADD CONSTRAINT ck_duration_minutes CHECK (duration_minutes > 30);

INSERT INTO members (member_name, email, phone_number, date_of_birth, reminder_emails)
VALUES ('Tom Smith', 'tomsmith@gmail.com', '123-456-7890','1960-01-01', true),
		('Mary Jenkins', 'maryjenkins@gmail.com', '345-456-1234','1960-02-02', true),
		('Stephen Hunt', 'stephenhunt@gmail.com', null,'1990-01-01', false),
		('Nicole Little', 'nicolelittle@gmail.com', null,'1992-01-01', true),
		('Manny Ramirez', 'mannyramirez.com', '508-345-7856','1965-01-01', false),
		('Bobby Hawkins', 'bobbyhawkins@gmail.com', '123-456-5463','1989-01-01', false),
		('Guy Short', 'guyshort@gmail.com', '123-546-7890','1987-01-01', true),
		('Jay Dewald', 'jaydewald@gmail.com', '678-456-7890','1998-01-01', false);
	-- SELECT * FROM members;
	
	INSERT INTO groups (group_name)
	VALUES ('Celtics Group')
	, ('Amusement Park Group')
	, ('City Tour Group');


INSERT INTO events (destination, date_time, duration_minutes, group_id)
VALUES ('Disney World', '2020-01-01 10:30:00', 100, (SELECT group_id FROM groups where group_name = 'Amusement Park Group'))
	, ('Cedar Point', '2020-06-01 08:00:00', 300, (SELECT group_id FROM groups where group_name = 'Amusement Park Group'))
	, ('TD Garden', '2021-05-25 19:30:00', 150 , (SELECT group_id FROM groups where group_name = 'Celtics Group'))
	, ('Chicago', '2023-10-15 17:00:00', 300 , (SELECT group_id FROM groups where group_name = 'City Tour Group'));
	
	
	INSERT INTO member_group (member_id, group_id)
	VALUES		 ((SELECT member_id FROM members WHERE member_name = 'Tom Smith'), (SELECT group_id FROM groups WHERE group_name = 'Celtics Group' ))
				, ((SELECT member_id FROM members WHERE member_name = 'Nicole Little'), (SELECT group_id FROM groups WHERE group_name = 'Celtics Group' ))
				, ((SELECT member_id FROM members WHERE member_name = 'Bobby Hawkins'), (SELECT group_id FROM groups WHERE group_name = 'City Tour Group' ))
				, ((SELECT member_id FROM members WHERE member_name = 'Guy Short'), (SELECT group_id FROM groups WHERE group_name = 'City Tour Group' ))
				, ((SELECT member_id FROM members WHERE member_name = 'Manny Ramirez'), (SELECT group_id FROM groups WHERE group_name = 'Amusement Park Group' ))
				, ((SELECT member_id FROM members WHERE member_name = 'Stephen Hunt'), (SELECT group_id FROM groups WHERE group_name = 'Amusement Park Group' ));
	--SELECT * FROM members
INSERT INTO event_attendees (member_id, event_id)
VALUES ((SELECT member_id FROM members WHERE member_id = 1), (SELECT event_id from events WHERE event_id = 3))
	  , ((SELECT member_id FROM members WHERE member_id = 3), (SELECT event_id from events WHERE event_id = 4))
	  , ((SELECT member_id FROM members WHERE member_id = 5), (SELECT event_id from events WHERE event_id = 2));
	--SELECT * FROM event_attendees
	
	

	
	
	
-- ROLLBACK; 	
COMMIT;	