package in.unicodelabs.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by saurabh on 3/3/18.
 */

public class KdLoadingView extends ImageView {
    private int mDuration = 1000; //init with default value
    private Animation mAnim;
    private int tintColor = Color.BLACK;
    private boolean isAnimRunning= false;

    public KdLoadingView(Context context) {
        super(context);
        init(null);
    }

    public KdLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public KdLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        setImageDrawable(getResources().getDrawable(R.drawable.ic_process_round));

        if (attributeSet != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.KdLoadingView, 0, 0);
            try {
                mDuration = a.getInt(R.styleable.KdLoadingView_anim_duration, 1000);

                int animReference = a.getResourceId(R.styleable.KdLoadingView_animation, R.anim.rotate);

                mAnim = AnimationUtils.loadAnimation(getContext(), animReference);

                tintColor = a.getColor(R.styleable.KdLoadingView_tint, Color.BLACK);
                setColorFilter(tintColor);
            } finally {
                a.recycle();
            }
        }

        start();
    }

    public void toggle() {
        if (isAnimRunning) {
            stop();
        } else {
            start();
        }
    }

    public void start() {
        if(isAnimRunning || mAnim == null)
            return;
        mAnim.setDuration(mDuration);
        setVisibility(View.VISIBLE);
        startAnimation(mAnim);
        isAnimRunning = true;
    }

    public void stop() {
        if(!isAnimRunning || mAnim == null)
            return;
        clearAnimation();
        setVisibility(View.GONE);
        isAnimRunning =false;
    }

}
