package classes;

import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ABoK4Do on 01.05.17.
 */
public class FoodDAO implements DAO<FoodsEntity>{


        public FoodDAO(){
        }



        public void insert(FoodsEntity food) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(food);
                session.getTransaction().commit();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {

                    session.close();
                }
            }
        }


        public void update(FoodsEntity food) throws SQLException{
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(food);
                session.getTransaction().commit();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при обновлении", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }


        public void delete(FoodsEntity food) throws SQLException{
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(food);
                session.getTransaction().commit();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }


        public FoodsEntity find(int id) throws SQLException{
            Session session = null;
            FoodsEntity food = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                food = (FoodsEntity) session.load(FoodsEntity.class, id);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'find'", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return food;
        }


        public List<FoodsEntity> findAll() throws SQLException{
            Session session = null;
            List foods = new ArrayList<FoodsEntity>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                foods = session.createCriteria(FoodsEntity.class).list();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findAll'", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return foods;
        }





}

