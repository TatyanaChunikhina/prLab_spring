package dao.impl;

import entity.Ingredient;
import entity.Recipe;
import dao.RecipeDao;
import java.io.*;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class FileTxtRecipeDao implements RecipeDao{

    @Override
    public void save(Recipe recipe) {
        try(FileWriter writer = new FileWriter("recipes.txt", false))
        {
            writer.write("Название: "+recipe.getName()+"\n");
            writer.write("Кол-во калорий: "+recipe.getKalories()+"\n");
            Map<Ingredient, Double> ingredients=recipe.getIngredients();
            for (Map.Entry<Ingredient, Double> x: ingredients.entrySet()) {
                writer.write("\t"+x.getKey().getName()+"\t"+x.getValue()+x.getKey().getNumeric()+"\n");
            }
            writer.write("Описание: "+recipe.getDescription()+"\n");
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}