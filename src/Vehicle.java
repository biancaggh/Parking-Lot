import java.util.Objects;

public class Vehicle {
    protected String vehicleName;
    protected SlotType vehicleSlotType;
    protected String vehicleUser;
    protected Vehicle() { //constructor created to be able to create constructor w parameters in Car, Motorcycle and Truck
    }

//    public String getVehicleName() {
//        return this.vehicleName;
//    }
//
//    public SlotType getVehicleSlotType() {
//        return this.vehicleSlotType;
//    }
//
//    public String getVehicleUser() {
//        return this.vehicleUser;
//    }

    @Override
    public boolean equals(Object o) { //equals method to verify if two objects have the same data
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vehicleName, vehicle.vehicleName) && vehicleSlotType == vehicle.vehicleSlotType && Objects.equals(vehicleUser, vehicle.vehicleUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleName, vehicleSlotType, vehicleUser);
    }

}
