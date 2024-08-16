
--- CREATE TRANSACTION TABLE SCRIPT

CREATE TABLE CREDIT_CARD_TRANSACTION (
  transactionId VARCHAR(255) primary key,
  merchantId VARCHAR(255)
  cardNumber numeric,
  amount numeric(10,2)
  timestampInMillis TIMESTAMP
);