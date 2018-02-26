/***************************************************************************
 * Open this file with "SJIS".
 * Copy all contents of this file, and paste to PSQL.
 ***************************************************************************/


/* Create User and Database */
DROP DATABASE IF EXISTS edu_spring_db;

DROP ROLE IF EXISTS "edu";

CREATE ROLE "edu" LOGIN
  PASSWORD 'edu'
  NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;

CREATE DATABASE edu_spring_db
  WITH OWNER = "edu"
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       CONNECTION LIMIT = -1;
GRANT ALL ON DATABASE edu_spring_db TO "edu";
REVOKE ALL ON DATABASE edu_spring_db FROM public;

\c edu_spring_db

/* Drop Tables */

DROP TABLE IF EXISTS chat;
DROP TABLE IF EXISTS bot;

/* Drop Sequences */

DROP SEQUENCE IF EXISTS seq_chat_id;
DROP SEQUENCE IF EXISTS seq_bot_id;

/* Create Sequences */

CREATE SEQUENCE seq_chat_id INCREMENT BY 1 START WITH 101;
CREATE SEQUENCE seq_bot_id INCREMENT BY 1 START WITH 101;


/* Create Tables */

CREATE TABLE chat
(
    id INTEGER PRIMARY KEY DEFAULT nextval('seq_chat_id'),
    question VARCHAR(128),
    answer VARCHAR(128)
);

CREATE TABLE bot
(
    id INTEGER PRIMARY KEY DEFAULT nextval('seq_bot_id'),
    question VARCHAR(128),
    answer VARCHAR(128)
);

/* Change Owner */

ALTER SEQUENCE seq_chat_id OWNER TO edu;
ALTER SEQUENCE seq_bot_id OWNER TO edu;
ALTER TABLE chat OWNER TO edu;
ALTER TABLE bot OWNER TO edu;


/* Insert Data */

BEGIN;

INSERT INTO chat VALUES(nextval('seq_chat_id'), 'こんにちは', 'はじめまして');
INSERT INTO chat VALUES(nextval('seq_chat_id'), 'あなたはだれですか？', 'わたしはボットです');
INSERT INTO chat VALUES(nextval('seq_chat_id'), '今日の天気は？', '快晴です');

INSERT INTO bot VALUES(nextval('seq_bot_id'), 'こんにちは', 'はじめまして');
INSERT INTO bot VALUES(nextval('seq_bot_id'), 'だれですか', 'わたしはボットです');
INSERT INTO bot VALUES(nextval('seq_bot_id'), '天気は', '快晴です');

COMMIT;


/* Show all records */

SELECT * FROM chat;
SELECT * FROM bot;
SELECT last_value FROM seq_chat_id;
SELECT last_value FROM seq_bot_id;

/* Show table metadata */
\d

/* *****************************************************************************
 * Setup is success when all data are shown and all "owner" is "edu".
 * *****************************************************************************
 */;
