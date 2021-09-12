CREATE TABLE account (
  id VARCHAR(36) NOT NULL,
  is_deleted TINYINT(1) NOT NULL,
  updated_date date NULL,
  account_number VARCHAR(20) NULL,
  account_name VARCHAR(50) NULL,
  phone_number VARCHAR(20) NULL,
  cif VARCHAR(11) NULL,
  address LONGTEXT NULL,
  currency VARCHAR(3) NULL,
  account_type_id VARCHAR(255) NULL,
  CONSTRAINT pk_account PRIMARY KEY (id)
);

CREATE TABLE account_type (
  id VARCHAR(36) NOT NULL,
  is_deleted TINYINT(1) NOT NULL,
  updated_date date NULL,
  code VARCHAR(3) NULL,
  name VARCHAR(100) NULL,
  CONSTRAINT pk_account_type PRIMARY KEY (id)
);

CREATE TABLE deposit (
  id VARCHAR(36) NOT NULL,
  is_deleted TINYINT(1) NOT NULL,
  updated_date date NULL,
  account_id VARCHAR(36) NULL,
  first_amount NUMERIC(19,2) NULL,
  monthly_deposit_amount NUMERIC(19,2) NULL,
  final_balance NUMERIC(19,2) NULL,
  tenor INT(3) NULL,
  saving_purpose VARCHAR(255) NULL,
  start_date date NULL,
  maturity_date date NULL,
  CONSTRAINT pk_deposit PRIMARY KEY (id)
);


ALTER TABLE account ADD CONSTRAINT uc_account_account_number UNIQUE (account_number);

ALTER TABLE account ADD CONSTRAINT FK_ACCOUNT_TYPE_ON_ACCOUNT FOREIGN KEY (account_type_id) REFERENCES account_type (id);

ALTER TABLE deposit ADD CONSTRAINT FK_ACCOUNT_ON_DEPOSIT FOREIGN KEY (account_id) REFERENCES account (id);
