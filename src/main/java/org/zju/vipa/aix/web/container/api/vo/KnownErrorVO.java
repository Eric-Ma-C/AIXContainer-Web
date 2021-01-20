package org.zju.vipa.aix.web.container.api.vo;

import org.zju.vipa.aix.container.common.utils.JsonUtils;
import org.zju.vipa.aix.web.container.db.entity.KnownError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/1/19 14:58
 * @Author: EricMa
 * @Description:
 */
public class KnownErrorVO implements Serializable {
    private long id;
    private String name;
    private String key_words;
    private List<String> repair_cmds;

    public KnownErrorVO(KnownError error) {
        id = error.getId();
        name = error.getName();
        key_words = error.getKey_words();
        List<String> list = JsonUtils.getList(error.getRepair_cmds(), String.class);
        if (list != null) {
            repair_cmds=list;
        }else {
            repair_cmds=new ArrayList<>();
//            repair_cmds.add("");
        }

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getKey_words() {
        return key_words;
    }

    public void setKey_words(String key_words) {
        this.key_words = key_words;
    }


    public List<String> getRepair_cmds() {
        return repair_cmds;
    }

    public void setRepair_cmds(List<String> repair_cmds) {
        this.repair_cmds = repair_cmds;
    }
}
