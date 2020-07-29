package com.minibank.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Transaction {

    private String accountNumberIn;
    private String accountNumberOut;
    private String money;
}
