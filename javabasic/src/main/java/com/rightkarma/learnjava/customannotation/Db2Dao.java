package com.rightkarma.learnjava.customannotation;

class Db2Dao implements dao{

    @Override
    public void savePojo(SomePojo somePojo) {
        System.out.println("run code to save data to DB2. somePojo:"+somePojo.getId());
    }
}
