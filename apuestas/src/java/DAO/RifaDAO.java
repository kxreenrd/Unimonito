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
    Session se = null;

    public RifaDAO() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Rifa> setRifa(String premio, int n_b, int valor_boleta, String f_inicio, String f_fin) {
        Rifa tor = new Rifa();
        tor.setPremio(premio);
        tor.setNumeroBoletas(n_b);
        tor.setHoraInicio(f_inicio);
        tor.setHoraFin(f_fin);
        tor.setValor(valor_boleta);
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
        List<Rifa> rifa = new ArrayList<Rifa>();
        try {
            se = HibernateUtil.getSessionFactory().openSession();            
            Query query = se.createQuery("from Rifa order by idrifa desc");            
            rifa = (List<Rifa>) query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (se != null) {
                se.close();
            }
        }
        return rifa;
    }
    
    public List<Rifa> getRifa(){
        List<Rifa> rifa = new ArrayList<Rifa>();
        try {
            se = HibernateUtil.getSessionFactory().openSession();            
            Query query = se.createQuery("from Rifa where activo = 1");            
            rifa = (List<Rifa>) query.list();
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
