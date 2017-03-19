package servlets;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ABoK4Do on 13.01.17.
 */
public class wayServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getParameter("chooser").equals("showAll")) {

            getServletContext().getRequestDispatcher("/showAllServlet").forward(req, resp);
        }
        if (req.getParameter("chooser").equals("search")) {
            getServletContext().getRequestDispatcher("/searchServlet").forward(req, resp);
        }
        if (req.getParameter("chooser").equals("closeAll")) {
            req.setAttribute("resultArray", null);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }

        if (req.getParameter("chooser").equals("DELETE")) {

            getServletContext().getRequestDispatcher("/delSomeServlet").forward(req, resp);
        }
        if (req.getParameter("chooser").equals("SAVE")) {

            getServletContext().getRequestDispatcher("/addSomeServlet").forward(req, resp);
        }

    }
}


