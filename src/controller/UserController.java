package controller;


import model.dao.UserDao;
import model.domain.User;
import model.domain.UserException;
import view.LoginView;
import view.MenuView;
import view.UserLoggedIn;

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
    public String Cadastro(User user) {
        try {
            User retorno = userDao.SalvarAtualizar(user);
            setUserDigitado(new User());
            return "Cadastro realizado com Sucesso!";
        }catch (UserException ex) {
            return ex.getMessage();
        }
    }
    public String Login(User user){
        try {
            User user_try = userDao.Login(user);
            setUserLoggedIn(user_try);
            setUserDigitado(new User());
            
            UserLoggedIn userView  = new UserLoggedIn();
            /*
                MenuView.MidPane.add(userView);
                userView.setVisible(true);
            */
            return "Login realizado com Sucesso!";
        } catch (UserException ex) {
            return ex.getMessage();
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
