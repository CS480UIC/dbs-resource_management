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


__Description of entity__: 'school' entity contains the information of all the schools willing to use this tool. A head uses login_id and password to manage resources. This is an independent entity.

### Entity Name: resource

__Attributes__: 


__Attribute Type__: __resource_id__

maxima:1-1 minima: 1

__Data type__ : VARCHAR(7)

__Description__: 'resource_id' contains the ID of the resource to identify them. It is a variable character of size 7. resource_id is a UNIQUE attribute with id mapping to pnly one resource and it should contain NOT NULL values as it the PRIMARY KEY of this entity.


__Attribute Type__: __school_code__

maxima:1-1 minima: 1

__Data type__ : VARCHAR(7)

__Description__: 'school_code' is the FOREIGN KEY from the school entity. It should be UNIQUE an d should contain NOT NULL values. 


__Attribute Type__: __resource_name__

maxima:M-1 minima: 1

__Data type__ : VARCHAR(20)

__Description__: 'resource_name' describes the name of the resource with a variable character of 20. It contains NOT NULL values and is REQUIRED.


__Attribute Type__: __resource_location__

maxima:M-1 minima: 1

__Data type__ : VARCHAR(50)

__Description__: 'resource_location' indicates the location of the resource. It is a NOT NULL attribute.


__Attribute Type__: __full_capacity__

maxima:M-1 minima: 1

__Data type__ : SMALLINT

__Description__: 'full_capacity' indicates the overall capacity of the resource. It is indicated in numbers and is a NOT NULL attribute. It is a REQUIRED attribute.


__Attribute Type__: __available_capacity__

maxima:M-1 minima: 1

__Data type__ : SMALLINT

__Description__: 'available_capacity' indicates the capacity of the resource that is available to book. It is a SMALLINT with a REQUIRED attribute. 


__Description of the entity__: This table records the resources of the schools that contain them. It depends on the entity 'school' and has the foreign key school_code to identify the school that contains the resource. The changes in the school has to be CASCADED to the entity resource. Cascade on primary key update and delete and Restrict on foreign key insert and update. 


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


### Relation MaXima and Minima
School_owns_resources: maxima/minima:1(1)-M(0)
booking_contains_booked_resources: maxima/minima:M(0)-1(1)
booking_employee_reserves_booking: maxima/minima:1(1)-M(0)
booking_employee_work_for_school: maxima/minima:M(1)-1(1)
