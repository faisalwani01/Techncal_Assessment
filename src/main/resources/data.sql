DROP TABLE IF EXISTS user_features;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS features;

CREATE TABLE users (
  id            LONG AUTO_INCREMENT PRIMARY KEY,
  email_address VARCHAR(250) NOT NULL
);

INSERT INTO users (email_address)
VALUES ('faisal@gmail.com'),
       ('steve@gmail.com'),
       ('matt@gmail.com'),
       ('jondoe@gmail.com');

CREATE UNIQUE INDEX USERS_EMAIL_UNIQUE
  ON users (email_address);


CREATE TABLE features (
  id           LONG AUTO_INCREMENT PRIMARY KEY,
  feature_name VARCHAR(100) NOT NULL
);

CREATE UNIQUE INDEX FEATURE_NAME_UNIQUE
  ON features (feature_name);

CREATE TABLE user_features (
  id         LONG AUTO_INCREMENT PRIMARY KEY,
  user_id    LONG,
  feature_id LONG,
  status     BOOLEAN,
  foreign key (feature_id) references features (id),
  foreign key (user_id) references users (id)

);

ALTER TABLE user_features
  ADD CONSTRAINT USER_FEATURE_UNQ_KEY UNIQUE KEY (user_id, feature_id);

INSERT INTO features (feature_name)
VALUES ('create'),
       ('update'),
       ('delete'),
       ('search');

