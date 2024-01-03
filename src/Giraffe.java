public class  Giraffe extends Animal {

    public  Giraffe(String name, String species) {
        super(name, "Giraffe");
    }

    @Override
    public void giveFood() {
        setHunger(Math.max(0, getHunger() - 50));
        setThirst(getThirst() + 30);
        setBoredom(getBoredom() + 20);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 100);
    }

    @Override
    public void giveWater() {
        setHunger(getHunger() + 20);
        setThirst(Math.max(0, getThirst() - 50));
        setBoredom(getBoredom() + 30);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 40);
    }

    @Override
    public void giveToy() {
        setHunger(getHunger() + 30);
        setThirst(getThirst() + 10);
        setBoredom(Math.max(0, getBoredom() - 40));
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 75);
    }
}
