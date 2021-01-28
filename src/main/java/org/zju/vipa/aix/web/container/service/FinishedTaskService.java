package org.zju.vipa.aix.web.container.service;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zju.vipa.aix.container.common.db.entity.aix.FinishedTask;
import org.zju.vipa.aix.web.container.api.vo.FinishedTaskVO;
import org.zju.vipa.aix.web.container.db.mapper.FinishedTaskMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/1/24 13:47
 * @Author: EricMa
 * @Description:
 */
@Service
public class FinishedTaskService {
    private final FinishedTaskMapper finishedTaskMapper;

    @Autowired
    public FinishedTaskService(FinishedTaskMapper finishedTaskMapper) {
        this.finishedTaskMapper = finishedTaskMapper;
    }


    public Integer getFinishedTaskCount() {
        return finishedTaskMapper.selectCount(null);
    }

    public List<FinishedTaskVO> getFinishedTaskListByPage(int page, int countPerPage) {
        RowBounds rowBounds=new RowBounds((page-1)*countPerPage,countPerPage);
        List<FinishedTask> finishedTaskList = finishedTaskMapper.selectByPage(rowBounds);
        List<FinishedTaskVO> finishedTaskVOList=new ArrayList<>();
        for (FinishedTask task : finishedTaskList) {
            finishedTaskVOList.add(new FinishedTaskVO(task));
        }

        return finishedTaskVOList;
    }

    public boolean deleteById(String id) {
        return finishedTaskMapper.deleteByPrimaryKey(id)>0;
    }
}
