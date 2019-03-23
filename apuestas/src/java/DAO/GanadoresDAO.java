/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HibernateUtil.HibernateUtil;
import Modelo.Boleta;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Karen Rodriguez
 * 
 */
public class GanadoresDAO {
    
    Session session = null;
    Session se = null;

    public GanadoresDAO() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    
    public List<Boleta> getGanadores(){
        List<Boleta> boleta = new ArrayList<Boleta>();
        try {
            se = HibernateUtil.getSessionFactory().openSession();            
            Query query = se.createQuery("FROM Boleta");            
            boleta = (List<Boleta>) query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (se != null) {
                se.close();
            }
        }
        return boleta;
    }
}
