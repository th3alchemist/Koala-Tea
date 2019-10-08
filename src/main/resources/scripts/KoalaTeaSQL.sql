
-- User Account table
create table useraccount(
id serial primary key,
firstName varchar not null,
lastName varchar not null,
email varchar unique not null,
password varchar not null,
address varchar not null,
dateofbirth date not null
);

--drop table user_account

insert into useraccount values (default, 'First', 'Last', 'email@mail.com', 'password', '123 street', '2019-10-04');
insert into useraccount values (default, 'First1', 'Last2', 'email2@mail.com', 'password', '456 street', '2019-10-05');

select * from projecttwo.useraccount;


-- Recipe table
create table recipe(
id serial primary key,
title varchar unique not null,
instructions varchar not null,
public boolean not null,
userid int references useraccount(id) not null
);

--drop table recipe;
insert into recipe values (default, 'Recipe 1', 'list of instructions', true, 1);
insert into recipe values (default, 'Recipe 2', 'list of instructions2', true, 1);
insert into recipe values (default, 'Recipe 3', 'list of instructions', true, 2);

select * from recipe;

-- Unit of Measurement table
create table unit(
id serial primary key,
unit varchar not null
);

drop table unit;
insert into unit values (default, 'mL');
insert into unit values (default, 'cups');
insert into unit values (default, 'tablespoon');
insert into unit values (default, 'teaspoon');
insert into unit values (default, 'L');

select * from unit;

-- Ingredient table
create table ingredient(
id serial primary key,
ingredientname varchar not null,
amount numeric not null,
unitid int references unit(id) not null
);

-- Recipe Ingredient JOIN TABLE table
create table recipeingredientjt(
recipeid int references recipe(id) not null,
ingredientid int references ingredient(id) not null
);

-- Cook Book table
create table cookbook(
id serial primary key,
title varchar not null,
description varchar not null,
public boolean not null,
userid int references useraccount(id) not null
);


-- Cook_Book Recipe JOIN TABLE table
create table cookbookrecipejt(
cookbookid int references cookbook(id) not null,
recipeid int references recipe(id) not null
);

-- Meal Plan table
create table mealplan(
id serial primary key,
day date not null,
userid int references useraccount(id) not null
);

-- Meal table
create table meal(
id serial primary key,
course varchar not null,
title varchar not null,
time time not null
);


-- Meal_Plan Meal JOIN TABLE table
create table mealplanmealjt(
mealplanid int references mealplan(id) not null,
mealid int references meal(id) not null
);




select * from useraccount;
--truncate table useraccount;




























