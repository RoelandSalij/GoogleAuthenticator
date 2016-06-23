# GoogleAuthenticator Connector
 
## Introduction

This connector enables you to implement validation of Google Authenticator generated validation codes.

## Usage

You need to generate a secret key using this module, and store/associate it with your users. You can validate Google Authenticator generated validation codes.

### Create credentials


### Validate code

## Development

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

