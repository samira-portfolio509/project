package Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Student;
import Model.Student;
public class StudentDao {

     Connection conn ;

    public StudentDao(){conn = daoConnection.getConnection();}

    public boolean signup(Student s){
        String query = "INSERT INTO student (student_name , student_id , student_department , semester , spass)" +
                "VALUES(?,?,?,?,?) ";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,s.getName());
            stmt.setString(2,s.getId());
            stmt.setString(3,s.getDept());
            stmt.setString(4,s.getSemester());
            stmt.setString(5,s.getPass());
            int row = stmt.executeUpdate();
            if(row > 0 ){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Student login (String id , String pass){
        Student s = new Student();
        String query = ("SELECT * FROM student WHERE student_id = ? AND spass = ?");
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,id);
            stmt.setString(2,pass);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                String name = rs.getString("student_name");
                String gid = rs.getString("student_id");
                String dept = rs.getString("student_department");
                String sem = rs.getString("semester");
                s.setName(name);
                s.setId(gid);
                s.setDept(dept);
                s.setSemester(sem);
                return s;
            }
            else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean deleteStudent(String id) {
        String query = "DELETE FROM student WHERE student_id = ?";
        String query2 = "DELETE FROM seatallocation WHERE student_id = ?";
        try {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query);
                 PreparedStatement stmt2 = conn.prepareStatement(query2)
            ) {
                stmt2.setString(1,id);
                 stmt2.executeUpdate();
                stmt.setString(1, id);
                int row = stmt.executeUpdate();
                if (row > 0) {
                    conn.commit();
                    return true;
                } else {
                    conn.rollback();
                    return false;
                }
            } catch (SQLException e) {
                try{
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            try{
                conn.rollback();
            }
            catch(SQLException ex){
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
    public List<Student> getStudent(){
        List<Student>list = new ArrayList<>();
        String query = "SELECT * FROM student";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Student s = new Student();
                s.setName(rs.getString("student_name"));
                s.setId(rs.getString("student_id"));
                s.setDept(rs.getString("student_department"));
                s.setSemester(rs.getString("semester"));
                list.add(s);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void closeConnection(){
        try{
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
