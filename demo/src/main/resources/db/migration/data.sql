CREATE TABLE IF NOT EXISTS user (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE Chat (
  id INT PRIMARY KEY,
  name VARCHAR(50) NOT NULL
);

CREATE TABLE Message (
  id INT PRIMARY KEY,
  chat_id INT NOT NULL,
  sender_id INT NOT NULL,
  content VARCHAR(255) NOT NULL,
  sent_at TIMESTAMP,
  FOREIGN KEY (chat_id) REFERENCES Chat(id),
  FOREIGN KEY (sender_id) REFERENCES User(id)
);

INSERT INTO user (username, password) VALUES ('admin', 'admin');

-- Inserimento dati nella tabella "User"
INSERT INTO User (id, username, password) VALUES
  (1, 'alice', 'password123'),
  (2, 'bob', 'secret123'),
  (3, 'charlie', 'qwerty');

-- Inserimento dati nella tabella "Chat"
INSERT INTO Chat (id, name) VALUES
  (1, 'Chat di lavoro'),
  (2, 'Chat di famiglia'),
  (3, 'Chat con amici');

-- Inserimento dati nella tabella "Message"
INSERT INTO Message (id, chat_id, sender_id, content, sent_at) VALUES
  (1, 1, 1, 'Ciao a tutti!', '2023-05-18 10:00:00'),
  (2, 1, 2, 'Buongiorno!', '2023-05-18 10:05:00'),
  (3, 2, 3, 'Ciao famiglia!', '2023-05-18 11:00:00'),
  (4, 2, 1, 'Come state?', '2023-05-18 11:05:00'),
  (5, 3, 2, 'Ci vediamo stasera!', '2023-05-18 12:00:00');

