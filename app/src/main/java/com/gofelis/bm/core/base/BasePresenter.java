package com.gofelis.bm.core.base;

/**
 * Presenter contains view logic for preparing content for display (as received from the Interactor) and for reacting to user inputs (by requesting new data from the Interactor).
 *
 * Entities are never passed from the Interactor to the Presenter.
 * Instead, simple data structures that have no behavior are passed from the Interactor to the Presenter.
 * This prevents any ‘real work’ from being done in the Presenter.
 * The Presenter can only prepare the data for display in the View.
 */
public interface BasePresenter<V extends BaseView,  I extends BaseInteractorInput, R extends BaseRouting>  {

    I getInteractor();
    R getRouting();
    V getView();

    void setRouting(R routing);
    void setInteractor(I interactor);

    void attachView(V view);
    void detachView();


}