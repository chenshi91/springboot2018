package com.girl.controal;

import java.text.ParseException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.girl.entity.Girl;
import com.girl.entity.User;
import com.girl.utils.Result;

@Controller
@RequestMapping(value = "/user")
 public class UserControal {

    @Resource
    private Girl girl;
    private Map<Integer,User> userResponse=new ConcurrentHashMap<>();

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseBody
    public Result demo1(User user){
        return Result.success(userResponse.put(user.getId(),user));
    }

    @ResponseBody
    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    public Result demo2(Integer id) throws ParseException {
        return Result.success(userResponse.get(id));
    }

    @ResponseBody
    @PostMapping(value = "/update")
    public Result demo3(User user){
        User updateUser = userResponse.get(user.getId());
        if (updateUser!=null) {
            userResponse.put(user.getId(),user);
            return Result.success(user);
        }
        return Result.error(updateUser);
    }

    @ResponseBody
    @DeleteMapping(value = "/delete")
    public Result   delete(Integer id){
        User user = userResponse.get(id);
        if (user==null) {
            return Result.error(user);
        }
        userResponse.remove(user);
        return Result.success(user);
    }

    @GetMapping(value = "list")
    @ResponseBody
    public Result list(){
        return Result.success(userResponse);
    }
}
