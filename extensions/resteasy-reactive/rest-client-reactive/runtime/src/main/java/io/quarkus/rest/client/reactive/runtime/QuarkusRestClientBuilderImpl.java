package io.quarkus.rest.client.reactive.runtime;

import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import jakarta.ws.rs.core.Configuration;

import org.eclipse.microprofile.rest.client.RestClientDefinitionException;
import org.eclipse.microprofile.rest.client.ext.QueryParamStyle;

import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;

public class QuarkusRestClientBuilderImpl implements QuarkusRestClientBuilder {

    private final RestClientBuilderImpl proxy;

    public QuarkusRestClientBuilderImpl(RestClientBuilderImpl proxy) {
        this.proxy = proxy;
    }

    @Override
    public QuarkusRestClientBuilder baseUrl(URL url) {
        proxy.baseUrl(url);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder baseUri(URI uri) {
        proxy.baseUri(uri);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder connectTimeout(long timeout, TimeUnit unit) {
        proxy.connectTimeout(timeout, unit);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder readTimeout(long timeout, TimeUnit unit) {
        proxy.readTimeout(timeout, unit);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder sslContext(SSLContext sslContext) {
        proxy.sslContext(sslContext);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder verifyHost(boolean verifyHost) {
        proxy.verifyHost(verifyHost);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder trustStore(KeyStore trustStore) {
        proxy.trustStore(trustStore);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder trustStore(KeyStore trustStore, String trustStorePassword) {
        proxy.trustStore(trustStore, trustStorePassword);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder keyStore(KeyStore keyStore, String keystorePassword) {
        proxy.keyStore(keyStore, keystorePassword);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder hostnameVerifier(HostnameVerifier hostnameVerifier) {
        proxy.hostnameVerifier(hostnameVerifier);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder followRedirects(boolean follow) {
        proxy.followRedirects(follow);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder proxyAddress(String proxyHost, int proxyPort) {
        proxy.proxyAddress(proxyHost, proxyPort);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder proxyPassword(String proxyPassword) {
        proxy.proxyPassword(proxyPassword);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder proxyUser(String proxyUser) {
        proxy.proxyUser(proxyUser);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder nonProxyHosts(String nonProxyHosts) {
        proxy.nonProxyHosts(nonProxyHosts);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder queryParamStyle(QueryParamStyle style) {
        proxy.queryParamStyle(style);
        return this;
    }

    @Override
    public Configuration getConfiguration() {
        return proxy.getConfiguration();
    }

    @Override
    public QuarkusRestClientBuilder property(String name, Object value) {
        proxy.property(name, value);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder register(Class<?> componentClass) {
        proxy.register(componentClass);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder register(Class<?> componentClass, int priority) {
        proxy.register(componentClass, priority);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder register(Class<?> componentClass, Class<?>... contracts) {
        proxy.register(componentClass, contracts);
        return null;
    }

    @Override
    public QuarkusRestClientBuilder register(Class<?> componentClass, Map<Class<?>, Integer> contracts) {
        proxy.register(componentClass, contracts);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder register(Object component) {
        proxy.register(component);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder register(Object component, int priority) {
        proxy.register(component, priority);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder register(Object component, Class<?>... contracts) {
        proxy.register(component, contracts);
        return this;
    }

    @Override
    public QuarkusRestClientBuilder register(Object component, Map<Class<?>, Integer> contracts) {
        proxy.register(component, contracts);
        return this;
    }

    @Override
    public <T> T build(Class<T> clazz) throws IllegalStateException, RestClientDefinitionException {
        return proxy.build(clazz);
    }
}
