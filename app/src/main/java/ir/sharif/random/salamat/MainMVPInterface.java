package ir.sharif.random.salamat;

/**
 * Created by Esmaeil Gholami on 2016/08/12.
 */
public interface MainMVPInterface {

    public interface ProvidedPresenterOps {
        void onCreate();

        void onConfigurationChanged(RequiredViewOps view);

        void onDestroy(boolean isChangingConfig);

    }

    public interface ProvidedModelOps {
        void onDestroy();
    }

    public interface RequiredViewOps {

    }

    public interface RequiredPresenterOps {

    }
}
