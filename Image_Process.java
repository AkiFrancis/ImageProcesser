import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
public class Image_Process {
    public static void main(String[] args) throws IOException {
        String im_path = "C:\\Users\\Administrator.DESKTOP-5STJAB2\\Desktop\\test4.jpg";
        Get_Image_Info im_info = new Get_Image_Info(im_path);
        //创建窗口 默认BorderLayout
        JFrame jf = new JFrame("test");
        jf.setSize(1600,1000);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

        //原始图片面板
        JPanel panel_ori_im=new Original_Image_Panel(im_info);
        panel_ori_im.setLayout(null);
        panel_ori_im.setBounds(50,50,600,600);

        //按键面板
        JPanel panel_button=new JPanel();
        panel_button.setBounds(0,jf.getHeight()-200,jf.getWidth(),150);
        JButton button_show = new JButton("显示");
        //鼠标事件监听器
        button_show.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click show");
                if(jf.getContentPane().getComponentCount()<2)
                    jf.getContentPane().add(panel_ori_im);
                jf.repaint();
            }
        });
        JButton button_grayscale = new JButton("灰度");
        button_grayscale.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click grayscale");
                JPanel panel_grayscale_im = new Grayscale_Image_Panel(im_info);
                panel_grayscale_im.setLayout(null);
                panel_grayscale_im.setBounds(700,50,600,600);
                if(jf.getContentPane().getComponentCount()>2){
                    jf.getContentPane().remove(2);
                }
                jf.getContentPane().add(panel_grayscale_im);
                jf.repaint();
            }
        });
        JButton button_binary = new JButton("二值");
        button_binary.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click binary");
                JPanel panel_binary_im = new Binary_Image_Panel(im_info);
                panel_binary_im.setLayout(null);
                panel_binary_im.setBounds(700,50,600,600);
                if(jf.getContentPane().getComponentCount()>2){
                    jf.getContentPane().remove(2);
                }
                jf.getContentPane().add(panel_binary_im);
                jf.repaint();
            }
        });
        JButton button_negative = new JButton("负片");
        button_negative.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click negative");
                JPanel panel_negative_im = new Negative_Image_Panel(im_info);
                panel_negative_im.setLayout(null);
                panel_negative_im.setBounds(700,50,600,600);
                if(jf.getContentPane().getComponentCount()>2){
                    jf.getContentPane().remove(2);
                }
                jf.getContentPane().add(panel_negative_im);
                jf.repaint();
            }
        });
        JButton button_msk = new JButton("马赛克");
        button_msk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click msk");
                JPanel panel_msk_im = new Msk_Image_Panel(im_info);
                panel_msk_im.setLayout(null);
                panel_msk_im.setBounds(700,50,600,600);
                if(jf.getContentPane().getComponentCount()>2){
                    jf.getContentPane().remove(2);
                }
                jf.getContentPane().add(panel_msk_im);
                jf.repaint();
            }
        });
        JButton button_oldfashion = new JButton("复古");
        button_oldfashion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click oldfashion");
                JPanel panel_of_im = new Oldfashion_Image_Panel(im_info);
                panel_of_im.setLayout(null);
                panel_of_im.setBounds(700,50,600,600);
                if(jf.getContentPane().getComponentCount()>2){
                    jf.getContentPane().remove(2);
                }
                jf.getContentPane().add(panel_of_im);
                jf.repaint();
            }
        });
        JButton button_sharp = new JButton("锐化");
        //鼠标事件监听器
        button_sharp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click sharp");
                int[][] kernel = {{-1, -1, -1},{-1, 9, -1},{-1, -1, -1}};
                JPanel panel_sharp_im = new Sharp_Image_Panel(im_info,kernel);
                panel_sharp_im.setLayout(null);
                panel_sharp_im.setBounds(700,50,600,600);
                if(jf.getContentPane().getComponentCount()>2){
                    jf.getContentPane().remove(2);
                }
                jf.getContentPane().add(panel_sharp_im);
                jf.repaint();
            }
        });
        //添加按键到按键面板
        panel_button.add(button_show);
        panel_button.add(button_grayscale);
        panel_button.add(button_binary);
        panel_button.add(button_negative);
        panel_button.add(button_msk);
        panel_button.add(button_oldfashion);
        panel_button.add(button_sharp);
        //添加按键面板到窗口底部
        jf.getContentPane().add(panel_button,BorderLayout.SOUTH);
        jf.setVisible(true);

    }
}
