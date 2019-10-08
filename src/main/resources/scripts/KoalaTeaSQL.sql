
select * from projecttwo.useraccount;


-- Recipe table

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

-- Recipe Ingredient JOIN TABLE table

-- Cook Book table



-- Cook_Book Recipe JOIN TABLE table

-- Meal Plan table

-- Meal table



-- Meal_Plan Meal JOIN TABLE table





select * from useraccount;
--truncate table useraccount;




























