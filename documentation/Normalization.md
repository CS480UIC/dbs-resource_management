__First Normal Form__ - 
            _"All non-key columns depend on primary key."_
            
We checked that all our tables have a primary key. Thus, it's in First Normal Form.

__Second Normal Form__ - 
            _"A table is in second normal form when all non-key columns depend on the whole primary key."_

The tables in the database are already in second normal form, as all our non-key coloumns depend on the whole primary key.

__Third Normal Form__ - 
             _"A table is in third normal form if, whenever a non-key column A depends on column B, then B is unique. Columns A and B may be simple or composite."_

The tables are in third normal form. We say this because we do not have any non-key column that depends on another non-key column. All our columns depend on the primary key.

__Boyce-Codd Normal Form__ - 
            _"A table is in Boyce-Codd normal form if, whenever column A depends on column B, then B is unique. Columns A and B may be simple or composite."_

Our tables complies with Boyce-Codd Normal Form as we have all columns depending on the primary key of the tables alone.
