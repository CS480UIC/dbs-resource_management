## Glossary


### Entity Name: school

__Attributes__: 

__Attribute Type__: __code__

maxima:1-1 minima: 1

__Data type__ : VARCHAR(7)

__Description__: 'code' is used to identify a school which is a varchar upto 7 characters.
Characters in code can be a mixture of alphabets and numbers. This attribute is UNIQUE and does not take NULL VALUES as it is the PRIMARY KEY.

__Attribute Type__: __name__ 

maxima:M-1 minima: 1

__Data type__ : VARCHAR(50)

__Description__: 'name' describes the name of the school. It is a variable character attribute accepting upto 50 characters. This attribute is does not take NULL VALUES meaning it is REQUIRED attribute.


__Attribute Type__: __address__

maxima:1-1 minima: 1

__Data type__ : VARCHAR(100)

__Description__: 'address' mentions the address of the school. It is a UNIQUE and NOT NULL attribute with the datatype as VARCHAR(100)


__Attribute Type__: __head__

maxima:1-1 minima: 1

__Data type__ : VARCHAR(20)

__Description__: 'head' is the principal of the school who gets to manage the resources. It is a UNIQUE attributes with NOT NULL values as every school needs to assign a head to manage the resources. 


__Attribute Type__: __login_id__

maxima:1-1 minima: 1

__Data type__ : VARCHAR(10)

__Description__: 'login_id' contains alphanumeric characters used by the head to login. This attribute is UNIQUE and NOT NULL. It is a required attribute menaing every head should have a login ID. 


__Attribute Type__: __password__

maxima:M-1 minima: 1

__Data type__ : VARCAHR(12)

__Description__: 'password' contains alphanumeric characters to login. This attribute is REQUIRED and is NOT NULL. 


__Description of entity__: School entity contains the information of all the schools willing to use this tool. 

### Entity Name: resource

__Attributes__: 


__Attribute Type__: __resource_id__

maxima:1-1 minima: 1

__Data type__ : VARCHAR(7)

__Description__: 'resource_id' contains the ID of the resource 
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
