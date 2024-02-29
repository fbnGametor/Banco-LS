// Objetivo: fazer com que o accountNumber acrescente a cada objeto conta criada.

package Application;

import Entities.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int accountNumber = 1;
        List<Account> accountList = new ArrayList<>();

        // Pegando dados do usuario
        System.out.println("Register your account!");
        System.out.print("Username: ");
        String username = sc.next();
        System.out.print("CPF: ");
        String cpf = sc.next();
        System.out.print("Password: ");
        String password = sc.next();

        Account newAccount = new Account(username, cpf, 0, password, accountNumber);
        accountList.add(newAccount);

        for (Account acc: accountList) {
            accountNumber++;
        }

        System.out.println("Username: " + newAccount.get_userName());
        System.out.println("CPF: " + newAccount.get_cpf());
        System.out.println("Password: " + newAccount.get_passWord());
        System.out.println("Your balance: " + newAccount.get_balance());
        System.out.println("Your account number: " + newAccount.get_accountNumber());

        sc.close();
    }
}