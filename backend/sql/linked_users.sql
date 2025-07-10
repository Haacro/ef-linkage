CREATE TABLE linked_users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  contact_date DATE NOT NULL,
  mobile_id VARCHAR(100) NOT NULL,
  wechat_name VARCHAR(50) NOT NULL,
  game_name VARCHAR(50) NOT NULL,
  game_id CHAR(9) NOT NULL,
  days_logged INT DEFAULT 0,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO linked_users (
  contact_date,
  mobile_id,
  wechat_name,
  game_name,
  game_id,
  days_logged
) VALUES
('2025-07-07', '18274880297', 'wyx', '尔湾实况第一人', '990810702', 2),
('2025-07-07', '18523896180', '王乐观', '彼阳de晚意', '796943575', 2),
('2025-07-07', '13699465977', '峰', '吹过阿峰', '751388845', 2),
('2025-07-07', '19722191193', '胖呆', '真的恶心GY', '015130885', 2);
