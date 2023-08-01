package com.sjj.mashibing.decorator.DataLoader;

import cn.hutool.core.io.FileUtil;
import org.apache.tools.ant.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 具体构件（Concrete  Component）角色<br>
 */
public class BaseFileDataLoader implements DataLoader {

    private String filePath;

    public BaseFileDataLoader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String read() {
        String result = FileUtil.readString(new File(filePath), Charset.forName("utf-8"));
        return result;
    }

    @Override
    public void write(String data) {
        FileUtil.writeString(data, new File(filePath), Charset.forName("utf-8"));
    }
}
