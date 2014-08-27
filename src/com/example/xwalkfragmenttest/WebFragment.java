package com.example.xwalkfragmenttest;

import org.xwalk.core.XWalkView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WebFragment extends Fragment {
	
	private XWalkView mXWalkView;
	private String u;
	
	public WebFragment setUrl(String u) {
		this.u = u;
		return this;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_web, container, false);
		mXWalkView = (XWalkView) v.findViewById(R.id.xwalkview);
		return v;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mXWalkView.load(u, null);
	}
	
	@Override
    public void onPause() {
        super.onPause();
        if (mXWalkView != null) {
            mXWalkView.onHide();
            mXWalkView.pauseTimers();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mXWalkView != null) {
            mXWalkView.onShow();
            mXWalkView.resumeTimers();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mXWalkView != null) {
            mXWalkView.onDestroy();
        }
    }

}
