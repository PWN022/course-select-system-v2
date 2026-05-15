package org.example.springboot.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

public class PinyinUtils {
    public static String toPinyin(String chinese) {
        if (chinese == null || chinese.trim().isEmpty()) return "";
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        // 不带声调
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        StringBuilder sb = new StringBuilder();
        for (char c : chinese.toCharArray()) {
            try {
                String[] arr = PinyinHelper.toHanyuPinyinStringArray(c, format);
                if (arr != null && arr.length > 0) {
                    sb.append(arr[0]);
                } else {
                    sb.append(c); // 非汉字原样保留
                }
            } catch (Exception e) {
                sb.append(c);
            }
        }
        return sb.toString().toLowerCase().replaceAll(" ", "");
    }
}
