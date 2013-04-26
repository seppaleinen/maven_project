import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Lab1Servlet
 */
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 7833322140419182952L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        response.getWriter().println
                ("<html> " +
                        "<body>" +
                        "<h1> Lab1 Servlet</h1>" +
                        "<br>" +
                        "<table>" +
                        "<tbody>" +
                        "<tr>" +
                        "<td>" + "Username " + "</td>" +
                        "<td>" + username + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td>" + "Password " + "</td>" +
                        "<td>" + password + "</td>" +
                        "</tr>" +
                        "<tbody>" +
                        "</table>" +
                        "</body>" +
                        "</html>");
    }

//        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String username = request.getParameter("userName");
//        String password = request.getParameter("password");
//        String[] children = request.getParameterValues("children");
//        int i, noOfChildren = children.length;
//        String childrenString = "";
//
//        if (noOfChildren > 0) {
//            for (i= 0; i < noOfChildren; i++) {
//                childrenString = childrenString.concat("<tr><td> Child </td>" + "<td>" + children[i] + "</td></tr>");
//            };
//        }
//        else {
//            childrenString = "<tr><td> Child </td> <td> no children </td></tr>";
//        }
//
//        response.setContentType("text/html");
//        response.getWriter().println
//                ("<html> " +
//                        "<body>" +
//                        "<h1> Lab1 Servlet</h1>" +
//                        "<br>" +
//                        "<table>" +
//                        "<tbody>" +
//                        "<tr>" +
//                        "<td>" + "Username " + "</td>" +
//                        "<td>" + username + "</td>" +
//                        "</tr>" +
//                        "<tr>" +
//                        "<td>" + "Password " + "</td>" +
//                        "<td>" + password + "</td>" +
//                        "</tr>" +
//                        childrenString +
//                        "<tbody>" +
//                        "</table>" +
//                        "</body>" +
//                        "</html>");
//    }
}
