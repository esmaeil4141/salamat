package ir.sharif.random.salamat.presenter;

import java.lang.ref.WeakReference;

import ir.sharif.random.salamat.MainMVPInterface;
import ir.sharif.random.salamat.model.MainModel;
import ir.sharif.random.salamat.model.localDataBase.DataBaseService;

public class MainPresenter implements MainMVPInterface.RequiredPresenterOps
        , MainMVPInterface.ProvidedPresenterOps {
    // Layer View reference
    private WeakReference<MainMVPInterface.RequiredViewOps> mView;
    // Layer Model reference
    private MainMVPInterface.ProvidedModelOps mModel;

    // Configuration change state
    private boolean mIsChangingConfig;

    //constructor method
    public MainPresenter(MainMVPInterface.RequiredViewOps mView, DataBaseService service) {
        this.mView = new WeakReference<>(mView);
        this.mModel = new MainModel(this,service);
    }

    /**
     * Sent from Activity after a configuration changes
     * @param view  View reference
     */
    @Override
    public void onConfigurationChanged(MainMVPInterface.RequiredViewOps view) {
        this.mView = new WeakReference<>(view);
    }

    /**
     * Receives {@link ir.sharif.random.salamat.view.MainView#onDestroy()} event
     * @param isChangingConfig  Config change state
     */
    @Override
    public void onDestroy(boolean isChangingConfig) {
        mView = null;
        mIsChangingConfig = isChangingConfig;
        if ( !isChangingConfig ) {
            mModel.onDestroy();
        }
    }

    @Override
    public void onCreate() {

    }


}
