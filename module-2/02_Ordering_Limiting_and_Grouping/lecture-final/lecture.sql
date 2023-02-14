-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT state_name, population
FROM state
ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. 
-- The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT state_name, census_region
FROM state
ORDER BY census_region DESC, state_name ASC;


-- The biggest park by area
SELECT park_name
FROM park
ORDER BY area DESC;


-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name, population
FROM city
ORDER BY population DESC
LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT park_name, date_established
FROM park
ORDER BY date_established ASC, park_name ASC
LIMIT 20;

-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT 'hello ' || 'world';

SELECT  city_name || ' ' || state_abbreviation AS city_state
FROM city
ORDER BY city_name;

-- All parks and date_established by name and date established.
SELECT park_name || ' ' || date_established AS park_birthday
FROM park
ORDER by park_birthday;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT state_name || ' ' || census_region
FROM state
WHERE census_region IN ('West', 'Midwest')
ORDER BY state_name DESC
LIMIT 10;



-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) AS avg_population
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) as total_population
FROM state
WHERE census_region IN ('West', 'South');

-- The number of cities with populations greater than 1 million
SELECT COUNT(population) AS num_cities
FROM city
WHERE population > 1000000;

-- The number of state nicknames.
SELECT COUNT(state_nickname) AS num_nicknames, COUNT(*) AS total_rows
FROM state;

SELECT COUNT(*)
FROM state
WHERE state_nickname IS NOT NULL;

-- The area of the smallest and largest parks.
SELECT 
	MIN(area) AS smallest_area
	, MAX(area) AS largest_area
FROM park;

-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.

SELECT state_abbreviation, city_name
FROM city
WHERE city.state_abbreviation IN ('CA', 'TX')
ORDER BY city.state_abbreviation;

SELECT state_abbreviation, COUNT(*) AS city_count, SUM(area) AS total_area
FROM city
GROUP BY state_abbreviation
ORDER BY city_count DESC;


-- Determine the average park area depending upon whether parks allow camping or not.
SELECT AVG(area), has_camping
FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population) AS total_population
FROM city
GROUP BY state_abbreviation;

SELECT SUBSTRING(city_name, 1,1) AS first, state_abbreviation, SUM(population) AS total_population
FROM city
GROUP BY state_abbreviation, SUBSTRING(city_name, 1, 1) 
ORDER BY state_abbreviation, first;

-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS smallest
FROM city
GROUP BY state_abbreviation
ORDER by smallest ASC

-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)

SELECT 
	city_name
	, population
FROM city
ORDER BY population DESC
OFFSET 30 FETCH NEXT 10 ROWS ONLY;

-- SUBQUERIES (optional) - using a query as an expression
-- single row / single column 
-- multi row / single column
-- multi row / multi column

-- The 20 oldest parks, sorted alphabetically by name.
-- (multi-row / multi-column)
SELECT park_name
FROM ( -- (multi-row / multi-column) subquery
	SELECT park_name, date_established
	FROM park
	ORDER BY date_established ASC
	LIMIT 20
	) AS oldest_parks
ORDER BY park_name;

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
-- (single row / single column )
-- outer query
SELECT COUNT(*) AS num_cities,
	-- inner query
	(SELECT state_name FROM state WHERE state.state_abbreviation = c.state_abbreviation) AS state_name
FROM city AS c
GROUP BY state_abbreviation;

-- all the cities that are within the midwest region
-- (single-column / multi-row)
SELECT city_name
FROM city
WHERE state_abbreviation IN (
	SELECT state_abbreviation
	FROM state
	WHERE census_region = 'Midwest'
	);

-- list the parks whose area is less than the average of all parks

SELECT park_name
FROM park
WHERE area < (SELECT AVG(area) FROM park);


SELECT *
FROM park
LIMIT (SELECT 10);




-- Include the names of the smallest and largest parks


-- List the capital cities for the states in the Northeast census region.

