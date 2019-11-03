package com.rakel.he.weatherbooth.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final NetModule module;

  public NetModule_ProvideOkHttpClientFactory(NetModule module) {
    this.module = module;
  }

  @Override
  public OkHttpClient get() {
    return provideInstance(module);
  }

  public static OkHttpClient provideInstance(NetModule module) {
    return proxyProvideOkHttpClient(module);
  }

  public static NetModule_ProvideOkHttpClientFactory create(NetModule module) {
    return new NetModule_ProvideOkHttpClientFactory(module);
  }

  public static OkHttpClient proxyProvideOkHttpClient(NetModule instance) {
    return Preconditions.checkNotNull(
        instance.provideOkHttpClient(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
