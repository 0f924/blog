package cn.itcast.blog.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CritiqueMapper {
    public int queryCritiqueCount(int AId);
}
