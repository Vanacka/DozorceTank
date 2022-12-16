import dev.robocode.tankroyale.botapi.*;
import dev.robocode.tankroyale.botapi.events.*;

import static dev.robocode.tankroyale.botapi.Constants.MAX_SPEED;

public class DozorceIvan extends Bot {
    public DozorceIvan() {
        super(BotInfo.fromFile("DozorceIvan.json"));
    }

    @Override
    public void run() {
        while (isRunning()) {
            getX();
            getY();
            setTargetSpeed(MAX_SPEED);
            if(getX() < 100 || getX()  + 100 > getArenaWidth() || getY() < 100 || getY() + 100 > getArenaHeight()) {
                turnLeft(90);
                forward(getArenaWidth() - 200);
                turnLeft(90);
                forward(getArenaHeight() - 200);
                turnLeft(90);
                forward(getArenaWidth() - 200);
                turnLeft(90);
                forward(getArenaHeight() - 200);
            }
        }
    }
    public void onBulletHit(BulletHitBotEvent bulletHitBotEvent){
        System.out.println("OSS");
    }
    public void onHitWall (HitWallEvent botHitWallEvent) {
        turnLeft(180);
        System.out.println("TO SMRDÍ HOVNAMA!!!");
    }

    @Override
    public void onScannedBot(ScannedBotEvent e) {
        rescan();
        setFireAssist(true);
        fire(2.3);
        turnGunRight(10);
        fire(2.3);
        turnGunRight(10);
        fire(2.3);
        turnGunLeft(20);
        fire(2.3);
        turnGunLeft(10);
        fire(2.3);
        turnGunLeft(10);
        fire(2.3);
    }

    public static void main(String[] args) {
        new DozorceIvan().start();
    }
}