## Glossary


### Entity Name: school

__Attributes__: 

__Attribute Type__: __code__

_maxima:1-1 minima: 1_

__Data type__ : VARCHAR(7)

__Description__: 'code' is used to identify a school which is a varchar upto 7 characters.
Characters in code can be a mixture of alphabets and numbers. This attribute is __UNIQUE__ and does __not take NULL VALUES__ as it is the __PRIMARY KEY__.

__Attribute Type__: __name__ 

_maxima:M-1 minima: 1_

__Data type__ : VARCHAR(50)

__Description__: 'name' describes the name of the school. It is a variable character attribute accepting upto 50 characters. This attribute is __does not take NULL VALUES__ meaning it is __REQUIRED__ attribute.


__Attribute Type__: __address__

_maxima:1-1 minima: 1_

__Data type__ : VARCHAR(100)

__Description__: 'address' mentions the address of the school. It is a __UNIQUE and NOT NULL__ attribute with the datatype as VARCHAR(100)


__Attribute Type__: __head__

_maxima:1-1 minima: 1_

__Data type__ : VARCHAR(20)

__Description__: 'head' is the principal of the school who gets to manage the resources. It is a __UNIQUE attributes with NOT NULL__ values as every school needs to assign a head to manage the resources. 


__Attribute Type__: __login_id__

_maxima:1-1 minima: 1_

__Data type__ : VARCHAR(10)

__Description__: 'login_id' contains alphanumeric characters used by the head to login. This attribute is __UNIQUE and NOT NULL__. It is a required attribute menaing every head should have a login ID. 


__Attribute Type__: __password__

_maxima:M-1 minima: 1_

__Data type__ : VARCAHR(12)

__Description__: 'password' contains alphanumeric characters to login. This attribute is __REQUIRED and is NOT NULL__. 


__Description of entity__: 'school' entity contains the information of all the schools willing to use this tool. A head uses login_id and password to manage resources. This is an independent entity.

### Entity Name: resource

__Attributes__: 


__Attribute Type__: __id__

_maxima:1-1 minima: 1_

__Data type__ : VARCHAR(7)

__Description__: 'id' contains the ID of the resource to identify them. It is a variable character of size 7. resource_id is a UNIQUE attribute with id mapping to pnly one resource and it should contain __NOT NULL values as it the PRIMARY KEY__ of this entity.


__Attribute Type__: __school_code__

_maxima:1-1 minima: 1_

__Data type__ : VARCHAR(7)

__Description__: 'school_code' is the FOREIGN KEY from the school entity. It should be __UNIQUE and should contain NOT NULL__ values. 


__Attribute Type__: __resource_name__

_maxima:M-1 minima: 1_

__Data type__ : VARCHAR(20)

__Description__: 'resource_name' describes the name of the resource with a variable character of 20. It contains __NOT NULL values and is REQUIRED__.


__Attribute Type__: __resource_location__

_maxima:M-1 minima: 1_

__Data type__ : VARCHAR(50)

__Description__: 'resource_location' indicates the location of the resource. It is a __NOT NULL__ attribute.


__Attribute Type__: __full_capacity__

_maxima:M-1 minima: 1_

__Data type__ : SMALLINT UNSIGNED

__Description__: 'full_capacity' indicates the overall capacity of the resource. It is indicated in numbers and is a __NOT NULL attribute__. The full capacity should be greater than zero. So we place a __CHECK__ Constraint


__Attribute Type__: __available_capacity__

_maxima:M-1 minima: 1_

__Data type__ : SMALLINT UNSIGNED

__Description__: 'available_capacity' indicates the capacity of the resource that is available to book. It is a __NOT NULL__ attribute. 


__Description of the entity__: This table records the resources of the schools that contain them. It depends on the entity 'school' and has the foreign key school_code to identify the school that contains the resource. The changes in the school has to be CASCADED to the entity resource. Cascade on primary key update and delete. 


### Entity Name: booking_employee
__Synonyms__ : booking_representative  
__Attributes__: 


__Attribute Type__: __user_id__

_maxima:1-1 minima: 1_

__Data type__ : VARCHAR(7)

