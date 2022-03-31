package com.example.tourist;

import static com.example.tourist.VillageUtils.searchString;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class VillageMyAdapter extends RecyclerView.Adapter<VillageMyAdapter.ViewHolder>{

    private Context c;
    private int mBackground;
    private int[] mMaterialColors;
    public List<Villagegetset> villagegetsets;

    interface ItemClickListener {
        void onItemClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements
     View.OnClickListener {
        private final TextView name, popular,pincode;
        private ImageView img;
        private final MaterialLetterIcon mIcon;
        private ItemClickListener itemClickListener;

        ViewHolder(View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.mMaterialLetterIcon);
            name = itemView.findViewById(R.id.name);

            popular = itemView.findViewById(R.id.popular);
            pincode = itemView.findViewById(R.id.pincode);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }

        void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }
    }

    public VillageMyAdapter(List<Villagegetset> villagegetsets) {
        this.villagegetsets = villagegetsets;

    }
    private void prepareLetterIcons(Context c){
        TypedValue mTypedValue = new TypedValue();
        c.getTheme().resolveAttribute(R.attr.selectableItemBackground,
                mTypedValue, true);
        mMaterialColors = c.getResources().getIntArray(R.array.colors);
        mBackground = mTypedValue.resourceId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.c = parent.getContext();
        prepareLetterIcons(c);
        View view = LayoutInflater.from(c).inflate(R.layout.model, parent, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get current scientist
        final Villagegetset s = villagegetsets.get(position);

        //bind data to widgets
        holder.name.setText(s.getVillage_name());
        holder.popular.setText(s.getDistrict());
        holder.pincode.setText(s.getArea_pincode());
//        Picasso.get()
//                .load(s.getImageURL())
//                .placeholder(R.drawable.ic_launcher_background)
//                .fit()
//                .centerCrop()
//                .into(holder.img);
        holder.mIcon.setInitials(true);
        holder.mIcon.setInitialsNumber(2);
        holder.mIcon.setLetterSize(25);
        holder.mIcon.setShapeColor(mMaterialColors[new Random().nextInt(
            mMaterialColors.length)]);
        holder.mIcon.setLetter(s.getVillage_name());

        if(position % 2 == 0){
            holder.itemView.setBackgroundColor(Color.parseColor("#efefef"));
        }

        //get name and galaxy
        String name = s.getVillage_name().toLowerCase(Locale.getDefault());

        //highlight name text while searching
        if (name.contains(searchString) && !(searchString.isEmpty())) {
            int startPos = name.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.name.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.name.setText(spanString);
        } else {
            //VillageUtils.show(ctx, "Search string empty");
        }

        //open detailactivity when clicked
        holder.setItemClickListener(pos -> VillageUtils.sendScientistToActivity(c, s,
         VillageDetailActivity.class));
    }

    @Override
    public int getItemCount() {
        return villagegetsets.size();
    }

}
//end