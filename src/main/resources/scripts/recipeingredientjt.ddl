create table recipeingredientjt(
  recipeid int references recipe(id) not null,
  ingredientid int references ingredient(id) not null
);
