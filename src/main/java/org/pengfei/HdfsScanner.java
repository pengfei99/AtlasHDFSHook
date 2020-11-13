package org.pengfei;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class HdfsScanner {
    private final Configuration conf;


    public HdfsScanner(Configuration conf) {
        this.conf = conf;
    }

    public List<HdfsMetadata> generateMetadata(String nameNodeUri, String filePath) {
        List<HdfsMetadata> result = new LinkedList<>();
        HdfsMetadataClient metadataClient = null;
        try {
            metadataClient = new HdfsMetadataClient(nameNodeUri,this.conf);
        } catch (IOException e) {
            System.out.println("Can not connect to the name node server "+e.toString());
        }
        List<FileStatus> fileStatusList = null;
        try {
            fileStatusList = metadataClient.getFileStatus(filePath,true);
        } catch (IOException e) {
            System.out.println("Can not find given path "+e.toString());
        }
        for(FileStatus fileStatus:fileStatusList){
            result.add(metadataClient.getMetadata(fileStatus));
        }
      return result;
    }
}