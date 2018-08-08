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
    
    // Return a string with commas of the received double
    public String addCommas(double getDouble){
        String modifiedDouble;
        int doubleLength = 0;
        modifiedDouble = ""+getDouble;
        System.out.println("getDouble = "+modifiedDouble);
        char[] doubleArray = modifiedDouble.toCharArray();
        System.out.println("doubleArray length: "+doubleArray.length); 
        // Count the number of chars until a '.'
        for (int n = 0; n<doubleArray.length; n++)
        {
            System.out.println("[n count: "+n+"]");
            System.out.println("Char: "+doubleArray[n]);
            // If char '.' is found
            if (doubleArray[n] == '.')
            {
                System.out.println("[Found '.'] at Char#"+n);
                doubleLength = n;
            }
        }
        // Create a char array of only the numbers before the period
        char[] loadOnlyInt = new char[doubleLength];
        // Creates arrays with commas loaded for different digit lengths
        char[] newIntArray4to6 = new char[doubleLength+1];
        char[] newIntArray7to9 = new char[doubleLength+2];
        char[] newIntArray10to12 = new char[doubleLength+3];
        char[] newIntArray13to15 = new char[doubleLength+4];
        // Load in the values for the only int array
        for (int n = 0; n<doubleLength; n++)
        {
            loadOnlyInt[n] = doubleArray[n];
            System.out.println("Load only ints: "+loadOnlyInt[n]);
        }
            // add comma to 4 digit
            if (doubleLength == 4)
            {
                newIntArray4to6[0] = loadOnlyInt[0];
                System.out.println("New int array: "+newIntArray4to6[0]);
                // Add the comma into row 2
                newIntArray4to6[1] = ',';
                System.out.println("New int array: "+newIntArray4to6[1]);
                for (int x = 2; x<=doubleLength; x++)
                {
                    newIntArray4to6[x] = loadOnlyInt[x-1];
                    System.out.println("New int array: "+newIntArray4to6[x]);
                    System.out.println("Int: "+x);
                }
                String getString = "$";
                getString += new String(newIntArray4to6);
                modifiedDouble = getString;
            }
            // else add comma to 5 digit
            else if (doubleLength == 5)
            {
                newIntArray4to6[0] = loadOnlyInt[0];
                newIntArray4to6[1] = loadOnlyInt[1];
                System.out.println("New int array: "+newIntArray4to6[0]+newIntArray4to6[1]);
                // Add the comma into row 3
                newIntArray4to6[2] = ',';
                for (int x = 3; x<=doubleLength; x++)
                {
                    newIntArray4to6[x] = loadOnlyInt[x-1];
                    System.out.println("New int array: "+newIntArray4to6[x]);
                    System.out.println("Int: "+x);
                }
                String getString = "$";
                getString += new String(newIntArray4to6);
                modifiedDouble = getString;
            }
        // Return the double modified with commas
        System.out.println("Modified double = "+modifiedDouble);
        return modifiedDouble;
    }
}
