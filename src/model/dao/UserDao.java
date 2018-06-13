/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import javax.persistence.EntityManager;
import model.domain.User;

/**
 *
 * @author mateu
 */
public class UserDao {
    
    public void SalvarAtualizar(User user){
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        if(user.getId() != null){
            user = em.merge(user);
        }
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }
    public void Excluir(User user){
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }
    public User Login(User user){
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        if(user.getId() != null){
            return user;
        }else{
            return null;
        }
    }
}
