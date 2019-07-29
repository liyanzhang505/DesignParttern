package com.prototype;

public class ProtoTypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        LateComer xiaoming = new LateComer("xiaoming", 1);
        LateComer xiaozhang = (LateComer) xiaoming.clone();
        xiaozhang.setName("xiaozhang");
        
        xiaoming.printLateInfo();
        xiaozhang.printLateInfo();
    }
    
}


class LateComer implements Cloneable {
    
    private String name;
    private int lateLeverl;
    
    LateComer(String name, int lateLeverl) {
        this.name = name;
        this.lateLeverl = lateLeverl;
    }
    
    public void printLateInfo() {
        System.out.println("name: " + name + "late level:" + lateLeverl);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Object clone() throws CloneNotSupportedException {
        System.out.println("clone !");
        return (LateComer) super.clone();
    }

}