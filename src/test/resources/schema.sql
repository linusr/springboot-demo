DROP TABLE IF EXISTS TBL_MENU;
CREATE TABLE TBL_MENU (
  id INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(100),
  URL VARCHAR(250),
  PRNT_ID INTEGER,
  SEQ INTEGER NOT NULL
);
