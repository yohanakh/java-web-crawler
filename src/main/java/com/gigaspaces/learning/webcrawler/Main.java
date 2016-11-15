package com.gigaspaces.learning.webcrawler;

/**
 * @author Yohana Khoury
 * @since 12.1
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 2) {
            System.err.println("Invalid syntax: <baseUrl> <numOfThreads>");
            System.exit(1);
        }
        String baseUrl = args[0];
        int numOfThreads = Integer.parseInt(args[1]);
        App app = new App(baseUrl, numOfThreads);
        System.out.println("Using " + numOfThreads + " threads to process " + baseUrl);
        long start = System.currentTimeMillis();
        app.start();
        long totalTimeInMS = System.currentTimeMillis() - start;
        app.shutdown();
        System.out.println(app.getProcessedLinks() + " links processed in " + (double)totalTimeInMS/1000 + "s");
    }

}