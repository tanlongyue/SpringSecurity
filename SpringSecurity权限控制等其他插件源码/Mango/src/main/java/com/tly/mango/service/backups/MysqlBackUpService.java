package com.tly.mango.service.backups;
/**
 * MySql命令行备份恢复服务
 * */
public interface MysqlBackUpService {

    /**
     * 备份数据库
     * */
    boolean backup(String host,String userName,String password,String backupFolderPath,String fileName,String database) throws Exception;

    /**
     * 恢复数据库
     * */
    boolean restore(String restoreFilePath,String host,String userName,String password,String database)throws Exception;
}
