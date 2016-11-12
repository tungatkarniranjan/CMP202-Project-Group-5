/**
 * Write a description of class MapSelector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;


public class MapSelector  
{
    private ArrayList<String> maps= new ArrayList<>();
    
    MapSelector(){
        maps.add("France");
        maps.add("Germany");
    }
    
    public MapScreen produceMap(int index){
        String mapName = maps.get(index);
        MapScreen mapScreen;
        System.out.println("I am selecting the map from the selector");
        System.out.println(index);
        if(mapName == "France"){
            mapScreen = new FranceMapScreen();
        }else if(mapName == "Germany"){
            mapScreen = new GermanyMapScreen();
        }else{
            mapScreen = null;
        }
        
        return mapScreen;
    
    }
    
    // Here add all other maps that needs to be part of the game.
    
    
    
}
