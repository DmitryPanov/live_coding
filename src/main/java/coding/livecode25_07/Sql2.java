package coding.livecode25_07;

public class Sql2 {
    /*
    * Input:
ActorDirector table:
+-------------+-------------+-------------+
| actor_id    | director_id | timestamp   |
+-------------+-------------+-------------+
| 1           | 1           | 0           |
| 1           | 1           | 1           |
| 1           | 1           | 2           |
| 1           | 2           | 3           |
| 1           | 2           | 4           |
| 2           | 1           | 5           |
| 2           | 1           | 6           |
+-------------+-------------+-------------+
*
* Найдите все пары (actor_id, Director_id), в которых актер сотрудничал с режиссером не менее трех раз.


Output:
+-------------+-------------+
| actor_id    | director_id |
+-------------+-------------+
| 1           | 1           |
+-------------+-------------+
*
* Select actor_id, director_id From ActorDirector GROUP BY actor_id, director_id HAVING count(timestamp) > 2;
    *
    * */
}
