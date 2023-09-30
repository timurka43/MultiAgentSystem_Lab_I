# MultiAgentSystem_Lab_I

This is the **first** lab in the series of 3 lab projects designed to introduce Multi-Agent Systems (MAS) as a base used later for Machine Learning research. 
Note that these series do not feature any Machine Learning, only MAS. I completed these labs in my OO Programming, Data Structures, and Algorithms class.

Here is a short description of what exactly this program does:

_Purpose:_ Creates agents that navigate a grid-like environment. Agents start in initialState (top left grid corner) and must navigate to finalState (bottom right grid corner). 
_Grid/Environment:_ Generated based on rows, columns, and agent strategy.
_Movement:_ Based on the environment that agents are in, agents have different probabilities associated with movement in any direction. Agents can move up, down, left, right, or stay still. They cannot move outside the bounds of the grid.
            
The program returns the average number and optimal number of steps that agents take to reach the final state in the environment (averaged over 1,000 agents).
