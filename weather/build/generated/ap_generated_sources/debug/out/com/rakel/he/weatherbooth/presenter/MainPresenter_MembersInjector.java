package com.rakel.he.weatherbooth.presenter;

import com.rakel.he.weatherbooth.contacts.MainContacts;
import com.rakel.he.weatherbooth.model.ApiService;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainPresenter_MembersInjector implements MembersInjector<MainPresenter> {
  private final Provider<MainContacts.View> viewProvider;

  private final Provider<ApiService> apiServiceProvider;

  public MainPresenter_MembersInjector(
      Provider<MainContacts.View> viewProvider, Provider<ApiService> apiServiceProvider) {
    this.viewProvider = viewProvider;
    this.apiServiceProvider = apiServiceProvider;
  }

  public static MembersInjector<MainPresenter> create(
      Provider<MainContacts.View> viewProvider, Provider<ApiService> apiServiceProvider) {
    return new MainPresenter_MembersInjector(viewProvider, apiServiceProvider);
  }

  @Override
  public void injectMembers(MainPresenter instance) {
    injectMainPresenter(instance, viewProvider.get(), apiServiceProvider.get());
  }

  public static void injectMainPresenter(
      MainPresenter instance, MainContacts.View view, ApiService apiService) {
    instance.MainPresenter(view, apiService);
  }
}
