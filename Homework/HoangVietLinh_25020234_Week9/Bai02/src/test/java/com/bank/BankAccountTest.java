package com.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {

  private BankAccount account;

  @BeforeEach
  void setUp() {
    account = new BankAccount("ACC001", "Nguyen Van A", 1000.0);
  }

  @Test
  void testDeposit() {
    account.deposit(500.0);
    assertEquals(1500.0, account.getBalance());
  }

  @Test
  void testDepositInvalid() {
    assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
  }

  @Test
  void testWithdrawSuccess() {
    assertTrue(account.withdraw(500.0));
    assertEquals(500.0, account.getBalance());
  }

  @Test
  void testWithdrawInsufficientFunds() {
    assertFalse(account.withdraw(2000.0));
    assertEquals(1000.0, account.getBalance());
  }

  @Test
  void testTransfer() {
    BankAccount target = new BankAccount("ACC002", "Tran Van B", 0);
    BankService service = new BankService();
    assertTrue(service.transfer(account, target, 300.0));
    assertEquals(700.0, account.getBalance());
    assertEquals(300.0, target.getBalance());
  }
}
