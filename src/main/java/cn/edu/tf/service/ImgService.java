package cn.edu.tf.service;

import cn.edu.tf.pojo.Img;

import javax.servlet.http.HttpSession;

/**
 * @author : 王俊
 * @date : 2019/11/11 21:50
 **/
public interface ImgService {
    Img createImg(Img img, HttpSession session);
}
