-- INSERT

-- Add Disneyland to the park table. (It was established on 7/17/1955, has an area of 2.1 square 
-- kilometers and does not offer camping.)
SELECT * FROM park ORDER BY park_id DESC;

SELECT nextval('park_park_id_seq');

INSERT INTO park (park_name, date_established, area, has_camping)
VALUES ('Disneyland', '19550717', 2.1, false);

-- Add Hawkins, IN (with a population of 30,000 and an area of 38.1 square kilometers) 
-- and Cicely, AK (with a popuation of 839 and an area of 11.4 square kilometers) to the city table.
SELECT * FROM city ORDER BY city_id DESC;

INSERT INTO city (city_name, state_abbreviation, population, area)
VALUES ('Hawkins', 'IN', 30000, 38.1),
	('Cicely', 'AK', 839, 11.4);
	
-- Since Disneyland is in California (CA), add a record representing that to the park_state table.
SELECT * FROM park ORDER BY park_id DESC;
SELECT * FROM park_state WHERE state_abbreviation = 'CA';

INSERT INTO park_state (park_id, state_abbreviation)
SELECT park_id, 'CA' 
FROM park 
WHERE park_name = 'Disneyland'

INSERT INTO park (park_name, date_established, area, has_camping)
VALUES ('mikeland', '20230216', 0.1, true) RETURNING park_id; 

SELECT * FROM park WHERE park_id = 68;
 
-- UPDATE

-- Change the state nickname of California to "The Happiest Place on Earth."
SELECT * FROM state WHERE state_abbreviation = 'CA';

UPDATE state
SET state_nickname = 'The Happiest Place on Earth.'
WHERE state_abbreviation = 'CA';

-- Increase the population of California by 1,000,000.
UPDATE state
SET population = population + 1000000
WHERE state_abbreviation = 'CA';

-- Change the capital of California to Anaheim.
UPDATE state
SET capital = (SELECT city_id FROM city WHERE city_name = 'Anaheim' AND state_abbreviation = 'CA')
WHERE state_abbreviation = 'CA';

-- Change California's nickname back to "The Golden State", 
-- reduce the population by 1,000,000, 
-- and change the capital back to Sacramento.
UPDATE state
	SET state_nickname = 'The golden state',
		population = population - 1000000,
		capital = (SELECT city_id FROM city WHERE city_name = 'Sacramento' AND state_abbreviation = 'CA')
WHERE state_abbreviation = 'CA';


-- DELETE

-- Delete Hawkins, IN from the city table.
SELECT * FROM city WHERE city_name = 'Hawkins';

DELETE FROM city
WHERE city_name = 'Hawkins' AND state_abbreviation = 'IN';


-- Delete all cities with a population of less than 1,000 people from the city table.
SELECT * FROM city WHERE population < 1000;

DELETE FROM city
WHERE population < 1000;

-- REFERENTIAL INTEGRITY

-- Try adding a city to the city table with "XX" as the state abbreviation.
-- WILL NOT WORK! violates FK constraint
SELECT * FROM city
INSERT INTO city (city_name, state_abbreviation, population, area)
VALUES ('n/a', 'XX', 0, 0);

-- Try deleting California from the state table.
DELETE FROM state
WHERE state_abbreviation = 'CA';


-- Try deleting Disneyland from the park table. Try again after deleting its record from the park_state table.

DELETE FROM park_state WHERE park_id = (SELECT park_id FROM park WHERE park_name = 'Disneyland');
DELETE FROM park WHERE park_name = 'Disneyland';



-- CONSTRAINTS
INSERT INTO city (city_id, city_name, state_abbreviation, population, area)
VALUES (1, 'n/a', 'XX', 0, 0);

-- NOT NULL constraint
-- Try adding Smallville, KS to the city table without specifying its population or area.
INSERT INTO city (city_name, state_abbreviation)
VALUES ('Smallville', 'KS');

INSERT INTO city (city_name, state_abbreviation, population, area)
VALUES ('Smallville', 'KS', null, null);

-- DEFAULT constraint
-- Try adding Smallville, KS again, specifying an area but not a population.
INSERT INTO city (city_name, state_abbreviation, area)
VALUES ('Smallville', 'KS', 0.1);

-- Retrieve the new record to confirm it has been given a default, non-null value for population.
SELECT * FROM city ORDER BY city_id DESC

-- UNIQUE constraint
-- Try changing California's nickname to "Vacationland" (which is already the nickname of Maine).
SELECT * FROM state 
WHERE state_abbreviation IN ('ME', 'CA');

UPDATE state 
SET state_nickname = 'Vacationland'
WHERE state_abbreviation = 'CA';

-- CHECK constraint
-- Try changing the census region of Florida (FL) to "Southeast" (which is not a valid census region).
UPDATE state
	SET census_region = 'Southeast'
WHERE state_abbreviation = 'FL';



-- TRANSACTIONS

-- Delete the record for Smallville, KS within a transaction.
SELECT * FROM city WHERE city_name = 'Smallville';

BEGIN TRANSACTION;
DELETE FROM city WHERE city_name = 'Smallville';
COMMIT;

-- Delete all of the records from the park_state table, but then "undo" the deletion by rolling back the transaction.
SELECT COUNT(*) FROM park_state

BEGIN TRANSACTION;
DELETE FROM park_state;
ROLLBACK;

-- Update all of the cities to be in the state of Texas (TX), but then roll back the transaction.


-- Demonstrate two different SQL connections trying to access the same table where one is inside of a transaction but hasn't committed yet.
SELECT COUNT(*) FROM park_state
BEGIN TRANSACTION;
DELETE FROM park_state;
COMMIT;

ROLLBACK;

