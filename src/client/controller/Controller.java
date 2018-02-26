package client.controller;

import client.model.Model;
import client.model.vo.BombVO;
import client.model.vo.PlayerVO;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    public static final double CELL_WIDTH = 64;
    public static final double CELL_HEIGHT = 64;
    public static final double PLAYER_SPEED = 2;
    private String _failoVardas = "map.txt";
    private Model model;
    private static final int fps = 60;
    private int[][] map = new int[10][10];


    public Pane mapContainer;

    /**
     * Initialize isijungia tik sugeneravus @FXML
     */
    @FXML
    public void initialize() {
        model = new Model();
        drawMap();
        createPlayers();
        run();
    }

    /**
     * Kuria playerius model klasej, modelis is PlayerVO
     */
    private void createPlayers() {
        System.out.println(model.players.size());
        mapContainer.getChildren().add(model.players.get(0).sprite);

    }

    private void createBomb() {
        // System.out.println("FUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
        model.createBombs();
        mapContainer.getChildren().add(model.bombs.get(model.bombs.size() - 1).sprite);
    }

    /**
     * Drawina map'a is int[][] MAP
     */
    private void drawMap() {
        getData();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                ImageView cell = new ImageView();
                mapContainer.getChildren().add(cell);
                cell.setFitHeight(CELL_HEIGHT);
                cell.setFitWidth(CELL_WIDTH);
                cell.setTranslateX(CELL_WIDTH * j);
                cell.setTranslateY(CELL_HEIGHT * i);
                cell.setFocusTraversable(true);
                File sprite;
                Image image;
                switch (map[i][j]) {
                    case 0:
                        sprite = new File("ground.png");
                        image = new Image(sprite.toURI().toString());
                        cell.setImage(image);
                        break;
                    case 1:
                        sprite = new File("boulder.png");
                        image = new Image(sprite.toURI().toString());
                        cell.setImage(image);
                        break;
                    case 2:
                        sprite = new File("boulder.png");
                        image = new Image(sprite.toURI().toString());
                        cell.setImage(image);
                        break;
                }
            }
        }
    }

    /**
     * KeyListener
     * */
    /**
     * lots of shit stuff inside.
     */
    private void run() {
        mapContainer.setFocusTraversable(true);
        showData(map);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                doTimer();
            }
        }, 0, 1000 / fps);
    }

    public void handleKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.DOWN) {
            model.players.get(0).Y += PLAYER_SPEED;
        } else if (keyEvent.getCode() == KeyCode.UP) {
            model.players.get(0).Y -= PLAYER_SPEED;
        } else if (keyEvent.getCode() == KeyCode.LEFT) {
            model.players.get(0).X -= PLAYER_SPEED;
        } else if (keyEvent.getCode() == KeyCode.RIGHT) {
            model.players.get(0).X += PLAYER_SPEED;
        } else if (keyEvent.getCode() == KeyCode.ENTER) {
            model.createPlayer();
            mapContainer.getChildren().add(model.players.get(model.players.size()-1).sprite);
        } else if (keyEvent.getCode() == KeyCode.SPACE) {
            model.createBombs();
            mapContainer.getChildren().add(model.bombs.get(model.bombs.size()-1).sprite);
        }
    }
//
//    public class AL extends KeyAdapter {
//
//        public void keyPressed(KeyEvent e) {
//
//        }
//
//        public void keyTyped(KeyEvent e) {
//        }
//
//        public void keyReleased(KeyEvent e) {
//        }
//    }

    /**
     * ??
     */
    public void doTimer() {
//        long time = System.currentTimeMillis();
        update();
        for (int i = 0; i < model.players.size(); i++) {
            PlayerVO player = model.players.get(i);
            player.sprite.setTranslateX(player.X);
            player.sprite.setTranslateY(player.Y);
        }
        for (int i = 0; i < model.bombs.size(); i++) {
            BombVO bomb = model.bombs.get(i);
            bomb.sprite.setTranslateX(bomb.X);
            bomb.sprite.setTranslateY(bomb.Y);
        }
    }

    /**
     * lygtais naudojamas checkint Win condition'am ar panasiai, turi but imestas i RUN loop'a
     */
    void update() {

    }

    /**
     * is map.txt suraso i int[][] MAP
     */
    private void getData() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(_failoVardas));

            final int rows = 10;
            final int cols = 10;
            map = new int[rows][cols];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    map[row][col] = scanner.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * just to check if getData works
     */
    private void showData(int[][] a) {
        final int rows = a.length;
        final int cols = a[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print("  " + a[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
