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
}
