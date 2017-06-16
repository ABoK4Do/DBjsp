package servlets;

import classes.FoodsEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ABoK4Do on 05.06.17.
 */
public class addSomeAJAX extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<FoodsEntity> foods = new ArrayList<FoodsEntity>();
        String names = req.getParameter("3");
        Map test = req.getParameterMap();
        String[] prices = req.getParameterValues("price");

        System.out.println("name" + names + "map:" + test.keySet());
    }

}


