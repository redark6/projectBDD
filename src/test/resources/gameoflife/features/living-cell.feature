Feature: Evolving of living cell
	controlling the next generation living cell state for a game of life field of 3 rows and 3 columns

#         columns 
#
#         0   1   2
#			   ___ ___ ___
# r	 0	| . | . | . |
# o     |___|___|___|
# w	 1	| . | . | . |
# s     |___|___|___|
# 	 2	| . | . | . |
#       |___|___|___|
#
# positon of a cell will be abreviated by: (row , column)

Scenario: A central living cell with no living neighbours dies of underpopulation.
Given a game of life field with a living cell at (1 , 1)
When this field pass to the next generation
Then the cell at (1 , 1) should be dead

Scenario: A central living cell with one living neighbour dies of underpopulation.
Given a game of life field with a living cell at (1 , 1) and it is living neigbours at
   | 0 | 0 |
When this field pass to the next generation
Then the cell at (1 , 1) should be dead

Scenario: A central living cell with two living neighbours lives on to the next generation.
Given a game of life field with a living cell at (1 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 1 |
When this field pass to the next generation
Then the cell at (1 , 1) should be alive

Scenario: A central living cell with three living neighbours lives on to the next generation.
Given a game of life field with a living cell at (1 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 1 |
   | 0 | 2 |
When this field pass to the next generation
Then the cell at (1 , 1) should be alive

Scenario: A central living cell with four living neighbours dies of overcrowding.
Given a game of life field with a living cell at (1 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 1 |
   | 0 | 2 |
   | 1 | 0 |
When this field pass to the next generation
Then the cell at (1 , 1) should be dead

Scenario: A central living cell with five living neighbours dies of overcrowding.
Given a game of life field with a living cell at (1 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 1 |
   | 0 | 2 |
   | 1 | 0 |
   | 1 | 2 |
When this field pass to the next generation
Then the cell at (1 , 1) should be dead

Scenario: A central living cell with six living neighbours dies of overcrowding.
Given a game of life field with a living cell at (1 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 1 |
   | 0 | 2 |
   | 1 | 0 |
   | 1 | 2 |
   | 2 | 0 |
When this field pass to the next generation
Then the cell at (1 , 1) should be dead

Scenario: A central living cell with seven living neighbours dies of overcrowding.
Given a game of life field with a living cell at (1 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 1 |
   | 0 | 2 |
   | 1 | 0 |
   | 1 | 2 |
   | 2 | 0 |
   | 2 | 1 |
When this field pass to the next generation
Then the cell at (1 , 1) should be dead

Scenario: A central living cell with eight living neighbours dies of overcrowding.
Given a game of life field with a living cell at (1 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 1 |
   | 0 | 2 |
   | 1 | 0 |
   | 1 | 2 |
   | 2 | 0 |
   | 2 | 1 |
   | 2 | 2 |
When this field pass to the next generation
Then the cell at (1 , 1) should be dead



Scenario: A corner living cell with no living neighbours dies of underpopulation.
Given a game of life field with a living cell at (0 , 0)
When this field pass to the next generation
Then the cell at (0 , 0) should be dead

Scenario: A corner living cell with one living neighbour dies of underpopulation.
Given a game of life field with a living cell at (0 , 0) and it is living neigbours at
   | 1 | 0 |
When this field pass to the next generation
Then the cell at (1 , 1) should be dead

Scenario: A corner living cell with two living neighbours lives on to the next generation.
Given a game of life field with a living cell at (0 , 0) and it is living neigbours at
   | 1 | 0 |
   | 0 | 1 |
When this field pass to the next generation
Then the cell at (0 , 0) should be alive

Scenario: A corner living cell with three living neighbours lives on to the next generation.
Given a game of life field with a living cell at (0 , 0) and it is living neigbours at
   | 1 | 0 |
   | 0 | 1 |
   | 1 | 1 |
When this field pass to the next generation
Then the cell at (0 , 0) should be alive



Scenario: An edge living cell with no living neighbours dies of underpopulation.
Given a game of life field with a living cell at (0 , 1)
When this field pass to the next generation
Then the cell at (1 , 0) should be dead

Scenario: An edge living cell with one living neighbour dies of underpopulation.
Given a game of life field with a living cell at (0 , 1) and it is living neigbours at
   | 0 | 0 |
When this field pass to the next generation
Then the cell at (0 , 1) should be dead

Scenario: An edge living cell with two living neighbours lives on to the next generation.
Given a game of life field with a living cell at (0 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 2 |
When this field pass to the next generation
Then the cell at (0 , 1) should be alive

Scenario: An edge living cell with three living neighbours lives on to the next generation.
Given a game of life field with a living cell at (0 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 2 |
   | 1 | 1 |
When this field pass to the next generation
Then the cell at (0 , 1) should be alive

Scenario: An edge living cell with four living neighbours dies of overcrowding.
Given a game of life field with a living cell at (0 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 2 |
   | 1 | 1 |
   | 1 | 0 |
When this field pass to the next generation
Then the cell at (0 , 1) should be dead

Scenario: An edge living cell with five living neighbours dies of overcrowding.
Given a game of life field with a living cell at (0 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 2 |
   | 1 | 1 |
   | 1 | 0 |
   | 1 | 2 |
When this field pass to the next generation
Then the cell at (0 , 1) should be dead