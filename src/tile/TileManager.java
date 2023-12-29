package tile;

import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
//import javax.swing.text.Utilities;

import main.GamePanel;
import main.UtilityTool;

public class TileManager {
    //private static TileManager tileManager;

    GamePanel gp;
    public Tile[] tile;
    //private Tile[] tile = new Tile[6];
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {
        //tileManager = this;
        super();

        this.gp = gp;

        tile = new Tile[250];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/WorldV2.txt");

    }

    public Tile getTileAtPosition(double x, double y) {
        int col = (int) (x / gp.tileSize);
        int row = (int) (y / gp.tileSize);

        if (col >= 0 && col < gp.maxWorldCol && row >= 0 && row < gp.maxWorldRow) {
            int tileNum = mapTileNum[col][row];
            return tile[tileNum];
        }

        return null;
    }

    public void getTileImage() {
        System.out.println("Image loading started");

        /* //PLACEHOLDERS
        setup(0, "grass00", false, false);
        setup(1, "grass00", false, false);
        setup(2, "grass00", false, true);
        setup(3, "grass00", false, false);
        setup(4, "grass00", false, false);
        setup(5, "grass00", false, false);
        setup(6, "grass00", false, false);
        setup(7, "grass00", false, false);
        setup(8, "grass00", false, false);
        setup(9, "grass00", false, false);

        //PLACEHOLDERS
        setup(10, "grass00", false, false);
        //setup(10, "image1x1", false, false);

        setup(11, "grass01", false, false);
        
        setup(12, "water00", false, true);
        setup(13, "water01", false, true);
        setup(14, "water02", false, true);
        setup(15, "water03", false, true);
        setup(16, "water04", false, false);
        setup(17, "water05", false, true);
        setup(18, "water06", false, false);
        setup(19, "water07", false, false);
        setup(20, "water08", false, false);
        setup(21, "water09", false, false);
        setup(22, "water10", false, true);
        setup(23, "water11", false, true);
        setup(24, "water12", false, true);
        setup(25, "water13", false, true);
        //PLACEHOLDERS
        setup(26, "road00", false, false);
        setup(27, "road01", false, false);
        setup(28, "road02", false, false);
        setup(29, "road03", false, false);
        setup(30, "road04", false, false);
        setup(31, "road05", false, false);
        setup(32, "road06", false, false);
        setup(33, "road07", false, false);
        setup(34, "road08", false, false);
        setup(35, "road09", false, false);
        setup(36, "road10", false, false);
        setup(37, "road11", false, false);
        setup(38, "road12", false, false);
        setup(39, "earth", false, false);
        setup(40, "wall", true, false);
        setup(41, "tree3", true, false); */

        ////////////////////////////////////////

        setup(10, "image1x1", false, false);

        setup(11, "image3x17", false, false);

        setup(12, "image1x2", true, true);
        setup(13, "image1x3", true, true);
        setup(14, "image3x7", true, true);
        setup(15, "image4x7", true, true);
        setup(16, "image5x7", true, false);
        setup(17, "image3x8", true, false); //right water
        setup(18, "image5x8", true, false);
        setup(19, "image3x9", true, false);
        setup(20, "image4x9", true, false);
        setup(21, "image5x9", true, false);
        setup(22, "image3x10", true, true);
        setup(23, "image4x10", true, true);
        setup(24, "image3x11", true, true);
        setup(25, "image4x11", true, true);
        //PLACEHOLDERS
        setup(26, "image2x5", false, false);
        setup(27, "image1x7", false, false);
        setup(28, "image2x6", false, false);
        setup(29, "image2x7", false, false);
        setup(30, "image3x5", false, false);
        setup(31, "image1x5", false, false);
        setup(32, "image1x8", false, false);
        setup(33, "image2x4", false, false);
        setup(34, "image2x8", false, false);
        setup(35, "image1x4", false, false);
        setup(36, "image3x4", false, false);
        setup(37, "image1x6", false, false);
        setup(38, "image3x6", false, false);
        setup(39, "earth", false, false);
        setup(40, "wall", true, false); //Up left corner //WALL
        setup(41, "tree3", true, false); //Up left corner
        setup(42, "image3x33", false, false); //DIRT
        setup(43, "rock", false, false);
        
        System.out.println("Image loading finished");
    }

    public void setup(int index, String imagePath, boolean collision, boolean isWater) {

        UtilityTool uTool = new UtilityTool();

        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/new/" + imagePath + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
            tile[index].isWater = isWater;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    

    public void loadMap(String filePath) {

        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow) {

                String line = br.readLine();

                //int charIndex = 0;

                while(col < gp.maxWorldCol){

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;

                    //charIndex += 2;

                    /* if (charIndex >= line.length()) {
                        break;
                    } */
                }
                if(col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol] [worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            double screenX = worldX - gp.player.worldX + gp.player.screenX;
            double screenY = worldY - gp.player.worldY + gp.player.screenY;

            /* Tile currentTile = tile[tileNum];
            boolean onWater = currentTile.isWater(); */
            
            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
               worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
               worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
               worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

                //g2.drawImage(tile[tileNum].image, (int)screenX, (int)screenY, gp.tileSize, gp.tileSize, null);
               g2.drawImage(tile[tileNum].image, (int)screenX, (int)screenY, null);
               
               if (tile[tileNum].isWater()) {
                    gp.player.setOnWater(true);
                }  
            }

            worldCol++;

            if(worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}