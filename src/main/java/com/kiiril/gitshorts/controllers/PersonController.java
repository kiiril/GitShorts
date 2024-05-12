package com.kiiril.gitshorts.controllers;

import com.kiiril.gitshorts.dto.PostDTO;
import com.kiiril.gitshorts.dto.TextPostDTO;
import com.kiiril.gitshorts.dto.UploadedPost;
import com.kiiril.gitshorts.models.Person;
import com.kiiril.gitshorts.models.Post;
import com.kiiril.gitshorts.models.TextPost;
import com.kiiril.gitshorts.services.PersonService;
import com.kiiril.gitshorts.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
public class PersonController {
    private final PersonService personService;
    private final PostService postService;
    private MultipartFile video;

    @Autowired
    public PersonController(PersonService personService, PostService postService) {
        this.personService = personService;
        this.postService = postService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/upload-video")
    public ResponseEntity<?> upload(@RequestPart("video") MultipartFile video) {
        if (video.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        System.out.println("I was there");
        this.video = video;
        postService.uploadVideo(this.video);
        // Get the file bytes and save it
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/upload-post")
    public ResponseEntity<?> uploadPost(@RequestBody UploadedPost uploadedPost) {
        Person person = personService.getByUsername(uploadedPost.getUsername());
        Post post = new Post();
        post.setOwner(person);
        TextPost textPost = new TextPost();
        textPost.setPost(post);
        textPost.setTitle(uploadedPost.getTitle());
        textPost.setDescription(uploadedPost.getDescription());
        textPost.setFeatures(uploadedPost.getFeatures());
        textPost.setTechnologies(uploadedPost.getTechnologies());
        System.out.println(postService.uploadVideo(video));
        post.setVideoLink("https://storage.googleapis.com/gitshorts_videos/videos/" + video.getOriginalFilename());
        post.setTextPost(textPost);
        // Perform further processing if needed
        postService.save(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> posts() {
        List<PostDTO> posts = postService.getPosts();
        for (PostDTO postDTO: posts) {
            if (postDTO.getTextPost() != null) {
                TextPost textPost = postDTO.getTextPost();
                textPost.setPost(null);
//                TextPostDTO textPostDTO = new TextPostDTO();
//                textPostDTO.setId(textPost.getId());
//                textPostDTO.setTitle(textPost.getTitle());
//                textPostDTO.setFeatures(textPost.getFeatures());
//                textPostDTO.setDescription(textPost.getDescription());
//                textPostDTO.setPostId(textPostDTO.getPostId());
//                postDTO.setTextPostDTO(textPostDTO);
            }
        }

        return posts != null
                ? new ResponseEntity<>(posts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> requestBody) {
        System.out.println("Login processed");
        Person person = new Person();
        person.setUsername(requestBody.get("username"));
        person.setProfileLink("");
        personService.save(person);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }





    //    @GetMapping("/")
//    public ResponseEntity<List<Person>> mainPage() {
//        List<Person> personList = personService.index();
//        return personList != null
//                ? new ResponseEntity<>(personList, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
}
