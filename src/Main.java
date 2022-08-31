import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Collects user input for string variables, includes validation
    public static String stringUserInput(String string) {
        Scanner reader = new Scanner(System.in);
        boolean incorrectInput = true;
        String userInput = "";
        while(incorrectInput) {
            System.out.print("Please enter your " + string + ": ");
            incorrectInput = reader.hasNextDouble();
            userInput = reader.nextLine();

            if(incorrectInput) {
                System.out.println("Please enter your " + string + ", not a number");
            }
        }
        return userInput;
    }

    // Collects user input for integer variables, includes validation
    public static int integerUserInput(String string) {
        Scanner reader = new Scanner(System.in);
        boolean incorrectInput = false;
        int userInput = 0;

        while(!incorrectInput) {
            System.out.print("Please enter your " + string + ": ");
            incorrectInput = reader.hasNextInt();

            try {
                userInput = Integer.parseInt(reader.nextLine());
            } catch(NumberFormatException e) {}

            if(!incorrectInput) {
                System.out.println("Please enter your " + string + ", as a number");
            }

        }
        return userInput;
    }

    // Collects user input for float variables, includes validation
    public static float floatUserInput(String string) {
        Scanner reader = new Scanner(System.in);
        boolean incorrectInput = false;
        float userInput = 0.0f;

        while(!incorrectInput) {
            System.out.print("Please enter your " + string + ": ");
            incorrectInput = reader.hasNextFloat();

            try {
                userInput = Float.parseFloat(reader.nextLine());
            } catch(NumberFormatException e) {}

            if(!incorrectInput) {
                System.out.println("Please enter your " + string + ", as a number");
            }

        }
        return userInput;
    }

    // Calls the string/integer/float userInput methods and return the variables within an instance of
    // the Person class
    public static Person userInput() {
        String name = stringUserInput("name");
        int age = integerUserInput("age");
        float height = floatUserInput("height");
        String gender = stringUserInput("gender");
        String hairColour = stringUserInput("hair colour");
        String emailAddress = stringUserInput("email address");

        return new Person(name, age, height, gender, hairColour, emailAddress);
    }

    // Iterates through the ArrayList of Objects (Person) and prints the attributes
    public static void displayEntries(ArrayList<Person> userEntries) {
        int entryNo = 1;
        for(Person entry : userEntries) {
            System.out.println("Entry : " + entryNo + " - " + entry);
            System.out.println("Name: " + entry.name());
            System.out.println("Age: " + entry.age());
            System.out.println("Height: " + entry.height() + "cm");
            System.out.println("Gender: " + entry.gender());
            System.out.println("Hair Colour: " + entry.hairColour());
            System.out.println("Email Address: " + entry.emailAddress());
            System.out.println();
            entryNo += 1;
        }
        entryNo = 1;
    }

    public static void main(String[] args) {
        ArrayList<Person> userEntries = new ArrayList<Person>();

        // Examples without having to manually enter data into the form:

        // Person person1 = new Person("Conor", 27, 179, "M", "Brown", "google.com");
        // Person person2 = new Person("Conor", 27, 179, "M", "Brown", "google.com");

       Person person1 = userInput();
       Person person2 = userInput();

       userEntries.add(person1);
       userEntries.add(person2);
       displayEntries(userEntries);
    }
}
