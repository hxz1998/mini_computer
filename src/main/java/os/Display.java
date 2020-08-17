/**
 * Created by Xiaozhong on 2020/8/16.
 * Copyright (c) 2020/8/16 Xiaozhong. All rights reserved.
 */
package os;

public class Display implements Device {
    @Override
    public boolean install() {
        return true;
    }

    @Override
    public boolean detach() {
        return true;
    }
}
