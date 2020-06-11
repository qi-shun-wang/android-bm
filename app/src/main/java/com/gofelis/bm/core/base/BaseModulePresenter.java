package com.gofelis.bm.core.base;

public interface BaseModulePresenter<M ,V extends BaseView, I extends BaseInteractorInput, R extends BaseRouting> extends BasePresenter<V,I,R> {

    M getModuleDelegate();

    void setModuleDelegate(M moduleDelegate);
}
