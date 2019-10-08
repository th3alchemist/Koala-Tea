create table mealplan(
  id     serial primary key,
  day    date not null,
  userid int references useraccount(id) not null
);