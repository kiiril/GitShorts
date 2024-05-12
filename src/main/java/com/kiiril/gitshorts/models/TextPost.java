package com.kiiril.gitshorts.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "text_post")
public class TextPost {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "features")
    private String features;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "text_post_x_technology",
//            joinColumns = @JoinColumn(name = "text_post_id"),
//            inverseJoinColumns = @JoinColumn(name = "technology_id")
//    )
//    private List<Technology> technologies;
    @Column(name = "technologies")
    private String technologies;

    public TextPost() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

//    public List<Technology> getTechnologies() {
//        return technologies;
//    }
//
//    public void setTechnologies(List<Technology> technologies) {
//        this.technologies = technologies;
//    }


    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }
}
