package com.darshilgandhi;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SerializeDeserialize {

    String line;
    List<String> lines = new LinkedList<String>();

    //writing contents of user input into a LinkedList and then to a file
    public void writeToFile() {
        Scanner scanner = new Scanner(System.in);
        Boolean quit = false;
        System.out.println("---Enter text to serialize. Type QUIT when done---");

        //while quit is not true, we will keep reading lines of Strings from the Scanner utility and adding it to a LinkedList
        while (!quit) {
            line = scanner.nextLine();
            //if user enters quit, that means we stop adding strings and break out of the while loop
            if (line.equalsIgnoreCase("quit")) {
                System.out.println("---User input complete. Proceeding to add write to File---");
                quit = true;
                line = "";
            }
            //function to add each line
            this.lines.add(line);
        }

        System.out.println("writing entered data to a file");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("serialize_program_output.txt"))) {
            for (String a : this.lines) {
                    bufferedWriter.write(a + "\n");
            }
            System.out.println("---Finished adding all data to file---");
        } catch (Exception e) {
                System.out.println("Unable to write to file due to error " + e.getMessage());
            }
    }



    public void readFromFile(){
        System.out.println("---Reading names of countries from file---");
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("deserialize_program_input.txt")))){
            while (scanner.hasNext()){
                String a = scanner.nextLine();
                lines.add(a);
            }
            //
            if(lines!=null){
                System.out.println("Number of countries added: "+lines.size()+". Names of countries are below: ");
                for (String b:lines){
                    System.out.println(b);
                }
            }

        } catch (Exception e){
            System.out.println("Unable to read from file due to error "+e.getMessage());
        }
    }


    //print contents of the lines LinkedList
    public void printLines(){
        System.out.println("Printing contents of LinkedList");
        for(String a : this.lines)
            System.out.println(a);
    }




}
