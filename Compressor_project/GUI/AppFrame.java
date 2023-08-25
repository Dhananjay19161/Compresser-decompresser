package GUI;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener{
    JButton compressButton,decompressButton;
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1 = new JPanel();
        
        compressButton=new JButton("Select File to Compress");
       
        compressButton.addActionListener(this);
        panel1.add(compressButton);
        

        decompressButton=new JButton("Select File to Decompress");
    
        decompressButton.addActionListener(this);
        panel1.add(decompressButton);
        this.add(panel1);
    
        this.setSize(1000, 500);
        this.getContentPane().setBackground(Color.BLUE);
        panel1.setBackground((Color.BLUE));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser filechosed=new JFileChooser();
            int response=filechosed.showSaveDialog(this.getParent());
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechosed.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    compressor.method(file);
                } catch (Exception ee) {
                  
                    JOptionPane.showMessageDialog(null,ee.getMessage());
                }
            }

        }
        if(e.getSource()==decompressButton){
            JFileChooser filechosed=new JFileChooser();
            int response=filechosed.showSaveDialog(this.getParent());
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechosed.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    decompressor.method(file);
                } catch (Exception eee) {
                  
                    JOptionPane.showMessageDialog(null,eee.getMessage());
                }
            }

        }
    }
    public static void main(String[] args) {
      new AppFrame();
        
    }
    
}
