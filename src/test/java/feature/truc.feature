Feature: Game of life next generation
  
Scenario: Passing next generation in an empty game of life field
Given a game of life field without any living cell
When this field pass to the next generation
Then i should found no living cells

Scenario: A living cell with no living neighbours dies of underpopulation.
Given a game of life field of 4 colums and 4 rows with a living cell at (0 , 0) 
When this field pass to the next generation
Then the cell at (0 , 0) should be dead

Scenario: A living cell with one living neighbours dies of underpopulation.
Given a game of life field of 4 colums and 4 rows with a living cell at (0 , 0) and it is living neigbours at
   | 0   | 1      |
When this field pass to the next generation
Then the cell at (0 , 0) should be dead

Scenario: A living cell with two living neighbours lives on to the next generation.
Given a game of life field of 4 colums and 4 rows with a living cell at (1 , 1) and it is living neigbours at
   | 0   | 0      |
   | 0   | 1      |
When this field pass to the next generation
Then the cell at (1 , 1) should be alive

Scenario: A living cell with three living neighbours lives on to the next generation.
Given a game of life field of 4 colums and 4 rows with a living cell at (1 , 1) and it is living neigbours at
   | 0   | 0      |
   | 0   | 1      |
   | 0   | 2      |
When this field pass to the next generation
Then the cell at (1 , 1) should be alive

Scenario: A dead cell with exactly three living neighbours becomes a living cell.
Given a game of life field of 4 colums and 4 rows with a dead cell at (1 , 1) and it is living neigbours at
   | 0   | 0      |
   | 0   | 1      |
   | 1   | 0      |
When this field pass to the next generation
Then the cell at (1 , 1) should be alive

Scenario: A living cell with more than three living neighbours dies of overcrowding.
Given a game of life field of 4 colums and 4 rows with a living cell at (1 , 1) and it is living neigbours at
   | 0   | 0      |
   | 0   | 1      |
   | 0   | 2      |
   | 1   | 0      |
When this field pass to the next generation
Then the cell at (1 , 1) should be dead