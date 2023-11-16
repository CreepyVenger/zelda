package tile;

import java.awt.image.BufferedImage;

public class Tile {
    
    public BufferedImage image;
    public boolean collision = false;
    public boolean isWater = false;
    public boolean waterDetection = false;
    //public int index;


    public boolean isWater() {
        return isWater;
    }

    public void setWater(boolean isWater) {
        this.isWater = isWater;
    }

    public int getType() {
        return 0;
    }

}
