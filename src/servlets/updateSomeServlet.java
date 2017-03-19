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
public class updateSomeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("typeTable").equals("text")||req.getParameter("typeTable") == null) {
           /* String[] arrayIds = req.getParameterValues("updateBox");
            String[] names = req.getParameterValues("addName");
            String[] categories = req.getParameterValues("addCat");
            String[] prices = req.getParameterValues("addPrice");

            for(int i=0;i<names.length; i++){
                if (names[i] != "null" && !names[i].equals(""))
                    if (prices[i] != "null" && !prices[i].equals(""))
                    {
                           // DataBaseWorker.updateOne(arrayIds[i], names[i], categories[i], prices[i]);
                }
            }
            req.setAttribute("typeTable", "row");
            */
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

        } else {
            if (req.getParameter("updateBox") != null) {
                String[] arrayIds = req.getParameterValues("updateBox");
                String ids = "(";
                for (int i = 0; i < arrayIds.length - 1; i++) {
                    ids += arrayIds[i] + ",";
                }
                
                ids += arrayIds[arrayIds.length - 1] + ")";
                req.setAttribute("resultArray", DataBaseWorker.searchByIds(ids));
                req.setAttribute("typeTable", "text");
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

            }

        }
    }
}