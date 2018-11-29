package cn.itcast.blog;

import cn.itcast.blog.mapper.BlogInfoMapper;
import cn.itcast.blog.mapper.DianjiliangMapper;
import cn.itcast.blog.mapper.UserMapper;
import cn.itcast.blog.pojo.Dianjiliang;
import cn.itcast.blog.pojo.User;
import cn.itcast.blog.service.DianjiliangService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private DianjiliangMapper dianjiliangMapper;
	@Autowired
	private DianjiliangService dianjiliangService;
	@Autowired
	private BlogInfoMapper blogInfoMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testUserDao() {
		User user = new User();
		user.setUsername("test");
		user.setNickname("测试用户");
		user.setPassword("123321");
		user.setQuestion("问题啦");
		user.setAnswer("答案啦");
		userMapper.add(user);
	}

	@Test
	public void testDianjiliangDao() {
		Dianjiliang dianjiliang = new Dianjiliang();
		dianjiliang.setAId(7);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String stime = sdf.format(new Date());
		Date time = null;
		try {
			time = sdf.parse(stime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dianjiliang.setTime(time);
		dianjiliang.setIp("0:0:0:0:0:0:0:1");
		System.out.println(dianjiliangMapper.queryDianjiliangByAId(dianjiliang));
	}

	@Test
	public void testBlogInfoDao() {
		System.out.println(blogInfoMapper.queryBlogInfoByUsername("xiaoxiao"));
	}

}
