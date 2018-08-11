/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compoundinterest;

/**
 *
 * @author kyle
 */
public class Control {
    
    // Constructor
    public void Control(){
        
    }
    
    // Return total money saved (retire)
    public double grandTotal(double currentAge, double retireAge, 
           double initialInvest, double annualAdd, double assumeInt){
        
        double age = retireAge - currentAge;
        
        double convInterest = (assumeInt/100)+1;
        System.out.println("Age: " + age);
        System.out.println("Interest: " + convInterest);
        
        Double balance = (initialInvest * convInterest) + annualAdd;
        System.out.println("Year: 1 Balance: " + balance);
        
        for (int years = 1; years < age; years++){
            balance = (balance * convInterest) + annualAdd;
            System.out.println("Year: " + (years+1));
            System.out.println("Balance: $" + balance);
        }
        return balance;
    }
    
    // Return total money saved (custom)
    public double grandTotal(double years, double initialInvest,
                             double annualAdd, double assumeInt){
        
        double convInterest = (assumeInt/100)+1;
        System.out.println("Age: " + years);
        System.out.println("Interest: " + convInterest);
        
        Double balance = (initialInvest * convInterest) + annualAdd;
        System.out.println("Year: 1 Balance: " + balance);
        
        for (int count = 1; count < years; count++){
            balance = (balance * convInterest) + annualAdd;
            System.out.println("Year: " + (count+1));
            System.out.println("Balance: $" + balance);
        }
        return balance;
    }
    
    // Return a double of the total invested
    public double moneyInvested(Double initial, Double annualAdd, Double years){
        double saved;
        saved = initial + (annualAdd * years);
        return saved;
    }
    
    // Return a double of the total earned off of the investment
    public double totalEarned(Double grandTotal, Double saved){
        double earned; 
        earned = grandTotal - saved;
        return earned;
    }
    
    public String addCommas(double getDouble)
    {
        String returnString;
        int convertToInt = (int)getDouble; // Casts double to int
        System.out.println("Double received: "+getDouble+"\nCast int: "+convertToInt);
        
        // Count the int's number of digits
        int intLength = String.valueOf(convertToInt).length();
        System.out.println("Int length: "+intLength);
        // Create array of chars of the int value
        returnString = ""+convertToInt;
        char[] intArray = returnString.toCharArray();
        // Create an array of the same length to reverse the digits into
        char[] flippedIntArray = new char[intLength];

        // Make a new array for adding 1 comma
        if (intLength > 3 && intLength <= 6)
        {
            // The char arrays for the final result
            char[] commaArray = new char[intLength+1];
            char[] flippedCommaArray = new char[intLength+1];
            
            int flippedCount = intLength-1; // Counting device
            // Feed chars from intArray backwards into flippedIntArray
            for (int count = 0; count < intLength; count++)
            {
                flippedIntArray[count] = intArray[flippedCount];
                System.out.println("Backwards feed #"+count+"-Char: "+flippedIntArray[count]);
                flippedCount--;
            }
            // Feed the flipped array into a new array that has a comma
            for (int count = 0; count <= intLength; count++)
            {
                if (count < 3) // load in chars 0-2
                {
                commaArray[count] = flippedIntArray[count];
                System.out.println("Char #"+count+"-"+commaArray[count]);
                }
                else if (count == 3) // load in char 3 as a comma
                {
                commaArray[count] = ',';
                System.out.println("Char #"+count+"-"+commaArray[count]);
                }
                else if (count > 3) // load in char 4-6
                {
                commaArray[count] = flippedIntArray[count-1];
                System.out.println("Char #"+count+"-"+commaArray[count]);
                }
            }
            // Reverse the comma array back forward
            flippedCount = intLength;
            for (int count = 0; count <= intLength; count++)
            {
                flippedCommaArray[count] = commaArray[flippedCount];
                System.out.println("**--> ReverseChar: "+flippedCommaArray[count]);
                flippedCount--;
            }
            returnString = new String(flippedCommaArray);
            System.out.println("Return String: "+returnString);
        }
        
        // Make a new array for adding 2 commas
        else if (intLength > 6 && intLength <= 9)
        {
            // The char array for the final result
            char[] commaArray = new char[intLength+2];
            char[] flippedCommaArray = new char[intLength+2];
            
            int flippedCount = intLength-1; // Counting device
            // Feed chars from intArray backwards into flippedIntArray
            for (int count = 0; count < intLength; count++)
            {
                flippedIntArray[count] = intArray[flippedCount];
                System.out.println("Backwards feed #"+count+"-Char: "+flippedIntArray[count]);
                flippedCount--;
            }
            // Feed the flipped array into a new array that has a comma
            for (int count = 0; count <= intLength+1; count++)
            {
                if (count < 3) // load in chars 0-2
                {
                commaArray[count] = flippedIntArray[count];
                System.out.println("Char #"+count+"-"+commaArray[count]);
                }
                else if (count == 3) // load in char 3 as a comma
                {
                commaArray[count] = ',';
                System.out.println("Char #"+count+"-"+commaArray[count]);
                }
                else if (count > 3 && count < 7) // load in char 4-6
                {
                commaArray[count] = flippedIntArray[count-1];
                System.out.println("Char #"+count+"-"+commaArray[count]);
                }
                else if (count == 7) // add the 2nd comma
                {
                commaArray[count] = ',';
                System.out.println("Char #"+count+"-"+commaArray[count]);
                }
                else if (count > 7) // load in char 7-9
                {
                commaArray[count] = flippedIntArray[count-2];
                System.out.println("Char #"+count+"-"+commaArray[count]);
                }
            }
            // Reverse the comma array back forward
            flippedCount = intLength+1;
            for (int count = 0; count < intLength+2; count++)
            {
                flippedCommaArray[count] = commaArray[flippedCount];
                System.out.println("**--> ReverseChar: "+flippedCommaArray[count]);
                flippedCount--;
            }
            returnString = new String(flippedCommaArray);
            System.out.println("Return String: "+returnString);
        }
        // Always tack on a dollar sign
        returnString = "$"+returnString;
        return returnString;
    }
}
