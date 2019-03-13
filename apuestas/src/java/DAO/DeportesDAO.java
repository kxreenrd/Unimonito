/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HibernateUtil.HibernateUtil;
import java.util.*;
import Modelo.Deporte;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * algo debo cambiarle?????
 * @author Karen Rodriguez
 */
public class DeportesDAO {
    
    Session session = null;
    public DeportesDAO(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    
    
    public List<Deporte> getDeporte() {
        List<Deporte> misDeportes = new ArrayList<Deporte>();
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Deporte");
            misDeportes = (List<Deporte>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return misDeportes;
    }
    
    
}
