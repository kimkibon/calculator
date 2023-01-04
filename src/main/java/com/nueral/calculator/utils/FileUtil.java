package com.nueral.calculator.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;
import java.util.UUID;
@Component
public class FileUtil {
    public String saveProfile(String name, String type, MultipartFile multipartFile) throws Exception{
        String path = System.getProperty("user.dir")+"/webapp/static/image/character/"+type;
        File Folder = new File(path);

        // 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
        if (!Folder.exists()) {
            try{
                Folder.mkdir(); //폴더 생성합니다.
                System.out.println(Folder.getAbsolutePath());
            }
            catch(Exception e){
                e.getStackTrace();
            }
        }else {
            System.out.println("이미 폴더가 생성되어 있습니다.");
        }
        String initPath = "/image/character/"+type+"/";
        String extension = Objects.requireNonNull(multipartFile.getOriginalFilename()).substring(multipartFile.getOriginalFilename().lastIndexOf("."));

        UUID uuid =UUID.randomUUID();

        String fileName = uuid + "_" + name + extension;

        multipartFile.transferTo(new File(path , fileName));

        return initPath+fileName;
    }
}
