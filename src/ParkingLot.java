import java.util.*;

public class ParkingLot {
    private int lotLevel; //floor level of the parking lot
    private ArrayList<String> slotsPerLevel; //slots per level
    private int availableSmallSpots = 2;
    private int availableMediumSpots = 5;
    private int availableLargeSpots = 3;

    private HashMap<String, String> occupied = new HashMap<String, String>();

    private List<ParkingLotSlotsPerLevel> motorcycleSpotsFree = new ArrayList<>();
    private List<ParkingLotSlotsPerLevel> carSpotsFree = new ArrayList<>();
    private List<ParkingLotSlotsPerLevel> truckSpotsFree = new ArrayList<>();
    List<ParkingLotSlotsPerLevel> listOfSpots = new ArrayList<>();

    public ParkingLot() {     //create a constructor
        this.motorcycleSpotsFree = addSpots(availableSmallSpots, "small");
        this.carSpotsFree = addSpots(availableMediumSpots, "medium");
        this.truckSpotsFree = addSpots(availableLargeSpots, "large");

    }

    public List<ParkingLotSlotsPerLevel> addSpots(int nr, String size) {//adding spots based on how many are available
        Vehicle v = new Vehicle();
        for (int index = 0; index < nr; index++) {
            ParkingLotSlotsPerLevel slot = new ParkingLotSlotsPerLevel(v.vehicleName, 1, size);
            listOfSpots.add(slot);
        }
        return listOfSpots;
    }

    public void getFreeSlots() { //prints all the available spots
        System.out.println("Small spots: " + availableSmallSpots);
        System.out.println("Medium spots: " + availableMediumSpots);
        System.out.println("Large spots: " + availableLargeSpots);
    }

    public boolean findIfExistFreeSlots(String type, String name, String user) {
        //motoare motoaree
        if (type.equals("small")) {
            if (user.equals("vip") && availableSmallSpots == 0) {
                if (availableMediumSpots > 0) {
                    return true;
                }
                if (availableMediumSpots == 0 && availableLargeSpots > 0) {
                    return true;
                }
            }
            if (availableSmallSpots == 0 && user.equals("regular")) {
                return false;
            } else {
                return true;
            }
        }

        //masiniti
        if (type.equals("medium")) {
            if (availableMediumSpots == 0 && user.equals("regular")) {
                return false;
            } else if (availableMediumSpots == 0 && availableLargeSpots > 0 && user.equals("vip")) {
                return true;
            } else {
                return true;
            }
        }

        //cameoane
        if (type.equals("large")) {
            if (availableLargeSpots == 0) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public void addInParkingLot(String type, String name, String user) { // we add vehicles in our parking lot
        if (type.equals("small")) { // we check each case to see if and where a motorcycle can be parked
            if (availableSmallSpots > 0) {
                availableSmallSpots -= 1;
                occupied.put(name, type);
            } else if (availableSmallSpots == 0 && availableMediumSpots > 0 && user.equals("vip")) {
                availableMediumSpots -= 1;
                occupied.put(name, "medium");
            } else if (availableSmallSpots == 0 && user.equals("regular")) {
                return;
            } else if (availableSmallSpots == 0 && availableMediumSpots == 0 && availableLargeSpots > 0 && user.equals("vip")) {
                availableLargeSpots -= 1;
                occupied.put(name, "large");
            }
        }
        if (type.equals("medium")) { // we check each case to see if and where a car can be parked
            if (availableMediumSpots > 0) {
                availableMediumSpots -= 1;
                occupied.put(name, type);
            } else if (availableMediumSpots == 0 && availableLargeSpots > 0 && user.equals("vip")) {
                availableLargeSpots -= 1;
                occupied.put(name, "large");
            } else if (availableMediumSpots == 0 && user.equals("regular")) {
                return;
            }
        }
        if (type.equals("large")) { // we check each case to see if and where a truck can be parked
            if (availableLargeSpots > 0) {
                availableLargeSpots -= 1;
                occupied.put(name, type);
            } else {
                return;
            }

        }
    }

    public void showOccupiesSpots() { // shows all the vehicles parked
        System.out.println("List of occupied spots: " + occupied);
    }

    public void leaveParkingLot(String name, String user, String slot) { // we leave the parking lot based on what spot is occupied
        occupied.remove(name);
        if (slot.equals("small")) {
            availableSmallSpots += 1;
            System.out.println(name + " left the spot");
        }
        if (slot.equals("medium")) {
            availableMediumSpots += 1;
            System.out.println(name + " left the spot");
        }
        if (slot.equals("large")) {
            availableLargeSpots += 1;
            System.out.println(name + " left the spot");
        }
        getFreeSlots();
    }

}
