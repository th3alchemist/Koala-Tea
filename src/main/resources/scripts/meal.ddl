create table meal(
  id     serial primary key,
  course varchar not null,
  title  varchar not null,
  time   time not null
);