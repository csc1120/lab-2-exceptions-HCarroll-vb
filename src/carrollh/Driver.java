/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Hunter Carroll
 * Last Updated: 9/10/2024
 */
package carrollh;

import java.util.Scanner;

/**
 * Driver class that runs the whole program
 */
public class Driver {
    /**
     * Constant for minimum number of dice
     */
    public static final int MIN_DICE = 2;
    /**
     * Constant for max number of dice
     */
    public static final int MAX_DICE = 10;

    /**
     * Main class to run user input
     * @param args that run the code
     */
    public static void main(String[] args) {
        System.out.print("Please enter the number of dice to roll, ");
        System.out.print("how many sides the dice have,");
        System.out.println("and how many rolls to complete, separating the values by a space.");

        int[] array = getInput();
        try {
            Die[] dieArray = createDice(array[0], array[1]);
            int[] rolls = rollDice(dieArray, array[1], array[2]);
            report(array[0], rolls, findMax(rolls));
        } catch(DieNotRolledException e){
            e.getMessage();
        } catch(ArithmeticException e){
            System.out.println(" ");
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Bad die creation: Illegal number of sides: " + array[1]);
        } catch(NegativeArraySizeException e) {
            System.out.println();
        }
    }

    /**
     * Grabs user input and transforms into array
     * @return array of user input
     */
    private static int[] getInput(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter configuration:");
        final int max = 3;
        int[] arr = new int[max];
        try{
            String ans = input.nextLine();
            arr[0] = Integer.parseInt(ans.substring(0, ans.indexOf(" ")));
            arr[1] = Integer.parseInt(ans.substring(ans.indexOf(" ") + 1,
                    ans.indexOf(" ", ans.indexOf(" ") + 1)));
            arr[2] = Integer.parseInt(ans.substring(ans.indexOf(" ", ans.indexOf(" ") + 1) + 1));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: All values must be whole numbers.");
        } catch(StringIndexOutOfBoundsException e) {
            System.out.println("Invalid input: Expected 3 values but only received 2");
        }
        if(arr[0] < MIN_DICE || arr[0] > MAX_DICE) {
            System.out.println("Invalid Input: Number of die outside expected.");
        }
        return arr;
    }

    /**
     * Creates array of Die objects
     * @param numDice number of dice to roll
     * @param numSides sides per die
     * @return array of Die that can be rolled
     */
    private static Die[] createDice(int numDice, int numSides){
        Die[] dice = new Die[numDice];
        for(int i = 0; i < numDice; i++){
            dice[i] = new Die(numSides);
        }
        return dice;
    }

    /**
     * Rolls dice
     * @param dice array of die
     * @param numSides sides per die
     * @param numRolls total rolls
     * @return array of die roll values
     */
    private static int[] rollDice(Die[] dice, int numSides, int numRolls){
        int[] results = new int[dice.length * (numSides - 1) + 1];
        for(int j = 0; j < results.length; j++){
            results[j] = 0;
        }
        for(int i = 0; i < numRolls; i++){
            int sum = 0;
            for(int k = 0; k < dice.length; k++) {
                dice[k].roll();
                sum += dice[k].getCurrentValue();
            }
            results[sum - dice.length]++;
            sum = 0;
        }
        return results;
    }

    /**
     * Finds max num rolls value
     * @param rolls array of rolls
     * @return max value
     */
    private static int findMax(int[] rolls){
        int max = 0;
        for(int i = 0; i < rolls.length; i++){
            if(rolls[i] > max){
                max = rolls[i];
            }
        }
        return max;
    }

    /**
     * Reports the normal model of values
     * @param numDice number of dice
     * @param rolls array of rolls and amounts
     * @param max max number
     */
    private static void report(int numDice, int[] rolls, int max){
        final int percentVal = 10;
        int scale = max / percentVal;
        for(int i = numDice; i <= rolls.length + (numDice - 1); i++){
            int numStars = rolls[i - numDice] / scale;
            System.out.print(i + "\t:" + rolls[i - numDice] + "\t");
            for(int j = 0; j < numStars; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}