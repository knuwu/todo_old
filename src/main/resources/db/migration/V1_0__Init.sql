CREATE TABLE todo (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  added_at DATETIME NOT NULL,
  modified_at DATETIME,
  due_at_date DATE,
  due_at_time TIME,
  remind_at DATETIME,
  title VARCHAR(255) NOT NULL ,
  details VARCHAR(1024)
);

INSERT INTO todo (added_at, title, details)
    VALUES (CURRENT_TIMESTAMP, 'Test', 'Dies ist ein Testeintrag');