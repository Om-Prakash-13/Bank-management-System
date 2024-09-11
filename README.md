# Bank Management System

## Overview

The **Bank Management System** is a Java-based console application designed to manage user accounts, allowing customers to deposit money, withdraw funds, transfer money between accounts, and view account balances. The system also allows for account creation and secure access to accounts using a username and password.

## Features

- **Account Creation:** Create a new account with a username, password, and an optional initial deposit.
- **Deposit Funds:** Add money to your account at any time.
- **Withdraw Funds:** Securely withdraw money from your account with sufficient balance.
- **View Balance:** Check your current account balance.
- **Transfer Money:** Transfer money to another account using their username.
- **Secure Access:** User authentication using a username and password.

## System Flow

1. **Main Menu**
   - Create a new account.
   - Manage an existing account.
   - Exit the application.

2. **Account Management**
   - Deposit funds.
   - Withdraw funds.
   - View balance.
   - Transfer money.
   - Quit account management.

## How to Run

1. Clone or download this repository.
2. Open the project in your favorite Java IDE.
3. Run the `BankingSystem` class.
4. Follow the on-screen instructions to create and manage bank accounts.

## Classes

### `account`

The `account` class represents a user account with the following functionalities:
- **deposit(amount):** Adds the specified amount to the account balance.
- **withdraw(amount):** Withdraws the specified amount if the balance is sufficient and the user is authenticated.
- **viewBalance():** Displays the current account balance if the user is authenticated.
- **moneyTransfer(myAC, othAC, amount):** Transfers money from one account to another if both accounts are valid and the transfer is confirmed by the user.
- **validate():** Private method to authenticate the user with a username and password.

### `bankingSystem`

This is the main class that drives the Bank Management System. It handles:
- **Account creation:** Allows users to set up a new account.
- **Account management:** Provides users with options to manage their accounts, including deposits, withdrawals, and transfers.
- **System control:** Runs the overall system by providing the main menu and guiding the user through different options.

## Example Usage

### Create an Account
```bash
1. Create a new account 
2. Manage your account 
3. To close the app 
Enter any option: 1
Set user name: 
om
Set password: 
om
Enter 1 if you want to deposit any amount now. other wise press any other button.
1
Enter the amount you want to deposit: 
100
1. Create a new account 
2. Manage your account 
3. To close the app 
Enter any option: 1
Set user name: 
ritesh
Set password: 
ritesh
Enter 1 if you want to deposit any amount now. other wise press any other button.
1
Enter the amount you want to deposit: 
200
1. Create a new account 
2. Manage your account 
3. To close the app 
Enter any option: 2
Enter username: 
ritesh
1. deposit
2. withdraw
3. view balance
4. Transfer Money
5. Quit
Enter to perform any task: 4
Enter 1 to confirm Money transfer: 
1
Enter the username of the person to whom you want to transfer money: 
om
Enter the amount you want to transfer: 
50
Enter Username: 
ritesh
Enter password: 
ritesh
If you want to view balance press 1 otherwise press any key
1
Your balance is: 150
1. deposit
2. withdraw
3. view balance
4. Transfer Money
5. Quit
Enter to perform any task: 5
