package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		Double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();

		Account ac = new Account(number, holder, balance, withdrawLimit);

		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		Double amount = sc.nextDouble();

		try {
			ac.withdraw(amount);
			System.out.println("New Balance: " + String.format("%.2f", ac.getBalance()));
		} catch (DomainExceptions e) {
			System.out.println("WithDraw Erro: " + e.getMessage());
		}

		sc.close();

	}

}
