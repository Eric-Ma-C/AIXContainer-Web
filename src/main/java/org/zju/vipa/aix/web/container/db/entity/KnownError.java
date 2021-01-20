package org.zju.vipa.aix.web.container.db.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class KnownError implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String name;
    private String key_words;
    private String repair_cmds;

}
