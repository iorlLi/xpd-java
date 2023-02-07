package level0.design.behaviour.template;

import java.math.BigDecimal;

public class HsFile1 extends AbstractFileRead {

    // 根据type匹配具体文件处理类
    // @autowried注入文件处理列表

 /*   public AbstractDao  getDao(){
        return File1Dao;
    }*/

    @Override
    protected <T> T read(String type) {
        System.out.println(type.concat("读取由子类完成解析"));
        File1 file1 = File1.builder()
                .bizId(1L)
                .tradeType(type)
                .amount(new BigDecimal(10086))
                .build();

        return (T) file1;
    }
}
