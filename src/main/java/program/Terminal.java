/**
 * Created by Xiaozhong on 2020/8/18.
 * Copyright (c) 2020/8/18 Xiaozhong. All rights reserved.
 */
package program;

import os.Computer;
import program.command.Command;
import util.Message;
import util.MessageCenter;
import util.MessageLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Terminal implements Runnable {

    private MessageCenter messageCenter = null;
    private Deque<Command> buffer;
    private Computer computer;
    private BufferedReader reader = null;

    public Terminal(MessageCenter messageCenter) {
        this.messageCenter = messageCenter;
        buffer = new ArrayDeque<>();
        messageCenter.addMessage(new Message(this, "", "", MessageLevel.TERMINAL));
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            try {
                messageCenter.addMessage(new Message(this, "", reader.readLine() + "\n", MessageLevel.TERMINAL));
                messageCenter.addMessage(new Message(this, "", "", MessageLevel.TERMINAL));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addCommand(Command command) {
        buffer.offerLast(command);
        notifyAll();
    }

    @Override
    public String toString() {
        return computer == null ? " $ > " : computer + " $ > ";
    }
}
