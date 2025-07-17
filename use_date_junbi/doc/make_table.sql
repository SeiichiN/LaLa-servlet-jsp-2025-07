--
-- exampleデータベース
--

CREATE TABLE members (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  birthday DATE NOT NULL
);

INSERT INTO members (name, birthday) VALUES
('湊 雄輔', '2022-7-17'),
('綾部 みゆき', '2023-10-23');

