package flink.base.wordcount;

import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class WordLamdbaCount {
    public static void main(String[] args) throws Exception {
        // 创建好 StreamExecutionEnvironment（流程序的运行环境）
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // 给流程序的运行环境设置全局的配置（从参数 args 获取）
        env.getConfig().setGlobalJobParameters(ParameterTool.fromArgs(args));
        // 构建数据源，WORDS是下面定义的字符串数组
        DataStreamSource<String> dataStreamSource = env.fromElements(WORDS);
        // 将字符串进行分隔然后收集
        SingleOutputStreamOperator<String[]> splitOperator = dataStreamSource.flatMap(
                (String input, Collector<String[]> collector) -> collector.collect(input.toLowerCase().split("\\W+")));
        // 分割后字符串组装后的数据格式是 (word、1)，1 代表 word 出现的次数为 1
        SingleOutputStreamOperator<Tuple2<String, Integer>> opt = splitOperator.flatMap((String[] words, Collector<Tuple2<String, Integer>> collector) -> {
            for (String word : words) {
                collector.collect(new Tuple2<>(word, 1));
            }
        });
        // 根据 word 关键字进行分组（0 代表对第一个字段分组，也就是对 word 进行分组）
        opt.keyBy(0)
                // 对单个 word 进行计数操作
                .reduce((ReduceFunction<Tuple2<String, Integer>>) (value1, value2)
                        -> new Tuple2<>(value1.f0, value1.f1 + value2.f1))
                // 打印所有的数据流，格式是 (word，count)，count 代表 word 出现的次数
                .print();
        // 开始执行 Job
        env.execute("zhisheng —— word count streaming demo");
    }

    private static final String[] WORDS = new String[]{
            "To be, or not to be,--that is the question:--", "Whether 'tis nobler in the mind to suffer"
    };
}
