# Opendata Projekt - Backend
This is the first part of the ReadMe for the project, after you are done with this part, go to the frontend version of the project and read through that to make sure everything is in order.
___

##1 | Getting Started


Download declared dependencies when first running this project

Declared dependencies can be found in `pom.xml`

####To use this api in frontend, the following usable paths are listed here
 - GET
    - http://localhost:8080/api/items
    Gets items from database and forwards said items as JSON
    - http://localhost:8080/api/user_items/`[userId]`
    Gets a users list of items from database and forwards said items as JSON
 
 - POST
    - http://localhost:8080/api/user_item/
    Adds a item to a users list
 
 - DELETE
    - http://localhost:8080/api/user_item/`[userId]`
    Removes a item from a users list
