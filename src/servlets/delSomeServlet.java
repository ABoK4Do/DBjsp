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
            String[] delElemStr = req.getParameterValues("updateBox");
            int[] delElemInt = new int[delElemStr.length];
            for(int i=0; i<delElemInt.length; i++){
                delElemInt[i] = Integer.parseInt(delElemStr[i]);
            }


            DataBaseWorker.delSome(delElemInt);


        }
        getServletContext().getRequestDispatcher("/showAllServlet").forward(req, resp);



    }


}