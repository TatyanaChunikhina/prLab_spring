import config.AppConfig;
import entity.Recipe;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.RecipeService;

public class Main {
    public static void main(String []args){

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        RecipeService recipService = context.getBean(RecipeService.class);
        Recipe recipe = (Recipe)context.getBean("bananaCake");
        recipService.save(recipe);
    }
}
