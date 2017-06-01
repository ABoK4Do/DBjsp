package servlets;

import classes.DataBaseWorker;
import classes.FoodsEntity;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ABoK4Do on 01.06.17.
 */
public class searchAJAX extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = null;
        if(request.getParameter("searchCat").equals("1")) {
          List<FoodsEntity> foods = DataBaseWorker.searchByName(request.getParameter("finder"));
          json = new ObjectMapper().writeValueAsString(foods);
       // System.out.print(request.getParameterMap());


        }
        if(request.getParameter("searchCat").equals("2")){
            List<FoodsEntity> foods = DataBaseWorker.searchByCat(request.getParameter("finder"));
            json = new ObjectMapper().writeValueAsString(foods);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

       /* if(req.getParameter("searchCat").equals("2")){
            req.setAttribute("resultArray", DataBaseWorker.(req.getParameter("finder")));
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);}*/
    }
}
