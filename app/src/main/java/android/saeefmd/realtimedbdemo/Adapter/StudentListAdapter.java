package android.saeefmd.realtimedbdemo.Adapter;

import android.saeefmd.realtimedbdemo.Data.Student;
import android.saeefmd.realtimedbdemo.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StudentListAdapter extends RecyclerView.Adapter {

    private List<Student> list;

    public StudentListAdapter(List<Student> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_students, viewGroup, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        Student data = list.get(i);

        ((MyViewHolder)viewHolder).stName.setText(data.getName());
        ((MyViewHolder)viewHolder).stMobile.setText(data.getMobile());
        ((MyViewHolder)viewHolder).stAddress.setText(data.getAddress());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView stName;
        TextView stMobile;
        TextView stAddress;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            stName = itemView.findViewById(R.id.list_student_name_tv);
            stMobile = itemView.findViewById(R.id.list_student_mobile_tv);
            stAddress = itemView.findViewById(R.id.list_student_address_tv);
        }
    }
}
