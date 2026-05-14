package Dao;

import Model.Teacher;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TeacherDao {
    Connection conn;

    public TeacherDao(){
        conn = daoConnection.getConnection();
    }

    public boolean teacherSignup(Teacher t){
        String query = "INSERT INTO teacher (teacher_name,teacher_id,teacher_department,tpass)" +
                "VALUES (?,?,?,?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,t.gettName());
            stmt.setInt(2,t.gettID());
            stmt.setString(3,t.gettdept());
            stmt.setString(4,t.gettpass());
            int row = stmt.executeUpdate();
            if (row > 0 ){
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
    public Teacher teacherLogin(int id , String pass){
        String query = "SELECT * FROM teacher WHERE teacher_id = ? AND tpass = ? ";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,id);
            stmt.setString(2,pass);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                Teacher t1 = new Teacher();
                t1.settName(rs.getString("teacher_name"));
                t1.settDept(rs.getString("teacher_department"));
                t1.settID(rs.getInt("teacher_id"));
                return t1;
            }
            else{
                return null;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean teacherDelete(int id) {
        String query = "DELETE FROM teacher WHERE teacher_id = ?";
        String query2 = "DELETE FROM teacher_room WHERE teacher_id = ?";
        try {
            conn.setAutoCommit(false);
            try (
                    PreparedStatement stmt = conn.prepareStatement(query);
                    PreparedStatement stmt2 = conn.prepareStatement(query2);
            ) {
                stmt2.setInt(1,id);
                stmt2.executeUpdate();
                stmt.setInt(1, id);
                int row = stmt.executeUpdate();
                if (row > 0) {
                    conn.commit();
                    return true;
                } else {
                    conn.rollback();
                    return false;
                }
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
                return false;
            }
        }
        catch(SQLException e){
            try{
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        }
        finally {
            try{
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public List<Teacher> getTeacher(){
        List<Teacher> teachers = new ArrayList<>();
        String query = "SELECT * FROM teacher";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Teacher te = new Teacher();
                te.settName(rs.getString("teacher_name"));
                te.settID(rs.getInt("teacher_id"));
                te.settDept(rs.getString("teacher_department"));
                teachers.add(te);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return teachers;
    }

}
