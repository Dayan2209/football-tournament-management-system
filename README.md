# Football Tournament Management System (Java)

This is a Java program that simulates a football tournament
It supports both **Round Robin** and **Knockout** formats so you can choose how the tournament runs

## Overview

The program takes team names as input and manages the full tournament flow
from generating matches to giving final results

It keeps track of scores updates team stats and shows a clear leaderboard

## Features

* Supports two formats

  * **Round Robin** each team plays every other team
  * **Knockout** loser gets eliminated each round

* Automatic match generation

* User input for match scores

* Points system

  * Win 3 points
  * Draw 1 point
  * Loss 0 points

* Tracks

  * Matches played
  * Wins losses draws
  * Goals scored GF and conceded GA
  * Goal Difference GD

* Leaderboard ranking based on

  1. Total points
  2. Goal difference if points are equal

* Shows round by round progress in knockout mode

## How It Works

Enter number of teams and team names
Then choose the tournament format

### Round Robin

Each team plays every other team once
You enter match scores and the system updates all stats
Teams are ranked based on points and then goal difference

### Knockout

Teams are paired each round
Winners move forward
This continues until one team wins the tournament

## Concepts Used

* Arrays for storing data
* Nested loops for generating matches
* Conditional logic for results
* Sorting using bubble sort for rankings
* Basic control structures like if else and switch

## Notes

* Knockout mode needs number of teams as a power of 2
* Draws are not allowed in knockout matches

## How to Run

1. Compile the program
2. Run the main class
3. Enter team details and follow prompts

## Author

Md Dayan Anjum
