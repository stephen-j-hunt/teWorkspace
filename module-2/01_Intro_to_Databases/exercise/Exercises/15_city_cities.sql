-- 15. The name, state abbreviation, and population for cities that end with the word "City" (11 rows)
SELECT state_abbreviation, population, city_name
FROM city
WHERE city_name LIKE '%City';
