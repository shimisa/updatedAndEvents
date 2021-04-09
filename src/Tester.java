import java.sql.*;

public class Tester {

    public static void main(String[] args){

        MySqlConnect mysqlConnect = new MySqlConnect();

        String sql = "SELECT * FROM `idle_services`";
        String insertInto = "INSERT INTO `idle_services` VALUES ('ddd', '2021-02-25', '2021-02-25', 'gfgfgfgfg', '2021-02-25')";

        try {

            mysqlConnect.connect();

            PreparedStatement statement1 = mysqlConnect.getConnection().prepareStatement(insertInto);
            PreparedStatement statement2 = mysqlConnect.getConnection().prepareStatement(sql);
            statement1.executeUpdate();
            ResultSet resultSet = statement2.executeQuery();


            while (resultSet.next() != false){
                for (int i = 1; i <= resultSet.findColumn("cur_date") ; i++){
                    String s = resultSet.getString(i);
                    System.out.print(s + " ");
                }
                System.out.println("");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.disconnect();
        }



        /**
         * test connection with mySql
         */
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        String url = "jdbc:mysql://localhost:3306/shimi_db";
        String username = "root";
        String password = "shimi";

        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }*/



    }

}
