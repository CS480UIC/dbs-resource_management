## Glossary


### Entity Name: School
__Synonyms__ : -  
__Attributes__: 

__Attribute Type__: _code_ 

maxima:1-1 minima: 1
__Data type__ : VARCHAR(7)

__Description__: 'code' is used to identify school which is a varchar upto 7 characters.
Characters in code can be a mixture of alphabets and numbers. This attribute does not take NULL values and they are UNIQUE.
It is the PRIMARY KEY attribute. 

_name_ maxima:M-1 minima: 1

_address_ maxima:1-1 minima: 1

_head_ maxima:1-1 minima: 1

_login_id_ maxima:1-1 minima: 1

_password_ maxima:M-1 minima: 1

__Description__: This entity contains the information of all the schools willing to use this tool.
The Head/ Pricipal can login using Login_ID and Password and then add/remove and update resources.


### Entity Name: Resource
__Synonyms__ : -  
__Attributes__: 
_resource_id,_ maxima:1-1 minima: 1
_school_code,_ maxima:1-1 minima: 1
_school_name,_ maxima:M-1 minima: 1
_resource_name,_ maxima:1-M minima: 1
_resource_location,_ maxima:M-1 minima: 1
_full_capacity,_ maxima:1-1 minima: 1
_available_capacity_ maxima:1-1 minima: 1
__Description__: This table records multiple resources and the school that contains them. It also records the capacity, address etc.


### Entity Name: booking_employee
__Synonyms__ : booking_representative  
__Attributes__: 
_user_id,_ maxima:1-1 minima: 1
_school_code,_ maxima:1-1 minima: 1
_school_name,_ maxima:M-1 minima: 1
_grade,_ maxima:1-M minima: 1
_password._ maxima:M-1 minima: 1
__Description__: The users of this table can book resources to use.
Typically one user/ representative is assigned to each grade and they are responsible for booking resources.


### Entity Name: booking
__Synonyms__ : -  
__Attributes__: 
_booking_id,_ maxima:1-1 minima: 1
_resource_school_code,_ maxima:1-1 minima: 1
_employee_user_id,_ maxima:1-1 minima: 1
_employee_school_code,_ maxima:1-1 minima: 1
_resource_id,_ maxima:1-1 minima: 1
_booked_capacity,_ maxima:1-1 minima: 1
_booking slot_, maxima:M-1 minima: 1
_notes._ maxima:1-1 minima: 0
__Description__: this table contains all the current bookings done by various schools.


### Relation Macima and Minima
School_owns_resources: maxima/minima:1(1)-M(0)
booking_contains_booked_resources: maxima/minima:M(0)-1(1)
booking_employee_reserves_booking: maxima/minima:1(1)-M(0)
booking_employee_work_for_school: maxima/minima:M(1)-1(1)
