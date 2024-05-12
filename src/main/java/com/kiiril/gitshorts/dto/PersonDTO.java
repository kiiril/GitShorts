package com.kiiril.gitshorts.dto;

public class PersonDTO {
    private Integer id;
    private String username;
    private String profileLink;

    public PersonDTO(Integer id, String username, String profileLink) {
        this.id = id;
        this.username = username;
        this.profileLink = profileLink;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileLink() {
        return profileLink;
    }

    public void setProfileLink(String profileLink) {
        this.profileLink = profileLink;
    }
}
