package org.example.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 公共实体类型
 * @author licc
 * @date 2021/05/08
 */
public class AbstractEntity implements Serializable {

    /**
     * Id
     */
    private Long id;

    /**
     * 最后更新人
     */
    private String lastModifiedBy;

    /**
     * 最后更新时间
     */

    private Date lastModifiedDate;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date creationTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
