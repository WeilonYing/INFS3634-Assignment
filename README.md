# OOPBuddy (INFS3634-Assignment)
Assignment project for INFS3634 (Mobile Application Development) at the University of New South Wales.
OOPBuddy is an Android app made by Weilon Ying for the INFS3634 course assignment in 2018 (S2).

## How to build and run in Android Studio
* Download the source code from this repository by using `git clone https://github.com/WeilonYing/INFS3634-Assignment.git`
  * If you obtained the source code from downloading a zipped file, unzip the files to a directory of your choice
* Open Android Studio. If you're already in a project, close the project by going to "File -> Close Project"
* Click on "Import Project"
* Navigate to the directory where you have downloading/unzipped the source code and select it. The
directory is most likely called "INFS3634-Assignment"
* Select "Import project from external model", then select "Gradle". Then select "Next"
* Select "Finish" to complete the setup
  * Android Studio may ask to overwrite a file. Select "Yes" if this is the case.
* In the top right corner of the screen, select "Edit Configurations" (see image below)
![Edit Configurations](https://imgur.com/undefined)
* Click on the "+" sign and select "Android App" (see image below)
![Select Android App](https://i.imgur.com/6rjAVGe.png)
* Then, set the module to "app" (see image below)
![Set module](https://i.imgur.com/6ZbDGDa.png)
* Finally, click on the run button (or press Shift+F10) to build and run the app

## Features
It features the implementation of features requested in the assignment specification, including:
* Provision of learning material from one of the courses in the School of Information Systems. In
this app, learning material for Object Oriented Programming from INFS1609 is provided.
* A form of assessing the user's knowledge of the course material. The app provides a multiple choice
quiz to test the user's knowledge on specific topics in OOP, with feedback on the user's progress
at the conclusion of the quiz.
* Use of an external API. OOPBuddy uses the MarkdownView API, GSON, the Google Cloud Translate API,
Material UI and the YouTube Player API to implement extra features in the app.

Extra features include:
* Simple course material extensibility. Extra learning material can be written for users with
Markdown, while quizzes are defined using JSON. No extra programming is required.
* YouTube video supplements. Users can supplement their learning with YouTube videos that can be
directly accessed within the app in each lesson.
* Auto-translated lessons. Each chapter can be translated into another language using the Google
Cloud Translate API.

## Credits
This app was made possible with the awesome API's from:
* Mukeshsolanki - https://github.com/mukeshsolanki/MarkdownView-Android
* Google
    * Google Cloud Translate
    * YouTube Player
    * GSON
    * Material Design Support Library

## Copyright and License
This code was written by Weilon Ying. You may make copies, distribute and make derivative works of
this work for any non-commercial purpose provided that you give me credit. The preferred way to
do this is simply providing a link to this GitHub repository.
