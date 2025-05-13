package bmi;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/bmi")
public class BMIServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            double weight = Double.parseDouble(req.getParameter("weight"));
            double height = Double.parseDouble(req.getParameter("height"));
            double bmi = weight / (height * height);
            req.setAttribute("bmi", bmi);
        } catch (Exception e) {
            req.setAttribute("bmi", "Lỗi khi tính toán.");
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("bmi.jsp");
        dispatcher.forward(req, resp);
    }
}
