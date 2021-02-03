package org.zju.vipa.aix.web.container.api.vo;

import org.zju.vipa.aix.container.common.db.entity.aix.Source;

/**
 * @Date: 2021/2/3 15:36
 * @Author: EricMa
 * @Description:
 */
public class SourceVO {
    private Integer id;
    private String type;
    private String name;
    private String url;

    public SourceVO(Source source) {
        id = source.getId();
        type = source.getType();
        name = source.getName();
        url = source.getUrl();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
