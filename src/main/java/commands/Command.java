package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by edik2 on 21.05.2018.
 */
public interface Command {

    void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}
