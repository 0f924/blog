package cn.itcast.blog.mapper;

import cn.itcast.blog.pojo.Dianjiliang;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface DianjiliangMapper {
    public void addJilu(Dianjiliang dianjiliang);
    public List<Dianjiliang> queryDianjiliangByAId(Dianjiliang dianjiliang);
}
