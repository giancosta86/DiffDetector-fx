# DiffDetector-fx

*JavaFX sample app for Diff Detector*


## Introduction


**DiffDetector-fx** is a sample JavaFX application that is part of the [Diff Detector](https://github.com/giancosta86/DiffDetector)'s architecture.

It is based on 2 editable text areas and a button that asks a running [Diff Detector-web](https://github.com/giancosta86/DiffDetector-web) server for diffs, showing them.

![Screenshot](https://github.com/giancosta86/DiffDetector-fx/blob/master/screenshots/app.png "Server running in the console and listening on the default port")


## Features

It employes several ideas of modern GUI toolkits, in particular:

* a declarative, separated approach, via an FXML file

* CSS styling, including CSS classes

* property binding


**PLEASE, NOTE:** this app is just an example, so it has only been tested with simple strings of ASCII chars. Further tests should be carried out with multi-byte characters as well.



## Running the app on your PC

The suggested way to run the app is [MoonDeploy](https://github.com/giancosta86/moondeploy), as it will automatically download and launch the application - just go to the [latest release](https://github.com/giancosta86/DiffDetector-fx/releases/latest) page and open the file **App.moondeploy**.

Otherwise, to start the application:
1. Download and decompress the zip archive
2. Run the file *bin/DiffDetector-fx* (on UNIX) or *bin/DiffDetector-fx.bat* (on Windows)



## Further references

* [Diff Detector](https://github.com/giancosta86/DiffDetector)

* [Diff Detector-web](https://github.com/giancosta86/DiffDetector-web)