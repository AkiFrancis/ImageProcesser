import javax.swing.*;
import java.awt.*;

public class Msk_Image_Panel extends JPanel {
    private Get_Image_Info info;
    Msk_Image_Panel(Get_Image_Info i){
        this.info=i;
    }
    public void paint(Graphics g) {
        int im_width = info.getIm_width();
        int im_height = info.getIm_height();
        for(int i=0;i<im_width-10;i=i+10){
            for (int j =0;j<im_height-10;j=j+10){
                int red = info.getIm_red()[i][j];
                int green = info.getIm_green()[i][j];
                int blue = info.getIm_blue()[i][j];
                g.setColor(new Color(red,green,blue));
                g.fillRect(i,j,10,10);
            }
        }
        int w=im_width%10;
        int h=im_height%10;
        //补齐底部余量
        for(int i=0;i<im_width-10;i=i+10){
            int red = info.getIm_red()[i][im_height-h];
            int green = info.getIm_green()[i][im_height-h];
            int blue = info.getIm_blue()[i][im_height-h];
            g.setColor(new Color(red,green,blue));
            g.fillRect(i,im_height-h,10,h);
        }
        //补齐右侧余量
        for(int j=0;j<im_height-10;j=j+10){
            int red = info.getIm_red()[im_width-w][j];
            int green = info.getIm_green()[im_width-w][j];
            int blue = info.getIm_blue()[im_width-w][j];
            g.setColor(new Color(red,green,blue));
            g.fillRect(im_width-w,j,w,10);
        }
    }



}
