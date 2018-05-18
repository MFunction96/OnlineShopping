package xyz.mfbrain.onlineshopping.dao;

import xyz.mfbrain.onlineshopping.bean.IndentBean;

import java.util.ArrayList;

/**
 * @program: OnlineShopping
 * @description:
 * @author: ChrisYoung
 * @create: 2018-05-17 22:37
 **/

public class IndentDaoImp extends BaseDao implements IindentDao {
    @Override
    public ArrayList<IndentBean> findAllIndents() {
        ArrayList<IndentBean> indents=null;
        String sql="Select ";
        return null;
    }

    @Override
    public ArrayList<IndentBean> findAllIndentsByDate() {
        return null;
    }

    @Override
    public IndentBean findIndentByID(String id) {
        return null;
    }

    @Override
    public boolean addIndent(IndentBean indent) {
        return false;
    }

    @Override
    public boolean modifyIndentStatus(String id, String status) {
        return false;
    }

    @Override
    public boolean modifyIndentRemark(String id, String remark) {
        return false;
    }

    @Override
    public boolean deleteIndent(String id) {
        return false;
    }
}
