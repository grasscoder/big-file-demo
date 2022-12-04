package top.bulk.big.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 文件相关的处理
 *
 * @author huql
 * @version 1.0.0
 * @date 2022-11-20
 */
@Slf4j
public class BulkFileUtil {
    private static final Logger log= LoggerFactory.getLogger(BulkFileUtil.class);
    /**
     * 文件下载
     * @param request
     * @param response
     * @param file
     * @throws UnsupportedEncodingException
     */
    public static void downloadFile(HttpServletRequest request, HttpServletResponse response, File file) throws UnsupportedEncodingException {
        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("application/octet-stream");
        FileInputStream fis = null;

        String filename = filenameEncoding(file.getName(), request);
        try {
            fis = new FileInputStream(file);
            response.setHeader("Content-Disposition", String.format("attachment;filename=%s", filename));
            IOUtils.copy(fis, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * 适配不同的浏览器，确保文件名字正常
     *
     * @param filename
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String filenameEncoding(String filename, HttpServletRequest request) throws UnsupportedEncodingException {
        // 获得请求头中的User-Agent
        String agent = request.getHeader("User-Agent");
        // 根据不同的客户端进行不同的编码

        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            //从JKD 9开始rt.jar包已废除，BASE64Encoder在jdk9以上就删除了
            // 从JDK 1.8开始，就提供了java.util.Base64.Decoder和java.util.Base64.Encoder的JDK公共API，
            // 可代替sun.misc.BASE64Decoder和sun.misc.BASE64Encoder的JDK内部API。
           // BASE64Encoder base64Encoder = new BASE64Encoder();
            Base64.Encoder base64Encoder = Base64.getEncoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes(StandardCharsets.UTF_8)) + "?=";
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
