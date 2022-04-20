package clinc.asset;

import java.sql.*;

public class DatabaseConnection {

    public static Connection connectToDB() throws SQLException {
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/clincsystem?autoReconnect=true&useSSL=false","root","1234");


        }catch(Exception e){ System.out.println(e);}
        return con;
    }

    public static boolean executeWritingQuery(String query){
        boolean result =false;
        try{
            Connection con = connectToDB();
            Statement stmt = con.createStatement();
            result =stmt.execute(query);
            //con.close();
        }catch(Exception e){ System.out.println(e);}
        return result;
    }

    public static ResultSet executeReadingQuery(String query){
        ResultSet result = null;
        try{
            Connection con = connectToDB();
            Statement stmt = con.createStatement();
            result =stmt.executeQuery(query);
            //con.close();
        }catch(Exception e){ System.out.println(e);}
        return result;
    }
}
/*
while(rs.next())
        System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
*/