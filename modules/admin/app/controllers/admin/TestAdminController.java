package controllers.admin;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;
import views.html.*;
import play.mvc.Controller;
import play.mvc.Result;

public class TestAdminController extends Controller {

	
		public static Result testAdmin() {	
			System.out.println("admin controller........");
			JsonNode json = request().body().asJson();
			System.out.println("I am..."+json.toString());
			System.out.println("I am in admin controller..."+json.toString());
			return ok("Hello");
		}
}
