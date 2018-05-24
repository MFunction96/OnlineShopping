package xyz.mfbrain.onlineshopping.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class JsonUtil {
    /**
     * 序列化对象到Json文件
     * @param obj 将实例化的对象
     * @param <T> 类型T
     * @param filePath Json文件路径
     * @throws IOException File Access Exception
     */
    public static <T> void SerializeObj(Object obj, String filePath, boolean appendFile) throws IOException {
        var file = new File(filePath);
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) throw new IOException("Can't create folder!");
        var serializer = new Gson();
        var token = new TypeToken<T>() {
        }.getType();
        var json = serializer.toJson(obj, token);
        if (!file.exists() && !file.createNewFile()) throw new IOException("Can't create file!");
        if (!file.canWrite()) throw new IOException("Can't write file!");
        var writer = new FileWriter(file, appendFile);
        writer.write(json);
        writer.close();
    }

    /**
     * 反序列化Json文件到对象
     * @param filePath Json文件路径
     * @param <T> 类型T
     * @return T类型对象
     * @throws IOException File Access Exception
     */
    public static <T> T DeserializeObj(String filePath) throws IOException {
        var file = new File(filePath);
        if (!file.exists()) throw new IOException("File is NOT Exist!");
        if (!file.canRead()) throw new IOException("File access denied!");
        var input = new FileInputStream(file);
        var buffer = new byte[(int) file.length()];
        if (input.read(buffer) != -1) throw new IOException("Fail to read file!");
        input.close();
        var json = new String(buffer, "UTF-8");
        var deserializer = new Gson();
        var token = new TypeToken<T>() {
        }.getType();
        return deserializer.fromJson(json, token);
    }
}
