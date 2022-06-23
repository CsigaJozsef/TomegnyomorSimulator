package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - gp.tileSize/2;
        screenY = gp.screenHeight/2 - gp.tileSize/2;

        hitBox = new Rectangle(8, 32, 16, 16);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";


    }

    public void getPlayerImage(){
        try{

            fel1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/fel1.png")));
            fel2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/fel2.png")));
            le1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/le1.png")));
            le2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/le2.png")));
            jobb1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/jobb1.png")));
            jobb2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/jobb2.png")));
            bal1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/bal1.png")));
            bal2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/bal2.png")));
            alap = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/alap.png")));

        }catch(IOException e){
            System.out.println("Baj");
        }
    }

    public void update(){

        if(keyH.upPressed && !gp.cChecker.checkCollisionUp(this)){
            direction = "up";
            worldY -= speed;
        }
        if(keyH.downPressed && !gp.cChecker.checkCollisionDown(this)){
            direction = "down";
            worldY += speed;
        }
        if(keyH.rightPressed && !gp.cChecker.checkCollisionRight(this)){
            direction = "right";
            worldX += speed;
        }
        if(keyH.leftPressed && !gp.cChecker.checkCollisionLeft(this)){
            direction = "left";
            worldX -= speed;
        }


        spriteCounter++;
        if(spriteCounter > 10){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

        if(!keyH.leftPressed && !keyH.rightPressed && !keyH.downPressed && !keyH.upPressed)
            direction = "alap";
    }

    public void draw(Graphics2D g2){

        //g2.setColor(Color.black);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up" -> {
                if (spriteNum == 1) {
                    image = fel1;
                }
                if (spriteNum == 2) {
                    image = fel2;
                }
            }
            case "down" -> {
                if (spriteNum == 1) {
                    image = le1;
                }
                if (spriteNum == 2) {
                    image = le2;
                }
            }
            case "right" -> {
                if (spriteNum == 1) {
                    image = jobb1;
                }
                if (spriteNum == 2) {
                    image = jobb2;
                }
            }
            case "left" -> {
                if (spriteNum == 1) {
                    image = bal1;
                }
                if (spriteNum == 2) {
                    image = bal2;
                }
            }
            default -> image = alap;
        }

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
