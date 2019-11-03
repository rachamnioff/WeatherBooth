package com.rakel.he.weatherbooth.di.modules;

import com.rakel.he.weatherbooth.model.ApiService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetModule_ProvideApiServiceFactory implements Factory<ApiService> {
  private final NetModule module;

  private final Provider<Retrofit> retrofitProvider;

  public NetModule_ProvideApiServiceFactory(NetModule module, Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public ApiService get() {
    return provideInstance(module, retrofitProvider);
  }

  public static ApiService provideInstance(NetModule module, Provider<Retrofit> retrofitProvider) {
    return proxyProvideApiService(module, retrofitProvider.get());
  }

  public static NetModule_ProvideApiServiceFactory create(
      NetModule module, Provider<Retrofit> retrofitProvider) {
    return new NetModule_ProvideApiServiceFactory(module, retrofitProvider);
  }

  public static ApiService proxyProvideApiService(NetModule instance, Retrofit retrofit) {
    return Preconditions.checkNotNull(
        instance.provideApiService(retrofit),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
