package com.bawei.chenshuaishuai20191202.view.fragment;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.bawei.chenshuaishuai20191202.R;
import com.bawei.chenshuaishuai20191202.base.BaseFragment;
import com.bawei.chenshuaishuai20191202.contract.INewsContract;
import com.bawei.chenshuaishuai20191202.modle.entity.Bean;
import com.bawei.chenshuaishuai20191202.presenter.NewsPresenter;
import com.bawei.chenshuaishuai20191202.utils.NetUtils;

public class NewsFragment extends BaseFragment implements INewsContract.iview {
    private NewsPresenter newsPresenter;

    @Override
    protected void initview(View inflate) {

    }
    @Override
    protected int layoutid() {
        return R.layout.news_fragment_layout;
    }
    @Override
    protected void initdata() {
        newsPresenter=new NewsPresenter(this);
        if (hasnet(getActivity())){
            newsPresenter.getdata("http://mobile.bwstudent.com/small/commodity/v1/findCommodityByKeyword?keyword=1&count=5&page=1");
        }

    }
    @Override
    public void success(Bean bean) {
        Toast.makeText(getActivity(),bean.getMessage(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void failure(Throwable throwable) {
        Toast.makeText(getActivity(),"网络异常",Toast.LENGTH_SHORT).show();
    }
}
