/**
 * Created by Xiaozhong on 2020/8/16.
 * Copyright (c) 2020/8/16 Xiaozhong. All rights reserved.
 */
package os;

public interface Bootable {
    boolean start();

    boolean boot();

    void shutdown();
}
