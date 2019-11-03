package com.rakel.he.weatherbooth.di.components;

import com.rakel.he.weatherbooth.di.modules.NetModule;
import com.rakel.he.weatherbooth.di.modules.NetModule_ProvideApiServiceFactory;
import com.rakel.he.weatherbooth.di.modules.NetModule_ProvideOkHttpClientFactory;
import com.rakel.he.weatherbooth.di.modules.NetModule_ProvideRetrofitFactory;
import com.rakel.he.weatherbooth.model.ApiService;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerNetComponent implements NetComponent {
  private Provider<OkHttpClient> provideOkHttpClientProvider;

  private Provider<Retrofit> provideRetrofitProvider;

  private Provider<ApiService> provideApiServiceProvider;

  private DaggerNetComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static NetComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideOkHttpClientProvider =
        DoubleCheck.provider(NetModule_ProvideOkHttpClientFactory.create(builder.netModule));
    this.provideRetrofitProvider =
        DoubleCheck.provider(
            NetModule_ProvideRetrofitFactory.create(
                builder.netModule, provideOkHttpClientProvider));
    this.provideApiServiceProvider =
        DoubleCheck.provider(
            NetModule_ProvideApiServiceFactory.create(builder.netModule, provideRetrofitProvider));
  }

  @Override
  public ApiService getApiService() {
    return provideApiServiceProvider.get();
  }

  public static final class Builder {
    private NetModule netModule;

    private Builder() {}

    public NetComponent build() {
      if (netModule == null) {
        this.netModule = new NetModule();
      }
      return new DaggerNetComponent(this);
    }

    public Builder netModule(NetModule netModule) {
      this.netModule = Preconditions.checkNotNull(netModule);
      return this;
    }
  }
}
