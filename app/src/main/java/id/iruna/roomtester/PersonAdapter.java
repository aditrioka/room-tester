package id.iruna.roomtester;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.iruna.roomtester.vo.Person;

/**
 * Created by aditrioka on 21/02/18.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private List<Person> people;

    public PersonAdapter(List<Person> people) {
        this.people = people;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        Person person = people.get(position);
        holder.tvAge.setText(person.getAge());
        holder.tvHobby.setText(person.getHobby());
        holder.tvName.setText(person.getName());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvHobby;
        private TextView tvAge;

        public PersonViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvHobby = (TextView) itemView.findViewById(R.id.tv_hobby);
            tvAge = (TextView) itemView.findViewById(R.id.tv_age);
        }
    }
}
