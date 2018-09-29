package com.dayuxiaoyu.dashboard.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/21 12/58
 * @since
 */

@RequestMapping("/dayu/qiniu")
@Controller
public class QiniuController {

    @RequestMapping("token")
    @ResponseBody
    public String uploadToken(){
        String ak = "BoQZO87sq0mfPi1oONFaAVnUeLrKKmcuPUT6PO80";
        String sk = "fwluIvAlFyV8m-A-1hXXZP8rAbxe3DuVYSD6p38D";
        Auth auth = Auth.create(ak,sk);
        return auth.uploadToken("dayu");
    }

    @RequestMapping(value="upload",method= RequestMethod.GET)
    @ResponseBody
    public String uploadConfig(String action) {
        if("config".equalsIgnoreCase(action)){
            return JSON.toJSONString(this.config());
        } else {
            return "{}";
        }
    }

    @RequestMapping(value="upload",method= RequestMethod.POST)
    @ResponseBody
    public String upload(String action,MultipartFile file) {

        if("config".equalsIgnoreCase(action)){
            return JSON.toJSONString(this.config());
        }

        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        String token = this.uploadToken();
        try {

            String fileName=file.getOriginalFilename();
            Long size = file.getSize();
            String type = fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;

            Response response = uploadManager.put(file.getInputStream(),null,token,null, null);
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

            Map<String,Object> result = new HashMap<String, Object>();
            result.put("state","SUCCESS");
            result.put("url","http://p2w2xj7bx.bkt.clouddn.com/"+putRet.key);
            result.put("title",putRet.key);
            result.put("original",fileName);
            result.put("type",type);
            result.put("size",size);
            return JSON.toJSONString(result);

        } catch (Exception e) {
            Map<String,Object> result = new HashMap<String, Object>();
            result.put("state",e.getMessage());
            return JSON.toJSONString(result);
        }
    }

    public Map<String,Object> config(){
        Map<String,Object> config = new HashMap<String,Object>();
        config.put("mageActionName","uploadimage");
        config.put("imageFieldName","file");
        config.put("imageMaxSize",2048000);
        config.put("imageAllowFiles", Arrays.asList(".png", ".jpg", ".jpeg", ".gif", ".bmp"));
        config.put("imageCompressEnable",true);
        config.put("imageCompressBorder",1600);
        config.put("imageInsertAlign","none");
        config.put("imageUrlPrefix","http://p2w2xj7bx.bkt.clouddn.com/");
        config.put("imagePathFormat","");

        return config;
    }
}
