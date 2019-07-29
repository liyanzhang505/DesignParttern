package com.factory.normal_factory;

public class FactoryTest {

    public static void main(String[] args) {
        ShootGameFactory shootGameFactory = new ShootGameFactory();
        ShootGame shootGame1 = (ShootGame)shootGameFactory.createGame();
        shootGame1.setPlayer("xiaozhang");
        shootGame1.setScore(100);
        
        ShootGame shootGame2 = (ShootGame)shootGameFactory.createGame();
        shootGame2.setPlayer("xiaowang");
        shootGame2.setScore(99);
        
        
        TowerDefenceGameFactory towerDefenceGameFactory = new TowerDefenceGameFactory();
        TowerDefenceGame towerDefenceGame = (TowerDefenceGame)towerDefenceGameFactory.createGame();
        towerDefenceGame.setPlayer("xiaoming");
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
    private String player;

    @Override
    public void setPlayer(String player) {
        this.player = player;
        System.out.println("tower defence game player:" + player);
    }
}

interface GameFactory {
    public Game createGame();
}

class ShootGameFactory implements GameFactory {

    @Override
    public Game createGame() {
        return new ShootGame();
    } 
}

class TowerDefenceGameFactory implements GameFactory {

    @Override
    public Game createGame() {
        return new TowerDefenceGame();
    } 
}