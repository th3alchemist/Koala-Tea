--drop table useraccount cascade;
--drop table cookbook;
--drop table recipe;
--drop table ingredient;
--drop table unit;
--drop table mealplan;
--drop table meal;


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
insert into useraccount values (default, 'First', 'Last', 'email@mail.com', 'password', '123 street', '2019-10-04');
insert into useraccount values (default, 'First1', 'Last2', 'email2@mail.com', 'password', '456 street', '2019-10-05');

select * from projecttwo.useraccount;


-- Recipe table
create table recipe(
id serial primary key,
title varchar unique not null,
instructions varchar not null,
public boolean not null,
userid int references useraccount(id) not null,
cookbookid int references cookbook(id)
);

insert into recipe values (default, 'Recipe 1', 'list of instructions', true, 1, 1);
insert into recipe values (default, 'Recipe 2', 'list of instructions2', true, 1, 1);
insert into recipe values (default, 'Recipe 3', 'list of instructions', true, 2, 2);

select * from recipe;

-- Unit of Measurement table
create table unit(
id serial primary key,
unit varchar not null
);

INSERT INTO UNIT VALUES (1, 'teaspoon');
INSERT INTO UNIT VALUES (2, 'tablespoon');
INSERT INTO UNIT VALUES (3, 'fluid-ounce');
INSERT INTO UNIT VALUES (4, 'cup');
INSERT INTO UNIT VALUES (5, 'pint');
INSERT INTO UNIT VALUES (6, 'quart');
INSERT INTO UNIT VALUES (7, 'gallon');
INSERT INTO UNIT VALUES (8, 'milliliter');
INSERT INTO UNIT VALUES (9, 'liter');
INSERT INTO UNIT VALUES (10, 'pound');
INSERT INTO UNIT VALUES (11, 'ounce');
INSERT INTO UNIT VALUES (12, 'mg');
INSERT INTO UNIT VALUES (13, 'g');
INSERT INTO UNIT VALUES (14, 'kg');

select * from unit;

-- Ingredient table
create table ingredient(
id serial primary key,
ingredientname varchar not null,
amount numeric not null,
unitid int references unit(id) not null,
recipeid int references recipe(id) not null
);

--for recipe 1
insert into ingredient values(default, 'Soy Sauce', 50, 8, 1);
insert into ingredient values(default, 'Brown Sugar', 2, 2, 1);
insert into ingredient values(default, 'Garlic Powder', 2, 2, 1);
insert into ingredient values(default, 'Ginger Powder', 2, 2, 1);
insert into ingredient values(default, 'Lemon Juice', 1, 1, 1);
--for recipe 2
insert into ingredient values(default, 'Flour', 1, 4, 2);
insert into ingredient values(default, 'Bread Crumb', 1, 4, 2);
insert into ingredient values(default, 'Egg', 2, 2, 2);
insert into ingredient values(default, 'Salt', 1, 1, 2);
insert into ingredient values(default, 'Pepper', 1, 1, 2);
--for recipe 3
insert into ingredient values(default, 'Red Sauce', 4, 5, 3);
insert into ingredient values(default, 'NY Italian Sausage', 3, 7, 3);
insert into ingredient values(default, 'Onion', 5, 2, 3);
insert into ingredient values(default, 'Garlic', 7, 2, 3);
insert into ingredient values(default, 'Rigatoni',2, 4, 3);


-- Cook Book table
create table cookbook(
id serial primary key,
title varchar not null,
description varchar not null,
public boolean not null,
userid int references useraccount(id) not null
);

insert into cookbook values (default, 'My Cookbook', 'My Cookbook contains recipes', true, 1);
insert into cookbook values (default, 'Another Cookbook', 'My Cookbook contains more recipes', true, 2);



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
time time not null,
mealplanid int references mealplan(id) not null
);
























