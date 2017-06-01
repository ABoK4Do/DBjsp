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
public class addSomeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] names = req.getParameterValues("addName");
        String[] categories = req.getParameterValues("addCat");
        String[] prices = req.getParameterValues("addPrice");

        for (int i = 0; i < names.length; i++) {
            if (names[i] != "null" && !names[i].equals(""))
                if (prices[i] != "null" && !prices[i].equals(""))
                    if (categories[i] == "null" && !categories[i].equals("")) {
                        DataBaseWorker.addOne(names[i].toString(), prices[i]);
                    } else DataBaseWorker.addOne(names[i].toString(), categories[i], prices[i]);


        }
        getServletContext().getRequestDispatcher("/showAllServlet").forward(req, resp);

    }


}
