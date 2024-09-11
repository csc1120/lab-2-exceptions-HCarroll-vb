/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Hunter Carroll
 * Last Updated: 9/10/2024
 */
package carrollh;

import java.util.Scanner;

public class Driver {
    public final int MIN_DICE = 2;
    public final int MAX_DICE = 10;

    public static void main(String[] args) {

    }

    private static int[] getInput(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter configuration:");
        int count = 0;
        final int Max = 3;
        int[] arr = new int[Max];
        try{
            while(count < Max){
                arr[count] = input.nextInt();
                count++;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: All values must be whole numbers.");
        }
        return arr;
    }

    private static Die[] createDice(int numDice, int numSides){
        Die[] dice = new Die[numDice];
        for(int i = 0; i < numDice; i++){
            dice[i] = new Die(numSides);
        }
        return dice;
    }

    private static int[] rollDice(Die[] dice, int numSides, int numRolls){
        int[] results = new int[dice.length * 5 + 1];
        for(int j = 0; j < results.length; j++){
            results[j] = 0;
        }
        for(int i = 0; i < numRolls; i++){
            int sum = 0;
            for(int k = 0; k < dice.length; k++) {
                dice[k].roll();
                sum += dice[k].getCurrentValue()
            }
            results[sum - 2] = results[sum - 2] + 1;
        }
        return results;
    }

    private static int findMax(int[] rolls){

    }

    private static void report(int numDice, int[] rolls, int max){

    }
}