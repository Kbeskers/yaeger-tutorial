package com.github.hanyaeger.tutorial.button;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.Waterworld;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlayAgainButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private Waterworld waterworld;

    public PlayAgainButton(Coordinate2D initialLocation, Waterworld waterworld){
        super(initialLocation,"Play Again");
        setFill(Color.BLACK);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        this.waterworld = waterworld;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        waterworld.setActiveScene(1);
    }
    @Override
    public void onMouseEntered(){
        setFill(Color.GREY);
        setCursor(Cursor.HAND);
    }
    @Override
    public void onMouseExited(){
        setFill(Color.BLACK);
        setCursor(Cursor.DEFAULT);
    }
}