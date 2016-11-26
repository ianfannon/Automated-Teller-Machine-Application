/*
 * Created: 11/24/2016
 * Programmer: Ian James Fannon
 * An application that simulates an automated teller machine where you can 
 * deposit, withdraw, and print a statement with you information that gets
 * stored in a file;
 */
package atm;

import java.util.Scanner;

/**
 * @author Ian James Fannon
 */
public class Main {

    private static int value;
    private static Scanner scan = new Scanner(System.in);
    private static String retry = "yes";
    
    public static void main(String[] args) {
       
        ATM atm = new ATM();
        boolean again = false;
        do {
            atm.setFirstName();
            atm.setLastName();
            atm.setAccountNumber();
            
            System.out.println("Enter 1 for deposit\nEnter 2 for withdraw\nEnter 3 for account information\nEnter 4 to cancel: ");
            do {
                if (scan.hasNextInt()) {
                    value = scan.nextInt();
                    if (value == 1) {
                        atm.deposit();
                        tryAgain();
                        if (retry.equalsIgnoreCase("Yes")) {
                            again = false;
                        } else if (retry.equalsIgnoreCase("No")) {
                            System.exit(0);
                        }
                    } else if (value == 2) {       
                        atm.withdraw();
                        atm.calculation(atm.getWithdraw(), atm.getDeposit());
                        tryAgain();
                        if (retry.equalsIgnoreCase("Yes")) {
                            again = false;
                        } else if (retry.equalsIgnoreCase("No")) {
                            System.exit(0);
                        }
                    } else if (value == 3) {        
                        atm.getAccount(atm.getAccountNumber(), atm.getFirstName(), atm.getLastName(), atm.getBalance());
                        tryAgain();
                        if (retry.equalsIgnoreCase("Yes")) {
                            again = false;
                        } else if (retry.equalsIgnoreCase("No")) {
                            System.exit(0);
                        }
                    } else if (value == 4) { 
                            System.exit(0);
                    } 
                } else {
                    scan.next();
                }
            } while (value < 0 && value > 5);
        } while (!(again) && retry.equalsIgnoreCase("yes"));
        atm.closeScanner();
    }
    
    private static String tryAgain() {
        System.out.print("Do you have another transaction (yes/no): ");
        retry = scan.next();
        
        return retry;
    }
}
