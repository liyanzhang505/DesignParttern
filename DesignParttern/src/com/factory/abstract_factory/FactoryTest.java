package com.factory.abstract_factory;

public class FactoryTest {

    public static void main(String[] args) {

        ShootGameFactory shootGameFactory =  new ShootGameFactory();
        SinglePlayerShootGame singlePlayerShootGame = (SinglePlayerShootGame)shootGameFactory.createSinglePlayerGame();
        singlePlayerShootGame.setAccount("account1");
        singlePlayerShootGame.setlayer("xiaohua");
        
        DoublePlayerShootGame doublePlayerShootGame = (DoublePlayerShootGame)shootGameFactory.createDoublePlayerGame();
        doublePlayerShootGame.setAccount("account2");
        doublePlayerShootGame.setlayer("xiaozhang", "xiaoming");
        
        
    }

}

interface Game {
    void setAccount(String account);
}

abstract class ShootGame implements Game {
    private String account;

    @Override
    public void setAccount(String account) {
        this.account = account;
        System.out.println("shoot game account:" + account);  
    }

}

abstract class TowerDefenceGame implements Game {
    private String account;

    @Override
    public void setAccount(String account) {
        this.account = account;
        System.out.println("tower defence game account:" + account);
    }
}

class SinglePlayerShootGame extends ShootGame {
    public void setlayer(String player) {
        System.out.println(player + " play single shoot game.");
    }
}

class DoublePlayerShootGame extends ShootGame {
    public void setlayer(String player1, String player2) {
        System.out.println(player1 + " and " + player2 + " play double shoot game");
    }
}

class SinglePlayerTowerDefenceGame extends ShootGame {
    public void setlayer(String player) {
        System.out.println(player + " play single towerdefence game");
    }
}

class DoublePlayerTowerDefenceGame extends ShootGame {
    public void setlayer(String player1, String player2) {
        System.out.println(player1 + " and " + player2 + " play double towerdefence game");
    }
}

interface GameFactory {
    public Game createSinglePlayerGame();
    public Game createDoublePlayerGame();
}

class ShootGameFactory implements GameFactory {

    @Override
    public Game createSinglePlayerGame() {
        return new SinglePlayerShootGame();
    } 
    
    @Override
    public Game createDoublePlayerGame() {
        return new DoublePlayerShootGame();
    } 
}

class TowerDefenceGameFactory implements GameFactory {

    @Override
    public Game createSinglePlayerGame() {
        return new SinglePlayerTowerDefenceGame();
    } 
    
    @Override
    public Game createDoublePlayerGame() {
        return new DoublePlayerTowerDefenceGame();
    } 
}