UPDATE movie m 
	SET collection_id = 
		(SELECT c.collection_id 
		 FROM collection c 
		 WHERE c.collection_name = 'Bill Murray Collection') 
FROM movie_actor ma 
WHERE ma.movie_id = m.movie_id 
	AND ma.actor_id = (SELECT person_id 
					   FROM person 
					   WHERE person_name = 'Bill Murray');
					   

UPDATE movie m 
	SET collection_id = 
		(SELECT c.collection_id 
		 FROM collection c 
		 WHERE c.collection_name = 'Bill Murray Collection') 
WHERE movie_id IN (
SELECT movie_id
FROM movie_actor ma
	INNER JOIN person p ON p.person_id = ma.actor_id
WHERE person_name = 'Bill Murray')


					   
					   
