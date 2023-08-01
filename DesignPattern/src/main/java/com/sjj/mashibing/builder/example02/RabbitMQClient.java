package com.sjj.mashibing.builder.example02;

/**
 * 建造者模式-重构
 *
 * @author spikeCong
 * @date 2022/9/19
 **/
public class RabbitMQClient {

    //私有构造方法
    private RabbitMQClient(Builder builder) {
    }

    public static class Builder {
        //属性密闭性,保证对象不可变
        private String host = "127.0.0.1";
        private int port = 5672;
        private int mode;
        private String exchange;
        private String queue;
        private boolean isDurable = true;
        int connectionTimeout = 1000;

        public Builder setHost(String host) {
            this.host = host;
            return this;
        }

        public Builder setPort(int port) {
            this.port = port;
            return this;
        }

        public Builder setMode(int mode) {
            this.mode = mode;
            return this;
        }

        public Builder setExchange(String exchange) {
            this.exchange = exchange;
            return this;
        }

        public Builder setQueue(String queue) {
            this.queue = queue;
            return this;
        }

        public Builder setDurable(boolean durable) {
            isDurable = durable;
            return this;
        }

        public Builder setConnectionTimeout(int connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
            return this;
        }


        //返回构建好的复杂对象
        public RabbitMQClient build() {
            //首先进行校验
            if (mode == 1) { //工作队列模式不需要设计交换机,但是队列名称一定要有
                if (exchange != null) {
                    throw new RuntimeException("工作队列模式无需设计交换机");
                }
                if (queue == null || queue.trim().equals("")) {
                    throw new RuntimeException("工作队列模式名称不能为空");
                }
                if (isDurable == false) {
                    throw new RuntimeException("工作队列模式必须开启持久化");
                }
            } else if (mode == 2) { //路由模式必须设计交换机,但是不能设计队列
                if (exchange == null) {
                    throw new RuntimeException("路由模式下必须设置交换机");
                }
                if (queue != null) {
                    throw new RuntimeException("路由模式无须设计队列名称");
                }
            }
            return new RabbitMQClient(this);
        }
    }

    public void sendMessage(String msg) {
        System.out.println("发送消息......");
    }

    public static void main(String[] args) {
        //使用链式编程设置参数
        RabbitMQClient client = new RabbitMQClient.Builder().setHost("192.168.52.123").setMode(2).setExchange("text-exchange")
                .setPort(5672).setDurable(true).build();
        client.sendMessage("Test");
    }
}