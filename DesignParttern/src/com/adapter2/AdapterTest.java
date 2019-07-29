package com.adapter2;

public class AdapterTest {
    public static void startCharge(DC5V dc5v) {
        dc5v.output5V();
    }

    public static void main(String[] args) {
        DC5V dc5v = new AC110VAdapter();
        startCharge(dc5v);

        dc5v = new AC220VAdapter();
        startCharge(dc5v);   
    }
}

interface DC5V {
    int output5V();
}

class AC220V {
    public int output220V() {
        return 220;
    }
}

class AC110V {
    public int output110V() {
        return 110;
    }
}

// 类适配器方式
class AC220VAdapter extends AC220V implements DC5V {
    @Override
    public int output5V() {
        int inputVolatage = super.output220V();
        int outputVolatage = inputVolatage/44;
        System.out.println("220V适配器工作：AC220V 转DC5V...");
        return outputVolatage;
    }
}

// 对象适配器方式
class AC110VAdapter implements DC5V {
    private AC110V ac110v = new AC110V();

    @Override
    public int output5V() {
        int inputVolatage = ac110v.output110V();
        int outputVolatage = inputVolatage/22;
        System.out.println("110V适配器工作：AC110V 转DC5V...");
        return outputVolatage;
    } 
}
