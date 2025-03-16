package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.button.PlayAgainButton;
import com.github.hanyaeger.tutorial.button.QuitButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOver extends StaticScene {

    private Waterworld waterworld;

    public GameOver(Waterworld waterworld){
        this.waterworld = waterworld;
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        var gameOverText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Game Over"
        );
        gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOverText.setFill(Color.BLACK);
        gameOverText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(gameOverText);


        var restartButton = new PlayAgainButton(
                new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 50),
                waterworld
        );
        restartButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(restartButton);

        var quitButton = new QuitButton(
                new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 100),
                waterworld
        );
        quitButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(quitButton);
    }
}
