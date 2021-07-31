package MVC_weibo.ssm.mapper;

import MVC_weibo.ssm.model.WeiboModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

// 这个是 spring 用来在 controller 进行依赖注入的。
@Repository
// 这个是 mybaits spring boot 用来自动跟 xml 联系起来，并注入到 spring 的 session 里面。
@Mapper
public interface WeiboMapper {
    void insertWeibo(WeiboModel Weibo);

    List<WeiboModel> selectAllWeibo();

    WeiboModel selectWeibo(int id);

    void updateWeibo(WeiboModel Weibo);

    void deleteWeibo(int id);
}
