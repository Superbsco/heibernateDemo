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
            // ����User����ĸ�������  
            u.setId(20);  
            u.setName("zhangsan");  
            u.setPassword("123456");  
            u.setType("admin");  
            // ʹ��UserDAOImpl��save������User������뵽���ݿ�  
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
