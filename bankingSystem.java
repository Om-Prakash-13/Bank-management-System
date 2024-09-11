package Bank;

import java.util.HashMap;
import java.util.Scanner;
class account {
    private Scanner sc = new Scanner(System.in);
    private int balance;
    private String Username;
    private String password;

    public void deposit(int amount){
        this.balance += amount;
    }

    public boolean withdraw(int amount){
        if (validate()){
            if(amount > this.balance){
                System.out.println("You do not have sufficient balance to withdraw.");
                return false;
            }
            this.balance -= amount;
            System.out.println("If you want to view balance press 1 otherwise press any key");
            int n = sc.nextInt();
            if(n == 1){
                System.out.println("Your balance is: "+this.balance);
            }
            return true;
        }
        else{
            System.out.println("Incorrect username or password.");
            return false;
        }
    }

    public void viewBalance(){
        if (validate()){
            System.out.println("Your balance is: "+balance);
        }
        else System.out.println("Incorrect username or password.");
    }

    public void moneyTransfer(account myAC, account othAC, int amount){
        boolean flag = myAC.withdraw(amount);
        if(flag) othAC.deposit(amount);
    }

    private boolean validate(){
        System.out.println("Enter Username: ");
        String un = sc.next();
        System.out.println("Enter password: ");
        String pw = sc.next();
        return un.equals(this.Username) && pw.equals(this.password);
    }

    account(String Username, String password){
        this.Username = Username;
        this.password = password;
        this.balance = 0;
    }
    account(String Username, String password, int balance){
        this.Username = Username;
        this.password = password;
        this.balance = balance;
    }

}

public class bankingSystem {
    static HashMap<String, account> bank = new HashMap<>();
    static void bankWork(account myAC){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. deposit");
            System.out.println("2. withdraw");
            System.out.println("3. view balance");
            System.out.println("4. Transfer Money");
            System.out.println("5. Quit");
            System.out.print("Enter to perform any task: ");
            int option = sc.nextInt();
            if(option == 1){
                System.out.println("Enter the amount you want to deposit: ");
                int amount = sc.nextInt();
                myAC.deposit(amount);
            }
            else if (option == 2){
                System.out.println("Enter the amount you want to withdraw: ");
                int amount = sc.nextInt();
                myAC.withdraw(amount);
            }
            else if (option == 3){
                myAC.viewBalance();
            }
            else if (option == 4) {
                System.out.println("Enter 1 to confirm Money transfer: ");
                int confirm = sc.nextInt();
                if(confirm == 1){
                    System.out.println("Enter the username of the person to whom you want to transfer money: ");
                    String othUn = sc.next();
                    if(bank.containsKey(othUn)){
                        account othAC = bank.get(othUn);
                        System.out.println("Enter the amount you want to transfer: ");
                        int amount = sc.nextInt();
                        myAC.moneyTransfer(myAC,othAC,amount);
                    }else{
                        System.out.println("You entered Wrong username of the costumer.");
                    }
                }
            }
            else if (option == 5) {
                break;
            }
            else {
                System.out.println("Invalid input. Enter a correct option.");
            }
        }while (true);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1. Create a new account ");
            System.out.println("2. Manage your account ");
            System.out.println("3. To close the app ");
            System.out.print("Enter any option: ");
            int option = sc.nextInt();
            if(option == 1){
                System.out.println("Set user name: ");
                String username = sc.next();
                System.out.println("Set password: ");
                String password = sc.next();
                System.out.println("Enter 1 if you want to deposit any amount now. other wise press any other button.");
                option = sc.nextInt();
                int amount = 0;
                if(option == 1){
                    System.out.println("Enter the amount you want to deposit: ");
                    amount = sc.nextInt();
                }
                bank.put(username, new account(username,password,amount));
            } else if (option == 2) {
                System.out.println("Enter username: ");
                String username = sc.next();
                if(bank.containsKey(username)){
                    account myAC = bank.get(username);
                    bankWork(myAC);
                }
                else System.out.println("Wrong username: ");
            }
            else if (option == 3) break;
            else System.out.println("Enter correct username and password: ");
        }while (true);
    }
}