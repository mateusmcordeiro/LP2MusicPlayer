package controller;


import java.util.ArrayList;
import javafx.scene.media.MediaPlayer;
import model.domain.Music;
import model.domain.PlayList;
import java.util.Observable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mateu
 */
public class PlayListController extends Observable {
    public PlayList playList;
    public int IndexMusicSelected;
    
    public PlayListController(){
        playList = new PlayList();
    }
    public void setIndexMusicSelected(int i){
        synchronized (this) {
            this.IndexMusicSelected = i;
        }
        setChanged();
        notifyObservers();
    }
    public synchronized int getIndex(){
        return this.IndexMusicSelected;
    }
    public void AddMusic(Music music){
        this.playList.addMusic(music);
    }
    public void RemoveMusic(Music music){
       this.playList.removeMusic(music);
    }
    public void PlayMusic(){
        this.playList.play(this.IndexMusicSelected);
    }
    public void PauseMusic(){
        this.playList.pause(this.IndexMusicSelected);
    }
    public ArrayList getPlayList(){
        return this.playList.getPlayList();
    }
    public MediaPlayer getPlayer(){
        return this.playList.getPlayer(this.IndexMusicSelected);
    }
    public Music getMusic(){
        return this.playList.getMusic(this.IndexMusicSelected);
    }
    public Music getMusic(int i){
        return this.playList.getMusic(i);
    }
    public int getTotalNumber(){
        return this.playList.getTotalNumber();
    }
    
   
    
}
