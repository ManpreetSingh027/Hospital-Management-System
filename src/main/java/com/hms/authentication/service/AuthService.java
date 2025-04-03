package com.hms.authentication.service;
import com.hms.user.model.User;
import com.hms.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
public class AuthService {
    // 🔐 Verify login credentials
    public User login(String username, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery(
                    "FROM User WHERE username = :username AND password = :password", User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

            User user = query.uniqueResult();
            if (user != null) {
                System.out.println("✅ Login successful as: " + user.getRole());
            } else {
                System.out.println("❌ Invalid credentials.");
            }

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
