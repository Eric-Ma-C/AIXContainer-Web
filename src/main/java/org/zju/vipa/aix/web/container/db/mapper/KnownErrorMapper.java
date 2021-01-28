package org.zju.vipa.aix.web.container.db.mapper;

import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.zju.vipa.aix.container.common.db.entity.aix.KnownError;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Date: 2021/1/18 15:06
 * @Author: EricMa
 * @Description:
 */

//@Component(value = "knownErrorMapper")
@org.apache.ibatis.annotations.Mapper()
public interface KnownErrorMapper extends Mapper<KnownError> {
    @Select("select * from known_error")
    List<KnownError> selectByPage(RowBounds rowBounds);
//    @Select("SELECT * FROM known_error WHERE name = #{name}")
//    KnownError findByName(@Param("name") String name);
//
//    @Insert("INSERT INTO known_error(name, key_words) VALUES(#{name}, #{key_words})")
//    int insert(@Param("name") String name, @Param("key_words") String key_words);
}
