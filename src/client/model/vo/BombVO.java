package client.model.vo;

import client.controller.Controller;
import client.model.Model;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class BombVO {

//    Model model = new Model();

    public double X = 200;
    public double Y = 200;

    public ImageView sprite;

    /**
     * create bomb and put it on the screen
     */
    public BombVO() {
     //   X = model.players.get(0).X;
     //   Y = model.players.get(0).Y;
        sprite = new ImageView();
        sprite.setFocusTraversable(true);
        File file = new File("bomb.png");
        Image image = new Image(file.toURI().toString());
        sprite.setImage(image);
        sprite.setFitHeight(Controller.CELL_HEIGHT);
        sprite.setFitWidth(Controller.CELL_WIDTH);
    }
}