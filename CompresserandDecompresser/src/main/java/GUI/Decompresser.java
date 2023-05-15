/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
/**
 *
 * @author Shikha
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;


public class Decompresser {
    public static void method(File file) throws IOException{
        String filedirectory=file.getParent();
        FileInputStream fis=new FileInputStream(file);
        GZIPInputStream gzip=new GZIPInputStream(fis);
        FileOutputStream fos=new FileOutputStream(filedirectory+"/Decompressedfileone");
        
        byte[] buffer=new byte[1024];
        int len;
        
        while((len=gzip.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        
        gzip.close();
        fis.close();
        fos.close();
        
    }
    public static void main(String[] args) throws IOException{
        File path=new File("C:\\Users\\Admin\\Desktop\\comdecom\\Compressedfile.gz");
         method(path);
        
        
        
    }
}