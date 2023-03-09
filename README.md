# DAT153 Quiz App

Welcome to the DAT153 Quiz App, a fun and interactive quiz application for Android devices. This app was developed as a project for the "DAT153" class at HVL.

## Features
- Quiz
- A timer for each quiz question
- A score display
- Database
- Option to add new items to database

## Getting Started

To run the DAT153 Quiz App on your Android device, follow these steps:
1. Clone or download the repository to your computer.
2. Open the project in Android Studio, and run in your emulator (API 33)

# Android testing with Gradle

## Which apk is used during testing?

During testing the app-debug-androidTest.apk is used. This can be found at build/outputs/apk/androidTest/debug/app-debug-androidTest.apk

## Which adb commands does gradle use to install and run the tests on the emulator?

After using apkTool to inspect the contents of the apk we found that gradle uses the following adb commands:

1. adb -s emulator-5554 install build/outputs/apk/androidTest/debug/app-debug-androidTest.apk
 This is to install the apk on the emulator.

2. adb -s emulator-5554 shell am start -n com.example.quizzapp/androidx.test.runner.AndroidJUnitRunner -e debug false -e class 'com.example.myapp.ExampleEspressoTest'
This is to run the tests on the emulator