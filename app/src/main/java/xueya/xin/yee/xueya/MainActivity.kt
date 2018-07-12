package xueya.xin.yee.xueya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import xueya.xin.yee.xueya.request.RequestApi

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onSupportNavigateUp() =
            findNavController(this, R.id.my_nav_host_fragment)
                    .navigateUp()

}
