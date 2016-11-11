package edu.sjsu.akatsuki;

import org.restlet.representation.*;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import java.io.IOException;

public class AkatsukiResource extends ServerResource {

 @Post
 public String postMessage(Representation entity) {
  System.out.println("Came here in the post message");
  try {
   System.out.println(entity.getText());
  } catch (IOException e) {
   e.printStackTrace();
  }
  return "1";
 }

}