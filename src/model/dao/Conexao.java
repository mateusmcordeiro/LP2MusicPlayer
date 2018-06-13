/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mateu
 */
public class Conexao {
    private static EntityManagerFactory emf;
    
    public static Conexao conexao;
    
    private Conexao(){
        emf = Persistence.createEntityManagerFactory("LP2PlayerPU");
    }
    public static EntityManager getEntityManager(){
        if(conexao == null){
            conexao = new Conexao();
        }
        return emf.createEntityManager();
    }
}
