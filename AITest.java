/* CSC-207-01 Spring 2023
 * Names: Connor Durkin, Timur Kasimov
 * AI Lab
 * Acknowledgements: previous labs, textbook, prof. eliott
 */

/* Purpose: Creates agents that navigate a grid-like environment. 
 * Agents start in initialState (top left grid corner) and must navigate to finalState (bottom right grid corner).
 * 
 * Grid/Environment: Generated based on rows, columns, and agent strategy.
 * 
 * Movement: Based on the environment, agents have different probabilities for movement.
 * Agents can move up, down, left, right, or stay still. They cannot move outside the bounds of the grid.
 * 
 * Returns the average number and optimal number of steps these agents take in the environment to reach final state.
 */

public class AITest {
    public static void main(String[] args) {

        // create an array of agents
        Agent[] agentsArray = new Agent[1000]; // allocating array for 1000 agent
        for (int i = 0; i < 1000; i++) { // creating 1000 agents
            agentsArray[i] = new Agent();
        }

        // initialize 5 distinct environments
        Environment environment1 = new Environment(2, 3, 30, 10, 20, 10, 30); // all movement strategies must add up to
                                                                              // 100
        Environment environment2 = new Environment(2, 3, 10, 30, 10, 30, 20); // e.g. 10+30+10+30+20 = 100
        Environment environment3 = new Environment(3, 3, 20, 20, 20, 20, 20);
        Environment environment4 = new Environment(10, 3, 20, 20, 20, 20, 20);
        Environment environment5 = new Environment(5, 5, 15, 25, 14, 26, 20);

        // put environments in an array
        Environment[] environmentArray = { environment1, environment2, environment3, environment4, environment5 };

        // for-each loop to run and print the tests of each environment
        for (Environment e : environmentArray) {
            System.out.println("Test " + e.getEnvironmentID() + " (Agent Number: 1000)");

            for (Agent a : agentsArray) { // for each agent
                // while agent is not in environment's final state...
                while (a.getCurrentState() != e.getFinalState()) {
                    a.move(e); // ... play random action
                }
            }

            // calculating and printing average number of steps:
            double averageSteps = 0.0;
            for (Agent a : agentsArray) {
                averageSteps += a.getNumberOfSteps(); // add together steps of each agent
            }
            averageSteps /= agentsArray.length; // divide by the number of agents to get the average #steps
            System.out.println(
                    "Average Number of Steps: " + (int) averageSteps);

            // calculating and printing minimal number of steps:
            int minimalSteps = agentsArray[0].getNumberOfSteps();
            for (Agent a : agentsArray) {
                if (minimalSteps > a.getNumberOfSteps()) {
                    minimalSteps = a.getNumberOfSteps();
                }
            }
            System.out.println(
                    "Minimal Number of Steps: " + minimalSteps);
            System.out.println(); // extra line for readibility

            // reset the agents to be used in next environment
            Agent.resetAgents(agentsArray);
        } // end for-each loop for each environment
    }
}