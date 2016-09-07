package ir.sharif.random.salamat.model;


import ir.sharif.random.salamat.MainMVPInterface;
import ir.sharif.random.salamat.model.localDataBase.DataBaseService;

/**
 * Created by Esmaeil Gholami on 2016/08/12.
 */
public class MainModel implements MainMVPInterface.ProvidedModelOps {

    private MainMVPInterface.RequiredPresenterOps mPresenter;
    private DataBaseService dataBaseService;

    public MainModel(MainMVPInterface.RequiredPresenterOps mPresenter, DataBaseService service) {
        this.mPresenter = mPresenter;
        this.dataBaseService = service;
    }

    @Override
    public void onDestroy() {
        mPresenter = null; // let presenter be available for GC
    }
}
