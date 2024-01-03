public class Monkey extends Animal {

    public Monkey(String name, String species) {
        super(name, "Monkey");
    }

    @Override
    public void giveFood() {
        setHunger(Math.max(0, getHunger() - 30));
        setThirst(getThirst() + 10);
        setBoredom(getBoredom() + 10);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5);
    }

    @Override
    public void giveWater() {
        setHunger(getHunger() + 10);
        setThirst(Math.max(0, getThirst() - 40));
        setBoredom(getBoredom() + 10);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5);
    }

    @Override
    public void giveToy() {
        setHunger(getHunger() + 10);
        setThirst(getThirst() + 10);
        setBoredom(Math.max(0, getBoredom() - 15));
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 15);
    }
}
