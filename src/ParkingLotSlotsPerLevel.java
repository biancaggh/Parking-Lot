public class ParkingLotSlotsPerLevel{
    private static String id; //we name it id but it s the name of the vehicle
    private int level; //it was supposed to be a parking lot with more than a level
    private String size;//type of slot basically -> small, medium and large

    public ParkingLotSlotsPerLevel(String id, int l, String size){ //constructor
        this.id=id;
        this.level=l;
        this.size=size;
    }
//    public static String get_Id(){
//        return id;
//    }
//    public int get_Level(){
//        return this.level;
//    }
//    public String get_Size(){
//        return this.size;
//    }
}
