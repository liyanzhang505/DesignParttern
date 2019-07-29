package com.adapter1;

public class AdapterTest {
    
    public void startActivity(TeamActivity activity) {
        activity.active();
    }
    
    public static void main(String[] args) {
        AdapterTest test = new AdapterTest();
        
        TeamActivity activity = new BasketballGameAdapter();
        test.startActivity(activity);
        
        activity = new FootballGameAdapter();
        test.startActivity(activity);
    }
}

interface TeamActivity {
    public void active();
}

class BasketballGame  {
    
    public void playBasketball() {
        System.out.println("play basketball.");
    }
    
}

class FootballGame  {
    
    public void playFootball() {
        System.out.println("play football.");
    }
    
}

// （类适配器方式）
class BasketballGameAdapter extends BasketballGame implements TeamActivity {
    @Override
    public void active() {
        super.playBasketball();
    }
}

// （对象适配器方式）
class FootballGameAdapter implements TeamActivity {
    private FootballGame  footballGame = new FootballGame();

    @Override
    public void active() {
        footballGame.playFootball();
    }
}