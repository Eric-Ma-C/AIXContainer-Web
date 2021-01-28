package org.zju.vipa.aix.web.container.db.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.zju.vipa.aix.container.common.db.entity.aix.FinishedTask;
import org.zju.vipa.aix.container.common.db.entity.aix.KnownError;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Date: 2021/1/24 13:44
 * @Author: EricMa
 * @Description:
 */
@org.apache.ibatis.annotations.Mapper()
public interface FinishedTaskMapper extends Mapper<FinishedTask> {
    @Select("select * from finished_task")
    List<FinishedTask> selectByPage(RowBounds rowBounds);
}
