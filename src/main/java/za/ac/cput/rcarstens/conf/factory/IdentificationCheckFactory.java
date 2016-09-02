package za.ac.cput.rcarstens.conf.factory;

import za.ac.cput.rcarstens.domain.IdentificationCheck;

/**
 * Created by rcarstens on 2016/08/08.
 */
public class IdentificationCheckFactory {
    private static IdentificationCheckFactory factory = null;

    private IdentificationCheckFactory(){

    }

    public static IdentificationCheckFactory getInstance(){
        if (factory == null)
        {factory = new IdentificationCheckFactory();}

        return factory;
    }

    public IdentificationCheck createIdentificationCheck(String response){
        return new IdentificationCheck.Builder()
                .response(response)
                .build();
    }
}
