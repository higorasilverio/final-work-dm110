CREATE TABLE PARTNER (
  PARTNER_CODE INTEGER NOT NULL,
  NAME VARCHAR(30) NOT NULL,
  PHONE VARCHAR(20) NOT NULL,
  EMAIL VARCHAR(50) NOT NULL,
  RATING INTEGER NOT NULL,
  PRIMARY KEY (PARTNER_CODE)
);

CREATE TABLE AUDIT (
  ID INTEGER NOT NULL,
  PARTNER_CODE INTEGER,
  OPERATION VARCHAR(20) NOT NULL,
  TIME_STAMP TIMESTAMP NOT NULL,
  PRIMARY KEY (ID)
);
