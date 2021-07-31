package MVC_weibo.ssm.service;


import MVC_weibo.ssm.mapper.WeiboMapper;
import MVC_weibo.ssm.Utility;
import MVC_weibo.ssm.model.WeiboModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
 public class WeiboService {
    private WeiboMapper mapper;
    
    public WeiboService(WeiboMapper weiboMapper) {
        this.mapper = weiboMapper;
    }
    
    public  WeiboModel add(String content) {
        WeiboModel m = new WeiboModel();
        m.setContent(content);
        m.setUserId(-1);
        Utility.log("mapper add before <%s>", m);
        mapper.insertWeibo(m);
        Utility.log("mapper add after <%s>", m);
        return m;
    }
    
    public  void update(Integer id, String content) {
        WeiboModel m = new WeiboModel();
        m.setId(id);
        m.setContent(content);
        mapper.updateWeibo(m);
    }
    
    public void delete(Integer id) {
        mapper.deleteWeibo(id);
    }

    public  WeiboModel findById(Integer id) {
        return mapper.selectWeibo(id);
    }
    
    public  List<WeiboModel> all() {
        return mapper.selectAllWeibo();
    }
}
