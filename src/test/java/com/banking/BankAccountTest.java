package com.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    BankAccount account;

    @BeforeEach
    void setUp() {
        // given
        account = new BankAccount();
    }

    @Test
    void shouldGetCustomerNameAndId_whenNewAccount() {

        // when
        String custName = account.getCustomerName();
        String custId = account.getCustomerId();

        // then
        assertThat(custName).isEqualTo("Xiao Ming");
        assertThat(custId).isEqualTo("123");
    }

    @Test
    void shouldGetBalance_givenDeposit() throws InvalidAmountException {

        // when
        account.deposit(0);

        // then
        assertThat(account.getBalance()).isEqualTo(20);
    }

    @Test
    void shouldReturnInvalid_givenInvalidDepositAmount() throws InvalidAmountException {

        assertThrows(InvalidAmountException.class, ()-> account.deposit(0));
    }

}

