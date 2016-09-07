package ir.sharif.random.salamat.model;

import ir.sharif.random.salamat.MainMVPInterface;
import ir.sharif.random.salamat.model.localDataBase.CloudDataBaseService;
import ir.sharif.random.salamat.model.localDataBase.DataBaseService;
import ir.sharif.random.salamat.model.localDataBase.LocalDataBaseService;

public class MainModel implements MainMVPInterface.ProvidedModelOps, DataBaseService.ModelCallBack {

    private MainMVPInterface.RequiredPresenterOps mPresenter;
    private LocalDataBaseService localDataBaseService;
    private CloudDataBaseService cloudDataBaseService;

    public MainModel(MainMVPInterface.RequiredPresenterOps mPresenter, DataBaseService service) {
        this.mPresenter = mPresenter;
        this.localDataBaseService = (LocalDataBaseService) service;
        this.cloudDataBaseService = (CloudDataBaseService) service;
        cloudDataBaseService.setModelCallBack(this);
    }

    @Override
    public void onDestroy() {
        mPresenter = null; // let presenter be available for GC
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void registerUser(String email, String password) {
        cloudDataBaseService.registerUser(email, password);
    }

    @Override
    public void registeredSuccessfully() {
        mPresenter.registeredSuccessfully();
    }
}
