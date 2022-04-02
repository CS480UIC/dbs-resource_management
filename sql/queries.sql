#7.1

CREATE VIEW available_resource AS
	SELECT id,resource_name,available_capacity
    FROM resource
    WHERE available_capacity > 0
    ORDER BY id;
    
    
    
#7.2

CREATE VIEW hours_booked AS
	SELECT COUNT(*),number_of_hours
    FROM booking
    GROUP BY number_of_hours
    HAVING COUNT(*)>2;
    
    
# 7.3
CREATE VIEW booked_view AS
	SELECT employee_name 
	FROM booking_employee be
	WHERE EXISTS
		(SELECT * 
		FROM booking
		WHERE employee_user_id = be.user_id 
				AND booked_capacity > 25);
