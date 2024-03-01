// Objetivo 1: fazer com que o accountNumber acrescente a cada objeto conta criada.
// Objetivo 2: mudar o metodo transfer da SavingsAccount.

package Application;

import Entities.SavingsAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int accountNumber = 1;
        List<SavingsAccount> accountList = new ArrayList<>();

        // Pegando dados do usuario
        System.out.println("Register your account!");
        System.out.print("Username: ");
        String username = sc.next();
        System.out.print("CPF: ");
        String cpf = sc.next();
        System.out.print("Password: ");
        String password = sc.next();

        SavingsAccount newAccount = new SavingsAccount(username, cpf, 0, password, accountNumber);
        accountList.add(newAccount);

        SavingsAccount newAccount2 = new SavingsAccount(username, cpf, 0, password, accountNumber);

        for (SavingsAccount acc: accountList) {
            accountNumber++;
        }

        System.out.println("Username: " + newAccount.get_userName());
        System.out.println("CPF: " + newAccount.get_cpf());
        System.out.println("Password: " + newAccount.get_passWord());
        System.out.println("Your balance: " + newAccount.get_balance());
        System.out.println("Your account number: " + newAccount.get_accountNumber());

        System.out.println("Your balance: " + newAccount.get_balance());
        System.out.println("Your balance: " + newAccount2.get_balance());

        newAccount.deposit(300);
        newAccount.transfer(newAccount2,200.0);

        System.out.println("Your balance: " + newAccount.get_balance());
        System.out.println("Your balance: " + newAccount2.get_balance());

        sc.close();
    }
}