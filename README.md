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

# Description of correctSubActivityTest
The `correctSubActivityTest` class contains a test method called `test_correctSubActivity_buttonClick()`
that verifies whether the correct sub-activity is launched when a button is clicked.

## Steps
1. The `ActivityScenarioRule` is created with the `MainActivity` class as the parameter. 
   This rule launches the activity before the test begins and closes it after the test is completed.
2. The `setUp()` method is called before the test starts. This method initializes the `Intents` class, 
   which is used for testing activities that launch other activities.
3. The `test_correctSubActivity_buttonClick()` method begins by simulating a click on the navigation quiz button 
   in the main activity. This is done using the `onView()` method, which locates the view with the ID `R.id.navigation_quiz` and performs a click on it.
4. Next, the method locates the button with ID `R.id.button6` and performs a click on it using the `onView()` method.
5. Finally, the `intended()` method is used to verify that the correct sub-activity, `QuizActivity`, 
   is launched. This is done by creating a `ComponentName` object with the application context and the name of the sub-activity, 
   and passing it to the `hasComponent()` matcher. The `intended()` method then checks whether an intent was sent with this component.

## Expected Result
The expected result of this test is that the correct sub-activity, `QuizActivity`, is launched when the button with ID `R.id.button6` is clicked.

## Implementation
The `test_correctSubActivity_buttonClick()` method implements the test by using the `ActivityScenarioRule`,
the `Intents` class, and the `onView()` and `intended()` methods from the Espresso testing framework. 
The `@LargeTest` annotation is used to indicate that this test requires some time to execute and should not be run during every build, 
most functional ui tests are large tests.

# Description of correctScoreTest
The `correctScoreTest` class contains a test method called `test_correctScore()`
that is meant to verify that the score gets updated correctly after a button with an answer is pressed.

This test method is unfinished.

# Description of correctScoreTest
The `registeredImagesTest` class contains a test method called `test_correctNumberOfImages()`
that is meant to verify that the number of registered images is correct after adding/deleting and entry.

This test method is unfinished.