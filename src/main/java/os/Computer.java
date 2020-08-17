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
    private Kernel kernel = null;
    private MessageCenter messageCenter;
    private ExecutorService messageService;
    private Hardware hardware;

    public Computer(String name, MessageCenter messageCenter, Hardware hardware) {
        this.name = name;
        this.messageCenter = messageCenter;
        messageService = Executors.newSingleThreadExecutor();
        this.hardware = hardware;
    }

    public Kernel getKernel() {
        return kernel;
    }

    public void setKernel(Kernel kernel) {
        this.kernel = kernel;
    }

    public void setMessageCenter(MessageCenter messageCenter) {
        this.messageCenter = messageCenter;
    }

    @Override
    public boolean start() {
        if (boot()) {
            messageCenter.addMessage(new Message(this, "Start", "start os..."));
            messageService.submit(messageCenter);
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
        messageCenter.addMessage(new Message(this, "Boot", "boot os..."));
        return kernel.boot();
    }

    @Override
    public void shutdown() {
        messageCenter.addMessage(new Message(this, "Shutdown", "shutdown os...", MessageLevel.WARNING));
        kernel.shutdown();
        messageCenter.prepareToShutdown();
        messageService.shutdown();
    }

    public static void main(String[] args) {
        Hardware hardware = new Hardware();
        MessageCenter messageCenter = new MessageCenter();
        messageCenter.setWindows(hardware.getDisplay().getTextArea());
        Kernel kernel = new Kernel(hardware, messageCenter);
        Computer computer = new Computer("cherry", messageCenter, hardware);
        computer.setKernel(kernel);
        computer.start();
        computer.shutdown();
    }
}
