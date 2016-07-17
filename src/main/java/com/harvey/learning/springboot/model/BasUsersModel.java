package com.harvey.learning.springboot.model;

/**
 * Created by harvey on 16/7/17.
 */

import com.harvey.common.core.model.BaseModelClass;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Model class for BAS_USERS
 * 用户表
 */
@Entity
@Table(name = "BAS_USERS")
@DynamicInsert
@DynamicUpdate
public class BasUsersModel extends BaseModelClass implements Serializable {

    private static final long serialVersionUID = 1L;



    /** USERS_ID
     *
     */
    private java.lang.String usersId;

    @Column(name = "USERS_ID")
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy="org.hibernate.id.UUIDGenerator")
    public java.lang.String getUsersId(){
        return this.usersId;
    }

    public void setUsersId(java.lang.String usersId){
        this.usersId = usersId;
        super.addValidField("usersId");
    }




    /** USER_NAME
     *姓名
     */
    private java.lang.String userName;

    @Column(name = "USER_NAME")
    public java.lang.String getUserName(){
        return this.userName;
    }

    public void setUserName(java.lang.String userName){
        this.userName = userName;
        super.addValidField("userName");
    }



    /** EMAIL
     *邮箱
     */
    private java.lang.String email;

    @Column(name = "EMAIL")
    public java.lang.String getEmail(){
        return this.email;
    }

    public void setEmail(java.lang.String email){
        this.email = email;
        super.addValidField("email");
    }


    /** PASSWORD
     *密码
     */
    private java.lang.String password;

    @Column(name = "PASSWORD")
    public java.lang.String getPassword(){
        return this.password;
    }

    public void setPassword(java.lang.String password){
        this.password = password;
        super.addValidField("password");
    }



    /** STATUS
     *状态
     */
    private java.lang.String status;

    @Column(name = "STATUS")
    public java.lang.String getStatus(){
        return this.status;
    }

    public void setStatus(java.lang.String status){
        this.status = status;
        super.addValidField("status");
    }



    /** CREATOR
     *创建人
     */
    private java.lang.String creator;

    @Column(name = "CREATOR")
    public java.lang.String getCreator(){
        return this.creator;
    }

    public void setCreator(java.lang.String creator){
        this.creator = creator;
        super.addValidField("creator");
    }


    /** CREATE_TIME
     *创建时间
     */
    private java.util.Date createTime;

    @Column(name = "CREATE_TIME")
    public java.util.Date getCreateTime(){
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime){
        this.createTime = createTime;
        super.addValidField("createTime");
    }


    /** MODIFIER
     *更新人
     */
    private java.lang.String modifier;

    @Column(name = "MODIFIER")
    public java.lang.String getModifier(){
        return this.modifier;
    }

    public void setModifier(java.lang.String modifier){
        this.modifier = modifier;
        super.addValidField("modifier");
    }


    /** MODIFY_TIME
     *更新时间
     */
    private java.util.Date modifyTime;

    @Column(name = "MODIFY_TIME")
    public java.util.Date getModifyTime(){
        return this.modifyTime;
    }

    public void setModifyTime(java.util.Date modifyTime){
        this.modifyTime = modifyTime;
        super.addValidField("modifyTime");
    }


    /** USER_NAME_EN
     *英文名
     */
    private java.lang.String userNameEn;

    @Column(name = "USER_NAME_EN")
    public java.lang.String getUserNameEn(){
        return this.userNameEn;
    }

    public void setUserNameEn(java.lang.String userNameEn){
        this.userNameEn = userNameEn;
        super.addValidField("userNameEn");
    }
}
