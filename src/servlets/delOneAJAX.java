package servlets;

import classes.FoodService;
import classes.FoodsEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ABoK4Do on 05.06.17.
 */
public class delOneAJAX extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(id!=null && !id.equals("")){
            FoodsEntity foodsEntity = new FoodsEntity();
            foodsEntity.setId(Integer.parseInt(id));
            new FoodService().delete(foodsEntity);
        }
    }
}
