package org.licc.domain;

import org.springframework.data.relational.core.mapping.Column;

/**
 * @author licc
 * @date 2021/6/22
 */
public class User extends AbstractDomain{

    @Column("name")
    private String name;

    @Column("password")
    private String password;

    @Column("tel")
    private String tel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
