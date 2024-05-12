package com.kiiril.gitshorts.models;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "technology")
public class Technology {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;

//    @ManyToMany(mappedBy = "technologies")
//    private List<TextPost> textPosts;

    public Technology() {}

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

//    public List<TextPost> getTextPosts() {
//        return textPosts;
//    }
//
//    public void setTextPosts(List<TextPost> textPosts) {
//        this.textPosts = textPosts;
//    }


}
