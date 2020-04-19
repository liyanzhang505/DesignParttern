package com.strategy;

public class StrategyTest {
    public static void main(String[] args) {
        Context context = new Context();
        Strategy strategy = new StrategyA();
        context.setStrategy(strategy);
        System.out.println("do strategy A: " + context.doStrategy(5, 3));

        strategy = new StrategyB();
        context.setStrategy(strategy);
        System.out.println("do strategy B: " + context.doStrategy(5, 3));
    }
}

interface Strategy {
    public int doStrategy(int a, int b);
}

class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int doStrategy(int a, int b) {
      return strategy.doStrategy(a, b);
    }
}

class StrategyA implements Strategy {
    @Override
    public int doStrategy(int a, int b) {
        return a + b;
    }
}

class StrategyB implements Strategy {
    @Override
    public int doStrategy(int a, int b) {
        return a - b;
    }
}