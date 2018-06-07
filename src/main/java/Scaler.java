import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Scaler {

    private final String Npath;
    private final String Opath;

    public  Scaler(String pathOriginalFolder, String pathNewFolder) throws IOException {
        this.Opath = pathOriginalFolder;
        this.Npath = pathNewFolder;

        scaled(300,300);
    }

    private void scaled(int width, int height) throws IOException {
        File folder = new File(Opath);
        String[] listImg = folder.list();

        for (String name: listImg
             ) {
                String pathImg =  folder +"\\"+ name;
                Image img = ImageIO.read(new File(pathImg));
            System.out.println(pathImg);
            BufferedImage scaled = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = scaled.createGraphics();
            g.drawImage(img,0,0, width,height,null);
            g.dispose();
            ImageIO.write(scaled,"JPEG", new File(Npath +"\\"+ name));
        }
    }

}
