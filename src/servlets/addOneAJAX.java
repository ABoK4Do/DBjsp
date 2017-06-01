package servlets;

import classes.CategoryEntity;
import classes.Factory;
import classes.FoodsEntity;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ABoK4Do on 01.06.17.
 */
public class addOneAJAX extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FoodsEntity food = new FoodsEntity();
       String name = "test1";
        //req.getParameter("name");
        String catName = "test2";
        //.getParameter("catName");
        int cat_id = 0;
        //int price = Integer.parseInt(req.getParameter("price"));
        int price = 10;
        if(!name.equals(null)&&(price!=0)){
            if(!catName.equals(null)){
                CategoryEntity cat = null;
                List<CategoryEntity> cats = null;
                try {
                    cats = Factory.getInstance().getCategoryDAO().findByName(catName);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (cats.size() > 0)
                    cat = cats.get(0);

                if (cat != null) {
                    cat_id = cat.getId();
                }
            }
            food.setName(name);
            food.setPrice(price);
            food.setCategoryId(cat_id);
           // food.getCategory().setName(catName);
            try {
                Factory.getInstance().getFoodDAO().insert(food);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String json = new ObjectMapper().writeValueAsString(food);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        }
    }
}
