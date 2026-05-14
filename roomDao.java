package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Room;
import Model.Room;

import java.util.ArrayList;
import java.util.List;
public class roomDao {
    Connection conn;
    public roomDao(){
        conn = daoConnection.getConnection();
    }
    public boolean insertRoom(Room r){
        String query = "INSERT INTO room (room_no,capacity,building_id) VALUES (?,?,?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,r.getRno());
            stmt.setInt(2,r.getCap());
            stmt.setInt(3,r.getBid());
            int row = stmt.executeUpdate();
            if(row > 0){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Room> getRoom(){
        List<Room>list = new ArrayList<>();
        String query = "SELECT * FROM room";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Room r = new Room();
                r.setRno(rs.getInt("room_no"));
                r.setCap(rs.getInt("capacity"));
                r.setBid(rs.getInt("building_id"));
                list.add(r);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
