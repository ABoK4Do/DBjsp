package servlets;

import classes.CategoryEntity;
import classes.DataBaseWorker;
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
        String catName = req.getParameter("catName");
        String price = req.getParameter("price");
        if ((name!=null) && (!name.equals(""))) {
            if ((price!=null) && (!price.equals(""))) {
                FoodsEntity food = new FoodsEntity();
                food.setId(Integer.parseInt(id));
                food.setName(name);
                food.setCategory(new CategoryEntity());
                food.getCategory().setName(catName);
                food.setPrice(Integer.parseInt(price));
                DataBaseWorker.updateOne(food);
                json = new ObjectMapper().writeValueAsString(food);
            }
        }


        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
