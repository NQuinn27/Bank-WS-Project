# NCI BSCHE4 Web Services & API Development  
## Bank Services Project  

### To Do
### Web service    
- [x] Create WebService environment  
- [x] Create Account Model  
- [x] Create Customer Model  
- [x] Create Transaction Model  
- [x] Create Account (POST)  
- [x] Make a Lodgement (POST)   
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
```
curl -X POST -H "Accept: application/json" -H "Content-Type: application/json" -d '{
"name" = "John Smith",
"email" = "john@smith.com",
"password" = "password",
"address" = "dublin"
}' "http://127.0.0.1:8080/api/customer/create"
```

### Create a Current Account   
```
curl -X POST -H "Accept: application/json" -d '3' "http://127.0.0.1:8080/api/customer/create"
```   

### Make A Lodgement   
```
curl -X POST -H "Content-Type: application/json" -d '{
	"accountId" = "3",
	"cardNumber" = "1234567890",
	"cardCVV" = "353",
	"cardExpiryDate" = "22/09",
	"amount" = "500.00"
}' "http://127.0.0.1:8080/api/transaction/lodgement"
```

### CHANGELOG
**December 2** *Niall Quinn*  
Updated the Account Resource to generate a random account number of 9 digits long. The database is checked to ensure that this account number does not exist, however unlikely that may be.  

**December 1** *Niall Quinn*
Added the Transaction Model and functionality. Transaction covers Lodgement and Withdrawal, differentiated by the TransactionType enum. When a transaction is made via the API, a transaction entry is committed to the database. After this the account service attempts to process the transaction by deducting or incrementing the balance of the account. After this the transaction is marked as processed. The transaction table can be queried by Account ID to retrieve a list of transactions for an account. Lodgement curl code above.
