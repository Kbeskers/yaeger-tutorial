package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.bubble.AirBubble;
import com.github.hanyaeger.tutorial.entities.bubble.PoisonBubble;
import com.github.hanyaeger.tutorial.entities.text.BubbleText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class Hanny extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collider, Collided {
    private HealthText healthText;
    private int health = 10;
    private BubbleText bubbleText;
    private int bubblesPopped = 0;
    private Waterworld waterworld;

    public Hanny(Coordinate2D location, HealthText healthText, BubbleText bubbleText, Waterworld waterworld) {
        super("sprites/hanny.png", location, new Size(20,40), 1,2);

        this.healthText = healthText;
        healthText.setHealthText(health);

        this.bubbleText = bubbleText;
        bubbleText.setBubbleText(0);

        setGravityConstant(0.005);
        setFrictionConstant(0.04);

        this.waterworld = waterworld;
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if(pressedKeys.contains(KeyCode.LEFT)){
            setCurrentFrameIndex(2);
            setMotion(3,270d);
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            setCurrentFrameIndex(1);
            setMotion(3,90d);
        } else if(pressedKeys.contains(KeyCode.UP)){
            setMotion(3,180d);
        } else if(pressedKeys.contains(KeyCode.DOWN)){
            setMotion(3,0d);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);
        switch(border){
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        var airBubbleCollision = false;
        var enemyCollision = false;
        var coralCollision = false;

        for (Collider collider : collidingObject) {
            if (collider instanceof AirBubble) {
                airBubbleCollision = true;
            } else if (collider instanceof PoisonBubble) {
                enemyCollision = true;
            } else  {
                coralCollision = true;
            }
        }

        if (airBubbleCollision) {
            bubbleText.setBubbleText(++bubblesPopped);
        }
        if (enemyCollision) {
            healthText.setHealthText(--health);

            if (health == 0) {
                this.waterworld.setActiveScene(2);
            } else {
                setAnchorLocation(new Coordinate2D(
                        new Random().nextInt((int) (getSceneWidth() - getWidth())),
                        new Random().nextInt((int) (getSceneHeight() - getHeight()))));
            }
        }
        if (coralCollision) {
            setSpeed(0);
        }
    }
}
