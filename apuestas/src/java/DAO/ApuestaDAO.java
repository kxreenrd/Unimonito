/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HibernateUtil.HibernateUtil;
import Modelo.Apuesta;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Karen Rodriguez
 */
public class ApuestaDAO {
    Session session = null;
    Session se = null;

    public ApuestaDAO() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Apuesta> setApuesta(int id,int max, int min) {
        Apuesta tor = new Apuesta();
        tor.setValorMinimo(min);
        tor.setValorMaximo(max);
        
        tor.setPartidoIdpartido(id);
        tor.setActivo(1);

        boolean aux = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(tor);
            session.getTransaction().commit();
            aux = true;
        } catch (Exception e) {
            aux = false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        List<Apuesta> apuesta = new ArrayList<Apuesta>();
        try {
            se = HibernateUtil.getSessionFactory().openSession();            
            Query query = se.createQuery("from Apuesta order by idapuesta desc");            
            apuesta = (List<Apuesta>) query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (se != null) {
                se.close();
            }
        }
        return apuesta;
    }
    
    public List<Apuesta> getApuesta(){
        List<Apuesta> rifa = new ArrayList<Apuesta>();
        try {
            se = HibernateUtil.getSessionFactory().openSession();            
            Query query = se.createQuery("from Apuesta where activo = 1");            
            rifa = (List<Apuesta>) query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (se != null) {
                se.close();
            }
        }
        return rifa;
    }
}
