package com.example.springbootapi.repositories;

import com.example.springbootapi.models.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Account> accountRowMapper = (rs, rowNum) -> new Account(rs.getInt("id"), rs.getString("name"), rs.getBigDecimal("amount"));

    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findAccountById(long id) {
        String sql = "SELECT * FROM account WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, accountRowMapper);
    }

    public List<Account> findAllAccounts() {
        return jdbcTemplate.query("SELECT * from account", accountRowMapper);
    }

    public void changeAmount(long id, BigDecimal amount) {
        jdbcTemplate.update("UPDATE account SET amount = ? WHERE id = ?", amount, id);
    }
}
