package com.harvey.learning.springboot.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.harvey.common.core.service.BaseService;
import com.harvey.learning.springboot.model.BasUsersModel;

public interface BasUsersService extends BaseService {

    List<BasUsersModel> saveAll(Collection<BasUsersModel> models);
    
    
    /**
     * 查询
     * @return
     */
    List<BasUsersModel> query();
    
    BasUsersModel save(BasUsersModel model);
    
    void removeAll(Collection<BasUsersModel> models);
    
    
    
    
    BasUsersModel findById(String userId);
    
    
    void removeAllByPk(Collection<? extends Serializable> ids);
    
    
    List<BasUsersModel> findByExample(BasUsersModel example);
    
}