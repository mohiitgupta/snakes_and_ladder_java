import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class ImagePanel extends JPanel {

    private Image img;
    private int[] pos;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.img = img;
        this.pos = new int[2];
        pos[0]=pos[1]=1;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
        int x0 =(int)(((pos[0]-1)%20<10)?(5+35.6*((pos[0]-1)%20)):(358-(35.6*(((pos[0]-1)%20)-9))));
        int x1 =(int)(((pos[1]-1)%20<10)?(5+35.6*((pos[1]-1)%20)):(358-(35.6*(((pos[1]-1)%20)-9))));
        int y0 = (int)(358-(((pos[0]-1)/10+1)*35.6));
        int y1 = (int)(358-(((pos[1]-1)/10+1)*35.6));
        //System.out.println(pos[0]+" "+pos[1]);
        //System.out.println(x0+" "+y0+" "+x1+" "+y1);
        g.setColor(Color.YELLOW);
        g.fillOval(x0, y0, 30, 30);
        g.setColor(Color.PINK);
        g.fillOval(x1, y1, 30, 30);
    }

    int movePos(int i, int step) {
        //System.out.println(i+" "+step);
        this.pos[i-1]=(this.pos[i-1]+step)<=100?this.pos[i-1]+step:this.pos[i-1];
        return check(i-1);
    }

    private int check(int i) {
        switch(pos[i]) {
            case 17:{
                pos[i]=7;
                return 2;
            }
            case 4: {
                pos[i]=14;
                return 1;
            }
            case 9:{
                pos[i]=31;
                return 1;
            }
            case 19:{
                pos[i]=38;
                return 1;
            }
            case 21:{
                pos[i]=42;
                return 1;
            }
            case 28:{
                pos[i]=84;
                return 1;
            }
            case 51:{
                pos[i]=67;
                return 1;
            }
            case 54:{
                pos[i]=34;
                return 2;
            }
            case 62:{
                pos[i]=19;
                return 2;
            }
            case 64:{
                pos[i]=60;
                return 2;
            }
            case 71:{
                pos[i]=91;
                return 1;
            }
            case 80:{
                pos[i]=100;
                return 1;
            }
            case 87:{
                pos[i]=24;
                return 2;
            }
            case 93:{
                pos[i]=73;
                return 2;
            }
            case 95:{
                pos[i]=75;
                return 2;
            }
            case 98:{
                pos[i]=79;
                return 2;
            }
            case 100:{
                return 3;
            }
            default : {
                return 0;
            }
        }
    }


}
