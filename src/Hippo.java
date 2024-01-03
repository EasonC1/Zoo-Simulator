public class  Hippo extends Animal {

    public  Hippo(String name, String species) {
        super(name, "Hippo");
    }

    @Override
    public void giveFood() {
        setHunger(Math.max(0, getHunger() - 25));
        setThirst(getThirst() + 5);
        setBoredom(getBoredom() + 25);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 50);
    }

    @Override
    public void giveWater() {
        setHunger(getHunger() + 5);
        setThirst(Math.max(0, getThirst() - 25));
        setBoredom(getBoredom() + 25);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 50);
    }

    @Override
    public void giveToy() {
        setHunger(getHunger() + 20);
        setThirst(getThirst() + 20);
        setBoredom(Math.max(0, getBoredom() - 50));
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);
    }
}
