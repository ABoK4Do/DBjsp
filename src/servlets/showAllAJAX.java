package servlets;

import classes.DataBaseWorker;
import classes.FoodsEntity;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ABoK4Do on 30.05.17.
 */
public class showAllAJAX extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        List<FoodsEntity> foods = DataBaseWorker.showDB();
        String json = new ObjectMapper().writeValueAsString(foods);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
