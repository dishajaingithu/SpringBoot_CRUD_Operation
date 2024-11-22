# SpringBoot_CRUD_Operation

**GitHub Repository** : 
You can access the full project repository on GitHub here:  
https://github.com/dishajaingithu/SpringBoot_CRUD_Operation

1. **Cloning the Repository**:  
   I obtained the project code by cloning the repository using the following command:  
   
   git clone https://github.com/dishajaingithu/SpringBoot_CRUD_Operation.git  
   

2. **Setting Up the Development Environment**:  
   - I used **Visual Studio Code (VS Code)** as my IDE to work on the project.  
   - Installed **Java Development Kit (JDK)** to run and build the Spring Boot application.  
   - Configured **Apache Maven** as the build tool for dependency management and compiling and running the application.  

3. **Database Configuration**:  
   - Installed **MySQL** and created the database `productcatalog_db` using **MySQL Workbench**.  
   - The required tables and relationships were defined based on the schema described below in the DB Design section.  

4. **Starting the Backend Server**:  
   - Navigated to the project directory and ran the application using the Maven command:   
     mvn spring-boot:run  
     
   - The Spring Boot application started successfully on `localhost:8080`.  

### **How I Tested the Machine Test Requirements**  

1. **CRUD Operations Implementation**:  
   - I developed the required RESTful APIs for performing CRUD operations on **Category** and **Product** entities, ensuring they adhered to the specifications, including pagination and relational data handling.  

2. **API Testing Using Postman**:  
   - Used **Postman** to test the endpoints for:  
     - Creating new categories and products.  
     - Updating existing records by ID.  
     - Fetching records with and without pagination parameters.  
     - Deleting records and verifying database updates.  

3. **Database Verification**:  
   - After each API operation, I verified the changes in the **productcatalog_db** database using **MySQL Workbench** to ensure data consistency and correctness.  

### **Database Design**  
The database was designed with two main tables:  

1. **Category Table**:  
   - Columns:  
     - `id` (Primary Key): Unique identifier for each category.  
     - `name`: The name of the category.  

2. **Product Table**:  
   - Columns:  
     - `id` (Primary Key): Unique identifier for each product.  
     - `name`: The name of the product.  
     - `price`: Price of the product.  
     - `category_id` (Foreign Key): References the `id` column in the Category table to establish the many-to-one relationship.  

### **Entity Relationship**  
- **One-to-Many Relationship**:  
   Each category can have multiple products associated with it, while each product is linked to a single category.  

### **Project Highlights**  
- Used **JPA** and **Hibernate** for ORM and database interaction.  
- Implemented server-side pagination for fetching records efficiently.  
- Ensured that when retrieving product details, the associated category information is also included in the response.  

### **How to Run the Project**  
1. Clone the repository:  
   git clone https://github.com/dishajaingithu/SpringBoot_CRUD_Operation.git  

2. Navigate to the project directory and start the Spring Boot application:  
   mvn spring-boot:run  

3. Use Postman to interact with the APIs and test CRUD operations, or open a browser to test GET endpoints directly.  

4. Verify the database updates in **MySQL Workbench** by inspecting the `productcatalog_db` database.  
