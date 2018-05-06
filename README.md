## DEPRECATED: Resgrid has not used Rollbar for a while, well over 2 years. Instead we've transitationed to Microsoft AppCenter Crashes [https://docs.microsoft.com/en-us/appcenter/sdk/crashes/cordova](https://docs.microsoft.com/en-us/appcenter/sdk/crashes/cordova). If you are using Ionic Framework Pro we highly recommend Ionic Monitor [https://ionicframework.com/pro/monitor](https://ionicframework.com/pro/monitor). If you still need the pluging we will continue to accept pull requests only.
##

Resgrid's Rollbar Cordova Plugin
==============

PhoneGap / Cordova plugin for using the Rollbar service. Currently supports Android and iOS allowing for capturing native exceptions that occur outside the context of the Web View (i.e. native crashes). 

About Resgrid
-------------
Resgrid is a software as a service (SaaS) logistics, management and communications platform for first responders, volunteer fire departments, career/paid-on-call fire, EMS, Search and Rescue (SAR), public safety, HAZMAT, CERT, disaster response, etc.

Resgrid is built on Microsoft's Azure platform, utilizing the Ionic Framework/Cordova/Angular for mobile applications.

Sign up for your free [Resgrid Account Today!](https://resgrid.com).

Rollbar
-------------

This plugin requires a Rollbar account. Sign up for your free Rollbar account [here](https://rollbar.com/).

## Installation ##
You can install the plugin by running the following command.

```
cordova plugin add https://github.com/Resgrid/cordova-plugins-rollbar.git --variable ROLLBAR_ACCESS_TOKEN="<ROLLBAR_ACCESS_TOKEN>" --variable ROLLBAR_ENVIRONMENT="<ROLLBAR_ENVIRONMENT>"
```

## Usage ##
After device ready call the following line of code to initialize the Rollbar plugin. Note that the token and environment are pulled form the plugin vairables.

```
cordova.plugins.Rollbar.init();
```

## Supported Platforms ##

- Android
- iOS

## Notes ##
Currently in development, we welcome PR's and other fixes. Hope to have it production ready soon.

## Author's ##
* Shawn Jackson (Twitter: @DesignLimbo Blog: http://designlimbo.com)
* Jason Jarrett (Twitter: @staxmanade Blog: http://staxmanade.com)

## Special Thanks ##
* Halkeye (https://github.com/halkeye)

## License ##
Apache 2.0
