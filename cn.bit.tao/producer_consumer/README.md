#生产者-消费者模型

关于生产者和消费者的定义如下：

生产者持续生产，直到缓冲区满，阻塞；缓冲区不满后，继续生产

消费者持续消费，直到缓冲区空，阻塞；缓冲区不空后，继续消费

生产者可以有多个，消费者也可以有多个

同一产品的消费行为一定发生在生产行为之后

任意时刻，缓冲区大小不小于0，不大于限制容量
