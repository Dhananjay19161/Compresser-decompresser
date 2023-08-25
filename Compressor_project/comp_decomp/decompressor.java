package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;



public class decompressor {
    public static void method(File file) throws IOException{
        String file_directory=file.getParent();
        FileInputStream ip=new FileInputStream(file);
        GZIPInputStream gip=new GZIPInputStream(ip);
        FileOutputStream op=new FileOutputStream(file_directory+"/decompressed");
        // GZIPOutputStream gop=new GZIPOutputStream(op);
        byte[] buffer=new byte[1024];
        int len;
        while((len=gip.read(buffer))!=-1){
            op.write(buffer,0,len);
        }
        op.close();
        ip.close();
        gip.close();

    }
    public static void main(String[] args) throws IOException {
        File path=new File("C:/Users/dhana/Downloads/compressed.gz");
        method(path);
    }
}
