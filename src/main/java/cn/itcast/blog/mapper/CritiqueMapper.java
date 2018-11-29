package cn.itcast.blog.mapper;

import cn.itcast.blog.pojo.Critique;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CritiqueMapper {
    public int queryCritiqueCount(int AId);
    public List<Critique> queryCritiqueByAId(int AId);
    public void addCritique(Critique critique);
}
