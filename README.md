# GoogleAuthenticator Connector
 
## Introduction

This connector enables you to generate a secret key and a otp authentication URL to register an application in the Google Authenticator app on the device of a user. Furthermore, you can use a validation action to validate codes being generated on the device of a user with a secret key.

## Configuration
 ![Available actions][3] 
 
### Create credentials
 
 - Create a 'credentials' entity which contains or is associated with a user to store the secret key. This entity should contain a 'ga_SecretKey' (String) attribute. Don't forget to set your entity access rules appropriately! Only the business logic of your app should be able to read the secret key.

 - A QR code viewer from the Mendix Marketplace is a nice way to display the generated One Time Password authentication URL.

  - Create a microflow which takes your 'credentials' entity object as a parameter and passes it as a parameter to the 'Google Authenticator Connector - Create user credentials' action. The action only changes the 'ga_SecretKey' attribute in your entity so you need to commit the entity yourself. (This way you're free in how you take care of your entities and storing of objects). 
 
 - The 'Google Authenticator Connector - Create user credentials' also requires a username and the name of your application(issuer). These values will be reflected in Googles 'Google Authenticator' app on the device of the user, so the user knows which code belongs to an application.
 
 - Create a page which shows the otp authentication URL as a QR-code to your user. You can use the QR Code Viewer in the Mendix Marketplace for this, for example. It's recommended to show the QR code to the user just once and to not store the value in the database.
  
![Create credentials][1]

### Validate code

- Create a page in your application where the user can fill in the code which is generated on the device of the user. 

- Pass this code to a microflow that contains the 'Google Authenticator Connector - Check validation code' action together with the secretkey stored with the user. (The secret key is available in the 'Credentials' entity which is described under 'Create Credentials' above.)

- The result of this authentication (boolean) can be used in any way you like.

- Since TOTP passwords are time-based, it is essential that the clock of both the server and the client are synchronised within the tolerance used by the library (30 seconds by default).

![Validate code][2]


## Example
The GitHub project of this module contains a working example.

## Dependencies

- googleauth-1.5.0.jar
- commons-codec-1.15.jar
- httpclient-4.5.13.jar
- httpcore-4.4.13.jar
- commons-logging-1.2.jar

## Collaboration on this connector

Development of this connector is done through a git project on Github.

This connector uses the GoogleAuth library. https://github.com/wstrange/GoogleAuth/

## License

This connector is licensed under the Apache v2 license.

## Copyright & Disclaimer GoogleAuth java library
Please find the Copyright notice in the disclaimer on https://github.com/wstrange/GoogleAuth/ or in the GoogleAuthenticator module.

  [1]: https://raw.githubusercontent.com/RoelandSalij/GoogleAuthenticator/master/docs/images/CreateCredentials.PNG
  [2]: https://raw.githubusercontent.com/RoelandSalij/GoogleAuthenticator/master/docs/images/ValidateUserInput.PNG
  [3]: https://raw.githubusercontent.com/RoelandSalij/GoogleAuthenticator/master/docs/images/Actions.PNG
