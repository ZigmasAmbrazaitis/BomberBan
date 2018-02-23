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
    public ArrayList<BombVO> bombs;
    public ArrayList<FlameVO> flames;

    /**
     * Kuria players arraylist. ima is PlayerVO
     */
    public Model() {
        players = new ArrayList<PlayerVO>();
        for (int i = 0; i < 5; i++) { //vietoje 5 turi atsiusti i serva uzklausima kad sukurti nauja playeri
            PlayerVO player = new PlayerVO();
            players.add(player);
        }
        bombs = new ArrayList<BombVO>();
        for (int i = 0; i < 5; i++) { //vietoje 5 turi atsiusti i serva uzklausima kad sukurti nauja playeri
            BombVO bomb = new BombVO();
            bombs.add(bomb);
        }
    }

}
