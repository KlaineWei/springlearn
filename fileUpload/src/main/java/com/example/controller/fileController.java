package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("file")
public class fileController {

    private static final Logger log = LoggerFactory.getLogger(fileController.class);

    @Value("${file.upload.dir}")
    private String uploadPath;

    @RequestMapping("upload")
    public String fileUpload(MultipartFile file) throws IOException {

        String originalFilename = file.getOriginalFilename();
        log.debug("文件名称: {}", file.getOriginalFilename());
        log.debug("文件大小: {}", file.getSize());

        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + suffix;

        file.transferTo(new File(uploadPath, newFileName));

        return "upload";
    }
}
