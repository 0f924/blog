package cn.itcast.blog.service;

import cn.itcast.blog.pojo.Critique;

import java.util.List;

public interface CritiqueService {
    public List<Critique> showCritiqueByAId(int AId);
}
