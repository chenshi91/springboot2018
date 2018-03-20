package com.girl.controal;

import com.girl.dao.BoyRepository;
import com.girl.entity.Boy;
import com.girl.entity.Girl;
import com.girl.entity.User;
import com.girl.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping(value = "/boy")
 public class BoyControal {

    @Resource
    private BoyRepository boyRepository;


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result demo1(Boy boy){
        return Result.success(boyRepository.save(boy));
    }

    @ResponseBody
    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    public Result demo2(Integer id) throws ParseException {
        return Result.success(boyRepository.findOne(id));
    }

    @ResponseBody
    @PostMapping(value = "/update")
    public Result demo3(Boy boy){
        Integer id = boy.getId();
        Boy selectBoy = boyRepository.findOne(id);
        if (selectBoy!=null) {
            return Result.success(boyRepository.saveAndFlush(boy));
        }
        return Result.error(boy);
    }

    @ResponseBody
    @DeleteMapping(value = "/delete")
    public Result   delete(Integer id){
        boyRepository.delete(id);
        return Result.success("删除成功！");
    }

    @GetMapping(value = "list")
    @ResponseBody
    public Result list(){
        return Result.success(boyRepository.findAll());
    }
}
