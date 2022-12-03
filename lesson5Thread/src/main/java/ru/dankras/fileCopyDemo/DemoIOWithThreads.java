package ru.dankras.fileCopyDemo;

import java.io.*;
import java.util.Scanner;

public class DemoIOWithThreads {
    private static volatile double readBites;
    private static volatile double sizeBites;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("current dir: " + System.getProperty("user.dir"));
        DemoIOWithThreads demoIO2 = new DemoIOWithThreads();
        Thread thread = new Thread(() -> {
            try {
                demoIO2.copyFile("Лекция1-Градл.mp4");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
        Thread threadStatus = getCopyStatusThread();
        threadStatus.start();
        Scanner scanner = new Scanner(System.in);
        var command = scanner.nextLine();
        if (command.equals("")) {
            thread.interrupt();
            threadStatus.interrupt();
        }
        thread.join();
        threadStatus.join();


    }


    private static Thread getCopyStatusThread() {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Процент копирования - " + (readBites / sizeBites) * 100);
                } catch (InterruptedException ex) {
                    System.out.println("Процент копирования - " + (readBites / sizeBites) * 100);
                    Thread.currentThread().interrupt();
                }
            }
        });
        return thread;
    }

    private void copyFile(String textFile) throws IOException {
        readBites = 0;
        System.out.println("Копирование без буфера");
        var file = new File(textFile);
        sizeBites = file.length();
        InputStream inputStream=null;
        OutputStream outputStream=null;
        try{
            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream(textFile + "_copy.pdf");
            int readBite = -1;
            while ((readBite = inputStream.read()) != -1 && !Thread.currentThread().isInterrupted()) {
                readBites += 1;
                outputStream.write(readBite);
            }
            System.out.println("The End");
        }catch (IOException exception){

        }finally {
            inputStream.close();
            outputStream.close();
        }

    }


}
