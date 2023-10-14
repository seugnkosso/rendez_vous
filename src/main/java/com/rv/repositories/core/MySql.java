package com.rv.repositories.core;

public class MySql extends dBImpl{
    public MySql() {
        super("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/rendez_vous","root","");                
    }
}
