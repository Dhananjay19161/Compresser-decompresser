package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;



public class compressor {
    public static void method(File file) throws IOException{
        String file_directory=file.getParent();
        FileInputStream ip=new FileInputStream(file);
        FileOutputStream op=new FileOutputStream(file_directory+"/compressed.gz");
        GZIPOutputStream gop=new GZIPOutputStream(op);
        byte[] buffer=new byte[1024];
        int len;
        while((len=ip.read(buffer))!=-1){
            gop.write(buffer,0,len);
        }
        gop.close();
        ip.close();
        op.close();

    }
    public static void main(String[] args) throws IOException {
        File path=new File("C:/Users/dhana/Downloads/cpu-z_2.06-en");
        method(path);
    }
}
