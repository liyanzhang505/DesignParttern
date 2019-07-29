package com.bridge;

public class BridgeTest {
    public static void main(String[] args) {
        Color color = new YellowColor();
        Bag bag;
        bag = new HandBag();
        bag.setColor(color);
        String name = bag.getName();
        System.out.println(name);
    }

}

abstract class Bag {
    Color color;

    public void setColor (Color color)
    {
        this.color = color;
    }
    
    public abstract String getName();
}

interface Color {
    public String getColor();
}


class YellowColor implements Color {
    @Override
    public String getColor() {
        return "Yellow";
    }
}

class RedColor implements Color {
    @Override
    public String getColor() {
        return "Red";
    }
}

class HandBag extends Bag {
    @Override
    public String getName() {
        return color.getColor() + " hand bag...";
    }
}

class ShoulderBag extends Bag {
    @Override
    public String getName() {
        return color.getColor() + " shoulder bag...";
    }
}