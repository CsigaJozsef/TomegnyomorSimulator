package main;

import entity.Entity;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }

    public boolean checkCollisionUp(Entity entity){

        int entityLeftWorldX = entity.worldX + entity.hitBox.x;
        int entityRightWorldX = entity.worldX + entity.hitBox.x + entity.hitBox.width;
        int entityTopWorldY = entity.worldY + entity.hitBox.y;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;

        int entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
        int tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
        int tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];

        return gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision;
    }

    public boolean checkCollisionDown(Entity entity){

        int entityLeftWorldX = entity.worldX + entity.hitBox.x;
        int entityRightWorldX = entity.worldX + entity.hitBox.x + entity.hitBox.width;
        int entityBottomWorldY = entity.worldY + entity.hitBox.y + entity.hitBox.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;

        int entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
        int tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
        int tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

        return gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision;
    }

    public boolean checkCollisionLeft(Entity entity){

        int entityLeftWorldX = entity.worldX + entity.hitBox.x;
        int entityTopWorldY = entity.worldY + entity.hitBox.y;
        int entityBottomWorldY = entity.worldY + entity.hitBox.y + entity.hitBox.height;

        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
        int tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
        int tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];

        return gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision;
    }

    public boolean checkCollisionRight(Entity entity){

        int entityRightWorldX = entity.worldX + entity.hitBox.x + entity.hitBox.width;
        int entityTopWorldY = entity.worldY + entity.hitBox.y;
        int entityBottomWorldY = entity.worldY + entity.hitBox.y + entity.hitBox.height;

        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
        int tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
        int tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

        return gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision;
    }
}
