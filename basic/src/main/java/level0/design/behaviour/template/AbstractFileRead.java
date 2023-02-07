package level0.design.behaviour.template;

import com.google.common.collect.Lists;

import java.util.List;

public abstract class AbstractFileRead {
    // 文件检查
    // 文件读取
    // 文件读取后，落操作记录之类的
    public <T>void process(String type) {
        checkFile(type);
        try {
            List<T> list = Lists.newArrayList();
            //for 逐行读
            T read = read(type);
            list.add(read);
            if(list.size() > 500){
                // 批量插入
            }
            System.out.println("DB Batch Operation...");
        } catch (Exception e) {
            doException(type);
        } finally {
            afterProcess(type);
        }
    }

    // 具体方法
    public void checkFile(String type) {
        System.out.println(type.concat("检查文件服务器上的文件状态"));
    }

    // 抽象方法
    protected abstract <T> T read(String type);


    public void afterProcess(String type) {
        System.out.println(type.concat("文件处理完成，落日志记录，更新任务状态"));
    }

    public void doException(String type) {
        System.out.println(type.concat("读取处理异常，记录日志"));
    }
}
