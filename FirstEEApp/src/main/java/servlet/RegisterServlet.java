package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String errMessage = "";
        if (name == null || name.equals("")) {
            errMessage += "name can not be null <br>";
        }
        if (surname == null || surname.equals("")) {
            errMessage += "surname can not be null<br>";
        }
        if (email == null || email.equals("")) {
            errMessage += "email can not be null<br>";
        }
        if (password == null || password.equals("")) {
            errMessage += "password can not be null<br>";
        }

        if (errMessage.equals("")) {
            req.setAttribute("name", name);
            req.getRequestDispatcher("/home.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", errMessage);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);

        }

    }
}
