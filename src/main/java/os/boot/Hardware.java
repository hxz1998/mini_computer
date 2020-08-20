/**
 * Created by Xiaozhong on 2020/8/16.
 * Copyright (c) 2020/8/16 Xiaozhong. All rights reserved.
 */
package os.boot;

public class Hardware implements Device {
    private Disk disk;
    private Display display;
    private Keyboard keyboard;

    public Hardware() {
        this.display = new Display();
        this.keyboard = new Keyboard();
        this.disk = new Disk();
        install();
    }

    public Hardware(Disk disk, Display display, Keyboard keyboard) {
        this.disk = disk;
        this.display = display;
        this.keyboard = keyboard;
        install();
    }

    public boolean checkHardware() {
        return disk != null && display != null && keyboard != null;
    }

    @Override
    public boolean install() {
        disk.install();
//        display.install();
        keyboard.install();
        return true;
    }

    @Override
    public boolean detach() {
        disk.detach();
        display.detach();
        keyboard.detach();
        return true;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
}
