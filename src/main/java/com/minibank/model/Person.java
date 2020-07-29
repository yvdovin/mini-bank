package com.minibank.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Person {
    private String guid;
    private String name;
    private String lastName;
    private String phoneNumber;
    private List<Account> account;
}
