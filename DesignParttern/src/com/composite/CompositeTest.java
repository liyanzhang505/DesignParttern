package com.composite;

import java.util.ArrayList;

public class CompositeTest {
    public static void main(String[] args) {
        Bags bags1 = new Bags(BagSize.BIG);
        Things hongmiPhone = new Goods("hongmi", 499, 2);
        bags1.add(hongmiPhone);

        Bags bags2 = new Bags(BagSize.MIDDLE);
        Things wallet = new Goods("wallet", 1000, 1);
        bags2.add(wallet);

        Bags bags3 = new Bags(BagSize.MINI);
        Things pencll = new Goods("pencll", 1, 3);
        bags3.add(pencll);

        bags1.add(bags2);
        bags2.add(bags3);

        System.out.println("您的物品有：");
        bags1.show();
        float payment = bags1.calc();
        System.out.println("总额：" + payment);
    }
}

enum BagSize {
    BIG("Big bag"),
    MIDDLE("Middle bag"),
    MINI("Mini bag");

    private String bagSize;
    BagSize(String bagSize) {
        this.bagSize = bagSize;
    }

    @Override
    public String toString() {
        return bagSize;
    }
}

interface Things {
    public void show();
    public float calc();
}

class Goods implements Things {
    private String name;
    private float unitPrice;
    private int quantity;

    Goods(String name, float unitPrice, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    @Override
    public void show() {
        System.out.println(String.format("物品名称:%s, 单价:%s, 数量：%d", name, unitPrice, quantity));
    }

    @Override
    public float calc() {
        return unitPrice * quantity;
    }
}

class Bags implements Things {
    private BagSize bagSize;
    private ArrayList<Things> bags = new ArrayList<Things>();

    Bags(BagSize bagSize) {
        this.bagSize = bagSize;
    }

    public void add(Things t) {
        bags.add(t);
    }

    public void remove(Things t) {
        bags.remove(t);
    }

    @Override
    public void show() {
        System.out.println(bagSize);
        for(Things thing: bags) {
            thing.show();
        }
    }

    @Override
    public float calc() {
        float s = 0;
        for(Things thing: bags) {
            s += thing.calc();
        }
        return s;
    }
}