package com.xiachufang.utils.video;

import android.util.Log;

public class FFmpegNativeHelper {
	public FFmpegNativeHelper() {
	}
	
	static {
		System.loadLibrary("avutil-55");
		System.loadLibrary("swresample-2");
		System.loadLibrary("avcodec-57");
		System.loadLibrary("avformat-57");
		System.loadLibrary("swscale-4");
		System.loadLibrary("avfilter-6");
		System.loadLibrary("avdevice-57");
		System.loadLibrary("ffmpegjni");
	}

	// success 0, error 1
	public static String runCommand(String command) {
		if(command == null || command.length() == 0) {
            return "Command can`t be empty.";
        }

		String[] args = command.split(" ");
		for(int i = 0; i < args.length; i++) {
			Log.d("ffmpeg-jni", args[i]);
		}
		try {
			return ffmpeg_run(args);
		} catch (Exception e) {
			throw e;
		}
	}

	// Deprecated, no use anymore
    public static int init() {
        //return ffmpeg_init();
		return 0;
    }

	// Deprecated, no use anymore
    public static int uninit() {
        //return ffmpeg_uninit();
		return 0;
    }

	private static native int ffmpeg_init();
	private static native int ffmpeg_uninit();
	private static native String ffmpeg_run(String[] args);
}
