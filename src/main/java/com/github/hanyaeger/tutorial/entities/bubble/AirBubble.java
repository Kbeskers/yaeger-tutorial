package com.github.hanyaeger.tutorial.entities.bubble;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class AirBubble extends Bubble {
    public AirBubble(Coordinate2D initialLocation, int speed) {
        super(initialLocation, 10, Color.WHITE, 0.5F, speed);
    }
}
