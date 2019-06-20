package oldschool;

import java.sql.*;

public class OldSchoolJokes {
    public String getRandomJoke() {
        String joke = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jokes", "root", null);
            ps = conn.prepareStatement("SELECT * from jokes j order by RAND() LIMIT 1");
            rs = ps.executeQuery();
            if(rs.next()) joke = rs.getString("joke");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null) try{ conn.close(); }catch (Exception ignore){}
            if (ps != null) try{ ps.close(); }catch (Exception ignore){}
            if (rs != null) try{ rs.close(); }catch (Exception ignore){}
        }
        return joke;
    }
}
