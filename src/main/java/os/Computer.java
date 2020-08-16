/**
 * Created by Xiaozhong on 2020/8/16.
 * Copyright (c) 2020/8/16 Xiaozhong. All rights reserved.
 */
package os;

import util.Message;
import util.MessageCenter;
import util.MessageLevel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Computer implements Bootable {
    private final String name;
    private final Hardware hardware;
    private MessageCenter messageCenter;
    private ExecutorService messageService;

    public Computer(String name, Hardware hardware, MessageCenter messageCenter) {
        this.name = name;
        this.hardware = hardware;
        this.messageCenter = messageCenter;
        messageService = Executors.newSingleThreadExecutor();
        messageService.submit(messageCenter);
    }

    public void setMessageCenter(MessageCenter messageCenter) {
        this.messageCenter = messageCenter;
    }

    @Override
    public boolean start() {
        if (boot()) {
            messageCenter.addMessage(new Message(this, "Boot", "start os...", MessageLevel.WARNING));
            return true;
        } else {
            System.out.println(this + " start error!");
            return false;
        }
    }

    @Override
    public String toString() {
        return "[ Computer: " + name + " ]";
    }

    @Override
    public boolean boot() {
        messageCenter.addMessage(new Message(this, "Boot", "boot os...", MessageLevel.WARNING));
        return hardware.checkHardware();
    }

    @Override
    public void shutdown() {
        messageCenter.addMessage(new Message(this, "Shutdown", "shutdown os...", MessageLevel.WARNING));
        messageCenter.prepareToShutdown();
        messageService.shutdown();
    }

    public static void main(String[] args) {
        Hardware hardware = new Hardware();
        MessageCenter messageCenter = new MessageCenter();
        Computer computer = new Computer("cherry", hardware, messageCenter);
        computer.start();
        computer.shutdown();
    }
}
