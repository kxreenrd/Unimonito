/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HibernateUtil.HibernateUtil;
import Modelo.Rifa;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Karen Rodriguez
 */
public class RifaDAO {
    Session session = null;
    
    public RifaDAO(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Rifa> setRifa(String premio,int n_b,String f_inicio, String f_fin){
        Rifa tor = new Rifa();
        tor.setPremio(premio);
        tor.setNumeroBoletas(n_b);
        tor.setFechaInicio(f_inicio);
        tor.setFechaFin(f_fin);
        
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
        List<Rifa> rifa = new ArrayList<Rifa>();
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Rifa");
            rifa = (List<Rifa>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rifa;
    }
    
}
