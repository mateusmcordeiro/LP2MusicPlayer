/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.media.MediaPlayer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.swing.DefaultListModel;

/**
 *
 * @author mateu
 */
@Entity
@Table(name="playlist")
public class PlayList {
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    
    @OneToMany
    private List<Music> Musics; 
    private DefaultListModel listModel;

    public PlayList() {
        this.Musics = new ArrayList<>();
        this.listModel = new DefaultListModel(); 
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addMusic(Music music){
        Musics.add(music);
        listModel.addElement(music.getName());
    }
    public void removeMusic(Music music){
        Musics.remove(music);
        listModel.removeElement(music.getName());
    }
    public ArrayList getPlayList(){
        return (ArrayList)this.Musics;
    }
    public void playFirst(){
        Musics.get(0).play();
    }

    public void pauseFirst() {
        Musics.get(0).pause();
    }
    
     public MediaPlayer getPlayer(int i){
        return Musics.get(i).player;
    }

    public void play(int indice) {
        Musics.get(indice).pause();
    }

    public void pause(int indice) {
        Musics.get(indice).pause();
   }

    public Music getMusic(int indice) {
        return  Musics.get(indice);
    }
    public int getTotalNumber(){
        return this.Musics.size();
    }
    public DefaultListModel getListModel(){
        return this.listModel;
    }

    public void stop(int indice) {
        Musics.get(indice).stop();
    }
}
