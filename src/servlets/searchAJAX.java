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
 * Created by ABoK4Do on 01.06.17.
 */
public class searchAJAX extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String json = "";
        if (request.getParameter("searchCat").equals("1")) {
            List<FoodsEntity> foodsEntities = new FoodService().findByName(request.getParameter("finder"));
            if (foodsEntities != null) {
                json = new ObjectMapper().writeValueAsString(foodsEntities);
            }



        }
        if (request.getParameter("searchCat").equals("2")) {
            List<FoodsEntity> foodsEntities = new FoodService().findByCategoryName(request.getParameter("finder"));
            if (foodsEntities != null) {
                json = new ObjectMapper().writeValueAsString(foodsEntities);
            }
        }

        ServletService.setAnswer(resp,json);


    }
}
