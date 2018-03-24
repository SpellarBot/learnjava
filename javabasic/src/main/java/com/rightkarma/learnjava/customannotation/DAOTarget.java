package com.rightkarma.learnjava.customannotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

import static com.rightkarma.learnjava.customannotation.DaoTargetType.*;

/**
 * LearningNote
 * Use case - use reflection to read annotations and do processing accordingly.
 * Here, BusinessLayer has access to 2 daos. But it decides which dao to use for saving data depending upon annotations in daowrapper.
 * So, if in your application, you are using two DAO implementations - Elastic and DB2 and save different data in different DAOs, you can annotate wrapper
 * to decide which actual dao will be used. This saves developers from writing if else blocks for each save operation to decide where the data will be persisted
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DAOTarget {
    DaoTargetType getDaoTarget() default DaoTargetType.ES;
}

class BusinessLayer{
    ESDao esdao = new ESDao();
    Db2Dao db2dao = new Db2Dao();

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
       BusinessLayer businessLayer = new BusinessLayer();
       businessLayer.iHavePojo();
    }
    public void iHavePojo() throws IllegalAccessException, InstantiationException {
        SomePojo obj = new SomePojo();
        obj.setId(11);
        Class<SaveDataDaoWrapper> saveDataDaoClass = SaveDataDaoWrapper.class;
        SaveDataDaoWrapper saveDataDaoWrapper = saveDataDaoClass.newInstance();
        Method[] methods = saveDataDaoClass.getDeclaredMethods();
        for(Method m : methods){
            DAOTarget target = m.getAnnotation(DAOTarget.class);
            if ( target!= null){
                if ( target.getDaoTarget().equals(DaoTargetType.ES) ){
                    esdao.savePojo(obj);
                } else if ( target.getDaoTarget().equals(DaoTargetType.DB2) ){
                    db2dao.savePojo(obj);
                }
                else {
                    System.out.println("specify where to save the object");
                }
            }
            else {
                System.out.println("specify where to save the object");
            }
        }
    }

}


class SaveDataDaoWrapper implements dao{

//    @DAOTarget(getDaoTarget = ES)
    @DAOTarget(getDaoTarget = DB2)
    @Override
    public void savePojo(SomePojo somePojo) {

    }
}


interface dao{
    void savePojo(SomePojo somePojo);
}

class ESDao implements dao{
    @Override
    public void savePojo(SomePojo somePojo) {
        System.out.println("run code to save data to ES. somePojo:"+somePojo.getId());
    }
}
class Db2Dao implements dao{

    @Override
    public void savePojo(SomePojo somePojo) {
        System.out.println("run code to save data to DB2. somePojo:"+somePojo.getId());
    }
}

class  SomePojo{
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}