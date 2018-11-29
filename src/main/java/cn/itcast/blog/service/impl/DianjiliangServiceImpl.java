package cn.itcast.blog.service.impl;

import cn.itcast.blog.mapper.DianjiliangMapper;
import cn.itcast.blog.pojo.Dianjiliang;
import cn.itcast.blog.service.DianjiliangService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DianjiliangServiceImpl implements DianjiliangService {
    @Autowired
    private DianjiliangMapper dianjiliangMapper;

    @Override
    public boolean isVisited(Dianjiliang dianjiliang) {
        if (dianjiliangMapper.queryDianjiliangByAId(dianjiliang).isEmpty()) {
            dianjiliangMapper.addJilu(dianjiliang);
            return false;
        } else {
            return true;
        }
    }
}
