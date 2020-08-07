package com.tly.mango.service.backups.impl;

import com.tly.mango.service.backups.MysqlBackUpService;
import com.tly.mango.util.backup.MySqlBackUpRestoreUtils;
import org.springframework.stereotype.Service;

@Service
public class MysqlBackUpServiceImpl implements MysqlBackUpService {




    @Override
    public boolean backup(String host, String userName, String password, String backupFolderPath, String fileName,
                          String database) throws Exception {
        return MySqlBackUpRestoreUtils.backup(host, userName, password, backupFolderPath, fileName, database);
    }

    @Override
    public boolean restore(String restoreFilePath, String host, String userName, String password, String database)
            throws Exception {
        return MySqlBackUpRestoreUtils.restore(restoreFilePath, host, userName, password, database);
    }
}
