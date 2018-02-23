package client.model;

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

    public Model(){
        players = new ArrayList<PlayerVO>();
        for (int i = 0; i<5; i++){ //vietoje 5 turi atsiusti i serva uzklausima kad sukurti nauja playeri
            PlayerVO player = new PlayerVO();
            players.add(player);
        }
    }

}
