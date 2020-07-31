package com.minibank.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Transaction {

    private String accountFrom;
    private String accountTo;
    private String amount;
}
