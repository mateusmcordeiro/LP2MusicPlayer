package controller;


import model.dao.UserDao;
import model.domain.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mateu
 */
public class UserController {
    private User UserLoggedIn;
    private UserDao userDao;
    private User UserDigitado;
    
    public UserController(){
        userDao = new UserDao();
    }
    public boolean Cadastro(User user){
        userDao.SalvarAtualizar(user);
        setUserDigitado(new User());
        return true;
    }
    public boolean Login(User user){
        User user_try = userDao.Login(user);
        
        if(user_try != null){
            setUserLoggedIn(user_try);
            setUserDigitado(new User());
            return true;
        }else{
            return false;
        }
    }

    public User getUserDigitado() {
        return UserDigitado;
    }

    public void setUserDigitado(User UserDigitado) {
        this.UserDigitado = UserDigitado;
    }

    public User getUserLoggedIn() {
        return UserLoggedIn;
    }

    public void setUserLoggedIn(User UserLoggedIn) {
        this.UserLoggedIn = UserLoggedIn;
    }
    
}
