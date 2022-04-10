package level0.proxy.staticproxy;

import level0.proxy.BizService;

public class BizServiceImpl implements BizService {

    @Override
    public String process() {
        return this.getClass().getSimpleName() + "process ..... ";
    }

    @Override
    public Boolean matchIt() {
        return Boolean.TRUE;
    }
}
