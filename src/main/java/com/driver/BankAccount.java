package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

//    //**************Setters*********************
    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
//    //****************Getters************************
    public String getName() {
        return name;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getMinBalance() {
        return minBalance;
    }
//

    //*********Constructor**************
    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        if(sum > digits * 9){
            throw new Exception("Account Number can not be generated");
        }
        String acountNumber = "";
        int count = 0;
        while(sum > 0){
            if(sum >= 9){
                sum -= 9;
                acountNumber += "9";
            }
            else{
                acountNumber += sum;
                sum = 0;
            }
            count++;
        }

        while(count < digits){
            acountNumber += "0";
            count++;
        }

        //System.out.println(acountNumber);
        return acountNumber;
    }

    public void deposit(double amount) {
        //add amount to balance
        balance += amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if((balance - amount) > minBalance)
            throw new Exception("Insufficient Balance");
        else
            balance -= amount;
    }

}