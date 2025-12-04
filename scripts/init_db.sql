-- Create schema acctmanager
Create schema IF NOT EXISTS acctmanager;

SET search_path TO acctmanager;


-- Banker Table
CREATE TABLE banker (
   sysid     uuid PRIMARY KEY DEFAULT gen_random_uuid(),
   customer_id varchar(100) not null,
   bank_name varchar(100) not null,
   ifsc_code varchar(100) not null,
   branch varchar(100) not null
);


-- Accounts table
CREATE TABLE savings_account (
   sysid     uuid not null,
   account_number varchar(100) not null,
   account_type varchar(100) not null,
   opening_date varchar(100) not null,
   closing_date varchar(100) not null,
   status varchar(100) not null,
   balance decimal(10,2),
   PRIMARY KEY(sysid, account_number)
);


-- FD
CREATE TABLE term_deposits(
   sysid     uuid not null,
   deposit_number varchar(100) not null,
   Amount decimal(10,2),
   Opening_date timestamp(6),
   Maturity_date timestamp(6),
   Closing_date timestamp(6),
   AutoRenew boolean,
   Maturity_value decimal(10,2),
   Interest_rate decimal(3,2),
   PRIMARY KEY(sysid, deposit_number)
);



-- RD
CREATE TABLE recurring_deposits(
   sysid     uuid not null,
   deposit_number varchar(100) not null,
   Amount decimal(10,2),
   Opening_date timestamp(6),
   Maturity_date timestamp(6),
   Closing_date timestamp(6),
   AutoRenew boolean,
   Maturity_value decimal(10,2),
   Interest_rate decimal(3,2),
   Frequency int,
   PRIMARY KEY(sysid, deposit_number)
);


--Loan
CREATE TABLE loans(
   sysid     uuid not null,
   loan_number varchar(100) not null,
   Amount decimal(10,2),
   EMI decimal(10,2),
   tenureInMonths int,
   InterestSchemeId uuid not null,
   Open_date timestamp(6),
   Closing_date timestamp(6),
   Description varchar(300),
   
   PRIMARY KEY(sysid, loan_number)
);


--InterestScheme
CREATE TABLE InterestScheme(
   sysid     uuid not null,
   Interest_rate decimal(3,2),
   ValidFrom timestamp(6),
   ValidTo timestamp(6) 
);

--Credit card
CREATE TABLE CreditCards(
   sysid     uuid not null,
   cardnumber varchar(20),
   ValidFrom timestamp(6),
   ValidTo timestamp(6) 
);



