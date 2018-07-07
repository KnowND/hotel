package commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by edik2 on 04.07.2018.
 */
public class CheckAdmin {

    public boolean checkAdmin(HttpServletRequest request){
        return request.getSession().getAttribute("admin")!=null;
    }

}
