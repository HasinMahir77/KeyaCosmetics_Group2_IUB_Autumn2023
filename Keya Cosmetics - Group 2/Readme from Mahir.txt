1) 
Make sure that your fxml is in the same folder as the class that sets the scene.
If fxml is in another directory, make a scene switching class in the directory and use that class's instance use
to switch scene. 
Example: My CustomerSceneSwitcher.java in my folder.

2) Name your User bin files in this manner:

CustomerList.bin
CustomerServiceExecutiveList.bin
ReceptionistList.bin
.
.
.
.

3) 
Once your user has passed logged in using my Login algorithm, you can get your user instance using
Main.getUserData(). If you want complete data, cast the return of the getUserData() method into the correct
User subclass.

Example: 

Customer c = (Customer) Main.getUserData();

4)

Use the Deleteable interface in your User class to allow deleting and recovery on account.
Code body for the features is available in customer class.