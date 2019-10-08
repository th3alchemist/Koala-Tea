create table cookbookrecipejt(
  cookbookid int references cookbook(id) not null,
  recipeid   int references recipe(id) not null
);
