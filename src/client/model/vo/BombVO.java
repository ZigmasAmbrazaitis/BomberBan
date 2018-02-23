package client.model.vo;

import client.controller.Controller;
import client.model.Model;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.ArrayList;

public class BombVO {

    public Model model;
    public double X = 200;
    public double Y = 200;

    public ImageView sprite;

    /**
     * create bomb and put it on the screen
     */
    public BombVO() {
//        X = model.players.get(0).X;
        X = 400;
//        Y = model.players.get(0).Y;
        Y = 400;
        sprite = new ImageView();
        File file = new File("bomb.png");
        Image image = new Image(file.toURI().toString());
        sprite.setImage(image);
        sprite.setFitHeight(Controller.CELL_HEIGHT);
        sprite.setFitWidth(Controller.CELL_WIDTH);
    }
}