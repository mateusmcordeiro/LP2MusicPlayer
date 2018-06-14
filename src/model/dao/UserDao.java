/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import model.domain.User;
import model.domain.UserException;


/**
 *
 * @author mateu
 */
public class UserDao {
    
    public User SalvarAtualizar(User user) throws UserException {
        try{ 
            EntityManager em = Conexao.getEntityManager();
            em.getTransaction().begin();
            if(user.getId() != null){
                user = em.merge(user);
            }
        
            user.HashPassword();
            em.persist(user);
            em.flush();
            User retorno =  user;
            em.getTransaction().commit();
            em.close();
            return retorno;
        } catch(PersistenceException  ex) {
            PersistenceException cause = (PersistenceException) ex.getCause();
            throw new UserException(cause.getMessage());
        } 
        
        
    }
    public void Excluir(User user){
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }
    public User Login(User user) throws UserException{
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createNativeQuery("select * from user where login = '"+user.getLogin()+"'",User.class);
        ArrayList<User> results1 = (ArrayList<User>) query.getResultList();
        
        if(!results1.isEmpty()){
            em.close();
            User user_result = results1.get(0);
            if(user_result.VerifyPasswordHash(user.getPassword(), user_result.getPassword())){
                return user_result;
            }else{
                throw new UserException("Senha Incorreta.");
            }
            
        }else{
            em.close();
            throw new UserException("Esse usuário não está cadastrado.");
        }
        
        
    }
}
