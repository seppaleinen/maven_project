import java.sql.*;

public class Datalayer {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public Datalayer(){
        conn = getConnection();
    }

    public void persist(User user) throws Exception{
        ps = createStatement(conn, "INSERT INTO USER (ID, USERNAME) VALUES (?, ?)");
        ps.setInt(1, user.getId());
        ps.setString(2, user.getUsername());
        ps.execute();
        close(conn, rs, ps);
    }

    public User find(String username) throws Exception{
        User user = new User();
        ps = createStatement(conn, "SELECT * FROM USER WHERE USERNAME=?");
        ps.setString(1, username);
        rs = ps.executeQuery();
        if(rs!=null){
            rs.next();
            user.setId(rs.getInt("ID"));
            user.setUsername(rs.getString("USERNAME"));
        }
        return user;
    }

    private PreparedStatement createStatement(Connection conn, String sql){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }
    private Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/maven_db", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    private void close(Connection conn, ResultSet rs, PreparedStatement ps){
        closeConnection(conn);
        closeResultSet(rs);
        closePreparedStatement(ps);
    }

    private void closeConnection(Connection conn){
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void closeResultSet(ResultSet rs){
        try {
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void closePreparedStatement(PreparedStatement ps){
        try {
            if(ps!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}