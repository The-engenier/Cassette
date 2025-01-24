package sopra.stage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cassette {

    //the data and table ARRAY LIST
     ArrayList<Integer> data = new ArrayList<>();
     ArrayList<Integer> table = new ArrayList<>();


    // Cassette data will be printed
    public Cassette(){
        readCassette();
    }

    private  void readCassette() {
        File file = new File("cassette.txt");
        String line = null;
        // line 23 to 26 will get all the data from cassette.txt
        try (Scanner allofme = new Scanner(file)) {
            while (allofme.hasNextLine()) {
                line = allofme.nextLine();
                System.out.println(line);

                String sstring = "";
                int count = 0;

                // will count the lenght of the every line
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ',') {
                        count++;
                    }
                }
                // will remove every "," in the data so it can get in the list
                for (int i = 0; i < count; i++) {
                    sstring = line.split(",")[i];
                    data.add(Integer.parseInt(sstring));
                    if (data.size() < 800){
                        data.add(Integer.valueOf(sstring));
                        Integer.valueOf(sstring);
                    }

                }
            }
        } catch (Exception e) { // DO NOT REMOVE
            System.out.println(e.getMessage());

        }



        System.out.print("data: ");
        System.out.println(data);
        System.out.println(data.size());
        System.out.print("table: ");
        System.out.println(table);
        System.out.println(table.size());
    }
    
    private void printCassetteData()  {

    }

}


    
    


