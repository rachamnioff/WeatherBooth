package com.rakel.he.weatherbooth.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final NetModule module;

  private final Provider<OkHttpClient> okhttpClientProvider;

  public NetModule_ProvideRetrofitFactory(
      NetModule module, Provider<OkHttpClient> okhttpClientProvider) {
    this.module = module;
    this.okhttpClientProvider = okhttpClientProvider;
  }

  @Override
  public Retrofit get() {
    return provideInstance(module, okhttpClientProvider);
  }

  public static Retrofit provideInstance(
      NetModule module, Provider<OkHttpClient> okhttpClientProvider) {
    return proxyProvideRetrofit(module, okhttpClientProvider.get());
  }

  public static NetModule_ProvideRetrofitFactory create(
      NetModule module, Provider<OkHttpClient> okhttpClientProvider) {
    return new NetModule_ProvideRetrofitFactory(module, okhttpClientProvider);
  }

  public static Retrofit proxyProvideRetrofit(NetModule instance, OkHttpClient okhttpClient) {
    return Preconditions.checkNotNull(
        instance.provideRetrofit(okhttpClient),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
