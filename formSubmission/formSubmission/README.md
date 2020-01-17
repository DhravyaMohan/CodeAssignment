# Getting Started

### Reference Documentation
To build the application:
------------------------
1)  Navigate to formsubmission

2)  Build the project by using the following command:

	    mvn clean install

To run the application:
------------------------

1)  Navigate to src/main/java/com.example.cts.formsubmission
2)  To run the application
    
        mvn spring-boot:run
	
Technical Details for technical team:
-------------------------------------

1)	To create a user:
   
    localhost:8080/userManagement/users/createuser 
    
  and use the following json format:
  
    {
    	"id":"2",
    	"firstName":"admin",
    	"lastName":"admin",
    	"emailId":"admin@gmail.com",
    	"address":"abcdefghijk",
    	"contactNo":"9977553311",
    	"age":"11"
    }
    
2)  To get the list of users:

        localhost:8080/userManagement/users/getallusers
    
3)  To update the user details:

        localhost:8080/userManagement/users/updateuser
   
4) To delete the user:

        localhost:8080/userManagement/users/deleteuser/2