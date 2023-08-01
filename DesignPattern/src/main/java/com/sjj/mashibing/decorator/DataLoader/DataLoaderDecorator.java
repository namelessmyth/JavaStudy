package com.sjj.mashibing.decorator.DataLoader;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/3/30/0030
 */
public class DataLoaderDecorator implements DataLoader {

    private DataLoader wrapper;

    public DataLoaderDecorator(DataLoader wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public String read() {
        return wrapper.read();
    }

    @Override
    public void write(String data) {
        wrapper.write(data);
    }
}
