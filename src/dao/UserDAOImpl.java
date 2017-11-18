package dao;

import org.hibernate.Session;  
import org.hibernate.Transaction;  
import entity.HibernateUtil;  
import entity.User;  
  
public class UserDAOImpl implements UserDAO {  
  
    // 添加用户  
    @Override  
    public void save(User user) {  
        // TODO Auto-generated method stub  
        // 创建Session实例  
        Session session = HibernateUtil.getsSession();  
        // 创建Transaction实例  
        Transaction tx = session.beginTransaction();  
        try {  
            // 使用Session的save方法将持久化对象保存到数据库  
            session.save(user);  
            // 提交事务  
            tx.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
            // 出现异常，回滚事务  
            tx.rollback();  
        } finally {  
            // 关闭Session连接  
            HibernateUtil.closeSession();  
        }  
    }  
  
    // 根据id查找用户  
    @Override  
    public User findById(int id) {  
        // TODO Auto-generated method stub  
        User user = null;  
        Session session = HibernateUtil.getsSession();  
        Transaction tx = session.beginTransaction();  
        try {  
            // 使用session的get方法获取指定id的用户  
            user = (User) session.get(User.class, id);  
            tx.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
            tx.rollback();  
        } finally {  
            HibernateUtil.closeSession();  
        }  
        return user;  
    }  
  
    // 删除用户  
    @Override  
    public void delete(User user) {  
        // TODO Auto-generated method stub  
        Session session = HibernateUtil.getsSession();  
        Transaction tx = session.beginTransaction();  
        try {  
            // 使用session的delete方法将持久化对象删除  
            session.delete(user);  
            tx.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
            tx.rollback();  
        } finally {  
            HibernateUtil.closeSession();  
        }  
    }  
  
    // 修改用户信息  
    @Override  
    public void update(User user) {  
        // TODO Auto-generated method stub  
        Session session = HibernateUtil.getsSession();  
        Transaction tx = session.beginTransaction();  
        try {  
            // 使用session的update方法更新持久化对象  
            session.update(user);  
            tx.commit();  
        } catch (Exception e) {  
            tx.rollback();  
            e.printStackTrace();  
        } finally {  
            HibernateUtil.closeSession();  
        }  
    }  
  
}  
