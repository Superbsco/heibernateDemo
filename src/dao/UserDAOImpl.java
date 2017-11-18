package dao;

import org.hibernate.Session;  
import org.hibernate.Transaction;  
import entity.HibernateUtil;  
import entity.User;  
  
public class UserDAOImpl implements UserDAO {  
  
    // ����û�  
    @Override  
    public void save(User user) {  
        // TODO Auto-generated method stub  
        // ����Sessionʵ��  
        Session session = HibernateUtil.getsSession();  
        // ����Transactionʵ��  
        Transaction tx = session.beginTransaction();  
        try {  
            // ʹ��Session��save�������־û����󱣴浽���ݿ�  
            session.save(user);  
            // �ύ����  
            tx.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
            // �����쳣���ع�����  
            tx.rollback();  
        } finally {  
            // �ر�Session����  
            HibernateUtil.closeSession();  
        }  
    }  
  
    // ����id�����û�  
    @Override  
    public User findById(int id) {  
        // TODO Auto-generated method stub  
        User user = null;  
        Session session = HibernateUtil.getsSession();  
        Transaction tx = session.beginTransaction();  
        try {  
            // ʹ��session��get������ȡָ��id���û�  
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
  
    // ɾ���û�  
    @Override  
    public void delete(User user) {  
        // TODO Auto-generated method stub  
        Session session = HibernateUtil.getsSession();  
        Transaction tx = session.beginTransaction();  
        try {  
            // ʹ��session��delete�������־û�����ɾ��  
            session.delete(user);  
            tx.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
            tx.rollback();  
        } finally {  
            HibernateUtil.closeSession();  
        }  
    }  
  
    // �޸��û���Ϣ  
    @Override  
    public void update(User user) {  
        // TODO Auto-generated method stub  
        Session session = HibernateUtil.getsSession();  
        Transaction tx = session.beginTransaction();  
        try {  
            // ʹ��session��update�������³־û�����  
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
