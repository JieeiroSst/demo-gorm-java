package models;

import db.DBConnection;
import dto.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountDB {
    public static Account getAccount(int accNo){
        Account acc=new Account();
        String sql="select * from Account where AccountNo="+accNo;
        Connection dbConn=DBConnection.getConnection();
        try {
            assert dbConn != null;
            PreparedStatement ps=dbConn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                acc.setAccountNo(accNo);
                acc.setCustomerName(rs.getString("CustomerName"));
                acc.setPasswd(rs.getString("Passwd").trim());
                acc.setAmount(rs.getInt("Amount"));
            }else{
                return null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return acc;
    }

    public ArrayList<Account> getAccounts(){
        String sql="select * from Account";
        ArrayList<Account> accounts=new ArrayList<>();
        Connection dbConn=DBConnection.getConnection();
        try {
            assert dbConn != null;
            PreparedStatement ps=dbConn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                Account acc=new Account();
                acc.setAccountNo(rs.getInt("AccountNo"));
                acc.setCustomerName(rs.getString("CustomerName"));
                acc.setPasswd(rs.getString("Passwd").trim());
                acc.setAmount(rs.getInt("Amount"));
                accounts.add(acc);
            }else{
                return null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accounts;
    }

    public boolean deleteAccount(Account acc){
        String sql="delete from Account where AccountNo=?";
        Connection connection= DBConnection.getConnection();
        try {
            assert connection != null;
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1,acc.getAccountNo());
            ps.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean updateAccount(Account acc){
        String sql="update Account  set"+"CustomerName=?,"+"Passwd=?"+"Amount=?"+"where AccountNo=?";
        Connection connection=DBConnection.getConnection();
        try {
            assert connection != null;
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,acc.getCustomerName());
            ps.setString(2,acc.getPasswd());
            ps.setInt(3,acc.getAmount());
            ps.setInt(4,acc.getAccountNo());
            ps.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
