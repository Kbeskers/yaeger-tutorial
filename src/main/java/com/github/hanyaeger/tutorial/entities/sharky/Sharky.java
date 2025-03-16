package com.github.hanyaeger.tutorial.entities.sharky;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;


import java.util.Random;

public class Sharky extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {
    public Sharky(Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(2, 90d);
    }

    @Override
    public void setupEntities() {
        var hitBox = new HitBox(new Coordinate2D(0, 0));
        addEntity(hitBox);
        var sharkySprite = new SharkySprite(new Coordinate2D(-80, -48));
        addEntity(sharkySprite);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(-35);
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
    }
}
