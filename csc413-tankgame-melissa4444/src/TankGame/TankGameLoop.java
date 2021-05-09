package TankGame;

import javafx.animation.AnimationTimer;


public class TankGameLoop extends AnimationTimer{
    protected TankGM TankGame;
    public TankGameLoop(TankGM iTank){
        TankGame=iTank;
    }

    @Override
    public void handle(long now){
        TankGame.iTank.update();
    }

    @Override
    public void start(){
        super.start();
    }
    @Override
    public void stop(){
        super.stop();
    }

}

