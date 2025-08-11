package org.example;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {
    private static final List <String> allNames =Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);



        for(int i=0 ; i<5; i++) {
            final  int fileIndex = i ;
           executor.submit(new FileReaderTask(fileIndex + ".txt"));
           System.out.println("Submitted task for reading " + fileIndex + ".txt");
        }
        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS);

        // Sort and print all names
        Collections.sort(allNames);

        System.out.println("\nSorted Names from all files:");
        for (String name : allNames) {
            System.out.println(name);
        }

    }
    static class FileReaderTask implements Runnable{

        private final String fileName;

        public FileReaderTask(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            File file = new File(fileName);
            List<String> namesFromFiles = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null){
                    if(!line.trim().isEmpty()){
                        namesFromFiles.add(line.trim());

                    }
                }

                    // synchronize access for all shared data
                    synchronized (allNames) {
                        allNames.addAll(namesFromFiles);
                    }
                    System.out.println("Successfully reading  : " + namesFromFiles.size() + " names from file : " + namesFromFiles);


            } catch (IOException e) {
                System.out.println("Error reading file : " + fileName + ":" + e.getMessage()) ;
            }

        }
    }

}



