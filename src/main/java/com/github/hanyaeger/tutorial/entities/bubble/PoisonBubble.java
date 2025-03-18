package com.github.hanyaeger.tutorial.entities.bubble;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class PoisonBubble extends Bubble {
    private int speed;
    public PoisonBubble(Coordinate2D initialLocation, int speed) {
        super(initialLocation, 10, Color.PURPLE, 0.5F, speed);
    }
}
