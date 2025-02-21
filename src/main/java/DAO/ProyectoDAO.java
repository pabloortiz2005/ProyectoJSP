package DAO;

import Entities.Proyectos;
import Entities.Estado;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import Util.HibernateUtil;

import java.util.List;

public class ProyectoDAO {

    public void guardarProyecto(Proyectos proyecto) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(proyecto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Proyectos> obtenerProyectosPorEstado(Estado estado) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            if (estado == null) {
                return session.createQuery("FROM Proyectos", Proyectos.class).list();
            }
            Query<Proyectos> query = session.createQuery("FROM Proyectos WHERE estado = :estado", Proyectos.class);
            query.setParameter("estado", estado);
            return query.list();
        }
    }

    public Proyectos obtenerProyectoPorId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Proyectos.class, id);
        }
    }
}
