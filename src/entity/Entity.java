package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int worldX, worldY;
    public int speed;

    public BufferedImage  alap, fel1, fel2, jobb1, jobb2, le1, le2, bal1, bal2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle hitBox;
    public boolean collisionOn = false;
}
