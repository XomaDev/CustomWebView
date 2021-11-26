package com.sunny.CustomWebView;

import androidx.annotation.NonNull;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.Notifier;

import java.util.HashMap;

public class CustomHashMap extends HashMap<Integer, WView> {

    private final Notifier notifier;

    public CustomHashMap(ComponentContainer container) {
        this.notifier = new Notifier(container);
    }

    @Override
    public @NonNull WView get(Object key) {
        final WView webView = super.get(key);
        if (webView == null) {
            // the webview is null because it doesn't exist
            notifier.ShowMessageDialog("Cannot find Web View of ID " + key,
                    "Custom Web View", "Continue");
            throw new IllegalArgumentException();
        }
        return webView;
    }
}
