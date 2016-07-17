package com.harvey.learning.springboot.service.impl;

import com.harvey.common.core.service.impl.BaseServiceImpl;
import com.harvey.learning.springboot.model.BasUsersModel;
import com.harvey.learning.springboot.service.BasUsersService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service
public class BasUsersServiceImpl extends BaseServiceImpl implements BasUsersService {

    @Override
    public List<BasUsersModel> saveAll(Collection<BasUsersModel> models) {
        return (List<BasUsersModel>) this.dao.saveAll(models);
    }


    @Override
    public List<BasUsersModel> query() {
        return this.dao.getAll(BasUsersModel.class);
    }

    @Override
    public BasUsersModel save(BasUsersModel model) {
        return this.dao.save(model);
    }

    @Override
    public void removeAll(Collection<BasUsersModel> models) {
        this.dao.removeAll(models);
    }





    @Override
    public BasUsersModel findById(String userId) {
        BasUsersModel example = new BasUsersModel();
        example.setUsersId(userId);
        List<BasUsersModel> list = this.dao.findByExample(example);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }


    @Override
    public void removeAllByPk(Collection<? extends Serializable> ids) {
        this.dao.removeAllByPk(BasUsersModel.class, ids);
    }


	@Override
	public List<BasUsersModel> findByExample(BasUsersModel example) {
		return this.dao.findByExample(example);
	}
}