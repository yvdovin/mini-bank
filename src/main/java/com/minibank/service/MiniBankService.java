package com.minibank.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minibank.dao.TempRepo;
import com.minibank.model.Account;
import com.minibank.model.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MiniBankService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void transferMoney(String body) throws Exception {
        Transaction transaction = objectMapper.readValue(body, Transaction.class);
        Account accountIn = TempRepo.map.get(transaction.getAccountNumberIn());
        Account accountOut = TempRepo.map.get(transaction.getAccountNumberOut());
        accountIn.getAmount().add(new BigDecimal(transaction.getMoney()));
        accountIn.getAmount().add(new BigDecimal(transaction.getMoney()).negate());
    }
}