__Description__: 'user_id' is  a unique ID used for the employee to book a resource. It is __UNIQUE and NOT NULL__. Also the __PRIMARY KEY__ of this enity.


__Attribute Type__: __school_code__

_maxima:1-1 minima: 1_

__Data type__ : VARCHAR(7)

__Description__: It is the foreign key from the entity school used to identify the school of the employee. It is __UNIQUE and NOT NULL__.


__Attribute_type__: __employee_name__

__Data_type__: VARCHAR(20)

__Description__: 'employee_name' contains the name of the employee of variable character size of 20, who is allowed to book the resource. It is __NOT NULL__ and is a REQUIRED attribute.


__Attribute Type__: __password__

_maxima:M-1 minima: 1_

__Data type__ : VARCHAR(12)

__Description__: Used to login by the employee. It is __NOT NULL__ and is a REQUIRED attribute.

__Description of the entity__: The users of this entity are employees who can book resources to use.
Typically one user representative is assigned to each grade and they are responsible for booking resources. The attribute 'grade' from this entity is a plural attribute and thus it is been implemented as a dependent entity 'booking_employee_grade'. This entity depends on the entity 'school' and has the foreign key school_code to identify the school of the employee. The changes in the school has to be CASCADED to the entity booking_employee. 


### Entity Name: booking_employee_grade

__Attributes__:

__Attribute Type__: __(booking_employee_user_id,grade)__ PK

__Data type__ : VARCHAR(10)

__Description of the entity__: This attribute is the primary key of this table. Since 'grade' was a plural attribute, this is put as a dependent table to the 'booking_employee' and the primary key is the composite of the foreign key 'booking_employee_user_id' from the master table and 'grade' of this table.


### Entity Name: booking
  
__Attributes__: 


__Attribute Type__: __booking_id__

_maxima:1-1 minima: 1_

__Data type__ : VARCHAR(7)

__Description__: 'booking_id' is a UNIQUE ID used to identify the booking of a resource. It is the PRIMARY KEY of this entity and thus is __NOT NULL__ and REQUIRED.


__Attribute Type__: __employee_user_id__

_maxima:1-1 minima: 1_

__Data type__ : VARCHAR(7)

__Description__: This attribute contains the user ID of the employee booking the resource. It is the foreign key from the table booking_employee. Thus all the updates from that table is cascaded here. It is a __NOT NULL__ and __UNIQUE__ attribute.


__Attribute Type__: __resource_id__

_maxima:1-1 minima: 1_

__Data type__ : VARCHAR(7)

__Description__: This attribute is the foreign key that contas the ID of the resource that was booked. It is dependent on resource and all the updates of the resources are cascaded to this attribute. It is NOT NULL and UNIQUE attribute.


__Attribute Type__: __booked_capacity__

_maxima:M-1 minima: 1_

__Data type__ : SMALLINT UNSIGNED

__Description__: It indicates the capacity of the resource that is booked. It is a __NOT NULL__ and REQUIRED attribute. A __CHECK__ Constraint is placed to check if the booked_capacity is greater than 0.


__Attribute Type__: __booking_slot__

_maxima:M-1 minima: 1_

__Data type__ : DATETIME

__Description__: This attribute indicates the date and time of the slot that a resource is being booked for. It is a REQUIRED attribute with __NOT NULL__ values.

__Attribute Type__: __number_of_hours__

_maxima:M-1 minima: 1_

__Data type__ : TINYINT UNSIGNED

__Description__: This contains the number of hours the resource is being booked for starting from the booking slot time. It is a REQUIRED and __NOT NULL__ attribute.  A __CHECK constraint__ is placed to check if the number of hours booked is grater than 0.


__Attribute Type__: __notes__

_maxima:1-1 minima: 0_

__Data type__ : VARCHAR(150)

__Description__: This contains extra specifications which is optional. It can contain NULL values.

__Description of the entity__: This table contains all the current bookings done by various schools. It depends on the entity 'school' and 'booking_employee' . The UPDATE in the school and booking_employee has to be CASCADED to the entity resource. Cascade on primary key update and delete.
