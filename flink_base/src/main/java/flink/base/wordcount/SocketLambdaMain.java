package flink.base.wordcount;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.typeutils.TupleTypeInfo;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * Desc: socket
 * Created by zhisheng on 2019-04-26
 * blog：http://www.54tianzhisheng.cn/
 * 微信公众号：zhisheng
 */
public class SocketLambdaMain {
    public static void main(String[] args) throws Exception {
        // 先启用端口监听 nc -l -p 9000
        String hostName = "127.0.0.1";
        int port = 9000;
        //参数检查
        if (args.length == 2) {
            hostName = args[0];
            port = Integer.parseInt(args[1]);
        }
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // 构建数据源，获取 Socket 数据
        DataStreamSource<String> stream = env.socketTextStream(hostName, port);
        // 对 Socket 数据字符串分隔后收集在根据 word 分组后计数
        stream.flatMap((s, collector) -> {
            for (String token : s.toLowerCase().split("\\W+")) {
                if (token.length() > 0) {
                    collector.collect(new Tuple2<String, Integer>(token, 1));
                }
            }
        })
                .returns((TypeInformation) TupleTypeInfo.getBasicTupleTypeInfo(String.class, Integer.class))
                .keyBy(0)
                .sum(1)
                .print();

        env.execute("Java WordCount from SocketTextStream Example");
    }
}