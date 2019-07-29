package com.constructor2;

public class ConstructorTest {
    
    public static void main(String[] args) {
        Manager manager = new Manager();
        BuilderCompanyA builderCompanyA =  new BuilderCompanyA();
        manager.setBuilder(builderCompanyA);
        
        Product product = manager.constructProduct();
        product.show();
    }

}

class Product {
    private String tv;
    private String sofa;

    public void setTV(String tv) {
        this.tv = tv;
    }

    public void setSofa(String sofa) {
        this.sofa = sofa;
    }
    
    public void show() {
        System.out.println("新房布局, TV:" + tv + " sofa:" + sofa);
    }
}

interface Builder {
    public Product returnProduct();
}

class Manager {
    private Builder builder;
    public void setBuilder(Builder builder){
        this.builder = builder;
    }
    
    public Product constructProduct() {
        return builder.returnProduct();
    }
}

class BuilderCompanyA implements Builder {
    @Override
    public Product returnProduct() {
        Product product = new Product();
        product.setSofa("真皮沙发");
        product.setTV("华为电视");
        
        return product;
    }  
}

class BuilderCompanyB implements Builder {
    @Override
    public Product returnProduct() {
        Product product = new Product();
        product.setSofa("仿皮沙发");
        product.setTV("小米电视");
        
        return product;
    }  
}
