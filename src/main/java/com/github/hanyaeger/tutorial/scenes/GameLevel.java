package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.map.CoralTileMap;
import com.github.hanyaeger.tutorial.entities.sharky.Sharky;
import com.github.hanyaeger.tutorial.entities.swordfish.Swordfish;
import com.github.hanyaeger.tutorial.entities.text.BubbleText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.spawner.BubbleSpawner;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {

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
        var healthText = new HealthText(new Coordinate2D(50, 50));
        addEntity(healthText);
        var bubbleText = new BubbleText(new Coordinate2D(500, 50));
        addEntity(bubbleText);
        var hanny = new Hanny(new Coordinate2D(50, 50), healthText, bubbleText, waterworld);
        addEntity(hanny);
        var swordfish = new Swordfish(new Coordinate2D(300, 300));
        addEntity(swordfish);
        var sharky = new Sharky(new Coordinate2D(500, 200));
        addEntity(sharky);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new BubbleSpawner(getWidth(), getHeight()));
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new CoralTileMap());
    }
}
