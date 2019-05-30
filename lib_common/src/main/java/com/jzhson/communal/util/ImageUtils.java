package com.jzhson.communal.util;

import android.net.Uri;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * Created by Hjb on 2019/5/30.
 */

public class ImageUtils {

    public static void loadNetImage(SimpleDraweeView simpleDraweeView, String url) {
        Uri uri = Uri.parse(url);
        loadImage(simpleDraweeView, uri);
    }

    public static void loadLocalImage(SimpleDraweeView simpleDraweeView, String fileName) {
        Uri uri = Uri.parse("file://" + fileName);
        loadImage(simpleDraweeView, uri);
    }

    public static void loadResourceImage(SimpleDraweeView simpleDraweeView, @DrawableRes int resId) {
        Uri uri = Uri.parse("res:///" + resId);
        loadImage(simpleDraweeView, uri);
    }

    public static void loadContentProviderImage(SimpleDraweeView simpleDraweeView, int resId) {
        Uri uri = Uri.parse("content:///" + resId);
        loadImage(simpleDraweeView, uri);
    }

    public static void loadAssetImage(SimpleDraweeView simpleDraweeView, int resId) {
        Uri uri = Uri.parse("asset:///" + resId);
        loadImage(simpleDraweeView, uri);
    }

    /**
     * 加载图片核心方法
     *
     * @param simpleDraweeView              图片加载控件
     * @param uri                           图片加载地址

     */
    public static void loadImage(SimpleDraweeView simpleDraweeView, Uri uri) {
        //构建并获取ImageRequest
        ImageRequest imageRequest = getImageRequest(uri, simpleDraweeView);
        //构建并获取Controller
        DraweeController draweeController = getController(imageRequest, simpleDraweeView.getController());
        //开始加载
        simpleDraweeView.setController(draweeController);
    }

    /**
     * 构建、获取ImageRequest
     * @param uri 加载路径
     * @param simpleDraweeView 加载的图片控件
     * @return ImageRequest
     */
    public static ImageRequest getImageRequest(Uri uri, SimpleDraweeView simpleDraweeView) {

        int width;
        int height;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            width = simpleDraweeView.getWidth();
            height = simpleDraweeView.getHeight();
        } else {
            width = simpleDraweeView.getMaxWidth();
            height = simpleDraweeView.getMaxHeight();
        }

        //根据请求路径生成ImageRequest的构造者
        ImageRequestBuilder builder = ImageRequestBuilder.newBuilderWithSource(uri);
        //调整解码图片的大小
        if (width > 0 && height > 0) {
            builder.setResizeOptions(new ResizeOptions(width, height));
        }
        //设置是否开启渐进式加载，仅支持JPEG图片
        builder.setProgressiveRenderingEnabled(true);
        return builder.build();
    }

    public static DraweeController getController(ImageRequest request, @Nullable DraweeController oldController) {

        PipelineDraweeControllerBuilder builder = Fresco.newDraweeControllerBuilder();
        builder.setImageRequest(request);//设置图片请求
        builder.setTapToRetryEnabled(false);//设置是否允许加载失败时点击再次加载
        builder.setAutoPlayAnimations(true);//设置是否允许动画图自动播放
        builder.setOldController(oldController);
        return builder.build();
    }
}
