package pl.coderslab.homeworks.oop.first;

import java.util.Scanner;

public class BankAccount {
    private final String RED = "\033[0;31m";   //for simplifying I use in the same class
    private final String RESET = "\033[0m";

    private int number;
    private double cash = 0;

    public BankAccount(int number) {
        if (number <= 0) {
            System.out.println(RED + "Account number must be greater than 0. Start again" + RESET);
            throw new IllegalArgumentException("Number negative or 0");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public double getCash() {
        return this.cash;
    }

    public void chooseOperation() {
        Scanner scan = new Scanner(System.in);
        choosingOperationLoop:
        while (true) {
            System.out.println("Please choose number, what you want to do:" + "\n" +
                    "1.See your account number and balance  |  2.Add cash to your account  |" +
                    "  3.Withdraw cash from your account  |  4.Exit application");
            String chosenOption = scan.nextLine().trim();
            switch (chosenOption) {
                case "1":
                    String accountInfo = printInfo();
                    System.out.println(accountInfo);
                    continue choosingOperationLoop;
                case "2":
                    depositCash();
                    continue choosingOperationLoop;
                case "3":
                    try {
                        double withdrawAmount = withdrawCash();
                        System.out.println(withdrawAmount + " was withdrawn from your account");
                    } catch (IllegalArgumentException e){
                    }
                    continue choosingOperationLoop;
                case "4":
                    System.out.println("See you soon");
                    break choosingOperationLoop;
                default:
                    System.out.println(RED + "Number you chose is not on the list" + RESET);
            }
        }
    }

    public void depositCash() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write how much you want to deposit");
        while(!scanner.hasNextDouble()){
            System.out.println(RED + "Incorrect number. Please give cash you want to deposit" + RESET);
            scanner.next();                //I use simplified version of validation
        }
        double amount = scanner.nextDouble();
        if (amount < 0) {
            System.out.println(RED + "You can't add negative number in this method. Try once again" + RESET);
            return;
        }
        cash += amount;
        System.out.println(amount + " was added to account balance");
    }

    public double withdrawCash() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write how much you want to withdraw");
        while(!scanner.hasNextDouble()){
            System.out.println(RED + "Incorrect number. Please give cash you want to withdraw" + RESET);
            scanner.next();                 //I use simplified version of validation
        }
        double amount = scanner.nextDouble();
        if (amount < 0) {
            System.out.println(RED + "You can't add negative number in this method. Try once again" + RESET);
            throw new IllegalArgumentException("negative number");  //I throw exception to exit method (differently than in depositCash void method where I used return;)
        }
        if (amount <= cash) {
            cash -= amount;
            return amount;
        }
        System.out.print(RED + "You wanted to withdraw more than is your current account balance. " + RESET);
        double withdraw = cash;
        cash = 0;
        return withdraw;
    }

    public String printInfo() {
        StringBuilder accountData = new StringBuilder();
        accountData.append("Account number: ").append(number).append("\n").append("Account balance: ").append(cash);
        return accountData.toString();
    }
}