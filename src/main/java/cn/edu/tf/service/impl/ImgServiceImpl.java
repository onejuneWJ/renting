package cn.edu.tf.service.impl;

import cn.edu.tf.dao.HouseDao;
import cn.edu.tf.dao.ImgBoxDao;
import cn.edu.tf.dao.ImgDao;
import cn.edu.tf.pojo.Img;
import cn.edu.tf.service.ImgService;
import org.springframework.stereotype.Service;

/**
 * @author : 王俊
 * @date : 2019/11/11 21:50
 **/
@Service
public class ImgServiceImpl implements ImgService {
    private ImgDao imgDao;
    private ImgBoxDao imgBoxDao;
    private HouseDao houseDao;
    @Override
    public Img createImg(Img img) {

        return img;
    }
}
