package client.model;

import client.model.vo.BombVO;
import client.model.vo.FlameVO;
import client.model.vo.PlayerVO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Model {

    public ArrayList<PlayerVO> players;
    public int Player=5;
    public int bombsOnScreen=0;
    public ArrayList<BombVO> bombs;
    public ArrayList<FlameVO> flames;
   // BombVO bomb = new BombVO();
    /**
     * Kuria players arraylist. ima is PlayerVO
     */
    public Model() {
        players = new ArrayList<PlayerVO>();
        bombs = new ArrayList<BombVO>();
        PlayerVO player = new PlayerVO();
        players.add(player);
        }

    public void createBombs() {
        BombVO bomb = new BombVO();
        bombs.add(bomb);
        bomb.X=players.get(0).X;
        bomb.Y=players.get(0).Y;
    }
    public void createPlayer() {
        PlayerVO player = new PlayerVO();
        players.add(player);
        player.X=Math.random()*500;
        player.Y=Math.random()*500;
    }
}


