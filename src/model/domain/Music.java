/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.io.File;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
/**
 *
 * @author mateu
 */
@Entity
@Table(name="music")
public class Music {
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;    
    @Column(name="name")
    private String name;
    @Column(name="path")
    private String path;
    
    private File musicFile;
    private Media pick;
    public MediaPlayer player;
    private Duration timeNow;
    private Duration totalTime;
    private String totalTimeString;
    
        
    
    public Music(String name,String path){
        com.sun.javafx.application.PlatformImpl.startup(()->{});
        this.name = name;
        this.path = path;
        this.musicFile = new File(this.path);
        this.pick  = new Media(this.musicFile.toURI().toString());
        this.player = new MediaPlayer(pick);
        this.totalTime = player.getMedia().getDuration();
        this.player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                timeNow = newValue;
            }
        });

    }
    public Music(Integer id,String name,String path){
        com.sun.javafx.application.PlatformImpl.startup(()->{});
        this.id = id;
        this.name = name;
        this.path = path;
        this.musicFile = new File(this.path);
        this.pick  = new Media(this.musicFile.toURI().toString());
        this.player = new MediaPlayer(pick);
        this.player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                timeNow = newValue;
            }
        });
        
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }  
    public void play() {
        this.player.play();
    }
    public void pause(){
        this.player.pause();
    }
    public String getTotalTime(){
        return totalTimeString;
    }

}
