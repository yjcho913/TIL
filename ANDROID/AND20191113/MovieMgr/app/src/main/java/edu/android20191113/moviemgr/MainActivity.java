package edu.android20191113.moviemgr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView movieLv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieLv = findViewById(R.id.movieLv);
        MovieAdapter<Movie> movieA = new MovieAdapter<Movie>(R.layout.raw_layout, getAllInfo());

        movieLv.setAdapter(movieA);
    }

    class MovieAdapter<M> extends BaseAdapter{

        private int layout;
        private ArrayList<Movie> movList;
        private LayoutInflater layoutinf;

        public MovieAdapter(int rowLayout, ArrayList<Movie> movList){
            this.layout = rowLayout;
            this.movList = movList;
//            layoutinf = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            // 보여줄 데이터의 크기 반환 (데이터가 몇개 있는지.. 리스트의 크기와 연관)
            return movList.size();
        }

        @Override
        public Object getItem(int position) {
            // 해당 position의 객체 반환
            return movList.get(position);
        }

        @Override
        public long getItemId(int position) {
            // position 반환
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder;

            if(convertView == null) {
//              View view = layoutinf.inflate(R.layout.raw_layout, null);
                convertView = View.inflate(MainActivity.this, R.layout.raw_layout, null);
                viewHolder = new ViewHolder();
                viewHolder.mTv = convertView.findViewById(R.id.mTitleV);
                viewHolder.mConTv = convertView.findViewById(R.id.mContentV);
                viewHolder.mimageV = convertView.findViewById(R.id.mImageV);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            Movie selMovie = (Movie) getItem(position);
            viewHolder.mTv.setText(selMovie.getmTitle());
            viewHolder.mConTv.setText(selMovie.getmContent());
            viewHolder.mimageV.setImageResource(selMovie.getmImage());

            return convertView;
        }
    }

    public ArrayList<Movie> getAllInfo(){
        ArrayList<Movie> tempL = new ArrayList<>();
        tempL.add(new Movie("조커","코미디언 지망생이 어쩌구 저쩌구...",R.drawable.joker));
        tempL.add(new Movie("엑시트","빌딩을 타는 이야기",R.drawable.exit));
        tempL.add(new Movie("해리포터","마법사가 되는 이야기",R.drawable.harrypotter));
        tempL.add(new Movie("미스슬로운","법 바꾸는 이야기",R.drawable.sloane));
        tempL.add(new Movie("인셉션","꿈 탐험 이야기",R.drawable.inception));
        tempL.add(new Movie("조커","코미디언 지망생이 어쩌구 저쩌구...",R.drawable.joker));
        tempL.add(new Movie("엑시트","빌딩을 타는 이야기",R.drawable.exit));
        tempL.add(new Movie("해리포터","마법사가 되는 이야기",R.drawable.harrypotter));
        tempL.add(new Movie("미스슬로운","법 바꾸는 이야기",R.drawable.sloane));
        tempL.add(new Movie("인셉션","꿈 탐험 이야기",R.drawable.inception));
        tempL.add(new Movie("조커","코미디언 지망생이 어쩌구 저쩌구...",R.drawable.joker));
        tempL.add(new Movie("엑시트","빌딩을 타는 이야기",R.drawable.exit));
        tempL.add(new Movie("해리포터","마법사가 되는 이야기",R.drawable.harrypotter));
        tempL.add(new Movie("미스슬로운","법 바꾸는 이야기",R.drawable.sloane));
        tempL.add(new Movie("인셉션","꿈 탐험 이야기",R.drawable.inception));
        return tempL;
    }

    class ViewHolder{
        TextView mTv;
        TextView mConTv;
        ImageView mimageV;
    }
}
