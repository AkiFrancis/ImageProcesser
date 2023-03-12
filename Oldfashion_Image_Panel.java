import javax.swing.*;
import java.awt.*;

public class Oldfashion_Image_Panel extends JPanel {
    private Get_Image_Info info;
    Oldfashion_Image_Panel(Get_Image_Info i){
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
                int R = (int) (0.393 * red + 0.469 * green + 0.049 * blue);
                int G = (int) (0.349 * red + 0.586 * green + 0.068 * blue);
                int B = (int) (0.272 * red + 0.534 * green + 0.031 * blue);
                g.setColor(new Color(R,G,B));
                g.drawLine(i,j,i,j);
            }
        }
    }



}
