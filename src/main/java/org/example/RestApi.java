package org.example;
import static spark.Spark.*;
import com.google.gson.Gson;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestApi{
    private static final String url = "jdbc:postgresql://localhost:5432/AdoptKidSystem";
    private static final String user = "postgres";
    private static final String password = "0294567890-=DM!";
    private static final Gson gson = new Gson();
    public static void main(String[] args) {
        port(4567);
        exception(Exception.class, (e, req, res) -> {
            e.printStackTrace(); // Print to console
            res.status(500);
            res.body("Internal Error: " + e.getMessage());
        });
        // GET: Fetch all jobs
        get("/kids", (req, res) -> {
            res.type("application/json");
            return gson.toJson(getAllKids());
        });
        // POST: Create a new job
        post("/kids", (req, res) -> {
            res.type("application/json");
            Kid kid = gson.fromJson(req.body(), Kid.class);
            createKid(kid);
            res.status(201);
            return gson.toJson("Job created successfully");
        });
//        // PUT: Update job budget
//        put("/kids/:id", (req, res) -> {
//            res.type("application/json");
//            int id = Integer.parseInt(req.params(":id"));
//            double newBudget = Double.parseDouble(req.queryParams("budget"));
//            updateKid(id, newBudget);
//            return gson.toJson("Kid updated");
//        });
//        // DELETE: Remove a job
//        delete("/kids/:id", (req, res) -> {
//            res.type("application/json");
//            int id = Integer.parseInt(req.params(":id"));
//            deleteKid(id);
//            return gson.toJson("Kid deleted");
//        });



        private static Connection connect() throws SQLException {
            return DriverManager.getConnection(url, user, password);
        }
        private static List<Kid> getAllKids() {
            List<Kid> kids = new ArrayList<>();
            String sql = "SELECT * FROM kid";
            try (Connection conn = connect();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    kids.add(new Kid(
                            rs.getString("kid_name"),
                            rs.getInt("kid_age"),
                            rs.getString("kid_gender"),
                            rs.getString("disease")
                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return kids;
        }
        private static void createJob(Kid kid) {
            String sql = "INSERT INTO kid (kid_name, kid_age, kid_gender, kid_disease) VALUES (?, ?, ?, ?)";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, kid.getName);
                pstmt.setString(2, );
                pstmt.setString(3, );
                pstmt.setString(4, );
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }
}
