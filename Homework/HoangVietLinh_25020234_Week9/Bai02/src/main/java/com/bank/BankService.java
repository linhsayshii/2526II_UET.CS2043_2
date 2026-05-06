package com.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Dịch vụ quản lý tài khoản ngân hàng.
 */
public class BankService {

  private static final Logger logger =
      LoggerFactory.getLogger(BankService.class);

  /**
   * Chuyển tiền giữa hai tài khoản.
   */
  public boolean transfer(BankAccount from, BankAccount to, double amount) {
    logger.info("Bắt đầu chuyển tiền: {} -> {}, amount={}",
        from.getAccountId(), to.getAccountId(), amount);

    if (amount <= 0) {
      logger.error("Số tiền chuyển không hợp lệ: {}", amount);
      throw new IllegalArgumentException("Số tiền chuyển phải lớn hơn 0");
    }

    boolean withdrawn = from.withdraw(amount);
    if (!withdrawn) {
      logger.warn("Chuyển tiền thất bại: không đủ số dư tài khoản {}",
          from.getAccountId());
      return false;
    }

    to.deposit(amount);
    logger.info("Chuyển tiền thành công: {} -> {}, amount={}",
        from.getAccountId(), to.getAccountId(), amount);
    return true;
  }
}
