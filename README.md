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