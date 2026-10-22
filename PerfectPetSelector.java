// Name: Tabriz Baloghlanli
//Date: October 21, 2026
// Description: Perfect Pet Selector program that asks the user for their favorite 
// color, season, and name, validates inputs, and determines their ideal pet.

import java.util.Scanner;

public class PerfectPetSelector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Get Color
        String color = "";
        boolean validColor = false;

        while (!validColor) {
            System.out.println("Enter your favorite color (Either red, blue or green):");
            color = scanner.nextLine().toLowerCase();

            if (color.equals("red") || color.equals("blue") || color.equals("green")) {
                validColor = true;
            } else {
                System.out.println("Invalid color. Please try again.");
            }
        }

        // 2. Get Season
        String season = "";
        boolean validSeason = false;

        while (!validSeason) {
            System.out.println("Enter your favorite season (winter, spring, summer, fall):");
            season = scanner.nextLine().toLowerCase();

            if (season.equals("winter") || season.equals("spring") || season.equals("summer") || season.equals("fall")) {
                validSeason = true; 
            } else {
                System.out.println("Invalid season. Please try again.");
            }
        }

        // 3. Get Name
        String name = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        boolean validName = false;

        while (!validName) {
            System.out.println("Enter your name:");
            name = scanner.nextLine();

            if (name.length() > 0) {
                // Check if the first character is in the alphabet string
                String firstChar = name.substring(0,1).toLowerCase();
                if (alphabet.indexOf(firstChar) >= 0) {
                    validName = true;
                } else {
                    System.out.println("Name must start with a letter. Please try again.");
                }
            } else {
                System.out.println("Name cannot be empty. Please try again.");
            }
        }

        //Determine if first letter is a vowel or consonant 
        String firstLetter = name.substring(0,1).toLowerCase();
        String vowels = "aeiou";

        boolean isVowel = vowels.indexOf(firstLetter) >= 0;
        boolean isConsonant = !isVowel;

        // 4. Determine Pet based on Rules
        String pet = "";

        if (color.equals("blue") && season.equals("fall")) {
            pet = "Alligator";
        } else if (color.equals("blue") && season.equals("spring")) {
            pet = "Ostrich";
        } else if (color.equals("green") && isConsonant && season.equals("winter")) {
            pet = "Giraffe";
        } else if (color.equals("green") && !season.equals("fall")) {
            pet = "Dog";
        } else if (color.equals("red")) {
            if (isVowel) {
                pet = "Porcupine";
            } else { 
                pet = "Panda";
            }
        } else if (season.equals("summer")) {
            pet = "Pony";
        } else if (isConsonant && color.equals("blue") && !season.equals("summer") && !season.equals("fall")) {
            pet = "Axolotl";
        } else {
            pet = "Pet Rock";
        }

        // Output result
        System.out.println("Your perfect pet is:" + pet);

        scanner.close();
    }
}