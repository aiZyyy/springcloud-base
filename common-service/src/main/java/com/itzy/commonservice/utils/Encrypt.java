package com.itzy.commonservice.utils;

import lombok.SneakyThrows;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * Created with IntelliJ IDEA
 *
 * @author 喵♂呜
 * Created on 2017/6/10 16:17.
 */
public class Encrypt {

    private Encrypt() {}

    /**
     * 通用的密码加密方案
     *
     * @param password
     *         密码
     * @return 加密后的值
     */
    @SneakyThrows
    public static String encryptPassword(String password) {
        return DigestUtils.sha256Hex(password.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 获取文件的MD5值
     *
     * @param file
     *         文件
     * @return MD5值
     */
    @SneakyThrows
    public static String getMd5(File file) {
        FileInputStream in = new FileInputStream(file);
        MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(byteBuffer);
        BigInteger bi = new BigInteger(1, md5.digest());
        in.close();
        return bi.toString(16);
    }

    /**
     * Hash平均分布
     *
     * @param key
     *         钥匙
     * @return 1-5平均分布的hash
     */
    public static long hash(String key) {
        return hash(key, 1, 5);
    }

    /**
     * Hash平均分布
     *
     * @param key
     *         钥匙
     * @param start
     *         开始值
     * @param end
     *         结束值
     * @return start-end平均分布的hash
     */
    public static long hash(String key, int start, int end) {
        long seed = 31;
        long hash = 0;
        int maxHash = 8;
        for (int i = 0; i < key.length() && i < maxHash; i++) {
            hash = hash * seed + key.charAt(i);
        }
        return hash % end + start;
    }
}
