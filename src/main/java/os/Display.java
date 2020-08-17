/**
 * Created by Xiaozhong on 2020/8/16.
 * Copyright (c) 2020/8/16 Xiaozhong. All rights reserved.
 */
package os;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Display implements Device {
    private JTextArea textArea;
    private JTextField textField;
    private JFrame frame;
    @Override
    public boolean install() {
        frame = new JFrame("Displayer");
        this.textArea = new JTextArea();
        textArea.setEditable(false);
        this.textField = new JTextField();
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add("Center", textArea);
        frame.getContentPane().add("South", textField);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        return true;
    }

    @Override
    public boolean detach() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        return true;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }
}
