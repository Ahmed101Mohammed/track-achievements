# track-achievements
Track your daily achievements to know your real productivity and progress. Here you will see the actual value of your habits.

## Project description

### App features:
The application can help you to track your daily achievement, and many analysis services to show your progress, This is the big picture of the app services:
-  Adding measuring achievement standard: With this service, you can choose a measuring standard for your achievement. such as: you want to track your reading books for one hour by adding the number of pages that you read in the day, and track your hour achievements across days.
- Tracking daily achievement: This service uses the previous one and asks you what you achieved today for each measuring achievement standard you recorded before.
- Analyses service: Here you will have 7 services until now, help you to make several analytics for your achievements.

### App technologies:
For this app, I used these technologies:
- Java programming language: for training reasons.
- SQLite DB: The app is simple and I find that it will be enough.
- Class diagrams with UML: This is one of the main reasons for building the app. I learned about this diagram and its principles and I built this project to test my knowledge.
- JDBC driver: I used this driver to reference my app to help my Java code communicate with SQLite.

### Main challenges I face in this project:
There are main challenges that I faced from the beginning of the planning for the application to the end of this process, and these are the main challenges:
- In the beginning of the planning I find it's a challenge problem to determine the relations between my classes.
- In the middle of the project I found a specific problem with the MeasuringAchievemntStandard class, And I solved it by changing my class diagrams by adding a new class called MesuringAchievementStandardServices.
- At the end of the project I found a problem with the DB with a complex conditional command, that gave me strange results, and I solved it by making my conditions more specific and logical by just adding parentheses "()".

## Installing and Runing
### Install the project:
To install the project you can open your terminal and enter this command:
```
git clone https://github.com/Ahmed101Mohammed/track-achievements.git
```
### Run the project:
If you expert than me I expect that you can run this project in way easy than I am. What I will explain is takes some time because I can use the project only in the VS code terminal.
follow these steps:
#### First Step:
If you don't have extensions to run Java code install these extensions from vs code extensions:
- Extension Pack for Java (This extension contains all the extensions you need).
#### Second Step:
Install the jar file of [this website](https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc/3.42.0.1)
#### Third Step:
Open the project folder with vs code by typing:
```
code .
```
In the terminal when being in the directory of the project "track-achievements".
#### Fourth Step:
- In VS code environment in the EXPLORER tap, you will find at the bottom this tap: "> JAVA PROJECTS".
- Click on the tap and you will see a new tap called: "> [] track-achievements".
- Click on it and many taps will appear, Make the mouse over on this tap: "> [] Referenced Libraries"
- Then the plus + sign will appear. Press it and find the file that you installed in the ***Therd Step***.

#### Fifth Step (finally):
In the VS Code environment go to the **App** folder and open **Main.java** file.
about the **main** method, you will find ***Run*** word, Press it.
The project will run in a terminal and you can use it.

## How to use the APP:
Flow this Youtube video instructions: [track-achievements tutorial video](https://youtu.be/AOA8S3uyT2g). 

## MIT License:
MIT License

Copyright (c) 2023 Ahmed Mohamed 3adl

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

## How you can Contribute
I expect that you know how to fork and pull in GitHub.
All you can do is: pull your contribution with none strange files. And a deep explanation about the bug that you solved or the feature that you added.
I hope you find a better way to run the app and upgrade the ReadMe file with it. But this way should work with me to accept it.
Thanks.