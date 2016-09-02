package za.ac.cput.rcarstens.conf.factory;

import za.ac.cput.rcarstens.domain.DetailsCheck;

import java.util.Map;

/**
 * Created by sanXion on 2016/04/03.
 */
public class DetailsCheckFactory {

    public static DetailsCheck createDetailsCheck(String response){
        return new DetailsCheck.Builder()
                .response(response)
                .build();
    }
}
