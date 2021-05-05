package com.banking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BankAccountTest {

    @Test
    void shouldGetCustomerNameAndId_whenNewAccount() {

        // given
        BankAccount account = new BankAccount();

        // when
        String custName = account.getCustomerName();

        // then
        assertThat(custName).isEqualTo("");
    }



}

