package servlets;

import classes.FoodService;
import classes.FoodsEntity;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ABoK4Do on 22.06.17.
 */
public class updateSomeAJAX extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "";
        List<FoodsEntity> entityList = ServletService.fromJsonToFoodEntityList(req);
        if (entityList != null) {
            for (FoodsEntity foodsEntity : entityList) {
                ServletService.setCategoryByName(foodsEntity, foodsEntity.getCategory().getName());
            }
            new FoodService().update(entityList);
            json = new ObjectMapper().writeValueAsString(entityList);
        }
        ServletService.setAnswer(resp, json);
    }
}
