package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/xuLy")
public class XuLyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));
        String result = "";

        if ("GiaiPT".equals(action)) {
            double delta = b * b - 4 * a * c;
            if (a == 0) {
                result = "Không phải phương trình bậc 2";
            } else if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                result = "Phương trình có 2 nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2;
            } else if (delta == 0) {
                double x = -b / (2 * a);
                result = "Phương trình có nghiệm kép: x = " + x;
            } else {
                result = "Phương trình vô nghiệm";
            }
        } else if ("KiemTraTamGiac".equals(action)) {
            if (a + b > c && a + c > b && b + c > a) {
                result = "Đây là 3 cạnh của một tam giác.";
            } else {
                result = "Không phải là 3 cạnh của một tam giác.";
            }
        }

        request.setAttribute("result", result);
        request.getRequestDispatcher("ketqua.jsp").forward(request, response);
    }
}
