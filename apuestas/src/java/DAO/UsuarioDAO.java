/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HibernateUtil.HibernateUtil;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Karen Rodriguez
 */
public class UsuarioDAO {
    Session session = null;
    
    public UsuarioDAO(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
        
    public List<Usuario> getUsuario(int identificacion) {
        List<Usuario> usuario = new ArrayList<Usuario>();
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Usuario where identificacion = "+ identificacion);
            usuario = (List<Usuario>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
    public boolean setUsuario(String nombre, String apellido, int identificacion){
        Usuario us = new Usuario();
        us.setNombres(nombre);
        us.setApellidos(apellido);
        us.setIdentificacion(identificacion);
        us.setRolIdrol(2);
        //session.save(us);
        
        
        boolean aux = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(us);
            session.getTransaction().commit();
            aux = true;
        } catch (Exception e) {
            aux = false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return aux;
    }
    
}
