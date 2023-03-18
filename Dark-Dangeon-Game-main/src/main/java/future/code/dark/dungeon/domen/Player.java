package future.code.dark.dungeon.domen;

import future.code.dark.dungeon.config.Configuration;
import future.code.dark.dungeon.service.GameMaster;

public class Player extends DynamicObject {
    private static final int stepSize = 1;

    public Player(int xPosition, int yPosition) {
        super(xPosition, yPosition, Configuration.PLAYER_SPRITE);
    }

    public void move(Direction direction) {
        super.move(direction, stepSize);
         if (GameMaster.getInstance().getCoins().stream()
                .anyMatch(coin -> collision(coin.xPosition, coin.yPosition)));
        {
                    GameMaster.getInstance().deleteCoins(this.xPosition, this.yPosition);
        }
         if (collision(GameMaster.getInstance().getExit().xPosition,
                GameMaster.getInstance().getExit().yPosition));
        {
            GameMaster.getInstance().isvictory = false;
        }
    }

    @Override
    public String toString() {
        return "Player{[" + xPosition + ":" + yPosition + "]}";
    }
}
