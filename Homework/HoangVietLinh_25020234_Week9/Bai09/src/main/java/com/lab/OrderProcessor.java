package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderProcessor {

    private static final Logger logger = LoggerFactory.getLogger(OrderProcessor.class);

    public double processOrder(String orderId, String product, int quantity, double unitPrice) {
        // INFO: theo dõi mốc quan trọng - đơn hàng bắt đầu xử lý
        logger.info("Bắt đầu xử lý đơn hàng: orderId={}, product={}, qty={}",
                orderId, product, quantity);

        // Validate input
        if (orderId == null || orderId.isBlank()) {
            // ERROR: lỗi nghiêm trọng
            logger.error("Mã đơn hàng không hợp lệ: null hoặc rỗng");
            throw new IllegalArgumentException("Mã đơn hàng không được để trống");
        }

        if (quantity <= 0) {
            logger.error("Số lượng không hợp lệ: quantity={} cho đơn hàng {}",
                    quantity, orderId);
            throw new IllegalArgumentException("Số lượng phải > 0");
        }

        if (unitPrice < 0) {
            logger.error("Đơn giá âm: unitPrice={} cho đơn hàng {}",
                    unitPrice, orderId);
            throw new IllegalArgumentException("Đơn giá không được âm");
        }

        double total = quantity * unitPrice;

        // Áp dụng giảm giá cho đơn lớn
        if (total > 1000000) {
            double discount = total * 0.1;
            total -= discount;
            // INFO: mốc quan trọng - áp dụng giảm giá
            logger.info("Áp dụng giảm giá 10% cho đơn {}: discount={}", orderId, discount);
        }

        // INFO: mốc quan trọng - hoàn thành xử lý
        logger.info("Hoàn thành đơn hàng {}: tổng={}", orderId, total);
        return total;
    }

    public void cancelOrder(String orderId) {
        if (orderId == null) {
            logger.error("Không thể hủy đơn hàng: orderId=null");
            throw new IllegalArgumentException("orderId không được null");
        }
        // INFO: mốc quan trọng - hủy đơn
        logger.info("Đã hủy đơn hàng: {}", orderId);
    }
}
