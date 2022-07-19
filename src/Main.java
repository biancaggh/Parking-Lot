import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car("Car1", "regular");//create an object from Car class
        Car car2 = new Car("Car2", "vip");//create an object from Car class
        Motorcycle motor1 = new Motorcycle("Motor1", "regular");//create an object from Motorcycle class
        Motorcycle motor2 = new Motorcycle("Motor2", "vip");//create an object from Motorcycle class
        Truck truck1 = new Truck("Truck1", "regular");//create an object from Truck class
        Truck truck2 = new Truck("Truck2", "vip");//create an object from Truck class

        ParkingLot lot = new ParkingLot();
        System.out.println("********************EMPTY PARKING LOT*********************");
        lot.getFreeSlots();//get free spots before any vehicle comes
        System.out.println("**********************************************************");
        lot.addInParkingLot(String.valueOf(car1.vehicleSlotType), car1.vehicleName, car1.vehicleUser);
        lot.addInParkingLot(String.valueOf(car2.vehicleSlotType), car2.vehicleName, car2.vehicleUser);
        lot.addInParkingLot(String.valueOf(motor1.vehicleSlotType), motor1.vehicleName, motor1.vehicleUser);
        lot.addInParkingLot(String.valueOf(motor2.vehicleSlotType), motor2.vehicleName, motor2.vehicleUser);
        lot.addInParkingLot(String.valueOf(truck1.vehicleSlotType), truck1.vehicleName, truck1.vehicleUser);
        lot.addInParkingLot(String.valueOf(truck2.vehicleSlotType), truck2.vehicleName, truck2.vehicleUser);
        System.out.println("*****************A FEW VEHICLES ARE PARKED ******************");
        lot.getFreeSlots(); // we added some vehicles
        System.out.println("---------------------");
        lot.showOccupiesSpots();//show who ocuppied which spots
        System.out.println("*************************************************************");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("**********************WELCOME***********************");
        System.out.println("Do you want to enter or leave the parking lot?"); //we are given a choice --> enter or leave the parking lot
        String leaveorenter = br.readLine();
        if (leaveorenter.equals("enter")) { //we enter some data in order to verify if this certain vehicle can be parked
            System.out.println("--------------------------------------------------------");
            System.out.println("Please enter your vehicle name: ");
            String name = br.readLine();
            System.out.println("Please enter your type of user: ");
            String user = br.readLine();
            if (!(user.equals("regular") || (user.equals("vip")))) {
                System.out.println("This type of user doesn`t exist. Bye!");
                return;
            }
            System.out.println("Please enter your type of vehicle: ");
            String typeVeh = br.readLine();

            switch (typeVeh) {
                case "car" -> {
                    String spotType = "medium";
                    Car c = new Car(name, user);
                    if (!lot.findIfExistFreeSlots(spotType, c.vehicleName, c.vehicleUser)) {
                        System.out.println("Sorry there are no more available spots for you.");
                    } else {
                        lot.addInParkingLot(spotType, c.vehicleName, c.vehicleUser);
                        lot.getFreeSlots();
                    }
                }
                case "motorcycle" -> {
                    String spotType = "small";
                    Motorcycle m = new Motorcycle(name, user);
                    if (!lot.findIfExistFreeSlots(spotType, m.vehicleName, m.vehicleUser)) {
                        System.out.println("Sorry there are no more available spots for you.");
                    } else {
                        lot.addInParkingLot(spotType, m.vehicleName, m.vehicleUser);
                        lot.getFreeSlots();
                    }
                }
                case "truck" -> {
                    String spotType = "large";
                    Truck t = new Truck(name, user);
                    if (!lot.findIfExistFreeSlots(spotType, t.vehicleName, t.vehicleUser)) {
                        System.out.println("Sorry there are no more available spots for you.");
                    } else {
                        lot.addInParkingLot(spotType, t.vehicleName, t.vehicleUser);
                        lot.getFreeSlots();
                    }
                }
                default -> {
                    System.out.println("We don`t have this particular type of vehicle spots. Bye!");
                    return;
                }
            }
            System.out.println("Vehicles parked now: "); //show who is parked after the new vehicle came
            lot.showOccupiesSpots();
            System.out.println("--------------------------------------------------------");
        } else if (leaveorenter.equals("leave")) { //if we want to leave we were enter some data as well
            System.out.println("--------------------------------------------------------");
            System.out.println("Choose your type of vehicle:");
            String vech = br.readLine();
            System.out.println("Choose your name:");
            String id = br.readLine();
            System.out.println("Choose your user:");
            String us = br.readLine();
            System.out.println("What type of spot are you leaving?:");
            String spot = br.readLine();
            switch (vech) { //we will compare the data added with the data that is already there
                case "car" -> {
                    Car a = new Car(id, us);
                    a.vehicleSlotType = SlotType.valueOf(spot);
                    if (a.equals(car1) || (a.equals(car2))) {
                        lot.leaveParkingLot(id, us, spot);
                    } else {
                        System.out.println("This car is not parked here. See ya");
                    }
                }
                case "motorcycle" -> {
                    Motorcycle a = new Motorcycle(id, us);
                    a.vehicleSlotType = SlotType.valueOf(spot);
                    if (a.equals(motor1) || (a.equals(motor2))) {
                        lot.leaveParkingLot(id, us, spot);
                    } else {
                        System.out.println("This motorcycle is not parked here. See ya");
                    }
                }
                case "truck" -> {
                    Truck a = new Truck(id, us);
                    a.vehicleSlotType = SlotType.valueOf(spot);
                    if (a.equals(truck1) || (a.equals(truck2))) {
                        lot.leaveParkingLot(id, us, spot);
                    } else {
                        System.out.println("This truck is not parked here. See ya");
                    }
                }
                default -> System.out.println("The data added is not found in any vehicle.");
            }
            System.out.println("Vehicles parked now: ");
            lot.showOccupiesSpots();
            System.out.println("--------------------------------------------------------");
        } else {
            System.out.println("It is not one of our options.");
        }
        System.out.println("************************BYE*************************");
    }
}
