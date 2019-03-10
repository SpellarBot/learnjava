package com.rightkarma.learnjava.customannotation;

class ESDao implements dao{
    @Override
    public void savePojo(SomePojo somePojo) {
        System.out.println("run code to save data to ES. somePojo:"+somePojo.getId());
    }
}
