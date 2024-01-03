public abstract class Animal {
    private String name;
    private String species;
    private int hunger;
    private int thirst;
    private int boredom;
    private String lastItem;

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
        this.hunger = 50;
        this.thirst = 50;
        this.boredom = 50;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getBoredom() {
        return boredom;
    }

    public void setBoredom(int boredom) {
        this.boredom = boredom;
    }

    public String getLastItem() {
        return lastItem;
    }

    public void setLastItem(String lastItem) {
        this.lastItem = lastItem;
    }

    public void giveFood() {
    }

    public void giveWater() {
    }

    public void giveToy() {
    }

    /**
     * Checks if the animal is dead based on its hunger, thirst, and boredom levels.
     *
     * @return True if the animal is considered dead, false otherwise.
     */
    public boolean isDead() {
        return hunger < 0 || thirst < 0 || boredom < 0 || hunger > 100 || thirst > 100 || boredom > 100;
    }

    /**
     * Generates a string representation of the animal's status, including name, species, hunger, thirst, and boredom levels.
     *
     * @return A string representation of the animal's status.
     */
    public String toString() {
        String statusMessage = isDead() ? "Name = " + getName() + " (Dead)\n" : "Name = " + getName() + "\n";
        statusMessage += "Species = " + getSpecies() + "\n";
        statusMessage += "Hunger = " + getHunger() + "\n";
        statusMessage += "Thirst = " + getThirst() + "\n";
        statusMessage += "Boredom = " + getBoredom() + "\n";
        return statusMessage;
    }

}
