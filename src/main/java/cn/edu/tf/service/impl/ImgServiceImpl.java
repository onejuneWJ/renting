package cn.edu.tf.service.impl;

import cn.edu.tf.dao.HouseDao;
import cn.edu.tf.dao.ImgBoxDao;
import cn.edu.tf.dao.ImgDao;
import cn.edu.tf.pojo.Img;
import cn.edu.tf.pojo.ImgBox;
import cn.edu.tf.service.ImgService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author : 王俊
 * @date : 2019/11/11 21:50
 **/
@Service
public class ImgServiceImpl implements ImgService {
    private ImgDao imgDao;
    private ImgBoxDao imgBoxDao;
    private HouseDao houseDao;

    public ImgServiceImpl(ImgDao imgDao, ImgBoxDao imgBoxDao, HouseDao houseDao) {
        this.imgDao = imgDao;
        this.imgBoxDao = imgBoxDao;
        this.houseDao = houseDao;
    }

    @Override
    public Img createImg(Img img, HttpSession session) {
        Long imgBoxId = (Long) session.getAttribute("IMG_BOX_ID");
        if (Objects.isNull(imgBoxId)) {
            ImgBox imgBox = new ImgBox();
            imgBoxDao.insert(imgBox);
            img.setBoxId(imgBox.getId());
        } else {
            img.setBoxId(imgBoxId);
        }
        imgDao.insert(img);
        session.setAttribute("IMG_BOX_ID", img.getBoxId());
        return img;
    }
}
