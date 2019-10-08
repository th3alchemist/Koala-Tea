create table useraccount(
  id          serial primary key,
  firstName   varchar not null,
  lastName    varchar not null,
  email       varchar unique not null,
  password    varchar not null,
  address     varchar not null,
  dateofbirth date not null
);