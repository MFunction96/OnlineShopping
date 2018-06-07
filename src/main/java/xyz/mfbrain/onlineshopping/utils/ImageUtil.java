package xyz.mfbrain.onlineshopping.utils;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.taglibs.standard.tag.common.core.NullAttributeException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class ImageUtil {

    /**
     * 上传图片
     * @param request HttpRequest
     * @param fileName 文件名称
     * @throws Exception 访问异常，多为IOException
     */
    public static void Upload(HttpServletRequest request, HttpServlet servlet, String fileName) throws Exception {
        var isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) throw new NullAttributeException("request", "No Upload");
// Create a factory for disk-based file items
        var factory = new DiskFileItemFactory();
// Configure a repository (to ensure a secure temp location is used)
        var servletContext = servlet.getServletConfig().getServletContext();
        var repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

// Create a new file upload handler
        var upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
// Parse the request
        var items = upload.parseRequest(request);
        for (var item : items) {
            if (!item.isFormField()) {
                var extName = item.getName().substring(item.getName().lastIndexOf(".") + 1);
                var dir = new File(servlet.getServletContext().getRealPath("/upload"));
                if (!dir.exists() ) {
                    dir.mkdirs();
                }
                var file = new File(dir,fileName + '.' + extName);
                if (!file.exists()) {
                    file.createNewFile();
                    file.setWritable(true);
                }
                item.write(file);
            }
        }
    }
}
