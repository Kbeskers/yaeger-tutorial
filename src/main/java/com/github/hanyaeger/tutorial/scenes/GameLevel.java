package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.entities.Swordfish;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameLevel extends DynamicScene {
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }
    @Override
    public void setupEntities() {
        var swordfish = new Swordfish(new Coordinate2D(300, 300));
        addEntity(swordfish);

    }
}
