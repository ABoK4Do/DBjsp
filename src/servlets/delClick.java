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
public class delClick extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name1=req.getQueryString();
        if(name1!=null) {
            DataBaseWorker.delOne(name1);
        }
         getServletContext().getRequestDispatcher("/index.jsp#add_plus").forward(req, resp);



    }


}