package com.state;

import com.sun.org.apache.xml.internal.security.Init;
import sun.nio.ch.Net;

public class StateTest {

    public static void main(String[] args) {
        NetMachine netMachine = new NetMachine();
        System.out.println("============================");
        System.out.println("first state: " + netMachine.getState());
        netMachine.sendData("123");

        System.out.println("============================");
        netMachine.connect();
        System.out.println("second state: " + netMachine.getState());
        netMachine.sendData("123");

        System.out.println("============================");
        netMachine.reconnect();

        System.out.println("============================");
        netMachine.disconnect();
        System.out.println("Third state: " + netMachine.getState());
    }
}


interface State {
    public void connect();
    public void sendData(String data);
    public void disconnect();
    public void reconnect();
}

class NetMachine {
    ConnectedState connectedState;
    DisconnectedState disconnectedState;

    State state;

    NetMachine() {
        connectedState = new ConnectedState(this);
        disconnectedState = new DisconnectedState(this);
        state = disconnectedState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void connect() {
        state.connect();
    }

    public void sendData(String data) {
        state.sendData(data);
    }

    public void disconnect() {
        state.disconnect();
    }

    public void reconnect() {
        state.reconnect();
    }
}

class DisconnectedState implements State {
    private NetMachine netMachine;

    DisconnectedState(NetMachine netMachine) {
        this.netMachine = netMachine;
    }

    @Override
    public void connect() {
        System.out.println("start connect server...");
        System.out.println("connect server success!");
        netMachine.setState(netMachine.connectedState);
    }

    @Override
    public void sendData(String data) {
        System.out.println("Has not connect to server, cannot send data!");
    }

    @Override
    public void disconnect() {
        System.out.println("Has already disconnected.");
    }

    @Override
    public void reconnect() {
        connect();
    }

    @Override
    public String toString() {
        return "DisconnectedState";
    }
}

class ConnectedState implements State {
    private NetMachine netMachine;

    ConnectedState(NetMachine netMachine) {
        this.netMachine = netMachine;
    }

    @Override
    public void connect() {
        System.out.println("Has already connected.");
    }

    @Override
    public void sendData(String data) {
        System.out.println(String.format("send data %s ok!", data));
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnect...");
        System.out.println("Disconnect network success.");
        netMachine.setState(netMachine.disconnectedState);
    }

    @Override
    public void reconnect() {
        disconnect();
        netMachine.connect();
    }

    @Override
    public String toString() {
        return "ConnectedState";
    }
}



