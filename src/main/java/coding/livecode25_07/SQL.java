package coding.livecode25_07;

public class SQL {
    /*
    * Input:
Cinema table:
+----+------------+-------------+--------+
| id | movie      | description | rating |
+----+------------+-------------+--------+
| 1  | War        | great 3D    | 8.9    |
| 2  | Science    | fiction     | 8.5    |
| 3  | irish      | boring      | 6.2    |
| 4  | Ice song   | Fantacy     | 8.6    |
| 5  | House card | Interesting | 9.1    |
+----+------------+-------------+--------+
*
* Напишите SQL-запрос, чтобы сообщить о фильмах с нечетным идентификатором и описанием,
* которое не является «скучным»
*
* Output:
+----+------------+-------------+--------+
| id | movie      | description | rating |
+----+------------+-------------+--------+
| 5  | House card | Interesting | 9.1    |
| 1  | War        | great 3D    | 8.9    |
+----+------------+-------------+--------+
    *
    * Select * From Cinema WHERE description != 'boring' AND (id % 2 != 0) ORDER BY rating DESC;
    * */
}
