package practice.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import practice.servlet.basic.BasicData;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("content-type", "application/json");
        response.setCharacterEncoding("utf-8");

        BasicData basicData = new BasicData();
        basicData.setUsername("hi");
        basicData.setAge(20);

        String result = objectMapper.writeValueAsString(basicData);
        
        response.getWriter().write(result);
    }
}
