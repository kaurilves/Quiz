package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class Dao<T> {
    protected final Connection connection;
    protected final static  String LAST_VAL="SELECT last_value FROM";
    protected final static String CUSTOMER_SEQUENCE="hp_customer_seq";

    public Dao(Connection connection){
        super();
        this.connection=connection;
    }

    public abstract  T findById(Integer id);
    public abstract List<T> findAll();
    public abstract T update(T dto);
    public abstract T create(T dto);
    public abstract void delete(Integer id);
    protected  int getLastVal(String sequence){
        int key=0;
        String sql=LAST_VAL+sequence;
        try(Statement statement=connection.createStatement()) {
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                key=resultSet.getInt(1);
            }
            return  key;
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}