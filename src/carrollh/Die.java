/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Hunter Carroll
 * Last Updated: 9/11/2024
 */
package carrollh;

/**
 * Die class used for each individual die.
 */
public class Die {
    /**
     * Constant for minSides
     */
    public final int MIN_SIDES = 2;
    /**
     * constant for maxSides
     */
    public final int MAX_SIDES = 100;

    private int currentValue;
    private int numSides;

    /**
     * Constructor to instantiate the die
     * @param numSides The number of sides of the die
     */
    public Die(int numSides){
        try{
            if(numSides <= MAX_SIDES && numSides >= MIN_SIDES){
                this.numSides = numSides;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Bad die creation: Illegal number of sides: " + numSides);
        }
    }

    /**
     * Get current value method to get current value
     * @return the current value or DieNotRolledException
     */
    public int getCurrentValue(){
        try{
            if(currentValue <= numSides && currentValue > 0){
                int value = currentValue;
                currentValue = 0;
                return value;
            }
        } catch(DieNotRolledException e){
            e.getMessage();
        }
        currentValue = 0;
        return 0;
    }

    /**
     * Rolls the die.
     */
    public void roll(){
        currentValue = (int)(Math.random() * numSides) + 1;
    }
}