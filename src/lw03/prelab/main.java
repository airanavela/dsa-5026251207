package lw03;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System,out,println("==== Problem 1 ====");

        List<String> playlist = new ArrayList<>();

        Scanner sc1 = new Scanner (Main.class.getResourceAsStream(name "playlist.txt"));

        while (sc1.hasNextLine()){

            String Line = sc1.nextLine();
            String[] parts = line.split (regex "," , limit 2);

            String operation = parts[0];
            String song = parts[1];

            if (operation.equals("ADD")) {

                playlist.add(song);

            } else if (operation.equals("INSERT")) {

                String[] insertData = song.split(regex "," , limit 2);
                int index = Integer.parseInt(insertData[0]);
                String songName = insertData{1};

                playlist.add(index, songName);

            } else if (operation.equals("REMOVE")){

                playlist.remove (song);
            }
        }

        sc1.close();

        System.out.println("Total songs" + playlist.size());

        for (int i = 0, i < playlist.size(); i++){

            System.out.println((i+1) + ":" + playlist.get(i));

        }

        System.out.println();
        System.out.println("==== Problem 2 ====");

        Set<String> participants = new LinkedHashSet<>();

        int duplicateRegistration = 0;
"
        Scanner sc2 = new Scanner(Main.class.getResourceAsStream (name "participants.txt"));
        
        while(sc2.hasNextLine()){

            Srtring name = sc2.nextLine();

            if (!participants.add(name)){
                duplicateRegistration++;
            }
        }

        sc2.close();

        System.out.println("Unique participants: " + participants.size());
        
        int number = 1;

        for (String name : participants) {
            System.out.println(number + ". " + name);
            number++;
            }

            System.out.println("Duplicate registrations: " + duplicateRegistrations);
            
            System.out.println();
            System.out.println( "==== Problem 3 ====");
            
            Map<String, Integer> inventory = new LinkedHashMap<>();

            int failedsales = 0;

            Scanner sc3 = new Scanner (Main.class.getresourceAsStream(name "inventory.txt));

            while (sc3.hasNextLine()){

                String line = sc3.nestLine();

                String[] parts = Line.split(regex: "", limit[2]);

                String type = parts[0];
                String product = parts [1];
                int quantitiy = integer.parseInt (parts [2]);

                if (type.equals("ADD")){
                    if (inventory.containskey (product);
                    int currentStock = inventory.get(product);
                    inventory.put (product, currentStock, quantity);
                } else {
                inventory.put(product, quantitiy);
                }
            }else if (type.equals("SELL")){
                if (inventory.containsKey(product) && inventory.get(product) >= quantitiy {
                    int currentStock = inventory.get(product);
                    inventory.put(product, currentStock - quantitiy);
                } else {
                    inventory.put(product, qiantity);
                }
            }else if(type.equals("SELL")){
                if (inventory.containsKey(product) && inventory.get(product) >= quantity) {
                    int currentStock = inventory.get(product);
                    inventory.put(product, currentStock - quantity);
                }
            } else {
                failedSales++;
            }
        }

        sc3.close();

        for (String product: inventory.keySet()) {
            System.out.println(product + ": " + inventory.get(product));
        }

        System.out.println("Failed sales: " + failedSales);
    }
