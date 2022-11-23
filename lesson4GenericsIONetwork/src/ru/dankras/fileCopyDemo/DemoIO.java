package ru.dankras.fileCopyDemo;

import java.io.*;

public class DemoIO {
    private static volatile double readBites;
    private static volatile double sizeBites;

    public static void main(String[] args) {
        System.out.println("current dir: " + System.getProperty("user.dir"));
        var t1 = System.currentTimeMillis();
        try {
            bufferedCopyFile("gradle.pdf", 1000);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        var t2 = System.currentTimeMillis();
        System.out.println("Для буфера размером " + "1000 время = " + (t2 - t1));

        t1 = System.currentTimeMillis();
        try {
            copyFile("gradle.pdf");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        t2 = System.currentTimeMillis();
        System.out.println("Время копирования без буфера " + (t2 - t1));

    }

    private static void bufferedCopyFile(String textFile, int size) throws IOException {
        readBites = 0;
        System.out.println("Копирование с помощью буфера");
        var file = new File(textFile);
        sizeBites = file.length();
        Thread thread = getCopyStatusThread();
        thread.start();
        try (var bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
             var bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(textFile + "_copy.pdf"))) {
            var buffer = new byte[2];
            while ((size = bufferedInputStream.read(buffer, 0, buffer.length)) > 0) {
                readBites += size;
                bufferedOutputStream.write(buffer, 0, size);
            }

        }
        thread.interrupt();

    }

    private static Thread getCopyStatusThread() {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Процент копирования - " + (readBites / sizeBites) * 100);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        return thread;
    }

    private static void copyFile(String textFile) throws IOException {
        readBites = 0;
        System.out.println("Копирование без буфера");
        var file = new File(textFile);
        sizeBites = file.length();
        Thread thread = getCopyStatusThread();
        thread.start();
        try (var inputStream = new FileInputStream(file);
             var outputStream = new FileOutputStream(textFile + "_copy.pdf")) {
            int readBite = -1;
            while ((readBite = inputStream.read()) != -1) {
                readBites += 1;
                outputStream.write(readBite);
            }

        }
        thread.interrupt();
    }


}
