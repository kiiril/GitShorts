package com.kiiril.gitshorts.services;

import com.google.cloud.storage.*;
import com.google.common.io.ByteStreams;
import com.kiiril.gitshorts.dto.PersonDTO;
import com.kiiril.gitshorts.dto.PostDTO;
import com.kiiril.gitshorts.models.Person;
import com.kiiril.gitshorts.models.Post;
import com.kiiril.gitshorts.repositories.PersonRepository;
import com.kiiril.gitshorts.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final PersonRepository personRepository;

    private static String PROJECT_ID = "sustained-opus-423022-g2";
    private static String BUCKET_NAME = "gitshorts_videos";

    @Autowired
    public PostService(PostRepository postRepository, PersonRepository personRepository) {
        this.postRepository = postRepository;
        this.personRepository = personRepository;
    }


    public void save(Post post) {
        postRepository.save(post);
    }

    public List<PostDTO> getPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> postDTOList = new ArrayList<>();
        for (Post post: posts) {
            Person person = post.getOwner();
            PersonDTO personDTO = new PersonDTO(person.getId(),
                                                person.getUsername(),
                                                person.getProfileLink());
            PostDTO postDTO = new PostDTO(post.getId(),
                                        post.getVideoLink(),
                                        post.getLikesCounter(),
                                        post.getTextPost(),
                                        personDTO);
            postDTOList.add(postDTO);
        }
        return postDTOList;
    }

    public String uploadVideo(MultipartFile video) {
        Storage storage = StorageOptions.newBuilder().setProjectId(PROJECT_ID).build().getService();
        BlobId blobId = BlobId.of(BUCKET_NAME, "videos/" + video.getName());
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                                    .setContentType("mp4")
                                    .build();
        try {
            InputStream inputStream = video.getInputStream();
            byte[] bytes = ByteStreams.toByteArray(inputStream);
            storage.create(blobInfo, bytes);
        } catch (IOException e) {
            return "FAILED";
        }
        return "OK";
//        Storage storage = StorageOptions.newBuilder().setProjectId(PROJECT_ID).build().getService();
//        BlobId blobId = BlobId.of(BUCKET_NAME, video);
//        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
//        String filePath = objectName;
//        storage.createFrom(blobInfo, Paths.get(filePath));
    }
}
