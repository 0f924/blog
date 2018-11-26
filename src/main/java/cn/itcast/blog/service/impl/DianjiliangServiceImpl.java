package cn.itcast.blog.service.impl;

import cn.itcast.blog.mapper.DianjiliangMapper;
import cn.itcast.blog.pojo.Dianjiliang;
import cn.itcast.blog.service.DianjiliangService;
import org.apache.ibatis.annotations.Mapper;

public class DianjiliangServiceImpl implements DianjiliangService {
    @Mapper
    private DianjiliangMapper dianjiliangMapper;

    @Override
    public boolean isVisited(Dianjiliang dianjiliang) {
        if (dianjiliangMapper.queryDianjiliangByAId(dianjiliang).size() != 0) {
            return true;
        } else {
            dianjiliangMapper.addJilu(dianjiliang);
            return false;
        }
    }
}
