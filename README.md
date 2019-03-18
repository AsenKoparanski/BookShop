# BookShop
=========================

This is an Intellij Project which calculates the final amount to be paid when given a list of books. The application has a GUI interface and a uses a JDBC driver and SQLite3 for database connection.

To run the application

 #Usage

1. In project structure, you have to include the junit and sqlite jdbc driver as libraries.
2. JavaFX 11 SDK needs to be added as a global library and as a Module to the current project.
3. In the Datasource class, the CONNECTION_STRING path must be changed to the local path where the project resides.
4. IMPORTANT: To select multiple rows from the table interface, you need to hold Control while pressing.
5. To refresh the selected choices, you can use the refresh table button.

#Notes

1. The application uses Java 11 SDK. 
2. JavaFX 11 is used for GUI, earlier versions may not work.

#Scalability

1. The app can very easily be extended to offer addition/deletion of books. It uses a singleton pattern in the datasource class.
2. The GUI class is seperated from the Database class. The logic class is also separate and addition of new discounts would be trivial.
