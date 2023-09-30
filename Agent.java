/* CSC-207-01 Spring 2023
 * Names: Connor Durkin, Timur Kasimov
 * AI Lab
 * Acknowledgements: previous labs, textbook, prof. eliott
 */

// Creates Agent class to navigate the grid/environment. 
// Agents store an ID, currentState, and the number of steps they took to reach finalState.

import java.util.*; //for Random

public class Agent {

    // instance fields
    private static int nextID = 1;
    private static Random rand = new Random(System.nanoTime());

    private int agentID;
    private int currentState;
    private int numberOfSteps;

    // constructor
    Agent() {
        this.agentID = nextID;
        nextID++;
        this.currentState = 1;
        this.numberOfSteps = 0;

    }

    // methods
    public int getAgentID() {
        return agentID;
    }

    public int getCurrentState() {
        return currentState;
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    // process an agent's move
    public void move(Environment environment) {
        int number = rand.nextInt(100) + 1; // random integer between 1 and 100 (both inclusive) that defines agent's
                                            // strategy
        this.currentState = environment.nextState(getCurrentState(), number); // get the environment to process the move
        this.numberOfSteps++; // increment the number of steps

        // TESTING OUTPUT BELOW
        // System.out.println("Agent ID: " + getID());
        // System.out.println("Current State: " + getCurrentState());
        // System.out.println("Number of Steps: " + getNumberOfSteps());
        // System.out.println();
    }

    // resets the agent in the array to be used in another test or environment
    public static void resetAgents(Agent[] agentsArray) {
        for (Agent a : agentsArray) {
            a.currentState = 1;
            a.numberOfSteps = 0;
        }
    }

}