# Vending Machine App

## Tech 
- Spring boot 2
- JPA running H2 in memory DB
- Thymeleaf for a front end


## How to run
- Run the za.co.chrispie.demo.vending.machine.DemoVendingMachineApplication class as a springboot app.
- Open the browser and go to http://localhost:7088/
- Alternatively the port could be changed in the application.properties file

## How to use the app
###### The main home landing page the user can:
- insert a 50c or a 1€ coin or (any other - that would be rejected as the backend would find it to be invalid).
- ask for a refund 
- select a drink of choice

###### The admin page
- Display a list of stock avail with the ability to increase it
- Display a list of sales with dates and amounts

## Folder logic
#### Controllers
- MVC front end controllers
#### DB
- JPA repositories and hibernate reverse engineered files
#### Facades
- Potentially in real life this would be separate services and acts as an entity
#### Models
- App based models that is shared in the application. In real life each component will have their own object models that would be exposed as a client lib
#### Util
- Any utilities in this case error/info messages. In real life this needs to be in a DB to be modifiable

## What is left?
- Keep track of coins to know what change is available is something that still needs to be implemented