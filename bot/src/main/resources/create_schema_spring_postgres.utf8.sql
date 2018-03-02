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

DROP TABLE IF EXISTS chat_qa;
DROP TABLE IF EXISTS bot_qa;

/* Drop Sequences */

DROP SEQUENCE IF EXISTS seq_chat_qa_id;
DROP SEQUENCE IF EXISTS seq_bot_qa_id;

/* Create Sequences */

CREATE SEQUENCE seq_chat_qa_id INCREMENT BY 1 START WITH 101;
CREATE SEQUENCE seq_bot_qa_id INCREMENT BY 1 START WITH 101;


/* Create Tables */

CREATE TABLE chat_qa
(
    id INTEGER PRIMARY KEY DEFAULT nextval('seq_chat_qa_id'),
    question VARCHAR(128),
    answer VARCHAR(128)
);

CREATE TABLE bot_qa
(
    id INTEGER PRIMARY KEY DEFAULT nextval('seq_bot_qa_id'),
    question VARCHAR(128),
    answer VARCHAR(128)
);

/* Change Owner */

ALTER SEQUENCE seq_chat_qa_id OWNER TO edu;
ALTER SEQUENCE seq_bot_qa_id OWNER TO edu;
ALTER TABLE chat_qa OWNER TO edu;
ALTER TABLE bot_qa OWNER TO edu;


/* Insert Data */

BEGIN;

INSERT INTO chat_qa VALUES(nextval('seq_chat_qa_id'), 'こんにちは', 'はじめまして');
INSERT INTO chat_qa VALUES(nextval('seq_chat_qa_id'), 'あなたはだれですか？', 'わたしはボットです');
INSERT INTO chat_qa VALUES(nextval('seq_chat_qa_id'), '今日の天気は？', '快晴です');

INSERT INTO bot_qa VALUES(nextval('seq_bot_qa_id'), 'こんにちは', 'はじめまして');
INSERT INTO bot_qa VALUES(nextval('seq_bot_qa_id'), 'だれですか', 'わたしはボットです');
INSERT INTO bot_qa VALUES(nextval('seq_bot_qa_id'), '天気は', '快晴です');

COMMIT;


/* Show all records */

SELECT * FROM chat_qa;
SELECT * FROM bot_qa;
SELECT last_value FROM seq_chat_qa_id;
SELECT last_value FROM seq_bot_qa_id;

/* Show table metadata */
\d

/* *****************************************************************************
 * Setup is success when all data are shown and all "owner" is "edu".
 * *****************************************************************************
 */;
