package com.example.lenovo.tumobi.interfaces.home;

import com.example.lenovo.tumobi.interfaces.IBaseView;
import com.example.lenovo.tumobi.interfaces.IPersenter;
import com.example.lenovo.tumobi.interfaces.news.NewsContract;
import com.example.lenovo.tumobi.model.bean.home_bean.Frist_Bean;


public interface HomeContract {
    interface View extends IBaseView {
        void getHomeReturn(Frist_Bean frist_bean);
    }

    interface Presenter extends IPersenter<HomeContract.View> {
        void getHome();
    }

}
