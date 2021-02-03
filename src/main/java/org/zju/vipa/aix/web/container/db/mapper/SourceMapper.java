package org.zju.vipa.aix.web.container.db.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.zju.vipa.aix.container.common.db.entity.aix.KnownError;
import org.zju.vipa.aix.container.common.db.entity.aix.Source;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Date: 2021/2/3 15:25
 * @Author: EricMa
 * @Description:
 */
@org.apache.ibatis.annotations.Mapper()
public interface SourceMapper extends Mapper<Source> {
    @Select("select * from source")
    List<Source> selectByPage(RowBounds rowBounds);
//    @Select("SELECT * FROM known_error WHERE name = #{name}")
//    KnownError findByName(@Param("name") String name);
//
//    @Insert("INSERT INTO known_error(name, key_words) VALUES(#{name}, #{key_words})")
//    int insert(@Param("name") String name, @Param("key_words") String key_words);
}
