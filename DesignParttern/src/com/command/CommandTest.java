package com.command;

import java.util.ArrayList;
import java.util.List;

public class CommandTest {
    public static void main(String[] args) {
        Server server = new Server();
        WebFront webFront = new WebFront();

        Command getUsernameCommand = new GetUsernameCommand(server);
        System.out.println("get username command result: " + webFront.executeCommand(getUsernameCommand));

        Command getPasswordCommand = new GetPasswordCommand(server);
        System.out.println("get password command result: " + webFront.executeCommand(getPasswordCommand));

        MacroCommands getAllInfoCommands = new GetAllInfoCommands();
        getAllInfoCommands.add(getUsernameCommand);
        getAllInfoCommands.add(getPasswordCommand);

        System.out.println("get allInfo command result: " + webFront.executeCommand(getAllInfoCommands));

    }
}

// abstract command
interface  Command {
    public String execute();
}

// receiver
class Server {
    public String getUsername() {
        return "lyz";
    }

    public String getPassword() {
        return "123";
    }
}

// concreted command
class GetUsernameCommand implements  Command {
    private Server server;

    public GetUsernameCommand(Server server) {
        this.server = server;
    }

    @Override
    public String execute() {
       return  server.getUsername();
    }
}

// concreted command
class GetPasswordCommand implements  Command {
    private Server server;

    public GetPasswordCommand(Server server) {
        this.server = server;
    }

    @Override
    public String execute() {
        return  server.getPassword();
    }
}

// macro command
interface MacroCommands extends Command {
    public void add(Command command);
    public void remove(Command command);
}

class GetAllInfoCommands implements MacroCommands {
    private List<Command> commandList = new ArrayList<Command>();

    @Override
    public String execute() {
        StringBuffer result = new StringBuffer();
        for (Command o : commandList) {
            result.append(o.execute() + " ");
        }
        return result.toString();
    }

    @Override
    public void add(Command command) {
        commandList.add(command);
    }

    @Override
    public void remove(Command command) {
        commandList.remove(command);
    }
}

class WebFront {
   public String executeCommand(Command command) {
       return command.execute();
   }
}