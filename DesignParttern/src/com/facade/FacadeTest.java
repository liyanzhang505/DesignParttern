package com.facade;

public class FacadeTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
        computer.shutDown();
    }
}

class Computer {
    private CPU cpu;
    private HardDisk hardDisk;
    private Display display;

    Computer(){
        cpu = new CPU();
        hardDisk = new HardDisk();
        display = new Display();
    }

    public void start() {
        cpu.start();
        hardDisk.start();
        display.start();
    }

    public void shutDown() {
        cpu.shutDown();
        hardDisk.shutDown();
        display.shutDown();
    }
}

class CPU {
    public void start() {
        System.out.println("CUP start work...");
    }
    
    public void shutDown() {
        System.out.println("cpu shut down...");
    }
}

class HardDisk {
    public void start() {
        System.out.println("Hard disk start work...");
    }
    
    public void shutDown() {
        System.out.println("Hard disk shut down...");
    }
}

class Display {
    public void start() {
        System.out.println("Display start work...");
    }
    
    public void shutDown() {
        System.out.println("Display shut down...");
    }
}
