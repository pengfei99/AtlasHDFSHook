package org.pengfei;

public class HdfsMetadata {
    private final String path;
    private final Boolean isDirectory;
    private final String length;
    private final int replication;
    private final String blockSize;
    private final String modificationTime;
    private final String accessTime;
    private final String owner;
    private final String group;
    private final String permission;
    private final boolean isSymlink;

    public HdfsMetadata(String path, Boolean isDirectory, String length, int replication, String blockSize,
                        String modificationTime, String accessTime, String owner, String group, String permission,
                        boolean isSymlink) {
        this.path = path;
        this.isDirectory = isDirectory;
        this.length = length;
        this.replication = replication;
        this.blockSize = blockSize;
        this.modificationTime = modificationTime;
        this.accessTime = accessTime;
        this.owner = owner;
        this.group = group;
        this.permission = permission;
        this.isSymlink = isSymlink;
    }

    public String getPath() {
        return path;
    }

    public Boolean getDirectory() {
        return isDirectory;
    }

    public String getLength() {
        return length;
    }

    public int getReplication() {
        return replication;
    }

    public String getBlockSize() {
        return blockSize;
    }

    public String getModificationTime() {
        return modificationTime;
    }

    public String getAccessTime() {
        return accessTime;
    }

    public String getOwner() {
        return owner;
    }

    public String getGroup() {
        return group;
    }

    public String getPermission() {
        return permission;
    }

    public boolean isSymlink() {
        return isSymlink;
    }
}
