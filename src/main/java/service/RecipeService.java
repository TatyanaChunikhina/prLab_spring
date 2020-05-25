package service;

import dao.RecipeDao;
import entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeService {

    @Autowired(required = false)
    private List<RecipeDao> recipeList = new ArrayList<RecipeDao>();

    public void save(Recipe recipe) {
        if(recipeList.isEmpty())
            return;
        for(RecipeDao r: recipeList)
            r.save(recipe);
    }
}