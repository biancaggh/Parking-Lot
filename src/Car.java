public class Car extends Vehicle{
    public Car(String vehicleName, String vehicleUser){ //we create a constructor
        this.vehicleName= vehicleName;
        this.vehicleUser=vehicleUser;
        this.vehicleSlotType=SlotType.medium;
    }

}
