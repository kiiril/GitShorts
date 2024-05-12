package com.kiiril.gitshorts.models;

import jakarta.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "video_link")
    private String videoLink;

    @Column(name = "likes_counter")
    private Integer likesCounter;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL)
    private TextPost textPost;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    public Post() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public Integer getLikesCounter() {
        return likesCounter;
    }

    public void setLikesCounter(Integer likesCounter) {
        this.likesCounter = likesCounter;
    }

    public TextPost getTextPost() {
        return textPost;
    }

    public void setTextPost(TextPost textPost) {
        this.textPost = textPost;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
