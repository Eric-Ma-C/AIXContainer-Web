package org.zju.vipa.aix.web.container.service;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zju.vipa.aix.container.api.entity.AixDeviceVO;
import org.zju.vipa.aix.container.common.db.entity.aix.KnownError;
import org.zju.vipa.aix.container.common.db.entity.atlas.AixDevice;
import org.zju.vipa.aix.web.container.api.vo.KnownErrorVO;
import org.zju.vipa.aix.web.container.db.mapper.KnownErrorMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/1/19 14:41
 * @Author: EricMa
 * @Description: KnownError业务代码
 */
@Service
public class KnownErrorService {
    private final KnownErrorMapper knownErrorMapper;

    @Autowired
    public KnownErrorService(KnownErrorMapper knownErrorMapper) {
        this.knownErrorMapper = knownErrorMapper;
    }


    public Integer getKnownErrorCount() {
        return knownErrorMapper.selectCount(null);
    }

    public List<KnownErrorVO> getKnownErrorListByPage(int page, int countPerPage) {
        RowBounds rowBounds=new RowBounds((page-1)*countPerPage,countPerPage);
        List<KnownError> knownErrorList = knownErrorMapper.selectByPage(rowBounds);
        List<KnownErrorVO> knownErrorVOList=new ArrayList<>();
        for (KnownError error : knownErrorList) {
            knownErrorVOList.add(new KnownErrorVO(error));
        }

        return knownErrorVOList;
    }

    public List<KnownError> getKnownErrorList() {
        List<KnownError> knownErrorList = knownErrorMapper.selectAll();
        return knownErrorList;
    }

    public boolean updateKeywordsById(String id, String keywords) {
        KnownError record=new KnownError();
        record.setId(Integer.valueOf(id));
        record.setKeyWords(keywords);
        return knownErrorMapper.updateByPrimaryKeySelective(record)>0;

    }

    public boolean updateNameById(String id, String newName) {
        KnownError record=new KnownError();
        record.setId(Integer.valueOf(id));
        record.setName(newName);
        return knownErrorMapper.updateByPrimaryKeySelective(record)>0;
    }

    public boolean updateRepairCmdsById(String id, String repairCmds) {
        KnownError record=new KnownError();
        record.setId(Integer.valueOf(id));
        record.setRepairCmds(repairCmds);
        return knownErrorMapper.updateByPrimaryKeySelective(record)>0;

    }

    public boolean insert(String name, String keywords, String repairCmds) {
        KnownError record=new KnownError();
        record.setName(name);
        record.setKeyWords(keywords);
        record.setRepairCmds(repairCmds);
        return knownErrorMapper.insertSelective(record)>0;
    }

    public boolean deleteById(String id) {
        return knownErrorMapper.deleteByPrimaryKey(id)>0;
    }
}
