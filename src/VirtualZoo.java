import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Starts the virtual zoo simulation.
 * It displays a welcome message, allows the user to select animals, and runs a one-week simulation.
 */
public class VirtualZoo {
    private final ArrayList<String> nameList = new ArrayList<>();
    private final Scanner scan;
    private static int totalCost;

    public static int getTotalCost() {
        return totalCost;
    }

    public static void setTotalCost(int totalCost) {
        VirtualZoo.totalCost = totalCost;
    }

    public VirtualZoo() {
        scan = new Scanner(System.in);
    }

    public void beginSimulation() {
        displayWelcome();
        ArrayList<Animal> zooAnimals = animalSelection();
        weekCycle(zooAnimals);
    }

    //-------------------------operational methods------------------------------

    /**
     * Displays a welcome message for the virtual zoo application.
     */
    public void displayWelcome() {
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("|                     Welcome to the Virtual Zoo!                      |");
        System.out.println("|     Use this application to simulate running a zoo over one week     |");
        System.out.println("|           This program is intended for zoo employees only!           |");
        System.out.println("+----------------------------------------------------------------------+");
    }

    /**
     * Asks the user for the number of animals in the zoo.
     *
     * @return The number of animals entered by the user.
     */
    public int askNumberAnimals() {
        int input;
        System.out.println("How many animals are at your zoo?");
        try {
            input = scan.nextInt();
            scan.nextLine();
            if (input <= 0) {
                System.out.println("Please enter a positive number of animals");
                return askNumberAnimals();
            } else
                return input;
        } catch (InputMismatchException e) {
            scan.nextLine();
            System.out.println("Please enter a valid number of animals");
            return askNumberAnimals();
        }
    }

    /**
     * Asks the user for the name of an animal.
     *
     * @param id The ID of the animal to name.
     * @return The name of the animal.
     */
    public String askAnimalName(int id) {
        while (true) {
            System.out.println("What is the name of animal #" + id + "?");
            String name = scan.nextLine();
            if (nameList.contains(name)) {
                System.out.println("That name is already taken");
            } else {
                nameList.add(name);
                return name;
            }
        }
    }

    /**
     * Asks the user for the species of an animal and creates an animal instance.
     *
     * @param name The name of the animal.
     * @return An instance of the selected animal species.
     */
    public Animal askAnimalSpecies(String name) {
        String species;
        loop:
        while (true) {
            System.out.println("What is the species of " + name + "?");
            species = scan.nextLine();
            switch (species.toLowerCase()) {
                case "tiger" -> {
                    species = "Tiger";
                    return new Tiger(name, species);
                }
                case "giraffe" -> {
                    species = "Giraffe";
                    return new Giraffe(name, species);
                }
                case "hippo" -> {
                    species = "Hippo";
                    return new Hippo(name, species);
                }
                case "panda" -> {
                    species = "Panda";
                    return new Panda(name, species);
                }
                case "monkey" -> {
                    species = "Monkey";
                    return new Monkey(name, species);
                }
                default -> System.out.println("That is not a valid species");
            }
        }
    }

    /**
     * Asks the number, name and species of animals
     *
     * @return the arraylist of animal
     */
    public ArrayList<Animal> animalSelection() {
        int number = askNumberAnimals();
        System.out.println();
        ArrayList<Animal> animalList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            String name = askAnimalName(i + 1);
            Animal a = askAnimalSpecies(name);
            animalList.add(a);
        }
        return animalList;
    }
    /**
     * Asks the user for an item to give to an animal and performs the corresponding action.
     *
     * @param animal The animal to receive the item.
     */
    public void askItem(Animal animal) {
        while (true) {
            System.out.println("What item would you like to give to " + animal.getName() + "?");
            String item = scan.next();
            item = item.toLowerCase();
            if (!item.equals("food") && !item.equals("water") && !item.equals("toy")) {
                System.out.println("That is not a valid item");
            } else if (item.equals(animal.getLastItem())) {
                System.out.println("You cannot give the same item as yesterday");
            } else {
                animal.setLastItem(item);
                if (item.equals("food")) {
                    animal.giveFood();
                } else if (item.equals("water")) {
                    animal.giveWater();
                } else if (item.equals("toy")) {
                    animal.giveToy();
                }
                if (animal.isDead()) {
                    System.out.println(animal.getName() + " has died");
                    totalCost += 1000;
                }
                break;
            }
        }
    }
    /**
     * Simulates a one-week cycle of interactions with zoo animals.
     *
     * @param zooAnimals The list of zoo animals.
     */
    public void weekCycle(ArrayList<Animal> zooAnimals) {
        String[] day = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (int i = 0; i < 7; i++) {
            System.out.println("\nThe current day is " + day[i] + "\n");
            for (Animal animal : zooAnimals
            ) {
                System.out.println(animal.toString());
            }
            for (int i1 = 0; i1 < zooAnimals.size(); i1++) {
                Animal animal = zooAnimals.get(i1);
                if (!animal.isDead())
                    askItem(animal);
            }
        }
        System.out.println();
        System.out.println("Total week cost = $" + getTotalCost());
    }
}