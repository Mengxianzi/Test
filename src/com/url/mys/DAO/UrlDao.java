package com.url.mys.DAO;

import com.url.mys.Entiy.Url;
import java.util.Set;

public interface UrlDao {
    /**
     * 增加短链接方法
     * @param url Url实体类
     * @return true/false
     * @throws Exception
     */
    public void doCreate(Url url)throws Exception;
    /**
     * 查询短链接方法
     * @return
     * @throws Exception
     */
    public String findByUrl(String url)throws Exception;
}
