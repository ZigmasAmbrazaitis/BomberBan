package client.model.vo;

import client.controller.Controller;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class PlayerVO {

    boolean isMe = true;
    public double X = 200;
    public double Y = 200;

    public ImageView sprite;

    /**
     * create player and put in on the screen
     * */
    public PlayerVO(){
        X = Math.random()*500;
        Y = Math.random()*500;
        sprite = new ImageView();
        File file = new File("bomber.png");
        Image image = new Image(file.toURI().toString());
        sprite.setImage(image);
        sprite.setFitHeight(Controller.CELL_HEIGHT);
        sprite.setFitWidth(Controller.CELL_WIDTH);
    }
}
