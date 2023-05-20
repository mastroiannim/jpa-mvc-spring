CREATE TABLE IF NOT EXISTS user (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS chat (
  id INT PRIMARY KEY,
  name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS chat_user (
  chat_id INT NOT NULL,
  user_id INT NOT NULL,
  FOREIGN KEY (chat_id) REFERENCES chat(id),
  FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS message (
  id INT PRIMARY KEY,
  chat_id INT NOT NULL,
  sender_id INT NOT NULL,
  content VARCHAR(255) NOT NULL,
  sent_at TIMESTAMP,
  FOREIGN KEY (chat_id) REFERENCES chat(id),
  FOREIGN KEY (sender_id) REFERENCES user(id)
);

-- Inserimento dati nella tabella "user"
INSERT INTO user (username, password) VALUES
  ('admin', 'admin'),
  ('alice', 'password123'),
  ('bob', 'secret123'),
  ('charlie', 'qwerty');

-- Inserimento dati nella tabella "chat"
INSERT INTO chat (id, name) VALUES
  (1, 'Chat di lavoro'),
  (2, 'Chat di famiglia'),
  (3, 'Chat con amici');

-- Inserimento dati nella tabella "message"
INSERT INTO message (id, chat_id, sender_id, content, sent_at) VALUES
  (1, 1, 1, 'Ciao a tutti!', '2023-05-18 10:00:00'),
  (2, 1, 2, 'Buongiorno!', '2023-05-18 10:05:00'),
  (3, 2, 3, 'Ciao famiglia!', '2023-05-18 11:00:00'),
  (4, 2, 1, 'Come state?', '2023-05-18 11:05:00'),
  (5, 3, 2, 'Ci vediamo stasera!', '2023-05-18 12:00:00');

-- Inserimento dati nella tabella "joined"
INSERT INTO chat_user (chat_id, user_id) VALUES
  (1, 1),
  (1, 2),
  (2, 1),
  (2, 3),
  (3, 2),
  (3, 3);

