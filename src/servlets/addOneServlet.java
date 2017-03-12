package servlets;

import classes.DataBaseWorker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ABoK4Do on 13.01.17.
 */
public class addOneServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("cat_name")=="null"||req.getParameter("cat_name")==""){
        DataBaseWorker.addOne(req.getParameter("food_name"),req.getParameter("price"));}
        else DataBaseWorker.addOne(req.getParameter("food_name"),req.getParameter("cat_name"), req.getParameter("price"));
       getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }


}
