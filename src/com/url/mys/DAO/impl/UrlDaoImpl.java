package com.url.mys.DAO.impl;
import com.url.mys.DAO.UrlDao;
import com.url.mys.Entiy.Url;

import java.sql.*;

public class UrlDaoImpl implements UrlDao {

    private Connection conn;
    private PreparedStatement pstmt;
    public UrlDaoImpl(Connection conn){
        this.conn = conn;
    }
    public UrlDaoImpl(){ }

    @Override
    public void doCreate(Url url) throws Exception {
        String sql = "insert into url(quondam,alterant) values(?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,url.getOurl());
        this.pstmt.setString(2,url.getMurl());
        pstmt.executeUpdate();
    }

    @Override
    public String findByUrl(String url) throws Exception {
        ResultSet rs = null;
        String result = "";
        String sql = "SELECT quondam FROM url where alterant=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,url);
        rs = pstmt.executeQuery();
        while (rs.next()){
            result=rs.getString(1);
        }
        return result;
    }

}
