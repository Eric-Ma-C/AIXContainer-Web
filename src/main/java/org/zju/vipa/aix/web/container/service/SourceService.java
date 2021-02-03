package org.zju.vipa.aix.web.container.service;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zju.vipa.aix.container.common.db.entity.aix.Source;
import org.zju.vipa.aix.web.container.api.vo.SourceVO;
import org.zju.vipa.aix.web.container.db.mapper.SourceMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/2/3 15:30
 * @Author: EricMa
 * @Description:
 */
@Service
public class SourceService {
    private final SourceMapper sourceMapper;

    @Autowired
    public SourceService(SourceMapper sourceMapper) {
        this.sourceMapper = sourceMapper;
    }


    public Integer getPipSourceCount() {
        Example example = new Example(Source.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("type", "PIP");
        return sourceMapper.selectCountByExample(example);
    }
    public Integer getAptSourceCount() {
        Example example = new Example(Source.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type", "APT");
        return sourceMapper.selectCountByExample(example);
    }

    public List<SourceVO> getPipSourceListByPage(int page, int countPerPage) {
        Example example = new Example(Source.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type", "PIP");
        return getSourceListByPageAndExample(example,page,countPerPage);
    }

    public List<SourceVO> getAptSourceListByPage(int page, int countPerPage) {
        Example example = new Example(Source.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type", "APT");
        return getSourceListByPageAndExample(example,page,countPerPage);
    }
    private List<SourceVO> getSourceListByPageAndExample(Example example,int page, int countPerPage) {
        RowBounds rowBounds = new RowBounds((page - 1) * countPerPage, countPerPage);

        List<Source> SourceList = sourceMapper.selectByExampleAndRowBounds(example,rowBounds);
        List<SourceVO> SourceVOList = new ArrayList<>();
        for (Source error : SourceList) {
            SourceVOList.add(new SourceVO(error));
        }

        return SourceVOList;
    }

//    public List<Source> getSourceList() {
//        List<Source> SourceList = sourceMapper.selectAll();
//        return SourceList;
//    }

    public boolean updateUrlById(String id, String url) {
        Source record = new Source();
        record.setId(Integer.valueOf(id));
        record.setUrl(url);
        return sourceMapper.updateByPrimaryKeySelective(record) > 0;
    }

    public boolean updateNameById(String id, String newName) {
        Source record = new Source();
        record.setId(Integer.valueOf(id));
        record.setName(newName);
        return sourceMapper.updateByPrimaryKeySelective(record) > 0;
    }


    public boolean insert(String name, String url, String type) {
        Source record = new Source();
        record.setName(name);
        record.setUrl(url);
        record.setType(type);
        return sourceMapper.insertSelective(record) > 0;
    }

    public boolean deleteById(String id) {
        return sourceMapper.deleteByPrimaryKey(id) > 0;
    }
}
