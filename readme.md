## Table of Contents
1. [Database](#database)
2. [Author(s)](#author)
3. [Database description](#description)
4. [Screen Shots for CRUD](#CRUD)
# Database
resource_management

# Authors
Shreya Raj Kati

Madhumitha Rajarajan

# Database description
The main idea behind this project is to collect data about the resources that are available in a particular school and use that information to allow access to other schools in the same community that lack those resources.
The entity school maintains the general information about all the schools such as the name, location and the head of the school.
The database resource collects the information about different types of resources that are available in a school and also how many such resources are available (15 laptops, 2 chemistry labs etc). The location of the resources (like labs or sports field) is also stored in the same table.
We also maintain a record of employees who are permitted to book these resources for any particular grade in a school in the table booking_employee. 
Then there is a booking table, where me manage the booking of resources (School xyz has booked chemistry lab "A" for Friday from 2:30 to 4:00) with the information about when the resource is booked, for how much capacity it is booked and also the number of hours it is booked for is stored. The front end is implemented using Java.


# CRUD

![Main Page](Screen_Shots/main_page.png)

![CRUD SCHOOL](Screen_Shots/crud_school.png)

![Create School](Screen_Shots/school_create.png)

![Read School](Screen_Shots/read_school.png)

![Update School](Screen_Shots/update_school.png)

![Delete School](Screen_Shots/delete_school.png)

![CRUD RESOURCES](Screen_Shots/crud_resource.png)

![Create Resource](Screen_Shots/resource_create.png)

![Read Resource](Screen_Shots/read_resource.png)

![Update Resource](Screen_Shots/update_resource.png)

![Delete Resource](Screen_Shots/delete_resource.png)

![CRUD Booking](Screen_Shots/CRUD_Booking.png)

![Create Booking](Screen_Shots/Create_Booking.png)

![Read Booking](Screen_Shots/Read_Booking.png)

![Update Booking](Screen_Shots/Update_Booking.png)

![Delete Booking](Screen_Shots/Delete_Booking.png)

![CRUD Booking Employee](Screen_Shots/CRUD_Booking_Employee.png)

![Create Booking Employee](Screen_Shots/Create_Booking_Employee.png)

![Read Booking Employee](Screen_Shots/Read_Booking_Employee.png)

![Update Booking Employee](Screen_Shots/Update_Booking_Employee.png)

![Delete Booking](Screen_Shots/Delete_Booking_Employee.png)
