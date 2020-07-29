package com.minibank.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class Account {

    private String guid;
    private String number;
    private BigDecimal amount;
    private Person person;
}
