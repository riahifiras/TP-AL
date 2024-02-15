import java.sql.ResultSet;

public class StudentDAO {
    private Student student;
    private ConnectDB connectDB;

    public StudentDAO(Student student, ConnectDB connectDB) {
        this.student = student;
        this.connectDB = connectDB;
    }

    public void create() {
    
        String query = "INSERT INTO etudiant (id, name) VALUES (" + student.getId() + ", '" + student.getName() + "')";
        connectDB.update(query);
    }

    public ResultSet read() {
        String query = "SELECT * FROM etudiant WHERE id = " + student.getId();
        ResultSet res = connectDB.execute(query);
        return res;
    }
    
    public ResultSet readAll() {
        String query = "SELECT * FROM etudiant";
        ResultSet res = connectDB.execute(query);
        return res;
    }

    public void update() {
        String query = "UPDATE etudiant SET name = '" + student.getName() + "' WHERE id = " + student.getId();
        connectDB.update(query);
    }

    public void delete() {
        String query = "DELETE FROM etudiant WHERE id = " + student.getId();
        connectDB.update(query);
    }
}
