/*
 * Created: 11/24/2016
 * Programmer: Ian James Fannon
 * An application that simulates an automated teller machine where you can 
 * deposit, withdraw, and print a statement with you information that gets
 * stored in a file;
 */
package atm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Ian James Fannon
 */
public final class ATM {
    private String firstName, lastName;
    private Float withdraw;
    private Float deposit;
    private Float balance;
    private int accountNumber;
    private Scanner scan = new Scanner(System.in);
    private NumberFormat format = NumberFormat.getCurrencyInstance();
    
    public ATM() {
        firstName = "";
        lastName = "";
        withdraw = 0.0f;
        deposit = 0.0f;
        accountNumber = 0;
        balance = 0.0f;
    }
    
    /**
     * A method to store various information to a file and print it to 
     * the console
     * @param accountNumber is the field that stores the account number.
     * @param firstName is the field that stores the users first name.
     * @param lastName is the field that stores the users last name.
     * @param balance is the field that stores the users balance.
     */
    public void getAccount(int accountNumber, String firstName, String lastName, float balance) {
        File file = new File("accounts.txt");
        PrintWriter output = null;
        try {
            output = new PrintWriter(file);
            output.println("Account Number: " + accountNumber);
            System.out.println("Account Number: " + accountNumber);
            output.println("FirstName: " + firstName);
            System.out.println("FirstName: " + firstName);
            output.println("Last name: " + lastName);
            System.out.println("Last name: " + lastName);
            output.println("Balance: " + format.format(balance));
            System.out.println("Balance: " + format.format(balance));
            output.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found " + ex.getMessage());
        }
    }    
    
    /**
     * A method to obtain the users first name.
     * @return the users first name in the field firstName.
     */
    public String setFirstName() {
        try {
            do {
                System.out.print("Enter first name: ");
                firstName = scan.next();
            } while (!firstName.matches("[a-zA-Z]+"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return firstName;
    }
    
    /**
     * A method to obtain the users last name.
     * @return the users last name in the field lastName.
     */
    public String setLastName() {
        try {
            do {
                System.out.print("Enter last name: ");
                lastName = scan.next();
            } while (!lastName.matches("[a-zA-Z]+"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return lastName;
    }
    
    /**
     * A method to randomly produce an integer for the account number and 
     * print it to the console.
     * @return the account number in the field accountNumber.
     */
    public int setAccountNumber() {
        Random rand = new Random();
        try {
            accountNumber = rand.nextInt(10000) + 1;
            System.out.println("Your account number is #" + accountNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return accountNumber;
    }
    /**
     * A method to withdraw money from the users account.
     * @return the field withdraw that stores the amount that was withdrawn.
     */
    public Float withdraw() {
        boolean isNumber;
        do {    
            System.out.print("Withdraw Ammount: ");
            if (scan.hasNextFloat()) {
                withdraw = scan.nextFloat();
                isNumber = true;
            } else {
                System.out.println("Invalid Input");
                isNumber = false;
                scan.next();
            }
        } while (!(isNumber));
        return withdraw;
    }
    
    /**
     * A method to obtain how much the user would like to deposit into their
     * account. 
     * @return the field deposit which stores the amount deposited.
     */
    public Float deposit() {
        boolean isNumber;
        do {    
            System.out.print("Deposit Ammount: ");
            if (scan.hasNextFloat()) {
                deposit = scan.nextFloat();
                isNumber = true;
            } else {
                System.out.println("Invalid Input");
                isNumber = false;
                scan.next();
            }
        } while (!(isNumber));
        return deposit;
    }
    /**
     * A method to calculate the amount to be withdrawn or deposited.
     * @param withdraw is the field which stores the amount to be withdrawn.
     * @param deposit is the field which stored the amount to be deposited.
     * @return 
     */
    public Float calculation(Float withdraw, Float deposit) {
            balance += deposit;
            if (balance >= withdraw) {
                balance -= withdraw;
            } else {
                System.out.println("Insufficient Funds");
            }
        return balance;
    }
    /**
     * A method to close the Scanner object instance.
     */
    public void closeScanner() {
        scan.close();
    }
    
    /**
     * An accessor method for the field firstName.
     * @return the users first name.
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * An accessor method for the field lastName.
     * @return the users last name.
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * An accessor method for the field balance.
     * @return the users account balance.
     */
    public Float getBalance() {
        return balance;
    }
    
    /**
     * An accessor method for the field accountNumber.
     * @return the users randomly generated account number.
     */
    public int getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * An accessor method for the field withdraw.
     * @return the amount withdrawn from the users account.
     */
    public Float getWithdraw() {
        return withdraw;
    }
    
    /**
     * An accessor method for the field deposit.
     * @return the amount deposited from the users account.
     */
    public Float getDeposit() {
        return deposit;
    }
}
