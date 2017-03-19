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
public class delSomeServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("updateBox")!=null) {
            String[] g = req.getParameterValues("updateBox");

            for(int i=0; i<g.length; i++){
                if(g[i]!=null){
                    DataBaseWorker.delOne(Integer.parseInt(g[i]));
                }
            }

        }
        getServletContext().getRequestDispatcher("/showAllServlet").forward(req, resp);



    }


}