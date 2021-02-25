package com.sanju.recyclerviewdiffutildemosk;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil.Callback;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context context;
    List<Employee> employeeList ;

    public ImageAdapter(Context context, List<Employee> employeeList ) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_single_row, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Log.d("Item Check Position", "onBindViewHolder: "+position);
        Employee employee  = employeeList.get(position);
        holder.textView1.setText(employee.getId()+". ");
        holder.textView2.setText(employee.getName());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public void updateSimpleList(List<Employee> employeeList){
        List<Employee> employeeList1 = new ArrayList<>();
        employeeList1.addAll(employeeList);
        this.employeeList.clear();
        this.employeeList.addAll(employeeList1);
        notifyDataSetChanged();
    }

    public void diffUtilChangeData(List<Employee> employeeList){
       // List<Employee> employeeList1 = new ArrayList<>();
       // employeeList1.addAll(employeeList);
        EmpDiffUtil diffUtil = new EmpDiffUtil(this.employeeList,employeeList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtil);

        this.employeeList.clear();
        this.employeeList.addAll(employeeList);
        diffResult.dispatchUpdatesTo(this);
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;

        public ImageViewHolder(View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
        }
    }
}
