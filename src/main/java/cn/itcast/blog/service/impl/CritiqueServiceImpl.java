package cn.itcast.blog.service.impl;

import cn.itcast.blog.mapper.CritiqueMapper;
import cn.itcast.blog.pojo.Critique;
import cn.itcast.blog.service.CritiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CritiqueServiceImpl implements CritiqueService {
    @Autowired
    private CritiqueMapper critiqueMapper;

    @Override
    public List<Critique> showCritiqueByAId(int AId) {
        return critiqueMapper.queryCritiqueByAId(AId);
    }

    @Override
    public void addCritique(Critique critique) {
        critiqueMapper.addCritique(critique);
    }
}
