package assignment.ketan.com.assignmentketan.view.activities.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import assignment.ketan.com.assignmentketan.R;
import assignment.ketan.com.assignmentketan.model.dto.assignment_result.Location;
import assignment.ketan.com.assignmentketan.model.dto.assignment_result.Results;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {


    private Context mContext;
    private ArrayList<Results> mSelectedList;

    public ItemAdapter(Context mContext, ArrayList<Results> mList) {

        this.mContext = mContext;
        this.mSelectedList = mList;


    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_profile, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final Results mItem = mSelectedList.get(position);
        holder.tv_address.setText("From:- " + ((Location) mItem.getLocation()).getCity() + ", " + ((Location) mItem.getLocation()).getState());
        holder.tv_age.setText("" + mItem.getDob().getAge());
        holder.tv_email.setText("" + mItem.getEmail());
        holder.tv_phone.setText("" + mItem.getCell());
        holder.tv_name.setText(mItem.getName().getFirst() + " " + mItem.getName().getFirst() + " " + mItem.getName().getLast());
        Glide.with(mContext).load(mItem.getPicture().getLarge()).apply(new RequestOptions().placeholder(R.drawable.user_icon_profile)).into(holder.iv_user);

    }

    @Override
    public int getItemCount() {
        return mSelectedList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_address, tv_name, tv_age, tv_email, tv_phone;

        private ImageView iv_user;

        public MyViewHolder(View view) {
            super(view);
            tv_address = (TextView) view.findViewById(R.id.tv_address);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_age = (TextView) view.findViewById(R.id.tv_age);
            tv_email = (TextView) view.findViewById(R.id.tv_email);
            tv_phone = (TextView) view.findViewById(R.id.tv_phone);
            iv_user = (ImageView) view.findViewById(R.id.iv_seller_profile);

        }
    }
}
