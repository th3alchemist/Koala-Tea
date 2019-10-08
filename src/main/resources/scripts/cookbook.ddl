create table cookbook(
  id          serial primary key,
  title       varchar not null,
  description varchar not null,
  public      boolean not null,
  userid      int references useraccount(id) not null
);