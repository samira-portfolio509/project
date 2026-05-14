package Dao;
import Model.SeatAllocation;
import Model.TeacherAllocation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class seatAllocationDao {
    Connection conn;

    public seatAllocationDao() {
         conn = daoConnection.getConnection();
    }

    public boolean insertSeat(SeatAllocation sa){
        String query = "INSERT INTO seatallocation(seat_no,student_id,exam_id,room_no)VALUES(?,?,?,?)";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1,sa.getSeatno());
            stmt.setString(2,sa.getId());
            stmt.setInt(3,sa.getExamid());
            stmt.setInt(4,sa.getroomNo());
            int row = stmt.executeUpdate();
            if (row > 0){
                return true;
            }
            else{
                return false;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean clearAllocation(int id){
        String query = "DELETE FROM seatallocation WHERE exam_id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1,id);
            int row = stmt.executeUpdate();
            if(row>0){
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
    public boolean insertTeacher(TeacherAllocation ta){
        String query = "INSERT INTO teacher_room(teacher_id,room_no,exam_id) VALUES (?,?,?)";
        try(PreparedStatement stmt3 = conn.prepareStatement(query)){
            stmt3.setInt(1,ta.getTeacher_id());
            stmt3.setInt(2,ta.getRoom_no());
            stmt3.setInt(3,ta.getExam_id());
            int row = stmt3.executeUpdate();
            if(row > 0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    public boolean deleteTeacher_Allocation(int id){
        String query = "DELETE FROM teacher_room WHERE exam_id = ?";
        try(PreparedStatement stmt1 = conn.prepareStatement(query)){
            stmt1.setInt(1,id);
            int row = stmt1.executeUpdate();
            if(row > 0){
                return true;
            }
            else{
                return false;
            }
        }
        catch (SQLException e ){
            e.printStackTrace();
            return false;
        }
    }

}
