import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.restlet.*;
import org.restlet.resource.*;
import org.json.JSONObject ;
import org.restlet.resource.*;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.data.* ;

/**
 * Write a description of class ClientRequestManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClientRequestManager extends Actor
{
    private static final String baseURL = "http://localhost:8080";
    
    public static String getRequestURL(String URI)
    {
        return baseURL + URI;
    }
    
    public static ClientResource getClient(String requestURL)
    {
        ClientResource client = new ClientResource(requestURL);
        return client;
    }
}
