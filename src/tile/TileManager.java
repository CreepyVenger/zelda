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
    


    /* public static TileManager getTileManager() {
        return tileManager;
    } */

    public Tile getTileAtPosition(double x, double y) {
        int col = (int) (x / gp.tileSize);
        int row = (int) (y / gp.tileSize);

        if (col >= 0 && col < gp.maxWorldCol && row >= 0 && row < gp.maxWorldRow) {
            int tileNum = mapTileNum[col][row];
            return tile[tileNum];
        }

        return null;
    }

    /* public boolean isWaterTile(int x, int y) {
        if (x >= 0 && x < gp.maxWorldCol && y >= 0 && y < gp.maxWorldRow) {
            int tileNum = mapTileNum[x][y];
            return tile[tileNum].isWater();
        }
        return false;
    } */

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

        setup(12, "image1x2", false, true);
        setup(13, "image1x3", false, true);
        setup(14, "image3x7", false, true);
        setup(15, "image4x7", false, true);
        setup(16, "image5x7", false, false);
        setup(17, "image3x8", false, true);
        setup(18, "image5x8", false, false);
        setup(19, "image3x9", false, false);
        setup(20, "image4x9", false, false);
        setup(21, "image5x9", false, false);
        setup(22, "image3x10", false, true);
        setup(23, "image4x10", false, true);
        setup(24, "image3x11", false, true);
        setup(25, "image4x11", false, true);
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
        setup(39, "image2x33", false, false);
        setup(40, "image6x17", false, false); //Up left corner //WALL
        setup(41, "tree3", true, false); //Up left corner
        setup(42, "image3x33", false, false); //DIRT
        setup(43, "rock", false, false);
    
        /* setup(41, "image7x17", false, false); //Up right corner
        setup(42, "image7x18", false, false); //bottom right corner
        setup(43, "image7x18", false, false); //bottom left corner is 9x18
        setup(44, "image8x19", false, false); //right
        setup(45, "image6x20", false, false); //down
        setup(46, "image7x19", false, false); //left
        setup(47, "image6x19", false, false); //up */   
        //setup(48, "image6x19", true, false); //center
        
        System.out.println("Image loading finished");
    }



/* public void getTileImage() {

    try {

        setup(0, "grass2", false);
        setup(1, "wall2", false);
        setup(2, "water2", false);
        setup(3, "earth", false);
        setup(4, "tree2-variant2", false);
        setup(5, "sand2", false);

        tile[0] = new Tile();
        tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass2.png"));
        //tile[0].index = 0;
        
        BufferedImage scaledImage = new BufferedImage(gp.tileSize, gp.tileSize, tile[0].image.getType());
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        tile[0].image = scaledImage;

        tile[1] = new Tile();
        tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall2.png"));
        tile[1].collision = true;
        //tile[1].index = 0;

        tile[2] = new Tile();
        tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water2.png"));
        tile[2].collision = false;
        //tile[2].index = 0;
        //tile[2].waterDetection = true;
        //tile[2].setWater(true);
        tile[2].isWater = true;

        tile[3] = new Tile();
        tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
        //tile[3].index = 0;
        
        tile[4] = new Tile();
        tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree2-variant2.png"));
        tile[4].collision = true;
        //tile[4].index = 0;
        

        tile[5] = new Tile();
        tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand2.png")); 
        //tile[5].index = 0;*/

        /* tile[0] = new Tile();
        tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));

        tile[1] = new Tile();
        tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
        
        tile[2] = new Tile();
        tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
        
        tile[3] = new Tile();
        tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
        tile[3].collision = true;

        tile[4] = new Tile();
        tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
        tile[4].collision = true;


        tile[5] = new Tile();
        tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
        tile[5].collision = true;


        tile[6] = new Tile();
        tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/rock.png"));
        tile[6].collision = true; */

    /* } catch (IOException e) {
        e.printStackTrace();
    }
} */ 

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

    /* public Tile setup(int index, String imagePath, boolean collision, boolean isWater) {

        UtilityTool uTool = new UtilityTool();
    
        try {
            Tile newTile = new Tile();
            newTile.image = ImageIO.read(getClass().getResourceAsStream("/tiles/new/" + imagePath + ".png"));
            newTile.image = uTool.scaleImage(newTile.image, gp.tileSize, gp.tileSize);
            newTile.collision = collision;
            newTile.isWater = isWater;
            tile[index] = newTile; // Add the new tile to the tile array at the specified index; this line is apparently not in the tutorial's code and I asked ChatGPT for help
            return newTile;
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return null;
    } */
    

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

        /* g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 48, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[2].image, 96, 0, gp.tileSize, gp.tileSize, null); */

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

            /* if (tile[tileNum].isWater()) {
            // Draw water tile specific logic
            } else {
            // Draw other tiles
            } */
        }
    }
}