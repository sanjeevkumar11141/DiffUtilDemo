package com.sanju.recyclerviewdiffutildemosk;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class EmpDiffUtil extends DiffUtil.Callback {
    List<Employee> oldEmployeeList;
    List<Employee> newEmployeeList;

    public EmpDiffUtil(List<Employee> employeeList, List<Employee> employeeList1) {
        this.oldEmployeeList = employeeList;
        this.newEmployeeList = employeeList1;
    }

    @Override
    public int getOldListSize() {
        return oldEmployeeList.size();
    }

    @Override
    public int getNewListSize() {
        return newEmployeeList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldEmployeeList.get(oldItemPosition).getId().equals(newEmployeeList.get(newItemPosition).getId());
        //return false;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldEmployeeList.get(oldItemPosition).getName().equals(newEmployeeList.get(newItemPosition).getName());
        //return false;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
