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
public class searchServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("typeTable", "row");
        if(req.getParameter("searchCat").equals("1")) {
            req.setAttribute("resultArray", DataBaseWorker.searchByName(req.getParameter("finder")));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }

            if(req.getParameter("searchCat").equals("2")){
                req.setAttribute("resultArray", DataBaseWorker.searchByCat(req.getParameter("finder")));
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);}







    }


}