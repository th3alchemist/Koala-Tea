create table useraccount(
  id          serial primary key,
  firstName   varchar not null,
  lastName    varchar not null,
  email       varchar unique not null,
  password    varchar not null,
  address     varchar not null,
  dateofbirth date not null
);


insert into useraccount values (default, 'Chris', 'P. Bacon', 'vegansUnite@beef.com', 'password', '123 street', '1998-10-04');
insert into useraccount values (default, 'Jed', 'I. Nyght', 'bananas@pajamas.com', 'password', '456 street', '2001-04-15');
