package com.codedifferently.lesson17.bank;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Test;

public class BusinessCheckingAccountTest {

  @Test
  void validateBusinessOwner_withBusinessOwner() {
    Set<Customer> owners = new HashSet<>();
    owners.add(new Customer(UUID.randomUUID(), "Elon Musk", CustomerType.BUSINESS));
    owners.add(new Customer(UUID.randomUUID(), "Elon Musk", CustomerType.BUSINESS));

    BusinessCheckingAccount account = new BusinessCheckingAccount("123456789", owners, 1000.0);
    assertThat(account).isNotNull();
  }
}
