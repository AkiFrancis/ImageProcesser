import javax.swing.*;
import java.awt.*;

public class Binary_Image_Panel extends JPanel {
    private Get_Image_Info info;
    Binary_Image_Panel(Get_Image_Info i){
        this.info=i;
    }
    public void paint(Graphics g) {
        int im_width = info.getIm_width();
        int im_height = info.getIm_height();
        for(int i=0;i<im_width;i++){
            for (int j =0;j<im_height;j++){
                int red = info.getIm_red()[i][j];
                int green = info.getIm_green()[i][j];
                int blue = info.getIm_blue()[i][j];
                int grayscale = (red*38+green*75+blue*15)>>7;
                int binary = 255;
                if(grayscale < 70){
                    binary = 0;
                }
                g.setColor(new Color(binary,binary,binary));
                g.drawLine(i,j,i,j);
            }
        }
    }



}
