package Model;

public class Room {
    int room_no;
    int capacity;
    int building_id;
    public Room(){};
    public Room(int rno , int cp, int ok ){
        room_no = rno;
        capacity = cp;
        building_id = ok;
    }
    public int getRno(){
        return room_no;
    }
    public int getCap(){
        return capacity;
    }
    public int getBid(){
        return building_id;
    }
    public void setRno(int rn){
         room_no = rn;
    }
    public void setCap(int cp){
         capacity = cp;
    }
    public void setBid(int bd){
         building_id = bd;
    }
}
