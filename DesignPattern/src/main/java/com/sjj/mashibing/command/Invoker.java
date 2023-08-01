package com.sjj.mashibing.command;

/**
 * 命令的调用者
 */
public class Invoker {

    /**
     * 持有命令对象
     */
    private Command command = null;

    /**
     * 设置调用者持有的命令对象
     *
     * @param command 命令对象
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 示意方法，调用命令执行请求
     */
    public void invoke() {
        command.execute();
    }
}
