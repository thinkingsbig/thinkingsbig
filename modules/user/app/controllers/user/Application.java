package controllers.user;

import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    public static Result getPage() {
        return ok( "Return Json" );
    }

}
