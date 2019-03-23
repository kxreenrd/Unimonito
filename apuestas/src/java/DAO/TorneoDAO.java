/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HibernateUtil.HibernateUtil;
import Modelo.Partido;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Karen Rodriguez
 */
public class TorneoDAO {
    Session session = null;
    Session se = null;

    public TorneoDAO() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Partido> setPartido(int local, int visitante, String fecha, String hini, String hfin) {
        Partido tor = new Partido();
        tor.setEquipoLocal(local);
        tor.setEquipoVisitante(visitante);
        tor.setFecha(fecha);
        tor.setMarcador("0-0");
        tor.setHoraInicio(hini);
        tor.setHoraFin(hfin);

        
        String aux = "no tiene nada";
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //session.save(tor);
            int id = (Integer)session.save(tor);
            aux = "si asigno "+id;
            session.getTransaction().commit();
            
        } catch (Exception e) {
            aux = "no asigno "+e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        List<Partido> partido = new ArrayList<Partido>();
        try {
            se = HibernateUtil.getSessionFactory().openSession();            
            Query query = se.createQuery("from Partido");            
            partido = (List<Partido>) query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (se != null) {
                se.close();
            }
        }
        return partido;
        //return aux;
    }
}
