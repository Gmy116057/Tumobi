package com.example.lenovo.tumobi.persenter.home_persenter;

import com.example.lenovo.tumobi.base.BasePersenter;
import com.example.lenovo.tumobi.component.CommonSubscriber;
import com.example.lenovo.tumobi.interfaces.home.HomeContract;
import com.example.lenovo.tumobi.model.bean.IndexBean;
import com.example.lenovo.tumobi.model.bean.home_bean.Frist_Bean;
import com.example.lenovo.tumobi.model.http.HttpManager;
import com.example.lenovo.tumobi.utils.RxUtils;

public class HomePersenter extends BasePersenter<HomeContract.View> implements HomeContract.Presenter {
    @Override
    public void getHome() {
        addSubscribe(HttpManager.getMyApi().getHome()
                .compose(RxUtils.<Frist_Bean> rxScheduler())
                .subscribeWith(new CommonSubscriber<Frist_Bean>(mView){
                    @Override
                    public void onNext(Frist_Bean frist_bean) {
                        mView.getHomeReturn(frist_bean);
                    }
                }));
    }
}
