package com.github.hanyaeger.tutorial.entities.Bubble;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class AirBubble extends DynamicCircleEntity {
    private int speed;
    public AirBubble(Coordinate2D initialLocation, int speed) {
        super(initialLocation);
        setShape(new Circle());
        setFill(Color.TRANSPARENT);
    }
}
