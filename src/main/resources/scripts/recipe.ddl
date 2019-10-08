create table recipe(
  id           serial primary key,
  title        varchar unique not null,
  instructions varchar not null,
  public       boolean not null,
  userid       int references useraccount(id) not null
);