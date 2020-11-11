package lycheenoisi.paintball.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Employee extends User{

    public Employee(String username) {
        super(username);
    }

    public Employee() { }

    public static List<Employee> getAllEmployees() {
        var list = new ArrayList<Employee>();
        try {
            String query = "SELECT * FROM User ";
            query += "WHERE role = '" + Role.admin.getNomDB() + "' OR role = '" + Role.employee.getNomDB() + "'";
            query += "ORDER BY username";
            var stmt = db.prepareStatement(query);
            var rs = stmt.executeQuery();
            while (rs.next()) {
                var employee = new Employee();
                mapper(rs, employee);
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void delete(Employee em) {
        String request = "DELETE from user WHERE id = ?";
        int id = em.getId();
        try {
            var statementUpdate = db.prepareStatement(request);
            statementUpdate.setInt(1, id);
            statementUpdate.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
