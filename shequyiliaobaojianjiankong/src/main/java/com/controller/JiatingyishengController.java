
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 家庭医生
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiatingyisheng")
public class JiatingyishengController {
    private static final Logger logger = LoggerFactory.getLogger(JiatingyishengController.class);

    @Autowired
    private JiatingyishengService jiatingyishengService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("家庭医生".equals(role))
            params.put("jiatingyishengId",request.getSession().getAttribute("userId"));
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("jiatingyishengDeleteStart",1);params.put("jiatingyishengDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = jiatingyishengService.queryPage(params);

        //字典表数据转换
        List<JiatingyishengView> list =(List<JiatingyishengView>)page.getList();
        for(JiatingyishengView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiatingyishengEntity jiatingyisheng = jiatingyishengService.selectById(id);
        if(jiatingyisheng !=null){
            //entity转view
            JiatingyishengView view = new JiatingyishengView();
            BeanUtils.copyProperties( jiatingyisheng , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiatingyishengEntity jiatingyisheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiatingyisheng:{}",this.getClass().getName(),jiatingyisheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JiatingyishengEntity> queryWrapper = new EntityWrapper<JiatingyishengEntity>()
            .eq("username", jiatingyisheng.getUsername())
            .or()
            .eq("jiatingyisheng_phone", jiatingyisheng.getJiatingyishengPhone())
            .andNew()
            .eq("jiatingyisheng_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiatingyishengEntity jiatingyishengEntity = jiatingyishengService.selectOne(queryWrapper);
        if(jiatingyishengEntity==null){
            jiatingyisheng.setJiatingyishengDelete(1);
            jiatingyisheng.setCreateTime(new Date());
            jiatingyisheng.setPassword("123456");
            jiatingyishengService.insert(jiatingyisheng);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiatingyishengEntity jiatingyisheng, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiatingyisheng:{}",this.getClass().getName(),jiatingyisheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<JiatingyishengEntity> queryWrapper = new EntityWrapper<JiatingyishengEntity>()
            .notIn("id",jiatingyisheng.getId())
            .andNew()
            .eq("username", jiatingyisheng.getUsername())
            .or()
            .eq("jiatingyisheng_phone", jiatingyisheng.getJiatingyishengPhone())
            .andNew()
            .eq("jiatingyisheng_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiatingyishengEntity jiatingyishengEntity = jiatingyishengService.selectOne(queryWrapper);
        if("".equals(jiatingyisheng.getJiatingyishengPhoto()) || "null".equals(jiatingyisheng.getJiatingyishengPhoto())){
                jiatingyisheng.setJiatingyishengPhoto(null);
        }
        if(jiatingyishengEntity==null){
            jiatingyishengService.updateById(jiatingyisheng);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<JiatingyishengEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JiatingyishengEntity jiatingyishengEntity = new JiatingyishengEntity();
            jiatingyishengEntity.setId(id);
            jiatingyishengEntity.setJiatingyishengDelete(2);
            list.add(jiatingyishengEntity);
        }
        if(list != null && list.size() >0){
            jiatingyishengService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<JiatingyishengEntity> jiatingyishengList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JiatingyishengEntity jiatingyishengEntity = new JiatingyishengEntity();
//                            jiatingyishengEntity.setUsername(data.get(0));                    //账户 要改的
//                            //jiatingyishengEntity.setPassword("123456");//密码
//                            jiatingyishengEntity.setJiatingyishengName(data.get(0));                    //家庭医生负责人姓名 要改的
//                            jiatingyishengEntity.setJiatingyishengPhoto("");//详情和图片
//                            jiatingyishengEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            jiatingyishengEntity.setJiatingyishengPhone(data.get(0));                    //联系方式 要改的
//                            jiatingyishengEntity.setJiatingyishengEmail(data.get(0));                    //邮箱 要改的
//                            jiatingyishengEntity.setKeshiTypes(Integer.valueOf(data.get(0)));   //科室 要改的
//                            jiatingyishengEntity.setJiatingyishengDelete(1);//逻辑删除字段
//                            jiatingyishengEntity.setCreateTime(date);//时间
                            jiatingyishengList.add(jiatingyishengEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //联系方式
                                if(seachFields.containsKey("jiatingyishengPhone")){
                                    List<String> jiatingyishengPhone = seachFields.get("jiatingyishengPhone");
                                    jiatingyishengPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> jiatingyishengPhone = new ArrayList<>();
                                    jiatingyishengPhone.add(data.get(0));//要改的
                                    seachFields.put("jiatingyishengPhone",jiatingyishengPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<JiatingyishengEntity> jiatingyishengEntities_username = jiatingyishengService.selectList(new EntityWrapper<JiatingyishengEntity>().in("username", seachFields.get("username")).eq("jiatingyisheng_delete", 1));
                        if(jiatingyishengEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiatingyishengEntity s:jiatingyishengEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //联系方式
                        List<JiatingyishengEntity> jiatingyishengEntities_jiatingyishengPhone = jiatingyishengService.selectList(new EntityWrapper<JiatingyishengEntity>().in("jiatingyisheng_phone", seachFields.get("jiatingyishengPhone")).eq("jiatingyisheng_delete", 1));
                        if(jiatingyishengEntities_jiatingyishengPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiatingyishengEntity s:jiatingyishengEntities_jiatingyishengPhone){
                                repeatFields.add(s.getJiatingyishengPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiatingyishengService.insertBatch(jiatingyishengList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        JiatingyishengEntity jiatingyisheng = jiatingyishengService.selectOne(new EntityWrapper<JiatingyishengEntity>().eq("username", username));
        if(jiatingyisheng==null || !jiatingyisheng.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(jiatingyisheng.getJiatingyishengDelete() != 1)
            return R.error("账户已被删除");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(jiatingyisheng.getId(),username, "jiatingyisheng", "家庭医生");
        R r = R.ok();
        r.put("token", token);
        r.put("role","家庭医生");
        r.put("username",jiatingyisheng.getJiatingyishengName());
        r.put("tableName","jiatingyisheng");
        r.put("userId",jiatingyisheng.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody JiatingyishengEntity jiatingyisheng){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<JiatingyishengEntity> queryWrapper = new EntityWrapper<JiatingyishengEntity>()
            .eq("username", jiatingyisheng.getUsername())
            .or()
            .eq("jiatingyisheng_phone", jiatingyisheng.getJiatingyishengPhone())
            .andNew()
            .eq("jiatingyisheng_delete", 1)
            ;
        JiatingyishengEntity jiatingyishengEntity = jiatingyishengService.selectOne(queryWrapper);
        if(jiatingyishengEntity != null)
            return R.error("账户或者联系方式已经被使用");
        jiatingyisheng.setJiatingyishengDelete(1);
        jiatingyisheng.setCreateTime(new Date());
        jiatingyishengService.insert(jiatingyisheng);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        JiatingyishengEntity jiatingyisheng = new JiatingyishengEntity();
        jiatingyisheng.setPassword("123456");
        jiatingyisheng.setId(id);
        jiatingyishengService.updateById(jiatingyisheng);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        JiatingyishengEntity jiatingyisheng = jiatingyishengService.selectOne(new EntityWrapper<JiatingyishengEntity>().eq("username", username));
        if(jiatingyisheng!=null){
            jiatingyisheng.setPassword("123456");
            boolean b = jiatingyishengService.updateById(jiatingyisheng);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrJiatingyisheng(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        JiatingyishengEntity jiatingyisheng = jiatingyishengService.selectById(id);
        if(jiatingyisheng !=null){
            //entity转view
            JiatingyishengView view = new JiatingyishengView();
            BeanUtils.copyProperties( jiatingyisheng , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = jiatingyishengService.queryPage(params);

        //字典表数据转换
        List<JiatingyishengView> list =(List<JiatingyishengView>)page.getList();
        for(JiatingyishengView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiatingyishengEntity jiatingyisheng = jiatingyishengService.selectById(id);
            if(jiatingyisheng !=null){


                //entity转view
                JiatingyishengView view = new JiatingyishengView();
                BeanUtils.copyProperties( jiatingyisheng , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody JiatingyishengEntity jiatingyisheng, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiatingyisheng:{}",this.getClass().getName(),jiatingyisheng.toString());
        Wrapper<JiatingyishengEntity> queryWrapper = new EntityWrapper<JiatingyishengEntity>()
            .eq("username", jiatingyisheng.getUsername())
            .or()
            .eq("jiatingyisheng_phone", jiatingyisheng.getJiatingyishengPhone())
            .andNew()
            .eq("jiatingyisheng_delete", 1)
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiatingyishengEntity jiatingyishengEntity = jiatingyishengService.selectOne(queryWrapper);
        if(jiatingyishengEntity==null){
            jiatingyisheng.setJiatingyishengDelete(1);
            jiatingyisheng.setCreateTime(new Date());
        jiatingyisheng.setPassword("123456");
        jiatingyishengService.insert(jiatingyisheng);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }


}
