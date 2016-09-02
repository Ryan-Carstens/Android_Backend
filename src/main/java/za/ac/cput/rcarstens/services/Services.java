package za.ac.cput.rcarstens.services;

import java.util.List;

/**
 * Created by sanXion on 2016/06/06.
 */
public interface Services<S,ID> {

    public S findById(ID id);

    public S save(S entity);

    public S update(S entity);

    public void delete(S entity);

    public List<S> findAll();
}
