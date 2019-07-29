package com.constructor1;

public class ConstructorTest {
    public static void main(String[] args) {
        Assistant assistant = new Assistant();

        TrafficPackageA a = new TrafficPackageA();
        assistant.setPackageBulider(a);
        TrafficPackage xioamingPackage = assistant.constructPackage();
        xioamingPackage.showInfo();
        
        TrafficPackageB b = new TrafficPackageB();
        assistant.setPackageBulider(b);
        TrafficPackage xiaozhangPackage = assistant.constructPackage();
        xiaozhangPackage.showInfo();
    }
}


class TrafficPackage {
    private int callDuration;
    private int limit;
    
    public void setCallDuration(int callDuration) {
       this.callDuration = callDuration;
    }
    
    public void setTrafficLimit(int limit) {
        this.limit = limit;
    }
    
    public int getCallDuration() {
        return callDuration;
    }
    
    public int getLimit() {
        return limit;
    }
    
    public void showInfo() {
        System.out.println("通话时长：" + getCallDuration() + "分钟 流量：" + getLimit() + "GB");
    }
}

abstract class TrafficPackageBulider {
    public TrafficPackage trafficPackage = new TrafficPackage();
    
    public abstract void bulidCallDuration();
    public abstract void bulidLimit();
    
    public TrafficPackage getTrafficPackage() {
        return trafficPackage;
    }
    
}

class TrafficPackageA extends TrafficPackageBulider {

    @Override
    public void bulidCallDuration() {
        trafficPackage.setCallDuration(300);
    }

    @Override
    public void bulidLimit() {
        trafficPackage.setTrafficLimit(2);
    }

}

class TrafficPackageB extends TrafficPackageBulider {

    @Override
    public void bulidCallDuration() {
        trafficPackage.setCallDuration(60);
    }

    @Override
    public void bulidLimit() {
        trafficPackage.setTrafficLimit(5);
        
    }

}
class Assistant {
    private TrafficPackageBulider packageBuilder;
    
    public void setPackageBulider(TrafficPackageBulider packageBuilder) {
        this.packageBuilder = packageBuilder;
    }
    
    public TrafficPackage constructPackage() {
        packageBuilder.bulidCallDuration();
        packageBuilder.bulidLimit();
        
        return packageBuilder.getTrafficPackage();
    }
}

