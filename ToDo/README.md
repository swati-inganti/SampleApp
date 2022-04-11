# TODO Application

This project was generated with [Spring Initializr] https://start.spring.io/.

## Getting the source code

Download the zip from Github : {url}.

##Setting up the code base in eclipse

1. Unzip the zip file.

2. Open Eclipse > Select File > Import > Existing Maven Project > Give the path to this unzipped folder in Root Directory > Click on Finish. 
Note : You should be able to see the ToDo project structure in Project Explorer after the above step.

##Run the application

To run the application, right click on ToDoApplication > Run As > Java Application.
In the console you can see the message "Started ToDoApplication" which marks that the application is up and running.

Note : You will not be able to see the app running at http://localhost:8081 as @CrossOrigin(origins = "http://localhost:4200") has been added in the controller to redirect the requests from UI application.
You can access the below get requests through postman once the application is up and only if there is data saved from UI, otherwise these results will give empty records- 
-http://localhost:8081/myapp/get-todo-listing 
-http://localhost:8081/myapp/get-todo-by-id/{id}


##Create Build

To create a war Right click on ToDo project > Run As > Maven Build > give command 'clean install package' > Run.
This will create a ToDo-0.0.1-SNAPSHOT.war at ToDo > target.

##Run Junit Test Cases

To run junit test cases, go to ToDoRestControllerTest > Right Click > Run As > Junit.