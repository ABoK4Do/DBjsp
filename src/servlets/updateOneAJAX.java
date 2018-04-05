package servlets;

import classes.FoodService;
import classes.FoodsEntity;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ABoK4Do on 05.06.17.
 */
public class updateOneAJAX extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "";
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String categoryName = req.getParameter("catName");
        String price = req.getParameter("price");
        if ((name!=null) && (!name.equals(""))) {
            if ((price!=null) && (!price.equals(""))) {
                FoodsEntity foodsEntity = new FoodsEntity();
                foodsEntity.setId(Integer.parseInt(id));
                foodsEntity.setName(name);
                ServletService.setCategoryByName(foodsEntity,categoryName);
                foodsEntity.setPrice(Integer.parseInt(price));
                new FoodService().update(foodsEntity);
                json = new ObjectMapper().writeValueAsString(foodsEntity);
            }
        }


        ServletService.setAnswer(resp,json);
    }
}
