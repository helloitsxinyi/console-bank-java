package com.banking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BankAccountTest {

    BankAccount account = new BankAccount();

    @Test
    void shouldGetZero_givenNewAccount() {
        assertThat(account).isEqualTo(0);
    }
}

