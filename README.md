# Football Tournament Management System (Java)

This project is a Java-based program that simulates a football tournament. It supports both **Round Robin** and **Knockout** formats, allowing users to choose how the tournament is conducted.


## Overview

The system takes team names as input and manages the entire tournament flow — from match generation to final results. It calculates scores, tracks team performance, and displays results in a structured leaderboard.


## Features

- Supports two formats:
  - **Round Robin** (each team plays every other team)
  - **Knockout** (loser is eliminated each round)
- Automatic match generation
- User input for match scores
- Points system:
  - Win: 3 points  
  - Draw: 1 point  
  - Loss: 0 points  
- Tracks:
  - Matches played  
  - Wins, losses, draws  
  - Goals scored (GF) and conceded (GA)  
  - Goal Difference (GD)  
- Leaderboard ranking based on:
  1. Total points  
  2. Goal difference (tiebreaker)  
- Displays round-by-round progression in knockout mode


## How It Works

After entering the number of teams and their names, the user selects the tournament format.


### Round Robin
Each team plays every other team once. Scores are entered for each match, and the system updates all statistics. Teams are then ranked based on points and goal difference.


### Knockout
Teams are paired for each round. Winners move on to the next round, and the process repeats until one final winner remains.


## Concepts Used

- Arrays for data storage  
- Nested loops for match generation  
- Conditional logic for match results  
- Sorting (Bubble Sort) for leaderboard ranking  
- Basic control structures (if-else, switch)


## Notes

- Knockout mode requires an even number of teams  
- Draws are not allowed in knockout matches


## How to Run

1. Compile the program in a java compiler
2. Run the main class
3. Enter team details and follow prompts


## Author

Md.Dayan Anjum
