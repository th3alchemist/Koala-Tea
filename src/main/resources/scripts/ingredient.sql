create table ingredient(
  id             serial primary key,
  ingredientname varchar not null,
  amount         numeric not null,
  unitid         int references unit(id) not null
);
