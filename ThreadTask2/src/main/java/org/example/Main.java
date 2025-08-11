package org.example;

import java.util.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        int[][] A = matrixReaderFile.readMatrix("A.txt");
        int[][] B = matrixReaderFile.readMatrix("B.txt");

        int N = A.length; //Number or row in A
        int M = A[0].length; //no .of column in A (And no. of row in B)
        int P = B[0].length; //no. column in B
        int[][] C = new int[N][P];


        // no.of rows in B = no. of column in A = M
        if (B.length != M) {
            System.out.println("Matrix dimensions incompatible for multiplication.");
            return;
        }


        // Create a thread pool and submit multiplication tasks (one per row)
        ExecutorService executor = Executors.newFixedThreadPool(N);
        // Submit one task per row of C
        for (int i = 0; i < N; i++) {
            executor.submit(new matrixMultiplication(A,B,C,i));// Pass row index 'i' so the thread knows which row of C to compute
        }
        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS);



        System.out.println("Matrix A = ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(A[i][j]  + " ");
            }
            System.out.println();
        }


        System.out.println("Matrix B = ");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < P; j++) {
                System.out.print(B[i][j]  + " ");
            }
            System.out.println();
        }


        System.out.println("Matrix C = AxB =");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < P; j++) {
                System.out.print(C[i][j] + " ");
            }
                System.out.println();
        }

        System.out.println("Matrix multiplication finished." );




    }

    // Reads a matrix from a text file
    static class matrixReaderFile {
        static int[][] readMatrix(String filename) {
            List<int[]> rows = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        // Split line by spaces and parse integers
                        String[] parts = line.trim().split("\\s+");
                        int[] row = new int[parts.length];
                        for (int i = 0; i < parts.length; i++) {
                            row[i] = Integer.parseInt(parts[i]);
                        }
                        rows.add(row);
                    }

                }
            } catch (IOException e) {
                System.out.println("Error reading file : " + filename + ":" + e.getMessage());
            }
            return rows.toArray(new int[0][]);
        }
    }
        static class matrixMultiplication implements Runnable {
        private final int[][] A;
        private final int[][] B;
        private final int[][] C;
        private final  int row; //The specific row index of matrix C that this thread will compute.



        public matrixMultiplication(int[][] A, int[][] B , int[][] C , int row) {
            this.A = A;
            this.B = B;
            this.C = C;
            this.row = row;
        }


         /**
          * Runs this operation.
          */
         @Override
         public void run() {
             int M = A[0].length; // Number of columns in A (and rows in B)
             int P = B[0].length; // Number of columns in B

             for (int j = 0; j < P; j++) { // For each column of B (and C)
                 for (int k = 0; k < M; k++) { // For each element in the row of A and column of B
                     C[row][j] += A[row][k] * B[k][j]; // Perform multiplication and addition
                 }

            }

         }
    }
}


