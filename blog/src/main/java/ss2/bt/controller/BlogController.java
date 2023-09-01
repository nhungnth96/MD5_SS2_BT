package ss2.bt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ss2.bt.model.dto.BlogDto;
import ss2.bt.model.service.IBlogService;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public String list(Model model){
        model.addAttribute("blogs",blogService.findAll());
        return "list";
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Long id){
        return new ModelAndView("detail","blog",blogService.findById(id));
    }
    @GetMapping("/add")
    public ModelAndView add(){

        return new ModelAndView("add","blog",new BlogDto());
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id){
        return new ModelAndView("edit","blog",blogService.findById(id));
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        blogService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute BlogDto blogDto){
        blogService.save(blogDto);
        return "redirect:/";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute BlogDto blogDto){
        blogService.save(blogDto);
        return "redirect:/";
    }

}
