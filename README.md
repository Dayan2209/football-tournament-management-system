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

## Author
Md.Dayan Anjum
