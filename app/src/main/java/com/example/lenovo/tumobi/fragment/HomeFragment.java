package com.example.lenovo.tumobi.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lenovo.tumobi.R;
import com.example.lenovo.tumobi.adapter.NaviLvAdapter;
import com.example.lenovo.tumobi.base.BaseMvpFragment;
import com.example.lenovo.tumobi.interfaces.IPersenter;
import com.example.lenovo.tumobi.interfaces.home.HomeContract;
import com.example.lenovo.tumobi.model.bean.home_bean.Frist_Bean;
import com.example.lenovo.tumobi.persenter.home_persenter.HomePersenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseMvpFragment implements HomeContract.View {


    @BindView(R.id.frist_ban)
    Banner fristBan;
    @BindView(R.id.iv_frist_home)
    ImageView ivFristHome;
    @BindView(R.id.tv_frist_home)
    TextView tvFristHome;
    @BindView(R.id.iv_frist_kitchen)
    ImageView ivFristKitchen;
    @BindView(R.id.tv_frist_kitchen)
    TextView tvFristKitchen;
    @BindView(R.id.iv_frist_parts)
    ImageView ivFristParts;
    @BindView(R.id.tv_frist_parts)
    TextView tvFristParts;
    @BindView(R.id.iv_frist_clothes)
    ImageView ivFristClothes;
    @BindView(R.id.tv_frist_clothes)
    TextView tvFristClothes;
    @BindView(R.id.iv_frist_more)
    ImageView ivFristMore;
    @BindView(R.id.tv_frist_more)
    TextView tvFristMore;
    Unbinder unbinder;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.navi_tv)
    TextView naviTv;
    @BindView(R.id.navi_lv)
    RecyclerView naviLv;
    private ArrayList<Frist_Bean.DataBean.BrandListBean> list;
    private NaviLvAdapter adapter;

    @Override
    protected void initData() {
        ((HomePersenter) mPresenter).getHome();
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        adapter = new NaviLvAdapter(getActivity(),list);
        naviLv.setAdapter(adapter);
        naviLv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

    }

    @Override
    protected IPersenter initMvpPresenter() {
        return new HomePersenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void getHomeReturn(Frist_Bean frist_bean) {
        fristBan.setImages(frist_bean.getData().getBanner())
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Frist_Bean.DataBean.BannerBean dataBean = (Frist_Bean.DataBean.BannerBean) path;
                        Glide.with(context).load(dataBean.getImage_url()).into(imageView);
                    }
                }).start();

        if (frist_bean != null) {
            List<Frist_Bean.DataBean.BrandListBean> brandList = frist_bean.getData().getBrandList();
            brandList.addAll(brandList);
            adapter.notifyDataSetChanged();
            Toast.makeText(mContext, frist_bean.getData().toString(), Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(mContext, "数据加载失败", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showError(String err) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
