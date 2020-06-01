package db;

import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        Connection connection=null;
        String url="jdbc:mysql://localhost:3306/ATM?characterEncoding=latin1&useConfigs=maxPerformance";
        String user="root";
        String password="manhquan";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url,user,password);

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] agrs){
        if(getConnection()!=null){
            System.out.println("ket noi thanh cong");
        }else{
            System.out.println("ket noi that bai");
        }
    }
}
