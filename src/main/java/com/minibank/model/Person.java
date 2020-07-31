package com.minibank.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Person {
    private String guid;
    @NonNull
    private String login;
    @NonNull
    private String password;
    private List<Account> account;
}
