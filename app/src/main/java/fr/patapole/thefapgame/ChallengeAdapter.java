package fr.patapole.thefapgame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ChallengeAdapter extends ArrayAdapter<Challenge> implements Filterable{

    private Context mContext;
    public List<Challenge> challengeList;

    public ChallengeAdapter(@NonNull Context context, List<Challenge> list){
        super(context, 0, list);
        mContext = context;
        challengeList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

        final Challenge current = challengeList.get(position);

        ImageView image = (ImageView)listItem.findViewById(R.id.img);
        image.setImageResource(current.getIcon());

        TextView name = (TextView) listItem.findViewById(R.id.name);
        name.setText(current.getName());

        TextView desc = (TextView) listItem.findViewById(R.id.desc);
        desc.setText(current.getDesc());

        CheckBox done = (CheckBox) listItem.findViewById(R.id.done);
        done.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                    current.setDone(isChecked);

                }
            }
        );
        done.setChecked(current.isDone());
        return listItem;
    }

    @Override
    public int getCount() {
        return challengeList.size();
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,FilterResults results) {

                challengeList = (List<Challenge>) results.values; // has the filtered values
                notifyDataSetChanged();  // notifies the data with new filtered values
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                List<Challenge> FilteredArrList = new ArrayList<>();

                if (constraint == null || constraint.length() == 0) {

                    // set the Original result to return
                    results.count = Challenge.challenges.size();
                    results.values = Challenge.challenges;
                } else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < Challenge.challenges.size(); i++) {
                        Challenge data = Challenge.challenges.get(i);
                        /*if (data.getName().toLowerCase().startsWith(constraint.toString())) {
                            FilteredArrList.add(data);
                        }*/
                        StringBuilder sb = new StringBuilder();
                        sb.append(data.getName().toUpperCase());
                        sb.append(data.getDesc().toUpperCase());
                        if (sb.toString().contains(constraint.toString().toUpperCase())){
                            FilteredArrList.add(data);
                        }
                    }
                    // set the Filtered result to return
                    results.count = FilteredArrList.size();
                    results.values = FilteredArrList;
                }
                return results;
            }
        };
        return filter;
    }

}
