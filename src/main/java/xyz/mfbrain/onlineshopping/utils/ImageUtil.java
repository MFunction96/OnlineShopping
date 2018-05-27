package xyz.mfbrain.onlineshopping.utils;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class ImageUtil {

    private static final String _upload = "./web/upload";

    /**
     * 上传图片
     * @param request HttpRequest
     * @param fileName 文件名称
     * @throws Exception 访问异常，多为IOException
     */
    public static void Upload(HttpServletRequest request, String fileName) throws Exception {
        var factory = new DiskFileItemFactory();
        var su = new ServletFileUpload(factory);
        su.setHeaderEncoding("UTF-8");
        var items = su.parseRequest(request);
        for (var item : items) {
            if (!item.isFormField()) {
                var extName = item.getName().substring(item.getName().lastIndexOf(".") + 1);
                var file = new File(_upload, fileName + '.' + extName);
                item.write(file);
            }
        }
    }
}
