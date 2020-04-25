package question3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("1.Validate Age\n2.Validate Name\n3.Lucky Custosmer");
		System.out.println("Enter the choice:");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch (choice) {
		case 1: {
			System.out.println("Enter birthdate:");
			SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
			Date birthdate = formater.parse(scanner.nextLine());
			if (validateAge(birthdate)) {
				System.out.println("Age is Valid");
			} else {
				System.out.println("Age is InValid");
			}

			break;
		}
		case 2: {
			System.out.println("Enter Name:");
			String name = scanner.nextLine();
			if (validateName(name)) {
				System.out.println("Name is valid");
			} else {
				System.out.println("Name is invalid");
			}
			break;
		}
		case 3: {
			System.out.println("Enter mobile number:");
			String mobile = scanner.nextLine();
			if (validateLuckyCustomer(mobile)) {
				System.out.println("Lucky Customer");
			} else {
				System.out.println("Unlucky Customer");
			}
			break;
		}
		default: {
			System.out.println("invalid choice");
			System.exit(0);
		}
		}

	}

	static Boolean validateName(String name) {
		char[] characters = name.toCharArray();

		for (char character : characters) {
			/*
			 * if (!((character >= 'a' && character <= 'z') || (character >= 'A' ||
			 * character <= 'Z'))) { return false; }
			 */

			if (!Character.isAlphabetic(character)) {
				return false;
			}

		}

		return true;
	}

	static Boolean validateAge(java.util.Date birth) {
		/*
		 * Date currentDate = new Date(2018 + 1900, 0, 1); int diff = birth.getYear() -
		 * currentDate.getYear(); if (diff >= 18) { return true; } else { return false;
		 * }
		 */

		/*
		 * 
		 * 
		 * 08 - 08 - 1993 06-02- 2011
		 * 
		 * 
		 */

		LocalDate currentDate = LocalDate.of(2018, 01, 01);
		LocalDate birthDate = LocalDate.of(birth.getYear() + 1900, birth.getMonth(), birth.getDate());
		LocalDate dateAfterEighteenYears = birthDate.plusYears(18);

		if (dateAfterEighteenYears.isBefore(currentDate) || dateAfterEighteenYears.isEqual(currentDate)) {
			return true;
		} else {
			return false;
		}

	}

	static Boolean validateLuckyCustomer(String mobile) {

		// 9494216610

		/*
		 * 
		 * Long mobileNo = Long.parseLong(mobile); while(mobileNo>9){ int rem =
		 * mobileNo%10; sum = sum +rem; }
		 * 
		 * mobileNo = sum;
		 * 
		 */

		while (mobile.length() > 1) {
			char[] characters = mobile.toCharArray();
			Integer sum = 0;
			for (char character : characters) {
				sum = sum + Integer.valueOf(String.valueOf(character));
			}
			// "42" -> for second iteration -> "6"
			mobile = String.valueOf(sum);
		}

		if (Integer.valueOf(mobile) == 1) {
			return true;
		} else {
			return false;
		}
	}

}
