package bmi;

import java.io.IOException;
import javax.servlet.*;

public class BMIInputFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            double weight = Double.parseDouble(request.getParameter("weight"));
            double height = Double.parseDouble(request.getParameter("height"));

            if (weight <= 0 || height <= 0) {
                request.setAttribute("error", "Chiều cao và cân nặng phải lớn hơn 0");
                request.getRequestDispatcher("bmi.jsp").forward(request, response);
                return;
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Vui lòng nhập số hợp lệ");
            request.getRequestDispatcher("bmi.jsp").forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }
}
