/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

/**
 *
 * @author mateu
 */
public class UserException extends Exception {

    public UserException(){
        super();
    }

    public UserException(String message){
        super(message);
    }
}