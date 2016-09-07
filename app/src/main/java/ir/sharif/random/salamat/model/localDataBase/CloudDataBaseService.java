package ir.sharif.random.salamat.model.localDataBase;

/**
 * Created by Mojtaba on 9/7/2016.
 */
public interface CloudDataBaseService {

    void setModelCallBack(DataBaseService.ModelCallBack callBack);

    void registerUser(String email, String password);

}
