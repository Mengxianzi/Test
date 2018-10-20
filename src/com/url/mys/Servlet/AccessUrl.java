package com.url.mys.Servlet;

import com.url.mys.DAO.impl.UrlDaoImpl;
import com.url.mys.dbc.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AccessUrl" ,urlPatterns = "/AccessUrl")
public class AccessUrl extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UrlDaoImpl udi = new UrlDaoImpl(new DatabaseConnection().getConnection());
        String md5 = request.getParameter("path");
        try{
            String sourceUrl = udi.findByUrl(md5);
            response.sendRedirect(sourceUrl);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
