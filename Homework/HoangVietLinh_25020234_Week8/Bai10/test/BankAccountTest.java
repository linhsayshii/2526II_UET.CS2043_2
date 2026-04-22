import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        // Số dư ban đầu là 500 trước mỗi test
        account = new BankAccount("ACC001", "Nguyen Van A", 500);
    }

    // ========== TEST deposit(double amount) ==========

    // EP: amount > 0 → nạp thành công, số dư tăng
    @Test
    void testDeposit_positiveAmount() {
        account.deposit(100);
        assertEquals(600, account.getBalance());
    }

    // EP: amount = 0 → ném ngoại lệ
    @Test
    void testDeposit_zeroAmount() {
        assertThrows(IllegalArgumentException.class,
            () -> account.deposit(0));
    }

    // EP: amount < 0 → ném ngoại lệ
    @Test
    void testDeposit_negativeAmount() {
        assertThrows(IllegalArgumentException.class,
            () -> account.deposit(-100));
    }

    // BVA: amount = 0.01 (ngay trên biên 0)
    @Test
    void testDeposit_minPositive() {
        account.deposit(0.01);
        assertEquals(500.01, account.getBalance(), 0.001);
    }

    // BVA: amount = -0.01 (ngay dưới biên 0)
    @Test
    void testDeposit_justBelowZero() {
        assertThrows(IllegalArgumentException.class,
            () -> account.deposit(-0.01));
    }

    // EP: nạp số lớn
    @Test
    void testDeposit_largeAmount() {
        account.deposit(1_000_000);
        assertEquals(1_000_500, account.getBalance());
    }

    // ========== TEST withdraw(double amount) ==========

    // EP: amount > 0 và amount <= balance → rút thành công
    @Test
    void testWithdraw_validAmount() {
        assertTrue(account.withdraw(200));
        assertEquals(300, account.getBalance());
    }

    // EP: amount > balance → rút thất bại
    @Test
    void testWithdraw_exceedsBalance() {
        assertFalse(account.withdraw(600));
        assertEquals(500, account.getBalance()); // Số dư không đổi
    }

    // EP: amount = 0 → ném ngoại lệ
    @Test
    void testWithdraw_zeroAmount() {
        assertThrows(IllegalArgumentException.class,
            () -> account.withdraw(0));
    }

    // EP: amount < 0 → ném ngoại lệ
    @Test
    void testWithdraw_negativeAmount() {
        assertThrows(IllegalArgumentException.class,
            () -> account.withdraw(-100));
    }

    // BVA: rút đúng bằng số dư (amount == balance)
    @Test
    void testWithdraw_exactBalance() {
        assertTrue(account.withdraw(500));
        assertEquals(0, account.getBalance());
    }

    // BVA: rút nhiều hơn số dư 0.01
    @Test
    void testWithdraw_justAboveBalance() {
        assertFalse(account.withdraw(500.01));
        assertEquals(500, account.getBalance());
    }

    // BVA: rút ít hơn số dư 0.01
    @Test
    void testWithdraw_justBelowBalance() {
        assertTrue(account.withdraw(499.99));
        assertEquals(0.01, account.getBalance(), 0.001);
    }

    // BVA: amount = 0.01 (ngay trên biên 0)
    @Test
    void testWithdraw_minPositive() {
        assertTrue(account.withdraw(0.01));
        assertEquals(499.99, account.getBalance(), 0.001);
    }

    // ========== TEST tính nhất quán (consistency) ==========

    @Test
    void testConsistency_depositAndWithdrawSequence() {
        // Bắt đầu với số dư = 0
        BankAccount acc = new BankAccount("ACC002", "Tran Van B");
        assertEquals(0, acc.getBalance());

        // Nạp 500
        acc.deposit(500);
        assertEquals(500, acc.getBalance());

        // Rút 200 → thành công
        assertTrue(acc.withdraw(200));
        assertEquals(300, acc.getBalance());

        // Rút 400 → thất bại (chỉ còn 300)
        assertFalse(acc.withdraw(400));
        assertEquals(300, acc.getBalance()); // Số dư không đổi

        // Kiểm tra số dư cuối = 300
        assertEquals(300, acc.getBalance());
    }
}
