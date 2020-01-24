package com.zz.supercleaner.utils;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;

public class ProcessUtil {
    private static String processName;

    public ProcessUtil() {
    }

    public static String getProcessName(int pid) {
        try {
            String cmdlinePath = "/proc/" + pid + "/cmdline";
            if (FileUtils.isFileExist(cmdlinePath)) {
                StringBuilder content = FileUtils.readFile(cmdlinePath, "UTF-8");
                if (content != null) {
                    return content.toString().split("\u0000")[0];
                }
            }
        } catch (Exception var3) {
            LogUtils.e("ProcessUtil", Log.getStackTraceString(var3));
        }

        return "unknown";
    }

    public static String myProcessName() {
        if (processName == null) {
            Class var0 = ProcessUtil.class;
            synchronized(ProcessUtil.class) {
                if (processName == null) {
                    processName = getProcessName(Process.myPid());
                }
            }
        }

        return processName;
    }

    public static boolean isMainProcess(Context c) {
        return TextUtils.equals(c.getPackageName(), myProcessName());
    }

    public static String myShortProcessName(Context context) {
        String proc = myProcessName();
        String result;
        if (context.getPackageName().equals(proc)) {
            result = "main";
        } else if (!TextUtils.isEmpty(proc)) {
            int index = proc.lastIndexOf(":");
            if (index != -1 && index + 1 < proc.length()) {
                result = proc.substring(index + 1);
            } else {
                result = proc;
            }
        } else {
            result = "unknown";
        }

        return result;
    }
}