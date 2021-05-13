package fi.jnsknn.wng;

import java.util.Scanner;

import fi.jnsknn.wng.api.WeirdName;
import fi.jnsknn.wng.api.WeirdNameGenerator;
import fi.jnsknn.wng.api.impl.WeirdNameGeneratorImpl;

public class ConsoleUi {

	private static volatile boolean isRunning = true;

	private static boolean isRunning(String logText, Scanner scanner) {
		if (!isRunning) {
			return false;
		}
		System.out.println(logText);
		return scanner.hasNextLine();
	}

	// This program is for demonstrating what kind of names WeirdNameGenerator can
	// generate
	public static void main(String[] args) {

		System.out.println("ConsoleUi#main#isRunning: " + isRunning);

		try (Scanner scanner = new Scanner(System.in);) {
			while (isRunning("Your name: ", scanner)) {

				WeirdNameGenerator wng = new WeirdNameGeneratorImpl(scanner.nextLine());
				WeirdName weirdName = wng.generate();

				System.out.println("Your generated name is " + weirdName.getGeneratedName() + " ("
						+ weirdName.getFixedName() + ")");
				System.out.println("You were formerly known as " + weirdName.getOriginalName());

				System.out.println("Exit? (y/n): ");

				if ("y".equals(scanner.nextLine())) {
					isRunning = false;
				}
			}

		} catch (Exception e) {
			isRunning = false;
			System.err.println("ConsoleUi#main: " + e.getMessage());
		}

		System.out.println("ConsoleUi#main#isRunning: " + isRunning);

	}

}
