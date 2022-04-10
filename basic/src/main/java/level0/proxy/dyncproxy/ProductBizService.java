package level0.proxy.dyncproxy;

import level0.proxy.BizService;

public class ProductBizService implements BizService {
    @Override
    public String process() {
        return this.getClass().getSimpleName() + "'s process";
    }

    @Override
    public Boolean matchIt() {
        return Boolean.TRUE;
    }
}
