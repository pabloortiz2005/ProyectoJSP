package DAO;

import Entities.Tareas;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import Util.HibernateUtil;

import java.util.List;

public class TareaDAO {

    // Guardar una nueva tarea en la base de datos
    public void guardarTarea(Tareas tarea) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(tarea);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Obtener una lista de tareas por ID de proyecto
    public List<Tareas> obtenerTareasPorProyecto(int idProyecto) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        Query<Tareas> query = session.createQuery(
            "FROM Tareas t WHERE t.proyecto.id = :idProyecto", Tareas.class
        );
        query.setParameter("idProyecto", idProyecto);
        return query.list();
    }
}


    // Obtener una tarea por ID
    public Tareas obtenerTareaPorId(int idTarea) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Tareas.class, idTarea);
        }
    }

    // Eliminar una tarea por ID
    public void eliminarTarea(int idTarea) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Tareas tarea = session.get(Tareas.class, idTarea);
            if (tarea != null) {
                session.delete(tarea);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
