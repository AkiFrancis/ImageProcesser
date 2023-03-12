import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Get_Image_Info {
    //private String im_path;
    //private BufferedImage buf_im;
    private int[][] im_red,im_green,im_blue;
    public int[][] getIm_red() {
        return this.im_red;
    }
    public int[][] getIm_green() {
        return this.im_green;
    }
    public int[][] getIm_blue() {
        return this.im_blue;
    }

    public void setIm_red(int[][] im_red) {
        this.im_red = im_red;
    }

    public void setIm_green(int[][] im_green) {
        this.im_green = im_green;
    }

    public void setIm_blue(int[][] im_blue) {
        this.im_blue = im_blue;
    }

    private int im_width,im_height;
    public int getIm_width(){
        return this.im_width;
    }
    public int getIm_height(){
        return this.im_height;
    }

    Get_Image_Info(String im_path) throws IOException {
        BufferedImage buf_im= ImageIO.read(new FileInputStream(im_path));
        im_width=buf_im.getWidth();
        im_height=buf_im.getHeight();
        int[][] red = new int[im_width][im_height];
        int[][] green = new int[im_width][im_height];
        int[][] blue = new int[im_width][im_height];
        for(int i=0;i<im_width;i++){
            for (int j =0;j<im_height;j++){
                red[i][j] = (buf_im.getRGB(i,j)>>16) &0xFF;
                green[i][j] = (buf_im.getRGB(i,j)>>8) &0xFF;
                blue[i][j] = (buf_im.getRGB(i,j)) &0xFF;
                setIm_red(red);
                setIm_green(green);
                setIm_blue(blue);
                //int greyscale = (red*38+green*75+blue*15)>>7;
            }
        }
    }
}
