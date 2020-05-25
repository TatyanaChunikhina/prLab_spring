package dao.impl;

import dao.RecipeDao;
import entity.Ingredient;
import entity.Recipe;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Map;

@Component
public class DBRecipeDao implements RecipeDao {

    private Statement getStatementConnection() throws ClassNotFoundException, SQLException {
        String server ="TATYANANOTE\\SQLEXPRESS";
        String urlDatabase ="bd_recipes";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionString = "jdbc:sqlserver://localhost:1433;serverName="+server+";databaseName="+urlDatabase+";integratedSecurity=true;";

        Connection con = DriverManager.getConnection(connectionString);
        return con.createStatement();
    }

    @Override
    public void save(Recipe recipe) {
        try {
            Statement stDatabase = getStatementConnection();
            String sExecute = "INSERT INTO recipes (name,description,kalories)  Values( '"+recipe.getName()+"', '"+recipe.getDescription()+"', '"+recipe.getKalories()+"');" ;
            stDatabase.execute(sExecute);
            sExecute="Select id from recipes where name='"+recipe.getName()+"';";
            ResultSet rs=stDatabase.executeQuery(sExecute);
            int id=-1;
            if(rs.next()) {

                id = rs.getInt(1);

                Map<Ingredient, Double> ingredients = recipe.getIngredients();
                for (Map.Entry<Ingredient, Double> x : ingredients.entrySet()) {
                    sExecute = "INSERT INTO ingredientList (name,numeric,count,recipe) Values('" + x.getKey().getName() + "', '" + x.getKey().getNumeric() + "', '" + x.getValue() + "', " + id + ");";
                    stDatabase.execute(sExecute);
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



}
