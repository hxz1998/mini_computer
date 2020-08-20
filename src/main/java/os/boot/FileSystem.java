/**
 * Created by Xiaozhong on 2020/8/18.
 * Copyright (c) 2020/8/18 Xiaozhong. All rights reserved.
 */
package os.boot;

import java.util.LinkedList;

public class FileSystem {
    private FileNode currentFileNode = Disk.getRoot();

    public void create(String filename, String content) {
        String[] files = filename.split("/");
        currentFileNode.addFileNode(new FileNode(files[files.length - 1], content));
    }

    public void create(String filename, LinkedList<FileNode> subDir) {

    }

    public String ls() {
        return currentFileNode.getSubDir().toString();
    }

    public void cd(String filename) {
        currentFileNode = currentFileNode.getSubDir().get(0);
    }
}
