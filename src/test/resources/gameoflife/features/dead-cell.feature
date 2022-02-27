Feature: Evolving of dead cell
	controlling the next generation dead cell state for a game of life field of 3 rows and 3 columns

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
# positon of a cell will be abreviated by: (column , row)

Scenario: Passing next generation in an empty game of life field
Given a game of life field without any living cell
When this field pass to the next generation
Then i should found no living cells

Scenario: A central dead cell with no living remains dead
Given a game of life field with a dead cell at (1 , 1)
When this field pass to the next generation
Then the cell at (1 , 1) should be dead

Scenario: A central dead cell with one living neighbour remains dead
Given a game of life field with a dead cell at (1 , 1) and it is living neigbours at
   | 0 | 0 |
When this field pass to the next generation
Then the cell at (1 , 1) should be dead

Scenario: A central dead cell with two living neighbours remains dead
Given a game of life field with a dead cell at (1 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 1 |
When this field pass to the next generation
Then the cell at (1 , 1) should be dead

Scenario: A central dead cell with three living neighbours become alive
Given a game of life field with a dead cell at (1 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 1 |
   | 0 | 2 |
When this field pass to the next generation
Then the cell at (1 , 1) should be alive

Scenario: A central dead cell with four living neighbours remains dead
Given a game of life field with a dead cell at (1 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 1 |
   | 0 | 2 |
   | 1 | 0 |
When this field pass to the next generation
Then the cell at (1 , 1) should be dead

Scenario: A central dead cell with five living neighbours remains dead
Given a game of life field with a dead cell at (1 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 1 |
   | 0 | 2 |
   | 1 | 0 |
   | 1 | 2 |
When this field pass to the next generation
Then the cell at (1 , 1) should be dead

Scenario: A central dead cell with six living neighbours remains dead
Given a game of life field with a dead cell at (1 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 1 |
   | 0 | 2 |
   | 1 | 0 |
   | 1 | 2 |
   | 2 | 0 |
When this field pass to the next generation
Then the cell at (1 , 1) should be dead

Scenario: A central dead cell with seven living neighbours remains dead
Given a game of life field with a dead cell at (1 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 1 |
   | 0 | 2 |
   | 1 | 0 |
   | 1 | 2 |
   | 2 | 0 |
   | 2 | 1 |
When this field pass to the next generation
Then the cell at (1 , 1) should be dead

Scenario: A central dead cell with eight living neighbours remains dead
Given a game of life field with a dead cell at (1 , 1) and it is living neigbours at
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



Scenario: A corner dead cell with no living neighbours remains dead
Given a game of life field with a dead cell at (0 , 0)
When this field pass to the next generation
Then the cell at (0 , 0) should be dead

Scenario: A corner dead cell with one living neighbour remains dead
Given a game of life field with a dead cell at (0 , 0) and it is living neigbours at
   | 1 | 0 |
When this field pass to the next generation
Then the cell at (1 , 1) should be dead

Scenario: A corner dead cell with two living neighbours remains dead
Given a game of life field with a dead cell at (0 , 0) and it is living neigbours at
   | 1 | 0 |
   | 0 | 1 |
When this field pass to the next generation
Then the cell at (0 , 0) should be dead

Scenario: A corner dead cell with three living neighbours become alive
Given a game of life field with a dead cell at (0 , 0) and it is living neigbours at
   | 1 | 0 |
   | 0 | 1 |
   | 1 | 1 |
When this field pass to the next generation
Then the cell at (0 , 0) should be alive



Scenario: An edge dead cell with no living neighbours remains dead
Given a game of life field with a dead cell at (0 , 1)
When this field pass to the next generation
Then the cell at (0 , 1) should be dead

Scenario: An edge dead cell with one living neighbour remains dead
Given a game of life field with a dead cell at (1 , 0) and it is living neigbours at
   | 0 | 0 |
When this field pass to the next generation
Then the cell at (0 , 1) should be dead

Scenario: An edge dead cell with two living neighbours remains dead
Given a game of life field with a dead cell at (0 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 2 |
When this field pass to the next generation
Then the cell at (0 , 1) should be dead

Scenario: An edge dead cell with three living neighbours  become alive
Given a game of life field with a dead cell at (0 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 2 |
   | 1 | 1 |
When this field pass to the next generation
Then the cell at (0 , 1) should be alive

Scenario: An edge dead cell with four living neighbours remains dead
Given a game of life field with a dead cell at (0 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 2 |
   | 1 | 1 |
   | 1 | 0 |
When this field pass to the next generation
Then the cell at (0 , 1) should be dead

Scenario: An edge dead cell with five living neighbours remains dead
Given a game of life field with a dead cell at (0 , 1) and it is living neigbours at
   | 0 | 0 |
   | 0 | 2 |
   | 1 | 1 |
   | 1 | 0 |
   | 1 | 2 |
When this field pass to the next generation
Then the cell at (0 , 1) should be dead