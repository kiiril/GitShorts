package com.kiiril.gitshorts.dto;

import com.kiiril.gitshorts.models.TextPost;
public class PostDTO {
    private Integer id;
    private String videoLink;
    private Integer likesCounter;
    private TextPost textPost;
//    private TextPostDTO textPostDTO;
    private PersonDTO owner;


    public PostDTO(Integer id, String videoLink, Integer likesCounter, TextPost textPost, PersonDTO owner) {
        this.id = id;
        this.videoLink = videoLink;
        this.likesCounter = likesCounter;
        this.textPost = textPost;
        this.owner = owner;
    }

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

    public PersonDTO getOwner() {
        return owner;
    }

    public void setOwner(PersonDTO owner) {
        this.owner = owner;
    }

    //    public TextPostDTO getTextPostDTO() {
    //        return textPostDTO;
    //    }
    //
    //    public void setTextPostDTO(TextPostDTO textPostDTO) {
    //        this.textPostDTO = textPostDTO;
    //    }
}
