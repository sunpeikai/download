package com.sandman.download.dao.mysql.user;

import com.sandman.download.entity.user.DownloadRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunpeikai on 2018/5/14.
 */
@Repository
public interface DownloadRecordDao {
    public List<DownloadRecord> findAllByUserId(Long userId);
    public Long createDownloadRecord(DownloadRecord downloadRecord);
    public void deleteById(DownloadRecord downloadRecord);//假删
}
