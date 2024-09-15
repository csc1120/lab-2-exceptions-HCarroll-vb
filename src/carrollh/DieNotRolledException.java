/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Hunter Carroll
 * Last Updated: 9/11/2024
 */
package carrollh;

/**
 * DieNotRolledException class to test if currentValue is in range of Die
 */
public class DieNotRolledException extends RuntimeException {

    /**
     * Message that not correct type is used
     * @return exception message if thrown
     */
    @Override
    public String getMessage(){
        return "currentValue not in expected range of die";
    }
}
