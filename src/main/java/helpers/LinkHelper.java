package helpers;

public class LinkHelper {

    /**
     * Extract id of the game from game link
     * @param link link with the path to the game
     * @return id of the game
     */

    public int getIdFromLink(String link){
        return Integer.parseInt(link
                        .replaceAll("\\D+\\/","")
                        .replaceAll("\\D.*",""));
    }

}
