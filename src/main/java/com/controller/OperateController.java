package com.controller;

import com.entity.Alumni;
import com.mapper.AlumniMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * @Author: EvenHuang
 * @Date: 2019/6/19 15:54
 */
@Controller
public class OperateController {

    @Autowired
    AlumniMapper alumniMapper;

    @RequestMapping(value = "/all")
    public String list(HttpServletRequest request){
        String token=null;
        try{
            token=request.getParameter("token");
        }catch(Exception e){
            e.printStackTrace();
        }
        ArrayList<Alumni> alumnis;
        if(token == null || token.length() <= 0){
            alumnis = alumniMapper.selectAlumnis();
        }
        else if(token.equals("sousuo")){
            String key=request.getParameter("key");
            alumnis=alumniMapper.selectAlumnisByName(key);
        }
        else
            alumnis = null;
        for (Alumni alumni : alumnis) {
            System.out.println("校友：" + alumni.toString());
        }
        request.setAttribute("alumnis", alumnis);

        return "operate/list";
    }

/*
    @RequestMapping(value = "/all",method = RequestMethod.POST)
    public String search(){

        return "redirect:all";
    }
*/
    //添加新校友页面
    @RequestMapping(value = "/alumni",method = RequestMethod.GET)
    public String add(Model model){
        return "/operate/edit";
    }

    //添加新校友
    @RequestMapping(value = "/alumni",method = RequestMethod.POST)
    public String add(Alumni alumni){
        alumniMapper.addAlumni(alumni);

        return "redirect:/all";
    }


    //来到校友信息修改页面，查出指定校友信息，在页面上显示
    @RequestMapping(value = "/alumni/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id")String id,Model model){
        Alumni alumni=alumniMapper.selectAlumniById(Integer.valueOf(id));
        model.addAttribute("alumni",alumni);

        return "/operate/edit";
    }

    //修改校友信息
    @RequestMapping(value = "/alumni",method = RequestMethod.PUT)
    public String update(Alumni alumni){
        alumniMapper.updateAlumni(alumni);

        return "redirect:/all";
    }

    //删除好友
    @RequestMapping(value = "/alumni/{id}",method = RequestMethod.DELETE)
    public String deleteAlumni(@PathVariable String id){
        alumniMapper.deleteAlumniById(Integer.valueOf(Integer.valueOf(id)));

        return "redirect:/all";
    }
}
