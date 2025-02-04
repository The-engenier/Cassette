package sopra.stage;

import java.io.*;
import java.util.*;

public class Cassette {
    //the data and table ARRAY LIST
    //louis.ballan@soprasteria.com
     private ArrayList<Integer> data = new ArrayList<>();
     private ArrayList<Integer> table = new ArrayList<>();


    // Cassette data will be printed
    public Cassette(){
        int id = -1;
        readCassette();
        /*
        verifierId(id);
        verofierID2(id);
        verifySpaceTable();
        verifySpaceData();*/
        verifyId();
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
        Map<Integer, Integer> dictionnary = getIdAndTaille();
        int fixer = 0;
        for (int key : dictionnary.keySet().stream().sorted().toList()) {
            int characterCount = dictionnary.get(key);
            System.out.print("info " + key + " " + characterCount + " | ");

            for (int i = 0; i < characterCount; i++) {
                System.out.print(decode().get(fixer + i));
            }
            fixer += characterCount;
            System.out.println();
        }
        System.out.println(table);
    }

    private Map<Integer,Integer> getIdAndTaille() {
        Map<Integer, Integer> adressCriteria = new HashMap<>();
        int id = -1;
        int characterCount = -1;
        for (int i = 0; i < table.size(); i++) {
            if (i % 2 == 0) {
                id = table.get(i);
            } else {
                characterCount = table.get(i);
            }
            adressCriteria.put(id, characterCount);
        }
        adressCriteria.remove(0);
        // AAAAA
        //System.out.println(adressCriteria);

        return adressCriteria;
    }

    private List<String> decode() {
        ArrayList<String> decodedChars = new ArrayList<>();
        for (Integer num : data) {
            if (num != 0) {
                char ch = (char) num.intValue();// Convert Integer to char
                decodedChars.add(String.valueOf(ch));
            }
        }
        //THIS
        //System.out.println(decodedChars);
        return decodedChars;
    }
/**
    private boolean verifierId(int id){
        for(int i = 0; i < table.size(); i++){
            int c = table.get(i);
            if (c == id || id == 0){
                //System.out.println("error");
                return false;
            }
        }
        return true;
    }

    private void verofierID2(int id){
        for(int i = 0; i < table.size(); i++){
            int c = table.get(i);
            if (id > c ){
                System.out.println("error");
            }
        }
    }
    
    private boolean verifySpaceTable(){
        System.out.println("this is the table: ");
        for(int i = 0; i < table.size() -1; i++){
            if (table.get(i) == 0 && table.get(i + 1) == 0) {
                return true;
            }
            //a supprimer
            Integer a = table.get(i);
            if (a == 0){
                int b = table.indexOf(i);
                int c = table.size() - b;
                //savoir si il ya 2 0 accoté deux
                for (int j = 0; j < c; j++) {
                    if (j < c - 1 && table.get(b + j) == 0 && table.get(b + j + 1) == 0) {
                        System.out.println("0 next to each other");
                        return true;
                    }
                }
                return true;
            }
            //a supprimer
        }
        return false;
    }

    private boolean verifySpaceData(){
        System.out.println("this is the data: ");
        for (Integer datum : data) {
            if (datum == 0) {
                System.out.println("no Space");
                return true;
            }else{
                System.out.println("Space");
                return false;
            }
        }
        return false;
    }

    public void addToCassette(int id){
        if (!verifierId(id)){
            if (!verifySpaceTable()){
                table.add(id);
                System.out.println("added");
                System.out.println(table);
            }else{
                System.out.println("not added");
            }
        }else {
            System.out.println("not added");
        }
    }

    public void addData(String info) {
        int asciiCode = 0;
        if (!verifySpaceData()) {
        }asciiCode = (int) info.charAt(0);
        data.get(asciiCode);
        System.out.println(asciiCode);
        System.out.println("added");
        System.out.println(data);
    }
*/
    private boolean verifyId() {
        Map<Integer, Integer> idAndTailleMap = getIdAndTaille();
        Set<Integer> keys = idAndTailleMap.keySet();
        System.out.println(keys);

        return keys.contains(Main.inputId);
    }

    public void remover() {
        if (verifyId() == true) {
            int index = table.indexOf(Main.inputId);
            if (index != -1 && index + 1 < table.size()) {
                int secondNumber = table.get(index + 1);
                table.remove(index); // Remove inputId
                table.remove(index); // Remove related second number
                if (secondNumber <= data.size()) {
                    data.subList(0, secondNumber).clear();
                }
            }
        } else {
            System.out.println("ID doesn't exist");
        }
    }

}