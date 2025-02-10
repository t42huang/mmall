package com.portal.service.impl;

import com.portal.service.IFileService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: tina.huanght
 * @Date: 10/02/25 11:09
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {
    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
    public String upload(MultipartFile file, String path){
        String fileName = file.getOriginalFilename();
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        String updateFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
        logger.info("开始上选文件, 文件名: {}, 路径: {}, 新文件名: {}", fileName, path, updateFileName);

        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path, updateFileName);
        try {
            file.transferTo(targetFile);
            //上传成功
            //todo 将targetfile 传到ftp服务上去
            //todo 删除旧的
        } catch (IOException e) {
            //上传失败
            throw new RuntimeException(e);
        }
        return targetFile.getName();
    }

    public static void main(String[] args) {
        String fileName = "test.jpg";
        System.out.println(fileName.substring(fileName.lastIndexOf(".")+1));

    }
}
