package com.hunter.dribbble.ui.profile.followers;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hunter.dribbble.R;
import com.hunter.dribbble.entity.FollowerEntity;
import com.hunter.dribbble.entity.UserEntity;
import com.hunter.dribbble.utils.glide.GlideUtils;
import com.hunter.lib.base.BaseAdapter;
import com.hunter.lib.base.BaseViewHolder;

import java.util.List;

public class FollowersAdapter extends BaseAdapter<FollowerEntity> {

    public FollowersAdapter(Context context, List<FollowerEntity> data) {
        super(context, data, R.layout.item_profile_followers);
    }

    @Override
    protected void onBindItemData(BaseViewHolder holder, int position) {
        UserEntity entity = mData.get(position).getFollower();

        ImageView ivAvatar = holder.getView(R.id.iv_item_follower_avatar);
        GlideUtils.setAvatar(mContext, entity.getAvatarUrl(), ivAvatar);
        holder.setTvText(R.id.tv_item_follower_user_name, entity.getUsername());
        holder.setTvText(R.id.tv_item_follower_shots, entity.getShotsCount() + " 作品");

        TextView tvLocation = holder.getView(R.id.tv_item_follower_location);
        String location = entity.getLocation();
        if (TextUtils.isEmpty(location)) {
            tvLocation.setVisibility(View.GONE);
        } else {
            tvLocation.setVisibility(View.VISIBLE);
            tvLocation.setText(location);
        }
    }
}