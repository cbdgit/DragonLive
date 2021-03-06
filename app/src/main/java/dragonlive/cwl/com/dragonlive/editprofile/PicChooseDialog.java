package dragonlive.cwl.com.dragonlive.editprofile;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import dragonlive.cwl.com.dragonlive.R;
import dragonlive.cwl.com.dragonlive.widget.TransParentDialog;

/**
 * Created by cwl on 2018/4/23.
 */

public class PicChooseDialog extends TransParentDialog {
    public View quitLogin;
    public PicChooseDialog(Activity activity) {
        super(activity);
        View view= LayoutInflater.from(activity).inflate(R.layout.dialog_pic_choose,null,false);
        setContentView(view);
        setDialogWidthAndHeght(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        View camera = view.findViewById(R.id.pic_camera);
        View picLib = view.findViewById(R.id.pic_album);
        View cancel = view.findViewById(R.id.pic_cancel);
        quitLogin=view.findViewById(R.id.quit_login);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hide();
                if (onDialogClickListener != null) {
                    onDialogClickListener.onCamera();
                }
            }
        });
        picLib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
                if (onDialogClickListener != null) {
                    onDialogClickListener.onAlbum();
                }
            }
        });
        quitLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //退出登录
               onDialogClickListener.onQuitLogin(v);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
            }
        });
    }
    private OnDialogClickListener onDialogClickListener;

    public void setOnDialogClickListener(OnDialogClickListener l) {
        onDialogClickListener = l;
    }

    public interface OnDialogClickListener {
        void onCamera();

        void onAlbum();

        void onQuitLogin(View view);
    }

    @Override
    public void show() {
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        dialog.getWindow().setAttributes(lp);
        super.show();
    }

}
