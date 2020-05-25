package config;

import entity.Ingredient;
import entity.Recipe;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"service", "dao.impl"})
public class AppConfig {
    @Bean(name = "bananaCake")
    public Recipe getRecipe() {
        Recipe recipe=new Recipe(1,"Банановый торт",1200,"Description1");
        recipe.addIngredient(new Ingredient("Крем",Ingredient.UNITS.gram.toString()),200);
        recipe.addIngredient(new Ingredient("Масло",Ingredient.UNITS.gram.toString()),100);
        recipe.addIngredient(new Ingredient("Печенье",Ingredient.UNITS.gram.toString()),150);
        recipe.addIngredient(new Ingredient("Бананы",Ingredient.UNITS.pc.toString()),2);

        return recipe;
    }
}
