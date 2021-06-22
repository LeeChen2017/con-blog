package org.licc.domain;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author licc
 * @date 2021/6/22
 */
public class AbstractDomain implements Serializable {

    /**
     * 唯一标识
     */
    @Id
    Long id;

    Date createTime;

    public void saveCreateTime(){
        this.createTime = new Date();
    }

}
