package com.lanou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created by dllo on 17/11/9.
 */

@Controller
public class HomeController {


    /**
     * 访问  localhost:8080/  时进入的页面
     *
     * @return
     */
    @RequestMapping("/")
    public String home() {
        return "fileUpload";
    }

    @RequestMapping("/login")
    public String login(String[] ids, String deptId, String postId, Model model) {
        if (ids != null) {
            for (String id : ids) {
                System.out.println(id);
            }
            model.addAttribute("ids", Arrays.toString(ids));
        }
        System.out.println(deptId + " : " + postId);
        model.addAttribute("deptId", deptId);
        model.addAttribute("postId", postId);
//        return "forward:/hr/findAll";//转发
        return "redirect:main";//重定向
    }

    @RequestMapping("/main")
    public String main(){
        return "error";
    }


    /**
     * 上传文件
     */
    @RequestMapping("/fileUpload")
    public String fileUpload(MultipartFile pic,
                             HttpServletRequest request,
                             HttpServletResponse response) throws IOException {

        String path = request.getServletContext().getRealPath("files");
        File dirFile = new File(path);
        if (!dirFile.exists() || dirFile.isFile()){
            dirFile.mkdirs();//不存在,则构建
        }

        File file = new File(dirFile, UUID.randomUUID()+pic.getOriginalFilename());
        //将临时文件保存到指定目录
        pic.transferTo(file);
        System.out.println("文件存储路径"+file.getAbsolutePath());

        return "success";
    }

}
