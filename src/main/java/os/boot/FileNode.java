/**
 * Created by Xiaozhong on 2020/8/18.
 * Copyright (c) 2020/8/18 Xiaozhong. All rights reserved.
 */
package os.boot;

import java.util.LinkedList;

public class FileNode {
    private boolean isDir = false;
    private String filename;
    private String content;
    private LinkedList<FileNode> subDir;

    public FileNode(String filename, String content) {
        this.filename = filename;
        this.content = content;
    }

    public FileNode(String filename, LinkedList<FileNode> subDir) {
        this.isDir = true;
        this.filename = filename;
        this.subDir = subDir;
    }

    public boolean isDir() {
        return isDir;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LinkedList<FileNode> getSubDir() {
        return subDir;
    }

    public void setSubDir(LinkedList<FileNode> subDir) {
        this.subDir = subDir;
    }

    public void addFileNode(FileNode fileNode) {
        this.subDir.add(fileNode);
    }
}
