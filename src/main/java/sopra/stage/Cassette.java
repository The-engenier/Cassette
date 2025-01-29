package sopra.stage;
import java.io.File;
import java.util.*;


public class Cassette {
    //the data and table ARRAY LIST
     ArrayList<Integer> data = new ArrayList<>();
     ArrayList<Integer> table = new ArrayList<>();

    int test;

    // Cassette data will be printed
    public Cassette(){
        readCassette();        readCassette();

        printCassetteData();
    }
    private void readCassette() {
        File file = new File("/home/scooby/Documents/cassette/Cassette/src/main/resources/cassette.txt");
        String line = null;
        // line 23 to 26 will get all the data from cassette.txt
        try (Scanner allofme = new Scanner(file)) {
            while (allofme.hasNextLine()) {
                line = allofme.nextLine();
                String sstring = "";
                int count = 0;
                // will count the lenght of the every line
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ',') {
                        count++;
                    }
                }
                // will remove every "," in the          data so it can get in the list
                for (int i = 0; i < count; i++) {
                    sstring = line.split(",")[i];
                    if (data.size() < 800){
                        data.add(Integer.valueOf(sstring));
                    }else{
                        table.add(Integer.valueOf(sstring));
                    }
                }
            }
        } catch (Exception e) { // WILL BRICK EVERYTHING IF REMOVED
            System.out.println(e.getMessage());
        }
    }
    
    public void printCassetteData()  {
        printIdAndTaille();
        List<String> decodedList = decode();
        for (int i = 0; i < decodedList.size(); i++) {

           // System.out.println(decodedList.subList(0,11));
            decodedList.subList(11, 11+4);
        }
    }

    private Map<Integer,Integer> printIdAndTaille() {
        Map<Integer, Integer> adressCriteria = new HashMap<>();


        int id = -1;
        int characterCount = -1;
        int changeid = 0;

        for (int i = 0; i < table.size(); i++) {
            if (id == 0 || characterCount == 0) {
                break;
            }
            if (i % 2 == 0) {
                id = table.get(i);
                //System.out.println("id : "+ id);
            } else {
                characterCount = table.get(i);
                //System.out.println("taille : "+characterCount);
            }
            adressCriteria.put(id, characterCount);
        }
        System.out.println(adressCriteria);
        return adressCriteria;
    }

    private List<String> decode(){
        ArrayList<String> decodedChars = new ArrayList<>();
        for (Integer num : data) {
            if(num != 0){
                char ch = (char) num.intValue();// Convert Integer to char
                decodedChars.add(String.valueOf(ch));
            }
        }


        return decodedChars;

        }



}