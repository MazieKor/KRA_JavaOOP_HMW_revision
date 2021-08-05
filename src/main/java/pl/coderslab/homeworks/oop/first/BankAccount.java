package pl.coderslab.homeworks.oop.first;

import java.util.Scanner;

public class BankAccount {
    private int number;
    private double cash = 0;  //NEW w inicjalizacji nie opieram się na default value

    public BankAccount(int number) {
        if (number <= 0) {   //NEW warunek w konstr.
            System.out.println("Account number must be greater than 0. Start again");
            throw new IllegalArgumentException("Number negative or 0");  //NEW: konstruktor i exception
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
                    "1.See your account information (acc. number and balance)  |  2.Add cash to your account  |" +
                    "  3.Withdraw cash from your account  |  4.Exit application");
            String chosenOption = scan.nextLine().trim();
            switch (chosenOption) {
                case "1":
                    String accountInfo = printInfo();   //NEW: kilka operacji bez { }
                    System.out.println(accountInfo);
                    continue choosingOperationLoop;  //NEW: bez breaka, a nie wywołuje następnych caseów
                case "2":
                    depositCash();
                    continue choosingOperationLoop;
                case "3":
                    withdrawCash();
                    continue choosingOperationLoop;
                case "4":
                    System.out.println("See you soon");
                    break choosingOperationLoop;
                default:
                    System.out.println("Number you chose is not on the list");
            }
        }
    }

    public void depositCash() {
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextDouble()){  //NEW int wchodzi jako double??
            System.out.println("please give cash you want to deposit");
            scanner.next();
        }
        double amount = scanner.nextDouble();
        if (amount < 0) {
            System.out.println("You can't add negative number in this metod. Try once again");
            return;
        }
        cash += amount;
        System.out.println(amount + " was added to account balance");
    }

    public double withdrawCash() {
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextDouble()){
            System.out.println("Incorrect number. Please give cash you want to withdraw");
        }


        if (amount < 0) {
            System.out.println("You can't add negative number in this metod. Try once again");
            throw new IllegalArgumentException("negative number");
        }
        if (amount <= cash) {
            cash -= amount;
            return amount;
        } else {
            System.out.println("You want to withdraw more than is your current account balance. Only " + cash + " was withdrawn");
            double withdraw = cash;
            cash = 0;
            return withdraw;
        }
    }

    public String printInfo() {
        StringBuilder accountData = new StringBuilder();
        accountData.append("Account number: ").append(number).append("\n").append("Account balance: ").append(cash);
        return accountData.toString();  //NEW: check this toString
    }
}