-- 10. For all people born before 1950 and have a home page, add the home page to the end of their biography. (142 rows)
-- Note: Assume all biographies end in a period with no trailing spaces. You'll need to also add a space before the website address.
-- JOIN person ON person.person_id =movie_actor.movie_id
-- JOIN movie ON movie.movie_id=movie.actor_id;
UPDATE person
SET biography = CONCAT(biography, ' ', home_page)
WHERE birthday < '19500101' AND home_page IS NOT NULL;


