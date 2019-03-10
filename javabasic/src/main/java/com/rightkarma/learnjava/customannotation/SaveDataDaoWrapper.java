package com.rightkarma.learnjava.customannotation;

import static com.rightkarma.learnjava.customannotation.DaoTargetType.DB2;

class SaveDataDaoWrapper implements dao{

    //    @DAOTarget(getDaoTarget = ES)
    @DAOTarget(getDaoTarget = DB2)
    @Override
    public void savePojo(SomePojo somePojo) {

    }
}
