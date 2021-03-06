
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;

import common.JsonTransformer;
import core.CoffeeBLL;

public class Main {

  public static void main(String[] args) {

	String porta = System.getenv("PORT");
	
	if (porta != null)	  
		port(Integer.valueOf(porta));
	else
		port(8080);
	
    staticFileLocation("/public");
    
    get("/coffee", "application/json", (request, response) ->{
    	return new CoffeeBLL().getISBM();
    	}, new JsonTransformer());
    
  get("/", (req, res) ->  new CoffeeBLL().getISBM());
    
    
    
    
    //get("/hello", (req, res) -> "Hello World");

    //get("/", (request, response) -> {
            //Map<String, Object> attributes = new HashMap<>();
            //attributes.put("message", "Hello World!");

            //return new ModelAndView(attributes, "index.ftl");
        //}, new FreeMarkerEngine());

    //get("/db", (req, res) -> {
      //Connection connection = null;
      //Map<String, Object> attributes = new HashMap<>();
      //try {
        //connection = DatabaseUrl.extract().getConnection();

        //Statement stmt = connection.createStatement();
        //stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        //stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        //ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        //ArrayList<String> output = new ArrayList<String>();
        //while (rs.next()) {
          //output.add( "Read from DB: " + rs.getTimestamp("tick"));
        //}

        //attributes.put("results", output);
        //return new ModelAndView(attributes, "db.ftl");
      //} catch (Exception e) {
        //attributes.put("message", "There was an error: " + e);
        //return new ModelAndView(attributes, "error.ftl");
      //} finally {
        //if (connection != null) try{connection.close();} catch(SQLException e){}
      //}
    //}, new FreeMarkerEngine());

  }

}
