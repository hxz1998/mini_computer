/**
 * Created by Xiaozhong on 2020/8/16.
 * Copyright (c) 2020/8/16 Xiaozhong. All rights reserved.
 */
package os;

import program.Terminal;
import util.Message;
import util.MessageCenter;

public class Kernel implements Bootable {
    private final Hardware hardware;
    private final MessageCenter messageCenter;
    private final double version = 0.1;
    private Terminal terminal;
    private Computer computer;

    public Kernel(Hardware hardware, Computer computer, MessageCenter messageCenter) {
        this.hardware = hardware;
        this.messageCenter = messageCenter;
    }

    public Kernel(Hardware hardware, MessageCenter messageCenter) {
        this.hardware = hardware;
        this.messageCenter = messageCenter;
    }


    @Override
    public boolean start() {
        return boot();
    }

    @Override
    public boolean boot() {
        messageCenter.addMessage(new Message(this, "Kernel", "boot kernel..."));
        return true;
    }

    @Override
    public void shutdown() {
        hardware.detach();
        messageCenter.addMessage(new Message(this, "Kernel", "detach hardware successfully..."));
    }

    @Override
    public String toString() {
        return "[ Kernel Mini-Computer " + version + " ] ";
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public Computer getComputer() {
        return computer;
    }
}
