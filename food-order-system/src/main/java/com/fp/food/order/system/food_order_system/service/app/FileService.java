package com.fp.food.order.system.food_order_system.service.app;

import com.fp.food.order.system.food_order_system.model.enums.TipeUpload;
import com.fp.food.order.system.food_order_system.model.response.BaseResponse;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    BaseResponse<?> upload(MultipartFile files, TipeUpload tipeUpload);

    Resource loadFileAsResource(String pathFile);

}
