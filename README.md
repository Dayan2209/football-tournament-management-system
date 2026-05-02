# Football Tournament Management System
This project is a Java-based system that simulates a football-style tournament where each team plays every other team.


## Features
- Automatic match generation using nested loops
- Score input for each match
- Points calculation (Win: 3, Draw: 1, Loss: 0)
- Leaderboard ranking system
- Goal Difference (GD) used as a tiebreaker
- Tracks wins, losses, draws, goals scored (GF) and goals conceded (GA)


## How It Works
The program takes team names as input and generates fixtures such that each team plays every other team once.
For each match, the user enters scores, and the system updates:
- Matches played
- Points
- Wins, losses, and draws
- Goals scored and conceded

After all matches are completed, teams are sorted based on:
1. Total points
2. Goal difference (if points are equal)

The final leaderboard is displayed with full team statistics.


## Concepts Used
- Arrays
- Nested loops
- Conditional statements
- Sorting (Bubble Sort)
- Basic data handling


## How to Run
1. Compile the program using a Java compiler
2. Run the main class
3. Enter team names and match scores as prompted


## Sample Output
Example:

enter number of teams
3
enter team names
Barcelona
Liverpool
Frankfurt
Barcelona vs Liverpool
enter goals scored by team Barcelona
5
enter goals scored by team Liverpool
3
winner of the match is team Barcelona

Barcelona vs Frankfurt
enter goals scored by team Barcelona
3
enter goals scored by team Frankfurt
0
winner of the match is team Barcelona

Liverpool vs Frankfurt
enter goals scored by team Liverpool
4
enter goals scored by team Frankfurt
2
winner of the match is team Liverpool


                                        SCOREBOARD
1. Team Barcelona      Matches : 2  Wins : 2  Losses : 0  Draws : 0  G/F : 8  G/A : 3  G/D : 5  Points : 6
2. Team Liverpool      Matches : 2  Wins : 1  Losses : 1  Draws : 0  G/F : 7  G/A : 7  G/D : 0  Points : 3
3. Team Frankfurt      Matches : 2  Wins : 0  Losses : 2  Draws : 0  G/F : 2  G/A : 7  G/D : -5  Points : 0



## Future Improvements
- Add graphical user interface (GUI)
- Store data using files
- Support knockout tournaments

## Author
Md.Dayan Anjum
