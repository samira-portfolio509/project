package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Exam;

public class ExamDao {
    Connection conn;

    public ExamDao() {
        conn = daoConnection.getConnection();
    }

    public boolean insertEaxm(Exam ex) {
        String query = "INSERT INTO exam (exam_name,exam_date,exam_time) VALUES (?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, ex.getEsub());
            stmt.setString(2, ex.getEdate());
            stmt.setString(3, ex.getEtime());
            int row = stmt.executeUpdate();
            if (row > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteExam() {
        String query = "DELETE FROM seatallocation";
        String query2 = "DELETE FROM teacher_room";
        String query3 = "DELETE FROM exam";
        try{
            conn.setAutoCommit(false);
            try(
                    PreparedStatement stmt = conn.prepareStatement(query);
                    PreparedStatement stmt2 = conn.prepareStatement(query2);
                    PreparedStatement stmt3 = conn.prepareStatement(query3);
                    ){
                stmt.executeUpdate();
                stmt2.executeUpdate();
                stmt3.executeUpdate();
               conn.commit();
               return true;
            }
            catch(SQLException e){
                conn.rollback();
                e.printStackTrace();
                return false;
            }
        }
        catch (SQLException e) {
            try{
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        }
        finally {
            try {
                conn.setAutoCommit(true);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public List<Exam> getExam(){
        List<Exam> ex = new ArrayList<>();
        String query = "SELECT * FROM exam";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Exam e = new Exam();
                e.setid(rs.getInt("exam_id"));
                e.setEsub(rs.getString("exam_name"));
                e.setEtime(rs.getString("exam_date"));
                e.setEdate(rs.getString("exam_time"));
                ex.add(e);
            }
            return ex;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
