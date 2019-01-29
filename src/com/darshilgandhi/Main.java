package com.darshilgandhi;

public class Main {

    public static void main(String[] args) {
        SerializeDeserialize obj = new SerializeDeserialize();
        //write to file
        obj.writeToFile();
        //reading from file
        obj.readFromFile();
    }
}
