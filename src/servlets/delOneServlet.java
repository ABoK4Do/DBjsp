package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ABoK4Do on 13.01.17.
 */
public class delOneServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("del_name")!=null) {
         //   DataBaseWorker.delOne(req.getParameter("del_name"));
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);



    }


}
