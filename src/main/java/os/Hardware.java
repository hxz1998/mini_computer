/**
 * Created by Xiaozhong on 2020/8/16.
 * Copyright (c) 2020/8/16 Xiaozhong. All rights reserved.
 */
package os;

public class Hardware implements Device{
    private Disk disk;
    private Display display;
    private Keyboard keyboard;

    public Hardware() {
        this.display = new Display();
        this.keyboard = new Keyboard();
        this.disk = new Disk();
    }

    public Hardware(Disk disk, Display display, Keyboard keyboard) {
        this.disk = disk;
        this.display = display;
        this.keyboard = keyboard;
    }

    public boolean checkHardware() {
        return disk != null && display != null && keyboard != null;
    }

    @Override
    public boolean install() {
        return true;
    }

    @Override
    public boolean detach() {
        return true;
    }
}
