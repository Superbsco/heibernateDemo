package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dao.UserDAO;
import dao.UserDAOImpl;
import entity.User;

public class UserTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSave() {
		UserDAO userDAO=new UserDAOImpl();  
        try{  
            User u=new User();  
            // 设置User对象的各个属性  
            u.setId(20);  
            u.setName("zhangsan");  
            u.setPassword("123456");  
            u.setType("admin");  
            // 使用UserDAOImpl的save方法将User对象存入到数据库  
            userDAO.save(u);  
        }catch(Exception e){  
            e.printStackTrace();  
        }
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
