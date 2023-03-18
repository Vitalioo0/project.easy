package future.code.dark.dungeon.domen;

import future.code.dark.dungeon.config.Configuration;
import future.code.dark.dungeon.service.GameMaster;

public abstract class DynamicObject extends GameObject {

    public DynamicObject(int xPosition, int yPosition, String imagePath) {
        super(xPosition, yPosition, imagePath);
    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    protected void move(Direction direction, int distance) {
        int tmpXPosition = getXPosition();
        int tmpYPosition = getYPosition();

        switch (direction) {
            case UP -> tmpYPosition -= distance;
            case DOWN -> tmpYPosition += distance;
            case LEFT -> tmpXPosition -= distance;
            case RIGHT -> tmpXPosition += distance;
        }

        if (isAllowedSurface(tmpXPosition, tmpYPosition)) {
            xPosition = tmpXPosition;
            yPosition = tmpYPosition;
        }
    }

    public boolean collision(int x, int y){
        return this.xPosition == x && yPosition == y;
    }
    private boolean exit(int x, int y, boolean exitEnable) {
       boolean notWall =  GameMaster.getInstance().getMap().getMap()[y][x] != Configuration.WALL_CHARACTER;
       boolean notExit = GameMaster.getInstance().getMap().getMap()[y][x] != Configuration.EXIT_CHARACTER;
       if (GameMaster.getInstance().exitEnable) return notWall;
       else return notExit && notWall;
    }

    private Boolean isAllowedSurface(int x, int y) {
        return GameMaster.getInstance().getMap().getMap()[y][x] != Configuration.WALL_CHARACTER;
    }

}
