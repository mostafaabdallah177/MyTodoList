package com.andorid.mytodolist
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_dialog_.*
import java.io.Serializable

class Dialog_Fragment() : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_dialog_,
                container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var task:Task= this.arguments!!.getSerializable("Key") as Task
        titlefragment.setText(task.titleTask)
        descfragment.setText(task.DescripitonTask)

    }

}