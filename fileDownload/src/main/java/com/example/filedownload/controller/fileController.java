package com.example.filedownload.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
@RequestMapping("file")
public class fileController {

    private static final Logger log = LoggerFactory.getLogger(fileController.class);
    @Value("${file.download.dir}")
    private String downloadPath;

    @RequestMapping("download")
    public void download(String fileName, HttpServletResponse response) throws IOException {

        log.debug("下载文件名: {}", fileName);
        log.debug("下载地址: {}", downloadPath);

        File file = new File(downloadPath, fileName);

        FileInputStream is = new FileInputStream(file);

        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));

        ServletOutputStream os = response.getOutputStream();

        FileCopyUtils.copy(is, os);
    }
}
