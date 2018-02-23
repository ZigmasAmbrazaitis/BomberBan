package client.controller;

import client.model.Model;
import client.model.vo.PlayerVO;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Controller extends JFrame {
    public static final double CELL_WIDTH = 64;
    public static final double CELL_HEIGHT = 64;
    private String _failoVardas = "map.txt";
    private Model model;
    //    private static final boolean isRunning = false;
    private static final int fps = 60;
    private int[][] map = new int[10][10];

    private static final int windowWidth = 1280;
    private static final int windowHeight = 720;
    private int positionX = windowHeight / 2;
    private int positionY = windowWidth / 2;

    public Pane mapContainer;

    /**
     * Initialize isijungia tik sugeneravus @FXML
     * */
    @FXML
    public void initialize() {
        model = new Model();
        drawMap();
        createPlayers();
        run();
    }

    /**
     * Kuria playerius model klasej, modelis is PlayerVO
     * */
    private void createPlayers() {
        for (int i = 0; i < model.players.size(); i++) {
            mapContainer.getChildren().add(model.players.get(i).sprite);
        }
    }

    /**
     * Drawina map'a is int[][] MAP
     * */
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
    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                    positionY += 20;
                    break;
                case KeyEvent.VK_UP:
                    positionY -= 20;
                    break;
                case KeyEvent.VK_LEFT:
                    positionX -= 20;
                    break;
                case KeyEvent.VK_RIGHT:
                    positionX += 20;
                    break;
            }
        }

        public void keyTyped(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
        }
    }

    /**
     * ??
     * */
    public void doTimer() {
//        long time = System.currentTimeMillis();
        update();
        for (int i = 0; i < model.players.size(); i++){
            PlayerVO player = model.players.get(i);
            player.sprite.setTranslateX(player.X);
            player.sprite.setTranslateY(player.Y);
        }
    }

    /**
     * lots of shit stuff inside.
     * */
    private void run() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addKeyListener(new AL());
        //showData(map);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setVisible(true);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                doTimer();
            }
        }, 0, 1000 / fps);

        // setVisible(false);
    }

    /**
     * lygtais naudojamas checkint Win condition'am ar panasiai, turi but imestas i RUN loop'a
     * */
    void update() {

    }

    /**
     * is map.txt suraso i int[][] MAP
     * */
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
     * */
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
