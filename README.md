# Apache Atlas HDFS hook

This client uses hadoop fs package to get the metadata of hdfs entities, then it inserts these metadata into Atlas instances.


## Quick start

### Get a dataframe of hdfs files metadata 
```scala
val hdfs_path="/HyperThesau/Bibracte/Bdb"
val df = spark.read.format("json").load(hdfs_path)
df.metadata.show(false)
```

## Prerequisites

This tool only requires Java 1.8 and spark 3.0.1

## Supported OS

Windows XP/7/8/10

Linux  

MacOS


## Authors

* **Pengfei Liu** 


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

