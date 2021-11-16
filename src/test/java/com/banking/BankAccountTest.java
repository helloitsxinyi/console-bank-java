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
    void shouldGetCustomerNameAndId_whenGetAccountInfo() {

        // when
        account = new BankAccount("Mary", "abc123");

        // then
        assertThat(account.getCustomerName()).isEqualTo("Mary");
        assertThat(account.getCustomerId()).isEqualTo("abc123");
    }

    @Test
    void shouldGetBalance_givenDeposit() throws InvalidAmountException {

        // when
        account.deposit(20);

        // then
        assertThat(account.getBalance()).isEqualTo("Balance: " + 20);
    }

    @Test
    void shouldGetInvalidAmount_givenInvalidDepositAmount() throws InvalidAmountException {

        assertThrows(InvalidAmountException.class, ()-> account.deposit(0));
    }

    @Test
    void shouldGetCorrectBalance_givenWithdraw() throws InvalidAmountException {

        // when
        account.deposit(20);
        account.withdraw(10);

        // then
        assertThat(account.getBalance()).isEqualTo("Balance: " + 10);
    }

    @Test
    void shouldGetInvalidAmount_givenWithdrawMoreThanBalanceAmount() throws InvalidAmountException {

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
        assertThat(account.getPreviousTransaction()).isEqualTo("Previous transaction: withdrawal of " + 20);
    }
}

