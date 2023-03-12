import javax.swing.*;
import java.awt.*;

public class Original_Image_Panel extends JPanel {
    private Get_Image_Info info;
    Original_Image_Panel(Get_Image_Info i){
        this.info=i;
    }
    @Override
    public void paint(Graphics g) {
        int im_width = info.getIm_width();
        int im_height = info.getIm_height();
        for(int i=0;i<im_width;i++){
            for (int j =0;j<im_height;j++){
                int red = info.getIm_red()[i][j];
                int green = info.getIm_green()[i][j];
                int blue = info.getIm_blue()[i][j];
                g.setColor(new Color(red,green,blue));
                g.drawLine(i,j,i,j);
            }
        }
    }
}
