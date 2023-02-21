-- 12. Create a "Bill Murray Collection" in the collection table. For the movies that have Bill Murray in them, set their collection ID to the "Bill Murray Collection". (1 row, 6 rows)

UPDATE movie
SET collection_id = (SELECT collection.collection_id FROM collection )
SELECT  movie_id 
FROM movie_actor
JOIN person ON person.person_id = movie_actor.actor_id WHERE person_name = 'Bill Murray'
SELECT person_id
FROM person 
WHERE person_name = 'Bill Murray'




INSERT INTO collection (collection_name)
VALUES ('Bill Murray Collection');
UPDATE movie
SET collection_id= (SELECT collection_id FROM collection WHERE collection_name= 'Bill Murray' limit 1)
FROM movie_actor
WHERE movie_actor.movie_id = movie.movie_id AND movie_actor.actor_id=(SELECT person_id FROM person WHERE person_name ='Bill Murray' limit 1);
-- 
-- SELECT * FROM collection
-- ORDER BY collection_name;