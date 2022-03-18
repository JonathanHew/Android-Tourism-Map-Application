# Android Irish Tourism Guide App 

Name: Jonathan Hew 

# Description of the assignment
For this project I designed and developed an Android App. The app was created for Irish tourists. When they use this app they will be able to find the locations of popular attractions and some information about them also. I coded this application in Java using Android Studio.

The application functionality contains: 
  - Data stored in a local SQLLite database
  - an input screen where the user enters data
  - a list populated by the SQL database
  - CRUD operations on the database, i.e INSERT, UPDATE, SELECT, DELETE.
  - Google maps feature 
  - Location services feature (User location tracking and updating)



# Youtube Video Link 
Please click on the video image below to view the demo of this project.

[![YouTube](http://img.youtube.com/vi/PvWy_KmDee4/0.jpg)](https://youtu.be/PvWy_KmDee4)


# Instructions
  - Download this repository 
  - Open the project on Android Studio 
  - Run the app on an emulator or an Android phone
  

# How it works
## Architecture Pattern
This project uses a Model View Controller (MVC) architecture pattern. MVC consists of three logical components. A Model, a View and a Controller.

### Model
In my project the AttractionsDatabaseManager and AttractionsDatabaseHelper classes act as the Model. These classes deal with storing and using data in this project. The purpose of the AttractionsDatabaseHelper class is to create and open the database. The AttractionsDatabaseManager contains all CRUD operations (Create, Read, Update, Delete) that are used to query the database in my project.
### View
In my project the XML files such as activity_main.XML act as the View. These XML files were created for each screens GUI. Because these XML files were kept separate from all other classes, layout changes can be made without effecting the applications running ability. 
### Controller 
All other classes in this porject act as the Controller. These bridge the gap between the model classes and the view classes. For example in the View_All_Activity.java class is used to display the data from the database (using the model class to retrieve) into a list (using a view class to format the layout of the list).

## Google Maps and Location Services
The Search_By_Map_Activity uses a an Adnroid feature which displays a google map.

# Low Fidelity Prototype 


# What I am most proud of in the assignment

# Pages I created
## Home
