package coding.sql;

public class TrimSql {
    /*
    Пассажиры которые улетели в москву на самолете ТУ-134ж

    Select distinct p.name from Trip t
        inner join pass_in_trip pass on t.id = pass.id
        inner join Passenger p WHERE t.town_to = 'Moscow' and t.plane = 'TU-134';


    Select distinct p.name from Passenger p
        inner join Pass_in_trip pass on p.id=pass.id
        inner join Trip t on pass.id = t.id
        WHERE t.town_to = 'Moscow' and t.plane = 'TU-134';
    * */
}
