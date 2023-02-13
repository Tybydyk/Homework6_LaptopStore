package Java_Homeworks.Homework6_2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Task6 {

    public static void main(String[] args) throws MalformedURLException, IOException {

        Integer ch = 999;
        Integer c = 0;
        String chStr = "";

        Laptop l1 = new Laptop("AMD", 15.60, 4, 512, "Windows");
        Laptop l2 = new Laptop("Intel", 14, 8, 512, "Linux");
        Laptop l3 = new Laptop("AMD", 13.0, 16, 1024, "Windows");
        Laptop l4 = new Laptop("Intel", 15.60, 4, 256, "Free DOS");
        Laptop l5 = new Laptop("Intel", 13, 8, 512, "Linux");
        Laptop l6 = new Laptop("AMD", 15.60, 16, 1024, "Windows");
        Laptop l7 = new Laptop("Intel", 14, 4, 128, "Linux");
        Laptop l8 = new Laptop("AMD", 15.60, 4, 128, "Linux");
        Laptop l9 = new Laptop("Intel", 13, 8, 512, "Linux");
        Laptop l10 = new Laptop("Intel", 13, 16, 512, "Windows");
        Laptop l11 = new Laptop("AMD", 15.60, 8, 1024, "Free DOS");
        Laptop l12 = new Laptop("Intel", 14, 4, 128, "Windows");
        Laptop l13 = new Laptop("AMD", 13.0, 8, 256, "Free DOS");
        Laptop l14 = new Laptop("Intel", 15.60, 16, 512, "Windows");
        Laptop l15 = new Laptop("Intel", 13, 4, 1024, "Linux");
        Laptop l16 = new Laptop("AMD", 15.60, 8, 512, "Windows");
        Laptop l17 = new Laptop("Intel", 14, 16, 256, "Linux");
        Laptop l18 = new Laptop("AMD", 15.60, 8, 256, "Free DOS");
        Laptop l19 = new Laptop("Intel", 13, 4, 128, "Linux");
        Laptop l20 = new Laptop("Intel", 13, 8, 1024, "Linux");
        Laptop l22 = new Laptop("Intel", 14, 16, 256, "Linux");
        System.out.println(l22.id);


    HashSet<Laptop> notes = new HashSet<Laptop>(Arrays.asList(l1, l2, l3, l4, l5, 
    l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20));
    HashSet<Laptop> selectedNotes1 = new HashSet<Laptop>();
    HashSet<Laptop> selectedNotes2 = new HashSet<Laptop>();
    
    HashMap<Integer,String> mapForCh = new HashMap<Integer,String>();           //Filter
    mapForCh.put(11, "13"); mapForCh.put(12, "14"); mapForCh.put(13, "15.6");
    mapForCh.put(21, "Intel"); mapForCh.put(22, "AMD");
    mapForCh.put(31, "4"); mapForCh.put(32, "8");  mapForCh.put(33, "16");
    mapForCh.put(41, "128"); mapForCh.put(42, "256"); mapForCh.put(43, "512"); mapForCh.put(44, "1024");
    mapForCh.put(51, "Windows"); mapForCh.put(52, "Linux"); mapForCh.put(53, "Free DOS");
    

    System.out.println("\n\n\tWelcome to laptop shop\n");
    setToPrint(notes);
    Scanner inpScan = new Scanner(System.in);

    Integer flagSearch = 1;
    while(flagSearch == 1){
        while (ch != 0 && ch != 1 && ch != 2 && ch != 3){ 
            System.out.println("\n\n\tLet's try to find a model for you\nEnter screen diagonal size in inch");
            System.out.println("press '1' -> 13inch,\npress '2' -> 14inch,\npress '3' -> 15,6inch,\nor '0' in order to skip this step : ");
            ch = inpScan.nextInt();
            String tmp = inpScan.nextLine(); // does not work without this line
        }
        if(ch == 0) flagSearch = 2;
                else{
                    for( Laptop item: notes){
                        if (Double.parseDouble(mapForCh.get(ch+10)) == item.scrn){
                            selectedNotes1.add(item);   // creating a Set with a choice of screen diagonal
                            c++;
                        }
                    }
                    System.out.printf("\t%d variants found.\n",c);
                    System.out.println("\tPrint the results('p')\n\tor continue the search'c'? ('c'/'p'):");
                    chStr = inpScan.nextLine();
                    if (chStr.equalsIgnoreCase("p")){
                        setToPrint(selectedNotes1);
                        flagSearch = 2;
                    }      
                    else if (chStr.equalsIgnoreCase("c")){
                        flagSearch = 2;
                    }
                    else {
                        flagSearch = 10;
                    }
                }
        
        if (flagSearch == 2){   //processor
            ch = 999; c = 0;
            while (ch != 0 && ch != 1 && ch != 2){
                System.out.println("\n  Choosing a processor:");
                System.out.println("press '1' -> Intel,\npress '2' -> AMD,\nor '0' in order to skip this step : ");
                ch = inpScan.nextInt();
                String tmp = inpScan.nextLine(); // does not work without this line
            }
            if(ch == 0) flagSearch = 3;
                else{
                    for( Laptop item: selectedNotes1){
                        if (mapForCh.get(ch+20).equals(item.proc)){
                            selectedNotes2.add(item);    // add to the Set a choice of processor
                            c++;
                        }
                    }
                    System.out.printf("\t%d variants found.\n",c);
                    if (c == 0){
                        flagSearch = restartOrQuite();
                        System.out.println(flagSearch);
                    } 
                    else {
                        System.out.println("\tPrint the results('p')\n\tor continue the search'c'\n\tRepeat the search again'r'? ('c'/'p'/'r'):");
                        chStr = inpScan.nextLine();
                        if (chStr.equalsIgnoreCase("c")){
                            selectedNotes1 = (HashSet<Laptop>) selectedNotes2.clone();
                            selectedNotes2.clear();
                            flagSearch = 3;
                        }      
                        else if (chStr.equalsIgnoreCase("p")){
                            selectedNotes1 = (HashSet<Laptop>) selectedNotes2.clone();
                            setToPrint(selectedNotes1);
                            selectedNotes2.clear();
                            flagSearch = 3;
                        }
                        else {
                            flagSearch = 10;
                        }
                    }
                }
            
            if (flagSearch == 3){   // RAM
                ch = 999; c = 0;
                while (ch != 0 && ch != 1 && ch != 2 && ch != 3){
                    System.out.println("\n  Choosing a RAM size:");
                    System.out.println("press '1' -> 4GB,\npress '2' -> 8GB,\npress '3' -> 16GB,\nor '0' in order to skip this step : ");
                    ch = inpScan.nextInt();
                    String tmp = inpScan.nextLine(); // does not work without this line
                }
                if(ch == 0) flagSearch = 4;
                else{
                    for( Laptop item: selectedNotes1){
                        if (Integer.parseInt(mapForCh.get(ch+30)) == item.mem){
                            selectedNotes2.add(item);    // add to the Set a choice of RAM
                            c++;
                        }
                    }
                    System.out.printf("\t%d variants found.\n",c);
                    if (c == 0) flagSearch = restartOrQuite();
                    else {
                        System.out.println("\tPrint the results'p'\n\tor continue the search'c'\n\tRepeat the search again'r'? ('c'/'p'/'r'):");
                    
                        chStr = inpScan.nextLine();
                        if (chStr.equalsIgnoreCase("c")){
                            selectedNotes1 = (HashSet<Laptop>) selectedNotes2.clone();
                            selectedNotes2.clear();
                            flagSearch = 4;
                        }      
                        else if (chStr.equalsIgnoreCase("p")){
                            selectedNotes1 = (HashSet<Laptop>) selectedNotes2.clone();
                            setToPrint(selectedNotes1);
                            selectedNotes2.clear();
                            flagSearch = 4;
                        }
                        else {
                            flagSearch = 10;
                        }
                    }
                }
                
                if (flagSearch == 4){   // HDD
                    ch = 999; c = 0;
                while (ch != 0 && ch != 1 && ch != 2 && ch != 3 && ch != 4){
                    System.out.println("\n  Choosing a HDD or SSD size:");
                    System.out.println("press '1' -> 128GB,\npress '2' -> 256GB,\npress '3' -> 512GB,\npress '4' -> 1024GB,\nor '0' in order to skip this step : ");
                    ch = inpScan.nextInt();
                    String tmp = inpScan.nextLine(); // does not work without this line
                }
                if(ch == 0) flagSearch = 5;
                else{
                    for( Laptop item: selectedNotes1){
                        if (Integer.parseInt(mapForCh.get(ch+40)) == item.stor){
                            selectedNotes2.add(item);    // add to the Set a choice of HDD
                            c++;
                        }
                    }
                    System.out.printf("\t%d variants found.\n",c);
                    if (c == 0) flagSearch = restartOrQuite();
                    else {
                        System.out.println("\tPrint the results'p'\n\tor continue the search'c'\n\tRepeat the search again'r'? ('c'/'p'/'r'):");
                    
                        chStr = inpScan.nextLine();
                        if (chStr.equalsIgnoreCase("c")){
                            selectedNotes1 = (HashSet<Laptop>) selectedNotes2.clone();
                            selectedNotes2.clear();
                            flagSearch = 5;
                        }      
                        else if (chStr.equalsIgnoreCase("p")){
                            selectedNotes1 = (HashSet<Laptop>) selectedNotes2.clone();
                            setToPrint(selectedNotes1);
                            selectedNotes2.clear();
                            flagSearch = 5;
                        }
                        else {
                            flagSearch = 10;
                        }
                    }
                }
                   
                    if (flagSearch == 5){   // OS
                        ch = 999; c = 0;
                    while (ch != 0 && ch != 1 && ch != 2 && ch != 3){
                        System.out.println("\n  Choosing an operating system:");
                        System.out.println("press '1' -> Windows,\npress '2' -> Linux,\npress '3' -> Free DOS,\nor '0' in order to skip this step : ");
                        ch = inpScan.nextInt();
                        String tmp = inpScan.nextLine(); // does not work without this line
                    }
                    if (ch == 0) {
                        System.out.println("\nThis was the last criterion of choice.\nYou have chosen :\n");
                        setToPrint(selectedNotes1);
                        flagSearch = restartOrQuite();
                    }
                    else{
                        for( Laptop item: selectedNotes1){
                            if (mapForCh.get(ch+50).equals(item.os)){
                                selectedNotes2.add(item);    // add to the Set a choice of OS
                                c++;
                            }
                        }
                        System.out.printf("\t%d variants found.\n",c);
                        setToPrint(selectedNotes2);
                        flagSearch = restartOrQuite();
                    }
  
                    }
                }
            }
        }   
            if (flagSearch == 10){  //Restart search
                selectedNotes1.clear();
                selectedNotes2.clear();
                ch = 99;
                chStr = "";
                flagSearch = 1;
            }
            if (flagSearch == 11){  // Quit
                inpScan.close();
                System.out.println("\nThe store is closed.\nYou were left without a laptop\n");
                }
    }
    }

    public static void setToPrint(HashSet<Laptop> notes) {
        for(Laptop item: notes){
            System.out.printf("id:%d, %s %.1f inch, %dGB, %dGB, %s\n", item.id, item.proc, item.scrn, item.mem, item.stor, item.os); 
        }
    }

    public static Integer restartOrQuite() {    //return flagSearch
        System.out.println("\tRepeat the search'r'' or exit'e'? ('r'/'e'):");
        Scanner inpScan2 = new Scanner(System.in);
        String chStr = inpScan2.nextLine();
        inpScan2.close();
        if (chStr.equalsIgnoreCase("r")) return 10;
        else if (chStr.equalsIgnoreCase("e")) return 11;
        else return 11;      
    }
}