package com.rentapplication.rentapplication.controllers;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.rentapplication.rentapplication.entities.Logement;
import com.rentapplication.rentapplication.entities.Picture;
import com.rentapplication.rentapplication.repositories.LogementRepository;
import com.rentapplication.rentapplication.repositories.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import java.io.File;

@RestController
@RequestMapping
public class PictureController {
    @Autowired
    PictureRepository picturerepository;
    @Autowired
    ServletContext context;

    @Autowired(required = true)
    private LogementRepository logementrepository;

    @CrossOrigin("http://localhost:4200")
    @PostMapping(value = "/uploadpictures")
    public Picture savePicture (@RequestParam("file") MultipartFile file,
                                @RequestParam("logement_id") Integer logement_id
                                ) throws JsonParseException, JsonMappingException, Exception
    {
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/Images/")).mkdir();
            System.out.println("mk dir.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        String newFileSaved = UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileSaved));
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println(logement_id);

        Logement newlogement = logementrepository.findById(logement_id).orElse(null);
        Picture picture = new Picture();
        picture.setLogement(newlogement);
        picture.setPictureFilename(newFileSaved);
        picture.setPictureName(newFileName);
        return picturerepository.save(picture);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping(path="/pictures/{id}")
    public List<Picture> getPhotos(@PathVariable("id") Integer id) throws Exception{
        return picturerepository.findByLogementId(id);
        //return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+picture.getPictureFilename()));
    }
    
    @CrossOrigin("http://localhost:4200")
    @GetMapping(path="/picture/{id}")
    public byte[] getPhoto(@PathVariable("id") Integer id) throws Exception{
        Picture picture = picturerepository.findById(id).orElse(null);
        return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+picture.getPictureFilename()));
    }


    @CrossOrigin("http://localhost:4200")
    @PostMapping(value = "/modifypictures")
    public Picture modifyPicture (@RequestParam("file") MultipartFile file,
                                  @RequestParam("logement_id") Integer logement_id
    ) throws JsonParseException, JsonMappingException, Exception
    {
        picturerepository.deleteAllByLogementId(logement_id);
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/Images/")).mkdir();
            System.out.println("mk dir.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        String newFileSaved = UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileSaved));
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println(logement_id);

        Logement newlogement = logementrepository.findById(logement_id).orElse(null);
        Picture picture = new Picture();
        picture.setLogement(newlogement);
        picture.setPictureFilename(newFileSaved);
        picture.setPictureName(newFileName);
        return picturerepository.save(picture);
    }


}
