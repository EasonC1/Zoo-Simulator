public class Tiger extends Animal {

    public Tiger(String name, String species) {
        super(name, "Tiger");
    }

    @Override
    public void giveFood() {
        setHunger(Math.max(0, getHunger() - 30));
        setThirst(getThirst() + 15);
        setBoredom(getBoredom() + 15);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 30);
    }

    @Override
    public void giveWater() {
        setHunger(getHunger() + 15);
        setThirst(Math.max(0, getThirst() - 30));
        setBoredom(getBoredom() + 15);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);
    }

    @Override
    public void giveToy() {
        setHunger(getHunger() + 15);
        setThirst(getThirst() + 15);
        setBoredom(Math.max(0, getBoredom() - 30));
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 40);
    }
}
