package com.github.hanyaeger.tutorial.entities.bubble;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.entities.map.Coral;
import com.github.hanyaeger.tutorial.entities.map.CoralTileMap;
import javafx.scene.paint.Color;

import java.util.List;

public class Bubble extends DynamicCircleEntity implements Collider, Collided, SceneBorderCrossingWatcher {

    protected Bubble(Coordinate2D initialLocation, int radius, Color color, float opacity, int speed) {
        super(initialLocation);
        setRadius(radius);
        setFill(color);
        setOpacity(opacity);
        setMotion(speed,180d);
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        var coralCollision = false;
        for (Collider collider : collidingObject) {
            if (collider instanceof Coral) {
                coralCollision = true;
            }
        }
        if (!coralCollision) {
            var popSound = new SoundClip("audio/pop.mp3");
            popSound.play();
            remove();
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}
