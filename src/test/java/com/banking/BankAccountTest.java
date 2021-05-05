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
        account.deposit(20);

        // then
        assertThat(account.getBalance()).isEqualTo(20);
    }

    @Test
    void shouldGetInvalid_givenInvalidDepositAmount() throws InvalidAmountException {

        assertThrows(InvalidAmountException.class, ()-> account.deposit(0));
    }

    @Test
    void shouldGetCorrectBalance_givenWithdraw() throws InvalidAmountException {

        // when
        account.deposit(20);
        account.withdraw(10);

        // then
        assertThat(account.getBalance()).isEqualTo(10);
    }

    @Test
    void shouldGetInvalid_givenWithdrawMoreThanBalanceAmount() throws InvalidAmountException {

        // when
        account.deposit(20);

        // then
        assertThrows(InvalidAmountException.class, () -> account.withdraw(30));
    }

    @Test
    void shouldGetCorrectStatement_givenPreviousTransaction() throws InvalidAmountException {

        // when
        account.deposit(30);
        account.withdraw(20);


        // then
        assertThat(account.getPreviousTransaction()).isEqualTo(-20);
    }
}

