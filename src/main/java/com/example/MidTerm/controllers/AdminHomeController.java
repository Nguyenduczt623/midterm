package com.example.MidTerm.controllers;

import com.example.MidTerm.models.BillDetail;
import com.example.MidTerm.models.Category;
import com.example.MidTerm.models.User;
import com.example.MidTerm.services.BillDetailService;
import com.example.MidTerm.services.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminHomeController {

    @Autowired
    BillDetailService billDetailService;

    @Autowired
    CategoryService categoryService;
    @RequestMapping(value = {"/login"},method = RequestMethod.GET)
    public String LoginPage(){

        return "admin/login";
    }

    @RequestMapping(value ="/statistics")
    public String StatisticsPage(HttpServletRequest rq,
                                 RedirectAttributes redirectAttributes,
                                 Model model){

        HttpSession session = rq.getSession();
        User user = (User) session.getAttribute("account");
        if(user == null) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập!!!");
            return "redirect:/admin/login";
        }

        if(user.getRole() != 3) {
            session.removeAttribute("account");
            return "redirect:/admin/login";
        }

        List<BillDetail> billDetailList = billDetailService.findAll();

        List<Category> categories = categoryService.findAll();
        int[] countList = new int[categories.size()];
        for(BillDetail p : billDetailList){

            for(Category c : categories){
                if(p.getProductId().getCategory().getId() == c.getId()){
                    countList[c.getId() - 1] += 1;
                }
            }

        }

        String[] nameList = new String[categories.size()];
        for (int i = 0; i<categories.size(); i++){
            nameList[i] = categories.get(i).getName();
        }

        model.addAttribute("nameList",nameList);
        model.addAttribute("countList",countList);
        return "admin/revenue-statistics";
    }

}
