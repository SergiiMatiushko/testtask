package com.coingaming.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Search {

    private int count;

    private LinkedHashMap [] arrayLinkedHashMap;
    private PropertiesFactory propertiesFactory;


    public Search(String searchedText){
        propertiesFactory = new PropertiesFactory();
        searchText(searchedText, openFile(propertiesFactory.getPropertyPathToLog()));
    }

    private BufferedReader openFile (String path){
        BufferedReader bufferedReader=null;
        try {
            System.out.println("---====PATH===----"+path);
            File file = new File(path);
            bufferedReader =  new BufferedReader(new FileReader(file));
        }catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }

    private void searchText (String searchingText, BufferedReader bufferedReader ){
        try{
            int lineNumber=0;
            String line;
            //LinkedList<LinkedHashMap> linkedList=null;
            while((line=bufferedReader.readLine())!=null){
                System.out.println("while((line=bufferedReader.readLine())!=null){");
                System.out.println("line = "+line);
                System.out.println("searchingText = "+ searchingText);
                lineNumber++;
                if(line.contains(searchingText)){
                    System.out.println("---!!!__TRUE___!!!---- = "+ searchingText);
                    count++;
                    LinkedHashMap <String,Object> linkedHashMap = new LinkedHashMap<String,Object>();
                    linkedHashMap.put("linenumber",lineNumber);
                    linkedHashMap.put("value",line);

                    if(arrayLinkedHashMap!=null){
                        arrayLinkedHashMap = Arrays.copyOf(arrayLinkedHashMap, arrayLinkedHashMap.length+1);
                        arrayLinkedHashMap [arrayLinkedHashMap.length-1] = linkedHashMap;
                    }else {
                        arrayLinkedHashMap = new LinkedHashMap[1];
                        arrayLinkedHashMap[0] = linkedHashMap;
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public int getCount() {
        return count;
    }

    public LinkedHashMap[] getArrayLinkedHashMap() {
        return arrayLinkedHashMap;
    }
}
