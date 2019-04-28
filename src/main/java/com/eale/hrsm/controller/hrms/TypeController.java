package com.eale.hrsm.controller.hrms;

import com.eale.hrsm.bean.Type;
import com.eale.hrsm.service.TypeService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description 房屋类型的controller
 * @author: Eale
 * @date:2019/4/29/029-2:11
 */
@Controller
@RequestMapping("/")
public class TypeController {


    @Autowired
    private TypeService typeService;

    /**
     * @description   进入类型列表
     * @date: 2019/4/29/029 3:25
     * @author: Eale
     * @prams [request, session]
     * @return java.lang.String
     */
    public String typeManage(Model model){
        List<Type> typeAll = typeService.findAll();
        model.addAttribute("typeAll",typeAll);
        return "hrms/typeManage";
    }
    
    /**
     * @description   进入类型新增、修改 页面
     * @date: 2019/4/29/029 3:36
     * @author: Eale
     * @prams [model, session]
     * @return java.lang.String
     */
    public String typeEdit(Model model,HttpSession session,String typeId){

        if (StringUtil.isEmpty(typeId)){

        }


    }




}
