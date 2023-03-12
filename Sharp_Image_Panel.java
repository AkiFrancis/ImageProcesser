import javax.swing.*;
import java.awt.*;

public class Sharp_Image_Panel extends JPanel {
    private Get_Image_Info info;
    private int[][] kernel_sharp;
    private int kernel_size;
    Sharp_Image_Panel(Get_Image_Info i,int[][] k){
        this.info=i;
        this.kernel_sharp=k;
        this.kernel_size=kernel_sharp.length;
    }
    public void paint(Graphics g) {
        int im_width = info.getIm_width();
        int im_height = info.getIm_height();

        for(int i=0;i<im_width-kernel_size+1;i++){
            for(int j =0;j<im_height-kernel_size+1;j++){
                int red=0,green=0,blue=0;
                for(int x=0;x<kernel_size;x++){
                    for(int y=0;y<kernel_size;y++){
                        red=red+info.getIm_red()[i+x][j+y]*kernel_sharp[x][y];
                        green=green+info.getIm_green()[i+x][j+y]*kernel_sharp[x][y];
                        blue=blue+info.getIm_blue()[i+x][j+y]*kernel_sharp[x][y];
                    }
                }
                red=red>255?255:Math.max(0,red);
                green=green>255?255:Math.max(0,green);
                blue=blue>255?255:Math.max(0,blue);
                g.setColor(new Color(red,green,blue));
                g.drawLine(i,j,i,j);
                //补充底层缺失像素 - 也可以图像外圈使用补0的方法
                if(j==(im_height-kernel_size)){
                    for(int m=0;m<kernel_size-1;m++){
                        red=info.getIm_red()[i][j+m+1];
                        green=info.getIm_green()[i][j+m+1];
                        blue=info.getIm_green()[i][j+m+1];
                        g.setColor(new Color(red,green,blue));
                        g.drawLine(i,j+m+1,i,j+m+1);
                    }
                }
            }
            //补充右侧缺失像素
            if(i==(im_width-kernel_size)){
                for(int n=0;n<kernel_size-1;n++){
                    for(int j =0;j<im_height;j++){
                        int red=info.getIm_red()[i+n+1][j];
                        int green=info.getIm_green()[i+n+1][j];
                        int blue=info.getIm_green()[i+n+1][j];
                        g.setColor(new Color(red,green,blue));
                        g.drawLine(i+n+1,j,i+n+1,j);
                    }
                }
            }

        }

    }





}
