package servlets;

import classes.CategoryEntity;
import classes.CategoryService;
import classes.FoodsEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ABoK4Do on 15.06.17.
 */
public class ServletService {
    public static void setAnswer(HttpServletResponse response, String json) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    public static void setCategory(FoodsEntity foodsEntity, String categoryName){
        CategoryEntity categoryEntity = new CategoryService().findByName(categoryName);
        if(categoryEntity!=null){
            foodsEntity.setCategory(categoryEntity);
            foodsEntity.setCategoryId(categoryEntity.getId());
        }else {
            foodsEntity.setCategoryId(0);
            foodsEntity.setCategory(new CategoryService().findById(0));
        }
    }
}
