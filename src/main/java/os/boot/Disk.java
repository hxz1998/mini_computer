/**
 * Created by Xiaozhong on 2020/8/16.
 * Copyright (c) 2020/8/16 Xiaozhong. All rights reserved.
 */
package os.boot;

import java.util.LinkedList;

public class Disk implements Device {
    private static FileNode root;

    @Override
    public boolean install() {
        root = new FileNode("/", new LinkedList<>());
        return true;
    }

    @Override
    public boolean detach() {
        root = null;
        return true;
    }

    public static FileNode getRoot() {
        return root;
    }
}
