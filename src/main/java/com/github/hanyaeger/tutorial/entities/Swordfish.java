package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Swordfish extends DynamicSpriteEntity {
    public Swordfish(Coordinate2D location){
        super("sprites/swordfish.png", location);
        setMotion(2, 270d);
    }
}
