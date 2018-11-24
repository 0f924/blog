package cn.itcast.blog;

import cn.itcast.blog.mapper.UserMapper;
import cn.itcast.blog.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {
	@Autowired
	private UserMapper userMapper;

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

}
