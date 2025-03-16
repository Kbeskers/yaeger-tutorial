package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.sharky.Sharky;
import com.github.hanyaeger.tutorial.entities.swordfish.Swordfish;
import com.github.hanyaeger.tutorial.entities.text.HealthText;

public class GameLevel extends DynamicScene {

    private Waterworld waterworld;

    public GameLevel(Waterworld waterworld){
        this.waterworld = waterworld;
    }
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }
    @Override
    public void setupEntities() {
        var health = new HealthText(new Coordinate2D(50, 50));
        addEntity(health);
        var hanny = new Hanny(new Coordinate2D(50, 50), health, waterworld);
        addEntity(hanny);
        var swordfish = new Swordfish(new Coordinate2D(300, 300));
        addEntity(swordfish);
        var sharky = new Sharky(new Coordinate2D(500, 200));
        addEntity(sharky);
    }
}
