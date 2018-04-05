package servlets;

import classes.*;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ABoK4Do on 01.06.17.
 */
public class addOneAJAX extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "";
        String name = req.getParameter("name");
        String categoryName = req.getParameter("catName");
        String priceStr = req.getParameter("price");
        if ((name!=null) && (!name.equals(""))) {
            if ((priceStr!=null) && (!priceStr.equals(""))) {
                FoodsEntity foodsEntity = new FoodsEntity();
                foodsEntity.setName(name);
                ServletService.setCategoryByName(foodsEntity,categoryName);
                foodsEntity.setPrice(Integer.parseInt(priceStr));
                new FoodService().insert(foodsEntity);
                json = new ObjectMapper().writeValueAsString(foodsEntity);
            }
        }


        ServletService.setAnswer(resp,json);
    }
}

