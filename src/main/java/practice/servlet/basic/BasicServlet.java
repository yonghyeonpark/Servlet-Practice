package practice.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// name : 서블릿 이름, urlPatterns : URL 매핑 => 둘은 중복되면 안됨
@WebServlet(name = "basicServlet", urlPatterns = "/basic")
public class BasicServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("BasicServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // 쿼리 파라미터 조회
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // header 정보
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        // body 정보
        response.getWriter().write("이름 : " + username);
    }
}
