package com.example.springbootapi.models;

import java.math.BigDecimal;

public record Account(long id, String name, BigDecimal amount) {
}
