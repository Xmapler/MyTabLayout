package tabl.xhf.asus.mytablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButtActivity extends AppCompatActivity {

    @BindView(R.id.bt_click)
    Button bt_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butt);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.bt_click)
    public void onClick() {
        startActivity(new Intent(ButtActivity.this,MainActivity.class));
    }
}
