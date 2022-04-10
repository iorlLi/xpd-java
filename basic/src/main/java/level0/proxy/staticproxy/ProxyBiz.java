package level0.proxy.staticproxy;

import level0.proxy.BizService;

public class ProxyBiz implements BizService {
    private BizService target;

    public ProxyBiz(BizService target) {
        this.target = target;
    }

    @Override
    public String process() {
        System.out.println("proxy process start");
        String process = target.process();
        System.out.print("after proxy return ");
        return "proxy " + process;
    }

    @Override
    public Boolean matchIt() {
        return true;
    }

    public static void main(String[] args) {
        BizService bizService = new BizServiceImpl();
        BizService proxyBiz = new ProxyBiz(bizService);
        if(proxyBiz.matchIt()){
            System.out.println(proxyBiz.process());
        }
    }
}
