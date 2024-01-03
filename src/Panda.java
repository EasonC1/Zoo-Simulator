public class  Panda extends Animal {

    public  Panda(String name, String species) {
        super(name, "Panda");
    }

    @Override
    public void giveFood() {
        setHunger(Math.max(0, getHunger() - 25));
        setThirst(getThirst() + 15);
        setBoredom(getBoredom() - 5);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 70);
    }

    @Override
    public void giveWater() {
        setHunger(getHunger() + 40);
        setThirst(Math.max(0, getThirst() - 80));
        setBoredom(getBoredom() + 10);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5);
    }

    @Override
    public void giveToy() {
        setHunger(getHunger() + 40);
        setThirst(getThirst() + 15);
        setBoredom(Math.max(0, getBoredom() - 40));
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);
    }
}
