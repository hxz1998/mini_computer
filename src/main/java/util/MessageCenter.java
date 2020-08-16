/**
 * Created by Xiaozhong on 2020/8/16.
 * Copyright (c) 2020/8/16 Xiaozhong. All rights reserved.
 */
package util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MessageCenter implements Runnable {
    private final static Deque<Message> buffer = new ArrayDeque<>();
    private boolean stop = false;

    @Override
    public synchronized void run() {
        while (true) {
            if (stop) break;
            if (!buffer.isEmpty()) {
                Message message = buffer.pollFirst();
                System.out.println(message);
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void addMessage(Message message) {
        buffer.push(message);
        notifyAll();
    }

    public synchronized boolean prepareToShutdown() {
        while (!buffer.isEmpty()) {
            System.out.println(buffer.pollFirst());
        }
        stop = true;
        notifyAll();
        return true;
    }
}
