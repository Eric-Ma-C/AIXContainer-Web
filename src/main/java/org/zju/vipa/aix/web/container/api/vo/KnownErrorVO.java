package org.zju.vipa.aix.web.container.api.vo;

import org.zju.vipa.aix.container.common.db.entity.aix.KnownError;
import org.zju.vipa.aix.container.common.utils.JsonUtils;

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
    private String keyWords;
    private List<String> repairCmds;

    public KnownErrorVO(KnownError error) {
        id = error.getId();
        name = error.getName();
        keyWords = error.getKeyWords();
        List<String> list = JsonUtils.getList(error.getRepairCmds(), String.class);
        if (list != null) {
            repairCmds =list;
        }else {
            repairCmds =new ArrayList<>();
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


    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }


    public List<String> getRepairCmds() {
        return repairCmds;
    }

    public void setRepairCmds(List<String> repairCmds) {
        this.repairCmds = repairCmds;
    }
}
