-- ============================================================
-- Bài 4: Thiết kế CSDL Quan hệ cho Hệ thống Chat theo phòng
-- Chuẩn hóa đạt 3NF (Third Normal Form)
-- ============================================================

-- Xóa bảng cũ nếu tồn tại (thứ tự ngược để tránh lỗi FK)
DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS room_members;
DROP TABLE IF EXISTS rooms;
DROP TABLE IF EXISTS users;

-- ============================================================
-- Bảng 1: users (Người dùng)
-- Mỗi user có ID duy nhất, username không trùng, email riêng
-- ============================================================
CREATE TABLE users (
    user_id     INT             PRIMARY KEY AUTO_INCREMENT,
    username    VARCHAR(50)     NOT NULL UNIQUE,
    email       VARCHAR(100)    NOT NULL UNIQUE,
    created_at  DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ============================================================
-- Bảng 2: rooms (Phòng chat)
-- Mỗi phòng có ID duy nhất và tên phòng
-- ============================================================
CREATE TABLE rooms (
    room_id     INT             PRIMARY KEY AUTO_INCREMENT,
    room_name   VARCHAR(100)    NOT NULL,
    created_at  DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ============================================================
-- Bảng 3: room_members (Thành viên phòng - Bảng trung gian)
-- Quan hệ Nhiều-Nhiều (N-M): 1 user có thể ở nhiều phòng,
-- 1 phòng có thể có nhiều user
-- ============================================================
CREATE TABLE room_members (
    user_id     INT     NOT NULL,
    room_id     INT     NOT NULL,
    joined_at   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    -- Khóa chính kết hợp: 1 user chỉ tham gia 1 phòng 1 lần
    PRIMARY KEY (user_id, room_id),

    -- Khóa ngoại liên kết đến bảng users
    FOREIGN KEY (user_id) REFERENCES users(user_id)
        ON DELETE CASCADE,

    -- Khóa ngoại liên kết đến bảng rooms
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)
        ON DELETE CASCADE
);

-- ============================================================
-- Bảng 4: messages (Tin nhắn)
-- Quan hệ Một-Nhiều: 1 user gửi nhiều tin nhắn,
-- 1 phòng chứa nhiều tin nhắn
-- ============================================================
CREATE TABLE messages (
    message_id  INT             PRIMARY KEY AUTO_INCREMENT,
    room_id     INT             NOT NULL,
    user_id     INT             NOT NULL,
    content     TEXT            NOT NULL,
    sent_at     DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,

    -- Khóa ngoại: tin nhắn thuộc về phòng nào
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)
        ON DELETE CASCADE,

    -- Khóa ngoại: tin nhắn do ai gửi
    FOREIGN KEY (user_id) REFERENCES users(user_id)
        ON DELETE CASCADE
);

-- ============================================================
-- Dữ liệu mẫu để test
-- ============================================================

-- Tạo users
INSERT INTO users (username, email) VALUES ('alice', 'alice@uet.vn');
INSERT INTO users (username, email) VALUES ('bob', 'bob@uet.vn');
INSERT INTO users (username, email) VALUES ('charlie', 'charlie@uet.vn');

-- Tạo rooms
INSERT INTO rooms (room_name) VALUES ('Phòng Chung');
INSERT INTO rooms (room_name) VALUES ('Phòng Dự Án');

-- Thêm thành viên vào phòng
INSERT INTO room_members (user_id, room_id) VALUES (1, 1);  -- alice → Phòng Chung
INSERT INTO room_members (user_id, room_id) VALUES (2, 1);  -- bob → Phòng Chung
INSERT INTO room_members (user_id, room_id) VALUES (3, 1);  -- charlie → Phòng Chung
INSERT INTO room_members (user_id, room_id) VALUES (1, 2);  -- alice → Phòng Dự Án
INSERT INTO room_members (user_id, room_id) VALUES (2, 2);  -- bob → Phòng Dự Án

-- Gửi tin nhắn
INSERT INTO messages (room_id, user_id, content) VALUES (1, 1, 'Xin chào mọi người!');
INSERT INTO messages (room_id, user_id, content) VALUES (1, 2, 'Chào Alice!');
INSERT INTO messages (room_id, user_id, content) VALUES (1, 3, 'Hi cả nhà!');
INSERT INTO messages (room_id, user_id, content) VALUES (2, 1, 'Dự án tuần này thế nào?');
INSERT INTO messages (room_id, user_id, content) VALUES (2, 2, 'Mình đang làm phần backend.');
