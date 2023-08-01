package com.sjj.mashibing.command.kitchen;

import java.util.ArrayList;

/**
 * 服务员-> Invoker调用者
 * @author spikeCong
 * @date 2022/10/19
 **/
public class Waiter {

    //可以持有很多的命令对象
    private ArrayList<Command> commands;

    public Waiter() {
        commands = new ArrayList();
    }

    public Waiter(ArrayList<Command> commands) {
        this.commands = commands;
    }

    public void setCommands(Command command) {
        commands.add(command);
    }

    //发出命令 ,指挥厨师工作
    public void orderUp(){
        System.out.println("服务员: 叮咚,有新的订单,请厨师开始制作......");
        for (Command cmd : commands) {
            if(cmd != null){
                cmd.execute();
            }
        }
    }
}