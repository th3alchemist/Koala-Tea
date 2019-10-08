create table mealplanmealjt(
  mealplanid int references mealplan(id) not null,
  mealid     int references meal(id) not null
);