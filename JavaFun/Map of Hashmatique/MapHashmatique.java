import java.util.HashMap;
import java.util.Set;
public class MapHashmatique{
    public static void main(String [] args){
        createHashMap();
         
    }

    public static void createHashMap(){
        HashMap<String, String> songMap = new HashMap<String, String>();
        songMap.put("song1 title", "song1");
        songMap.put("song2 title", "song2");
        songMap.put("song3 title", "song3");
        songMap.put("song4 title", "song4");

        String song2Tilte = songMap.get("song2 title");
        Set<String> keys = songMap.keySet();
        for(String key : keys) {
            System.out.println(key+": "+songMap.get(key));
        }


    }

}