package servlets;

import classes.CategoryEntity;
import classes.CategoryService;
import classes.FoodsEntity;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ABoK4Do on 15.06.17.
 */
public class ServletService {
    public static void setAnswer(HttpServletResponse response, String json) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    public static void setCategoryByName(FoodsEntity foodsEntity, String categoryName) {
        CategoryEntity categoryEntity = new CategoryService().findByName(categoryName);
        if (categoryEntity != null) {
            foodsEntity.setCategory(categoryEntity);
            foodsEntity.setCategoryId(categoryEntity.getId());
        } else {
            foodsEntity.setCategoryId(0);
            foodsEntity.setCategory(new CategoryService().findById(0));
        }
    }

    public static List<FoodsEntity> fromJsonToFoodEntityList(HttpServletRequest request) throws IOException {
        List<FoodsEntity> entityList = null;
        if (request.getParameterValues("json")[0] != null) {
            String jsonArray = request.getParameterValues("json")[0];
            System.out.println(jsonArray);
            if (jsonArray != null) {
                FoodsEntity[] entityArray = new ObjectMapper().readValue(jsonArray, FoodsEntity[].class);
                if (entityArray != null)
                    entityList = Arrays.asList(entityArray);
            }
        }
        return entityList;
    }
}
