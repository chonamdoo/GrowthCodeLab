package com.learn.growthcodelab.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseFragment extends Fragment {



    final public String getTransactionTag(){
        return getClass().getSimpleName();
    }

    @Override
    public void onAttach(Context context) {
        logLifeCycle("onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        logLifeCycle("onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        logLifeCycle("onCreateView");
        View rootView;
        if(getLayoutRes() > 0){
            rootView = bindView(inflater, container, savedInstanceState);
        } else {
            rootView = super.onCreateView(inflater, container, savedInstanceState);
        }
        return rootView;
    }

    protected View bindView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        return inflater.inflate(getLayoutRes(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        logLifeCycle("onCreateView");
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        logLifeCycle("onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        logLifeCycle("onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        logLifeCycle("onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        logLifeCycle("onStop");
        super.onPause();
    }

    @Override
    public void onStop() {
        logLifeCycle("onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        logLifeCycle("onStop");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        logLifeCycle("onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        logLifeCycle("onDetach");
        super.onDetach();
    }

    @LayoutRes
    public int getLayoutRes(){
        return 0;
    }

    protected boolean enableLifeCycleLog(){
        return false;
    }

    final protected void logLifeCycle(String lifeCycle){
        if(enableLifeCycleLog()){
            String lifeCycleFormat = "%1$s:%2$s";
            Log.d("trail", String.format(lifeCycleFormat, getTransactionTag(), lifeCycle));
        }
    }
}
