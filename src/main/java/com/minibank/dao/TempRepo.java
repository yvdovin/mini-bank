package com.minibank.dao;

import com.minibank.model.Account;
import com.minibank.model.Person;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TempRepo {

    public static Person person1;
    public static Person person2;
    public static Map<String, Account> map;
    public static Account account1;
    public static Account account2;

    static {
        person1 = new Person("vasya", "1234");
        person2 = new Person("kolya", "5678");
        person1.setAccount(Collections.singletonList(account1));
        person2.setAccount(Collections.singletonList(account2));
        account1 = new Account();
        account2 = new Account();
        account1.setAmount(new BigDecimal("10000"));
        account1.setNumber("1");
        account2.setAmount(new BigDecimal("10000"));
        account2.setNumber("2");
        map = new HashMap<>();
        map.put("1", account1);
        map.put("2", account2);
    }
}
