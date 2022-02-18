## Glossary


### Entity Name: School
Synonyms : -  
__Attributes__: 
*Code* maxima:1-1 minima: 1

*Name* maxima:M-1 minima: 1

*Address* maxima:1-1 minima: 1

*Head* maxima:1-1 minima: 1

*Login_ID* maxima:1-1 minima: 1

*Password.* maxima:M-1 minima: 1

Description: This entity contains the information of all the schools willing to use this tool.
The Head/ Pricipal can login using Login_ID and Password and then add/remove and update resources.


### Entity Name: Resource
Synonyms : -  
__Attributes__: resource_id, school_code,school_name, resource_name, resource_location,full_capacity, available_capacity
Description: This table records multiple resources and the school that contains them. It also records the capacity, address etc.


### Entity Name: booking_employee
Synonyms : booking_representative  
__Attributes__: user_id, school_code, school_name, grade, password.
Description: The users of this table can book resources to use.
Typically one user/ representative is assigned to each grade and they are responsible for booking resources.


### Entity Name: booking
Synonyms : -  
__Attributes__: booking_id, resource_school_code, employee_user_id, employee_school_code, resource_id, booked_capacity, booking slot, notes.
Description: this table contains all the current bookings done by various schools.

