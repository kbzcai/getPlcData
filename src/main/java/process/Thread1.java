package process;

import com.github.s7connector.api.DaveArea;
import com.github.s7connector.api.S7Connector;
import com.github.s7connector.api.factory.S7ConnectorFactory;
import com.github.s7connector.impl.serializer.converter.StringConverter;

public class Thread1 implements Runnable{
    public void run() {
        //创建一个链接对象
        S7Connector connector =
                S7ConnectorFactory
                        .buildTCPConnector()
                        .withHost("192.168.21.30") //
                        .withRack(0) //架机号  可选
                        .withSlot(1) //插槽号  可选
                        .build();
        String data = "qqqqqqqq111";
        byte[] bytes = data.getBytes();
        System.out.println("bytes = " + bytes.length);
        connector.write(DaveArea.DB,1,4,bytes);

        byte[] PlcData = connector.read(
                DaveArea.DB, //选择区块
                1, // 区块编号
                255,  //长度
                4);   //偏移地址
        String str = new String(PlcData);
        String str1 = "";
        System.out.println("读取到的数据="+str);
        StringConverter converter = new StringConverter();
        String extract1 = converter.extract(str1.getClass(), PlcData, 0, 0);
        System.out.println("内置方法转换str="+extract1);
    }
}
