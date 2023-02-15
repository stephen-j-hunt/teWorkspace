
SELECT city_name, population
FROM city
WHERE population IN (
	(SELECT MIN(population) FROM city),
	(SELECT MAX(population) FROM city)
);

SELECT city_name, population,
	RANK() OVER (ORDER BY population)
FROM city;

SELECT state_abbreviation, city_name, population,
	RANK() OVER (PARTITION BY state_abbreviation ORDER BY population)
FROM city;

-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database
SELECT city_name, state_abbreviation
FROM city
WHERE city_name = 'Columbus';

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
SELECT city_name, state_abbreviation,
	(SELECT state_name FROM state WHERE state_abbreviation = city.state_abbreviation) AS state_name
FROM city
WHERE city_name = 'Columbus';

SELECT city_name, city.state_abbreviation, state.state_abbreviation, state_name
FROM city
	INNER JOIN state ON state.state_abbreviation = city.state_abbreviation
WHERE city_name = 'Columbus';

-- "INNER" is optional
SELECT city_name, city.state_abbreviation, state.state_abbreviation, state_name
FROM city
	JOIN state ON state.state_abbreviation = city.state_abbreviation
WHERE city_name = 'Columbus';

-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT park_name, state_abbreviation
FROM park
	INNER JOIN park_state ON park.park_id = park_state.park_id

-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT park_name, state_name, state.state_abbreviation AS state_abv
FROM park
	INNER JOIN park_state ON park.park_id = park_state.park_id
	INNER JOIN state ON state.state_abbreviation = park_state.state_abbreviation;

-- ... alias the table with AS
SELECT park_name, state_name, s.state_abbreviation AS state_abv
FROM park AS p
	INNER JOIN park_state AS ps ON p.park_id = ps.park_id
	INNER JOIN state AS s ON s.state_abbreviation = ps.state_abbreviation;

-- ... alias the table w/o AS
SELECT park_name, state_name, s.state_abbreviation AS state_abv
FROM park p
	INNER JOIN park_state ps ON p.park_id = ps.park_id
	INNER JOIN state s ON s.state_abbreviation = ps.state_abbreviation;

-- Modify the previous query to include the name of the state's capital city.
SELECT park_name, state_name, s.state_abbreviation AS state_abv, c.city_name AS capital
FROM park p
	INNER JOIN park_state ps ON p.park_id = ps.park_id
	INNER JOIN state s ON s.state_abbreviation = ps.state_abbreviation
	INNER JOIN city c ON s.capital = c.city_id;
	
SELECT * FROM state;

-- Modify the previous query to include the area of each park.
SELECT park_name, state_name, s.state_abbreviation AS state_abv, 
		c.city_name AS capital, p.area AS park_area
FROM park p
	INNER JOIN park_state ps ON p.park_id = ps.park_id
	INNER JOIN state s ON s.state_abbreviation = ps.state_abbreviation
	INNER JOIN city c ON s.capital = c.city_id;


-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
SELECT city_name, city.population
FROM city
	INNER JOIN state ON state.state_abbreviation = city.state_abbreviation
WHERE census_region = 'Midwest';

-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.
SELECT state_name, COUNT(city_name) AS numCities
FROM city
	INNER JOIN state ON state.state_abbreviation = city.state_abbreviation
WHERE census_region = 'Midwest'
GROUP BY state_name;


-- Modify the previous query to sort the results by the number of cities in descending order.
SELECT state_name, COUNT(city_name) AS numCities
FROM city
	INNER JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE census_region = 'Midwest'
GROUP BY state_name
ORDER BY numCities DESC;



-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was 
-- established in that state (or territory) for every record in the state table 
-- that has park records associated with it.
SELECT state_name, MIN(date_established)
FROM state
	INNER JOIN park_state ON state.state_abbreviation = park_state.state_abbreviation
	INNER JOIN park ON park.park_id = park_state.park_id
GROUP BY state_name;

SELECT COUNT(*) FROM state;

-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.
SELECT state_name, MIN(date_established)
FROM state
	LEFT JOIN park_state ON state.state_abbreviation = park_state.state_abbreviation
	LEFT JOIN park ON park.park_id = park_state.park_id
GROUP BY state_name;


-- UNION

SELECT *
FROM park 
	INNER JOIN park_state ON park_state.park_id = park.park_id
	INNER JOIN state ON state.state_abbreviation = park_state.state_abbreviation;
	

-- Write a query to retrieve all the place names in the city 
-- and state tables that begin with "W" sorted alphabetically. 
-- (Washington is the name of a city and a state--how many times does it appear in the results?)
-- ... duplicates are removed
SELECT city_name AS place_name
FROM city
WHERE city_name LIKE 'W%'
UNION
SELECT state_name
FROM state
WHERE state_name LIKE 'W%'
ORDER BY place_name;

-- ... keep duplicates
SELECT city_name AS place_name
FROM city
WHERE city_name LIKE 'W%'
UNION ALL
SELECT state_name
FROM state
WHERE state_name LIKE 'W%'
ORDER BY place_name;

-- Modify the previous query to include a column that indicates whether the place is a city or state.
SELECT city_name AS place_name, 'C' as source
FROM city
WHERE city_name LIKE 'W%'
UNION
SELECT state_name, 'S'
FROM state
WHERE state_name LIKE 'W%'
ORDER BY place_name;



-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in pgAdmin and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres


-- The titles of all the Comedy movies

