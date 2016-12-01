# NCI BSCHE4 Web Services & API Development  
## Bank Services Project  

### To Do
### Web service    
- [x] Create WebService environment  
- [x] Create Account Model  
- [x] Create Customer Model  
- [ ] Create Transaction Model  
- [x] Create Account (POST)  
- [ ] Make a Lodgement (POST/PUT?)   
- [ ] Transfer (POST)  
- [ ] Withdrawal (POST)  
- [ ] Balance (GET)  
- [ ] Documentation (outlined in brief)

### Clients
- [ ] Decide HTML/JS or Mobile touching all parts of API  
- [ ] Java Client touching all parts of API  
- [ ] Server implementing API

### Database   
To get up and running, first create an SQL database on your machine with the name 'WebAPIBank'. Using the SQL Dump in this repository, create the database. In the project, create the file GroupGBankApp/src/main/webapp/WEB-INF/classes/META-INF/persistence.xml (sample provided to duplicate). Fill in the correct values for SQL_PORT, SQL_USERNAME and SQL_PASSWORD for your machine.  

### Curl Client   
#### Create a Customer   
'''
curl -X POST -H "Accept: application/json" -H "Content-Type: application/json" -d '{
"name" = "John Smith",
"email" = "john@smith.com",
"password" = "password",
"address" = "dublin"
}' "http://127.0.0.1:8080/api/customer/create"
'''

### Create a Current Account   
'''
curl -X POST -H "Accept: application/json" -d '3' "http://127.0.0.1:8080/api/customer/create"
'''
