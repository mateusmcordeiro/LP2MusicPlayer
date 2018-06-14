package controller;


import java.util.ArrayList;
import java.util.List;
import model.dao.UserDao;
import model.domain.Music;
import model.domain.PlayList;
import model.domain.User;
import model.domain.UserException;
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
public class PlayListController {
    public PlayList playList;
    
    
    public PlayListController(){
        playList = new PlayList();
    }
    
    public void AddMusic(Music music){
        this.playList.addMusic(music);
    }
    public void RemoveMusic(Music music){
       this.playList.removeMusic(music);
    }
    public ArrayList getPlayList(){
        return this.playList.getPlayList();
    }
    
   
    
}
