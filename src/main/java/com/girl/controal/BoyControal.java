package com.girl.controal;

import java.text.ParseException;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.girl.dao.BoyRepository;
import com.girl.entity.Boy;
import com.girl.exception.MyException;
import com.girl.utils.Result;

@Controller
@RequestMapping(value = "/boy")
 public class BoyControal {

    @Resource
    private BoyRepository boyRepository;


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result demo1(@Valid()Boy boy,BindingResult bindingResult){
    	if (bindingResult.hasErrors()) {
			return	Result.error(bindingResult.getFieldError().getDefaultMessage());
		}
        return Result.success(boyRepository.save(boy));
    }

    @ResponseBody
    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    public Result demo2(Integer id) throws ParseException {
    	if(boyRepository.findOne(id)==null){
    		throw new MyException((byte)101, "查询结果为空");
    	}
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
        return Result.error("修改失败");
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
