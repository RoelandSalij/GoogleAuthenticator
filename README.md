# GoogleAuthenticator Connector
 
## Introduction

This connector enables you to 
	- generate secret keys and Qr codes for users to register an application in the Google Authenticator app on their device.
	- implement validation of Google Authenticator codes being generated on the device of a user.

## Configuration
 ![Available actions][3] 
 
### Create credentials
 
 - Create a 'credentials' entity which is associated to your users to store the secret key and url for the QR code. Don't forget to set your entity access rules appropriately! Only your applications business logic should be able to read the secret key. Only users should be able to read the QR code url associated to them. 

 - Create a microflow which receives your 'credentials' entity and passes it as a parameter to the 'Google Authenticator Connector - Create user credentials' action. The action only sets the attributes in your entity so you need to commit the entity yourself. (This way you're free in how you take care of your entities and storing of objects). 
 
 - The 'Google Authenticator Connector - Create user credentials' also requires a username and the name of your application. These values will be reflected in Googles 'Google Authenticator' app on the device of the user, so the user knows which code belongs to an application.
 
 - Create a page which shows the QR-code to your user. You can use the ImageViewer widget from the App Store for this, for example. It's recommended to show the QR code to the user just once and remove the value completely from your database afterwards.
  
![Create credentials][1]

### Validate code

- Create a page in your applications where the user can fill in the code which is generated on the device of the user. 

- Pass this code to the 'Google Authenticator Connector - Check validation code' action together with the secretkey stored with the user. (The secret key is available in the 'Credentials' entity which is described under 'Create Credentials' above.)

- The result of this authentication (boolean) can be used in any way you like.

![Validate code][2]

## Know issues
A time difference between server and a device providing validation codes causes issues.

## Collaboration on this connector

Development of this connector is done through a git project on Github.

All java jar dependencies are managed using an ivy file. You can download all
dependencies by running runivy.cmd. This will save all jars in the userlib folder. There are two different
scripts to run ivy:
* runivy.cmd - downloads all dependencies required for running and testing the project
* runivy-export.cmd - downloads only the dependencies required for distributing the connector mpk.

Before you start to develop the connector you need to run runivy.cmd. After you validate everything works, run runivy-export.cmd.
This will delete all jars in the userlib folder and only download the jars required for creating the connector mpk.


This connector uses the GoogleAuth library. https://github.com/wstrange/GoogleAuth/

## License

This connector is licensed under the Apache v2 license.

## Copyright & Disclaimer GoogleAuth java library
Please find the Copyright notice in the disclaimer on https://github.com/wstrange/GoogleAuth/ or in the GoogleAuthenticator module.

  [1]: https://raw.githubusercontent.com/RoelandSalij/GoogleAuthenticator/master/docs/images/CreateCredentials.PNG
  [2]: https://raw.githubusercontent.com/RoelandSalij/GoogleAuthenticator/master/docs/images/ValidateUserInput.PNG
  [3]: https://raw.githubusercontent.com/RoelandSalij/GoogleAuthenticator/master/docs/images/Actions.PNG
