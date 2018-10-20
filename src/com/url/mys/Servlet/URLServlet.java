package com.url.mys.Servlet;

import com.url.mys.DAO.impl.UrlDaoImpl;
import com.url.mys.Entiy.Url;
import com.url.mys.dbc.DatabaseConnection;
import org.apache.commons.codec.digest.DigestUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(urlPatterns = "/URL")
public class URLServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Random random = new Random();
        UrlDaoImpl udi = new UrlDaoImpl(new DatabaseConnection().getConnection());
        Url url = new Url();

        char character[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();

        // 获取用户输入的网址
        String link = request.getParameter("link");
        // 获取加密字符串的KEY
        String key = request.getParameter("shortsite");

        String result = "";
        for (int i = 0; i < 5; i++) {
            result+=character[random.nextInt(character.length)];
        }

//      String md5 = createMd5(link);
//      String path = String.format("http://localhost:8080/%s?%s/%s", "AccessUrl", key, md5);

        String path = "https://"+key+"/"+result;
        try {
            url.setOurl(link);
            url.setMurl(path);
            udi.doCreate(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("path", path);
        request.setAttribute("link", link);
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public String createMd5(String sourceContext) {
        return DigestUtils.md5Hex(sourceContext);
    }


}
