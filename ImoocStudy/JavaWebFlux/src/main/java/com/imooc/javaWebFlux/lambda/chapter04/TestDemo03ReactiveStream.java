package com.imooc.javaWebFlux.lambda.chapter04;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class TestDemo03ReactiveStream {

    public static void main(String[] args) throws InterruptedException {

//         1、定义发布者，发布的数据类型为Integer
//        直接使用jdk自带的SubmissionPublisher 他实现了Publisher接口
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
//2、定义订阅者
        Flow.Subscriber<Integer> subscriber = new Flow.Subscriber<Integer>() {

            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
//    保存订阅关系，需要用他来给发布者响应
                this.subscription = subscription;
//   请求一个数据
                this.subscription.request(1);
            }

            @Override
            public void onNext(Integer item) {
//接受到一个数据，处理
                System.out.println("接受到数据 " + item);
//                处理完调用 request再请求一个数据
                this.subscription.request(1);
//                或者， 已经达到了目标，调用cancel告诉发布者不再接受数据了
//                this.subscription.cancel();
            }

            @Override
            public void onError(Throwable throwable) {
//出现了异常，（例如处理数据的时候产生了异常）
                throwable.printStackTrace();
//                我们可以告诉发布者，后面不再接受数据了
                this.subscription.cancel();
            }

            @Override
            public void onComplete() {
//                全部数据处理完了(发布者关闭了)
                System.out.println("处理完了");

            }
        };

//`3、发布者和订阅者  简历订阅关系
        publisher.subscribe(subscriber);

//        4、生产数据，并发布
//        这里忽略生产过程
        int data = 111;
        publisher.submit(data);
        publisher.submit(2222);
        publisher.submit(3333);
//        5、结束后，关闭发布者
//        正式环境，应该放在finally中或者使用try。。resouce确保关闭
        publisher.close();

//        z主线程延迟停止，否则数据没有消费就退出了
        Thread.currentThread().join(1000);

    }
}
