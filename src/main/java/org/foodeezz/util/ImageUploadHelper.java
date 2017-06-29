package org.foodeezz.util;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bakhtiar.galib on 4/2/15.
 */
@Component
public class ImageUploadHelper {

    static final List<String> VALID_IMAGE_TYPES = new ArrayList<String>()
        {{
            add("image/jpeg");
            add("image/png");
        }};

    static final int IMAGE_SIZE_IN_BYTES = 500000;

    public static boolean isValidImage(MultipartFile image) {
        return ( isValidType(image) && image.getSize() <= IMAGE_SIZE_IN_BYTES )|| image.isEmpty();
    }

    public static boolean isValidType(MultipartFile image){
        return VALID_IMAGE_TYPES.contains(image.getContentType());
    }
}
