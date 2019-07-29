package com.factory.simple_factory;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        GameFactory fac = new GameFactory();
        ShootGame shootGame = (ShootGame) fac.createGame("shoot"); 
        shootGame.setPlayer("xiaozhang");
        shootGame.setScore(10);
    }
}

interface Game {
    void setPlayer(String player);
}

class ShootGame implements Game {
    private String player;
    private int score;
    
    @Override
    public void setPlayer(String player) {
        this.player = player;
        System.out.println("shoot game player:" + player);  
    }
    
    public void setScore(int score) {
        this.score = score;
        System.out.println(player + " shoot game set score " + score);  
    }
}

class TowerDefenceGame implements Game {

    @Override
    public void setPlayer(String player) {
        System.out.println("tower defence game player:" + player);
        
    }
}

class GameFactory {
    
    public Game createGame(String gameType) {
        if (gameType.equals("shoot")){
            return new ShootGame();
        }
        else if (gameType.equals("tower")){
            return new TowerDefenceGame();
        }
        else {
           return null;
        }
    }
}



