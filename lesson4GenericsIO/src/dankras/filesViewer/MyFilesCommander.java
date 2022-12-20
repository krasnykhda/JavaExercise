package dankras.filesViewer;

import java.io.File;

public class MyFilesCommander {
    public static void viewFiles(File file){
      for (File currentFile:file.listFiles()){
          if(currentFile.isDirectory()){
              System.out.println(currentFile);
              viewFiles(currentFile);
          }else {
              System.out.println(currentFile);
          }
      }
    }
    public static void main(String[] args) {
        File file=new File(".");
        viewFiles(file);
    }
}
