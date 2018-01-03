package com.xzt.uc;

/**
 * Created by asus on 2017/11/20.
 */

public interface DownloadListener {

    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();

}
