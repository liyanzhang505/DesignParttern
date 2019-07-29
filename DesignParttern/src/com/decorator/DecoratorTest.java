package com.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        System.out.println("分到A部门之前:");
        Imployee xiaoming = new Coder();
        xiaoming.work();
        
        System.out.println("分到A部门之后:");
        xiaoming = new TeamA(xiaoming);
        xiaoming.work();
    }
}

interface Imployee {
    public void work();
}

class Coder implements Imployee {
    @Override
    public void work() {
        System.out.println("coding... ");
    }
}

abstract class ImployeeDecorator implements Imployee{
    Imployee imployee;

    ImployeeDecorator(Imployee imployee) {
        this.imployee = imployee;
    }

    @Override
    public void work() {
        imployee.work();
    }

}

class TeamA extends ImployeeDecorator{
    TeamA(Imployee imployee) {
        super(imployee);
    }

    public void work() {
        eat();
        super.work();
    }

    private void eat(){
        System.out.println("吃饱饭先...");
    }
}
