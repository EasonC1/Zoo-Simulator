
public class VirtualZooDriver {
    
    /**
     * The entry point of the Virtual Zoo simulation program. It creates a VirtualZoo object and starts the simulation.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        VirtualZoo zoo = new VirtualZoo();
        zoo.beginSimulation();
    }

}

