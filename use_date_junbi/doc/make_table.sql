--
-- exampleデータベース
--

CREATE TABLE members (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  birthday DATE NOT NULL
);

INSERT INTO members (name, birthday) VALUES
('湊 雄輔', '2002-7-17'),
('綾部 みゆき', '2003-10-23');

