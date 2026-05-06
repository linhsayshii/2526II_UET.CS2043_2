package com.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp đại diện cho một tài khoản ngân hàng.
 */
public class BankAccount {

  private static final Logger logger =
      LoggerFactory.getLogger(BankAccount.class);

  private String accountId;
  private String ownerName;
  private double balance;

  /**
   * Khởi tạo tài khoản ngân hàng.
   */
  public BankAccount(String accountId, String ownerName, double initialBalance) {
    this.accountId = accountId;
    this.ownerName = ownerName;
    this.balance = initialBalance;
    logger.info("Tạo tài khoản: id={}, owner={}, balance={}",
        accountId, ownerName, initialBalance);
  }

  /**
   * Gửi tiền vào tài khoản.
   */
  public void deposit(double amount) {
    if (amount <= 0) {
      logger.error("Số tiền gửi không hợp lệ: {}", amount);
      throw new IllegalArgumentException("Số tiền gửi phải lớn hơn 0");
    }
    balance += amount;
    logger.info("Gửi tiền: amount={}, newBalance={}", amount, balance);
  }

  /**
   * Rút tiền từ tài khoản.
   */
  public boolean withdraw(double amount) {
    if (amount <= 0) {
      logger.error("Số tiền rút không hợp lệ: {}", amount);
      throw new IllegalArgumentException("Số tiền rút phải lớn hơn 0");
    }
    if (amount > balance) {
      logger.warn("Không đủ số dư: yêu cầu={}, hiện có={}", amount, balance);
      return false;
    }
    balance -= amount;
    logger.info("Rút tiền: amount={}, newBalance={}", amount, balance);
    return true;
  }

  public String getAccountId() {
    return accountId;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public double getBalance() {
    return balance;
  }
}
