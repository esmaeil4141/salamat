package ir.sharif.random.salamat;

public interface MainMVPInterface {

    public interface ProvidedPresenterOps {
        void onCreate();

        void onConfigurationChanged(RequiredViewOps view);

        void onDestroy(boolean isChangingConfig);


    }

    public interface ProvidedModelOps {
        void onDestroy();

        void onCreate();

        void registerUser(String email, String password);
    }

    public interface RequiredViewOps {

    }

    public interface RequiredPresenterOps {
        void registeredSuccessfully();
    }
}
