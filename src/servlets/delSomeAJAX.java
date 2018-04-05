package servlets;

import classes.FoodService;
import classes.FoodsEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ABoK4Do on 22.06.17.
 */
public class delSomeAJAX extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FoodsEntity> entityList = ServletService.fromJsonToFoodEntityList(req);
        if (entityList != null) {
            new FoodService().delete(entityList);
        }
    }
}
