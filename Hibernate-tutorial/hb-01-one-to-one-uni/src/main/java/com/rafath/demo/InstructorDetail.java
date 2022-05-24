package com.rafath.demo;


import javax.persistence.*;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

    //annotate the class as an entity

    //define the fields

    //annotate the fields with db column names

    //create constructors

    //generate getter/ setter methods

    //generate toString() method

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    public int getId() {
        return id;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    public InstructorDetail(){

    }

    public InstructorDetail(String youtubeChannel, String hobby){
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }
}
