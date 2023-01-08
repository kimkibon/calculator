package com.nueral.calculator.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
@Component
public class FileUtil {
    public String saveProfile(String name, String type, MultipartFile multipartFile) throws Exception{
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        String imgPath = System.getProperty("user.dir")+"/webapp/static/image/character/"+type+"/"+formatter.format(date);
        String folderPath = System.getProperty("user.dir")+"/webapp/static/image/character/"+type;
        File Folder2 = new File(imgPath);
        File Folder1 = new File(folderPath);

        // 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
        if (!Folder1.exists()) {
            try{
                Folder1.mkdir(); //폴더 생성합니다.
            }
            catch(Exception e){
                e.getStackTrace();
            }
        }if (!Folder2.exists()) {
            try{
                Folder2.mkdir(); //폴더 생성합니다.
            }
            catch(Exception e){
                e.getStackTrace();
            }
        }
        String initPath = "/image/character/"+type+"/"+formatter.format(date)+"/";
        String extension = Objects.requireNonNull(multipartFile.getOriginalFilename()).substring(multipartFile.getOriginalFilename().lastIndexOf("."));

        UUID uuid =UUID.randomUUID();

        String fileName = uuid + "_" + name + extension;

        multipartFile.transferTo(new File(imgPath , fileName));

        return initPath+fileName;
    }
}
