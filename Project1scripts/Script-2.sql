create table customer(
id serial primary key,
fname varchar(30),
lname varchar(30),
username varchar(30) unique,
c_password varchar(30),
c_email varchar(30) unique
);

drop table customer 
delete from customer
where fname = 'Taybian'


create table bank_account_c(
customer_id serial,
checkings_accountid serial,
checkings_balance numeric,
constraint foreign_key foreign key (customer_id) references customer(id)
);

drop table bank_account_c 

create table bank_account_s(
customer_id serial,
savings_accountid serial,
savings_balance numeric,
constraint foreign_key foreign key (customer_id) references customer(id)
);

drop table bank_account_s


create table transactions(
trans_id serial,
customer_id serial references customer(id),
checkings_accountid serial,
savings_accountid serial,
current_checkings numeric,
current_savings numeric,
amount numeric,
total_checkings numeric,
total_savings numeric
);


drop table transactions
-------------DummyAcounts--------
insert into customer(id,fname,lname,username,c_password,c_email) values
     (56765,'Mark','Robbin','Mark12','password2','@ggmail.com'),
     (45600,'Joe','Que','Joe44','password3','@gggmail.com');
     
insert into bank_account_c(customer_id,checkings_accountid,checkings_balance) values
       (56765,789876,1298989),
       (45600,900900,80000);
       
insert into bank_account_s(customer_id,savings_accountid,savings_balance) values
       (56765,45454,130000),
       (45600,67676,12333);