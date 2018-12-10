package com.hubbleadvance.utils.ideveloper.common.session;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.hubbleadvance.utils.ideveloper.domain.user.User;

public class OnlineUserManager implements HttpSessionListener {
    private static Map<String, OnlineUser> pool = new TreeMap<String, OnlineUser>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Long.valueOf(o1) > Long.valueOf(o2) ? 1 : -1;
        }
    });
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        User u = (User)se.getSession().getAttribute("user_info");
        if (u != null) {
            pool.remove(u.getId());
        }
    }
    
    public static List<OnlineUser> getOnlineUserList() {
        List<OnlineUser> result = null;
        if (pool.size() > 0) {
            result = new ArrayList<OnlineUser>(pool.size());
            for (Map.Entry<String, OnlineUser> entry : pool.entrySet()) {
                result.add(entry.getValue());
            } 
        }
        return result;
    }
    
    public static void addOnlineUser(OnlineUser u) {
        if (pool.containsKey(u.getId())) {
            OnlineUser ou = pool.get(u.getId());
            ou.setIp(u.getIp());
            pool.put(u.getId(), ou);
        } else {
            pool.put(u.getId(), u);
        }
    }
}
