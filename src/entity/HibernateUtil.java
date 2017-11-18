package entity;

import org.hibernate.HibernateException;  
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.cfg.Configuration; 

public class HibernateUtil {  
	  
    private static SessionFactory sessionFactory;  
    // �����ֲ߳̾�����threadLocal����������Hibernate��Session  
    private static final ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();  
    // ʹ�þ�̬������ʼ��Hibernate  
    static  
    {  
        try  
        {  
            // ��ȡ�����ļ�  
            Configuration cfg=new Configuration().configure();  
            // ����SessionFactory  
            sessionFactory=cfg.buildSessionFactory();  
        }catch(Throwable ex)  
        {  
            throw new ExceptionInInitializerError(ex);  
        }  
    }  
    // ���SessionFactory��ʵ��  
    public static SessionFactory getsSessionFactory()  
    {  
        return sessionFactory;  
    }  
    // ���ThreadLocal��������Session  
    public static Session getsSession() throws HibernateException  
    {  
        Session session=(Session) threadLocal.get();  
        if(session==null||!session.isOpen())  
        {  
            if(sessionFactory==null)  
            {  
                rebuildSessionFactory();  
            }  
            // ͨ��SessionFactory���󴴽�Session����  
            session=(sessionFactory!=null)?sessionFactory.openSession():null;  
            // ��Session���󱣴浽�ֲ߳̾�����threadLocal��  
            threadLocal.set(session);  
        }  
        return session;  
    }  
    // �ر�Sessionʵ��  
    public static void closeSession()  
    {  
        // ���ֲ߳̾�����threadLocal�л�ȡ֮ǰ�����Sessionʵ��  
        Session session=(Session)threadLocal.get();  
        threadLocal.set(null);  
        if(session!=null)  
        {  
            session.close();  
        }  
    }  
    // �ؽ�SessionFactory  
    public static void rebuildSessionFactory()  
    {  
        Configuration configuration=new Configuration();  
        configuration.configure("/hibernate.cfg.xml");  
        sessionFactory=configuration.buildSessionFactory();  
    }  
    // �رջ�������ӳ�  
    public static void shutdown()  
    {  
        getsSessionFactory().close();  
    }  
}  