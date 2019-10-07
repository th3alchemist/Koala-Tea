create table recipe(
  id           serial primary key,
  title        varchar unique not null,
  instructions varchar not null,
  public       boolean not null,
  userid       int references useraccount(id) not null
);

insert into recipe values (default, 'Recipe 1', 'list of instructions', true, 1);
insert into recipe values (default, 'Recipe 2', 'list of instructions2', true, 1);
insert into recipe values (default, 'Recipe 3', 'list of instructions', true, 2);