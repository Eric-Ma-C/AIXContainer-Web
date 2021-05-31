package org.zju.vipa.aix.web.container;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.zju.vipa.aix.container.common.db.entity.aix.KnownError;
import org.zju.vipa.aix.web.container.db.mapper.KnownErrorMapper;
import org.junit.Test;

/**
 * @Date: 2021/1/18 15:25
 * @Author: EricMa
 * @Description:
 */
//@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDb {
    @Autowired
    private KnownErrorMapper knownErrorMapper;

    @Test
    @Rollback
    public void test() throws Exception {
        KnownError record=new KnownError();
        record.setId(5);
        record.setName("HTTP4_RETRY");
        knownErrorMapper.updateByPrimaryKeySelective(record);

//        knownErrorMapper.insert(record);
//        KnownError error = knownErrorMapper.findByName("AAA");

//        Assert.assertEquals(20, error.getId());
    }
}
