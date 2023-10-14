package com.rv.repositories.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dBImpl implements IdataBase {
    
    protected Connection conn;
    protected Statement stmt;
    protected PreparedStatement Pstmt;
    protected ResultSet res;    
    protected String driver;
    protected String bd ;
    protected String user;
    protected String pass;

    public dBImpl(String driver,String bd, String user,String pass){
        this.driver = driver;
        this.bd = bd;
        this.user = user;
        this.pass = pass;
    }
    
    @Override
    public void openConnexion() {
         try {
            // étape 1: charger la classe de driver
            Class.forName(driver);

            // étape 2: créer l'objet de connexion
            conn = DriverManager.getConnection(bd, user, pass);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void closeConnexion() {
        try {
            Pstmt.close();
            res.close();
            // stmt.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void executeSelect() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executeSelect'");
    }

    @Override
    public void executeUpdate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executeUpdate'");
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public PreparedStatement getPstmt() {
        return Pstmt;
    }

    public void setPstmt(PreparedStatement pstmt) {
        Pstmt = pstmt;
    }

    public ResultSet getRes() {
        return res;
    }

    public void setRes(ResultSet res) {
        this.res = res;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
