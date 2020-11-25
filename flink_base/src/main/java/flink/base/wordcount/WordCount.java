package flink.base.wordcount;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class WordCount {
    public static void main(String[] args) throws Exception {
        // 创建好 StreamExecutionEnvironment（流程序的运行环境）
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // 给流程序的运行环境设置全局的配置（从参数 args 获取）
        env.getConfig().setGlobalJobParameters(ParameterTool.fromArgs(args));
        // 构建数据源，定义的字符串数组
        DataStreamSource<String> dataStreamSource = env.fromElements(
                "To be, or not to be,--that is the question:--",
                "Whether 'tis nobler in the mind to suffer");
        // 将字符串进行分隔然后收集，组装后的数据格式是 (word、1)，1 代表 word 出现的次数为 1
        // 注：此处如果使用lambda，需要使用returns方法来明确的制定返回类型，具体参照 https://blog.csdn.net/fu_huo_1993/article/details/103108847
        SingleOutputStreamOperator<Tuple2<String, Integer>> singleOutputStreamOperator =
                dataStreamSource.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
                    @Override
                    public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
                        String[] splits = value.toLowerCase().split("\\W+");

                        for (String split : splits) {
                            if (split.length() > 0) {
                                out.collect(new Tuple2<>(split, 1));
                            }
                        }
                    }
                });
        // 根据 word 关键字进行分组（0 代表对第一个字段分组，也就是对 word 进行分组）
        singleOutputStreamOperator.keyBy(0)
                // 对单个 word 进行计数操作
                .reduce((ReduceFunction<Tuple2<String, Integer>>) (value1, value2)
                        -> new Tuple2<>(value1.f0, value1.f1 + value2.f1))
                // 打印所有的数据流，格式是 (word，count)，count 代表 word 出现的次数
                .print();
        // 开始执行 Job
        env.execute("word count streaming demo");
    }
}
