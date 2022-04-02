#7.1

CREATE VIEW available_resource AS
	SELECT id,resource_name,available_capacity
    FROM resource
    WHERE available_capacity > 0
    ORDER BY id;
        
CREATE VIEW school_details AS 
	select name, address from school where head LIKE 'Sandy';
    
#7.2

CREATE VIEW hour_booked AS
	SELECT COUNT(*) AS booked_resources,number_of_hours
    FROM booking
    GROUP BY number_of_hours
    HAVING COUNT(*)>2;
    
CREATE VIEW booking_details AS
	select CONCAT(booking_slot,' for ',number_of_hours,' hours') as slot_booked from booking where TIME(booking_slot)='15:00:00';

    
# 7.3

CREATE VIEW booked_view AS
	SELECT employee_name 
	FROM booking_employee be
	WHERE EXISTS
		(SELECT * 
		FROM booking
		WHERE employee_user_id = be.user_id 
				AND booked_capacity > 25);

CREATE VIEW join_view AS
	SELECT s.name,r.resource_name
	FROM school s
	JOIN resource r
	WHERE s.code = r.school_code;


CREATE VIEW employee_details AS
	select  user_id, employee_name from booking_employee where school_code in (select code from school where name='UIUC' );


    
