package com.example.springbootapi.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Account(rs.getInt("id"),
                rs.getString("name")
                , rs.getBigDecimal("amount"));
    }
}
