-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985.
-- Order the results by actor from oldest to youngest.
-- (20 rows)
SELECT DISTINCT person_name, birthday
FROM person
JOIN movie_actor ON movie_actor.actor_id = person.person_id
JOIN movie ON movie.movie_id = movie_actor.movie_id
WHERE birthday >= '19500101' AND birthday < '19600101' AND release_date >= '19850101' AND release_date < '19860101'
ORDER BY birthday;
