package ui;

import generator.GenerateName;

public class NameGeneratorUi {

	public static void main(String[] args) {
		// This program is for demonstrating what kind of names WeirdNameGenerator can generate
		try{
			String input = System.console().readLine("Your name: ");
			
			GenerateName name = new GenerateName(input);
			
			System.out.println("Your new name is " + name.returnName() + "!");
			System.out.println("Your new fixed name is " + name.fixName() + "!");
			
		}catch(Exception e){
			System.out.println("Error:" + e.getMessage());
		}

	}

}
