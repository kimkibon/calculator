package com.nueral.calculator.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;
@Component
public class FileUtil {
    public String saveProfile(String name, String type, MultipartFile multipartFile) throws Exception{
        String path = System.getProperty("user.dir")+"/src/main/resources/static/image/character/"+type;
        String initPath = "/image/character/"+type+"/";
        String extension = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));

        UUID uuid =UUID.randomUUID();

        String fileName = uuid + "_" + name + extension;

        multipartFile.transferTo(new File(path , fileName));

        return initPath+fileName;
    }
}
